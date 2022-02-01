package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.encrypt.TknEncManager;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import com.tencent.token.utils.l;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tmsdk.common.util.TmsLog;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class bw
{
  public byte[] a;
  public int[] b = new int[6];
  Runnable c = new Runnable()
  {
    public void run()
    {
      if (System.currentTimeMillis() - bw.a(bw.this) > 1000L)
      {
        TmsLog.i("mod_seed", "auto mod is excuting.");
        ca.a().e(bw.b(bw.this));
        bw.a(bw.this, System.currentTimeMillis());
      }
    }
  };
  private long d = 0L;
  private int e = 30;
  private long f = 0L;
  private String g = "";
  private int h = 0;
  private Handler i = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 4016)
      {
        if (paramAnonymousMessage.arg1 != 0) {
          break label25;
        }
        TmsLog.i("mod_seed", "mod seed done, success.");
      }
      label25:
      while (cq.a().e() == null) {
        return;
      }
      paramAnonymousMessage = (e)paramAnonymousMessage.obj;
      TmsLog.e("mod_seed", "mod seed failed, errcode:" + paramAnonymousMessage.a);
    }
  };
  private long j = 0L;
  
  public bw()
  {
    e();
  }
  
  private void c(long paramLong)
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(new Date(paramLong));
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(((Calendar)localObject1).get(1)).append('-').append(l.a(((Calendar)localObject1).get(2) + 1, 2)).append('-').append(l.a(((Calendar)localObject1).get(5), 2)).append(' ').append(l.a(((Calendar)localObject1).get(11), 2)).append(':').append(l.a(((Calendar)localObject1).get(12), 2)).append(':').append(l.a(((Calendar)localObject1).get(13) / 30 * 30, 2));
    localObject1 = ((StringBuffer)localObject2).toString().getBytes();
    if (this.a == null) {
      return;
    }
    localObject2 = new byte[this.a.length + localObject1.length];
    System.arraycopy(this.a, 0, localObject2, 0, this.a.length);
    System.arraycopy(localObject1, 0, localObject2, this.a.length, localObject1.length);
    localObject1 = new du().a((byte[])localObject2);
    localObject2 = new byte[localObject1.length * 2];
    int k = 0;
    while (k < localObject1.length)
    {
      localObject2[(k * 2)] = ((byte)((localObject1[k] & 0xFF) >>> 4));
      localObject2[(k * 2 + 1)] = ((byte)(localObject1[k] & 0xF));
      k += 1;
    }
    k = 0;
    while (k < 6)
    {
      int m = 0;
      int n = 0;
      while (m < 9)
      {
        n += localObject2[(k + 1 + m * 7)];
        m += 1;
      }
      this.b[k] = (n % 10);
      k += 1;
    }
    this.f = (paramLong / 1000L / this.e * this.e * 1000L);
  }
  
  public static String d()
  {
    try
    {
      String str = r().getString("token_info", "");
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private int[] p()
  {
    int[] arrayOfInt2 = new int[16];
    int k = 0;
    while (k < arrayOfInt2.length)
    {
      arrayOfInt2[k] = 0;
      k += 1;
    }
    Object localObject2 = r().getString("token_seq_sp", "");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = o();
    }
    localObject2 = arrayOfInt2;
    if (arrayOfInt2.length == ((String)localObject1).length())
    {
      k = 0;
      int[] arrayOfInt1;
      try
      {
        while (k < arrayOfInt2.length)
        {
          arrayOfInt2[k] = Integer.parseInt(String.valueOf(((String)localObject1).charAt(k)));
          k += 1;
        }
        return arrayOfInt2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        arrayOfInt1 = new int[16];
        k = 0;
      }
      for (;;)
      {
        localObject2 = arrayOfInt1;
        if (k >= arrayOfInt1.length) {
          break;
        }
        arrayOfInt1[k] = 0;
        k += 1;
      }
    }
    return localObject2;
  }
  
  private String q()
  {
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = cb.b();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = System.getProperty("microedition.platform");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    int m = Runtime.getRuntime().hashCode();
    try
    {
      PRNGFixes.a();
      localObject1 = new SecureRandom();
      SecureRandom localSecureRandom = new SecureRandom();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append((String)localObject2).append(localSecureRandom.nextInt()).append(System.currentTimeMillis()).append(m).append(new Object().hashCode());
      ((SecureRandom)localObject1).a(localStringBuffer.toString().getBytes());
      int k = 1;
      while (k < arrayOfByte.length)
      {
        arrayOfByte[k] = ((byte)(Math.abs(((SecureRandom)localObject1).nextInt()) % 256));
        localSecureRandom.a(localSecureRandom.a(k));
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(System.currentTimeMillis() + "").append(localSecureRandom.nextInt()).append(m).append(new Object().hashCode());
        localStringBuffer.insert(Math.abs(localSecureRandom.nextInt()) % localStringBuffer.length(), (String)localObject2);
        ((SecureRandom)localObject1).a(localStringBuffer.toString().getBytes());
        k += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      arrayOfByte[0] = ((byte)(Math.abs(localException.nextInt()) % 64));
    }
    return ci.a(arrayOfByte);
  }
  
  private static SharedPreferences r()
  {
    switch ()
    {
    default: 
      return RqdApplication.l().getSharedPreferences("token_save_info", 0);
    case 0: 
      return RqdApplication.l().getSharedPreferences("token_save_info_test", 0);
    case 1: 
      return RqdApplication.l().getSharedPreferences("token_save_info", 0);
    case 2: 
      return RqdApplication.l().getSharedPreferences("token_save_info_exp", 0);
    }
    return RqdApplication.l().getSharedPreferences("token_save_info_gray", 0);
  }
  
  public String a(int paramInt)
  {
    long l = System.currentTimeMillis() + this.d + paramInt;
    TmsLog.i("mod_seed", "get token code timestamp: " + l);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(new Date(l));
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(((Calendar)localObject1).get(1)).append('-').append(l.a(((Calendar)localObject1).get(2) + 1, 2)).append('-').append(l.a(((Calendar)localObject1).get(5), 2)).append(' ').append(l.a(((Calendar)localObject1).get(11), 2)).append(':').append(l.a(((Calendar)localObject1).get(12), 2)).append(':').append(l.a(((Calendar)localObject1).get(13) / 30 * 30, 2));
    localObject1 = ((StringBuffer)localObject2).toString().getBytes();
    if (this.a == null) {
      return "";
    }
    localObject2 = new byte[this.a.length + localObject1.length];
    System.arraycopy(this.a, 0, localObject2, 0, this.a.length);
    System.arraycopy(localObject1, 0, localObject2, this.a.length, localObject1.length);
    localObject2 = new du().a((byte[])localObject2);
    localObject1 = new byte[localObject2.length * 2];
    paramInt = 0;
    while (paramInt < localObject2.length)
    {
      localObject1[(paramInt * 2)] = ((byte)((localObject2[paramInt] & 0xFF) >>> 4));
      localObject1[(paramInt * 2 + 1)] = ((byte)(localObject2[paramInt] & 0xF));
      paramInt += 1;
    }
    localObject2 = new StringBuffer();
    paramInt = 0;
    while (paramInt < 6)
    {
      int k = 0;
      int m = 0;
      while (k < 9)
      {
        m += localObject1[(paramInt + 1 + k * 7)];
        k += 1;
      }
      ((StringBuffer)localObject2).append(m % 10);
      paramInt += 1;
    }
    return ((StringBuffer)localObject2).toString();
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
    this.f = 0L;
  }
  
  public void a(dp paramdp)
  {
    this.a = new du().a(ci.a(paramdp.e()));
    TmsLog.i("mod_seed", "computeSeed @active, shareKey: " + paramdp + " hexStr: " + l.a(this.a));
  }
  
  public void a(String paramString)
  {
    new em().a(paramString);
    this.g = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = 0L;
    if (paramBoolean) {
      if (System.currentTimeMillis() - this.j > 1000L)
      {
        TmsLog.i("mod_seed", "handle mod is excuting.");
        ca.a().e(this.i);
        this.j = System.currentTimeMillis();
      }
    }
    long l2;
    do
    {
      return;
      l2 = n();
    } while (l2 >= 31536000000L);
    if (l2 < 0L) {}
    for (;;)
    {
      this.i.removeCallbacks(this.c);
      this.i.postDelayed(this.c, l1);
      TmsLog.i("mod_seed", "auto mod will excute in " + l1 + " ms later.");
      return;
      l1 = l2;
    }
  }
  
  public boolean a()
  {
    return (this.a == null) || (this.a.length == 0);
  }
  
  public void b()
  {
    this.a = null;
  }
  
  public void b(long paramLong)
  {
    long l = paramLong;
    if (paramLong > 0L) {
      l = paramLong * 1000L;
    }
    SharedPreferences.Editor localEditor = r().edit();
    localEditor.putLong("seed_expire_time", l);
    TmsLog.i("mod_seed", "@recordSeedExpireTime expiretime is server: " + l);
    localEditor.commit();
  }
  
  public void c()
  {
    try
    {
      et localet = new et();
      String str;
      Object localObject2;
      byte[] arrayOfByte;
      if ((this.a != null) && (this.a.length > 0))
      {
        str = q();
        localObject2 = new a();
        arrayOfByte = ((a)localObject2).b(this.a, com.tencent.token.utils.encrypt.c.a(str));
        if (arrayOfByte != null) {
          break label176;
        }
        arrayOfByte = ((a)localObject2).b(this.a, com.tencent.token.utils.encrypt.c.a(str));
      }
      for (;;)
      {
        localObject2 = r();
        boolean bool;
        if (localObject2 != null)
        {
          bool = true;
          g.a(bool);
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt("token_type", 2);
          ((SharedPreferences.Editor)localObject2).putString("token_info", str);
          ((SharedPreferences.Editor)localObject2).commit();
          localet.a(this.d, this.e, arrayOfByte);
        }
        for (;;)
        {
          return;
          bool = false;
          break;
          localet.a(this.d, this.e, this.a);
        }
      }
    }
    finally {}
  }
  
  public void e()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Object localObject1 = eq.a();
        Object localObject3 = new et();
        ((et)localObject3).a((SQLiteDatabase)localObject1);
        if (!((et)localObject3).a())
        {
          ((et)localObject3).b = 0L;
          ((et)localObject3).d = null;
          ((et)localObject3).c = 30;
          ((et)localObject3).b((SQLiteDatabase)localObject1);
        }
        Object localObject4 = new em();
        ((em)localObject4).a((SQLiteDatabase)localObject1);
        if (!((em)localObject4).a())
        {
          ((em)localObject4).b = "";
          ((em)localObject4).b((SQLiteDatabase)localObject1);
        }
        this.d = ((et)localObject3).b;
        this.a = ((et)localObject3).d;
        this.e = ((et)localObject3).c;
        this.g = ((em)localObject4).b;
        localObject1 = r();
        if (localObject1 != null) {
          bool = true;
        }
        g.a(bool);
        localObject3 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject3).putBoolean("token_status", true);
        ((SharedPreferences.Editor)localObject3).commit();
        if ((this.a != null) && (this.a.length > 0))
        {
          this.h = ((SharedPreferences)localObject1).getInt("token_type", 0);
          if (2 != this.h) {
            break label287;
          }
          localObject4 = ((SharedPreferences)localObject1).getString("token_info", "");
          if ((localObject4 == null) || (((String)localObject4).length() == 0)) {
            this.a = null;
          }
        }
        else
        {
          return;
        }
        a locala = new a();
        localObject3 = locala.a(this.a, com.tencent.token.utils.encrypt.c.a((String)localObject4));
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = locala.a(this.a, com.tencent.token.utils.encrypt.c.a((String)localObject4));
        }
        this.a = ((byte[])localObject1);
        continue;
        if (1 != this.h) {
          break label316;
        }
      }
      finally {}
      label287:
      this.a = TknEncManager.a().decInitCode(this.a);
      c();
      continue;
      label316:
      c();
    }
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    int[] arrayOfInt = p();
    StringBuffer localStringBuffer = new StringBuffer();
    int k = 0;
    while (k < arrayOfInt.length)
    {
      localStringBuffer.append(arrayOfInt[k]);
      k += 1;
    }
    localStringBuffer.insert(12, '-');
    localStringBuffer.insert(8, '-');
    localStringBuffer.insert(4, '-');
    return localStringBuffer.toString();
  }
  
  public long h()
  {
    long l1 = 0L;
    try
    {
      int[] arrayOfInt = p();
      StringBuffer localStringBuffer = new StringBuffer();
      int k = 0;
      while (k < arrayOfInt.length)
      {
        localStringBuffer.append(arrayOfInt[k]);
        k += 1;
      }
      long l2 = Long.parseLong(localStringBuffer.toString());
      l1 = l2;
    }
    catch (Exception localException)
    {
      label56:
      break label56;
    }
    TmsLog.i("mod_seed", "tokenseq: " + l1);
    return l1;
  }
  
  public void i()
  {
    TmsLog.i("mod_seed", "invoke updateToken.");
    long l = System.currentTimeMillis() + this.d;
    if (l - this.f >= this.e * 1000)
    {
      a(false);
      c(l);
    }
  }
  
  public void j()
  {
    if (m()) {
      a(true);
    }
    c(System.currentTimeMillis() + this.d);
  }
  
  public String k()
  {
    return a(-30000);
  }
  
  public long l()
  {
    return this.d;
  }
  
  public boolean m()
  {
    long l1 = r().getLong("seed_expire_time", 0L);
    if (l1 == 0L) {
      TmsLog.i("mod_seed", "@isSeedExpire expiretime is 0, will never be expired.");
    }
    long l2;
    do
    {
      return false;
      l2 = System.currentTimeMillis() + this.d;
      TmsLog.i("mod_seed", "@isSeedExpire expiretime is server: " + l1 + " client time with plus: " + l2);
    } while (l2 < l1);
    return true;
  }
  
  public long n()
  {
    long l1 = r().getLong("seed_expire_time", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = this.d;
    if (l1 == 0L) {
      return 31536000000L;
    }
    return l1 - (l2 + l3);
  }
  
  public String o()
  {
    int i1 = 0;
    Object localObject1 = new int[16];
    Object localObject2 = new du();
    Object localObject3 = new du();
    for (;;)
    {
      try
      {
        localObject2 = ((du)localObject2).a(((du)localObject3).a(this.a));
        localObject3 = new byte[localObject2.length * 2];
        k = 0;
        if (k >= localObject2.length) {
          continue;
        }
        localObject3[(k * 2)] = ((byte)((localObject2[k] & 0xFF) >>> 4));
        localObject3[(k * 2 + 1)] = ((byte)(localObject2[k] & 0xF));
        k += 1;
        continue;
        if (localObject1[0] == 0) {
          localObject1[0] = 1;
        }
      }
      catch (Exception localException)
      {
        continue;
        k = 0;
      }
      localObject2 = new StringBuilder();
      int k = i1;
      if (k < localObject1.length)
      {
        ((StringBuilder)localObject2).append(localObject1[k]);
        k += 1;
      }
      else
      {
        localObject1 = r().edit();
        ((SharedPreferences.Editor)localObject1).putString("token_seq_sp", ((StringBuilder)localObject2).toString());
        ((SharedPreferences.Editor)localObject1).commit();
        return ((StringBuilder)localObject2).toString();
        while (k < 16)
        {
          int m = 0;
          int n = 0;
          while (m < 4)
          {
            n += localObject3[(m * 16 + k)];
            m += 1;
          }
          localObject1[k] = (n % 10);
          k += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bw
 * JD-Core Version:    0.7.0.1
 */