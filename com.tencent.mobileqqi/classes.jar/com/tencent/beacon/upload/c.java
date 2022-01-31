package com.tencent.beacon.upload;

import android.content.Context;
import com.tencent.beacon.a.b.e;
import com.tencent.beacon.a.d;
import com.tencent.beacon.c.a.b;

public final class c
  extends a
{
  private Context d = null;
  private b e = null;
  
  public c(Context paramContext)
  {
    super(paramContext, 0, 102);
    this.d = paramContext;
  }
  
  public final b a()
  {
    int i = 1;
    com.tencent.beacon.d.a.b("QIMEIUploadDatas.getUploadRequestPackage() start}", new Object[0]);
    if (this.e != null) {
      return this.e;
    }
    com.tencent.beacon.b.a locala;
    try
    {
      locala = com.tencent.beacon.b.a.a(this.d);
      if (locala != null) {
        break label58;
      }
      com.tencent.beacon.d.a.c("QIMEIInfo instance is null, return}", new Object[0]);
      return null;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return this.e;
    label58:
    Object localObject1;
    label65:
    Object localObject3;
    Object localObject2;
    int j;
    if (locala == null)
    {
      localObject1 = null;
      localObject3 = com.tencent.beacon.a.b.c.a(this.c).b();
      localObject2 = "*^@K#K@!";
      if (localObject3 == null) {
        break label291;
      }
      i = ((e)localObject3).f();
      j = ((e)localObject3).g();
      localObject2 = ((e)localObject3).h();
    }
    for (;;)
    {
      localObject1 = com.tencent.beacon.b.a.a(((com.tencent.beacon.c.c.a)localObject1).a(), j, i, (String)localObject2);
      if (localObject1 == null)
      {
        com.tencent.beacon.d.a.d("encodeDatasByZipAndEncry failed!", new Object[0]);
        return null;
        localObject2 = new com.tencent.beacon.c.c.a();
        localObject3 = locala.b();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ((com.tencent.beacon.c.c.a)localObject2).b = ((String)localObject1);
        localObject3 = locala.d();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ((com.tencent.beacon.c.c.a)localObject2).d = ((String)localObject1);
        localObject3 = locala.c();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ((com.tencent.beacon.c.c.a)localObject2).c = ((String)localObject1);
        localObject3 = locala.e();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ((com.tencent.beacon.c.c.a)localObject2).e = ((String)localObject1);
        localObject3 = locala.a();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ((com.tencent.beacon.c.c.a)localObject2).a = ((String)localObject1);
        localObject1 = localObject2;
        break label65;
      }
      localObject2 = d.m();
      this.e = com.tencent.beacon.b.a.a(this.a, (d)localObject2, (byte[])localObject1, j, i);
      break;
      label291:
      j = 1;
    }
  }
  
  public final void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.c
 * JD-Core Version:    0.7.0.1
 */