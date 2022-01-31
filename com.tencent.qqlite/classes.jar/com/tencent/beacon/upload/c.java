package com.tencent.beacon.upload;

import android.content.Context;
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
    com.tencent.beacon.d.a.b("QIMEIUploadDatas.getUploadRequestPackage() start", new Object[0]);
    if (this.e != null) {
      return this.e;
    }
    com.tencent.beacon.b.a locala;
    try
    {
      locala = com.tencent.beacon.b.a.a(this.d);
      if (locala == null)
      {
        com.tencent.beacon.d.a.c("QIMEIInfo instance is null, return", new Object[0]);
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
      if (locala == null) {}
      int i;
      int j;
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        Object localObject3 = com.tencent.beacon.a.b.c.a(this.c).b();
        i = 1;
        j = 2;
        localObject2 = "*^@K#K@!";
        if (localObject3 != null)
        {
          i = ((com.tencent.beacon.a.b.e)localObject3).i();
          j = ((com.tencent.beacon.a.b.e)localObject3).j();
          localObject2 = ((com.tencent.beacon.a.b.e)localObject3).k();
        }
        localObject1 = com.tencent.beacon.b.a.a(((com.tencent.beacon.c.c.a)localObject1).a(), j, i, (String)localObject2);
        if (localObject1 != null) {
          break;
        }
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
      }
      Object localObject2 = com.tencent.beacon.a.e.m();
      this.e = com.tencent.beacon.b.a.a(this.a, (com.tencent.beacon.a.e)localObject2, (byte[])localObject1, j, i);
    }
  }
  
  public final void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.c
 * JD-Core Version:    0.7.0.1
 */