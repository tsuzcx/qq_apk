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
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aload 8
    //   11: astore 5
    //   13: sipush 8192
    //   16: newarray byte
    //   18: astore 9
    //   20: aload 8
    //   22: astore 5
    //   24: aload_1
    //   25: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   28: astore 10
    //   30: aload 8
    //   32: astore 5
    //   34: new 56	java/io/BufferedInputStream
    //   37: dup
    //   38: new 58	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_1
    //   50: aload_1
    //   51: aload 9
    //   53: invokevirtual 70	java/io/InputStream:read	([B)I
    //   56: istore_3
    //   57: iload_3
    //   58: ifgt +22 -> 80
    //   61: aload 10
    //   63: invokevirtual 74	java/security/MessageDigest:digest	()[B
    //   66: invokestatic 78	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   69: astore_2
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 81	java/io/InputStream:close	()V
    //   78: aload_2
    //   79: areturn
    //   80: aload 10
    //   82: aload 9
    //   84: iconst_0
    //   85: iload_3
    //   86: invokevirtual 85	java/security/MessageDigest:update	([BII)V
    //   89: aload_2
    //   90: invokevirtual 91	com/weiyun/sdk/job/BaseJob:isAlive	()Z
    //   93: istore 4
    //   95: iload 4
    //   97: ifne -47 -> 50
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 81	java/io/InputStream:close	()V
    //   108: ldc 93
    //   110: areturn
    //   111: astore_0
    //   112: ldc 14
    //   114: aload_0
    //   115: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   118: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: goto -13 -> 108
    //   124: astore_0
    //   125: ldc 14
    //   127: aload_0
    //   128: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   131: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: goto -56 -> 78
    //   137: astore_2
    //   138: aload 6
    //   140: astore_1
    //   141: aload_1
    //   142: astore 5
    //   144: ldc 14
    //   146: new 105	java/lang/StringBuilder
    //   149: dup
    //   150: ldc 107
    //   152: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_0
    //   156: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 114
    //   161: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_2
    //   165: invokevirtual 115	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   168: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 81	java/io/InputStream:close	()V
    //   185: ldc 93
    //   187: areturn
    //   188: astore_0
    //   189: ldc 14
    //   191: aload_0
    //   192: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   195: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: goto -13 -> 185
    //   201: astore_2
    //   202: aload 7
    //   204: astore_1
    //   205: aload_1
    //   206: astore 5
    //   208: ldc 14
    //   210: new 105	java/lang/StringBuilder
    //   213: dup
    //   214: ldc 107
    //   216: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload_0
    //   220: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc 114
    //   225: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_2
    //   229: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   232: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 81	java/io/InputStream:close	()V
    //   249: ldc 93
    //   251: areturn
    //   252: astore_0
    //   253: ldc 14
    //   255: aload_0
    //   256: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   259: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: goto -13 -> 249
    //   265: astore_0
    //   266: aload 5
    //   268: ifnull +8 -> 276
    //   271: aload 5
    //   273: invokevirtual 81	java/io/InputStream:close	()V
    //   276: aload_0
    //   277: athrow
    //   278: astore_1
    //   279: ldc 14
    //   281: aload_1
    //   282: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   285: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -12 -> 276
    //   291: astore_0
    //   292: aload_1
    //   293: astore 5
    //   295: goto -29 -> 266
    //   298: astore_2
    //   299: goto -94 -> 205
    //   302: astore_2
    //   303: goto -162 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramString1	String
    //   0	306	1	paramString2	String
    //   0	306	2	paramBaseJob	BaseJob
    //   56	30	3	i	int
    //   93	3	4	bool	boolean
    //   11	283	5	localObject1	Object
    //   7	132	6	localObject2	Object
    //   1	202	7	localObject3	Object
    //   4	27	8	localObject4	Object
    //   18	65	9	arrayOfByte	byte[]
    //   28	53	10	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   104	108	111	java/io/IOException
    //   74	78	124	java/io/IOException
    //   13	20	137	java/io/FileNotFoundException
    //   24	30	137	java/io/FileNotFoundException
    //   34	50	137	java/io/FileNotFoundException
    //   181	185	188	java/io/IOException
    //   13	20	201	java/io/IOException
    //   24	30	201	java/io/IOException
    //   34	50	201	java/io/IOException
    //   245	249	252	java/io/IOException
    //   13	20	265	finally
    //   24	30	265	finally
    //   34	50	265	finally
    //   144	177	265	finally
    //   208	241	265	finally
    //   271	276	278	java/io/IOException
    //   50	57	291	finally
    //   61	70	291	finally
    //   80	95	291	finally
    //   50	57	298	java/io/IOException
    //   61	70	298	java/io/IOException
    //   80	95	298	java/io/IOException
    //   50	57	302	java/io/FileNotFoundException
    //   61	70	302	java/io/FileNotFoundException
    //   80	95	302	java/io/FileNotFoundException
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
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: new 56	java/io/BufferedInputStream
    //   12: dup
    //   13: new 58	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 7
    //   26: sipush 8192
    //   29: newarray byte
    //   31: astore 9
    //   33: aload_1
    //   34: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   37: astore 6
    //   39: aload_2
    //   40: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   43: astore 8
    //   45: aload 7
    //   47: aload 9
    //   49: invokevirtual 70	java/io/InputStream:read	([B)I
    //   52: istore 4
    //   54: iload 4
    //   56: ifgt +52 -> 108
    //   59: new 138	java/util/HashMap
    //   62: dup
    //   63: iconst_2
    //   64: invokespecial 141	java/util/HashMap:<init>	(I)V
    //   67: astore_3
    //   68: aload_3
    //   69: aload_1
    //   70: aload 6
    //   72: invokevirtual 74	java/security/MessageDigest:digest	()[B
    //   75: invokestatic 78	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   78: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: aload_3
    //   83: aload_2
    //   84: aload 8
    //   86: invokevirtual 74	java/security/MessageDigest:digest	()[B
    //   89: invokestatic 78	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   92: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: aload 7
    //   98: ifnull +8 -> 106
    //   101: aload 7
    //   103: invokevirtual 81	java/io/InputStream:close	()V
    //   106: aload_3
    //   107: areturn
    //   108: aload 6
    //   110: aload 9
    //   112: iconst_0
    //   113: iload 4
    //   115: invokevirtual 85	java/security/MessageDigest:update	([BII)V
    //   118: aload 8
    //   120: aload 9
    //   122: iconst_0
    //   123: iload 4
    //   125: invokevirtual 85	java/security/MessageDigest:update	([BII)V
    //   128: aload_3
    //   129: invokevirtual 91	com/weiyun/sdk/job/BaseJob:isAlive	()Z
    //   132: istore 5
    //   134: iload 5
    //   136: ifne -91 -> 45
    //   139: aload 7
    //   141: ifnull +8 -> 149
    //   144: aload 7
    //   146: invokevirtual 81	java/io/InputStream:close	()V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_0
    //   152: ldc 14
    //   154: aload_0
    //   155: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   158: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: goto -12 -> 149
    //   164: astore_0
    //   165: ldc 14
    //   167: aload_0
    //   168: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   171: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -68 -> 106
    //   177: astore_2
    //   178: aload 8
    //   180: astore_1
    //   181: aload_1
    //   182: astore 6
    //   184: ldc 14
    //   186: new 105	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 107
    //   192: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: aload_0
    //   196: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 114
    //   201: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_2
    //   205: invokevirtual 115	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   208: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 81	java/io/InputStream:close	()V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_0
    //   228: ldc 14
    //   230: aload_0
    //   231: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   234: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -12 -> 225
    //   240: astore_2
    //   241: aload 9
    //   243: astore_1
    //   244: aload_1
    //   245: astore 6
    //   247: ldc 14
    //   249: new 105	java/lang/StringBuilder
    //   252: dup
    //   253: ldc 107
    //   255: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload_0
    //   259: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 114
    //   264: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   271: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_1
    //   281: ifnull +7 -> 288
    //   284: aload_1
    //   285: invokevirtual 81	java/io/InputStream:close	()V
    //   288: aconst_null
    //   289: areturn
    //   290: astore_0
    //   291: ldc 14
    //   293: aload_0
    //   294: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   297: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: goto -12 -> 288
    //   303: astore_0
    //   304: aload 6
    //   306: ifnull +8 -> 314
    //   309: aload 6
    //   311: invokevirtual 81	java/io/InputStream:close	()V
    //   314: aload_0
    //   315: athrow
    //   316: astore_1
    //   317: ldc 14
    //   319: aload_1
    //   320: invokevirtual 97	java/io/IOException:getMessage	()Ljava/lang/String;
    //   323: invokestatic 103	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: goto -12 -> 314
    //   329: astore_0
    //   330: aload 7
    //   332: astore 6
    //   334: goto -30 -> 304
    //   337: astore_2
    //   338: aload 7
    //   340: astore_1
    //   341: goto -97 -> 244
    //   344: astore_2
    //   345: aload 7
    //   347: astore_1
    //   348: goto -167 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramString1	String
    //   0	351	1	paramString2	String
    //   0	351	2	paramString3	String
    //   0	351	3	paramBaseJob	BaseJob
    //   52	72	4	i	int
    //   132	3	5	bool	boolean
    //   4	329	6	localObject	Object
    //   24	322	7	localBufferedInputStream	java.io.BufferedInputStream
    //   7	172	8	localMessageDigest	MessageDigest
    //   1	241	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   144	149	151	java/io/IOException
    //   101	106	164	java/io/IOException
    //   9	26	177	java/io/FileNotFoundException
    //   221	225	227	java/io/IOException
    //   9	26	240	java/io/IOException
    //   284	288	290	java/io/IOException
    //   9	26	303	finally
    //   184	217	303	finally
    //   247	280	303	finally
    //   309	314	316	java/io/IOException
    //   26	45	329	finally
    //   45	54	329	finally
    //   59	96	329	finally
    //   108	134	329	finally
    //   26	45	337	java/io/IOException
    //   45	54	337	java/io/IOException
    //   59	96	337	java/io/IOException
    //   108	134	337	java/io/IOException
    //   26	45	344	java/io/FileNotFoundException
    //   45	54	344	java/io/FileNotFoundException
    //   59	96	344	java/io/FileNotFoundException
    //   108	134	344	java/io/FileNotFoundException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.HashSumCalc
 * JD-Core Version:    0.7.0.1
 */