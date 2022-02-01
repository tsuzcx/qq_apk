import android.util.SparseArray;
import com.tencent.smtt.utils.ByteUtils;
import java.nio.ByteBuffer;

public class ioh
{
  public static SparseArray<iog> a(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    SparseArray localSparseArray = new SparseArray();
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      short s = a(localByteBuffer, j);
      j += 2;
      int i = b(localByteBuffer, j);
      j += 2;
      byte[] arrayOfByte = c(paramArrayOfByte, j, i);
      j += i;
      localSparseArray.put(s, new iog(s, i, arrayOfByte));
    }
    return localSparseArray;
  }
  
  private static short a(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getShort(paramInt);
  }
  
  public static byte[] a(iog paramiog)
  {
    if (paramiog != null)
    {
      short s1 = paramiog.getTag();
      short s2 = paramiog.getLength();
      paramiog = paramiog.getValue();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(s2 + 4);
      localByteBuffer.putShort(s1);
      localByteBuffer.putShort(s2);
      localByteBuffer.put(paramiog);
      return localByteBuffer.array();
    }
    return null;
  }
  
  private static short b(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getShort(paramInt);
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return ByteUtils.subByte(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioh
 * JD-Core Version:    0.7.0.1
 */