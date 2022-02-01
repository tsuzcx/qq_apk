import java.io.IOException;
import java.io.InputStream;

public class ajxq
{
  public static byte[] readBytes(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    Object localObject;
    if (paramInt <= 0) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      int i = 0;
      byte[] arrayOfByte = new byte[paramInt];
      localObject = arrayOfByte;
      if (i >= paramInt) {
        continue;
      }
      try
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        localObject = arrayOfByte;
        if (j <= 0) {
          continue;
        }
        i += j;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxq
 * JD-Core Version:    0.7.0.1
 */