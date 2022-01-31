package com.tencent.feedback.upload;

import android.content.Context;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.e;
import com.tencent.feedback.common.h;
import com.tencent.feedback.proguard.C;
import com.tencent.feedback.proguard.T;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.w;

public final class b
  extends AbstractUploadDatas
{
  private Context d = null;
  private C e = null;
  
  public b(Context paramContext)
  {
    super(paramContext, 1111, 15);
    this.d = paramContext;
  }
  
  public final C a()
  {
    e.b("rqdp{  QIMEIUploadDatas.getUploadRequestPackage() start}", new Object[0]);
    if (this.e != null) {
      return this.e;
    }
    h localh;
    try
    {
      localh = h.a(this.d);
      if (localh == null)
      {
        e.c("rqdp{  QIMEIInfo instance is null, return}", new Object[0]);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    for (;;)
    {
      return this.e;
      if (localh == null) {}
      int i;
      int j;
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        localObject2 = t.a(this.c).b();
        i = ((w)localObject2).f();
        j = ((w)localObject2).g();
        localObject2 = ((w)localObject2).d();
        localObject1 = a.a(((T)localObject1).a(), j, i, (String)localObject2);
        if (localObject1 != null) {
          break;
        }
        e.d("rqdp{  encodeDatasByZipAndEncry failed!}", new Object[0]);
        return null;
        localObject2 = new T();
        String str = localh.b();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        ((T)localObject2).b = ((String)localObject1);
        str = localh.d();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        ((T)localObject2).d = ((String)localObject1);
        str = localh.c();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        ((T)localObject2).c = ((String)localObject1);
        str = localh.e();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        ((T)localObject2).e = ((String)localObject1);
        str = localh.a();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        ((T)localObject2).a = ((String)localObject1);
      }
      Object localObject2 = c.p();
      this.e = a.a(this.a, (c)localObject2, (byte[])localObject1, j, i);
    }
  }
  
  public final void done(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.b
 * JD-Core Version:    0.7.0.1
 */