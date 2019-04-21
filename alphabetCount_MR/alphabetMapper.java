package alphabetCount;


import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class alphabetMapper extends Mapper<LongWritable, Text, IntWritable, Text>
{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String s1 = value.toString();
		String s2 = s1.replaceAll("[0-9\\,\\.\\?\\#]", "");
		String arr[] = s2.split(" ");
		
		for (String s : arr)
		{
			Text word = new Text(s);
			int i = s.length();
			IntWritable wordCount = new IntWritable(i);
			
			context.write(wordCount, word);

		}
		
	}
	
	

}
