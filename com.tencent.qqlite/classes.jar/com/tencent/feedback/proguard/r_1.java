package com.tencent.feedback.proguard;

import android.content.Context;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;

public final class r
  implements com.tencent.feedback.upload.e
{
  private Context a = null;
  
  public r(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramInt != 300) {
      com.tencent.feedback.common.e.c("rqdp{  com strategy unmatch key:}%d", new Object[] { Integer.valueOf(paramInt) });
    }
    w localw;
    Object localObject1;
    do
    {
      do
      {
        return;
      } while (paramArrayOfByte == null);
      localw = t.a(this.a).b();
      if (localw == null)
      {
        com.tencent.feedback.common.e.c("rqdp{  imposible! common strategy null!}", new Object[0]);
        return;
      }
      try
      {
        localObject1 = new U();
        ((U)localObject1).a(new h(paramArrayOfByte));
        if (localObject1 == null) {
          break label1072;
        }
        if (localw != null) {
          break;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        com.tencent.feedback.common.e.d("rqdp{  error to common strategy!}", new Object[0]);
        return;
      }
    } while (i == 0);
    if (paramBoolean)
    {
      com.tencent.feedback.common.e.e("rqdp{  update common strategy should save}", new Object[0]);
      a.a(this.a, paramInt, paramArrayOfByte);
    }
    com.tencent.feedback.common.e.e("rqdp{  com strategy changed notify!}", new Object[0]);
    t.a(this.a).a(localw);
    com.tencent.feedback.common.a.a(this.a, "SVR_STRATEG_META", "true");
    return;
    int i = 0;
    if (((U)localObject1).g != localw.i())
    {
      com.tencent.feedback.common.e.b("rqdp{  useSStrategy changed to} %b", new Object[] { Boolean.valueOf(((U)localObject1).g) });
      i = 1;
      localw.a(((U)localObject1).g);
    }
    if (!((U)localObject1).e.equals(localw.a()))
    {
      com.tencent.feedback.common.e.b("rqdp{  url changed to} %s", new Object[] { ((U)localObject1).e });
      i = 1;
      localw.a(((U)localObject1).e);
    }
    if (((U)localObject1).c != localw.b())
    {
      com.tencent.feedback.common.e.b("rqdp{  upStrategy changed to} %d", new Object[] { Integer.valueOf(((U)localObject1).c) });
      i = 1;
      localw.a(((U)localObject1).c);
    }
    if (((U)localObject1).d != localw.c())
    {
      com.tencent.feedback.common.e.b("rqdp{  QueryPeriod changed to} %d", new Object[] { Integer.valueOf(((U)localObject1).d) });
      i = 1;
      localw.b(((U)localObject1).d);
    }
    int k = i;
    if (((U)localObject1).f != localw.k())
    {
      com.tencent.feedback.common.e.b("rqdp{  enforceQuery changed to} %b", new Object[] { Boolean.valueOf(((U)localObject1).f) });
      k = 1;
      localw.b(((U)localObject1).f);
    }
    Object localObject2 = ((U)localObject1).b;
    label423:
    int j;
    int m;
    if (localObject2 != null)
    {
      if (localw == null)
      {
        break label1078;
        localObject1 = ((U)localObject1).a;
        if (localw == null)
        {
          i = 0;
          break label1092;
        }
      }
      else
      {
        i = 0;
        if (((X)localObject2).c != localw.f())
        {
          com.tencent.feedback.common.e.b("rqdp{  ea changed:}%d", new Object[] { Integer.valueOf(((X)localObject2).c) });
          i = 1;
          localw.c(((X)localObject2).c);
        }
        if (((X)localObject2).d != localw.g())
        {
          com.tencent.feedback.common.e.b("rqdp{  za changed:}%d", new Object[] { Integer.valueOf(((X)localObject2).d) });
          i = 1;
          localw.d(((X)localObject2).d);
        }
        if (!((X)localObject2).a.equals(localw.d()))
        {
          com.tencent.feedback.common.e.b("rqdp{  enk changed}", new Object[0]);
          i = 1;
          localw.b(((X)localObject2).a);
        }
        if (((X)localObject2).b.equals(localw.e())) {
          break label1081;
        }
        com.tencent.feedback.common.e.b("rqdp{  enpk changed}", new Object[0]);
        i = 1;
        localw.c(((X)localObject2).b);
        break label1081;
      }
      j = 0;
      m = 0;
      i = 0;
      if (localObject1 != null)
      {
        localObject2 = localw.j();
        j = i;
        if (localObject2 != null)
        {
          m = 0;
          i = 0;
          label651:
          if (m >= ((SparseArray)localObject2).size()) {
            break label1119;
          }
          w.a locala = (w.a)((SparseArray)localObject2).valueAt(m);
          Iterator localIterator = ((ArrayList)localObject1).iterator();
          boolean bool1 = false;
          label683:
          if (localIterator.hasNext())
          {
            W localW = (W)localIterator.next();
            j = i;
            if (localW.a != locala.a) {
              break label1103;
            }
            boolean bool2 = true;
            if (locala.d() != localW.c)
            {
              com.tencent.feedback.common.e.b("rqdp{  mid:}%d rqdp{  , need detail changed:}%b ", new Object[] { Integer.valueOf(localW.a), Boolean.valueOf(localW.c) });
              i = 1;
              locala.c(localW.c);
            }
            bool1 = bool2;
            j = i;
            if (locala.a().equals(localW.b)) {
              break label1103;
            }
            com.tencent.feedback.common.e.b("rqdp{  mid:}%d rqdp{  , url changed:}%s", new Object[] { Integer.valueOf(localW.a), localW.b });
            j = 1;
            locala.a(localW.b);
            bool1 = bool2;
            break label1103;
          }
          if (bool1 == locala.c()) {
            break label1110;
          }
          com.tencent.feedback.common.e.b("rqdp{  mid:}%d rqdp{  , enable} %b", new Object[] { Integer.valueOf(locala.a), Boolean.valueOf(bool1) });
          i = 1;
          locala.b(bool1);
          break label1110;
        }
      }
    }
    for (;;)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (W)((Iterator)localObject1).next();
        if (localw.e(((W)localObject2).a) == null) {
          com.tencent.feedback.common.e.c("rqdp{  imposiable! module base strategy not ready! mId:}%d", new Object[] { Integer.valueOf(((W)localObject2).a) });
        }
      }
      localObject1 = localw.j();
      i = m;
      if (localObject1 != null)
      {
        m = 0;
        for (;;)
        {
          i = j;
          if (m >= ((SparseArray)localObject1).size()) {
            break;
          }
          localObject2 = (w.a)((SparseArray)localObject1).valueAt(m);
          if (((w.a)localObject2).c())
          {
            com.tencent.feedback.common.e.b("rqdp{  mid:}%d rqdp{  , server closed}", new Object[] { Integer.valueOf(((w.a)localObject2).e()) });
            j = 1;
            ((w.a)localObject2).b(false);
          }
          m += 1;
        }
      }
      label1072:
      label1078:
      label1081:
      label1092:
      while (i == 0)
      {
        i = k;
        break;
        i = 0;
        break;
        i = 0;
        if (i == 0) {
          break label423;
        }
        k = 1;
        break label423;
      }
      i = 1;
      break;
      label1103:
      i = j;
      break label683;
      label1110:
      m += 1;
      break label651;
      label1119:
      j = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.r
 * JD-Core Version:    0.7.0.1
 */