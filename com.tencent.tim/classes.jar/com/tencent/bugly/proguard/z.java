package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class z
{
  private static Map<String, String> a = null;
  
  public static Context a(Context paramContext)
  {
    if (paramContext == null) {}
    Context localContext;
    do
    {
      return paramContext;
      localContext = paramContext.getApplicationContext();
    } while (localContext == null);
    return localContext;
  }
  
  public static SharedPreferences a(String paramString, Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences(paramString, 0);
    }
    return null;
  }
  
  private static BufferedReader a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.canRead())) {
      return null;
    }
    try
    {
      paramFile = new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), "utf-8"));
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      x.a(paramFile);
    }
    return null;
  }
  
  public static BufferedReader a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramString1 = new File(paramString1, paramString2);
        if ((paramString1.exists()) && (paramString1.canRead()))
        {
          paramString1 = a(paramString1);
          return paramString1;
        }
      }
      catch (NullPointerException paramString1)
      {
        x.a(paramString1);
      }
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
      paramString1.setAccessible(true);
      paramString1 = paramString1.invoke(null, paramArrayOfObject);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static <T> T a(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    try
    {
      paramArrayOfByte = paramCreator.createFromParcel(localParcel);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    finally
    {
      if (localParcel != null) {
        localParcel.recycle();
      }
    }
  }
  
  public static String a()
  {
    return a(System.currentTimeMillis());
  }
  
  public static String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException) {}
    return new Date().toString();
  }
  
  /* Error */
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 163
    //   3: invokestatic 168	com/tencent/bugly/crashreport/common/info/AppInfo:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   6: ifne +17 -> 23
    //   9: ldc 170
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 174	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aconst_null
    //   20: astore_2
    //   21: aload_2
    //   22: areturn
    //   23: aload_2
    //   24: ifnonnull +207 -> 231
    //   27: iconst_4
    //   28: anewarray 176	java/lang/String
    //   31: astore_0
    //   32: aload_0
    //   33: iconst_0
    //   34: ldc 178
    //   36: aastore
    //   37: aload_0
    //   38: iconst_1
    //   39: ldc 180
    //   41: aastore
    //   42: aload_0
    //   43: iconst_2
    //   44: ldc 182
    //   46: aastore
    //   47: aload_0
    //   48: iconst_3
    //   49: ldc 184
    //   51: aastore
    //   52: aconst_null
    //   53: astore_2
    //   54: aconst_null
    //   55: astore 4
    //   57: new 186	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   64: astore 5
    //   66: invokestatic 193	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   69: aload_0
    //   70: invokevirtual 197	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   73: astore_0
    //   74: new 41	java/io/BufferedReader
    //   77: dup
    //   78: new 43	java/io/InputStreamReader
    //   81: dup
    //   82: aload_0
    //   83: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   86: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   89: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +170 -> 269
    //   102: aload 5
    //   104: aload_3
    //   105: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 215
    //   110: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: iload_1
    //   115: ifle -22 -> 93
    //   118: aload 5
    //   120: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   123: iload_1
    //   124: if_icmple -31 -> 93
    //   127: aload 5
    //   129: iconst_0
    //   130: aload 5
    //   132: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   135: iload_1
    //   136: isub
    //   137: invokevirtual 223	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: goto -48 -> 93
    //   144: astore_3
    //   145: aload_0
    //   146: astore_2
    //   147: aload_3
    //   148: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   151: ifne +9 -> 160
    //   154: aload_0
    //   155: astore_2
    //   156: aload_3
    //   157: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   160: aload_0
    //   161: astore_2
    //   162: aload 5
    //   164: new 186	java/lang/StringBuilder
    //   167: dup
    //   168: ldc 225
    //   170: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: aload_3
    //   174: invokevirtual 229	java/lang/Throwable:toString	()Ljava/lang/String;
    //   177: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 231
    //   182: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: astore_3
    //   195: aload_3
    //   196: astore_2
    //   197: aload_0
    //   198: ifnull -177 -> 21
    //   201: aload_0
    //   202: invokevirtual 236	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   205: invokevirtual 241	java/io/OutputStream:close	()V
    //   208: aload_0
    //   209: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   212: invokevirtual 244	java/io/InputStream:close	()V
    //   215: aload_0
    //   216: invokevirtual 247	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   219: invokevirtual 244	java/io/InputStream:close	()V
    //   222: aload_3
    //   223: areturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   229: aload_3
    //   230: areturn
    //   231: bipush 6
    //   233: anewarray 176	java/lang/String
    //   236: astore_0
    //   237: aload_0
    //   238: iconst_0
    //   239: ldc 178
    //   241: aastore
    //   242: aload_0
    //   243: iconst_1
    //   244: ldc 180
    //   246: aastore
    //   247: aload_0
    //   248: iconst_2
    //   249: ldc 182
    //   251: aastore
    //   252: aload_0
    //   253: iconst_3
    //   254: ldc 184
    //   256: aastore
    //   257: aload_0
    //   258: iconst_4
    //   259: ldc 250
    //   261: aastore
    //   262: aload_0
    //   263: iconst_5
    //   264: aload_2
    //   265: aastore
    //   266: goto -214 -> 52
    //   269: aload 5
    //   271: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: astore_3
    //   275: aload_3
    //   276: astore_2
    //   277: aload_0
    //   278: ifnull -257 -> 21
    //   281: aload_0
    //   282: invokevirtual 236	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   285: invokevirtual 241	java/io/OutputStream:close	()V
    //   288: aload_0
    //   289: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   292: invokevirtual 244	java/io/InputStream:close	()V
    //   295: aload_0
    //   296: invokevirtual 247	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   299: invokevirtual 244	java/io/InputStream:close	()V
    //   302: aload_3
    //   303: areturn
    //   304: astore_0
    //   305: aload_0
    //   306: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   309: aload_3
    //   310: areturn
    //   311: astore_2
    //   312: aload_2
    //   313: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   316: goto -28 -> 288
    //   319: astore_2
    //   320: aload_2
    //   321: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   324: goto -29 -> 295
    //   327: astore_2
    //   328: aload_2
    //   329: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   332: goto -124 -> 208
    //   335: astore_2
    //   336: aload_2
    //   337: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   340: goto -125 -> 215
    //   343: astore_0
    //   344: aload_2
    //   345: ifnull +24 -> 369
    //   348: aload_2
    //   349: invokevirtual 236	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   352: invokevirtual 241	java/io/OutputStream:close	()V
    //   355: aload_2
    //   356: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   359: invokevirtual 244	java/io/InputStream:close	()V
    //   362: aload_2
    //   363: invokevirtual 247	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   366: invokevirtual 244	java/io/InputStream:close	()V
    //   369: aload_0
    //   370: athrow
    //   371: astore_3
    //   372: aload_3
    //   373: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   376: goto -21 -> 355
    //   379: astore_3
    //   380: aload_3
    //   381: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   384: goto -22 -> 362
    //   387: astore_2
    //   388: aload_2
    //   389: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   392: goto -23 -> 369
    //   395: astore_3
    //   396: aload_0
    //   397: astore_2
    //   398: aload_3
    //   399: astore_0
    //   400: goto -56 -> 344
    //   403: astore_3
    //   404: aload 4
    //   406: astore_0
    //   407: goto -262 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramContext	Context
    //   0	410	1	paramInt	int
    //   0	410	2	paramString	String
    //   97	8	3	str1	String
    //   144	30	3	localThrowable1	Throwable
    //   194	116	3	str2	String
    //   371	2	3	localIOException1	java.io.IOException
    //   379	2	3	localIOException2	java.io.IOException
    //   395	4	3	localObject1	Object
    //   403	1	3	localThrowable2	Throwable
    //   55	350	4	localObject2	Object
    //   64	206	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   74	93	144	java/lang/Throwable
    //   93	98	144	java/lang/Throwable
    //   102	114	144	java/lang/Throwable
    //   118	141	144	java/lang/Throwable
    //   269	275	144	java/lang/Throwable
    //   215	222	224	java/io/IOException
    //   295	302	304	java/io/IOException
    //   281	288	311	java/io/IOException
    //   288	295	319	java/io/IOException
    //   201	208	327	java/io/IOException
    //   208	215	335	java/io/IOException
    //   66	74	343	finally
    //   147	154	343	finally
    //   156	160	343	finally
    //   162	195	343	finally
    //   348	355	371	java/io/IOException
    //   355	362	379	java/io/IOException
    //   362	369	387	java/io/IOException
    //   74	93	395	finally
    //   93	98	395	finally
    //   102	114	395	finally
    //   118	141	395	finally
    //   269	275	395	finally
    //   66	74	403	java/lang/Throwable
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {
      return "";
    }
    if (a == null)
    {
      a = new HashMap();
      Object localObject = "/system/bin/sh";
      if ((!new File("/system/bin/sh").exists()) || (!new File("/system/bin/sh").canExecute())) {
        localObject = "sh";
      }
      localObject = a(paramContext, new String[] { localObject, "-c", "getprop" });
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        x.b(z.class, "Successfully get 'getprop' list.", new Object[0]);
        paramContext = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Matcher localMatcher = paramContext.matcher((String)((Iterator)localObject).next());
          if (localMatcher.find()) {
            a.put(localMatcher.group(1), localMatcher.group(2));
          }
        }
        x.b(z.class, "Systems properties number: %d.", new Object[] { Integer.valueOf(a.size()) });
      }
    }
    if (a.containsKey(paramString)) {
      return (String)a.get(paramString);
    }
    return "fail";
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +17 -> 18
    //   4: aload_0
    //   5: invokevirtual 36	java/io/File:exists	()Z
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokevirtual 39	java/io/File:canRead	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 186	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: new 41	java/io/BufferedReader
    //   32: dup
    //   33: new 43	java/io/InputStreamReader
    //   36: dup
    //   37: new 45	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: ldc 50
    //   47: invokespecial 53	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_3
    //   54: aload_3
    //   55: astore_0
    //   56: aload_3
    //   57: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +51 -> 115
    //   67: aload_3
    //   68: astore_0
    //   69: aload 4
    //   71: aload 5
    //   73: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 215
    //   78: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: iload_1
    //   83: ifle -29 -> 54
    //   86: aload_3
    //   87: astore_0
    //   88: aload 4
    //   90: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   93: iload_1
    //   94: if_icmple -40 -> 54
    //   97: iload_2
    //   98: ifeq +42 -> 140
    //   101: aload_3
    //   102: astore_0
    //   103: aload 4
    //   105: iload_1
    //   106: aload 4
    //   108: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   111: invokevirtual 223	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_3
    //   116: astore_0
    //   117: aload 4
    //   119: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 4
    //   124: aload_3
    //   125: invokevirtual 349	java/io/BufferedReader:close	()V
    //   128: aload 4
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   136: pop
    //   137: aload 4
    //   139: areturn
    //   140: aload_3
    //   141: astore_0
    //   142: aload 4
    //   144: iconst_0
    //   145: aload 4
    //   147: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   150: iload_1
    //   151: isub
    //   152: invokevirtual 223	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: goto -102 -> 54
    //   159: astore 4
    //   161: aload_3
    //   162: astore_0
    //   163: aload 4
    //   165: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   168: pop
    //   169: aload_3
    //   170: ifnull -152 -> 18
    //   173: aload_3
    //   174: invokevirtual 349	java/io/BufferedReader:close	()V
    //   177: aconst_null
    //   178: areturn
    //   179: astore_0
    //   180: aload_0
    //   181: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   184: pop
    //   185: aconst_null
    //   186: areturn
    //   187: astore_3
    //   188: aconst_null
    //   189: astore_0
    //   190: aload_0
    //   191: ifnull +7 -> 198
    //   194: aload_0
    //   195: invokevirtual 349	java/io/BufferedReader:close	()V
    //   198: aload_3
    //   199: athrow
    //   200: astore_0
    //   201: aload_0
    //   202: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   205: pop
    //   206: goto -8 -> 198
    //   209: astore_3
    //   210: goto -20 -> 190
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_3
    //   217: goto -56 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramFile	File
    //   0	220	1	paramInt	int
    //   0	220	2	paramBoolean	boolean
    //   53	121	3	localBufferedReader	BufferedReader
    //   187	12	3	localObject1	Object
    //   209	1	3	localObject2	Object
    //   216	1	3	localObject3	Object
    //   27	119	4	localObject4	Object
    //   159	5	4	localThrowable1	Throwable
    //   213	1	4	localThrowable2	Throwable
    //   60	12	5	str	String
    // Exception table:
    //   from	to	target	type
    //   124	128	131	java/lang/Exception
    //   56	62	159	java/lang/Throwable
    //   69	82	159	java/lang/Throwable
    //   88	97	159	java/lang/Throwable
    //   103	115	159	java/lang/Throwable
    //   117	124	159	java/lang/Throwable
    //   142	156	159	java/lang/Throwable
    //   173	177	179	java/lang/Exception
    //   20	54	187	finally
    //   194	198	200	java/lang/Exception
    //   56	62	209	finally
    //   69	82	209	finally
    //   88	97	209	finally
    //   103	115	209	finally
    //   117	124	209	finally
    //   142	156	209	finally
    //   163	169	209	finally
    //   20	54	213	java/lang/Throwable
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      paramThrowable = localStringWriter.getBuffer().toString();
      return paramThrowable;
    }
    catch (Throwable paramThrowable)
    {
      if (!x.a(paramThrowable)) {
        paramThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String a(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    try
    {
      paramDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate) {}
    return new Date().toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "NULL";
    }
    try
    {
      Object localObject = MessageDigest.getInstance("SHA-1");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      if (paramArrayOfByte == null) {
        return "";
      }
      localObject = new StringBuffer();
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        if (str.length() == 1) {
          ((StringBuffer)localObject).append("0");
        }
        ((StringBuffer)localObject).append(str);
        i += 1;
      }
      paramArrayOfByte = ((StringBuffer)localObject).toString().toUpperCase();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!x.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static Thread a(Runnable paramRunnable, String paramString)
  {
    try
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setName(paramString);
      paramRunnable.start();
      return paramRunnable;
    }
    catch (Throwable paramRunnable)
    {
      x.e("[Util] Failed to start a thread to execute task with message: %s", new Object[] { paramRunnable.getMessage() });
    }
    return null;
  }
  
  /* Error */
  private static ArrayList<String> a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 423	com/tencent/bugly/crashreport/common/info/AppInfo:e	(Landroid/content/Context;)Z
    //   6: ifeq +24 -> 30
    //   9: new 425	java/util/ArrayList
    //   12: dup
    //   13: iconst_1
    //   14: anewarray 176	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 427
    //   22: aastore
    //   23: invokestatic 433	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   26: invokespecial 436	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   29: areturn
    //   30: new 425	java/util/ArrayList
    //   33: dup
    //   34: invokespecial 437	java/util/ArrayList:<init>	()V
    //   37: astore 4
    //   39: invokestatic 193	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   42: aload_1
    //   43: invokevirtual 197	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   46: astore_0
    //   47: new 41	java/io/BufferedReader
    //   50: dup
    //   51: new 43	java/io/InputStreamReader
    //   54: dup
    //   55: aload_0
    //   56: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   59: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   62: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   65: astore_1
    //   66: aload_1
    //   67: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull +56 -> 128
    //   75: aload 4
    //   77: aload_2
    //   78: invokevirtual 440	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: goto -16 -> 66
    //   85: astore 4
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: astore_3
    //   91: aload_1
    //   92: astore_2
    //   93: aload 4
    //   95: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   98: ifne +12 -> 110
    //   101: aload_0
    //   102: astore_3
    //   103: aload_1
    //   104: astore_2
    //   105: aload 4
    //   107: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 349	java/io/BufferedReader:close	()V
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 349	java/io/BufferedReader:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: new 41	java/io/BufferedReader
    //   131: dup
    //   132: new 43	java/io/InputStreamReader
    //   135: dup
    //   136: aload_0
    //   137: invokevirtual 247	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   140: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   143: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   146: astore_0
    //   147: aload_0
    //   148: astore_3
    //   149: aload_1
    //   150: astore_2
    //   151: aload_0
    //   152: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   155: astore 5
    //   157: aload 5
    //   159: ifnull +23 -> 182
    //   162: aload_0
    //   163: astore_3
    //   164: aload_1
    //   165: astore_2
    //   166: aload 4
    //   168: aload 5
    //   170: invokevirtual 440	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   173: pop
    //   174: goto -27 -> 147
    //   177: astore 4
    //   179: goto -90 -> 89
    //   182: aload_1
    //   183: invokevirtual 349	java/io/BufferedReader:close	()V
    //   186: aload_0
    //   187: invokevirtual 349	java/io/BufferedReader:close	()V
    //   190: aload 4
    //   192: areturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   198: aload 4
    //   200: areturn
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   206: goto -20 -> 186
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   214: goto -96 -> 118
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   222: goto -96 -> 126
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_1
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 349	java/io/BufferedReader:close	()V
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 349	java/io/BufferedReader:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   251: goto -15 -> 236
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   259: goto -15 -> 244
    //   262: astore_0
    //   263: goto -35 -> 228
    //   266: astore_0
    //   267: aload_2
    //   268: astore_1
    //   269: goto -41 -> 228
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_1
    //   278: goto -189 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramContext	Context
    //   0	281	1	paramArrayOfString	String[]
    //   70	198	2	localObject	Object
    //   1	240	3	localContext	Context
    //   37	39	4	localArrayList	ArrayList
    //   85	82	4	localThrowable1	Throwable
    //   177	22	4	localThrowable2	Throwable
    //   272	1	4	localThrowable3	Throwable
    //   155	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   66	71	85	java/lang/Throwable
    //   75	82	85	java/lang/Throwable
    //   128	147	85	java/lang/Throwable
    //   151	157	177	java/lang/Throwable
    //   166	174	177	java/lang/Throwable
    //   186	190	193	java/io/IOException
    //   182	186	201	java/io/IOException
    //   114	118	209	java/io/IOException
    //   122	126	217	java/io/IOException
    //   39	66	225	finally
    //   232	236	246	java/io/IOException
    //   240	244	254	java/io/IOException
    //   66	71	262	finally
    //   75	82	262	finally
    //   128	147	262	finally
    //   93	101	266	finally
    //   105	110	266	finally
    //   151	157	266	finally
    //   166	174	266	finally
    //   39	66	272	java/lang/Throwable
  }
  
  public static Map<String, String> a(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap(12);
    Object localObject2 = Thread.getAllStackTraces();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = Looper.getMainLooper().getThread();
    if (!((Map)localObject2).containsKey(localObject1)) {
      ((Map)localObject2).put(localObject1, ((Thread)localObject1).getStackTrace());
    }
    Thread.currentThread().getId();
    localObject1 = new StringBuilder();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).setLength(0);
      if ((localEntry.getValue() != null) && (((StackTraceElement[])localEntry.getValue()).length != 0))
      {
        StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])localEntry.getValue();
        int j = arrayOfStackTraceElement.length;
        int i = 0;
        for (;;)
        {
          StackTraceElement localStackTraceElement;
          if (i < j)
          {
            localStackTraceElement = arrayOfStackTraceElement[i];
            if ((paramInt > 0) && (((StringBuilder)localObject1).length() >= paramInt)) {
              ((StringBuilder)localObject1).append("\n[Stack over limit size :" + paramInt + " , has been cut!]");
            }
          }
          else
          {
            localHashMap.put(((Thread)localEntry.getKey()).getName() + "(" + ((Thread)localEntry.getKey()).getId() + ")", ((StringBuilder)localObject1).toString());
            break;
          }
          ((StringBuilder)localObject1).append(localStackTraceElement.toString()).append("\n");
          i += 1;
        }
      }
    }
    return localHashMap;
  }
  
  public static Map<String, PlugInBean> a(Parcel paramParcel)
  {
    paramParcel = paramParcel.readBundle();
    if (paramParcel == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = ((Integer)paramParcel.get("pluginNum")).intValue();
    int i = 0;
    while (i < j)
    {
      localArrayList1.add(paramParcel.getString("pluginKey" + i));
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      String str1 = paramParcel.getString("pluginVal" + i + "plugInId");
      String str2 = paramParcel.getString("pluginVal" + i + "plugInUUID");
      localArrayList2.add(new PlugInBean(str1, paramParcel.getString("pluginVal" + i + "plugInVersion"), str2));
      i += 1;
    }
    if (localArrayList1.size() == localArrayList2.size())
    {
      paramParcel = new HashMap(localArrayList1.size());
      i = 0;
      while (i < localArrayList1.size())
      {
        paramParcel.put(localArrayList1.get(i), PlugInBean.class.cast(localArrayList2.get(i)));
        i += 1;
      }
    }
    for (;;)
    {
      return paramParcel;
      x.e("map plugin parcel error!", new Object[0]);
      paramParcel = null;
    }
  }
  
  public static void a(Parcel paramParcel, Map<String, PlugInBean> paramMap)
  {
    int k = 0;
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      paramParcel.writeBundle(null);
      return;
    }
    int i = paramMap.size();
    ArrayList localArrayList1 = new ArrayList(i);
    ArrayList localArrayList2 = new ArrayList(i);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList1.add(localEntry.getKey());
      localArrayList2.add(localEntry.getValue());
    }
    paramMap = new Bundle();
    paramMap.putInt("pluginNum", localArrayList1.size());
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= localArrayList1.size()) {
        break;
      }
      paramMap.putString("pluginKey" + i, (String)localArrayList1.get(i));
      i += 1;
    }
    while (j < localArrayList1.size())
    {
      paramMap.putString("pluginVal" + j + "plugInId", ((PlugInBean)localArrayList2.get(j)).a);
      paramMap.putString("pluginVal" + j + "plugInUUID", ((PlugInBean)localArrayList2.get(j)).c);
      paramMap.putString("pluginVal" + j + "plugInVersion", ((PlugInBean)localArrayList2.get(j)).b);
      j += 1;
    }
    paramParcel.writeBundle(paramMap);
  }
  
  public static void a(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass.set(null, paramObject1);
      return;
    }
    catch (Exception paramClass) {}
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 595
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: aload_0
    //   10: aastore
    //   11: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: aload_1
    //   16: ifnull +13 -> 29
    //   19: aload_1
    //   20: invokevirtual 254	java/lang/String:trim	()Ljava/lang/String;
    //   23: invokevirtual 392	java/lang/String:length	()I
    //   26: ifgt +4 -> 30
    //   29: return
    //   30: new 32	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 6
    //   40: aload 6
    //   42: invokevirtual 36	java/io/File:exists	()Z
    //   45: ifne +26 -> 71
    //   48: aload 6
    //   50: invokevirtual 601	java/io/File:getParentFile	()Ljava/io/File;
    //   53: ifnull +12 -> 65
    //   56: aload 6
    //   58: invokevirtual 601	java/io/File:getParentFile	()Ljava/io/File;
    //   61: invokevirtual 604	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload 6
    //   67: invokevirtual 607	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: aconst_null
    //   72: astore 5
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: astore 4
    //   79: aload 5
    //   81: astore_3
    //   82: aload 6
    //   84: invokevirtual 609	java/io/File:length	()J
    //   87: iload_2
    //   88: i2l
    //   89: lcmp
    //   90: iflt +61 -> 151
    //   93: aload_0
    //   94: astore 4
    //   96: aload 5
    //   98: astore_3
    //   99: new 611	java/io/FileOutputStream
    //   102: dup
    //   103: aload 6
    //   105: iconst_0
    //   106: invokespecial 614	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   109: astore_0
    //   110: aload_0
    //   111: astore 4
    //   113: aload_0
    //   114: astore_3
    //   115: aload_0
    //   116: aload_1
    //   117: ldc_w 616
    //   120: invokevirtual 620	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   123: invokevirtual 623	java/io/FileOutputStream:write	([B)V
    //   126: aload_0
    //   127: astore 4
    //   129: aload_0
    //   130: astore_3
    //   131: aload_0
    //   132: invokevirtual 626	java/io/FileOutputStream:flush	()V
    //   135: aload_0
    //   136: invokevirtual 627	java/io/FileOutputStream:close	()V
    //   139: ldc_w 629
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   149: pop
    //   150: return
    //   151: aload_0
    //   152: astore 4
    //   154: aload 5
    //   156: astore_3
    //   157: new 611	java/io/FileOutputStream
    //   160: dup
    //   161: aload 6
    //   163: iconst_1
    //   164: invokespecial 614	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   167: astore_0
    //   168: goto -58 -> 110
    //   171: astore_0
    //   172: aload 4
    //   174: astore_3
    //   175: aload_0
    //   176: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   179: ifne +10 -> 189
    //   182: aload 4
    //   184: astore_3
    //   185: aload_0
    //   186: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   189: aload 4
    //   191: ifnull -52 -> 139
    //   194: aload 4
    //   196: invokevirtual 627	java/io/FileOutputStream:close	()V
    //   199: goto -60 -> 139
    //   202: astore_0
    //   203: aload_0
    //   204: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   207: ifne -68 -> 139
    //   210: aload_0
    //   211: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   214: goto -75 -> 139
    //   217: astore_0
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 627	java/io/FileOutputStream:close	()V
    //   226: aload_0
    //   227: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramString1	String
    //   0	228	1	paramString2	String
    //   0	228	2	paramInt	int
    //   81	142	3	localObject1	Object
    //   77	118	4	str	String
    //   72	83	5	localObject2	Object
    //   38	124	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   82	93	171	java/lang/Throwable
    //   99	110	171	java/lang/Throwable
    //   115	126	171	java/lang/Throwable
    //   131	135	171	java/lang/Throwable
    //   157	168	171	java/lang/Throwable
    //   40	65	202	java/lang/Throwable
    //   65	71	202	java/lang/Throwable
    //   135	139	202	java/lang/Throwable
    //   194	199	202	java/lang/Throwable
    //   222	226	202	java/lang/Throwable
    //   226	228	202	java/lang/Throwable
    //   82	93	217	finally
    //   99	110	217	finally
    //   115	126	217	finally
    //   131	135	217	finally
    //   157	168	217	finally
    //   175	182	217	finally
    //   185	189	217	finally
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    x.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try
    {
      File localFile = new File(paramContext.getFilesDir() + File.separator + paramString);
      if (localFile.exists())
      {
        if (System.currentTimeMillis() - localFile.lastModified() < 10000L) {
          return false;
        }
        x.c("[Util] Lock file (%s) is expired, unlock it.", new Object[] { paramString });
        b(paramContext, paramString);
      }
      if (localFile.createNewFile())
      {
        x.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        return true;
      }
      x.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return false;
    }
    catch (Throwable paramContext)
    {
      x.a(paramContext);
    }
    return false;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 665
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: aload_0
    //   15: ifnull +15 -> 30
    //   18: aload_1
    //   19: ifnull +11 -> 30
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 666	java/io/File:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +16 -> 43
    //   30: ldc_w 668
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokestatic 174	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   40: pop
    //   41: iconst_0
    //   42: ireturn
    //   43: aload_0
    //   44: invokevirtual 36	java/io/File:exists	()Z
    //   47: ifeq +10 -> 57
    //   50: aload_0
    //   51: invokevirtual 39	java/io/File:canRead	()Z
    //   54: ifne +16 -> 70
    //   57: ldc_w 670
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokestatic 174	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: iconst_0
    //   69: ireturn
    //   70: aload_1
    //   71: invokevirtual 601	java/io/File:getParentFile	()Ljava/io/File;
    //   74: ifnull +21 -> 95
    //   77: aload_1
    //   78: invokevirtual 601	java/io/File:getParentFile	()Ljava/io/File;
    //   81: invokevirtual 36	java/io/File:exists	()Z
    //   84: ifne +11 -> 95
    //   87: aload_1
    //   88: invokevirtual 601	java/io/File:getParentFile	()Ljava/io/File;
    //   91: invokevirtual 604	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload_1
    //   96: invokevirtual 36	java/io/File:exists	()Z
    //   99: ifne +8 -> 107
    //   102: aload_1
    //   103: invokevirtual 607	java/io/File:createNewFile	()Z
    //   106: pop
    //   107: aload_1
    //   108: invokevirtual 36	java/io/File:exists	()Z
    //   111: ifeq -70 -> 41
    //   114: aload_1
    //   115: invokevirtual 39	java/io/File:canRead	()Z
    //   118: ifeq -77 -> 41
    //   121: new 45	java/io/FileInputStream
    //   124: dup
    //   125: aload_0
    //   126: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore_3
    //   130: new 672	java/util/zip/ZipOutputStream
    //   133: dup
    //   134: new 674	java/io/BufferedOutputStream
    //   137: dup
    //   138: new 611	java/io/FileOutputStream
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 675	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   146: invokespecial 678	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   149: invokespecial 679	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   152: astore 4
    //   154: aload 4
    //   156: bipush 8
    //   158: invokevirtual 682	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   161: aload 4
    //   163: new 684	java/util/zip/ZipEntry
    //   166: dup
    //   167: aload_0
    //   168: invokevirtual 685	java/io/File:getName	()Ljava/lang/String;
    //   171: invokespecial 686	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   174: invokevirtual 690	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   177: sipush 5000
    //   180: newarray byte
    //   182: astore_0
    //   183: aload_3
    //   184: aload_0
    //   185: invokevirtual 694	java/io/FileInputStream:read	([B)I
    //   188: istore_2
    //   189: iload_2
    //   190: ifle +79 -> 269
    //   193: aload 4
    //   195: aload_0
    //   196: iconst_0
    //   197: iload_2
    //   198: invokevirtual 696	java/util/zip/ZipOutputStream:write	([BII)V
    //   201: goto -18 -> 183
    //   204: astore 5
    //   206: aload_3
    //   207: astore_1
    //   208: aload 4
    //   210: astore_0
    //   211: aload 5
    //   213: astore_3
    //   214: aload_3
    //   215: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   218: ifne +7 -> 225
    //   221: aload_3
    //   222: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   225: aload_1
    //   226: ifnull +7 -> 233
    //   229: aload_1
    //   230: invokevirtual 697	java/io/FileInputStream:close	()V
    //   233: aload_0
    //   234: ifnull +7 -> 241
    //   237: aload_0
    //   238: invokevirtual 698	java/util/zip/ZipOutputStream:close	()V
    //   241: ldc_w 700
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: iconst_0
    //   253: ireturn
    //   254: astore_3
    //   255: aload_3
    //   256: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   259: ifne -152 -> 107
    //   262: aload_3
    //   263: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   266: goto -159 -> 107
    //   269: aload 4
    //   271: invokevirtual 701	java/util/zip/ZipOutputStream:flush	()V
    //   274: aload 4
    //   276: invokevirtual 704	java/util/zip/ZipOutputStream:closeEntry	()V
    //   279: aload_3
    //   280: invokevirtual 697	java/io/FileInputStream:close	()V
    //   283: aload 4
    //   285: invokevirtual 698	java/util/zip/ZipOutputStream:close	()V
    //   288: ldc_w 700
    //   291: iconst_0
    //   292: anewarray 4	java/lang/Object
    //   295: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   298: pop
    //   299: iconst_1
    //   300: ireturn
    //   301: astore_0
    //   302: aload_0
    //   303: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   306: goto -23 -> 283
    //   309: astore_0
    //   310: aload_0
    //   311: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   314: goto -26 -> 288
    //   317: astore_1
    //   318: aload_1
    //   319: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   322: goto -89 -> 233
    //   325: astore_0
    //   326: aload_0
    //   327: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   330: goto -89 -> 241
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_0
    //   336: aconst_null
    //   337: astore_3
    //   338: aload_3
    //   339: ifnull +7 -> 346
    //   342: aload_3
    //   343: invokevirtual 697	java/io/FileInputStream:close	()V
    //   346: aload_0
    //   347: ifnull +7 -> 354
    //   350: aload_0
    //   351: invokevirtual 698	java/util/zip/ZipOutputStream:close	()V
    //   354: ldc_w 700
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   364: pop
    //   365: aload_1
    //   366: athrow
    //   367: astore_3
    //   368: aload_3
    //   369: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   372: goto -26 -> 346
    //   375: astore_0
    //   376: aload_0
    //   377: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   380: goto -26 -> 354
    //   383: astore_1
    //   384: aconst_null
    //   385: astore_0
    //   386: goto -48 -> 338
    //   389: astore_1
    //   390: aload 4
    //   392: astore_0
    //   393: goto -55 -> 338
    //   396: astore 4
    //   398: aload_1
    //   399: astore_3
    //   400: aload 4
    //   402: astore_1
    //   403: goto -65 -> 338
    //   406: astore_3
    //   407: aconst_null
    //   408: astore_0
    //   409: aload 4
    //   411: astore_1
    //   412: goto -198 -> 214
    //   415: astore 4
    //   417: aconst_null
    //   418: astore_0
    //   419: aload_3
    //   420: astore_1
    //   421: aload 4
    //   423: astore_3
    //   424: goto -210 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	paramFile1	File
    //   0	427	1	paramFile2	File
    //   0	427	2	paramInt	int
    //   129	93	3	localObject1	Object
    //   254	26	3	localThrowable1	Throwable
    //   337	6	3	localObject2	Object
    //   367	2	3	localIOException	java.io.IOException
    //   399	1	3	localFile	File
    //   406	14	3	localThrowable2	Throwable
    //   423	1	3	localThrowable3	Throwable
    //   1	390	4	localZipOutputStream	java.util.zip.ZipOutputStream
    //   396	14	4	localObject3	Object
    //   415	7	4	localThrowable4	Throwable
    //   204	8	5	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   154	183	204	java/lang/Throwable
    //   183	189	204	java/lang/Throwable
    //   193	201	204	java/lang/Throwable
    //   269	279	204	java/lang/Throwable
    //   70	95	254	java/lang/Throwable
    //   95	107	254	java/lang/Throwable
    //   279	283	301	java/io/IOException
    //   283	288	309	java/io/IOException
    //   229	233	317	java/io/IOException
    //   237	241	325	java/io/IOException
    //   121	130	333	finally
    //   342	346	367	java/io/IOException
    //   350	354	375	java/io/IOException
    //   130	154	383	finally
    //   154	183	389	finally
    //   183	189	389	finally
    //   193	201	389	finally
    //   269	279	389	finally
    //   214	225	396	finally
    //   121	130	406	java/lang/Throwable
    //   130	154	415	java/lang/Throwable
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Object localObject = w.a();
      if (localObject != null) {
        return ((w)localObject).a(paramRunnable);
      }
      localObject = paramRunnable.getClass().getName().split("\\.");
      if (a(paramRunnable, localObject[(localObject.length - 1)]) != null) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() <= 0);
  }
  
  public static byte[] a(Parcelable paramParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return paramParcelable;
  }
  
  /* Error */
  public static byte[] a(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 392	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: ldc_w 665
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: new 739	java/io/ByteArrayInputStream
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 616
    //   32: invokevirtual 620	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   35: invokespecial 741	java/io/ByteArrayInputStream:<init>	([B)V
    //   38: astore 4
    //   40: new 743	java/io/ByteArrayOutputStream
    //   43: dup
    //   44: invokespecial 744	java/io/ByteArrayOutputStream:<init>	()V
    //   47: astore 5
    //   49: new 672	java/util/zip/ZipOutputStream
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 679	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: aload_1
    //   62: bipush 8
    //   64: invokevirtual 682	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   67: aload_1
    //   68: astore_0
    //   69: aload_1
    //   70: new 684	java/util/zip/ZipEntry
    //   73: dup
    //   74: aload_2
    //   75: invokespecial 686	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 690	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   81: aload_1
    //   82: astore_0
    //   83: sipush 1024
    //   86: newarray byte
    //   88: astore_2
    //   89: aload_1
    //   90: astore_0
    //   91: aload 4
    //   93: aload_2
    //   94: invokevirtual 745	java/io/ByteArrayInputStream:read	([B)I
    //   97: istore_3
    //   98: iload_3
    //   99: ifle +52 -> 151
    //   102: aload_1
    //   103: astore_0
    //   104: aload_1
    //   105: aload_2
    //   106: iconst_0
    //   107: iload_3
    //   108: invokevirtual 696	java/util/zip/ZipOutputStream:write	([BII)V
    //   111: goto -22 -> 89
    //   114: astore_2
    //   115: aload_1
    //   116: astore_0
    //   117: aload_2
    //   118: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   121: ifne +9 -> 130
    //   124: aload_1
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 698	java/util/zip/ZipOutputStream:close	()V
    //   138: ldc_w 700
    //   141: iconst_0
    //   142: anewarray 4	java/lang/Object
    //   145: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   148: pop
    //   149: aconst_null
    //   150: areturn
    //   151: aload_1
    //   152: astore_0
    //   153: aload_1
    //   154: invokevirtual 704	java/util/zip/ZipOutputStream:closeEntry	()V
    //   157: aload_1
    //   158: astore_0
    //   159: aload_1
    //   160: invokevirtual 701	java/util/zip/ZipOutputStream:flush	()V
    //   163: aload_1
    //   164: astore_0
    //   165: aload_1
    //   166: invokevirtual 748	java/util/zip/ZipOutputStream:finish	()V
    //   169: aload_1
    //   170: astore_0
    //   171: aload 5
    //   173: invokevirtual 751	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   176: astore_2
    //   177: aload_1
    //   178: invokevirtual 698	java/util/zip/ZipOutputStream:close	()V
    //   181: ldc_w 700
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   191: pop
    //   192: aload_2
    //   193: areturn
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   199: goto -18 -> 181
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   207: goto -69 -> 138
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_0
    //   213: aload_0
    //   214: ifnull +7 -> 221
    //   217: aload_0
    //   218: invokevirtual 698	java/util/zip/ZipOutputStream:close	()V
    //   221: ldc_w 700
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 597	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   231: pop
    //   232: aload_1
    //   233: athrow
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   239: goto -18 -> 221
    //   242: astore_1
    //   243: goto -30 -> 213
    //   246: astore_2
    //   247: aconst_null
    //   248: astore_1
    //   249: goto -134 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramFile	File
    //   0	252	1	paramString1	String
    //   0	252	2	paramString2	String
    //   97	11	3	i	int
    //   38	54	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   47	125	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   61	67	114	java/lang/Throwable
    //   69	81	114	java/lang/Throwable
    //   83	89	114	java/lang/Throwable
    //   91	98	114	java/lang/Throwable
    //   104	111	114	java/lang/Throwable
    //   153	157	114	java/lang/Throwable
    //   159	163	114	java/lang/Throwable
    //   165	169	114	java/lang/Throwable
    //   171	177	114	java/lang/Throwable
    //   177	181	194	java/io/IOException
    //   134	138	202	java/io/IOException
    //   24	59	210	finally
    //   217	221	234	java/io/IOException
    //   61	67	242	finally
    //   69	81	242	finally
    //   83	89	242	finally
    //   91	98	242	finally
    //   104	111	242	finally
    //   117	124	242	finally
    //   126	130	242	finally
    //   153	157	242	finally
    //   159	163	242	finally
    //   165	169	242	finally
    //   171	177	242	finally
    //   24	59	246	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    x.c("[Util] Zip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), "Gzip" });
    try
    {
      ae localae = ad.a(2);
      if (localae == null) {
        return null;
      }
      paramArrayOfByte = localae.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!x.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static long b()
  {
    try
    {
      long l = (System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000L;
      int i = TimeZone.getDefault().getRawOffset();
      return l * 86400000L - i;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static long b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(new String(paramArrayOfByte, "utf-8"));
      return l;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1L;
  }
  
  public static String b(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return localStringWriter.toString();
  }
  
  public static Map<String, String> b(Parcel paramParcel)
  {
    int i = 0;
    paramParcel = paramParcel.readBundle();
    if (paramParcel == null) {
      return null;
    }
    ArrayList localArrayList1 = paramParcel.getStringArrayList("keys");
    ArrayList localArrayList2 = paramParcel.getStringArrayList("values");
    if ((localArrayList1 != null) && (localArrayList2 != null) && (localArrayList1.size() == localArrayList2.size()))
    {
      paramParcel = new HashMap(localArrayList1.size());
      while (i < localArrayList1.size())
      {
        paramParcel.put(localArrayList1.get(i), localArrayList2.get(i));
        i += 1;
      }
    }
    for (;;)
    {
      return paramParcel;
      x.e("map parcel error!", new Object[0]);
      paramParcel = null;
    }
  }
  
  public static void b(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public static void b(Parcel paramParcel, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      paramParcel.writeBundle(null);
      return;
    }
    int i = paramMap.size();
    ArrayList localArrayList1 = new ArrayList(i);
    ArrayList localArrayList2 = new ArrayList(i);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList1.add(localEntry.getKey());
      localArrayList2.add(localEntry.getValue());
    }
    paramMap = new Bundle();
    paramMap.putStringArrayList("keys", localArrayList1);
    paramMap.putStringArrayList("values", localArrayList2);
    paramParcel.writeBundle(paramMap);
  }
  
  public static void b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = new File(paramString);
    } while ((!paramString.isFile()) || (!paramString.exists()) || (!paramString.canWrite()));
    paramString.delete();
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((a.b() != null) && (a.b().F != null)) {
      a.b().F.edit().putString(paramString1, paramString2).apply();
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    x.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try
    {
      paramContext = new File(paramContext.getFilesDir() + File.separator + paramString);
      if (paramContext.exists())
      {
        if (paramContext.delete()) {
          x.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        }
      }
      else {
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      x.a(paramContext);
    }
    return false;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    x.c("[Util] Unzip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), "Gzip" });
    try
    {
      ae localae = ad.a(2);
      if (localae == null) {
        return null;
      }
      paramArrayOfByte = localae.b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (paramArrayOfByte.getMessage() == null) {
        break label87;
      }
    }
    if (paramArrayOfByte.getMessage().contains("Not in GZIP format")) {
      x.d(paramArrayOfByte.getMessage(), new Object[0]);
    }
    for (;;)
    {
      return null;
      label87:
      if (!x.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static String c(String paramString1, String paramString2)
  {
    if ((a.b() != null) && (a.b().F != null)) {
      return a.b().F.getString(paramString1, paramString2);
    }
    return "";
  }
  
  public static boolean c(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {}
    for (int i = 0; i != 0; i = 1) {
      return false;
    }
    if (paramString.length() > 255)
    {
      x.a("URL(%s)'s length is larger than 255.", new Object[] { paramString });
      return false;
    }
    if (!paramString.toLowerCase().startsWith("http"))
    {
      x.a("URL(%s) is not start with \"http\".", new Object[] { paramString });
      return false;
    }
    return true;
  }
  
  public static byte[] c(long paramLong)
  {
    try
    {
      byte[] arrayOfByte = paramLong.getBytes("utf-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.z
 * JD-Core Version:    0.7.0.1
 */