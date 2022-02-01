package com.tencent.smtt.utils;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils
{
  private static OutputStream a = null;
  
  public static void closeOutputStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      Log.e("LOG_FILE", "Couldn't close stream!", paramOutputStream);
    }
  }
  
  public static byte[] createHeaderText(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      paramString2 = String.format("%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      return arrayOfByte;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static String createKey()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  public static byte[] encrypt(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      Log.e("LOG_FILE", "encrypt exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  public static byte[] encryptKey(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      Log.e("LOG_FILE", "encrypt exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  /* Error */
  public static void writeDataToStorage(java.io.File paramFile, String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_1
    //   7: aload_3
    //   8: invokestatic 125	com/tencent/smtt/utils/LogFileUtils:encrypt	(Ljava/lang/String;Ljava/lang/String;)[B
    //   11: astore 5
    //   13: aload 6
    //   15: astore_1
    //   16: aload 5
    //   18: ifnull +8 -> 26
    //   21: aconst_null
    //   22: astore_3
    //   23: aload 5
    //   25: astore_1
    //   26: aload_0
    //   27: invokevirtual 131	java/io/File:getParentFile	()Ljava/io/File;
    //   30: invokevirtual 135	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: aload_0
    //   35: invokevirtual 138	java/io/File:isFile	()Z
    //   38: ifeq +31 -> 69
    //   41: aload_0
    //   42: invokevirtual 141	java/io/File:exists	()Z
    //   45: ifeq +24 -> 69
    //   48: aload_0
    //   49: invokevirtual 144	java/io/File:length	()J
    //   52: ldc2_w 145
    //   55: lcmp
    //   56: ifle +13 -> 69
    //   59: aload_0
    //   60: invokevirtual 149	java/io/File:delete	()Z
    //   63: pop
    //   64: aload_0
    //   65: invokevirtual 152	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   72: ifnonnull +23 -> 95
    //   75: new 154	java/io/BufferedOutputStream
    //   78: dup
    //   79: new 156	java/io/FileOutputStream
    //   82: dup
    //   83: aload_0
    //   84: iload 4
    //   86: invokespecial 159	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   89: invokespecial 161	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   92: putstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   95: aload_3
    //   96: ifnull +31 -> 127
    //   99: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   102: aload_3
    //   103: invokevirtual 164	java/lang/String:getBytes	()[B
    //   106: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   109: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   112: astore_0
    //   113: aload_0
    //   114: ifnull +9 -> 123
    //   117: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   120: invokevirtual 171	java/io/OutputStream:flush	()V
    //   123: ldc 2
    //   125: monitorexit
    //   126: return
    //   127: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   130: aload_2
    //   131: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   134: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   137: aload_1
    //   138: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   141: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   144: iconst_2
    //   145: newarray byte
    //   147: dup
    //   148: iconst_0
    //   149: ldc 172
    //   151: bastore
    //   152: dup
    //   153: iconst_1
    //   154: ldc 172
    //   156: bastore
    //   157: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   160: goto -51 -> 109
    //   163: astore_0
    //   164: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull -46 -> 123
    //   172: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   175: invokevirtual 171	java/io/OutputStream:flush	()V
    //   178: goto -55 -> 123
    //   181: astore_0
    //   182: goto -59 -> 123
    //   185: astore_0
    //   186: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   189: astore_1
    //   190: aload_1
    //   191: ifnull +9 -> 200
    //   194: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   197: invokevirtual 171	java/io/OutputStream:flush	()V
    //   200: aload_0
    //   201: athrow
    //   202: astore_0
    //   203: ldc 2
    //   205: monitorexit
    //   206: aload_0
    //   207: athrow
    //   208: astore_1
    //   209: goto -9 -> 200
    //   212: astore_0
    //   213: goto -90 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramFile	java.io.File
    //   0	216	1	paramString1	String
    //   0	216	2	paramArrayOfByte	byte[]
    //   0	216	3	paramString2	String
    //   0	216	4	paramBoolean	boolean
    //   11	13	5	arrayOfByte	byte[]
    //   1	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	69	163	java/lang/Throwable
    //   69	95	163	java/lang/Throwable
    //   99	109	163	java/lang/Throwable
    //   127	160	163	java/lang/Throwable
    //   172	178	181	java/lang/Throwable
    //   26	69	185	finally
    //   69	95	185	finally
    //   99	109	185	finally
    //   127	160	185	finally
    //   6	13	202	finally
    //   109	113	202	finally
    //   117	123	202	finally
    //   164	168	202	finally
    //   172	178	202	finally
    //   186	190	202	finally
    //   194	200	202	finally
    //   200	202	202	finally
    //   194	200	208	java/lang/Throwable
    //   117	123	212	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.LogFileUtils
 * JD-Core Version:    0.7.0.1
 */