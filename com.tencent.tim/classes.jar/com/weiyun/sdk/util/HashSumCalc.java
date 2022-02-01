package com.weiyun.sdk.util;

import com.weiyun.sdk.job.BaseJob;
import com.weiyun.sdk.log.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class HashSumCalc
{
  public static final String MD5_HASH_TYPE = "MD5";
  public static final String SHA_HASH_TYPE = "SHA";
  private static final String TAG = "HashSumCalc";
  private static final char[] sHexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  private static String getHash(String paramString1, String paramString2, BaseJob paramBaseJob)
    throws NoSuchAlgorithmException
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray byte
    //   5: astore 5
    //   7: aload_1
    //   8: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   11: astore 6
    //   13: new 56	java/io/BufferedInputStream
    //   16: dup
    //   17: new 58	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore 4
    //   30: aload 4
    //   32: astore_1
    //   33: aload 4
    //   35: aload 5
    //   37: invokevirtual 70	java/io/InputStream:read	([B)I
    //   40: istore_3
    //   41: iload_3
    //   42: ifle +57 -> 99
    //   45: aload 4
    //   47: astore_1
    //   48: aload 6
    //   50: aload 5
    //   52: iconst_0
    //   53: iload_3
    //   54: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   57: aload 4
    //   59: astore_1
    //   60: aload_2
    //   61: invokevirtual 80	com/weiyun/sdk/job/BaseJob:isAlive	()Z
    //   64: ifne -34 -> 30
    //   67: ldc 82
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: aload 4
    //   74: ifnull +10 -> 84
    //   77: aload 4
    //   79: invokevirtual 85	java/io/InputStream:close	()V
    //   82: aload_1
    //   83: astore_0
    //   84: aload_0
    //   85: areturn
    //   86: astore_0
    //   87: ldc 14
    //   89: aload_0
    //   90: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   93: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 82
    //   98: areturn
    //   99: aload 4
    //   101: astore_1
    //   102: aload 6
    //   104: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   107: invokestatic 103	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: aload_1
    //   114: astore_0
    //   115: aload 4
    //   117: ifnull -33 -> 84
    //   120: aload 4
    //   122: invokevirtual 85	java/io/InputStream:close	()V
    //   125: aload_1
    //   126: areturn
    //   127: astore_0
    //   128: ldc 14
    //   130: aload_0
    //   131: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   134: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_1
    //   138: areturn
    //   139: astore_2
    //   140: aconst_null
    //   141: astore 4
    //   143: aload 4
    //   145: astore_1
    //   146: ldc 14
    //   148: new 105	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   155: ldc 108
    //   157: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 114
    //   166: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_2
    //   170: invokevirtual 115	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: ldc 82
    //   184: astore_0
    //   185: aload 4
    //   187: ifnull -103 -> 84
    //   190: aload 4
    //   192: invokevirtual 85	java/io/InputStream:close	()V
    //   195: ldc 82
    //   197: areturn
    //   198: astore_0
    //   199: ldc 14
    //   201: aload_0
    //   202: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   205: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: ldc 82
    //   210: areturn
    //   211: astore_2
    //   212: aconst_null
    //   213: astore 4
    //   215: aload 4
    //   217: astore_1
    //   218: ldc 14
    //   220: new 105	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   227: ldc 108
    //   229: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_0
    //   233: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc 114
    //   238: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_2
    //   242: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   245: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: ldc 82
    //   256: astore_0
    //   257: aload 4
    //   259: ifnull -175 -> 84
    //   262: aload 4
    //   264: invokevirtual 85	java/io/InputStream:close	()V
    //   267: ldc 82
    //   269: areturn
    //   270: astore_0
    //   271: ldc 14
    //   273: aload_0
    //   274: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   277: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: ldc 82
    //   282: areturn
    //   283: astore_0
    //   284: aconst_null
    //   285: astore_1
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 85	java/io/InputStream:close	()V
    //   294: aload_0
    //   295: athrow
    //   296: astore_1
    //   297: ldc 14
    //   299: aload_1
    //   300: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   303: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: goto -12 -> 294
    //   309: astore_0
    //   310: goto -24 -> 286
    //   313: astore_2
    //   314: goto -99 -> 215
    //   317: astore_2
    //   318: goto -175 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramString1	String
    //   0	321	1	paramString2	String
    //   0	321	2	paramBaseJob	BaseJob
    //   40	14	3	i	int
    //   28	235	4	localBufferedInputStream	java.io.BufferedInputStream
    //   5	46	5	arrayOfByte	byte[]
    //   11	92	6	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   77	82	86	java/io/IOException
    //   120	125	127	java/io/IOException
    //   0	30	139	java/io/FileNotFoundException
    //   190	195	198	java/io/IOException
    //   0	30	211	java/io/IOException
    //   262	267	270	java/io/IOException
    //   0	30	283	finally
    //   290	294	296	java/io/IOException
    //   33	41	309	finally
    //   48	57	309	finally
    //   60	67	309	finally
    //   102	111	309	finally
    //   146	182	309	finally
    //   218	254	309	finally
    //   33	41	313	java/io/IOException
    //   48	57	313	java/io/IOException
    //   60	67	313	java/io/IOException
    //   102	111	313	java/io/IOException
    //   33	41	317	java/io/FileNotFoundException
    //   48	57	317	java/io/FileNotFoundException
    //   60	67	317	java/io/FileNotFoundException
    //   102	111	317	java/io/FileNotFoundException
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
  
  public static HashMap<String, String> getMd5AndShaHash(String paramString, BaseJob paramBaseJob)
  {
    try
    {
      paramString = getMd5AndShaHash(paramString, "MD5", "SHA", paramBaseJob);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
  
  /* Error */
  private static HashMap<String, String> getMd5AndShaHash(String paramString1, String paramString2, String paramString3, BaseJob paramBaseJob)
    throws NoSuchAlgorithmException
  {
    // Byte code:
    //   0: new 56	java/io/BufferedInputStream
    //   3: dup
    //   4: new 58	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 7
    //   17: aload 7
    //   19: astore 6
    //   21: sipush 8192
    //   24: newarray byte
    //   26: astore 10
    //   28: aload 7
    //   30: astore 6
    //   32: aload_1
    //   33: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   36: astore 8
    //   38: aload 7
    //   40: astore 6
    //   42: aload_2
    //   43: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   46: astore 9
    //   48: aload 7
    //   50: astore 6
    //   52: aload 7
    //   54: aload 10
    //   56: invokevirtual 70	java/io/InputStream:read	([B)I
    //   59: istore 4
    //   61: iload 4
    //   63: ifle +70 -> 133
    //   66: aload 7
    //   68: astore 6
    //   70: aload 8
    //   72: aload 10
    //   74: iconst_0
    //   75: iload 4
    //   77: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   80: aload 7
    //   82: astore 6
    //   84: aload 9
    //   86: aload 10
    //   88: iconst_0
    //   89: iload 4
    //   91: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   94: aload 7
    //   96: astore 6
    //   98: aload_3
    //   99: invokevirtual 80	com/weiyun/sdk/job/BaseJob:isAlive	()Z
    //   102: istore 5
    //   104: iload 5
    //   106: ifne -58 -> 48
    //   109: aload 7
    //   111: ifnull +8 -> 119
    //   114: aload 7
    //   116: invokevirtual 85	java/io/InputStream:close	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_0
    //   122: ldc 14
    //   124: aload_0
    //   125: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   128: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aconst_null
    //   132: areturn
    //   133: aload 7
    //   135: astore 6
    //   137: new 138	java/util/HashMap
    //   140: dup
    //   141: iconst_2
    //   142: invokespecial 141	java/util/HashMap:<init>	(I)V
    //   145: astore_3
    //   146: aload 7
    //   148: astore 6
    //   150: aload_3
    //   151: aload_1
    //   152: aload 8
    //   154: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   157: invokestatic 103	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   160: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload 7
    //   166: astore 6
    //   168: aload_3
    //   169: aload_2
    //   170: aload 9
    //   172: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   175: invokestatic 103	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   178: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   181: pop
    //   182: aload 7
    //   184: ifnull +8 -> 192
    //   187: aload 7
    //   189: invokevirtual 85	java/io/InputStream:close	()V
    //   192: aload_3
    //   193: areturn
    //   194: astore_0
    //   195: ldc 14
    //   197: aload_0
    //   198: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   201: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: goto -12 -> 192
    //   207: astore_1
    //   208: aconst_null
    //   209: astore 7
    //   211: aload 7
    //   213: astore 6
    //   215: ldc 14
    //   217: new 105	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   224: ldc 108
    //   226: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 114
    //   235: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: invokevirtual 115	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   242: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload 7
    //   253: ifnull -134 -> 119
    //   256: aload 7
    //   258: invokevirtual 85	java/io/InputStream:close	()V
    //   261: aconst_null
    //   262: areturn
    //   263: astore_0
    //   264: ldc 14
    //   266: aload_0
    //   267: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   270: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aconst_null
    //   274: areturn
    //   275: astore_1
    //   276: aconst_null
    //   277: astore 7
    //   279: aload 7
    //   281: astore 6
    //   283: ldc 14
    //   285: new 105	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   292: ldc 108
    //   294: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_0
    //   298: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc 114
    //   303: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_1
    //   307: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   310: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload 7
    //   321: ifnull -202 -> 119
    //   324: aload 7
    //   326: invokevirtual 85	java/io/InputStream:close	()V
    //   329: aconst_null
    //   330: areturn
    //   331: astore_0
    //   332: ldc 14
    //   334: aload_0
    //   335: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   338: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aconst_null
    //   342: areturn
    //   343: astore_0
    //   344: aconst_null
    //   345: astore 6
    //   347: aload 6
    //   349: ifnull +8 -> 357
    //   352: aload 6
    //   354: invokevirtual 85	java/io/InputStream:close	()V
    //   357: aload_0
    //   358: athrow
    //   359: astore_1
    //   360: ldc 14
    //   362: aload_1
    //   363: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   366: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: goto -12 -> 357
    //   372: astore_0
    //   373: goto -26 -> 347
    //   376: astore_1
    //   377: goto -98 -> 279
    //   380: astore_1
    //   381: goto -170 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramString1	String
    //   0	384	1	paramString2	String
    //   0	384	2	paramString3	String
    //   0	384	3	paramBaseJob	BaseJob
    //   59	31	4	i	int
    //   102	3	5	bool	boolean
    //   19	334	6	localBufferedInputStream1	java.io.BufferedInputStream
    //   15	310	7	localBufferedInputStream2	java.io.BufferedInputStream
    //   36	117	8	localMessageDigest1	MessageDigest
    //   46	125	9	localMessageDigest2	MessageDigest
    //   26	61	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   114	119	121	java/io/IOException
    //   187	192	194	java/io/IOException
    //   0	17	207	java/io/FileNotFoundException
    //   256	261	263	java/io/IOException
    //   0	17	275	java/io/IOException
    //   324	329	331	java/io/IOException
    //   0	17	343	finally
    //   352	357	359	java/io/IOException
    //   21	28	372	finally
    //   32	38	372	finally
    //   42	48	372	finally
    //   52	61	372	finally
    //   70	80	372	finally
    //   84	94	372	finally
    //   98	104	372	finally
    //   137	146	372	finally
    //   150	164	372	finally
    //   168	182	372	finally
    //   215	251	372	finally
    //   283	319	372	finally
    //   21	28	376	java/io/IOException
    //   32	38	376	java/io/IOException
    //   42	48	376	java/io/IOException
    //   52	61	376	java/io/IOException
    //   70	80	376	java/io/IOException
    //   84	94	376	java/io/IOException
    //   98	104	376	java/io/IOException
    //   137	146	376	java/io/IOException
    //   150	164	376	java/io/IOException
    //   168	182	376	java/io/IOException
    //   21	28	380	java/io/FileNotFoundException
    //   32	38	380	java/io/FileNotFoundException
    //   42	48	380	java/io/FileNotFoundException
    //   52	61	380	java/io/FileNotFoundException
    //   70	80	380	java/io/FileNotFoundException
    //   84	94	380	java/io/FileNotFoundException
    //   98	104	380	java/io/FileNotFoundException
    //   137	146	380	java/io/FileNotFoundException
    //   150	164	380	java/io/FileNotFoundException
    //   168	182	380	java/io/FileNotFoundException
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
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(sHexChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(sHexChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.util.HashSumCalc
 * JD-Core Version:    0.7.0.1
 */