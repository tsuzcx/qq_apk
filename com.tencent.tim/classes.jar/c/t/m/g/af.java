package c.t.m.g;

import android.util.Base64;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
public final class af
{
  private static byte[] a = null;
  private static HashMap<String, String> b;
  
  static
  {
    a();
  }
  
  public static final String a(String paramString)
  {
    try
    {
      String str = (String)b.get(paramString);
      paramString = str;
      if (ai.c(str)) {
        paramString = "";
      }
      return paramString;
    }
    finally {}
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 1);
  }
  
  private static String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    if ((paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("wrong mode.");
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      paramString1 = "";
      return paramString1;
    }
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        paramString1 = paramString1.getBytes();
        if (paramString1 == null) {
          break label124;
        }
        if (paramString1.length == 0)
        {
          break label124;
          if (paramInt == 2) {
            paramString1 = Base64.decode(paramString1.getBytes(), 2);
          }
        }
        else
        {
          paramString2 = a(paramString1, paramString1.length, paramString2, paramInt);
          if (paramInt == 1) {
            return Base64.encodeToString(paramString2, 2);
          }
          paramString1 = localObject;
          if (paramInt != 2) {
            break;
          }
          paramString1 = new String(paramString2);
          return paramString1;
        }
      }
      catch (Throwable paramString1)
      {
        return "";
      }
      paramString1 = null;
    }
    label124:
    return "";
  }
  
  private static final void a()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        b = new HashMap();
        String[] arrayOfString1 = new String(ai.a(new byte[] { 8, 16, 116, 91, -113, -11, 70, -62, -45, -36, 8, 119, -121, 51, 54, -122, 72, 12, -109, -53, 78, 13, -80, -118, -43, -111, 85, -110, 87, 62, 10, 92, -46, 53, -86, -78, 75, -122, 108, -53, 30, 123, -122, -114, 65, 78, 27, -15, 63, -58, -22, 26, -19, -87, -65, -34, -76, 3, -26, -75, 53, 115, -22, -113, 102, 43, -52, 74, 39, -117, 39, -63, -116, 4, -99, 109, 1, 53, -127, -75, 74, 12, -88, 77, -37, 53, 1, 89, 73, -95, -103, -33, -91, 1, -22, 66, 105, 3, 12, 111, -83, 85, -57, -89, -43, -94, 99, -117, 2, -81, 67, -2, 111, -128, -124, 79, -111, 86, -83, -106, 92, -87, 17, -85, 119, -15, -116, -68, 121, 1, 6, 92, 40, -12, -22, 60, 31, -73, -6, 31, -28, -8, -14, -125, -63, -33, -85, -12, 7, 23, 109, 122, -110, 113, -103, 15, -101, 64, 67, 115, 3, -85, 73, 102, 59, -61, -16, 112, 53, 123, 118, -19, -61, 63, -102, 101, -40, -118, 49, -127, 14, -109, -30, -123, 41, -117, -14, 59, 10, -56, 78, 121, -77, 55, -84, -40, -34, -69, -94, 52, 53, 94, -49, 48, -10, 82, 18, -7, 56, -126, -70, -94, 59, 118, 25, 0, -11, -26, 7, -126, 72, -93, -66, -6, 62, 124, 74, 109, 18, 61, -57, 98, 67, 95, 25, -53, -25, 65, 127, -5, -74, 30, -99, -1, 87, -104, 54, -61, 37, 107, 12, 106, 67, 21, 17, -100, 113, -35, -43, -62, -11, -52, -116, -97, -44, -125, 28, -67, 67, 72, -45, -84, -82, 102, -118, 80, -9, -87, 6, 30, -100, 36, -122, 6, 71, -91, 21, 96, -53, -79, -82, 76, 91, -101, 84, -4, 87, -15, -48, -38, -81, 10, 42, -11, 17, 117, -39, -119, 90, -51, 67, -87, 55, -69, 48, -92, 116, 34, 118, -56, 4, 95, -106, -3, 23, -9, 81, -69, -58, -57, 26, -87, 119, 62, -87, 69, -8, -58, -77, -57, 8, -89, 15, 77, 64, -15, -110, 80, -13, 70, 96, -41, 73, -2, -66, 43, 107, 103, 44, -81, -17, -41, -48, -91, 60, 25, -76, -109 }, 368), "UTF-8").split(";");
        if (i < arrayOfString1.length)
        {
          String[] arrayOfString2 = arrayOfString1[i].split(",");
          if (arrayOfString2.length != 2) {
            break label2589;
          }
          b.put(arrayOfString2[0], arrayOfString2[1]);
          break label2589;
        }
        a = ((String)b.get("enc_iv")).getBytes("UTF-8");
      }
      catch (Throwable localThrowable)
      {
        ai.a("EncAesCbcUtil", "init error.", localThrowable);
        continue;
      }
      finally {}
      return;
      label2589:
      i += 1;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt2 != 1) && (paramInt2 != 2)) {
      throw new IllegalArgumentException("wrong mode.");
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramInt1 == 0)) {
      return ab.a;
    }
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(paramInt2, paramString, new IvParameterSpec(a));
      if (localCipher == null) {
        return ab.a;
      }
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte, 0, paramInt1);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return ab.a;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length, paramString, 1);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.af
 * JD-Core Version:    0.7.0.1
 */