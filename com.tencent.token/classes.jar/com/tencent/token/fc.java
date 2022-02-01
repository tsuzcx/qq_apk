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
import java.security.KeyStore;
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
import okhttp3.aa;
import okhttp3.s;
import okhttp3.y;
import okio.ByteString;
import okio.c;
import okio.q;

public final class fc
{
  public static final byte[] a = new byte[0];
  public static final String[] b = new String[0];
  public static final aa c;
  public static final y d;
  public static final Charset e;
  public static final Charset f;
  public static final TimeZone g;
  public static final Comparator<String> h;
  private static final ByteString i;
  private static final ByteString j;
  private static final ByteString k;
  private static final ByteString l;
  private static final ByteString m;
  private static final Charset n;
  private static final Charset o;
  private static final Charset p;
  private static final Charset q;
  private static final Method r;
  private static final Pattern s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  static
  {
    Object localObject2 = a;
    Object localObject1 = null;
    c = aa.a(null, (byte[])localObject2);
    d = y.a(null, a);
    i = ByteString.b("efbbbf");
    j = ByteString.b("feff");
    k = ByteString.b("fffe");
    l = ByteString.b("0000ffff");
    m = ByteString.b("ffff0000");
    e = Charset.forName("UTF-8");
    f = Charset.forName("ISO-8859-1");
    n = Charset.forName("UTF-16BE");
    o = Charset.forName("UTF-16LE");
    p = Charset.forName("UTF-32BE");
    q = Charset.forName("UTF-32LE");
    g = TimeZone.getTimeZone("GMT");
    h = new Comparator()
    {
      public int a(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString1.compareTo(paramAnonymousString2);
      }
    };
    try
    {
      localObject2 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label162:
      break label162;
    }
    r = localObject1;
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
  
  public static int a(String paramString, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong >= 0L)
    {
      if (paramTimeUnit != null)
      {
        long l1 = paramTimeUnit.toMillis(paramLong);
        if (l1 <= 2147483647L)
        {
          if ((l1 == 0L) && (paramLong > 0L))
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
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append(paramString);
    paramTimeUnit.append(" < 0");
    throw new IllegalArgumentException(paramTimeUnit.toString());
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
  
  public static String a(String paramString)
  {
    if (paramString.contains(":"))
    {
      if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
        localObject = d(paramString, 1, paramString.length() - 1);
      } else {
        localObject = d(paramString, 0, paramString.length());
      }
      if (localObject == null) {
        return null;
      }
      Object localObject = ((InetAddress)localObject).getAddress();
      if (localObject.length == 16) {
        return a((byte[])localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid IPv6 address: '");
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
      boolean bool = d(paramString);
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
  
  public static String a(s params, boolean paramBoolean)
  {
    Object localObject1;
    if (params.f().contains(":"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(params.f());
      ((StringBuilder)localObject1).append("]");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = params.f();
    }
    Object localObject2;
    if (!paramBoolean)
    {
      localObject2 = localObject1;
      if (params.g() == s.a(params.b())) {}
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(params.g());
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int i7 = 0;
    int i1 = 0;
    int i3 = -1;
    int i4;
    int i5;
    for (int i2 = 0; i1 < paramArrayOfByte.length; i2 = i5)
    {
      i4 = i1;
      while ((i4 < 16) && (paramArrayOfByte[i4] == 0) && (paramArrayOfByte[(i4 + 1)] == 0)) {
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
    c localc = new c();
    i1 = i7;
    while (i1 < paramArrayOfByte.length) {
      if (i1 == i3)
      {
        localc.b(58);
        i4 = i1 + i2;
        i1 = i4;
        if (i4 == 16)
        {
          localc.b(58);
          i1 = i4;
        }
      }
      else
      {
        if (i1 > 0) {
          localc.b(58);
        }
        localc.j((paramArrayOfByte[i1] & 0xFF) << 8 | paramArrayOfByte[(i1 + 1)] & 0xFF);
        i1 += 2;
      }
    }
    return localc.o();
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
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, fc.this);
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
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((localObject.length == 1) && ((localObject[0] instanceof X509TrustManager))) {
        return (X509TrustManager)localObject[0];
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected default trust managers:");
      localStringBuilder.append(Arrays.toString((Object[])localObject));
      throw new IllegalStateException(localStringBuilder.toString());
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw a("No System TLS", localGeneralSecurityException);
    }
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
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
  
  public static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private static boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int i2 = paramInt3;
    int i1 = paramInt1;
    while (i1 < paramInt2)
    {
      if (i2 == paramArrayOfByte.length) {
        return false;
      }
      paramInt1 = i1;
      if (i2 != paramInt3)
      {
        if (paramString.charAt(i1) != '.') {
          return false;
        }
        paramInt1 = i1 + 1;
      }
      i1 = paramInt1;
      int i3 = 0;
      while (i1 < paramInt2)
      {
        int i4 = paramString.charAt(i1);
        if ((i4 < 48) || (i4 > 57)) {
          break;
        }
        if ((i3 == 0) && (paramInt1 != i1)) {
          return false;
        }
        i3 = i3 * 10 + i4 - 48;
        if (i3 > 255) {
          return false;
        }
        i1 += 1;
      }
      if (i1 - paramInt1 == 0) {
        return false;
      }
      paramArrayOfByte[i2] = ((byte)i3);
      i2 += 1;
    }
    return i2 == paramInt3 + 4;
  }
  
  public static boolean a(q paramq, int paramInt, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = b(paramq, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException paramq)
    {
      label9:
      break label9;
    }
    return false;
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
  
  /* Error */
  public static boolean b(q paramq, int paramInt, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: invokestatic 475	java/lang/System:nanoTime	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: invokeinterface 480 1 0
    //   11: invokevirtual 485	okio/r:d_	()Z
    //   14: ifeq +19 -> 33
    //   17: aload_0
    //   18: invokeinterface 480 1 0
    //   23: invokevirtual 487	okio/r:d	()J
    //   26: lload 5
    //   28: lsub
    //   29: lstore_3
    //   30: goto +7 -> 37
    //   33: ldc2_w 488
    //   36: lstore_3
    //   37: aload_0
    //   38: invokeinterface 480 1 0
    //   43: lload_3
    //   44: aload_2
    //   45: iload_1
    //   46: i2l
    //   47: invokevirtual 492	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   50: invokestatic 498	java/lang/Math:min	(JJ)J
    //   53: lload 5
    //   55: ladd
    //   56: invokevirtual 501	okio/r:a	(J)Lokio/r;
    //   59: pop
    //   60: new 305	okio/c
    //   63: dup
    //   64: invokespecial 306	okio/c:<init>	()V
    //   67: astore_2
    //   68: aload_0
    //   69: aload_2
    //   70: ldc2_w 502
    //   73: invokeinterface 506 4 0
    //   78: ldc2_w 507
    //   81: lcmp
    //   82: ifeq +10 -> 92
    //   85: aload_2
    //   86: invokevirtual 510	okio/c:r	()V
    //   89: goto -21 -> 68
    //   92: lload_3
    //   93: ldc2_w 488
    //   96: lcmp
    //   97: ifne +15 -> 112
    //   100: aload_0
    //   101: invokeinterface 480 1 0
    //   106: invokevirtual 512	okio/r:f	()Lokio/r;
    //   109: pop
    //   110: iconst_1
    //   111: ireturn
    //   112: aload_0
    //   113: invokeinterface 480 1 0
    //   118: lload 5
    //   120: lload_3
    //   121: ladd
    //   122: invokevirtual 501	okio/r:a	(J)Lokio/r;
    //   125: pop
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_2
    //   129: lload_3
    //   130: ldc2_w 488
    //   133: lcmp
    //   134: ifne +16 -> 150
    //   137: aload_0
    //   138: invokeinterface 480 1 0
    //   143: invokevirtual 512	okio/r:f	()Lokio/r;
    //   146: pop
    //   147: goto +17 -> 164
    //   150: aload_0
    //   151: invokeinterface 480 1 0
    //   156: lload 5
    //   158: lload_3
    //   159: ladd
    //   160: invokevirtual 501	okio/r:a	(J)Lokio/r;
    //   163: pop
    //   164: aload_2
    //   165: athrow
    //   166: lload_3
    //   167: ldc2_w 488
    //   170: lcmp
    //   171: ifne +15 -> 186
    //   174: aload_0
    //   175: invokeinterface 480 1 0
    //   180: invokevirtual 512	okio/r:f	()Lokio/r;
    //   183: pop
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_0
    //   187: invokeinterface 480 1 0
    //   192: lload 5
    //   194: lload_3
    //   195: ladd
    //   196: invokevirtual 501	okio/r:a	(J)Lokio/r;
    //   199: pop
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_2
    //   203: goto -37 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramq	q
    //   0	206	1	paramInt	int
    //   0	206	2	paramTimeUnit	TimeUnit
    //   29	166	3	l1	long
    //   3	190	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   60	68	128	finally
    //   68	89	128	finally
    //   60	68	202	java/io/InterruptedIOException
    //   68	89	202	java/io/InterruptedIOException
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
    int i1 = 0;
    int i2 = -1;
    int i4 = -1;
    int i3;
    int i5;
    for (;;)
    {
      i3 = i1;
      i5 = i2;
      if (paramInt1 >= paramInt2) {
        break label280;
      }
      if (i1 == arrayOfByte.length) {
        return null;
      }
      i3 = paramInt1 + 2;
      if ((i3 <= paramInt2) && (paramString.regionMatches(paramInt1, "::", 0, 2)))
      {
        if (i2 != -1) {
          return null;
        }
        paramInt1 = i1 + 2;
        if (i3 == paramInt2)
        {
          i5 = paramInt1;
          i3 = paramInt1;
          break label280;
        }
        i2 = paramInt1;
        i1 = paramInt1;
        paramInt1 = i3;
      }
      else if (i1 != 0)
      {
        if (paramString.regionMatches(paramInt1, ":", 0, 1))
        {
          paramInt1 += 1;
        }
        else
        {
          if (paramString.regionMatches(paramInt1, ".", 0, 1))
          {
            if (!a(paramString, i4, paramInt2, arrayOfByte, i1 - 2)) {
              return null;
            }
            i3 = i1 + 2;
            i5 = i2;
            break label280;
          }
          return null;
        }
      }
      i3 = paramInt1;
      i4 = 0;
      while (i3 < paramInt2)
      {
        i5 = a(paramString.charAt(i3));
        if (i5 == -1) {
          break;
        }
        i4 = (i4 << 4) + i5;
        i3 += 1;
      }
      i5 = i3 - paramInt1;
      if (i5 == 0) {
        break;
      }
      if (i5 > 4) {
        return null;
      }
      i5 = i1 + 1;
      arrayOfByte[i1] = ((byte)(i4 >>> 8 & 0xFF));
      i1 = i5 + 1;
      arrayOfByte[i5] = ((byte)(i4 & 0xFF));
      i4 = paramInt1;
      paramInt1 = i3;
    }
    return null;
    label280:
    if (i3 != arrayOfByte.length)
    {
      if (i5 == -1) {
        return null;
      }
      paramInt1 = arrayOfByte.length;
      paramInt2 = i3 - i5;
      System.arraycopy(arrayOfByte, i5, arrayOfByte, paramInt1 - paramInt2, paramInt2);
      Arrays.fill(arrayOfByte, i5, arrayOfByte.length - i3 + i5, (byte)0);
    }
    try
    {
      paramString = InetAddress.getByAddress(arrayOfByte);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      label344:
      break label344;
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
 * Qualified Name:     com.tencent.token.fc
 * JD-Core Version:    0.7.0.1
 */