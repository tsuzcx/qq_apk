package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.kingkong.database.SQLiteDatabase;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.utils.encrypt.TknEncManager;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.encrypt.c;
import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import com.tencent.token.utils.s;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class u
{
  public byte[] a;
  public int[] b = new int[6];
  private long c = 0L;
  private int d = 30;
  private long e = 0L;
  private String f = "";
  private int g = 0;
  
  public u()
  {
    l();
  }
  
  public static String b()
  {
    try
    {
      String str = m().getString("token_info", "");
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private void b(long paramLong)
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(new Date(paramLong));
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(((Calendar)localObject1).get(1)).append('-').append(s.a(((Calendar)localObject1).get(2) + 1)).append('-').append(s.a(((Calendar)localObject1).get(5))).append(' ').append(s.a(((Calendar)localObject1).get(11))).append(':').append(s.a(((Calendar)localObject1).get(12))).append(':').append(s.a(((Calendar)localObject1).get(13) / 30 * 30));
    localObject1 = ((StringBuffer)localObject2).toString().getBytes();
    if (this.a == null) {
      return;
    }
    localObject2 = new byte[this.a.length + localObject1.length];
    System.arraycopy(this.a, 0, localObject2, 0, this.a.length);
    System.arraycopy(localObject1, 0, localObject2, this.a.length, localObject1.length);
    localObject1 = new fz().b((byte[])localObject2);
    localObject2 = new byte[localObject1.length * 2];
    int i = 0;
    while (i < localObject1.length)
    {
      localObject2[(i * 2)] = ((byte)((localObject1[i] & 0xFF) >>> 4));
      localObject2[(i * 2 + 1)] = ((byte)(localObject1[i] & 0xF));
      i += 1;
    }
    i = 0;
    while (i < 6)
    {
      int j = 0;
      int k = 0;
      while (j < 9)
      {
        k += localObject2[(i + 1 + j * 7)];
        j += 1;
      }
      this.b[i] = (k % 10);
      i += 1;
    }
    this.e = (paramLong / 1000L / this.d * this.d * 1000L);
  }
  
  private int[] j()
  {
    int[] arrayOfInt = new int[16];
    Object localObject1 = new fz();
    Object localObject2 = new fz();
    for (;;)
    {
      try
      {
        localObject1 = ((fz)localObject1).b(((fz)localObject2).b(this.a));
        localObject2 = new byte[localObject1.length * 2];
        i = 0;
        if (i < localObject1.length)
        {
          localObject2[(i * 2)] = ((byte)((localObject1[i] & 0xFF) >>> 4));
          localObject2[(i * 2 + 1)] = ((byte)(localObject1[i] & 0xF));
          i += 1;
          continue;
          if (arrayOfInt[0] == 0) {
            arrayOfInt[0] = 1;
          }
          return arrayOfInt;
        }
      }
      catch (Exception localException)
      {
        return arrayOfInt;
      }
      int i = 0;
      while (i < 16)
      {
        int j = 0;
        int k = 0;
        while (j < 4)
        {
          k += localObject2[(j * 16 + i)];
          j += 1;
        }
        arrayOfInt[i] = (k % 10);
        i += 1;
      }
    }
  }
  
  private static String k()
  {
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = ag.b();
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
    int j = Runtime.getRuntime().hashCode();
    try
    {
      PRNGFixes.a();
      localObject1 = new SecureRandom();
      SecureRandom localSecureRandom = new SecureRandom();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append((String)localObject2).append(localSecureRandom.nextInt()).append(System.currentTimeMillis()).append(j).append(new Object().hashCode());
      ((SecureRandom)localObject1).a(localStringBuffer.toString().getBytes());
      int i = 1;
      while (i < arrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)(Math.abs(((SecureRandom)localObject1).nextInt()) % 256));
        localSecureRandom.a(localSecureRandom.a(i));
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(System.currentTimeMillis() + "").append(localSecureRandom.nextInt()).append(j).append(new Object().hashCode());
        localStringBuffer.insert(Math.abs(localSecureRandom.nextInt()) % localStringBuffer.length(), (String)localObject2);
        ((SecureRandom)localObject1).a(localStringBuffer.toString().getBytes());
        i += 1;
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
    return ap.a(arrayOfByte);
  }
  
  private void l()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = gl.a();
        Object localObject3 = new gp();
        ((gp)localObject3).a((SQLiteDatabase)localObject1);
        Object localObject4 = (gp)gl.a((go)localObject3, "token_conf", new String[] { "plusTime", "tokenIntVTime", "data" });
        if (localObject4 == null)
        {
          i = 0;
          if (i == 0)
          {
            ((gp)localObject3).b = 0L;
            ((gp)localObject3).d = null;
            ((gp)localObject3).c = 30;
            ((gp)localObject3).b((SQLiteDatabase)localObject1);
          }
          localObject4 = new gg();
          ((gg)localObject4).a((SQLiteDatabase)localObject1);
          localObject5 = (gg)gl.a((go)localObject4, "ksid_data", new String[] { "ksid" });
          if (localObject5 == null)
          {
            i = 0;
            if (i == 0)
            {
              ((gg)localObject4).b = "";
              ((gg)localObject4).b((SQLiteDatabase)localObject1);
            }
            this.c = ((gp)localObject3).b;
            this.a = ((gp)localObject3).d;
            this.d = ((gp)localObject3).c;
            this.f = ((gg)localObject4).b;
            localObject1 = m();
            if (localObject1 == null) {
              break label438;
            }
            bool = true;
            e.a(bool);
            localObject3 = ((SharedPreferences)localObject1).edit();
            ((SharedPreferences.Editor)localObject3).putBoolean("token_status", true);
            ((SharedPreferences.Editor)localObject3).commit();
            if ((this.a != null) && (this.a.length > 0))
            {
              this.g = ((SharedPreferences)localObject1).getInt("token_type", 0);
              if (2 != this.g) {
                break label409;
              }
              localObject4 = ((SharedPreferences)localObject1).getString("token_info", "");
              if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
                continue;
              }
              this.a = null;
            }
          }
        }
        else
        {
          ((gp)localObject3).b = ((gp)localObject4).b;
          ((gp)localObject3).c = ((gp)localObject4).c;
          ((gp)localObject3).d = ((gp)localObject4).d;
          i = 1;
          continue;
        }
        ((gg)localObject4).b = ((gg)localObject5).b;
        int i = 1;
        continue;
        Object localObject5 = new a();
        localObject3 = ((a)localObject5).a(this.a, c.a((String)localObject4));
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = ((a)localObject5).a(this.a, c.a((String)localObject4));
        }
        this.a = ((byte[])localObject1);
        continue;
        if (1 != this.g) {
          break label431;
        }
      }
      finally {}
      label409:
      this.a = TknEncManager.a().decInitCode(this.a);
      label431:
      a();
      continue;
      label438:
      boolean bool = false;
    }
  }
  
  private static SharedPreferences m()
  {
    switch ()
    {
    default: 
      return RqdApplication.i().getSharedPreferences("token_save_info", 0);
    case 0: 
      return RqdApplication.i().getSharedPreferences("token_save_info_test", 0);
    case 1: 
      return RqdApplication.i().getSharedPreferences("token_save_info", 0);
    case 2: 
      return RqdApplication.i().getSharedPreferences("token_save_info_exp", 0);
    }
    return RqdApplication.i().getSharedPreferences("token_save_info_gray", 0);
  }
  
  public final void a()
  {
    try
    {
      gp localgp = new gp();
      String str;
      Object localObject2;
      byte[] arrayOfByte;
      if ((this.a != null) && (this.a.length > 0))
      {
        str = k();
        localObject2 = new a();
        arrayOfByte = ((a)localObject2).b(this.a, c.a(str));
        if (arrayOfByte != null) {
          break label175;
        }
        arrayOfByte = ((a)localObject2).b(this.a, c.a(str));
      }
      for (;;)
      {
        localObject2 = m();
        boolean bool;
        if (localObject2 != null)
        {
          bool = true;
          e.a(bool);
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt("token_type", 2);
          ((SharedPreferences.Editor)localObject2).putString("token_info", str);
          ((SharedPreferences.Editor)localObject2).commit();
          localgp.a(this.c, this.d, arrayOfByte);
        }
        for (;;)
        {
          return;
          bool = false;
          break;
          localgp.a(this.c, this.d, this.a);
        }
      }
    }
    finally {}
  }
  
  public final void a(long paramLong)
  {
    this.c = paramLong;
    this.e = 0L;
  }
  
  public final void a(String paramString)
  {
    new gg().a(paramString);
    this.f = paramString;
  }
  
  public final String c()
  {
    return this.f;
  }
  
  public final String d()
  {
    int[] arrayOfInt = j();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localStringBuffer.append(arrayOfInt[i]);
      i += 1;
    }
    localStringBuffer.insert(12, '-');
    localStringBuffer.insert(8, '-');
    localStringBuffer.insert(4, '-');
    return localStringBuffer.toString();
  }
  
  public final long e()
  {
    try
    {
      int[] arrayOfInt = j();
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < arrayOfInt.length)
      {
        localStringBuffer.append(arrayOfInt[i]);
        i += 1;
      }
      long l = Long.parseLong(localStringBuffer.toString());
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public final void f()
  {
    long l = System.currentTimeMillis() + this.c;
    if (l - this.e >= this.d * 1000) {
      b(l);
    }
  }
  
  public final void g()
  {
    b(System.currentTimeMillis() + this.c);
  }
  
  public final String h()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(new Date(l1 + l2 - 30000L));
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(((Calendar)localObject1).get(1)).append('-').append(s.a(((Calendar)localObject1).get(2) + 1)).append('-').append(s.a(((Calendar)localObject1).get(5))).append(' ').append(s.a(((Calendar)localObject1).get(11))).append(':').append(s.a(((Calendar)localObject1).get(12))).append(':').append(s.a(((Calendar)localObject1).get(13) / 30 * 30));
    localObject1 = ((StringBuffer)localObject2).toString().getBytes();
    if (this.a == null) {
      return "";
    }
    localObject2 = new byte[this.a.length + localObject1.length];
    System.arraycopy(this.a, 0, localObject2, 0, this.a.length);
    System.arraycopy(localObject1, 0, localObject2, this.a.length, localObject1.length);
    localObject2 = new fz().b((byte[])localObject2);
    localObject1 = new byte[localObject2.length * 2];
    int i = 0;
    while (i < localObject2.length)
    {
      localObject1[(i * 2)] = ((byte)((localObject2[i] & 0xFF) >>> 4));
      localObject1[(i * 2 + 1)] = ((byte)(localObject2[i] & 0xF));
      i += 1;
    }
    localObject2 = new StringBuffer();
    i = 0;
    while (i < 6)
    {
      int j = 0;
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
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.u
 * JD-Core Version:    0.7.0.1
 */