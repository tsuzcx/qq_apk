package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.e;
import com.tencent.feedback.upload.d;
import java.util.Map;

public final class r
  implements d
{
  private Context a = null;
  
  public r(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static boolean a(Q paramQ, w paramw)
  {
    if ((paramQ != null) && (paramw != null))
    {
      if (paramQ.b == null) {
        return false;
      }
      String str1 = (String)paramQ.b.get("B17");
      if (str1 != null)
      {
        bool1 = str1.equals("1");
        if (bool1 != paramw.f())
        {
          e.b("rqdp{  useStrategy changed to} %b", new Object[] { Boolean.valueOf(bool1) });
          paramw.a(bool1);
          bool2 = true;
          break label85;
        }
      }
      boolean bool2 = false;
      label85:
      if ((paramQ.a != null) && (!paramQ.a.equals(paramw.a())))
      {
        e.b("rqdp{  url changed to} %s", new Object[] { paramQ.a });
        paramw.a(paramQ.a);
        bool2 = true;
      }
      else
      {
        e.b("rqdp{  url same to} %s", new Object[] { paramQ.a });
      }
      str1 = (String)paramQ.b.get("B18");
      boolean bool1 = bool2;
      int i;
      if (str1 != null)
      {
        try
        {
          i = Integer.parseInt(str1);
          bool1 = bool2;
          if (i == paramw.b()) {
            break label251;
          }
          e.b("rqdp{  upStrategy changed to} %d", new Object[] { Integer.valueOf(i) });
          try
          {
            paramw.a(i);
            bool1 = true;
          }
          catch (Exception localException1)
          {
            bool2 = true;
          }
          bool1 = bool2;
        }
        catch (Exception localException2) {}
        if (!e.a(localException2))
        {
          localException2.printStackTrace();
          bool1 = bool2;
        }
      }
      label251:
      String str2 = (String)paramQ.b.get("B19");
      bool2 = bool1;
      if (str2 != null)
      {
        try
        {
          i = Integer.parseInt(str2);
          bool2 = bool1;
          if (i == paramw.c()) {
            break label348;
          }
          e.b("rqdp{  QueryPeriod changed to} %d", new Object[] { Integer.valueOf(i) });
          try
          {
            paramw.b(i);
            bool2 = true;
          }
          catch (Exception localException3)
          {
            bool1 = true;
          }
          bool2 = bool1;
        }
        catch (Exception localException4) {}
        if (!e.a(localException4))
        {
          localException4.printStackTrace();
          bool2 = bool1;
        }
      }
      label348:
      paramQ = (String)paramQ.b.get("B20");
      bool1 = bool2;
      if (paramQ != null)
      {
        boolean bool3 = paramQ.equals("0") ^ true;
        bool1 = bool2;
        if (bool3 != paramw.g())
        {
          e.b("rqdp{  enforceQuery changed to} %b", new Object[] { Boolean.valueOf(bool3) });
          paramw.b(bool3);
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramInt != 510)
    {
      e.c("rqdp{  com strategy unmatch key:}%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramArrayOfByte != null)
    {
      w localw = t.a(this.a).b();
      if (localw == null)
      {
        e.c("rqdp{  imposible! common strategy null!}", new Object[0]);
        return;
      }
      try
      {
        Q localQ = a.d(paramArrayOfByte);
        localQ.a(new h(paramArrayOfByte));
        if (a(localQ, localw))
        {
          if (paramBoolean)
          {
            e.b("rqdp{  update common strategy should save}", new Object[0]);
            a.a(this.a, paramInt, paramArrayOfByte);
          }
          e.b("rqdp{  com strategy changed notify!}", new Object[0]);
          t.a(this.a).a(localw);
        }
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!e.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
        e.d("rqdp{  error to common strategy!}", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.r
 * JD-Core Version:    0.7.0.1
 */