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
    //   0: new 18	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: ldc 20
    //   7: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 27	java/io/File:exists	()Z
    //   15: ifeq +285 -> 300
    //   18: aload_1
    //   19: invokevirtual 30	java/io/File:canRead	()Z
    //   22: ifne +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new 32	java/io/FileInputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore_1
    //   38: aload_3
    //   39: invokestatic 38	com/tencent/feedback/eup/jni/c:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +140 -> 184
    //   47: aload_3
    //   48: astore_1
    //   49: aload_2
    //   50: ldc 40
    //   52: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifne +6 -> 61
    //   58: goto +126 -> 184
    //   61: aload_3
    //   62: astore_1
    //   63: new 48	java/util/HashMap
    //   66: dup
    //   67: invokespecial 49	java/util/HashMap:<init>	()V
    //   70: astore 5
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_3
    //   75: astore_1
    //   76: aload_3
    //   77: invokestatic 38	com/tencent/feedback/eup/jni/c:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   80: astore 4
    //   82: aload 4
    //   84: ifnull +31 -> 115
    //   87: aload_2
    //   88: ifnonnull +9 -> 97
    //   91: aload 4
    //   93: astore_2
    //   94: goto -20 -> 74
    //   97: aload_3
    //   98: astore_1
    //   99: aload 5
    //   101: aload_2
    //   102: aload 4
    //   104: invokeinterface 55 3 0
    //   109: pop
    //   110: aconst_null
    //   111: astore_2
    //   112: goto -38 -> 74
    //   115: aload_2
    //   116: ifnull +39 -> 155
    //   119: aload_3
    //   120: astore_1
    //   121: ldc 57
    //   123: iconst_1
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_2
    //   130: aastore
    //   131: invokestatic 63	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   134: pop
    //   135: aload_3
    //   136: invokevirtual 66	java/io/FileInputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_0
    //   142: aload_0
    //   143: invokestatic 69	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   146: ifne +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   153: aconst_null
    //   154: areturn
    //   155: aload_3
    //   156: astore_1
    //   157: aload_0
    //   158: aload 5
    //   160: invokestatic 75	com/tencent/feedback/eup/jni/c:a	(Landroid/content/Context;Ljava/util/Map;)Lcom/tencent/feedback/eup/e;
    //   163: astore_0
    //   164: aload_3
    //   165: invokevirtual 66	java/io/FileInputStream:close	()V
    //   168: aload_0
    //   169: areturn
    //   170: astore_1
    //   171: aload_1
    //   172: invokestatic 69	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   175: ifne +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   182: aload_0
    //   183: areturn
    //   184: aload_3
    //   185: astore_1
    //   186: ldc 77
    //   188: iconst_1
    //   189: anewarray 4	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_2
    //   195: aastore
    //   196: invokestatic 63	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   199: pop
    //   200: aload_3
    //   201: invokevirtual 66	java/io/FileInputStream:close	()V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_0
    //   207: aload_0
    //   208: invokestatic 69	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   211: ifne +7 -> 218
    //   214: aload_0
    //   215: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   218: aconst_null
    //   219: areturn
    //   220: astore_2
    //   221: aload_3
    //   222: astore_0
    //   223: goto +12 -> 235
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_1
    //   229: goto +46 -> 275
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_0
    //   235: aload_0
    //   236: astore_1
    //   237: aload_2
    //   238: invokestatic 69	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   241: ifne +9 -> 250
    //   244: aload_0
    //   245: astore_1
    //   246: aload_2
    //   247: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   250: aload_0
    //   251: ifnull +21 -> 272
    //   254: aload_0
    //   255: invokevirtual 66	java/io/FileInputStream:close	()V
    //   258: aconst_null
    //   259: areturn
    //   260: astore_0
    //   261: aload_0
    //   262: invokestatic 69	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   265: ifne +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   272: aconst_null
    //   273: areturn
    //   274: astore_0
    //   275: aload_1
    //   276: ifnull +22 -> 298
    //   279: aload_1
    //   280: invokevirtual 66	java/io/FileInputStream:close	()V
    //   283: goto +15 -> 298
    //   286: astore_1
    //   287: aload_1
    //   288: invokestatic 69	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   291: ifne +7 -> 298
    //   294: aload_1
    //   295: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   298: aload_0
    //   299: athrow
    //   300: aconst_null
    //   301: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramContext	Context
    //   0	302	1	paramString	String
    //   42	153	2	localObject	Object
    //   220	1	2	localIOException1	java.io.IOException
    //   232	15	2	localIOException2	java.io.IOException
    //   35	187	3	localFileInputStream	java.io.FileInputStream
    //   80	23	4	str	String
    //   70	89	5	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   135	139	141	java/io/IOException
    //   164	168	170	java/io/IOException
    //   200	204	206	java/io/IOException
    //   38	43	220	java/io/IOException
    //   49	58	220	java/io/IOException
    //   63	72	220	java/io/IOException
    //   76	82	220	java/io/IOException
    //   99	110	220	java/io/IOException
    //   121	135	220	java/io/IOException
    //   157	164	220	java/io/IOException
    //   186	200	220	java/io/IOException
    //   27	36	226	finally
    //   27	36	232	java/io/IOException
    //   254	258	260	java/io/IOException
    //   38	43	274	finally
    //   49	58	274	finally
    //   63	72	274	finally
    //   76	82	274	finally
    //   99	110	274	finally
    //   121	135	274	finally
    //   157	164	274	finally
    //   186	200	274	finally
    //   237	244	274	finally
    //   246	250	274	finally
    //   279	283	286	java/io/IOException
  }
  
  private static com.tencent.feedback.eup.e a(Context paramContext, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    if (com.tencent.feedback.common.c.a(paramContext) == null)
    {
      com.tencent.feedback.common.e.d("abnormal com info not created", new Object[0]);
      return null;
    }
    Object localObject1 = (String)paramMap.get("intStateStr");
    if ((localObject1 != null) && (((String)localObject1).trim().length() > 0))
    {
      localObject1 = b((String)localObject1);
      if (localObject1 == null)
      {
        com.tencent.feedback.common.e.d("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
        return null;
      }
      try
      {
        ((Integer)((Map)localObject1).get("ep")).intValue();
        ((Integer)((Map)localObject1).get("et")).intValue();
        ((Integer)((Map)localObject1).get("sino")).intValue();
        int i = ((Integer)((Map)localObject1).get("sico")).intValue();
        int j = ((Integer)((Map)localObject1).get("spd")).intValue();
        ((Integer)((Map)localObject1).get("sud")).intValue();
        long l1 = ((Integer)((Map)localObject1).get("ets")).intValue();
        long l2 = ((Integer)((Map)localObject1).get("etms")).intValue();
        String str2 = (String)paramMap.get("soVersion");
        if (str2 == null)
        {
          com.tencent.feedback.common.e.d("error format at version", new Object[0]);
          return null;
        }
        localObject1 = (String)paramMap.get("errorAddr");
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "unknown2";
        }
        localObject1 = (String)paramMap.get("codeMsg");
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "unknown2";
        }
        localObject1 = (String)paramMap.get("tombPath");
        Object localObject4 = localObject1;
        if (localObject1 == null) {
          localObject4 = "unknown2";
        }
        localObject1 = (String)paramMap.get("signalName");
        Object localObject5 = localObject1;
        if (localObject1 == null) {
          localObject5 = "unknown2";
        }
        String str3 = (String)paramMap.get("errnoMsg");
        String str1 = (String)paramMap.get("stack");
        localObject1 = str1;
        if (str1 == null) {
          localObject1 = "unknown2";
        }
        str1 = (String)paramMap.get("jstack");
        paramMap = (Map<String, String>)localObject1;
        if (str1 != null)
        {
          paramMap = new StringBuilder();
          paramMap.append((String)localObject1);
          paramMap.append("java:\n");
          paramMap.append(str1);
          paramMap = paramMap.toString();
        }
        paramContext = b.a(paramContext, l2 / 1000L + l1 * 1000L, (String)localObject5, (String)localObject2, paramMap, (String)localObject4, i, (String)localObject3, -j, str3, null, null, str2);
        if (paramContext != null) {
          paramContext.c(true);
        }
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        com.tencent.feedback.common.e.d("error format", new Object[0]);
        if (!com.tencent.feedback.common.e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        return null;
      }
    }
    com.tencent.feedback.common.e.d("no intStateStr", new Object[0]);
    return null;
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
    return null;
  }
  
  public static void a(String paramString)
  {
    paramString = new File(paramString, "rqd_record.eup");
    if (paramString.exists())
    {
      if (!paramString.canWrite()) {
        return;
      }
      paramString.delete();
      com.tencent.feedback.common.e.b("delete record file %s", new Object[] { paramString.getAbsoluteFile() });
      return;
    }
  }
  
  private static Map<String, Integer> b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      String[] arrayOfString1 = paramString.split(",");
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString1[i];
        String[] arrayOfString2 = str.split(":");
        if (arrayOfString2.length != 2)
        {
          com.tencent.feedback.common.e.d("error format at %s", new Object[] { str });
          return null;
        }
        int k = Integer.parseInt(arrayOfString2[1]);
        localHashMap.put(arrayOfString2[0], Integer.valueOf(k));
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      com.tencent.feedback.common.e.d("error format intStateStr %s", new Object[] { paramString });
      if (!com.tencent.feedback.common.e.a(localException)) {
        localException.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.c
 * JD-Core Version:    0.7.0.1
 */