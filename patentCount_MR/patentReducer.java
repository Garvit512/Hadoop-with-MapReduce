package patentCount;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class patentReducer extends Reducer<IntWritable, FloatWritable, IntWritable, IntWritable>
{
	public void reduce(IntWritable key, Iterable<FloatWritable> value, Context context) throws IOException, InterruptedException
	{
		int counter=0;
				
	for (FloatWritable floatWritable : value)
	{
		counter = counter+1;
	}
		context.write(key, new IntWritable(counter));
	}

}
