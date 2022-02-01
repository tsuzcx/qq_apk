package com.tencent.feedback.eup.jni;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;

public class c
{
  public byte a;
  public int b;
  
  /* Error */
  public static com.tencent.feedback.eup.e a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 18	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: ldc 20
    //   10: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload 4
    //   16: astore_1
    //   17: aload_2
    //   18: invokevirtual 27	java/io/File:exists	()Z
    //   21: ifeq +13 -> 34
    //   24: aload_2
    //   25: invokevirtual 30	java/io/File:canRead	()Z
    //   28: ifne +8 -> 36
    //   31: aload 4
    //   33: astore_1
    //   34: aload_1
    //   35: areturn
    //   36: new 32	java/io/FileInputStream
    //   39: dup
    //   40: aload_2
    //   41: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore_3
    //   45: aload_3
    //   46: astore_1
    //   47: aload_3
    //   48: invokestatic 38	com/tencent/feedback/eup/jni/c:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +14 -> 67
    //   56: aload_3
    //   57: astore_1
    //   58: aload_2
    //   59: ldc 40
    //   61: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   64: ifne +42 -> 106
    //   67: aload_3
    //   68: astore_1
    //   69: ldc 48
    //   71: iconst_1
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_2
    //   78: aastore
    //   79: invokestatic 54	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_3
    //   84: invokevirtual 57	java/io/FileInputStream:close	()V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_0
    //   90: aload 4
    //   92: astore_1
    //   93: aload_0
    //   94: invokestatic 60	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   97: ifne -63 -> 34
    //   100: aload_0
    //   101: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   104: aconst_null
    //   105: areturn
    //   106: aload_3
    //   107: astore_1
    //   108: new 65	java/util/HashMap
    //   111: dup
    //   112: invokespecial 66	java/util/HashMap:<init>	()V
    //   115: astore 6
    //   117: aconst_null
    //   118: astore_2
    //   119: aload_3
    //   120: astore_1
    //   121: aload_3
    //   122: invokestatic 38	com/tencent/feedback/eup/jni/c:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   125: astore 5
    //   127: aload 5
    //   129: ifnull +31 -> 160
    //   132: aload_2
    //   133: ifnonnull +9 -> 142
    //   136: aload 5
    //   138: astore_2
    //   139: goto -20 -> 119
    //   142: aload_3
    //   143: astore_1
    //   144: aload 6
    //   146: aload_2
    //   147: aload 5
    //   149: invokeinterface 72 3 0
    //   154: pop
    //   155: aconst_null
    //   156: astore_2
    //   157: goto -38 -> 119
    //   160: aload_2
    //   161: ifnull +42 -> 203
    //   164: aload_3
    //   165: astore_1
    //   166: ldc 74
    //   168: iconst_1
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_2
    //   175: aastore
    //   176: invokestatic 54	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload_3
    //   181: invokevirtual 57	java/io/FileInputStream:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: aload 4
    //   189: astore_1
    //   190: aload_0
    //   191: invokestatic 60	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   194: ifne -160 -> 34
    //   197: aload_0
    //   198: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   201: aconst_null
    //   202: areturn
    //   203: aload_3
    //   204: astore_1
    //   205: aload_0
    //   206: aload 6
    //   208: invokestatic 77	com/tencent/feedback/eup/jni/c:a	(Landroid/content/Context;Ljava/util/Map;)Lcom/tencent/feedback/eup/e;
    //   211: astore_0
    //   212: aload_3
    //   213: invokevirtual 57	java/io/FileInputStream:close	()V
    //   216: aload_0
    //   217: areturn
    //   218: astore_2
    //   219: aload_0
    //   220: astore_1
    //   221: aload_2
    //   222: invokestatic 60	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   225: ifne -191 -> 34
    //   228: aload_2
    //   229: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: areturn
    //   234: astore_2
    //   235: aconst_null
    //   236: astore_0
    //   237: aload_0
    //   238: astore_1
    //   239: aload_2
    //   240: invokestatic 60	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   243: ifne +9 -> 252
    //   246: aload_0
    //   247: astore_1
    //   248: aload_2
    //   249: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   252: aload 4
    //   254: astore_1
    //   255: aload_0
    //   256: ifnull -222 -> 34
    //   259: aload_0
    //   260: invokevirtual 57	java/io/FileInputStream:close	()V
    //   263: aconst_null
    //   264: areturn
    //   265: astore_0
    //   266: aload 4
    //   268: astore_1
    //   269: aload_0
    //   270: invokestatic 60	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   273: ifne -239 -> 34
    //   276: aload_0
    //   277: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   280: aconst_null
    //   281: areturn
    //   282: astore_0
    //   283: aconst_null
    //   284: astore_1
    //   285: aload_1
    //   286: ifnull +7 -> 293
    //   289: aload_1
    //   290: invokevirtual 57	java/io/FileInputStream:close	()V
    //   293: aload_0
    //   294: athrow
    //   295: astore_1
    //   296: aload_1
    //   297: invokestatic 60	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   300: ifne -7 -> 293
    //   303: aload_1
    //   304: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   307: goto -14 -> 293
    //   310: astore_0
    //   311: goto -26 -> 285
    //   314: astore_2
    //   315: aload_3
    //   316: astore_0
    //   317: goto -80 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramContext	Context
    //   0	320	1	paramString	String
    //   13	162	2	localObject1	Object
    //   218	11	2	localIOException1	java.io.IOException
    //   234	15	2	localIOException2	java.io.IOException
    //   314	1	2	localIOException3	java.io.IOException
    //   44	272	3	localFileInputStream	java.io.FileInputStream
    //   1	266	4	localObject2	Object
    //   125	23	5	str	String
    //   115	92	6	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   83	87	89	java/io/IOException
    //   180	184	186	java/io/IOException
    //   212	216	218	java/io/IOException
    //   36	45	234	java/io/IOException
    //   259	263	265	java/io/IOException
    //   36	45	282	finally
    //   289	293	295	java/io/IOException
    //   47	52	310	finally
    //   58	67	310	finally
    //   69	83	310	finally
    //   108	117	310	finally
    //   121	127	310	finally
    //   144	155	310	finally
    //   166	180	310	finally
    //   205	212	310	finally
    //   239	246	310	finally
    //   248	252	310	finally
    //   47	52	314	java/io/IOException
    //   58	67	314	java/io/IOException
    //   69	83	314	java/io/IOException
    //   108	117	314	java/io/IOException
    //   121	127	314	java/io/IOException
    //   144	155	314	java/io/IOException
    //   166	180	314	java/io/IOException
    //   205	212	314	java/io/IOException
  }
  
  private static com.tencent.feedback.eup.e a(Context paramContext, Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      paramContext = null;
      return paramContext;
    }
    if (com.tencent.feedback.common.c.a(paramContext) == null)
    {
      com.tencent.feedback.common.e.d("abnormal com info not created", new Object[0]);
      return null;
    }
    Object localObject = (String)paramMap.get("intStateStr");
    if ((localObject == null) || (((String)localObject).trim().length() <= 0))
    {
      com.tencent.feedback.common.e.d("no intStateStr", new Object[0]);
      return null;
    }
    localObject = b((String)localObject);
    if (localObject == null)
    {
      com.tencent.feedback.common.e.d("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
      return null;
    }
    label512:
    label515:
    label518:
    label521:
    for (;;)
    {
      try
      {
        ((Integer)((Map)localObject).get("ep")).intValue();
        ((Integer)((Map)localObject).get("et")).intValue();
        ((Integer)((Map)localObject).get("sino")).intValue();
        int i = ((Integer)((Map)localObject).get("sico")).intValue();
        int j = ((Integer)((Map)localObject).get("spd")).intValue();
        ((Integer)((Map)localObject).get("sud")).intValue();
        long l1 = ((Integer)((Map)localObject).get("ets")).intValue();
        long l2 = ((Integer)((Map)localObject).get("etms")).intValue();
        String str5 = (String)paramMap.get("soVersion");
        if (str5 == null)
        {
          com.tencent.feedback.common.e.d("error format at version", new Object[0]);
          return null;
        }
        String str1 = (String)paramMap.get("errorAddr");
        if (str1 == null)
        {
          str1 = "unknown2";
          String str2 = (String)paramMap.get("codeMsg");
          if (str2 != null) {
            break label512;
          }
          str2 = "unknown2";
          String str3 = (String)paramMap.get("tombPath");
          if (str3 != null) {
            break label515;
          }
          str3 = "unknown2";
          String str4 = (String)paramMap.get("signalName");
          if (str4 != null) {
            break label518;
          }
          str4 = "unknown2";
          String str6 = (String)paramMap.get("errnoMsg");
          localObject = (String)paramMap.get("stack");
          if (localObject != null) {
            break label521;
          }
          localObject = "unknown2";
          String str7 = (String)paramMap.get("jstack");
          paramMap = (Map<String, String>)localObject;
          if (str7 != null) {
            paramMap = (String)localObject + "java:\n" + str7;
          }
          paramMap = b.a(paramContext, l2 / 1000L + 1000L * l1, str4, str1, paramMap, str3, i, str2, -j, str6, null, null, str5);
          paramContext = paramMap;
          if (paramMap == null) {
            break;
          }
          paramMap.c(true);
          return paramMap;
        }
      }
      catch (Throwable paramContext)
      {
        com.tencent.feedback.common.e.d("error format", new Object[0]);
        if (!com.tencent.feedback.common.e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        return null;
      }
      continue;
      continue;
      continue;
    }
  }
  
  private static String a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      if (i == 0) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append((char)i);
    }
  }
  
  public static void a(String paramString)
  {
    paramString = new File(paramString, "rqd_record.eup");
    if ((!paramString.exists()) || (!paramString.canWrite())) {
      return;
    }
    paramString.delete();
    com.tencent.feedback.common.e.b("delete record file %s", new Object[] { paramString.getAbsoluteFile() });
  }
  
  private static Map<String, Integer> b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      int i;
      String[] arrayOfString2;
      try
      {
        HashMap localHashMap = new HashMap();
        String[] arrayOfString1 = paramString.split(",");
        int j = arrayOfString1.length;
        i = 0;
        if (i >= j) {
          break label135;
        }
        String str = arrayOfString1[i];
        arrayOfString2 = str.split(":");
        if (arrayOfString2.length == 2) {
          break label104;
        }
        com.tencent.feedback.common.e.d("error format at %s", new Object[] { str });
        return null;
      }
      catch (Exception localException)
      {
        com.tencent.feedback.common.e.d("error format intStateStr %s", new Object[] { paramString });
      }
      if (com.tencent.feedback.common.e.a(localException)) {
        break;
      }
      localException.printStackTrace();
      return null;
      label104:
      int k = Integer.parseInt(arrayOfString2[1]);
      localException.put(arrayOfString2[0], Integer.valueOf(k));
      i += 1;
    }
    label135:
    return localException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.c
 * JD-Core Version:    0.7.0.1
 */