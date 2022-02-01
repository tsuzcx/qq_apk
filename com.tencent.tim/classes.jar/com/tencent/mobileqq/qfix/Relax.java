package com.tencent.mobileqq.qfix;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Relax
{
  public static final int APPLY_ERROR_GET_METHODS_BYTES = 4;
  public static final int APPLY_ERROR_PATCH_BOUNDARY = 3;
  public static final int APPLY_ERROR_PREPARE = 1;
  public static final int APPLY_ERROR_REMOVE_PATCH_CLASSES = 2;
  public static final int APPLY_SUCCESS = 0;
  
  static
  {
    System.currentTimeMillis();
  }
  
  @SuppressLint({"PrivateApi"})
  private static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return true;
    }
    try
    {
      Class.forName("android.se.omapi.Channel");
      return true;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  private static boolean a(ClassLoader paramClassLoader)
  {
    try
    {
      boolean bool = init(c.class.getDeclaredMethod("a", new Class[0]), c.class.getDeclaredMethod("b", new Class[0]), paramClassLoader, b(paramClassLoader), a());
      return bool;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      paramClassLoader.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  private static byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 84	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: invokespecial 85	java/io/ByteArrayOutputStream:<init>	()V
    //   10: astore_3
    //   11: new 87	java/io/BufferedInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 90	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_2
    //   20: aload_2
    //   21: astore_0
    //   22: sipush 4000
    //   25: newarray byte
    //   27: astore 5
    //   29: aload_2
    //   30: astore_0
    //   31: aload_2
    //   32: aload 5
    //   34: iconst_0
    //   35: aload 5
    //   37: arraylength
    //   38: invokevirtual 94	java/io/BufferedInputStream:read	([BII)I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_m1
    //   44: if_icmpeq +39 -> 83
    //   47: aload_2
    //   48: astore_0
    //   49: aload_3
    //   50: aload 5
    //   52: iconst_0
    //   53: iload_1
    //   54: invokevirtual 98	java/io/ByteArrayOutputStream:write	([BII)V
    //   57: goto -28 -> 29
    //   60: astore_3
    //   61: aload_2
    //   62: astore_0
    //   63: aload_3
    //   64: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   67: aload 4
    //   69: astore_0
    //   70: aload_2
    //   71: ifnull +10 -> 81
    //   74: aload_2
    //   75: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   78: aload 4
    //   80: astore_0
    //   81: aload_0
    //   82: areturn
    //   83: aload_2
    //   84: astore_0
    //   85: aload_3
    //   86: iconst_0
    //   87: invokevirtual 105	java/io/ByteArrayOutputStream:write	(I)V
    //   90: aload_2
    //   91: astore_0
    //   92: aload_3
    //   93: invokevirtual 109	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   96: astore_3
    //   97: aload_3
    //   98: astore_0
    //   99: aload_2
    //   100: ifnull -19 -> 81
    //   103: aload_2
    //   104: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   107: aload_3
    //   108: areturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   114: aload_3
    //   115: areturn
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   134: aload_2
    //   135: athrow
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   141: goto -7 -> 134
    //   144: astore_2
    //   145: goto -19 -> 126
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_2
    //   151: goto -90 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramInputStream	InputStream
    //   41	13	1	i	int
    //   19	85	2	localBufferedInputStream	java.io.BufferedInputStream
    //   123	12	2	localObject1	Object
    //   144	1	2	localObject2	Object
    //   150	1	2	localObject3	Object
    //   10	40	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   60	33	3	localIOException1	java.io.IOException
    //   96	19	3	arrayOfByte1	byte[]
    //   148	1	3	localIOException2	java.io.IOException
    //   1	78	4	localObject4	Object
    //   27	24	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	29	60	java/io/IOException
    //   31	42	60	java/io/IOException
    //   49	57	60	java/io/IOException
    //   85	90	60	java/io/IOException
    //   92	97	60	java/io/IOException
    //   103	107	109	java/io/IOException
    //   74	78	116	java/io/IOException
    //   3	20	123	finally
    //   130	134	136	java/io/IOException
    //   22	29	144	finally
    //   31	42	144	finally
    //   49	57	144	finally
    //   63	67	144	finally
    //   85	90	144	finally
    //   92	97	144	finally
    //   3	20	148	java/io/IOException
  }
  
  public static int apply(InputStream paramInputStream1, InputStream paramInputStream2, InputStream paramInputStream3, boolean paramBoolean)
  {
    if (!paramBoolean) {
      System.loadLibrary("relax");
    }
    try
    {
      ClassLoader localClassLoader = Relax.class.getClassLoader();
      paramBoolean = a(localClassLoader);
      if (!paramBoolean) {
        return 1;
      }
      if ((paramInputStream1 != null) && (paramInputStream2 != null))
      {
        paramBoolean = remove(localClassLoader, a(paramInputStream1), a(paramInputStream2));
        if (!paramBoolean) {
          return 2;
        }
      }
      paramInputStream1 = a(paramInputStream3);
      if (paramInputStream1 == null) {
        return 4;
      }
      paramBoolean = relax(paramInputStream1);
      if (!paramBoolean) {
        return 3;
      }
      return 0;
    }
    finally
    {
      release();
    }
  }
  
  private static long b(ClassLoader paramClassLoader)
  {
    long l = 0L;
    if (!a()) {}
    try
    {
      Field localField = ClassLoader.class.getDeclaredField("classTable");
      localField.setAccessible(true);
      l = localField.getLong(paramClassLoader);
      return l;
    }
    catch (Exception paramClassLoader) {}
    return 0L;
  }
  
  private static native boolean init(Method paramMethod1, Method paramMethod2, ClassLoader paramClassLoader, long paramLong, boolean paramBoolean);
  
  private static native boolean relax(byte[] paramArrayOfByte);
  
  private static native void release();
  
  private static native boolean remove(ClassLoader paramClassLoader, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ApplyResult {}
  
  @Keep
  class c
  {
    c() {}
    
    @Keep
    void a() {}
    
    @Keep
    void b() {}
  }
  
  @Keep
  class d
  {
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.Relax
 * JD-Core Version:    0.7.0.1
 */