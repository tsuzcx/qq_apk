import android.util.Base64;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;

public class ahwx
{
  static final String DEFAULT_KEY = 'W' + 't' + 'R' + 'x' + 'K' + 'b' + 'L' + 'k';
  
  public static String bd(String paramString1, String paramString2)
    throws XorCipherException
  {
    if (paramString1 == null) {
      throw new XorCipherException("null input");
    }
    try
    {
      paramString1 = new String(Base64.encode(k(paramString1.getBytes(), paramString2.getBytes()), 0));
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      throw new XorCipherException(paramString1);
    }
  }
  
  public static String be(String paramString1, String paramString2)
    throws XorCipherException
  {
    if (paramString1 == null) {
      throw new XorCipherException("null input");
    }
    try
    {
      paramString1 = new String(k(Base64.decode(paramString1, 0), paramString2.getBytes()));
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      throw new XorCipherException(paramString1);
    }
  }
  
  public static String decrypt(String paramString)
    throws XorCipherException
  {
    return be(paramString, DEFAULT_KEY);
  }
  
  public static String encrypt(String paramString)
    throws XorCipherException
  {
    return bd(paramString, DEFAULT_KEY);
  }
  
  private static byte[] k(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(i % paramArrayOfByte2.length)]));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwx
 * JD-Core Version:    0.7.0.1
 */