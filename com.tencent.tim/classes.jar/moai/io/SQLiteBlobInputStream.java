package moai.io;

import android.support.annotation.NonNull;
import com.tencent.moai.database.sqlite.SQLiteBlob;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class SQLiteBlobInputStream
  extends InputStream
{
  private final SQLiteBlob blob;
  
  public SQLiteBlobInputStream(SQLiteBlob paramSQLiteBlob)
  {
    this.blob = paramSQLiteBlob;
  }
  
  public void close()
  {
    this.blob.free();
  }
  
  public long getBlobSize()
  {
    try
    {
      long l = this.blob.length();
      return l;
    }
    catch (SQLException localSQLException) {}
    return 0L;
  }
  
  public int read()
    throws IOException
  {
    throw new UnsupportedOperationException("read single byte is unsupported.");
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.blob.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.SQLiteBlobInputStream
 * JD-Core Version:    0.7.0.1
 */