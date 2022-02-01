package com.tencent.feedback.eup;

import android.content.Context;
import com.tencent.feedback.common.e;
import com.tencent.feedback.proguard.Q;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
  implements com.tencent.feedback.upload.d
{
  private Context a;
  
  public d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static boolean a(Q paramQ, CrashStrategyBean paramCrashStrategyBean)
  {
    if ((paramQ != null) && (paramCrashStrategyBean != null) && (paramQ.b != null))
    {
      if (paramQ.b.size() == 0) {
        return false;
      }
      Object localObject = paramQ.b.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        e.b("key %s", new Object[] { (String)((Iterator)localObject).next() });
      }
      String str1 = (String)paramQ.b.get("B11");
      String str2 = (String)paramQ.b.get("B12");
      String str3 = (String)paramQ.b.get("B13");
      String str4 = (String)paramQ.b.get("B21");
      String str5 = (String)paramQ.b.get("B22");
      String str6 = (String)paramQ.b.get(Integer.valueOf(60));
      localObject = (String)paramQ.b.get(Integer.valueOf(50));
      boolean bool3;
      if (str1 != null)
      {
        bool3 = str1.equals("0") ^ true;
        e.b("%b", new Object[] { Boolean.valueOf(bool3) });
      }
      else
      {
        bool3 = true;
      }
      boolean bool4;
      if (str2 != null)
      {
        bool4 = str2.equals("0") ^ true;
        e.b("%b", new Object[] { Boolean.valueOf(bool4) });
      }
      else
      {
        bool4 = false;
      }
      boolean bool5;
      if (str3 != null)
      {
        bool5 = str3.equals("0") ^ true;
        e.b("%b", new Object[] { Boolean.valueOf(bool5) });
      }
      else
      {
        bool5 = false;
      }
      if (str4 != null)
      {
        bool1 = str4.equals("0") ^ true;
        if (paramCrashStrategyBean.isMerged() != bool1)
        {
          e.b("rqdp{  is merged changed} %b", new Object[] { Boolean.valueOf(bool1) });
          paramCrashStrategyBean.setMerged(bool1);
          bool1 = true;
          break label371;
        }
      }
      boolean bool1 = false;
      label371:
      boolean bool2 = bool1;
      if (str5 != null)
      {
        boolean bool6 = str5.equals("0") ^ true;
        bool2 = bool1;
        if (paramCrashStrategyBean.isAssertOn() != bool6)
        {
          paramCrashStrategyBean.setAssertEnable(bool6);
          e.b("rqdp{ Assert enable changed: } %s", new Object[] { Boolean.valueOf(bool6) });
          bool2 = true;
        }
      }
      bool1 = bool2;
      int i;
      if (str6 != null)
      {
        try
        {
          i = Integer.valueOf(str6).intValue();
          bool1 = bool2;
          if (paramCrashStrategyBean.getAssertTaskInterval() == i) {
            break label505;
          }
          paramCrashStrategyBean.setAssertTaskInterval(i);
          try
          {
            e.b("rqdp{ Assert task interval changed: } %s", new Object[] { Integer.valueOf(i) });
            bool1 = true;
          }
          catch (Exception paramQ)
          {
            bool1 = true;
          }
          if (e.a(paramQ)) {
            break label505;
          }
        }
        catch (Exception paramQ)
        {
          bool1 = bool2;
        }
        paramQ.printStackTrace();
      }
      label505:
      bool2 = bool1;
      if (localObject != null)
      {
        try
        {
          i = Integer.valueOf((String)localObject).intValue();
          bool2 = bool1;
          if (paramCrashStrategyBean.getAssertLimitCount() == i) {
            break label585;
          }
          paramCrashStrategyBean.setAssertLimitCount(i);
          try
          {
            e.b("rqdp{ Assert task interval changed: } %s", new Object[] { Integer.valueOf(i) });
            bool2 = true;
          }
          catch (Exception paramQ)
          {
            bool1 = true;
          }
          bool2 = bool1;
        }
        catch (Exception paramQ) {}
        if (!e.a(paramQ))
        {
          paramQ.printStackTrace();
          bool2 = bool1;
        }
      }
      label585:
      if (paramCrashStrategyBean.isOpenANR() != bool3)
      {
        paramCrashStrategyBean.setOpenANR(bool3);
        e.b("rqdp{ anr changed: } %b", new Object[] { Boolean.valueOf(bool3) });
        bool2 = true;
      }
      if (paramCrashStrategyBean.isBroadcast() != bool4)
      {
        paramCrashStrategyBean.setBroadcast(bool4);
        e.b("rqdp{ broad changed: } %b", new Object[] { Boolean.valueOf(bool4) });
        bool2 = true;
      }
      if (paramCrashStrategyBean.isReceiveBroadcast() != bool5)
      {
        paramCrashStrategyBean.setReceiveBroadcast(bool5);
        e.b("rqdp{ receiver changed: } %b", new Object[] { Boolean.valueOf(bool5) });
        return true;
      }
      return bool2;
    }
    return false;
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramInt == 510) && (paramArrayOfByte != null)) {
      try
      {
        f localf = f.l();
        if (localf == null)
        {
          e.c("rqdp{  imposiable handle response ,but no eup instance!}", new Object[0]);
          return;
        }
        Q localQ = new Q();
        localQ.a(new h(paramArrayOfByte));
        CrashStrategyBean localCrashStrategyBean2 = localf.q();
        CrashStrategyBean localCrashStrategyBean1 = localCrashStrategyBean2;
        if (localCrashStrategyBean2 == null)
        {
          localCrashStrategyBean1 = localf.p();
          if (localCrashStrategyBean1 == null)
          {
            e.b("rqdp{  init eup sStrategy by default}", new Object[0]);
            localCrashStrategyBean1 = new CrashStrategyBean();
          }
          else
          {
            e.b("rqdp{  init eup sStrategy by uStrategy}", new Object[0]);
            localCrashStrategyBean1 = localCrashStrategyBean1.clone();
          }
          localf.a(localCrashStrategyBean1);
        }
        if ((a(localQ, localCrashStrategyBean1)) && (paramBoolean))
        {
          e.b("rqdp{  save eup strategy}", new Object[0]);
          a.a(this.a, paramInt, paramArrayOfByte);
        }
        e.b("rqdp{  crashStrategy}[%s]", new Object[] { localQ });
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!e.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
        e.d("rqdp{  process crash strategy error} %s", new Object[] { paramArrayOfByte.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.d
 * JD-Core Version:    0.7.0.1
 */