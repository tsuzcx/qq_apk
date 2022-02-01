package com.tencent.tpns.baseapi.base.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import com.tencent.tpns.baseapi.core.net.a;
import java.io.Closeable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonHelper
{
  public static boolean checkManifestIfComponentConfiged(Context paramContext, String paramString)
  {
    try
    {
      paramString = new ComponentName(paramContext.getPackageName(), paramString);
      paramContext.getPackageManager().getServiceInfo(paramString, 0);
      return true;
    }
    catch (Throwable paramContext)
    {
      Logger.e("CommonHelper", "CommonHelper -> checkManifestIfComponentConfiged", paramContext);
    }
    return false;
  }
  
  /* Error */
  public static byte[] decodeGZipContent(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 48	java/io/ByteArrayInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 51	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore 4
    //   13: new 53	java/util/zip/GZIPInputStream
    //   16: dup
    //   17: aload 4
    //   19: invokespecial 56	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore_3
    //   23: sipush 4096
    //   26: newarray byte
    //   28: astore_2
    //   29: new 58	java/io/ByteArrayOutputStream
    //   32: dup
    //   33: aload_0
    //   34: arraylength
    //   35: iconst_2
    //   36: imul
    //   37: invokespecial 61	java/io/ByteArrayOutputStream:<init>	(I)V
    //   40: astore_0
    //   41: aload_0
    //   42: astore 7
    //   44: aload_3
    //   45: astore 6
    //   47: aload 4
    //   49: astore 5
    //   51: aload_3
    //   52: aload_2
    //   53: invokevirtual 65	java/util/zip/GZIPInputStream:read	([B)I
    //   56: istore_1
    //   57: iload_1
    //   58: iconst_m1
    //   59: if_icmpeq +92 -> 151
    //   62: aload_0
    //   63: astore 7
    //   65: aload_3
    //   66: astore 6
    //   68: aload 4
    //   70: astore 5
    //   72: aload_0
    //   73: aload_2
    //   74: iconst_0
    //   75: iload_1
    //   76: invokevirtual 69	java/io/ByteArrayOutputStream:write	([BII)V
    //   79: goto -38 -> 41
    //   82: astore_2
    //   83: aload_0
    //   84: astore 7
    //   86: aload_3
    //   87: astore 6
    //   89: aload 4
    //   91: astore 5
    //   93: ldc 36
    //   95: new 71	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   102: ldc 74
    //   104: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_2
    //   108: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 86	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 90	java/util/zip/GZIPInputStream:close	()V
    //   133: aload 8
    //   135: astore_0
    //   136: aload 4
    //   138: ifnull +11 -> 149
    //   141: aload 4
    //   143: invokevirtual 91	java/io/ByteArrayInputStream:close	()V
    //   146: aload 8
    //   148: astore_0
    //   149: aload_0
    //   150: areturn
    //   151: aload_0
    //   152: astore 7
    //   154: aload_3
    //   155: astore 6
    //   157: aload 4
    //   159: astore 5
    //   161: aload_0
    //   162: invokevirtual 95	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   165: astore_2
    //   166: aload_0
    //   167: ifnull +7 -> 174
    //   170: aload_0
    //   171: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 90	java/util/zip/GZIPInputStream:close	()V
    //   182: aload_2
    //   183: astore_0
    //   184: aload 4
    //   186: ifnull -37 -> 149
    //   189: aload 4
    //   191: invokevirtual 91	java/io/ByteArrayInputStream:close	()V
    //   194: aload_2
    //   195: areturn
    //   196: astore_0
    //   197: aload_2
    //   198: areturn
    //   199: astore_0
    //   200: aconst_null
    //   201: astore_2
    //   202: aconst_null
    //   203: astore_3
    //   204: aconst_null
    //   205: astore 4
    //   207: aload_2
    //   208: ifnull +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   215: aload_3
    //   216: ifnull +7 -> 223
    //   219: aload_3
    //   220: invokevirtual 90	java/util/zip/GZIPInputStream:close	()V
    //   223: aload 4
    //   225: ifnull +8 -> 233
    //   228: aload 4
    //   230: invokevirtual 91	java/io/ByteArrayInputStream:close	()V
    //   233: aload_0
    //   234: athrow
    //   235: astore_0
    //   236: goto -62 -> 174
    //   239: astore_0
    //   240: goto -58 -> 182
    //   243: astore_0
    //   244: goto -119 -> 125
    //   247: astore_0
    //   248: goto -115 -> 133
    //   251: astore_0
    //   252: aconst_null
    //   253: areturn
    //   254: astore_2
    //   255: goto -40 -> 215
    //   258: astore_2
    //   259: goto -36 -> 223
    //   262: astore_2
    //   263: goto -30 -> 233
    //   266: astore_0
    //   267: aconst_null
    //   268: astore_2
    //   269: aconst_null
    //   270: astore_3
    //   271: goto -64 -> 207
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_2
    //   277: goto -70 -> 207
    //   280: astore_0
    //   281: aload 7
    //   283: astore_2
    //   284: aload 6
    //   286: astore_3
    //   287: aload 5
    //   289: astore 4
    //   291: goto -84 -> 207
    //   294: astore_2
    //   295: aconst_null
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_3
    //   299: aconst_null
    //   300: astore 4
    //   302: goto -219 -> 83
    //   305: astore_2
    //   306: aconst_null
    //   307: astore_0
    //   308: aconst_null
    //   309: astore_3
    //   310: goto -227 -> 83
    //   313: astore_2
    //   314: aconst_null
    //   315: astore_0
    //   316: goto -233 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramArrayOfByte	byte[]
    //   56	20	1	i	int
    //   28	46	2	arrayOfByte1	byte[]
    //   82	26	2	localThrowable1	Throwable
    //   165	47	2	arrayOfByte2	byte[]
    //   254	1	2	localThrowable2	Throwable
    //   258	1	2	localThrowable3	Throwable
    //   262	1	2	localThrowable4	Throwable
    //   268	16	2	localObject1	Object
    //   294	1	2	localThrowable5	Throwable
    //   305	1	2	localThrowable6	Throwable
    //   313	1	2	localThrowable7	Throwable
    //   22	288	3	localObject2	Object
    //   11	290	4	localObject3	Object
    //   49	239	5	localObject4	Object
    //   45	240	6	localObject5	Object
    //   42	240	7	arrayOfByte3	byte[]
    //   1	146	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   51	57	82	java/lang/Throwable
    //   72	79	82	java/lang/Throwable
    //   161	166	82	java/lang/Throwable
    //   189	194	196	java/lang/Throwable
    //   3	13	199	finally
    //   170	174	235	java/lang/Throwable
    //   178	182	239	java/lang/Throwable
    //   121	125	243	java/lang/Throwable
    //   129	133	247	java/lang/Throwable
    //   141	146	251	java/lang/Throwable
    //   211	215	254	java/lang/Throwable
    //   219	223	258	java/lang/Throwable
    //   228	233	262	java/lang/Throwable
    //   13	23	266	finally
    //   23	41	274	finally
    //   51	57	280	finally
    //   72	79	280	finally
    //   93	117	280	finally
    //   161	166	280	finally
    //   3	13	294	java/lang/Throwable
    //   13	23	305	java/lang/Throwable
    //   23	41	313	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] encodeGZipContent(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 58	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: aload_0
    //   8: arraylength
    //   9: invokespecial 61	java/io/ByteArrayOutputStream:<init>	(I)V
    //   12: astore_1
    //   13: new 98	java/util/zip/GZIPOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 101	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore 5
    //   23: aload 5
    //   25: astore_3
    //   26: aload_1
    //   27: astore_2
    //   28: aload 5
    //   30: aload_0
    //   31: invokevirtual 103	java/util/zip/GZIPOutputStream:write	([B)V
    //   34: aload 5
    //   36: ifnull +8 -> 44
    //   39: aload 5
    //   41: invokevirtual 104	java/util/zip/GZIPOutputStream:close	()V
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   52: aload_1
    //   53: invokevirtual 95	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   56: astore_0
    //   57: aload_0
    //   58: areturn
    //   59: astore 4
    //   61: aconst_null
    //   62: astore_0
    //   63: aconst_null
    //   64: astore_1
    //   65: aload_0
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: ldc 36
    //   71: new 71	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   78: ldc 106
    //   80: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 4
    //   85: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 86	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 104	java/util/zip/GZIPOutputStream:close	()V
    //   102: aload 6
    //   104: astore_0
    //   105: aload_1
    //   106: ifnull -49 -> 57
    //   109: aload_1
    //   110: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_3
    //   124: ifnull +7 -> 131
    //   127: aload_3
    //   128: invokevirtual 104	java/util/zip/GZIPOutputStream:close	()V
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   139: aload_0
    //   140: athrow
    //   141: astore_0
    //   142: goto -98 -> 44
    //   145: astore_0
    //   146: goto -94 -> 52
    //   149: astore_0
    //   150: goto -48 -> 102
    //   153: astore_2
    //   154: goto -23 -> 131
    //   157: astore_1
    //   158: goto -19 -> 139
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_3
    //   164: goto -41 -> 123
    //   167: astore_0
    //   168: aload_2
    //   169: astore_1
    //   170: goto -47 -> 123
    //   173: astore 4
    //   175: aconst_null
    //   176: astore_0
    //   177: goto -112 -> 65
    //   180: astore 4
    //   182: aload 5
    //   184: astore_0
    //   185: goto -120 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramArrayOfByte	byte[]
    //   12	124	1	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   157	1	1	localThrowable1	Throwable
    //   169	1	1	localObject1	Object
    //   27	42	2	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   153	16	2	localThrowable2	Throwable
    //   25	139	3	localObject2	Object
    //   59	25	4	localThrowable3	Throwable
    //   173	1	4	localThrowable4	Throwable
    //   180	1	4	localThrowable5	Throwable
    //   21	162	5	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   1	102	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	59	java/lang/Throwable
    //   109	113	115	java/lang/Throwable
    //   3	13	118	finally
    //   39	44	141	java/lang/Throwable
    //   48	52	145	java/lang/Throwable
    //   98	102	149	java/lang/Throwable
    //   127	131	153	java/lang/Throwable
    //   135	139	157	java/lang/Throwable
    //   13	23	161	finally
    //   28	34	167	finally
    //   69	94	167	finally
    //   13	23	173	java/lang/Throwable
    //   28	34	180	java/lang/Throwable
  }
  
  public static Object getMetaData(Context paramContext, String paramString, Object paramObject)
  {
    try
    {
      Object localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      paramContext = paramObject;
      if (localObject != null)
      {
        localObject = ((ApplicationInfo)localObject).metaData.get(paramString);
        paramContext = paramObject;
        if (localObject != null) {
          paramContext = (Context)localObject;
        }
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Logger.e("CommonHelper", "unexpected for getMetaData:" + paramString);
    }
    return paramObject;
  }
  
  public static String getOfflineMsg(Context paramContext, String paramString1, String paramString2, HttpRequestCallback paramHttpRequestCallback)
  {
    try
    {
      if (CloudManager.getInstance(paramContext).shouldRefuse())
      {
        Logger.i("CommonHelper", "getOfflineMsg refused by cloud");
        return "";
      }
      String str = a.a(paramString1);
      paramContext = a.a(paramContext).a(paramString1, str, paramString2, paramHttpRequestCallback, true);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Logger.w("CommonHelper", "unexpected for getOfflineMsg, exception:", paramContext);
    }
    return "";
  }
  
  public static boolean isIPValid(String paramString)
  {
    if ((paramString == null) || (paramString.length() < 7) || (paramString.length() > 15) || ("".equals(paramString))) {
      return false;
    }
    return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(paramString).find();
  }
  
  public static Object jsonGet(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    Object localObject = paramObject;
    try
    {
      if (paramJSONObject.has(paramString)) {
        localObject = paramJSONObject.get(paramString);
      }
      return localObject;
    }
    catch (JSONException paramJSONObject)
    {
      Logger.e("CommonHelper", "unexpected for jsonGet:" + paramJSONObject.getMessage());
    }
    return paramObject;
  }
  
  public static boolean jsonPut(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        paramJSONObject.put(paramString, paramObject);
        return true;
      }
      catch (JSONException paramJSONObject)
      {
        Logger.e("CommonHelper", "unexpected for jsonPush:" + paramJSONObject.getMessage());
      }
    }
    return false;
  }
  
  public static boolean safeClose(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return true;
      }
      catch (Throwable paramCloseable)
      {
        Logger.e("CommonHelper", "unexpected for safeClose:" + paramCloseable.getMessage());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.CommonHelper
 * JD-Core Version:    0.7.0.1
 */