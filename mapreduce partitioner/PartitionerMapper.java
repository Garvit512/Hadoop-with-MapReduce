package partitionerDemo;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class PartitionerMapper extends Mapper<LongWritable, Text, Text, DoubleWritable>{
	
	// 111, Akshay, Noida, 30000
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String s1 = value.toString().replaceAll(" ", "");
		String arr[] = s1.split(",");
		
		String empname = arr[1];
		String loc = arr[2];
		Double sal = Double.parseDouble(arr[3]);
		
		Text location = new Text(loc);
		DoubleWritable salary = new DoubleWritable(sal);
		
		context.write(location, salary);	
	}

}
