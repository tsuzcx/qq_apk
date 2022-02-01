package moai.io;

import com.tencent.moai.database.sqlite.SQLiteBlob;
import java.io.IOException;
import java.io.OutputStream;

public class SQLiteBlobOutputStream
  extends OutputStream
{
  private final SQLiteBlob blob;
  private int writeOffset;
  
  public SQLiteBlobOutputStream(SQLiteBlob paramSQLiteBlob)
  {
    this.blob = paramSQLiteBlob;
  }
  
  public void close()
  {
    this.blob.free();
  }
  
  public int getBlobSize()
  {
    return this.writeOffset;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.blob.write(paramInt);
    this.writeOffset += 1;
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.blob.write(paramArrayOfByte, paramInt1, paramInt2);
    this.writeOffset += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.SQLiteBlobOutputStream
 * JD-Core Version:    0.7.0.1
 */