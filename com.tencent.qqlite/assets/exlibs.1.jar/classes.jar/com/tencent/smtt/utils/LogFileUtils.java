package com.tencent.smtt.utils;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils
{
  private static final String LOG_TAG = "LOG_FILE";
  private static final int MAX_SIZE = 2097152;
  private static OutputStream outputStream = null;
  private static final String private_key = "%$%&*)f4";
  
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
  
  public static byte[] encrypt(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec("%$%&*)f4".getBytes("UTF-8"), "RC4"));
      paramString = localCipher.update(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("LOG_FILE", "encrypt exception:" + paramString.getMessage());
    }
    return null;
  }
  
  /* Error */
  public static void writeDataToStorage(java.io.File paramFile, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_1
    //   9: invokestatic 96	com/tencent/smtt/utils/LogFileUtils:encrypt	(Ljava/lang/String;)[B
    //   12: astore 5
    //   14: aload 5
    //   16: ifnull +104 -> 120
    //   19: aload 5
    //   21: astore_1
    //   22: aload_0
    //   23: invokevirtual 102	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 106	java/io/File:mkdirs	()Z
    //   29: pop
    //   30: aload_0
    //   31: invokevirtual 109	java/io/File:isFile	()Z
    //   34: ifeq +31 -> 65
    //   37: aload_0
    //   38: invokevirtual 112	java/io/File:exists	()Z
    //   41: ifeq +24 -> 65
    //   44: aload_0
    //   45: invokevirtual 116	java/io/File:length	()J
    //   48: ldc2_w 117
    //   51: lcmp
    //   52: ifle +13 -> 65
    //   55: aload_0
    //   56: invokevirtual 121	java/io/File:delete	()Z
    //   59: pop
    //   60: aload_0
    //   61: invokevirtual 124	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   68: ifnonnull +22 -> 90
    //   71: new 126	java/io/BufferedOutputStream
    //   74: dup
    //   75: new 128	java/io/FileOutputStream
    //   78: dup
    //   79: aload_0
    //   80: iload_2
    //   81: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   84: invokespecial 133	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   87: putstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   90: aload_3
    //   91: ifnull +37 -> 128
    //   94: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   97: aload_3
    //   98: invokevirtual 136	java/lang/String:getBytes	()[B
    //   101: invokevirtual 140	java/io/OutputStream:write	([B)V
    //   104: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   107: ifnull +9 -> 116
    //   110: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   113: invokevirtual 143	java/io/OutputStream:flush	()V
    //   116: ldc 2
    //   118: monitorexit
    //   119: return
    //   120: aload_1
    //   121: astore_3
    //   122: aload 4
    //   124: astore_1
    //   125: goto -103 -> 22
    //   128: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   131: aload_1
    //   132: invokevirtual 140	java/io/OutputStream:write	([B)V
    //   135: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   138: iconst_2
    //   139: newarray byte
    //   141: dup
    //   142: iconst_0
    //   143: ldc 144
    //   145: bastore
    //   146: dup
    //   147: iconst_1
    //   148: ldc 144
    //   150: bastore
    //   151: invokevirtual 140	java/io/OutputStream:write	([B)V
    //   154: goto -50 -> 104
    //   157: astore_1
    //   158: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   161: ifnull +9 -> 170
    //   164: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   167: invokevirtual 143	java/io/OutputStream:flush	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: ldc 8
    //   175: new 75	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   182: ldc 146
    //   184: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: invokevirtual 149	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   191: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 151
    //   196: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: iload_2
    //   200: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   203: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: aload_1
    //   207: invokestatic 41	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   210: pop
    //   211: goto -95 -> 116
    //   214: astore_0
    //   215: ldc 2
    //   217: monitorexit
    //   218: aload_0
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramFile	java.io.File
    //   0	220	1	paramString	String
    //   0	220	2	paramBoolean	boolean
    //   7	115	3	str	String
    //   4	119	4	localObject	Object
    //   12	8	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	65	157	finally
    //   65	90	157	finally
    //   94	104	157	finally
    //   128	154	157	finally
    //   104	116	172	java/lang/Throwable
    //   158	170	172	java/lang/Throwable
    //   170	172	172	java/lang/Throwable
    //   8	14	214	finally
    //   104	116	214	finally
    //   158	170	214	finally
    //   170	172	214	finally
    //   173	211	214	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.LogFileUtils
 * JD-Core Version:    0.7.0.1
 */