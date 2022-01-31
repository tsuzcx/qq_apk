package com.tencent.beacon.upload;

import android.content.Context;
import com.tencent.beacon.a.b.c;
import com.tencent.beacon.a.b.e;
import com.tencent.beacon.a.b.e.a;
import com.tencent.beacon.a.d;
import com.tencent.beacon.c.a.b;

public abstract class a
{
  protected final int a;
  protected final int b;
  protected Context c;
  
  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public static b a(Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null) {}
    try
    {
      c.a(paramContext).b();
      paramContext = com.tencent.beacon.b.a.a(paramArrayOfByte, -1, -1, null);
      localObject = paramContext;
      if (paramContext == null)
      {
        com.tencent.beacon.d.a.c("enzp error! :%d %d ", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1) });
        return null;
      }
      paramContext = com.tencent.beacon.b.a.a(paramInt, d.m(), (byte[])localObject, -1, -1);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.c("imposiable comStrategy error:%s", new Object[] { paramContext.toString() });
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public abstract b a();
  
  public abstract void a(boolean paramBoolean);
  
  public void b()
  {
    com.tencent.beacon.d.a.c("encode failed, clear db data", new Object[0]);
  }
  
  public final int c()
  {
    return this.a;
  }
  
  public final String d()
  {
    try
    {
      if (this.b == 0) {
        return c.a(this.c).b().b();
      }
      String str = c.a(this.c).b().b(this.b).b();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.c("imposiable comStrategy error:%s", new Object[] { localThrowable.toString() });
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.a
 * JD-Core Version:    0.7.0.1
 */