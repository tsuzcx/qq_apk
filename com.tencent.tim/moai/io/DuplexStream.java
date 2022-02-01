package moai.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by ayangxu.
 */
public class DuplexStream extends FilterInputStream {
    private final OutputStream out;
    private final boolean autoClosedInput;
    public DuplexStream(InputStream in, OutputStream out, boolean autoCloseInput) {
        super(in);
        this.out = out;
        this.autoClosedInput = autoCloseInput;
    }

    @Override
    public void close() throws IOException {
        if (autoClosedInput) {
            super.close();
        }
        out.close();
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    /**
     * Reads a single byte from the filtered stream and returns it as an integer
     * in the range from 0 to 255. Returns -1 if the end of this stream has been
     * reached.
     *
     * @return the byte read or -1 if the end of the filtered stream has been
     *         reached.
     * @throws IOException
     *             if the stream is closed or another IOException occurs.
     */
    @Override
    public int read() throws IOException {
        int ret = in.read();
        out.write(ret);
        return ret;
    }

    @Override public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int ret = in.read(buffer, byteOffset, byteCount);
        out.write(buffer, byteOffset, byteCount);
        return ret;
    }

    @Override
    public synchronized void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public long skip(long byteCount) throws IOException {
        throw new UnsupportedOperationException();
    }
}
