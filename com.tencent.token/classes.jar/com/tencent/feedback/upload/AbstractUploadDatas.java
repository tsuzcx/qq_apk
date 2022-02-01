package com.tencent.feedback.upload;

import android.content.Context;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.e;
import com.tencent.feedback.proguard.N;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.w;
import com.tencent.feedback.proguard.w.a;

public abstract class AbstractUploadDatas
{
  protected final int a;
  protected final int b;
  protected Context c;
  
  public AbstractUploadDatas(Context paramContext, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public static N a(Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      String str = t.a(paramContext).b().d();
      paramContext = a.a(paramInt, c.a(paramContext), paramArrayOfByte, (byte)2, (byte)1, str);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      e.c("rqdp{  imposiable comStrategy error} %s", new Object[] { paramContext.toString() });
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static void d()
  {
    e.c("rqdp{  encode failed, clear db data}", new Object[0]);
  }
  
  public abstract N a();
  
  public final byte[] a(boolean paramBoolean)
  {
    try
    {
      Object localObject = a();
      if (localObject != null)
      {
        localObject = ((N)localObject).a();
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
      e.d("rqdp{  encode to bytes failed}", new Object[0]);
    }
    return null;
  }
  
  public final int b()
  {
    return this.a;
  }
  
  public final String c()
  {
    try
    {
      if (this.b == 1111) {
        return t.a(this.c).b().a();
      }
      String str = t.a(this.c).b().c(this.b).a();
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.c("rqdp{  imposiable comStrategy error }%s", new Object[] { localThrowable.toString() });
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
  
  public abstract void done(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.AbstractUploadDatas
 * JD-Core Version:    0.7.0.1
 */