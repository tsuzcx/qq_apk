package com.tencent.thumbplayer.core.downloadproxy.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TPDLProxyUtils
{
  private static final String FILE_NAME = "TPDLProxyUtils";
  
  public static String byteArrayToString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", "byteArrayToString failed, error:" + paramArrayOfByte.toString());
        paramArrayOfByte = "";
      }
    }
  }
  
  public static String losePackageCheck(int paramInt)
  {
    label220:
    label223:
    for (;;)
    {
      try
      {
        Object localObject1 = "ping -c " + paramInt + " www.qq.com";
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String)localObject1).getInputStream()));
        Object localObject2 = "";
        localObject1 = "";
        String str;
        Object localObject5;
        Object localObject3;
        int i;
        Object localObject4;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          str = localBufferedReader.readLine();
          localObject5 = localObject2;
          localObject3 = localObject1;
          if (str != null)
          {
            if (!str.contains(" packet loss")) {
              break label223;
            }
            paramInt = str.indexOf("received, ");
            i = str.indexOf("%");
            localObject3 = str.substring(paramInt + "received, ".length(), i + 1);
            localObject1 = localObject3;
          }
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        try
        {
          if (!str.contains("avg")) {
            break label220;
          }
          paramInt = str.indexOf("/", 20);
          localObject3 = str.substring(paramInt + 1, str.indexOf(".", paramInt));
          localObject2 = localObject3;
        }
        catch (Throwable localThrowable3)
        {
          continue;
        }
        localThrowable1 = localThrowable1;
        localObject2 = "";
        localObject1 = "";
        localThrowable1.printStackTrace();
        localObject4 = localObject1;
        localObject5 = localObject2;
        return localObject4 + ";" + localObject5;
      }
    }
  }
  
  public static int objectToInt(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      return paramInt;
    }
    try
    {
      int i = ((Integer)paramObject).intValue();
      return i;
    }
    catch (Throwable paramObject)
    {
      TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", "object to int failed, error:" + paramObject.toString());
    }
    return paramInt;
  }
  
  public static long objectToLong(Object paramObject, long paramLong)
  {
    if (paramObject == null) {
      return paramLong;
    }
    try
    {
      long l = ((Long)paramObject).longValue();
      return l;
    }
    catch (Throwable paramObject)
    {
      TPDLProxyLog.e("TPDLProxyUtils", 0, "tpdlnative", "object to long failed, error:" + paramObject.toString());
    }
    return paramLong;
  }
  
  /* Error */
  public static String serialize(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: new 145	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 146	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_2
    //   18: aload 4
    //   20: astore_3
    //   21: new 148	java/io/ObjectOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 151	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore 4
    //   31: aload 4
    //   33: aload_0
    //   34: invokevirtual 155	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   37: aload_1
    //   38: ldc 157
    //   40: invokevirtual 160	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_0
    //   44: aload 4
    //   46: ifnull +8 -> 54
    //   49: aload 4
    //   51: invokevirtual 163	java/io/ObjectOutputStream:close	()V
    //   54: aload_1
    //   55: ifnull +3 -> 58
    //   58: aload_1
    //   59: invokevirtual 164	java/io/ByteArrayOutputStream:close	()V
    //   62: aload_0
    //   63: areturn
    //   64: astore_2
    //   65: ldc 8
    //   67: iconst_0
    //   68: ldc 28
    //   70: new 30	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   77: ldc 166
    //   79: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_2
    //   83: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   86: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   95: goto -41 -> 54
    //   98: astore_1
    //   99: ldc 8
    //   101: iconst_0
    //   102: ldc 28
    //   104: new 30	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   111: ldc 168
    //   113: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   120: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: areturn
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_1
    //   134: aload 5
    //   136: astore 4
    //   138: aload_1
    //   139: astore_2
    //   140: aload 4
    //   142: astore_3
    //   143: ldc 8
    //   145: iconst_0
    //   146: ldc 28
    //   148: new 30	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   155: ldc 170
    //   157: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   164: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   173: aload 4
    //   175: ifnull +8 -> 183
    //   178: aload 4
    //   180: invokevirtual 163	java/io/ObjectOutputStream:close	()V
    //   183: aload_1
    //   184: ifnull +3 -> 187
    //   187: aload_1
    //   188: invokevirtual 164	java/io/ByteArrayOutputStream:close	()V
    //   191: ldc 19
    //   193: areturn
    //   194: astore_0
    //   195: ldc 8
    //   197: iconst_0
    //   198: ldc 28
    //   200: new 30	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   207: ldc 166
    //   209: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_0
    //   213: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   216: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   225: goto -42 -> 183
    //   228: astore_0
    //   229: ldc 8
    //   231: iconst_0
    //   232: ldc 28
    //   234: new 30	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   241: ldc 168
    //   243: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   250: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   259: goto -68 -> 191
    //   262: astore_0
    //   263: aconst_null
    //   264: astore_1
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 163	java/io/ObjectOutputStream:close	()V
    //   273: aload_1
    //   274: ifnull +3 -> 277
    //   277: aload_1
    //   278: invokevirtual 164	java/io/ByteArrayOutputStream:close	()V
    //   281: aload_0
    //   282: athrow
    //   283: astore_2
    //   284: ldc 8
    //   286: iconst_0
    //   287: ldc 28
    //   289: new 30	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   296: ldc 166
    //   298: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_2
    //   302: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   305: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   314: goto -41 -> 273
    //   317: astore_1
    //   318: ldc 8
    //   320: iconst_0
    //   321: ldc 28
    //   323: new 30	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   330: ldc 168
    //   332: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_1
    //   336: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   339: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   348: goto -67 -> 281
    //   351: astore_0
    //   352: aload_2
    //   353: astore_1
    //   354: goto -89 -> 265
    //   357: astore_0
    //   358: aload 4
    //   360: astore_3
    //   361: goto -96 -> 265
    //   364: astore_0
    //   365: aload 5
    //   367: astore 4
    //   369: goto -231 -> 138
    //   372: astore_0
    //   373: goto -235 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramObject	Object
    //   15	44	1	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   98	19	1	localThrowable1	Throwable
    //   133	145	1	localObject1	Object
    //   317	19	1	localThrowable2	Throwable
    //   353	1	1	localObject2	Object
    //   17	1	2	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   64	19	2	localThrowable3	Throwable
    //   139	1	2	localObject3	Object
    //   283	70	2	localThrowable4	Throwable
    //   1	360	3	localObject4	Object
    //   3	365	4	localObject5	Object
    //   6	360	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   49	54	64	java/lang/Throwable
    //   58	62	98	java/lang/Throwable
    //   8	16	131	java/lang/Throwable
    //   178	183	194	java/lang/Throwable
    //   187	191	228	java/lang/Throwable
    //   8	16	262	finally
    //   269	273	283	java/lang/Throwable
    //   277	281	317	java/lang/Throwable
    //   21	31	351	finally
    //   143	173	351	finally
    //   31	44	357	finally
    //   21	31	364	java/lang/Throwable
    //   31	44	372	java/lang/Throwable
  }
  
  /* Error */
  public static Object serializeToObject(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 174	java/io/ByteArrayInputStream
    //   6: dup
    //   7: aload_0
    //   8: ldc 157
    //   10: invokevirtual 178	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   13: invokespecial 181	java/io/ByteArrayInputStream:<init>	([B)V
    //   16: astore_1
    //   17: new 183	java/io/ObjectInputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 184	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_0
    //   26: aload_0
    //   27: astore_3
    //   28: aload_1
    //   29: astore_2
    //   30: aload_0
    //   31: invokevirtual 188	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   34: astore 4
    //   36: aload 4
    //   38: astore_2
    //   39: aload_0
    //   40: ifnull +7 -> 47
    //   43: aload_0
    //   44: invokevirtual 189	java/io/ObjectInputStream:close	()V
    //   47: aload_2
    //   48: astore_0
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_1
    //   54: invokevirtual 190	java/io/ByteArrayInputStream:close	()V
    //   57: aload_2
    //   58: astore_0
    //   59: aload_0
    //   60: areturn
    //   61: astore_0
    //   62: ldc 8
    //   64: iconst_0
    //   65: ldc 28
    //   67: new 30	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   74: ldc 192
    //   76: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   83: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   92: goto -45 -> 47
    //   95: astore_0
    //   96: ldc 8
    //   98: iconst_0
    //   99: ldc 28
    //   101: new 30	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   108: ldc 194
    //   110: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   117: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   126: aload_2
    //   127: areturn
    //   128: astore 4
    //   130: aconst_null
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_1
    //   134: aload_0
    //   135: astore_3
    //   136: aload_1
    //   137: astore_2
    //   138: ldc 8
    //   140: iconst_0
    //   141: ldc 28
    //   143: new 30	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   150: ldc 196
    //   152: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 4
    //   157: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   160: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 189	java/io/ObjectInputStream:close	()V
    //   177: aload 5
    //   179: astore_0
    //   180: aload_1
    //   181: ifnull -122 -> 59
    //   184: aload_1
    //   185: invokevirtual 190	java/io/ByteArrayInputStream:close	()V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_0
    //   191: ldc 8
    //   193: iconst_0
    //   194: ldc 28
    //   196: new 30	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   203: ldc 194
    //   205: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   212: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   221: aconst_null
    //   222: areturn
    //   223: astore_0
    //   224: ldc 8
    //   226: iconst_0
    //   227: ldc 28
    //   229: new 30	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   236: ldc 192
    //   238: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   245: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   254: goto -77 -> 177
    //   257: astore_0
    //   258: aconst_null
    //   259: astore_3
    //   260: aconst_null
    //   261: astore_1
    //   262: aload_3
    //   263: ifnull +7 -> 270
    //   266: aload_3
    //   267: invokevirtual 189	java/io/ObjectInputStream:close	()V
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 190	java/io/ByteArrayInputStream:close	()V
    //   278: aload_0
    //   279: athrow
    //   280: astore_2
    //   281: ldc 8
    //   283: iconst_0
    //   284: ldc 28
    //   286: new 30	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   293: ldc 192
    //   295: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_2
    //   299: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   302: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   311: goto -41 -> 270
    //   314: astore_1
    //   315: ldc 8
    //   317: iconst_0
    //   318: ldc 28
    //   320: new 30	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   327: ldc 194
    //   329: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_1
    //   333: invokevirtual 41	java/lang/Throwable:toString	()Ljava/lang/String;
    //   336: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 48	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   345: goto -67 -> 278
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_3
    //   351: goto -89 -> 262
    //   354: astore_0
    //   355: aload_2
    //   356: astore_1
    //   357: goto -95 -> 262
    //   360: astore 4
    //   362: aconst_null
    //   363: astore_0
    //   364: goto -230 -> 134
    //   367: astore 4
    //   369: goto -235 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramString	String
    //   16	259	1	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   314	19	1	localThrowable1	Throwable
    //   356	1	1	localObject1	Object
    //   29	109	2	localObject2	Object
    //   280	76	2	localThrowable2	Throwable
    //   27	324	3	str	String
    //   34	3	4	localObject3	Object
    //   128	28	4	localThrowable3	Throwable
    //   360	1	4	localThrowable4	Throwable
    //   367	1	4	localThrowable5	Throwable
    //   1	177	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   43	47	61	java/lang/Throwable
    //   53	57	95	java/lang/Throwable
    //   3	17	128	java/lang/Throwable
    //   184	188	190	java/lang/Throwable
    //   173	177	223	java/lang/Throwable
    //   3	17	257	finally
    //   266	270	280	java/lang/Throwable
    //   274	278	314	java/lang/Throwable
    //   17	26	348	finally
    //   30	36	354	finally
    //   138	169	354	finally
    //   17	26	360	java/lang/Throwable
    //   30	36	367	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils
 * JD-Core Version:    0.7.0.1
 */