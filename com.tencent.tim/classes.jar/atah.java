import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class atah
{
  private static int a(ByteBuffer paramByteBuffer)
  {
    c(paramByteBuffer);
    int j = paramByteBuffer.capacity();
    if (j < 22) {}
    for (;;)
    {
      return -1;
      int k = Math.min(j - 22, 65535);
      int i = 0;
      while (i < k)
      {
        int m = j - 22 - i;
        if ((paramByteBuffer.getInt(m) == 101010256) && (b(paramByteBuffer, m + 20) == i)) {
          return m;
        }
        i += 1;
      }
    }
  }
  
  private static long a(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getInt(paramInt) & 0xFFFFFFFF;
  }
  
  private static Pair<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile, int paramInt)
    throws IOException
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("maxCommentSize: " + paramInt);
    }
    long l = paramRandomAccessFile.length();
    if (l < 22L) {}
    ByteBuffer localByteBuffer;
    do
    {
      return null;
      localByteBuffer = ByteBuffer.allocate((int)Math.min(paramInt, l - 22L) + 22);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      l -= localByteBuffer.capacity();
      paramRandomAccessFile.seek(l);
      paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
      paramInt = a(localByteBuffer);
    } while (paramInt == -1);
    localByteBuffer.position(paramInt);
    paramRandomAccessFile = localByteBuffer.slice();
    paramRandomAccessFile.order(ByteOrder.LITTLE_ENDIAN);
    return Pair.create(paramRandomAccessFile, Long.valueOf(l + paramInt));
  }
  
  private static void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    if ((paramLong < 0L) || (paramLong > 4294967295L)) {
      throw new IllegalArgumentException("uint32 value of out range: " + paramLong);
    }
    paramByteBuffer.putInt(paramByteBuffer.position() + paramInt, (int)paramLong);
  }
  
  private static int b(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getShort(paramInt) & 0xFFFF;
  }
  
  public static Pair<ByteBuffer, Long> b(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    Object localObject;
    if (paramRandomAccessFile.length() < 22L) {
      localObject = null;
    }
    Pair localPair;
    do
    {
      return localObject;
      localPair = a(paramRandomAccessFile, 0);
      localObject = localPair;
    } while (localPair != null);
    return a(paramRandomAccessFile, 65535);
  }
  
  public static final boolean b(RandomAccessFile paramRandomAccessFile, long paramLong)
    throws IOException
  {
    paramLong -= 20L;
    if (paramLong < 0L) {}
    do
    {
      return false;
      paramRandomAccessFile.seek(paramLong);
    } while (paramRandomAccessFile.readInt() != 1347094023);
    return true;
  }
  
  public static long c(ByteBuffer paramByteBuffer)
  {
    c(paramByteBuffer);
    return a(paramByteBuffer, paramByteBuffer.position() + 16);
  }
  
  private static void c(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
      throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
  }
  
  public static long d(ByteBuffer paramByteBuffer)
  {
    c(paramByteBuffer);
    return a(paramByteBuffer, paramByteBuffer.position() + 12);
  }
  
  static void d(ByteBuffer paramByteBuffer, long paramLong)
  {
    c(paramByteBuffer);
    a(paramByteBuffer, paramByteBuffer.position() + 16, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atah
 * JD-Core Version:    0.7.0.1
 */