package com.tencent.token;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
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
import okhttp3.af;
import okhttp3.ar;
import okhttp3.av;
import okio.ByteString;
import okio.f;
import okio.y;
import okio.z;

public final class gn
{
  public static final byte[] a;
  public static final String[] b;
  public static final av c;
  public static final ar d;
  public static final Charset e;
  public static final Charset f;
  public static final TimeZone g;
  public static final Comparator h;
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
    Object localObject = null;
    a = new byte[0];
    b = new String[0];
    c = av.a(null, a);
    d = ar.a(null, a);
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
    h = new go();
    try
    {
      Method localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      localObject = localMethod;
    }
    catch (Exception localException)
    {
      label160:
      break label160;
    }
    r = localObject;
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
    for (;;)
    {
      int i1 = paramInt2;
      if (paramInt1 < paramInt2) {}
      switch (paramString.charAt(paramInt1))
      {
      default: 
        i1 = paramInt1;
        return i1;
      }
      paramInt1 += 1;
    }
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    for (;;)
    {
      int i1 = paramInt2;
      if (paramInt1 < paramInt2)
      {
        if (paramString.charAt(paramInt1) == paramChar) {
          i1 = paramInt1;
        }
      }
      else {
        return i1;
      }
      paramInt1 += 1;
    }
  }
  
  public static int a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    for (;;)
    {
      int i1 = paramInt2;
      if (paramInt1 < paramInt2)
      {
        if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
          i1 = paramInt1;
        }
      }
      else {
        return i1;
      }
      paramInt1 += 1;
    }
  }
  
  public static int a(String paramString, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException(paramString + " < 0");
    }
    if (paramTimeUnit == null) {
      throw new NullPointerException("unit == null");
    }
    long l1 = paramTimeUnit.toMillis(paramLong);
    if (l1 > 2147483647L) {
      throw new IllegalArgumentException(paramString + " too large.");
    }
    if ((l1 == 0L) && (paramLong > 0L)) {
      throw new IllegalArgumentException(paramString + " too small.");
    }
    return (int)l1;
  }
  
  public static int a(Comparator paramComparator, String[] paramArrayOfString, String paramString)
  {
    int i1 = 0;
    int i2 = paramArrayOfString.length;
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
    Object localObject;
    if (paramString.contains(":")) {
      if ((paramString.startsWith("[")) && (paramString.endsWith("]")))
      {
        localObject = d(paramString, 1, paramString.length() - 1);
        if (localObject != null) {
          break label58;
        }
      }
    }
    for (;;)
    {
      return null;
      localObject = d(paramString, 0, paramString.length());
      break;
      label58:
      localObject = ((InetAddress)localObject).getAddress();
      if (localObject.length == 16) {
        return a((byte[])localObject);
      }
      throw new AssertionError("Invalid IPv6 address: '" + paramString + "'");
      try
      {
        paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
        if (!paramString.isEmpty())
        {
          boolean bool = d(paramString);
          if (!bool) {
            return paramString;
          }
        }
      }
      catch (IllegalArgumentException paramString) {}
    }
    return null;
  }
  
  public static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static String a(af paramaf, boolean paramBoolean)
  {
    if (paramaf.f().contains(":")) {}
    for (String str1 = "[" + paramaf.f() + "]";; str1 = paramaf.f())
    {
      String str2;
      if (!paramBoolean)
      {
        str2 = str1;
        if (paramaf.g() == af.a(paramaf.b())) {}
      }
      else
      {
        str2 = str1 + ":" + paramaf.g();
      }
      return str2;
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int i7 = 0;
    int i3 = 0;
    int i2 = -1;
    int i1 = 0;
    int i4;
    while (i1 < paramArrayOfByte.length)
    {
      i4 = i1;
      while ((i4 < 16) && (paramArrayOfByte[i4] == 0) && (paramArrayOfByte[(i4 + 1)] == 0)) {
        i4 += 2;
      }
      int i8 = i4 - i1;
      int i6 = i3;
      int i5 = i2;
      if (i8 > i3)
      {
        i6 = i3;
        i5 = i2;
        if (i8 >= 4)
        {
          i6 = i8;
          i5 = i1;
        }
      }
      i1 = i4 + 2;
      i3 = i6;
      i2 = i5;
    }
    f localf = new f();
    i1 = i7;
    while (i1 < paramArrayOfByte.length) {
      if (i1 == i2)
      {
        localf.b(58);
        i4 = i1 + i3;
        i1 = i4;
        if (i4 == 16)
        {
          localf.b(58);
          i1 = i4;
        }
      }
      else
      {
        if (i1 > 0) {
          localf.b(58);
        }
        localf.j((paramArrayOfByte[i1] & 0xFF) << 8 | paramArrayOfByte[(i1 + 1)] & 0xFF);
        i1 += 2;
      }
    }
    return localf.o();
  }
  
  public static List a(List paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static List a(Object... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  public static Map a(Map paramMap)
  {
    if (paramMap.isEmpty()) {
      return Collections.emptyMap();
    }
    return Collections.unmodifiableMap(new LinkedHashMap(paramMap));
  }
  
  public static ThreadFactory a(String paramString, boolean paramBoolean)
  {
    return new gp(paramString, paramBoolean);
  }
  
  public static X509TrustManager a()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((localObject.length != 1) || (!(localObject[0] instanceof X509TrustManager))) {
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString((Object[])localObject));
      }
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw a("No System TLS", localGeneralSecurityException);
    }
    X509TrustManager localX509TrustManager = (X509TrustManager)localGeneralSecurityException[0];
    return localX509TrustManager;
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3)) {
      throw new ArrayIndexOutOfBoundsException();
    }
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
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (r != null) {}
    try
    {
      r.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      return;
    }
    catch (IllegalAccessException paramThrowable1) {}catch (InvocationTargetException paramThrowable1) {}
  }
  
  public static void a(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (AssertionError paramSocket)
    {
      while (a(paramSocket)) {}
      throw paramSocket;
    }
    catch (RuntimeException paramSocket)
    {
      throw paramSocket;
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
      int i3 = 0;
      i1 = paramInt1;
      for (;;)
      {
        int i4;
        if (i1 < paramInt2)
        {
          i4 = paramString.charAt(i1);
          if ((i4 >= 48) && (i4 <= 57)) {}
        }
        else
        {
          if (i1 - paramInt1 != 0) {
            break;
          }
          return false;
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
      paramArrayOfByte[i2] = ((byte)i3);
      i2 += 1;
    }
    return i2 == paramInt3 + 4;
  }
  
  public static boolean a(y paramy, int paramInt, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = b(paramy, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException paramy) {}
    return false;
  }
  
  public static String[] a(Comparator paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfString1.length;
    int i1 = 0;
    if (i1 < i3)
    {
      String str = paramArrayOfString1[i1];
      int i4 = paramArrayOfString2.length;
      int i2 = 0;
      for (;;)
      {
        if (i2 < i4)
        {
          if (paramComparator.compare(str, paramArrayOfString2[i2]) == 0) {
            localArrayList.add(str);
          }
        }
        else
        {
          i1 += 1;
          break;
        }
        i2 += 1;
      }
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
    int i1 = 0;
    int i2 = paramString.length();
    while (i1 < i2)
    {
      int i3 = paramString.charAt(i1);
      if ((i3 <= 31) || (i3 >= 127)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public static int b(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    for (;;)
    {
      int i1 = paramInt1;
      if (paramInt2 >= paramInt1) {}
      switch (paramString.charAt(paramInt2))
      {
      default: 
        i1 = paramInt2 + 1;
        return i1;
      }
      paramInt2 -= 1;
    }
  }
  
  public static boolean b(Comparator paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0)) {}
    for (;;)
    {
      return false;
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
    }
  }
  
  public static boolean b(y paramy, int paramInt, TimeUnit paramTimeUnit)
  {
    long l2 = System.nanoTime();
    long l1;
    if (paramy.a().d_()) {
      l1 = paramy.a().d() - l2;
    }
    for (;;)
    {
      paramy.a().a(Math.min(l1, paramTimeUnit.toNanos(paramInt)) + l2);
      try
      {
        paramTimeUnit = new f();
        while (paramy.a(paramTimeUnit, 8192L) != -1L) {
          paramTimeUnit.r();
        }
      }
      catch (InterruptedIOException paramTimeUnit)
      {
        if (l1 == 9223372036854775807L) {
          paramy.a().f();
        }
        for (;;)
        {
          return false;
          l1 = 9223372036854775807L;
          break;
          if (l1 == 9223372036854775807L) {
            paramy.a().f();
          }
          for (;;)
          {
            return true;
            paramy.a().a(l1 + l2);
          }
          paramy.a().a(l1 + l2);
        }
      }
      finally
      {
        if (l1 != 9223372036854775807L) {
          break label188;
        }
      }
    }
    paramy.a().f();
    for (;;)
    {
      throw paramTimeUnit;
      label188:
      paramy.a().a(l1 + l2);
    }
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
    int i6 = -1;
    int i2 = -1;
    int i1 = 0;
    int i3 = paramInt1;
    int i4 = i2;
    paramInt1 = i1;
    if (i3 < paramInt2)
    {
      if (i1 == arrayOfByte.length) {
        return null;
      }
      if ((i3 + 2 <= paramInt2) && (paramString.regionMatches(i3, "::", 0, 2)))
      {
        if (i2 != -1) {
          return null;
        }
        paramInt1 = i3 + 2;
        i1 += 2;
        if (paramInt1 != paramInt2) {
          break label354;
        }
        paramInt1 = i1;
        i4 = i1;
      }
    }
    else
    {
      if (paramInt1 == arrayOfByte.length) {
        break label337;
      }
      if (i4 != -1) {
        break label300;
      }
      return null;
    }
    paramInt1 = i3;
    i4 = i2;
    int i5 = i1;
    if (i1 != 0)
    {
      if (!paramString.regionMatches(i3, ":", 0, 1)) {
        break label185;
      }
      paramInt1 = i3 + 1;
      i5 = i1;
    }
    for (i4 = i2;; i4 = i1)
    {
      i2 = 0;
      i1 = paramInt1;
      for (;;)
      {
        if (i1 < paramInt2)
        {
          i3 = a(paramString.charAt(i1));
          if (i3 != -1) {}
        }
        else
        {
          i3 = i1 - paramInt1;
          if ((i3 != 0) && (i3 <= 4)) {
            break label245;
          }
          return null;
          label185:
          if (paramString.regionMatches(i3, ".", 0, 1))
          {
            if (!a(paramString, i6, paramInt2, arrayOfByte, i1 - 2)) {
              return null;
            }
            paramInt1 = i1 + 2;
            i4 = i2;
            break;
          }
          return null;
        }
        i2 = (i2 << 4) + i3;
        i1 += 1;
      }
      label245:
      i3 = i5 + 1;
      arrayOfByte[i5] = ((byte)(i2 >>> 8 & 0xFF));
      i5 = i3 + 1;
      arrayOfByte[i3] = ((byte)(i2 & 0xFF));
      i3 = i1;
      i2 = i4;
      i1 = i5;
      i6 = paramInt1;
      break;
      label300:
      System.arraycopy(arrayOfByte, i4, arrayOfByte, arrayOfByte.length - (paramInt1 - i4), paramInt1 - i4);
      Arrays.fill(arrayOfByte, i4, arrayOfByte.length - paramInt1 + i4, (byte)0);
      try
      {
        label337:
        paramString = InetAddress.getByAddress(arrayOfByte);
        return paramString;
      }
      catch (UnknownHostException paramString)
      {
        throw new AssertionError();
      }
      label354:
      i5 = i1;
    }
  }
  
  private static boolean d(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      int i2;
      if (i1 < paramString.length())
      {
        i2 = paramString.charAt(i1);
        if ((i2 <= 31) || (i2 >= 127)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      if (" #%/:?@[\\]".indexOf(i2) != -1) {
        return true;
      }
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gn
 * JD-Core Version:    0.7.0.1
 */