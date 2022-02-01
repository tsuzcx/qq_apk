package com.tencent.tbs.logger.file;

import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption
{
  public static final String DEFAULT_TEXT_ENCODING = "UTF-8";
  public static final String LOG_ENCRYPTION_ALGORITHM = "RC4";
  
  public static String createKeyOfPlainText()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  private static byte[] encryptKey(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private static byte[] encryptPlainText(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] getEncryptedKeyBytes(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      if (paramString1 == null) {
        return null;
      }
      paramString2 = String.format(Locale.US, "%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      return arrayOfByte;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static byte[] getEncryptedLogBytes(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: invokestatic 93	com/tencent/tbs/logger/file/Encryption:encryptPlainText	(Ljava/lang/String;Ljava/lang/String;)[B
    //   8: astore 5
    //   10: aload 5
    //   12: ifnull +77 -> 89
    //   15: aload_2
    //   16: arraylength
    //   17: aload 5
    //   19: arraylength
    //   20: iadd
    //   21: iconst_2
    //   22: iadd
    //   23: newarray byte
    //   25: astore_0
    //   26: aload_2
    //   27: iconst_0
    //   28: aload_0
    //   29: iconst_0
    //   30: aload_2
    //   31: arraylength
    //   32: invokestatic 89	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   35: aload_2
    //   36: arraylength
    //   37: iconst_0
    //   38: iadd
    //   39: istore_3
    //   40: aload 5
    //   42: iconst_0
    //   43: aload_0
    //   44: iload_3
    //   45: aload 5
    //   47: arraylength
    //   48: invokestatic 89	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   51: aload 5
    //   53: arraylength
    //   54: istore 4
    //   56: iconst_2
    //   57: newarray byte
    //   59: astore_1
    //   60: aload_1
    //   61: dup
    //   62: iconst_0
    //   63: ldc 94
    //   65: bastore
    //   66: dup
    //   67: iconst_1
    //   68: ldc 94
    //   70: bastore
    //   71: pop
    //   72: aload_1
    //   73: iconst_0
    //   74: aload_0
    //   75: iload 4
    //   77: iload_3
    //   78: iadd
    //   79: aload_1
    //   80: arraylength
    //   81: invokestatic 89	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: areturn
    //   89: aload_1
    //   90: invokevirtual 97	java/lang/String:getBytes	()[B
    //   93: astore_0
    //   94: goto -10 -> 84
    //   97: astore_0
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_0
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramString1	String
    //   0	103	1	paramString2	String
    //   0	103	2	paramArrayOfByte	byte[]
    //   39	40	3	i	int
    //   54	25	4	j	int
    //   8	44	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	10	97	finally
    //   15	84	97	finally
    //   89	94	97	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.Encryption
 * JD-Core Version:    0.7.0.1
 */