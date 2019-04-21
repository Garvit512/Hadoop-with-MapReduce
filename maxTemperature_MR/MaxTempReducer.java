package maxTemp;

import java.io.IOException;
import java.util.Iterator;
import java.util.ListIterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTempReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable>
{
	public void reduce(IntWritable key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException
	{
	  
	  int max=0;
	 
	  /*
	  for (IntWritable intWritable : value)
	  {
		  Iterator<IntWritable> itr = value.iterator());  
		  while(itr.hasNext())
		  {
			  temp = (itr.next()-one).get();
			  if(temp > max_tmp)
			  {
				  max_tmp = temp;
			  }
		  }
		*/
	  Iterator<IntWritable> itr = value.iterator();  
	  while (itr.hasNext())
	  {
		int  temp = itr.next().get(); 
		if(max>temp)
		{
			max = temp;
		
	    }
		  context.write(key, new IntWritable(max));
	  }
		
	}
}









