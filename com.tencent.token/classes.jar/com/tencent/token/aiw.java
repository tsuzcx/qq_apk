package com.tencent.token;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class aiw
{
  public static final byte[] a = new byte[0];
  public static final String[] b = new String[0];
  public static final air c = air.a(a);
  public static final aip d;
  public static final Charset e;
  public static final Charset f;
  public static final TimeZone g;
  public static final Comparator<String> h;
  private static final alb i;
  private static final alb j;
  private static final alb k;
  private static final alb l;
  private static final alb m;
  private static final Charset n;
  private static final Charset o;
  private static final Charset p;
  private static final Charset q;
  private static final Method r;
  private static final Pattern s;
  
  static
  {
    Object localObject = a;
    int i1 = localObject.length;
    if (localObject != null)
    {
      a(localObject.length, i1);
      d = new aip.1(i1, (byte[])localObject);
      i = alb.b("efbbbf");
      j = alb.b("feff");
      k = alb.b("fffe");
      l = alb.b("0000ffff");
      m = alb.b("ffff0000");
      e = Charset.forName("UTF-8");
      f = Charset.forName("ISO-8859-1");
      n = Charset.forName("UTF-16BE");
      o = Charset.forName("UTF-16LE");
      p = Charset.forName("UTF-32BE");
      q = Charset.forName("UTF-32LE");
      g = TimeZone.getTimeZone("GMT");
      h = new Comparator() {};
    }
    try
    {
      localObject = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
    }
    catch (Exception localException)
    {
      label179:
      break label179;
    }
    localObject = null;
    r = (Method)localObject;
    s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    return;
    throw new NullPointerException("content == null");
  }
  
  public static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      switch (paramString.charAt(paramInt1))
      {
      default: 
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int a(String paramString, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit != null)
    {
      long l1 = paramTimeUnit.toMillis(60L);
      if (l1 <= 2147483647L)
      {
        if (l1 == 0L)
        {
          paramTimeUnit = new StringBuilder();
          paramTimeUnit.append(paramString);
          paramTimeUnit.append(" too small.");
          throw new IllegalArgumentException(paramTimeUnit.toString());
        }
        return (int)l1;
      }
      paramTimeUnit = new StringBuilder();
      paramTimeUnit.append(paramString);
      paramTimeUnit.append(" too large.");
      throw new IllegalArgumentException(paramTimeUnit.toString());
    }
    throw new NullPointerException("unit == null");
  }
  
  public static int a(Comparator<String> paramComparator, String[] paramArrayOfString, String paramString)
  {
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramComparator.compare(paramArrayOfString[i1], paramString) == 0) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public static AssertionError a(String paramString, Exception paramException)
  {
    paramString = new AssertionError(paramString);
    try
    {
      paramString.initCause(paramException);
      return paramString;
    }
    catch (IllegalStateException paramException) {}
    return paramString;
  }
  
  public static String a(aii paramaii, boolean paramBoolean)
  {
    Object localObject;
    if (paramaii.b.contains(":"))
    {
      localObject = new StringBuilder("[");
      ((StringBuilder)localObject).append(paramaii.b);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = paramaii.b;
    }
    if ((!paramBoolean) && (paramaii.c == aii.a(paramaii.a))) {
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(":");
    localStringBuilder.append(paramaii.c);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    boolean bool;
    if (paramString.contains(":"))
    {
      bool = paramString.startsWith("[");
      int i7 = 0;
      if ((bool) && (paramString.endsWith("]"))) {
        localObject = d(paramString, 1, paramString.length() - 1);
      } else {
        localObject = d(paramString, 0, paramString.length());
      }
      if (localObject == null) {
        return null;
      }
      Object localObject = ((InetAddress)localObject).getAddress();
      if (localObject.length == 16)
      {
        int i1 = 0;
        int i3 = -1;
        int i4;
        int i5;
        for (int i2 = 0; i1 < localObject.length; i2 = i5)
        {
          i4 = i1;
          while ((i4 < 16) && (localObject[i4] == 0) && (localObject[(i4 + 1)] == 0)) {
            i4 += 2;
          }
          int i8 = i4 - i1;
          int i6 = i3;
          i5 = i2;
          if (i8 > i2)
          {
            i6 = i3;
            i5 = i2;
            if (i8 >= 4)
            {
              i5 = i8;
              i6 = i1;
            }
          }
          i1 = i4 + 2;
          i3 = i6;
        }
        paramString = new aky();
        i1 = i7;
        while (i1 < localObject.length) {
          if (i1 == i3)
          {
            paramString.b(58);
            i4 = i1 + i2;
            i1 = i4;
            if (i4 == 16)
            {
              paramString.b(58);
              i1 = i4;
            }
          }
          else
          {
            if (i1 > 0) {
              paramString.b(58);
            }
            paramString.i((localObject[i1] & 0xFF) << 8 | localObject[(i1 + 1)] & 0xFF);
            i1 += 2;
          }
        }
        return paramString.m();
      }
      localObject = new StringBuilder("Invalid IPv6 address: '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'");
      throw new AssertionError(((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      if (paramString.isEmpty()) {
        return null;
      }
      bool = d(paramString);
      if (bool) {
        return null;
      }
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  public static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static <T> List<T> a(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static <T> List<T> a(T... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  public static <K, V> Map<K, V> a(Map<K, V> paramMap)
  {
    if (paramMap.isEmpty()) {
      return Collections.emptyMap();
    }
    return Collections.unmodifiableMap(new LinkedHashMap(paramMap));
  }
  
  public static ThreadFactory a(String paramString, final boolean paramBoolean)
  {
    new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, aiw.this);
        paramAnonymousRunnable.setDaemon(paramBoolean);
        return paramAnonymousRunnable;
      }
    };
  }
  
  public static X509TrustManager a()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init(null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((localObject.length == 1) && ((localObject[0] instanceof X509TrustManager))) {
        return (X509TrustManager)localObject[0];
      }
      StringBuilder localStringBuilder = new StringBuilder("Unexpected default trust managers:");
      localStringBuilder.append(Arrays.toString((Object[])localObject));
      throw new IllegalStateException(localStringBuilder.toString());
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw a("No System TLS", localGeneralSecurityException);
    }
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    if (((paramLong2 | 0L) >= 0L) && (0L <= paramLong1) && (paramLong1 - 0L >= paramLong2)) {
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    Method localMethod = r;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      return;
    }
    catch (InvocationTargetException|IllegalAccessException paramThrowable1) {}
    return;
  }
  
  public static void a(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (RuntimeException paramSocket)
    {
      throw paramSocket;
    }
    catch (AssertionError paramSocket)
    {
      if (a(paramSocket)) {
        return;
      }
      throw paramSocket;
      return;
    }
    catch (Exception paramSocket) {}
  }
  
  /* Error */
  public static boolean a(alo paramalo, int paramInt, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: invokestatic 435	java/lang/System:nanoTime	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: invokeinterface 440 1 0
    //   11: invokevirtual 445	com/tencent/token/alp:e_	()Z
    //   14: ifeq +19 -> 33
    //   17: aload_0
    //   18: invokeinterface 440 1 0
    //   23: invokevirtual 447	com/tencent/token/alp:c	()J
    //   26: lload 5
    //   28: lsub
    //   29: lstore_3
    //   30: goto +7 -> 37
    //   33: ldc2_w 448
    //   36: lstore_3
    //   37: aload_0
    //   38: invokeinterface 440 1 0
    //   43: lload_3
    //   44: aload_2
    //   45: iload_1
    //   46: i2l
    //   47: invokevirtual 452	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   50: invokestatic 458	java/lang/Math:min	(JJ)J
    //   53: lload 5
    //   55: ladd
    //   56: invokevirtual 461	com/tencent/token/alp:a	(J)Lcom/tencent/token/alp;
    //   59: pop
    //   60: new 280	com/tencent/token/aky
    //   63: dup
    //   64: invokespecial 281	com/tencent/token/aky:<init>	()V
    //   67: astore_2
    //   68: aload_0
    //   69: aload_2
    //   70: ldc2_w 462
    //   73: invokeinterface 466 4 0
    //   78: ldc2_w 467
    //   81: lcmp
    //   82: ifeq +10 -> 92
    //   85: aload_2
    //   86: invokevirtual 470	com/tencent/token/aky:p	()V
    //   89: goto -21 -> 68
    //   92: lload_3
    //   93: ldc2_w 448
    //   96: lcmp
    //   97: ifne +16 -> 113
    //   100: aload_0
    //   101: invokeinterface 440 1 0
    //   106: invokevirtual 473	com/tencent/token/alp:f_	()Lcom/tencent/token/alp;
    //   109: pop
    //   110: goto +17 -> 127
    //   113: aload_0
    //   114: invokeinterface 440 1 0
    //   119: lload 5
    //   121: lload_3
    //   122: ladd
    //   123: invokevirtual 461	com/tencent/token/alp:a	(J)Lcom/tencent/token/alp;
    //   126: pop
    //   127: iconst_1
    //   128: ireturn
    //   129: astore_2
    //   130: lload_3
    //   131: ldc2_w 448
    //   134: lcmp
    //   135: ifne +16 -> 151
    //   138: aload_0
    //   139: invokeinterface 440 1 0
    //   144: invokevirtual 473	com/tencent/token/alp:f_	()Lcom/tencent/token/alp;
    //   147: pop
    //   148: goto +17 -> 165
    //   151: aload_0
    //   152: invokeinterface 440 1 0
    //   157: lload 5
    //   159: lload_3
    //   160: ladd
    //   161: invokevirtual 461	com/tencent/token/alp:a	(J)Lcom/tencent/token/alp;
    //   164: pop
    //   165: aload_2
    //   166: athrow
    //   167: lload_3
    //   168: ldc2_w 448
    //   171: lcmp
    //   172: ifne +16 -> 188
    //   175: aload_0
    //   176: invokeinterface 440 1 0
    //   181: invokevirtual 473	com/tencent/token/alp:f_	()Lcom/tencent/token/alp;
    //   184: pop
    //   185: goto +17 -> 202
    //   188: aload_0
    //   189: invokeinterface 440 1 0
    //   194: lload 5
    //   196: lload_3
    //   197: ladd
    //   198: invokevirtual 461	com/tencent/token/alp:a	(J)Lcom/tencent/token/alp;
    //   201: pop
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_2
    //   205: goto -38 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramalo	alo
    //   0	208	1	paramInt	int
    //   0	208	2	paramTimeUnit	TimeUnit
    //   29	168	3	l1	long
    //   3	192	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   60	68	129	finally
    //   68	89	129	finally
    //   60	68	204	java/io/InterruptedIOException
    //   68	89	204	java/io/InterruptedIOException
  }
  
  public static boolean a(alo paramalo, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = a(paramalo, 100, paramTimeUnit);
      return bool;
    }
    catch (IOException paramalo)
    {
      label10:
      break label10;
    }
    return false;
  }
  
  public static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static String[] a(Comparator<? super String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfString1.length;
    int i1 = 0;
    while (i1 < i3)
    {
      String str = paramArrayOfString1[i1];
      int i4 = paramArrayOfString2.length;
      int i2 = 0;
      while (i2 < i4)
      {
        if (paramComparator.compare(str, paramArrayOfString2[i2]) == 0)
        {
          localArrayList.add(str);
          break;
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String[] a(String[] paramArrayOfString, String paramString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    return arrayOfString;
  }
  
  public static int b(String paramString)
  {
    int i2 = paramString.length();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramString.charAt(i1);
      if (i3 > 31)
      {
        if (i3 >= 127) {
          return i1;
        }
        i1 += 1;
      }
      else
      {
        return i1;
      }
    }
    return -1;
  }
  
  public static int b(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      switch (paramString.charAt(paramInt2))
      {
      default: 
        return paramInt2 + 1;
      }
      paramInt2 -= 1;
    }
    return paramInt1;
  }
  
  public static boolean b(Comparator<String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null) && (paramArrayOfString1.length != 0))
    {
      if (paramArrayOfString2.length == 0) {
        return false;
      }
      int i3 = paramArrayOfString1.length;
      int i1 = 0;
      while (i1 < i3)
      {
        String str = paramArrayOfString1[i1];
        int i4 = paramArrayOfString2.length;
        int i2 = 0;
        while (i2 < i4)
        {
          if (paramComparator.compare(str, paramArrayOfString2[i2]) == 0) {
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
      return false;
    }
    return false;
  }
  
  public static String c(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, b(paramString, paramInt1, paramInt2));
  }
  
  public static boolean c(String paramString)
  {
    return s.matcher(paramString).matches();
  }
  
  @Nullable
  private static InetAddress d(String paramString, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[16];
    int i3 = paramInt1;
    int i1 = 0;
    int i2 = -1;
    paramInt1 = -1;
    while (i3 < paramInt2)
    {
      if (i1 == 16) {
        return null;
      }
      int i4 = i3 + 2;
      int i6;
      if ((i4 <= paramInt2) && (paramString.regionMatches(i3, "::", 0, 2)))
      {
        if (i2 != -1) {
          return null;
        }
        paramInt1 = i1 + 2;
        if (i4 == paramInt2)
        {
          i2 = paramInt1;
          break label465;
        }
        i2 = paramInt1;
        i1 = i4;
        i3 = paramInt1;
        paramInt1 = i1;
      }
      else if (i1 != 0)
      {
        if (paramString.regionMatches(i3, ":", 0, 1))
        {
          paramInt1 = i3 + 1;
          i3 = i1;
        }
        else
        {
          if (paramString.regionMatches(i3, ".", 0, 1))
          {
            i6 = i1 - 2;
            i4 = i6;
            i3 = paramInt1;
            for (;;)
            {
              i5 = 0;
              if (i3 >= paramInt2) {
                break;
              }
              if (i4 == 16)
              {
                paramInt1 = i5;
                break label332;
              }
              paramInt1 = i3;
              if (i4 != i6)
              {
                if (paramString.charAt(i3) != '.')
                {
                  paramInt1 = i5;
                  break label332;
                }
                paramInt1 = i3 + 1;
              }
              i3 = paramInt1;
              i5 = 0;
              while (i3 < paramInt2)
              {
                int i7 = paramString.charAt(i3);
                if ((i7 < 48) || (i7 > 57)) {
                  break;
                }
                if ((i5 == 0) && (paramInt1 != i3))
                {
                  paramInt1 = 0;
                  break label332;
                }
                i5 = i5 * 10 + i7 - 48;
                if (i5 > 255)
                {
                  paramInt1 = 0;
                  break label332;
                }
                i3 += 1;
              }
              if (i3 - paramInt1 == 0)
              {
                paramInt1 = 0;
                break label332;
              }
              arrayOfByte[i4] = ((byte)i5);
              i4 += 1;
            }
            if (i4 != i6 + 4) {
              paramInt1 = 0;
            } else {
              paramInt1 = 1;
            }
            label332:
            if (paramInt1 == 0) {
              return null;
            }
            paramInt1 = i1 + 2;
            break label465;
          }
          return null;
        }
      }
      else
      {
        paramInt1 = i3;
        i3 = i1;
      }
      i1 = paramInt1;
      i4 = 0;
      while (i1 < paramInt2)
      {
        i5 = a(paramString.charAt(i1));
        if (i5 == -1) {
          break;
        }
        i4 = (i4 << 4) + i5;
        i1 += 1;
      }
      int i5 = i1 - paramInt1;
      if (i5 != 0)
      {
        if (i5 > 4) {
          return null;
        }
        i6 = i3 + 1;
        arrayOfByte[i3] = ((byte)(i4 >>> 8 & 0xFF));
        i5 = i6 + 1;
        arrayOfByte[i6] = ((byte)(i4 & 0xFF));
        i3 = i1;
        i1 = i5;
      }
      else
      {
        return null;
      }
    }
    paramInt1 = i1;
    label465:
    if (paramInt1 != 16)
    {
      if (i2 == -1) {
        return null;
      }
      paramInt2 = paramInt1 - i2;
      System.arraycopy(arrayOfByte, i2, arrayOfByte, 16 - paramInt2, paramInt2);
      Arrays.fill(arrayOfByte, i2, 16 - paramInt1 + i2, (byte)0);
    }
    try
    {
      paramString = InetAddress.getByAddress(arrayOfByte);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      label521:
      break label521;
    }
    throw new AssertionError();
  }
  
  private static boolean d(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      int i2 = paramString.charAt(i1);
      if (i2 > 31)
      {
        if (i2 >= 127) {
          return true;
        }
        if (" #%/:?@[\\]".indexOf(i2) != -1) {
          return true;
        }
        i1 += 1;
      }
      else
      {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aiw
 * JD-Core Version:    0.7.0.1
 */