package alphabetCount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class alphabetDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Configuration conf = new Configuration();
		
		Job job = new Job(conf);
		
		job.setJarByClass(alphabetDriver.class);
		job.setMapperClass(alphabetMapper.class);
		job.setReducerClass(alphabetReducer.class);
	
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Text.class);
	
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		FileSystem fs = FileSystem.get(conf);
		fs.delete(new Path(args[1]));
		
		System.exit(job.waitForCompletion(true) ? 0:1);
	}

}
