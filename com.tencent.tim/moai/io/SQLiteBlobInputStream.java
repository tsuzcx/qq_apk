package moai.io;

import android.support.annotation.NonNull;

import com.tencent.moai.database.sqlite.SQLiteBlob;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by ayangxu.
 */
public class SQLiteBlobInputStream extends InputStream {
    private final SQLiteBlob blob;

    public SQLiteBlobInputStream(SQLiteBlob blob) {
        this.blob = blob;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException("read single byte is unsupported.");
    }

    @Override
    public int read(@NonNull byte[] buffer) throws IOException {
        return read(buffer, 0, buffer.length);
    }

    @Override
    public int read(@NonNull byte[] buffer, int offset, int count) throws IOException {
        return blob.read(buffer, offset, count);
    }

    @Override
    public void close() {
        blob.free();
    }

    public long getBlobSize() {
        try {
            return blob.length();
        } catch (SQLException e) {

        }
        return 0;
    }
}
