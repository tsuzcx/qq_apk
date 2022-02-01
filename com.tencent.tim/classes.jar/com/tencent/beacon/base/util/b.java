package com.tencent.beacon.base.util;

import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.b.d;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.base.net.b.a;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  private static final Random a = new Random();
  private static final AtomicInteger b = new AtomicInteger(0);
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1;
    if (paramString != null) {}
    try
    {
      i = Integer.parseInt(paramString);
      j = paramInt1;
      if (i >= paramInt2)
      {
        j = paramInt1;
        if (i <= paramInt3) {
          j = i;
        }
      }
      return j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        c.a(paramString);
        int i = paramInt1;
      }
    }
  }
  
  public static long a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    long l2 = paramLong1;
    if (paramString != null) {}
    try
    {
      l1 = Long.parseLong(paramString);
      l2 = paramLong1;
      if (l1 >= paramLong2)
      {
        l2 = paramLong1;
        if (l1 <= paramLong3) {
          l2 = l1;
        }
      }
      return l2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        c.a(paramString);
        long l1 = paramLong1;
      }
    }
  }
  
  /* Error */
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 51	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 54	java/io/ByteArrayInputStream:<init>	([B)V
    //   16: astore_3
    //   17: new 56	java/io/ObjectInputStream
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 59	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_1
    //   29: invokevirtual 63	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_2
    //   33: iconst_1
    //   34: anewarray 65	java/io/Closeable
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   44: iconst_1
    //   45: anewarray 65	java/io/Closeable
    //   48: dup
    //   49: iconst_0
    //   50: aload_3
    //   51: aastore
    //   52: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   55: aload_2
    //   56: areturn
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: aload_2
    //   63: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   66: aload_1
    //   67: astore_0
    //   68: aload_2
    //   69: invokevirtual 72	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   72: iconst_0
    //   73: anewarray 4	java/lang/Object
    //   76: invokestatic 75	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: iconst_1
    //   80: anewarray 65	java/io/Closeable
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   90: iconst_1
    //   91: anewarray 65	java/io/Closeable
    //   94: dup
    //   95: iconst_0
    //   96: aload_3
    //   97: aastore
    //   98: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_2
    //   104: aload_0
    //   105: astore_1
    //   106: aload_2
    //   107: astore_0
    //   108: iconst_1
    //   109: anewarray 65	java/io/Closeable
    //   112: dup
    //   113: iconst_0
    //   114: aload_1
    //   115: aastore
    //   116: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   119: iconst_1
    //   120: anewarray 65	java/io/Closeable
    //   123: dup
    //   124: iconst_0
    //   125: aload_3
    //   126: aastore
    //   127: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   130: aload_0
    //   131: athrow
    //   132: astore_2
    //   133: goto -73 -> 60
    //   136: astore_0
    //   137: aload_2
    //   138: astore_1
    //   139: goto -31 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramArrayOfByte	byte[]
    //   25	114	1	localObject1	Object
    //   1	55	2	localObject2	Object
    //   57	12	2	localThrowable1	Throwable
    //   103	4	2	localObject3	Object
    //   132	6	2	localThrowable2	Throwable
    //   16	110	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   17	26	57	java/lang/Throwable
    //   28	33	103	finally
    //   62	66	103	finally
    //   68	79	103	finally
    //   28	33	132	java/lang/Throwable
    //   17	26	136	finally
  }
  
  public static String a()
  {
    return a(16);
  }
  
  private static String a(int paramInt)
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("abcdef0123456789".charAt(localRandom.nextInt(16)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      paramThrowable = "";
    }
    Object localObject;
    do
    {
      return paramThrowable;
      localObject = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter((Writer)localObject));
      localObject = (paramThrowable.getMessage() + "\n" + ((StringWriter)localObject).getBuffer().toString()).replace("\t", " ").replace("\n", " ").replace("$", "-");
      paramThrowable = (Throwable)localObject;
    } while (((String)localObject).length() <= 10240);
    return ((String)localObject).substring(0, 10240);
  }
  
  /* Error */
  public static ArrayList<String> a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 151	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 152	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 158	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: aload_0
    //   15: invokevirtual 162	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 168	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   23: astore_1
    //   24: new 170	java/io/BufferedReader
    //   27: dup
    //   28: new 172	java/io/InputStreamReader
    //   31: dup
    //   32: aload_1
    //   33: ldc 174
    //   35: invokestatic 180	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   38: invokespecial 183	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   41: invokespecial 186	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual 189	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +50 -> 101
    //   54: aload 4
    //   56: aload_3
    //   57: invokevirtual 193	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: goto -16 -> 45
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_1
    //   69: astore_2
    //   70: aload_0
    //   71: astore_3
    //   72: aload 4
    //   74: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   77: iconst_1
    //   78: anewarray 65	java/io/Closeable
    //   81: dup
    //   82: iconst_0
    //   83: aload_1
    //   84: aastore
    //   85: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   88: iconst_1
    //   89: anewarray 65	java/io/Closeable
    //   92: dup
    //   93: iconst_0
    //   94: aload_0
    //   95: aastore
    //   96: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   99: aconst_null
    //   100: areturn
    //   101: aload_0
    //   102: invokevirtual 196	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   105: astore_0
    //   106: new 170	java/io/BufferedReader
    //   109: dup
    //   110: new 172	java/io/InputStreamReader
    //   113: dup
    //   114: aload_0
    //   115: ldc 174
    //   117: invokestatic 180	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   120: invokespecial 183	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   123: invokespecial 186	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   126: astore_0
    //   127: aload_1
    //   128: astore_2
    //   129: aload_0
    //   130: astore_3
    //   131: aload_0
    //   132: invokevirtual 189	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +23 -> 162
    //   142: aload_1
    //   143: astore_2
    //   144: aload_0
    //   145: astore_3
    //   146: aload 4
    //   148: aload 5
    //   150: invokevirtual 193	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   153: pop
    //   154: goto -27 -> 127
    //   157: astore 4
    //   159: goto -91 -> 68
    //   162: iconst_1
    //   163: anewarray 65	java/io/Closeable
    //   166: dup
    //   167: iconst_0
    //   168: aload_1
    //   169: aastore
    //   170: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   173: iconst_1
    //   174: anewarray 65	java/io/Closeable
    //   177: dup
    //   178: iconst_0
    //   179: aload_0
    //   180: aastore
    //   181: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   184: aload 4
    //   186: areturn
    //   187: astore_0
    //   188: aconst_null
    //   189: astore_1
    //   190: iconst_1
    //   191: anewarray 65	java/io/Closeable
    //   194: dup
    //   195: iconst_0
    //   196: aload_1
    //   197: aastore
    //   198: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   201: iconst_1
    //   202: anewarray 65	java/io/Closeable
    //   205: dup
    //   206: iconst_0
    //   207: aload_2
    //   208: aastore
    //   209: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   212: aload_0
    //   213: athrow
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_1
    //   218: aconst_null
    //   219: astore_0
    //   220: goto -152 -> 68
    //   223: astore_0
    //   224: aload_2
    //   225: astore_1
    //   226: aload_3
    //   227: astore_2
    //   228: goto -38 -> 190
    //   231: astore_0
    //   232: goto -42 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramArrayOfString	String[]
    //   23	203	1	localObject1	Object
    //   1	227	2	localObject2	Object
    //   49	178	3	localObject3	Object
    //   9	46	4	localArrayList	ArrayList
    //   64	83	4	localThrowable1	Throwable
    //   157	28	4	localThrowable2	Throwable
    //   214	1	4	localThrowable3	Throwable
    //   135	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   45	50	64	java/lang/Throwable
    //   54	61	64	java/lang/Throwable
    //   101	106	64	java/lang/Throwable
    //   106	127	64	java/lang/Throwable
    //   131	137	157	java/lang/Throwable
    //   146	154	157	java/lang/Throwable
    //   11	24	187	finally
    //   24	45	187	finally
    //   11	24	214	java/lang/Throwable
    //   24	45	214	java/lang/Throwable
    //   72	77	223	finally
    //   131	137	223	finally
    //   146	154	223	finally
    //   45	50	231	finally
    //   54	61	231	finally
    //   101	106	231	finally
    //   106	127	231	finally
  }
  
  public static HashSet<String> a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      HashSet localHashSet = new HashSet(paramArrayList.size());
      localHashSet.addAll(paramArrayList);
      return localHashSet;
    }
    return null;
  }
  
  public static void a(Closeable... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Closeable localCloseable = paramVarArgs[i];
        if (localCloseable != null) {}
        try
        {
          localCloseable.close();
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            c.a(localException);
          }
        }
      }
    }
  }
  
  public static boolean a(SharedPreferences.Editor paramEditor)
  {
    if (paramEditor == null)
    {
      c.b("BeaconProperties editor is null!", new Object[0]);
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return paramString.startsWith("rqd_");
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      if (!paramString.toLowerCase().equals("y")) {
        break label22;
      }
      bool = true;
    }
    label22:
    do
    {
      return bool;
      bool = paramBoolean;
    } while (!paramString.toLowerCase().equals("n"));
    return false;
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: instanceof 236
    //   6: ifne +14 -> 20
    //   9: ldc 238
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 75	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aconst_null
    //   19: areturn
    //   20: new 240	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 241	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore 4
    //   29: new 243	java/io/ObjectOutputStream
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 246	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: aload_0
    //   43: invokevirtual 250	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 253	java/io/ObjectOutputStream:flush	()V
    //   52: aload_2
    //   53: astore_1
    //   54: aload 4
    //   56: invokevirtual 257	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   59: astore_0
    //   60: iconst_1
    //   61: anewarray 65	java/io/Closeable
    //   64: dup
    //   65: iconst_0
    //   66: aload_2
    //   67: aastore
    //   68: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   71: iconst_1
    //   72: anewarray 65	java/io/Closeable
    //   75: dup
    //   76: iconst_0
    //   77: aload 4
    //   79: aastore
    //   80: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   83: aload_0
    //   84: areturn
    //   85: astore_3
    //   86: aconst_null
    //   87: astore_0
    //   88: aload_0
    //   89: astore_1
    //   90: aload_3
    //   91: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: astore_1
    //   96: aload_3
    //   97: invokevirtual 72	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokestatic 75	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: iconst_1
    //   108: anewarray 65	java/io/Closeable
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: aastore
    //   115: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   118: iconst_1
    //   119: anewarray 65	java/io/Closeable
    //   122: dup
    //   123: iconst_0
    //   124: aload 4
    //   126: aastore
    //   127: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_0
    //   133: iconst_1
    //   134: anewarray 65	java/io/Closeable
    //   137: dup
    //   138: iconst_0
    //   139: aload_1
    //   140: aastore
    //   141: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   144: iconst_1
    //   145: anewarray 65	java/io/Closeable
    //   148: dup
    //   149: iconst_0
    //   150: aload 4
    //   152: aastore
    //   153: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: goto -26 -> 133
    //   162: astore_3
    //   163: aload_2
    //   164: astore_0
    //   165: goto -77 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramObject	Object
    //   1	139	1	localObject	Object
    //   38	126	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   85	12	3	localThrowable1	Throwable
    //   162	1	3	localThrowable2	Throwable
    //   27	124	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   29	39	85	java/lang/Throwable
    //   41	46	132	finally
    //   48	52	132	finally
    //   54	60	132	finally
    //   90	94	132	finally
    //   96	107	132	finally
    //   29	39	158	finally
    //   41	46	162	java/lang/Throwable
    //   48	52	162	java/lang/Throwable
    //   54	60	162	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    c.a("unzp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      byte[] arrayOfByte = a.b(paramInt, paramArrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      d.b().a("509", "unzipData length: " + paramArrayOfByte.length + ",type:" + paramInt, localThrowable);
      c.a(localThrowable);
      c.b("err unzp}" + localThrowable.toString(), new Object[0]);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = a(b(paramArrayOfByte, paramInt2, paramString), paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    c.a("CoreUtils", "encry data length:%d type: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    try
    {
      byte[] arrayOfByte = com.tencent.beacon.base.net.b.c.b(paramInt, paramString, paramArrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
      d.b().a("507", "data length: " + paramArrayOfByte.length + ",type:" + paramInt + ",key: " + paramString, localThrowable);
    }
    return null;
  }
  
  public static String b()
  {
    String str = "";
    Object localObject = com.tencent.beacon.a.c.c.d();
    if (localObject != null) {
      str = ((com.tencent.beacon.a.c.c)localObject).f();
    }
    localObject = e.l().d();
    int i = a.nextInt(2147473647);
    return b(str + "_" + (String)localObject + "_" + new Date().getTime() + "_" + (i + 1000));
  }
  
  public static String b(String paramString)
  {
    String str = c(paramString);
    paramString = str;
    if (str != null) {}
    try
    {
      paramString = str.substring(8, 24);
      return paramString;
    }
    catch (Exception paramString)
    {
      c.a(paramString);
    }
    return str;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    c.a("zp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      byte[] arrayOfByte = a.a(paramInt, paramArrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      d.b().a("509", "zipData length: " + paramArrayOfByte.length + ",type:" + paramInt, localThrowable);
      c.a(localThrowable);
      c.b("err zp : %s", new Object[] { localThrowable.toString() });
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(b(paramArrayOfByte, paramInt1), paramInt2, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    try
    {
      byte[] arrayOfByte = com.tencent.beacon.base.net.b.c.a(paramInt, paramString, paramArrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      c.e("data length: " + paramArrayOfByte.length + ",type:" + paramInt + ",key: " + paramString + ",error: " + localThrowable.getMessage(), new Object[0]);
      d.b().a("508", "data length: " + paramArrayOfByte.length + ",type:" + paramInt + ",key: " + paramString, localThrowable);
    }
    return null;
  }
  
  public static long c()
  {
    return new Date().getTime() + com.tencent.beacon.a.c.c.d().j();
  }
  
  public static String c(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      localObject = ((MessageDigest)localObject).digest(paramString.getBytes(Charset.forName("UTF-8")));
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      while (i < j)
      {
        int k = localObject[i] & 0xFF;
        if (k < 16) {
          localStringBuilder.append(0);
        }
        localStringBuilder.append(Integer.toHexString(k));
        i += 1;
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      c.a(localException);
    }
    return paramString;
  }
  
  public static String d()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
    return "";
  }
  
  public static Date d(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() <= 0)) {
      return null;
    }
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      c.a(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.util.b
 * JD-Core Version:    0.7.0.1
 */