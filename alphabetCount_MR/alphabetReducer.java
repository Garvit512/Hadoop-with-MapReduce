package alphabetCount;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class alphabetReducer extends Reducer<IntWritable, Text, IntWritable, IntWritable> {

	public void reduce(IntWritable key, Iterable<Text> value, Context context) throws IOException, InterruptedException {
		int count = 0;
		for (Text txText : value) {
			count = count + 1;
		}
		context.write(key, new IntWritable(count));
	}

}
