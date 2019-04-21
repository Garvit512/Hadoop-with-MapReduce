package maxTemp;

import java.io.IOException;
import java.sql.Struct;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTempMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable>
{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		
		String s = value.toString();
		String arr[] = s.split(" ");
		
		String s1  = arr[0];
		String s2 = arr[1];
		
		int kk = Integer.parseInt(s1);
		int vv = Integer.parseInt(s2);
		
		context.write(new IntWritable(kk), new IntWritable(vv));
		
	}

}
