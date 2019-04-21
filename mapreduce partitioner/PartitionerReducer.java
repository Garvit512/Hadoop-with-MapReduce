package partitionerDemo;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PartitionerReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable>
{
	Double sum=0.0;
	
	public void reduce(Text key, Iterable<DoubleWritable> value, Context context) throws IOException, InterruptedException
	{
		for (DoubleWritable doubleWritable : value)
		{
			sum = sum+ Double.parseDouble(doubleWritable.toString());
			
		}
		
		DoubleWritable summ = new DoubleWritable(sum);
		
		context.write(key, summ);
		
	}

}
