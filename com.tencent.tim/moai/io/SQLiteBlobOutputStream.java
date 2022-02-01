package moai.io;

import com.tencent.moai.database.sqlite.SQLiteBlob;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ayangxu.
 */
public class SQLiteBlobOutputStream extends OutputStream {
    private final SQLiteBlob blob;
    private int writeOffset;

    public SQLiteBlobOutputStream(SQLiteBlob blob) {
        this.blob = blob;
    }

    @Override
    public void write(int b) throws IOException {
        blob.write(b);
        writeOffset++;
    }

    @Override
    public void write(byte[] buffer) throws IOException {
        write(buffer, 0, buffer.length);
    }

    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        blob.write(buffer, offset, count);
        this.writeOffset += count;
    }

    public int getBlobSize() {
        return writeOffset;
    }

    @Override
    public void close() {
        blob.free();
    }
}
