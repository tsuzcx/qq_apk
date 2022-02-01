import com.tencent.common.app.BaseApplicationImpl;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class npu
{
  public static volatile npw a = new npw(BaseApplicationImpl.getContext(), "proteus");
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return copy(paramInputStream, paramOutputStream, 8024);
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    for (long l = 0L;; l += paramInt)
    {
      paramInt = paramInputStream.read(arrayOfByte);
      if (-1 == paramInt) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, paramInt);
    }
    return l;
  }
  
  public static boolean h(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if (!paramFile.exists()) {
      try
      {
        boolean bool = paramFile.mkdirs();
        return bool;
      }
      finally {}
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npu
 * JD-Core Version:    0.7.0.1
 */