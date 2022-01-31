package com.weiyun.sdk.util;

import com.weiyun.sdk.job.BaseJob;
import com.weiyun.sdk.log.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashSumCalc
{
  private static final String TAG = "HashSumCalc";
  private static final char[] sHexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  private static String getHash(String paramString1, String paramString2, BaseJob paramBaseJob)
    throws NoSuchAlgorithmException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: new 44	java/io/BufferedInputStream
    //   12: dup
    //   13: new 46	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 52	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 6
    //   26: sipush 8192
    //   29: newarray byte
    //   31: astore 5
    //   33: aload_1
    //   34: invokestatic 58	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   37: astore_1
    //   38: aload 6
    //   40: aload 5
    //   42: invokevirtual 64	java/io/InputStream:read	([B)I
    //   45: istore_3
    //   46: iload_3
    //   47: ifgt +23 -> 70
    //   50: aload_1
    //   51: invokevirtual 68	java/security/MessageDigest:digest	()[B
    //   54: invokestatic 72	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   57: astore_1
    //   58: aload 6
    //   60: ifnull +8 -> 68
    //   63: aload 6
    //   65: invokevirtual 75	java/io/InputStream:close	()V
    //   68: aload_1
    //   69: areturn
    //   70: aload_1
    //   71: aload 5
    //   73: iconst_0
    //   74: iload_3
    //   75: invokevirtual 79	java/security/MessageDigest:update	([BII)V
    //   78: aload_2
    //   79: invokevirtual 85	com/weiyun/sdk/job/BaseJob:isAlive	()Z
    //   82: istore 4
    //   84: iload 4
    //   86: ifne -48 -> 38
    //   89: aload 6
    //   91: ifnull +8 -> 99
    //   94: aload 6
    //   96: invokevirtual 75	java/io/InputStream:close	()V
    //   99: ldc 87
    //   101: areturn
    //   102: astore_0
    //   103: ldc 8
    //   105: aload_0
    //   106: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   109: invokestatic 97	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: goto -13 -> 99
    //   115: astore_0
    //   116: ldc 8
    //   118: aload_0
    //   119: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   122: invokestatic 97	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: goto -57 -> 68
    //   128: astore_2
    //   129: aload 7
    //   131: astore_1
    //   132: aload_1
    //   133: astore 5
    //   135: ldc 8
    //   137: new 99	java/lang/StringBuilder
    //   140: dup
    //   141: ldc 101
    //   143: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 108
    //   152: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_2
    //   156: invokevirtual 109	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 115	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 75	java/io/InputStream:close	()V
    //   176: ldc 87
    //   178: areturn
    //   179: astore_0
    //   180: ldc 8
    //   182: aload_0
    //   183: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   186: invokestatic 97	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -13 -> 176
    //   192: astore_2
    //   193: aload 8
    //   195: astore_1
    //   196: aload_1
    //   197: astore 5
    //   199: ldc 8
    //   201: new 99	java/lang/StringBuilder
    //   204: dup
    //   205: ldc 101
    //   207: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: aload_0
    //   211: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 108
    //   216: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_2
    //   220: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   223: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 115	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_1
    //   233: ifnull +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 75	java/io/InputStream:close	()V
    //   240: ldc 87
    //   242: areturn
    //   243: astore_0
    //   244: ldc 8
    //   246: aload_0
    //   247: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   250: invokestatic 97	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: goto -13 -> 240
    //   256: astore_0
    //   257: aload 5
    //   259: ifnull +8 -> 267
    //   262: aload 5
    //   264: invokevirtual 75	java/io/InputStream:close	()V
    //   267: aload_0
    //   268: athrow
    //   269: astore_1
    //   270: ldc 8
    //   272: aload_1
    //   273: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   276: invokestatic 97	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: goto -12 -> 267
    //   282: astore_0
    //   283: aload 6
    //   285: astore 5
    //   287: goto -30 -> 257
    //   290: astore_2
    //   291: aload 6
    //   293: astore_1
    //   294: goto -98 -> 196
    //   297: astore_2
    //   298: aload 6
    //   300: astore_1
    //   301: goto -169 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString1	String
    //   0	304	1	paramString2	String
    //   0	304	2	paramBaseJob	BaseJob
    //   45	30	3	i	int
    //   82	3	4	bool	boolean
    //   4	282	5	localObject1	Object
    //   24	275	6	localBufferedInputStream	java.io.BufferedInputStream
    //   7	123	7	localObject2	Object
    //   1	193	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   94	99	102	java/io/IOException
    //   63	68	115	java/io/IOException
    //   9	26	128	java/io/FileNotFoundException
    //   172	176	179	java/io/IOException
    //   9	26	192	java/io/IOException
    //   236	240	243	java/io/IOException
    //   9	26	256	finally
    //   135	168	256	finally
    //   199	232	256	finally
    //   262	267	269	java/io/IOException
    //   26	38	282	finally
    //   38	46	282	finally
    //   50	58	282	finally
    //   70	84	282	finally
    //   26	38	290	java/io/IOException
    //   38	46	290	java/io/IOException
    //   50	58	290	java/io/IOException
    //   70	84	290	java/io/IOException
    //   26	38	297	java/io/FileNotFoundException
    //   38	46	297	java/io/FileNotFoundException
    //   50	58	297	java/io/FileNotFoundException
    //   70	84	297	java/io/FileNotFoundException
  }
  
  public static String getMD5Hash(String paramString, BaseJob paramBaseJob)
  {
    try
    {
      paramBaseJob = getHash(paramString, "MD5", paramBaseJob);
      return paramBaseJob;
    }
    catch (NoSuchAlgorithmException paramBaseJob)
    {
      Log.e("HashSumCalc", "getHash() for file: " + paramString + " failed:" + paramBaseJob.getMessage());
    }
    return "";
  }
  
  public static String getSHA1Hash(String paramString, BaseJob paramBaseJob)
  {
    try
    {
      paramBaseJob = getHash(paramString, "SHA", paramBaseJob);
      return paramBaseJob;
    }
    catch (NoSuchAlgorithmException paramBaseJob)
    {
      Log.e("HashSumCalc", "getHash() for file: " + paramString + " failed:" + paramBaseJob.getMessage());
    }
    return "";
  }
  
  public static String getStringHash(String paramString1, String paramString2)
    throws NoSuchAlgorithmException
  {
    paramString1 = paramString1.getBytes();
    paramString2 = MessageDigest.getInstance(paramString2);
    paramString2.update(paramString1, 0, paramString1.length);
    return toHexString(paramString2.digest());
  }
  
  public static String getStringHashSafely(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = getStringHash(paramString1, paramString2);
      return paramString2;
    }
    catch (NoSuchAlgorithmException paramString2)
    {
      Log.e("HashSumCalc", "", paramString2);
    }
    return String.valueOf(paramString1.hashCode());
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(sHexChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(sHexChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.util.HashSumCalc
 * JD-Core Version:    0.7.0.1
 */