package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

final class LogHelper
{
  private static final SimpleDateFormat aa = new SimpleDateFormat("MM-dd HH:mm:ss SSS");
  private static final byte[] ab = { 4, 0, 0, 0, -1, -1, -1, 0 };
  
  public static void initLogHeader(PrintStream paramPrintStream, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if ((paramPrintStream == null) || (Util.isNullOrNil(paramString2)) || (paramLong == 0L)) {
      return;
    }
    paramPrintStream.println("1 " + paramString1);
    paramPrintStream.println("2 " + paramString2);
    paramPrintStream.println("3 " + paramLong);
    paramPrintStream.println("4 " + Integer.toHexString(paramInt));
    paramPrintStream.println("5 " + Build.VERSION.RELEASE);
    paramPrintStream.println("6 " + Build.VERSION.CODENAME);
    paramPrintStream.println("7 " + Build.VERSION.INCREMENTAL);
    paramPrintStream.println("8 " + Build.BOARD);
    paramPrintStream.println("9 " + Build.DEVICE);
    paramPrintStream.println("10 " + Build.DISPLAY);
    paramPrintStream.println("11 " + Build.FINGERPRINT);
    paramPrintStream.println("12 " + Build.HOST);
    paramPrintStream.println("13 " + Build.MANUFACTURER);
    paramPrintStream.println("14 " + Build.MODEL);
    paramPrintStream.println("15 " + Build.PRODUCT);
    paramPrintStream.println("16 " + Build.TAGS);
    paramPrintStream.println("17 " + Build.TYPE);
    paramPrintStream.println("18 " + Build.USER);
    paramPrintStream.println();
    paramPrintStream.flush();
  }
  
  /* Error */
  public static void writeToStream(PrintStream paramPrintStream, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +24 -> 25
    //   4: aload_1
    //   5: invokestatic 156	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   8: ifne +17 -> 25
    //   11: aload_2
    //   12: invokestatic 36	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   15: ifne +10 -> 25
    //   18: aload_3
    //   19: invokestatic 36	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   22: ifeq +4 -> 26
    //   25: return
    //   26: aload_0
    //   27: monitorenter
    //   28: new 158	java/lang/StringBuffer
    //   31: dup
    //   32: invokespecial 159	java/lang/StringBuffer:<init>	()V
    //   35: astore 4
    //   37: aload 4
    //   39: getstatic 20	com/tencent/mm/sdk/platformtools/LogHelper:aa	Ljava/text/SimpleDateFormat;
    //   42: invokestatic 165	java/lang/System:currentTimeMillis	()J
    //   45: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: invokevirtual 175	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   54: pop
    //   55: aload 4
    //   57: ldc 180
    //   59: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   62: aload_2
    //   63: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   66: ldc 180
    //   68: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   71: aload_3
    //   72: invokevirtual 178	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   75: pop
    //   76: aload 4
    //   78: invokevirtual 181	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   81: astore_2
    //   82: new 183	javax/crypto/spec/DESKeySpec
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 186	javax/crypto/spec/DESKeySpec:<init>	([B)V
    //   90: astore_1
    //   91: ldc 188
    //   93: invokestatic 194	javax/crypto/SecretKeyFactory:getInstance	(Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;
    //   96: aload_1
    //   97: invokevirtual 198	javax/crypto/SecretKeyFactory:generateSecret	(Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;
    //   100: astore_1
    //   101: ldc 188
    //   103: invokestatic 203	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   106: astore_3
    //   107: aload_3
    //   108: iconst_1
    //   109: aload_1
    //   110: invokevirtual 207	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   113: aload_3
    //   114: aload_2
    //   115: invokevirtual 213	java/lang/String:getBytes	()[B
    //   118: invokevirtual 217	javax/crypto/Cipher:doFinal	([B)[B
    //   121: astore_1
    //   122: aload_0
    //   123: aload_1
    //   124: arraylength
    //   125: invokestatic 223	com/tencent/mm/algorithm/TypeTransform:intToByteArrayLH	(I)[B
    //   128: invokevirtual 226	java/io/PrintStream:write	([B)V
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 226	java/io/PrintStream:write	([B)V
    //   136: aload_0
    //   137: getstatic 25	com/tencent/mm/sdk/platformtools/LogHelper:ab	[B
    //   140: invokevirtual 226	java/io/PrintStream:write	([B)V
    //   143: aload_0
    //   144: invokevirtual 149	java/io/PrintStream:flush	()V
    //   147: aload_0
    //   148: monitorexit
    //   149: return
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   160: goto -17 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramPrintStream	PrintStream
    //   0	163	1	paramArrayOfByte	byte[]
    //   0	163	2	paramString1	String
    //   0	163	3	paramString2	String
    //   35	42	4	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   28	82	150	finally
    //   82	143	150	finally
    //   143	149	150	finally
    //   156	160	150	finally
    //   82	143	155	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LogHelper
 * JD-Core Version:    0.7.0.1
 */