import android.annotation.SuppressLint;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class ijf
{
  private static ijf a = new ijf();
  
  public static ijf.a a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = paramArrayOfByte[0];
    j = paramArrayOfByte[(i - 1)];
    Object localObject = new byte[4];
    byte[] arrayOfByte = new byte[4];
    QLog.d("AudioTrans runhw", 2, "rspBodyBytes = " + i(paramArrayOfByte));
    System.arraycopy(paramArrayOfByte, 1, localObject, 0, 4);
    System.arraycopy(paramArrayOfByte, 5, arrayOfByte, 0, 4);
    j = byteArrayToInt((byte[])localObject);
    int k = byteArrayToInt(arrayOfByte);
    QLog.d("AudioTrans runhw", 2, "rspBytesLen = " + i + ", lengthOfHead = " + j + ", lengthOfBody = " + k);
    localObject = new ijf.a(j, k);
    System.arraycopy(paramArrayOfByte, 9, ((ijf.a)localObject).head, 0, j);
    System.arraycopy(paramArrayOfByte, j + 9, ((ijf.a)localObject).body, 0, k);
    return localObject;
  }
  
  public static ijf a()
  {
    return a;
  }
  
  @SuppressLint({"DefaultLocale"})
  public static String aH(int paramInt)
  {
    return String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(paramInt >> 24 & 0xFF), Integer.valueOf(paramInt >> 16 & 0xFF), Integer.valueOf(paramInt >> 8 & 0xFF), Integer.valueOf(paramInt & 0xFF) });
  }
  
  private static int byteArrayToInt(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  public static byte[] g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    int j = paramArrayOfByte2.length;
    byte[] arrayOfByte1 = ByteBuffer.allocate(4).putInt(i).array();
    byte[] arrayOfByte2 = ByteBuffer.allocate(4).putInt(j).array();
    byte[] arrayOfByte3 = new byte[i + 9 + j + 1];
    arrayOfByte3[0] = 40;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 1, 4);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 5, 4);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte3, 9, i);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte3, i + 9, j);
    arrayOfByte3[(arrayOfByte3.length - 1)] = 41;
    return arrayOfByte3;
  }
  
  public static String i(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    char[] arrayOfChar1 = "0123456789ABCDEF".toCharArray();
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4)];
      arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static class a
  {
    public byte[] body;
    public byte[] head;
    
    public a(int paramInt1, int paramInt2)
    {
      this.head = new byte[paramInt1];
      this.body = new byte[paramInt2];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijf
 * JD-Core Version:    0.7.0.1
 */