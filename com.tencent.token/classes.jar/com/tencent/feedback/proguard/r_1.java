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
    if ((paramQ == null) || (paramw == null) || (paramQ.b == null))
    {
      bool1 = false;
      return bool1;
    }
    String str = (String)paramQ.b.get("B17");
    if (str != null) {
      if (str.equals("1"))
      {
        bool1 = true;
        label52:
        if (bool1 == paramw.f()) {
          break label433;
        }
        e.b("rqdp{  useStrategy changed to} %b", new Object[] { Boolean.valueOf(bool1) });
        paramw.a(bool1);
      }
    }
    boolean bool2;
    label133:
    label298:
    label433:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramQ.a != null) && (!paramQ.a.equals(paramw.a())))
      {
        e.b("rqdp{  url changed to} %s", new Object[] { paramQ.a });
        paramw.a(paramQ.a);
        bool2 = true;
        str = (String)paramQ.b.get("B18");
        bool1 = bool2;
        if (str == null) {}
      }
      for (;;)
      {
        for (;;)
        {
          int i;
          boolean bool3;
          try
          {
            i = Integer.parseInt(str);
            bool1 = bool2;
            if (i != paramw.b()) {
              e.b("rqdp{  upStrategy changed to} %d", new Object[] { Integer.valueOf(i) });
            }
          }
          catch (Exception localException1) {}
          for (;;)
          {
            try
            {
              paramw.a(i);
              bool1 = true;
              str = (String)paramQ.b.get("B19");
              bool2 = bool1;
              if (str == null) {
                break;
              }
            }
            catch (Exception localException4)
            {
              bool2 = true;
              continue;
            }
            try
            {
              i = Integer.parseInt(str);
              bool2 = bool1;
              if (i != paramw.c()) {
                e.b("rqdp{  QueryPeriod changed to} %d", new Object[] { Integer.valueOf(i) });
              }
            }
            catch (Exception localException2)
            {
              bool2 = bool1;
              if (e.a(localException2)) {
                break;
              }
              localException2.printStackTrace();
              bool2 = bool1;
              break;
              bool3 = true;
              break label298;
            }
          }
          try
          {
            paramw.b(i);
            bool2 = true;
            paramQ = (String)paramQ.b.get("B20");
            bool1 = bool2;
            if (paramQ == null) {
              break;
            }
            if (!paramQ.equals("0")) {
              break label412;
            }
            bool3 = false;
            bool1 = bool2;
            if (bool3 == paramw.g()) {
              break;
            }
            e.b("rqdp{  enforceQuery changed to} %b", new Object[] { Boolean.valueOf(bool3) });
            paramw.b(bool3);
            return true;
          }
          catch (Exception localException3)
          {
            bool1 = true;
            break label390;
          }
        }
        bool1 = false;
        break label52;
        e.b("rqdp{  url same to} %s", new Object[] { paramQ.a });
        bool2 = bool1;
        break label133;
        bool1 = bool2;
        if (!e.a(localException1))
        {
          localException1.printStackTrace();
          bool1 = bool2;
        }
      }
    }
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramInt != 510) {
      e.c("rqdp{  com strategy unmatch key:}%d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      return;
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
            return;
          }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.r
 * JD-Core Version:    0.7.0.1
 */