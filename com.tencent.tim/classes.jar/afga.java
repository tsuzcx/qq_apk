import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class afga
  extends RandomAccessFile
{
  private final byte[] scratch = new byte[8];
  
  public afga(String paramString1, String paramString2)
    throws FileNotFoundException
  {
    super(new File(paramString1), paramString2);
  }
  
  public int read()
    throws IOException
  {
    int i = -1;
    if (read(this.scratch, 0, 1) != -1) {
      i = this.scratch[0] & 0xFF;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    long l = super.getFilePointer();
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > -1) {
      afgc.a(paramArrayOfByte, paramInt1, paramInt2, l);
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afga
 * JD-Core Version:    0.7.0.1
 */