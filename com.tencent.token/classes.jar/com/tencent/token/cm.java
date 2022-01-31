package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.utils.encrypt.TknEncManager;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import com.tencent.token.utils.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class cm
{
  public byte[] a;
  public int[] b = new int[6];
  private long c = 0L;
  private int d = 30;
  private long e = 0L;
  private String f = "";
  private int g = 0;
  
  public cm()
  {
    e();
  }
  
  private void b(long paramLong)
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(new Date(paramLong));
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(((Calendar)localObject1).get(1)).append('-').append(w.a(((Calendar)localObject1).get(2) + 1, 2)).append('-').append(w.a(((Calendar)localObject1).get(5), 2)).append(' ').append(w.a(((Calendar)localObject1).get(11), 2)).append(':').append(w.a(((Calendar)localObject1).get(12), 2)).append(':').append(w.a(((Calendar)localObject1).get(13) / 30 * 30, 2));
    localObject1 = ((StringBuffer)localObject2).toString().getBytes();
    if (this.a == null) {
      return;
    }
    localObject2 = new byte[this.a.length + localObject1.length];
    System.arraycopy(this.a, 0, localObject2, 0, this.a.length);
    System.arraycopy(localObject1, 0, localObject2, this.a.length, localObject1.length);
    localObject1 = new fc().a((byte[])localObject2);
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
  
  public static String d()
  {
    try
    {
      String str = o().getString("token_info", "");
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private int[] m()
  {
    int[] arrayOfInt = new int[16];
    Object localObject1 = new fc();
    Object localObject2 = new fc();
    for (;;)
    {
      try
      {
        localObject1 = ((fc)localObject1).a(((fc)localObject2).a(this.a));
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
  
  private String n()
  {
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = cx.b();
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
    return dg.a(arrayOfByte);
  }
  
  private static SharedPreferences o()
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
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    long l3 = paramInt;
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(new Date(l1 + l2 + l3));
    ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+8"));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(((Calendar)localObject1).get(1)).append('-').append(w.a(((Calendar)localObject1).get(2) + 1, 2)).append('-').append(w.a(((Calendar)localObject1).get(5), 2)).append(' ').append(w.a(((Calendar)localObject1).get(11), 2)).append(':').append(w.a(((Calendar)localObject1).get(12), 2)).append(':').append(w.a(((Calendar)localObject1).get(13) / 30 * 30, 2));
    localObject1 = ((StringBuffer)localObject2).toString().getBytes();
    if (this.a == null) {
      return "";
    }
    localObject2 = new byte[this.a.length + localObject1.length];
    System.arraycopy(this.a, 0, localObject2, 0, this.a.length);
    System.arraycopy(localObject1, 0, localObject2, this.a.length, localObject1.length);
    localObject2 = new fc().a((byte[])localObject2);
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
      int i = 0;
      int j = 0;
      while (i < 9)
      {
        j += localObject1[(paramInt + 1 + i * 7)];
        i += 1;
      }
      ((StringBuffer)localObject2).append(j % 10);
      paramInt += 1;
    }
    return ((StringBuffer)localObject2).toString();
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
    this.e = 0L;
  }
  
  public void a(ex paramex)
  {
    this.a = new fc().a(dg.a(paramex.e()));
  }
  
  public void a(String paramString)
  {
    new fv().a(paramString);
    this.f = paramString;
  }
  
  public boolean a()
  {
    return (this.a == null) || (this.a.length == 0);
  }
  
  public void b()
  {
    this.a = null;
  }
  
  public void c()
  {
    try
    {
      ge localge = new ge();
      String str;
      Object localObject2;
      byte[] arrayOfByte;
      if ((this.a != null) && (this.a.length > 0))
      {
        str = n();
        localObject2 = new a();
        arrayOfByte = ((a)localObject2).b(this.a, com.tencent.token.utils.encrypt.c.a(str));
        if (arrayOfByte != null) {
          break label176;
        }
        arrayOfByte = ((a)localObject2).b(this.a, com.tencent.token.utils.encrypt.c.a(str));
      }
      for (;;)
      {
        localObject2 = o();
        boolean bool;
        if (localObject2 != null)
        {
          bool = true;
          h.a(bool);
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt("token_type", 2);
          ((SharedPreferences.Editor)localObject2).putString("token_info", str);
          ((SharedPreferences.Editor)localObject2).commit();
          localge.a(this.c, this.d, arrayOfByte);
        }
        for (;;)
        {
          return;
          bool = false;
          break;
          localge.a(this.c, this.d, this.a);
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
        Object localObject1 = ga.a();
        Object localObject3 = new ge();
        ((ge)localObject3).a((SQLiteDatabase)localObject1);
        if (!((ge)localObject3).a())
        {
          ((ge)localObject3).b = 0L;
          ((ge)localObject3).d = null;
          ((ge)localObject3).c = 30;
          ((ge)localObject3).b((SQLiteDatabase)localObject1);
        }
        Object localObject4 = new fv();
        ((fv)localObject4).a((SQLiteDatabase)localObject1);
        if (!((fv)localObject4).a())
        {
          ((fv)localObject4).b = "";
          ((fv)localObject4).b((SQLiteDatabase)localObject1);
        }
        this.c = ((ge)localObject3).b;
        this.a = ((ge)localObject3).d;
        this.d = ((ge)localObject3).c;
        this.f = ((fv)localObject4).b;
        localObject1 = o();
        if (localObject1 != null) {
          bool = true;
        }
        h.a(bool);
        localObject3 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject3).putBoolean("token_status", true);
        ((SharedPreferences.Editor)localObject3).commit();
        if ((this.a != null) && (this.a.length > 0))
        {
          this.g = ((SharedPreferences)localObject1).getInt("token_type", 0);
          if (2 != this.g) {
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
        if (1 != this.g) {
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
    return this.f;
  }
  
  public String g()
  {
    int[] arrayOfInt = m();
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
  
  public long h()
  {
    try
    {
      int[] arrayOfInt = m();
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
  
  public void i()
  {
    long l = System.currentTimeMillis() + this.c;
    if (l - this.e >= this.d * 1000) {
      b(l);
    }
  }
  
  public void j()
  {
    b(System.currentTimeMillis() + this.c);
  }
  
  public String k()
  {
    return a(-30000);
  }
  
  public long l()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cm
 * JD-Core Version:    0.7.0.1
 */