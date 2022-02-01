package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.encrypt.TknEncManager;
import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tmsdk.common.util.TmsLog;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class se
{
  public byte[] a;
  long b = 0L;
  int c = 30;
  public int[] d = new int[6];
  long e = 0L;
  public String f = "";
  Handler g = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 4016)
      {
        if (paramAnonymousMessage.arg1 == 0)
        {
          TmsLog.i("mod_seed", "mod seed done, success.");
          return;
        }
        if (th.a().k.b() == null) {
          return;
        }
        paramAnonymousMessage = (xh)paramAnonymousMessage.obj;
        StringBuilder localStringBuilder = new StringBuilder("mod seed failed, errcode:");
        localStringBuilder.append(paramAnonymousMessage.a);
        TmsLog.e("mod_seed", localStringBuilder.toString());
      }
    }
  };
  Runnable h = new Runnable()
  {
    public final void run()
    {
      if (System.currentTimeMillis() - se.this.i > 1000L)
      {
        TmsLog.i("mod_seed", "auto mod is excuting.");
        sc.a.a().b(se.this.g);
        se.this.i = System.currentTimeMillis();
      }
    }
  };
  long i = 0L;
  private int j = 0;
  
  public se()
  {
    h();
  }
  
  public static String b()
  {
    try
    {
      String str = c().getString("token_info", "");
      return str;
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  public static SharedPreferences c()
  {
    switch ()
    {
    default: 
      return RqdApplication.p().getSharedPreferences("token_save_info", 0);
    case 3: 
      return RqdApplication.p().getSharedPreferences("token_save_info_gray", 0);
    case 2: 
      return RqdApplication.p().getSharedPreferences("token_save_info_exp", 0);
    case 1: 
      return RqdApplication.p().getSharedPreferences("token_save_info", 0);
    }
    return RqdApplication.p().getSharedPreferences("token_save_info_test", 0);
  }
  
  private int[] f()
  {
    int[] arrayOfInt2 = new int[16];
    int k = 0;
    while (k < 16)
    {
      arrayOfInt2[k] = 0;
      k += 1;
    }
    Object localObject2 = c().getString("token_seq_sp", "");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = e();
    }
    localObject2 = arrayOfInt2;
    if (16 == ((String)localObject1).length())
    {
      k = 0;
      int[] arrayOfInt1;
      for (;;)
      {
        localObject2 = arrayOfInt2;
        if (k >= 16) {
          return localObject2;
        }
        try
        {
          arrayOfInt2[k] = Integer.parseInt(String.valueOf(((String)localObject1).charAt(k)));
          k += 1;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          arrayOfInt1 = new int[16];
          k = 0;
        }
      }
      for (;;)
      {
        localObject2 = arrayOfInt1;
        if (k >= 16) {
          break;
        }
        arrayOfInt1[k] = 0;
        k += 1;
      }
    }
    return localObject2;
  }
  
  private static String g()
  {
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = sj.a();
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
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    SecureRandom localSecureRandom1 = new SecureRandom();
    SecureRandom localSecureRandom2 = new SecureRandom();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((String)localObject2);
    localStringBuffer.append(localSecureRandom2.nextInt());
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append(m);
    localStringBuffer.append(new Object().hashCode());
    localSecureRandom1.a(localStringBuffer.toString().getBytes());
    int k = 1;
    while (k < 16)
    {
      arrayOfByte[k] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 256));
      localSecureRandom2.a(localSecureRandom2.a(k));
      localStringBuffer = new StringBuffer();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append(localSecureRandom2.nextInt());
      localStringBuffer.append(m);
      localStringBuffer.append(new Object().hashCode());
      localStringBuffer.insert(Math.abs(localSecureRandom2.nextInt()) % localStringBuffer.length(), (String)localObject2);
      localSecureRandom1.a(localStringBuffer.toString().getBytes());
      k += 1;
    }
    arrayOfByte[0] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 64));
    return sz.a(arrayOfByte);
  }
  
  private void h()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = ait.a();
        Object localObject3 = new aiw();
        ((SQLiteDatabase)localObject1).b("CREATE TABLE IF NOT EXISTS token_conf(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,plusTime INTEGER,tokenIntVTime INTEGER,data BLOB);");
        Object localObject4 = (aiw)ait.a((aiv)localObject3, "token_conf", new String[] { "plusTime", "tokenIntVTime", "data" });
        int k;
        if (localObject4 == null)
        {
          k = 0;
        }
        else
        {
          ((aiw)localObject3).b = ((aiw)localObject4).b;
          ((aiw)localObject3).c = ((aiw)localObject4).c;
          ((aiw)localObject3).d = ((aiw)localObject4).d;
          k = 1;
        }
        if (k == 0)
        {
          ((aiw)localObject3).b = 0L;
          ((aiw)localObject3).d = null;
          ((aiw)localObject3).c = 30;
          ((aiw)localObject3).b((SQLiteDatabase)localObject1);
        }
        localObject4 = new aip();
        ((SQLiteDatabase)localObject1).b("CREATE TABLE IF NOT EXISTS ksid_data(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,ksid TEXT);");
        Object localObject5 = (aip)ait.a((aiv)localObject4, "ksid_data", new String[] { "ksid" });
        if (localObject5 == null)
        {
          k = 0;
        }
        else
        {
          ((aip)localObject4).c = ((aip)localObject5).c;
          k = 1;
        }
        if (k == 0)
        {
          ((aip)localObject4).c = "";
          ((aip)localObject4).b((SQLiteDatabase)localObject1);
        }
        this.b = ((aiw)localObject3).b;
        this.a = ((aiw)localObject3).d;
        this.c = ((aiw)localObject3).c;
        this.f = ((aip)localObject4).c;
        localObject1 = c();
        if (localObject1 != null)
        {
          bool = true;
          xj.a(bool);
          localObject3 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject3).putBoolean("token_status", true);
          ((SharedPreferences.Editor)localObject3).commit();
          if ((this.a != null) && (this.a.length > 0))
          {
            this.j = ((SharedPreferences)localObject1).getInt("token_type", 0);
            if (2 == this.j)
            {
              localObject4 = ((SharedPreferences)localObject1).getString("token_info", "");
              if ((localObject4 != null) && (((String)localObject4).length() != 0))
              {
                localObject5 = new abh();
                localObject3 = ((abh)localObject5).a(this.a, abj.a((String)localObject4));
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = ((abh)localObject5).a(this.a, abj.a((String)localObject4));
                }
                this.a = ((byte[])localObject1);
                return;
              }
              this.a = null;
              return;
            }
            if (1 == this.j) {
              this.a = TknEncManager.a().decInitCode(this.a);
            }
            a();
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public final void a()
  {
    for (;;)
    {
      try
      {
        aiw localaiw = new aiw();
        if ((this.a != null) && (this.a.length > 0))
        {
          String str = g();
          abh localabh = new abh();
          Object localObject3 = localabh.b(this.a, abj.a(str));
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = localabh.b(this.a, abj.a(str));
          }
          localObject3 = c();
          if (localObject3 != null)
          {
            bool = true;
            xj.a(bool);
            localObject3 = ((SharedPreferences)localObject3).edit();
            ((SharedPreferences.Editor)localObject3).putInt("token_type", 2);
            ((SharedPreferences.Editor)localObject3).putString("token_info", str);
            ((SharedPreferences.Editor)localObject3).commit();
            localaiw.a(this.b, this.c, (byte[])localObject1);
          }
        }
        else
        {
          localaiw.a(this.b, this.c, this.a);
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  final void a(long paramLong)
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(new Date(paramLong));
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(((Calendar)localObject1).get(1));
    ((StringBuffer)localObject2).append('-');
    ((StringBuffer)localObject2).append(aao.a(((Calendar)localObject1).get(2) + 1));
    ((StringBuffer)localObject2).append('-');
    ((StringBuffer)localObject2).append(aao.a(((Calendar)localObject1).get(5)));
    ((StringBuffer)localObject2).append(' ');
    ((StringBuffer)localObject2).append(aao.a(((Calendar)localObject1).get(11)));
    ((StringBuffer)localObject2).append(':');
    ((StringBuffer)localObject2).append(aao.a(((Calendar)localObject1).get(12)));
    ((StringBuffer)localObject2).append(':');
    ((StringBuffer)localObject2).append(aao.a(((Calendar)localObject1).get(13) / 30 * 30));
    localObject1 = ((StringBuffer)localObject2).toString().getBytes();
    localObject2 = this.a;
    if (localObject2 == null) {
      return;
    }
    byte[] arrayOfByte = new byte[localObject2.length + localObject1.length];
    System.arraycopy(localObject2, 0, arrayOfByte, 0, localObject2.length);
    System.arraycopy(localObject1, 0, arrayOfByte, this.a.length, localObject1.length);
    localObject1 = new abm().b(arrayOfByte);
    localObject2 = new byte[localObject1.length * 2];
    int k = 0;
    int m;
    while (k < localObject1.length)
    {
      m = k * 2;
      localObject2[m] = ((byte)((localObject1[k] & 0xFF) >>> 4));
      localObject2[(m + 1)] = ((byte)(localObject1[k] & 0xF));
      k += 1;
    }
    k = 0;
    while (k < 6)
    {
      m = 0;
      int n = 0;
      while (m < 9)
      {
        n += localObject2[(k + 1 + m * 7)];
        m += 1;
      }
      this.d[k] = (n % 10);
      k += 1;
    }
    paramLong /= 1000L;
    k = this.c;
    this.e = (paramLong / k * k * 1000L);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (System.currentTimeMillis() - this.i > 1000L)
      {
        TmsLog.i("mod_seed", "handle mod is excuting.");
        sc.a.a().b(this.g);
        this.i = System.currentTimeMillis();
      }
      return;
    }
    Object localObject = c();
    long l2 = 0L;
    long l1 = ((SharedPreferences)localObject).getLong("seed_expire_time", 0L);
    long l3 = System.currentTimeMillis();
    long l4 = this.b;
    if (l1 == 0L) {
      l1 = 31536000000L;
    } else {
      l1 -= l3 + l4;
    }
    if (l1 >= 31536000000L) {
      return;
    }
    if (l1 < 0L) {
      l1 = l2;
    }
    this.g.removeCallbacks(this.h);
    this.g.postDelayed(this.h, l1);
    localObject = new StringBuilder("auto mod will excute in ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" ms later.");
    TmsLog.i("mod_seed", ((StringBuilder)localObject).toString());
  }
  
  public final long d()
  {
    try
    {
      int[] arrayOfInt = f();
      StringBuffer localStringBuffer = new StringBuffer();
      int k = 0;
      while (k < 16)
      {
        localStringBuffer.append(arrayOfInt[k]);
        k += 1;
      }
      l = Long.parseLong(localStringBuffer.toString());
    }
    catch (Exception localException)
    {
      long l;
      label52:
      break label52;
    }
    l = 0L;
    TmsLog.i("mod_seed", "tokenseq: ".concat(String.valueOf(l)));
    return l;
  }
  
  public final String e()
  {
    Object localObject1 = new int[16];
    Object localObject2 = new abm();
    Object localObject3 = new abm();
    int i1 = 0;
    for (;;)
    {
      int m;
      try
      {
        localObject2 = ((abm)localObject2).b(((abm)localObject3).b(this.a));
        localObject3 = new byte[localObject2.length * 2];
        k = 0;
        if (k >= localObject2.length) {
          continue;
        }
        m = k * 2;
        localObject3[m] = ((byte)((localObject2[k] & 0xFF) >>> 4));
        localObject3[(m + 1)] = ((byte)(localObject2[k] & 0xF));
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
      if (k < 16)
      {
        ((StringBuilder)localObject2).append(localObject1[k]);
        k += 1;
      }
      else
      {
        localObject1 = c().edit();
        ((SharedPreferences.Editor)localObject1).putString("token_seq_sp", ((StringBuilder)localObject2).toString());
        ((SharedPreferences.Editor)localObject1).commit();
        return ((StringBuilder)localObject2).toString();
        while (k < 16)
        {
          m = 0;
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
 * Qualified Name:     com.tencent.token.se
 * JD-Core Version:    0.7.0.1
 */