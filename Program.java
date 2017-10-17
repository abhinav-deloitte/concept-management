import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.sql.*;


class Update {
	Integer value;
	Integer time;
}

class Example {
	String resource;
	Update data;
}


public class Program {
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/tarun";

	   static final String USER = "root";
	   static final String PASS = "FOOTBALLo1!";
	public static void main(String args[])
	{
		
		
		Comparator<Update> comparator = new TimeComparator();
		PriorityQueue<Update> queue = new PriorityQueue<Update>(10, comparator);
		ConcurrentHashMap<String,PriorityQueue> map = new ConcurrentHashMap<String,PriorityQueue>();
		HashMap<String,Integer> datastore=new HashMap<String,Integer>();
		Example example1=new Example();
		Example example2=new Example();
		Update update1=new Update();
		Update update2=new Update();
		
		Scanner in=new Scanner(System.in);
		
		example1.data=update1;
		example2.data=update2;
		example1.resource = in.next();
		example2.resource = in.next();
		example1.data.value = in.nextInt();
		example2.data.value = in.nextInt();
		example1.data.time = in.nextInt();
		example2.data.time = in.nextInt();
		in.close();
		if(map.containsKey(example1.resource))
		{
			queue=map.get(example1.resource);
			queue.add(example1.data);
			map.put(example1.resource, queue);
		}
		else
		{
			queue = new PriorityQueue<Update>(10, comparator);
			queue.add(example1.data);
			map.put(example1.resource, queue);
		}
		if(map.containsKey(example2.resource))
		{
			queue=map.get(example2.resource);
			queue.add(example2.data);
			map.put(example2.resource, queue);
		}
		else
		{
			queue = new PriorityQueue<Update>(10, comparator);
			queue.add(example2.data);
			map.put(example2.resource, queue);
		}
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Connecting to database...");
		for (ConcurrentHashMap.Entry<String, PriorityQueue> entry : map.entrySet())
		{
		    final String b=entry.getKey();
		    final PriorityQueue queue1=entry.getValue();
		    while(queue1.peek()!=null)
		    {
		    	final Update t=(Update)queue1.remove(); 
		    	Thread t1=new Thread(new Runnable(){
		    		public void run(){
		    			synchronized(queue1){
		    		        datastore.put(b,t.value);

		    			}
		    		}
		    	});
		    	t1.start();
		    }
		}	       
		}catch(Exception e){e.printStackTrace();}
		for(Map.Entry<String, Integer> entry1 : datastore.entrySet())
		{
		  	try{
			String sql = "insert into data values(?,?) on duplicate key update amount=?";
		  	final Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		  	final PreparedStatement stmt = conn.prepareStatement(sql);
	        
	    	System.out.println("hello");
	        stmt.setString(1, entry1.getKey());  
	        stmt.setInt(2, entry1.getValue());
	        stmt.setInt(3, entry1.getValue());
	        stmt.executeUpdate();
		
			System.out.println(entry1.getKey()+" and the value is "+entry1.getValue());
		  	}catch(Exception e){e.printStackTrace();}
		}
		System.out.println("Done");
		
	}
}



class TimeComparator implements Comparator<Update>
{
 @Override
 public int compare(Update x, Update y)
 {
     if (x.time < y.time)
     {
         return -1;
     }
     if (x.time > y.time)
     {
         return 1;
     }
     return 0;
 }
}