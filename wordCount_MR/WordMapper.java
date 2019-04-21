package wordCount;



import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
//import org.apache.hadoop.mapreduce.Reducer;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
  {
	  String str = value.toString();
	  String arr[] = str.split(" ");
	  
	  for (String x : arr)
	  {
		  Text word = new Text(x);
		  IntWritable one = new IntWritable(1);
		  context.write(word, one);
		
		 
	  }
  }
	
	

}
