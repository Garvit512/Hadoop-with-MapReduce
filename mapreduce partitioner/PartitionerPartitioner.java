package partitionerDemo;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class PartitionerPartitioner extends Partitioner<Text, DoubleWritable>
{

	public int getPartition(Text key, DoubleWritable value, int NR)
	{
		String s = key.toString().toLowerCase().trim();
		
		if(s.equals("hapur"))
			return 0;	
		
		if(s.equals("noida"))
			return 0;
		
		if(s.equals("mumbai"))
			return 1;
		
		if(s.equals("pune"))
			return 1;
		
		if(s.equals("chennai"))
			return 2;
		
		if(s.equals("bangalore"))
			return 2;
		
		else 
			return 2;
	}

}

