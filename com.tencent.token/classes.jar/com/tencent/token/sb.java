package com.tencent.token;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tmsdk.common.util.TmsLog;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class sb
{
  private static sb c;
  private static String d = "";
  private static String e = "https://aq.qq.com";
  public rw a = null;
  public su b = null;
  
  static
  {
    if (aaa.c == 0) {
      e = "http://test.aq.qq.com";
    }
  }
  
  public static String a()
  {
    return d;
  }
  
  public static void a(long paramLong)
  {
    paramLong *= 1000L;
    if (paramLong > 0L)
    {
      long l = System.currentTimeMillis();
      rw localrw = b().a;
      localrw.b = (paramLong - l);
      localrw.e = 0L;
      b().a.a();
      b().e();
    }
  }
  
  public static void a(String paramString)
  {
    e = paramString;
  }
  
  public static sb b()
  {
    if (c == null) {
      c = new sb();
    }
    return c;
  }
  
  public static void b(long paramLong)
  {
    long l = paramLong;
    if (paramLong > 0L) {
      l = paramLong * 1000L;
    }
    SharedPreferences.Editor localEditor = rw.c().edit();
    localEditor.putLong("seed_expire_time", l);
    TmsLog.i("mod_seed", "@recordSeedExpireTime expiretime is server: ".concat(String.valueOf(l)));
    localEditor.commit();
  }
  
  public static void b(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 15) {
      str = paramString.substring(0, 15);
    }
    d = aax.b(aax.a(str.getBytes()));
  }
  
  public static String g()
  {
    String str2 = "0000";
    String str3 = qy.a().e();
    String str1 = str2;
    if (str3 != null)
    {
      str1 = str2;
      if (str3.length() != 0)
      {
        str1 = str2;
        if (str3.length() >= 4) {
          str1 = str3.substring(0, 4);
        }
      }
    }
    return str1;
  }
  
  public static long h()
  {
    return 30000L - (System.currentTimeMillis() + qy.a().g()) % 30000L;
  }
  
  public final void a(aas paramaas)
  {
    rw localrw = this.a;
    localrw.a = new aba().b(sr.a(paramaas.a()));
    StringBuilder localStringBuilder = new StringBuilder("computeSeed @active, shareKey: ");
    localStringBuilder.append(paramaas);
    localStringBuilder.append(" hexStr: ");
    localStringBuilder.append(aac.a(localrw.a));
    TmsLog.i("mod_seed", localStringBuilder.toString());
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.a.a = paramArrayOfByte;
    StringBuilder localStringBuilder = new StringBuilder("recv initCode, hexStr: ");
    localStringBuilder.append(aac.a(paramArrayOfByte));
    TmsLog.i("mod_seed", localStringBuilder.toString());
    if (paramArrayOfByte != null) {
      vt.a(false);
    }
  }
  
  public final void c()
  {
    this.a.a = null;
  }
  
  public final void d()
  {
    rw localrw = this.a;
    TmsLog.i("mod_seed", "invoke updateToken.");
    long l = System.currentTimeMillis() + localrw.b;
    if (l - localrw.e >= localrw.c * 1000)
    {
      localrw.a(false);
      localrw.a(l);
    }
  }
  
  public final void e()
  {
    rw localrw = this.a;
    long l1 = rw.c().getLong("seed_expire_time", 0L);
    if (l1 == 0L)
    {
      TmsLog.i("mod_seed", "@isSeedExpire expiretime is 0, will never be expired.");
    }
    else
    {
      long l2 = System.currentTimeMillis() + localrw.b;
      StringBuilder localStringBuilder = new StringBuilder("@isSeedExpire expiretime is server: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" client time with plus: ");
      localStringBuilder.append(l2);
      TmsLog.i("mod_seed", localStringBuilder.toString());
      if (l2 >= l1)
      {
        i = 1;
        break label103;
      }
    }
    int i = 0;
    label103:
    if (i != 0) {
      localrw.a(true);
    }
    localrw.a(System.currentTimeMillis() + localrw.b);
  }
  
  public final String f()
  {
    Object localObject1 = this.a;
    long l = System.currentTimeMillis() + ((rw)localObject1).b - 30000L;
    TmsLog.i("mod_seed", "get token code timestamp: ".concat(String.valueOf(l)));
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTime(new Date(l));
    ((Calendar)localObject2).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject3 = new StringBuffer();
    ((StringBuffer)localObject3).append(((Calendar)localObject2).get(1));
    ((StringBuffer)localObject3).append('-');
    ((StringBuffer)localObject3).append(aac.a(((Calendar)localObject2).get(2) + 1));
    ((StringBuffer)localObject3).append('-');
    ((StringBuffer)localObject3).append(aac.a(((Calendar)localObject2).get(5)));
    ((StringBuffer)localObject3).append(' ');
    ((StringBuffer)localObject3).append(aac.a(((Calendar)localObject2).get(11)));
    ((StringBuffer)localObject3).append(':');
    ((StringBuffer)localObject3).append(aac.a(((Calendar)localObject2).get(12)));
    ((StringBuffer)localObject3).append(':');
    ((StringBuffer)localObject3).append(aac.a(((Calendar)localObject2).get(13) / 30 * 30));
    localObject2 = ((StringBuffer)localObject3).toString().getBytes();
    if (((rw)localObject1).a == null) {
      return "";
    }
    localObject3 = new byte[((rw)localObject1).a.length + localObject2.length];
    System.arraycopy(((rw)localObject1).a, 0, localObject3, 0, ((rw)localObject1).a.length);
    System.arraycopy(localObject2, 0, localObject3, ((rw)localObject1).a.length, localObject2.length);
    localObject2 = new aba().b((byte[])localObject3);
    localObject1 = new byte[localObject2.length * 2];
    int i = 0;
    int j;
    while (i < localObject2.length)
    {
      j = i * 2;
      localObject1[j] = ((byte)((localObject2[i] & 0xFF) >>> 4));
      localObject1[(j + 1)] = ((byte)(localObject2[i] & 0xF));
      i += 1;
    }
    localObject2 = new StringBuffer();
    i = 0;
    while (i < 6)
    {
      j = 0;
      int k = 0;
      while (j < 9)
      {
        k += localObject1[(i + 1 + j * 7)];
        j += 1;
      }
      ((StringBuffer)localObject2).append(k % 10);
      i += 1;
    }
    return ((StringBuffer)localObject2).toString();
  }
  
  public final long i()
  {
    return System.currentTimeMillis() + this.a.b;
  }
  
  public final void j()
  {
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sb
 * JD-Core Version:    0.7.0.1
 */