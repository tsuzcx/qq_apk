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
    if ((paramQ == null) || (paramCrashStrategyBean == null) || (paramQ.b == null) || (paramQ.b.size() == 0)) {
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
    boolean bool1;
    if (str1 != null) {
      if (str1.equals("0"))
      {
        bool1 = false;
        e.b("%b", new Object[] { Boolean.valueOf(bool1) });
      }
    }
    for (boolean bool3 = bool1;; bool3 = true)
    {
      if (str2 != null) {
        if (str2.equals("0"))
        {
          bool1 = false;
          label253:
          e.b("%b", new Object[] { Boolean.valueOf(bool1) });
        }
      }
      for (boolean bool4 = bool1;; bool4 = false)
      {
        if (str3 != null) {
          if (str3.equals("0"))
          {
            bool1 = false;
            label290:
            e.b("%b", new Object[] { Boolean.valueOf(bool1) });
          }
        }
        for (boolean bool5 = bool1;; bool5 = false)
        {
          if (str4 != null) {
            if (str4.equals("0"))
            {
              bool1 = false;
              label327:
              if (paramCrashStrategyBean.isMerged() == bool1) {
                break label711;
              }
              e.b("rqdp{  is merged changed} %b", new Object[] { Boolean.valueOf(bool1) });
              paramCrashStrategyBean.setMerged(bool1);
            }
          }
          label655:
          label670:
          label702:
          label705:
          label711:
          for (bool1 = true;; bool1 = false)
          {
            if (str5 != null) {
              if (str5.equals("0"))
              {
                bool2 = false;
                label377:
                if (paramCrashStrategyBean.isAssertOn() == bool2) {
                  break label705;
                }
                paramCrashStrategyBean.setAssertEnable(bool2);
                e.b("rqdp{ Assert enable changed: } %s", new Object[] { Boolean.valueOf(bool2) });
              }
            }
            for (boolean bool2 = true;; bool2 = bool1)
            {
              bool1 = bool2;
              if (str6 != null) {}
              try
              {
                i = Integer.valueOf(str6).intValue();
                bool1 = bool2;
                if (paramCrashStrategyBean.getAssertTaskInterval() != i) {
                  paramCrashStrategyBean.setAssertTaskInterval(i);
                }
              }
              catch (Exception paramQ)
              {
                for (;;)
                {
                  int i;
                  bool1 = bool2;
                  if (!e.a(paramQ)) {
                    paramQ.printStackTrace();
                  }
                }
              }
              for (;;)
              {
                try
                {
                  e.b("rqdp{ Assert task interval changed: } %s", new Object[] { Integer.valueOf(i) });
                  bool1 = true;
                  bool2 = bool1;
                  if (localObject == null) {
                    break;
                  }
                }
                catch (Exception paramQ)
                {
                  bool1 = true;
                  break label655;
                }
                try
                {
                  i = Integer.valueOf((String)localObject).intValue();
                  bool2 = bool1;
                  if (paramCrashStrategyBean.getAssertLimitCount() != i) {
                    paramCrashStrategyBean.setAssertLimitCount(i);
                  }
                }
                catch (Exception paramQ)
                {
                  bool2 = bool1;
                  if (e.a(paramQ)) {
                    break;
                  }
                  paramQ.printStackTrace();
                  bool2 = bool1;
                  break;
                }
              }
              try
              {
                e.b("rqdp{ Assert task interval changed: } %s", new Object[] { Integer.valueOf(i) });
                bool2 = true;
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
                if (paramCrashStrategyBean.isReceiveBroadcast() == bool5) {
                  break label702;
                }
                paramCrashStrategyBean.setReceiveBroadcast(bool5);
                e.b("rqdp{ receiver changed: } %b", new Object[] { Boolean.valueOf(bool5) });
                return true;
              }
              catch (Exception paramQ)
              {
                bool1 = true;
                break label670;
              }
              bool1 = true;
              break;
              bool1 = true;
              break label253;
              bool1 = true;
              break label290;
              bool1 = true;
              break label327;
              bool2 = true;
              break label377;
              return bool2;
            }
          }
        }
      }
    }
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramInt == 510) && (paramArrayOfByte != null)) {
      for (;;)
      {
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
          localCrashStrategyBean1 = localCrashStrategyBean2;
          if (localCrashStrategyBean2 == null)
          {
            localCrashStrategyBean1 = localf.p();
            if (localCrashStrategyBean1 == null)
            {
              e.b("rqdp{  init eup sStrategy by default}", new Object[0]);
              localCrashStrategyBean1 = new CrashStrategyBean();
              localf.a(localCrashStrategyBean1);
            }
          }
          else
          {
            if ((a(localQ, localCrashStrategyBean1)) && (paramBoolean))
            {
              e.b("rqdp{  save eup strategy}", new Object[0]);
              a.a(this.a, paramInt, paramArrayOfByte);
            }
            e.b("rqdp{  crashStrategy}[%s]", new Object[] { localQ });
            return;
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          if (!e.a(paramArrayOfByte)) {
            paramArrayOfByte.printStackTrace();
          }
          e.d("rqdp{  process crash strategy error} %s", new Object[] { paramArrayOfByte.toString() });
          return;
        }
        e.b("rqdp{  init eup sStrategy by uStrategy}", new Object[0]);
        CrashStrategyBean localCrashStrategyBean1 = localCrashStrategyBean1.clone();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.d
 * JD-Core Version:    0.7.0.1
 */