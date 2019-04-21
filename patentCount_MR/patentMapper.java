package patentCount;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class patentMapper extends Mapper<LongWritable, Text, IntWritable, FloatWritable>
{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		
		String s = value.toString();
		
		String arr[]  = s.split(" ");
		
		String s1 = arr[0];
		String s2 = arr[1];
		
		Integer kk = new Integer(s1);
		Float vv = new Float(s2);
		
		context.write(new IntWritable(kk), new FloatWritable(vv));
	}
}
