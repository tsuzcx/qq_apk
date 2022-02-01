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

public class by
{
  public byte[] a;
  public int[] b = new int[6];
  Runnable c = new Runnable()
  {
    public void run()
    {
      if (System.currentTimeMillis() - by.a(by.this) > 1000L)
      {
        TmsLog.i("mod_seed", "auto mod is excuting.");
        bw.a().d(by.b(by.this));
        by.a(by.this, System.currentTimeMillis());
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
        if (paramAnonymousMessage.arg1 == 0)
        {
          TmsLog.i("mod_seed", "mod seed done, success.");
          return;
        }
        if (cs.a().e() == null) {
          return;
        }
        paramAnonymousMessage = (e)paramAnonymousMessage.obj;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mod seed failed, errcode:");
        localStringBuilder.append(paramAnonymousMessage.a);
        TmsLog.e("mod_seed", localStringBuilder.toString());
      }
    }
  };
  private long j = 0L;
  
  public by()
  {
    e();
  }
  
  private void c(long paramLong)
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(new Date(paramLong));
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(((Calendar)localObject1).get(1));
    ((StringBuffer)localObject2).append('-');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(2) + 1, 2));
    ((StringBuffer)localObject2).append('-');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(5), 2));
    ((StringBuffer)localObject2).append(' ');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(11), 2));
    ((StringBuffer)localObject2).append(':');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(12), 2));
    ((StringBuffer)localObject2).append(':');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(13) / 30 * 30, 2));
    localObject1 = ((StringBuffer)localObject2).toString().getBytes();
    localObject2 = this.a;
    if (localObject2 == null) {
      return;
    }
    byte[] arrayOfByte = new byte[localObject2.length + localObject1.length];
    System.arraycopy(localObject2, 0, arrayOfByte, 0, localObject2.length);
    System.arraycopy(localObject1, 0, arrayOfByte, this.a.length, localObject1.length);
    localObject1 = new dw().a(arrayOfByte);
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
      this.b[k] = (n % 10);
      k += 1;
    }
    paramLong /= 1000L;
    k = this.e;
    this.f = (paramLong / k * k * 1000L);
  }
  
  public static String d()
  {
    try
    {
      String str = r().getString("token_info", "");
      return str;
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
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
      for (;;)
      {
        localObject2 = arrayOfInt2;
        try
        {
          if (k >= arrayOfInt2.length) {
            return localObject2;
          }
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
    Object localObject2 = cd.b();
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
    while (k < arrayOfByte.length)
    {
      arrayOfByte[k] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 256));
      localSecureRandom2.a(localSecureRandom2.a(k));
      localStringBuffer = new StringBuffer();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append(localSecureRandom2.nextInt());
      localStringBuffer.append(m);
      localStringBuffer.append(new Object().hashCode());
      localStringBuffer.insert(Math.abs(localSecureRandom2.nextInt()) % localStringBuffer.length(), (String)localObject2);
      localSecureRandom1.a(localStringBuffer.toString().getBytes());
      k += 1;
    }
    arrayOfByte[0] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 64));
    return ck.a(arrayOfByte);
  }
  
  private static SharedPreferences r()
  {
    switch ()
    {
    default: 
      return RqdApplication.n().getSharedPreferences("token_save_info", 0);
    case 3: 
      return RqdApplication.n().getSharedPreferences("token_save_info_gray", 0);
    case 2: 
      return RqdApplication.n().getSharedPreferences("token_save_info_exp", 0);
    case 1: 
      return RqdApplication.n().getSharedPreferences("token_save_info", 0);
    }
    return RqdApplication.n().getSharedPreferences("token_save_info_test", 0);
  }
  
  public String a(int paramInt)
  {
    long l = System.currentTimeMillis() + this.d + paramInt;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("get token code timestamp: ");
    ((StringBuilder)localObject1).append(l);
    TmsLog.i("mod_seed", ((StringBuilder)localObject1).toString());
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(new Date(l));
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(((Calendar)localObject1).get(1));
    ((StringBuffer)localObject2).append('-');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(2) + 1, 2));
    ((StringBuffer)localObject2).append('-');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(5), 2));
    ((StringBuffer)localObject2).append(' ');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(11), 2));
    ((StringBuffer)localObject2).append(':');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(12), 2));
    ((StringBuffer)localObject2).append(':');
    ((StringBuffer)localObject2).append(l.a(((Calendar)localObject1).get(13) / 30 * 30, 2));
    localObject1 = ((StringBuffer)localObject2).toString().getBytes();
    localObject2 = this.a;
    if (localObject2 == null) {
      return "";
    }
    byte[] arrayOfByte = new byte[localObject2.length + localObject1.length];
    System.arraycopy(localObject2, 0, arrayOfByte, 0, localObject2.length);
    System.arraycopy(localObject1, 0, arrayOfByte, this.a.length, localObject1.length);
    localObject2 = new dw().a(arrayOfByte);
    localObject1 = new byte[localObject2.length * 2];
    paramInt = 0;
    int k;
    while (paramInt < localObject2.length)
    {
      k = paramInt * 2;
      localObject1[k] = ((byte)((localObject2[paramInt] & 0xFF) >>> 4));
      localObject1[(k + 1)] = ((byte)(localObject2[paramInt] & 0xF));
      paramInt += 1;
    }
    localObject2 = new StringBuffer();
    paramInt = 0;
    while (paramInt < 6)
    {
      k = 0;
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
  
  public void a(dr paramdr)
  {
    this.a = new dw().a(ck.a(paramdr.e()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("computeSeed @active, shareKey: ");
    localStringBuilder.append(paramdr);
    localStringBuilder.append(" hexStr: ");
    localStringBuilder.append(l.a(this.a));
    TmsLog.i("mod_seed", localStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    new ep().a(paramString);
    this.g = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (System.currentTimeMillis() - this.j > 1000L)
      {
        TmsLog.i("mod_seed", "handle mod is excuting.");
        bw.a().d(this.i);
        this.j = System.currentTimeMillis();
      }
      return;
    }
    long l2 = n();
    if (l2 >= 31536000000L) {
      return;
    }
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.i.removeCallbacks(this.c);
    this.i.postDelayed(this.c, l1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("auto mod will excute in ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" ms later.");
    TmsLog.i("mod_seed", localStringBuilder.toString());
  }
  
  public boolean a()
  {
    byte[] arrayOfByte = this.a;
    return (arrayOfByte == null) || (arrayOfByte.length == 0);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@recordSeedExpireTime expiretime is server: ");
    localStringBuilder.append(l);
    TmsLog.i("mod_seed", localStringBuilder.toString());
    localEditor.commit();
  }
  
  public void c()
  {
    for (;;)
    {
      try
      {
        ew localew = new ew();
        if ((this.a != null) && (this.a.length > 0))
        {
          String str = q();
          a locala = new a();
          Object localObject3 = locala.b(this.a, com.tencent.token.utils.encrypt.c.a(str));
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = locala.b(this.a, com.tencent.token.utils.encrypt.c.a(str));
          }
          localObject3 = r();
          if (localObject3 == null) {
            break label172;
          }
          bool = true;
          g.a(bool);
          localObject3 = ((SharedPreferences)localObject3).edit();
          ((SharedPreferences.Editor)localObject3).putInt("token_type", 2);
          ((SharedPreferences.Editor)localObject3).putString("token_info", str);
          ((SharedPreferences.Editor)localObject3).commit();
          localew.a(this.d, this.e, (byte[])localObject1);
        }
        else
        {
          localew.a(this.d, this.e, this.a);
        }
        return;
      }
      finally {}
      label172:
      boolean bool = false;
    }
  }
  
  public void e()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = et.a();
        Object localObject3 = new ew();
        ((ew)localObject3).a((SQLiteDatabase)localObject1);
        if (!((ew)localObject3).a())
        {
          ((ew)localObject3).b = 0L;
          ((ew)localObject3).d = null;
          ((ew)localObject3).c = 30;
          ((ew)localObject3).b((SQLiteDatabase)localObject1);
        }
        Object localObject4 = new ep();
        ((ep)localObject4).a((SQLiteDatabase)localObject1);
        if (!((ep)localObject4).a())
        {
          ((ep)localObject4).b = "";
          ((ep)localObject4).b((SQLiteDatabase)localObject1);
        }
        this.d = ((ew)localObject3).b;
        this.a = ((ew)localObject3).d;
        this.e = ((ew)localObject3).c;
        this.g = ((ep)localObject4).b;
        localObject1 = r();
        if (localObject1 != null)
        {
          bool = true;
          g.a(bool);
          localObject3 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject3).putBoolean("token_status", true);
          ((SharedPreferences.Editor)localObject3).commit();
          if ((this.a != null) && (this.a.length > 0))
          {
            this.h = ((SharedPreferences)localObject1).getInt("token_type", 0);
            if (2 == this.h)
            {
              localObject4 = ((SharedPreferences)localObject1).getString("token_info", "");
              if ((localObject4 != null) && (((String)localObject4).length() != 0))
              {
                a locala = new a();
                localObject3 = locala.a(this.a, com.tencent.token.utils.encrypt.c.a((String)localObject4));
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = locala.a(this.a, com.tencent.token.utils.encrypt.c.a((String)localObject4));
                }
                this.a = ((byte[])localObject1);
              }
              else
              {
                this.a = null;
              }
            }
            else if (1 == this.h)
            {
              this.a = TknEncManager.a().decInitCode(this.a);
              c();
            }
            else
            {
              c();
            }
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
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
    try
    {
      localObject = p();
      StringBuffer localStringBuffer = new StringBuffer();
      int k = 0;
      while (k < localObject.length)
      {
        localStringBuffer.append(localObject[k]);
        k += 1;
      }
      l = Long.parseLong(localStringBuffer.toString());
    }
    catch (Exception localException)
    {
      Object localObject;
      long l;
      label53:
      break label53;
    }
    l = 0L;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tokenseq: ");
    ((StringBuilder)localObject).append(l);
    TmsLog.i("mod_seed", ((StringBuilder)localObject).toString());
    return l;
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
    boolean bool = false;
    if (l1 == 0L)
    {
      TmsLog.i("mod_seed", "@isSeedExpire expiretime is 0, will never be expired.");
      return false;
    }
    long l2 = System.currentTimeMillis() + this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@isSeedExpire expiretime is server: ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" client time with plus: ");
    localStringBuilder.append(l2);
    TmsLog.i("mod_seed", localStringBuilder.toString());
    if (l2 >= l1) {
      bool = true;
    }
    return bool;
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
    Object localObject1 = new int[16];
    Object localObject2 = new dw();
    Object localObject3 = new dw();
    int i1 = 0;
    for (;;)
    {
      int m;
      try
      {
        localObject2 = ((dw)localObject2).a(((dw)localObject3).a(this.a));
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
 * Qualified Name:     com.tencent.token.by
 * JD-Core Version:    0.7.0.1
 */