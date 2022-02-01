package moai.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import moai.core.utilities.Indexes;

/**
 * Created by ayangxu.
 */
public class HaffmanEncodeOutputStream extends FilterOutputStream {
    private final ByteBuffer oneIntBuffer = ByteBuffer.allocate(8);
    private int count;

    public HaffmanEncodeOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int oneByte) throws IOException {
        Indexes.encodeOneInt(oneByte, oneIntBuffer);
        out.write(oneIntBuffer.array(), 0, oneIntBuffer.limit());
        count += oneIntBuffer.limit();
    }

    public void write(int[] arr, int start, int length) throws IOException {
        length += start;
        while (start < length) write(arr[start++]);
    }

    public void write(int[] arr) throws IOException {
        write(arr, 0, arr.length);
    }

    public int getCount() {
        return count;
    }
}
