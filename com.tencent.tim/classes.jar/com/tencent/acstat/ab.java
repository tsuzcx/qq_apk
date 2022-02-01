package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.common.StatPreferences;
import com.tencent.acstat.event.EventType;
import com.tencent.acstat.event.b;
import com.tencent.acstat.event.d;
import java.util.Map;

class ab
{
  private static volatile long f = 0L;
  private d a;
  private StatReportStrategy b = null;
  private boolean c = false;
  private Context d = null;
  private long e = System.currentTimeMillis();
  
  public ab(d paramd)
  {
    this.a = paramd;
    this.b = StatConfig.getStatSendStrategy();
    this.c = paramd.f();
    this.d = paramd.e();
  }
  
  private void a(StatDispatchCallback paramStatDispatchCallback)
  {
    g.b(StatServiceImpl.e()).a(this.a, paramStatDispatchCallback);
  }
  
  private void b()
  {
    if (this.a.a() == EventType.CUSTOM)
    {
      String str = ((b)this.a).b().a;
      if (StatConfig.isEventIdInDontReportEventIdsSet(str)) {
        StatServiceImpl.f().w("eventid=" + str + " In DontReportEventIdsSet, droped.");
      }
    }
    do
    {
      do
      {
        return;
        if ((this.a.d() != null) && (this.a.d().isSendImmediately())) {
          this.b = StatReportStrategy.INSTANT;
        }
        if ((StatConfig.j) && (NetworkManager.getInstance(StatServiceImpl.e()).isWifi())) {
          this.b = StatReportStrategy.INSTANT;
        }
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("strategy=" + this.b.name());
        }
        switch (s.a[this.b.ordinal()])
        {
        default: 
          StatServiceImpl.f().error("Invalid stat strategy:" + StatConfig.getStatSendStrategy());
          return;
        case 1: 
          c();
          return;
        case 2: 
          af.a(this.d).a(this.a, null, this.c, false);
          if (StatConfig.isDebugEnable()) {
            StatServiceImpl.f().i("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + StatServiceImpl.c + ",difftime=" + (StatServiceImpl.c - this.e));
          }
          if (StatServiceImpl.c == 0L)
          {
            StatServiceImpl.c = StatPreferences.getLong(this.d, "last_period_ts", 0L);
            if (this.e > StatServiceImpl.c) {
              StatServiceImpl.d(this.d);
            }
            long l = this.e + StatConfig.getSendPeriodMinutes() * 60 * 1000;
            if (StatServiceImpl.c > l) {
              StatServiceImpl.c = l;
            }
            c.a(this.d).a();
          }
          if (StatConfig.isDebugEnable()) {
            StatServiceImpl.f().i("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + StatServiceImpl.c + ",difftime=" + (StatServiceImpl.c - this.e));
          }
          break;
        }
      } while (this.e <= StatServiceImpl.c);
      StatServiceImpl.d(this.d);
      return;
      af.a(this.d).a(this.a, null, this.c, false);
      return;
      af.a(this.d).a(this.a, new ac(this), this.c, true);
      return;
      if (NetworkManager.getInstance(StatServiceImpl.e()).getNetworkType() == 1)
      {
        c();
        return;
      }
      af.a(this.d).a(this.a, null, this.c, false);
      return;
    } while (!StatCommonHelper.isWiFiActive(this.d));
    a(new ad(this));
  }
  
  private void c()
  {
    if (((af.b().a > 0) && (StatConfig.l)) || (this.a.a() == EventType.BACKGROUND))
    {
      af.b().a(this.a, null, this.c, true);
      af.b().a(-1);
      return;
    }
    a(new ae(this));
  }
  
  private boolean d()
  {
    if (StatConfig.h > 0)
    {
      if (this.e > StatServiceImpl.k())
      {
        StatServiceImpl.l().clear();
        StatServiceImpl.a(this.e + StatConfig.i);
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("clear methodsCalledLimitMap, nextLimitCallClearTime=" + StatServiceImpl.k());
        }
      }
      Integer localInteger1 = Integer.valueOf(this.a.a().a());
      Integer localInteger2 = (Integer)StatServiceImpl.l().get(localInteger1);
      if (localInteger2 != null)
      {
        StatServiceImpl.l().put(localInteger1, Integer.valueOf(localInteger2.intValue() + 1));
        if (localInteger2.intValue() > StatConfig.h)
        {
          if (StatConfig.isDebugEnable()) {
            StatServiceImpl.f().e("event " + this.a.g() + " was discard, cause of called limit, current:" + localInteger2 + ", limit:" + StatConfig.h + ", period:" + StatConfig.i + " ms");
          }
          return true;
        }
      }
      else
      {
        StatServiceImpl.l().put(localInteger1, Integer.valueOf(1));
      }
    }
    return false;
  }
  
  public void a()
  {
    if (d()) {}
    do
    {
      return;
      if ((StatConfig.m > 0) && (this.e >= f))
      {
        StatServiceImpl.flushDataToDB(this.d);
        f = this.e + StatConfig.n;
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("nextFlushTime=" + f);
        }
      }
      if (!NetworkManager.getInstance(this.d).isNetworkAvailable()) {
        break;
      }
      if (StatConfig.isDebugEnable()) {
        StatServiceImpl.f().i("sendFailedCount=" + StatServiceImpl.a);
      }
      if (!StatServiceImpl.a())
      {
        b();
        return;
      }
      af.a(this.d).a(this.a, null, this.c, false);
    } while (this.e - StatServiceImpl.b <= 1800000L);
    StatServiceImpl.e(this.d);
    return;
    af.a(this.d).a(this.a, null, this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.ab
 * JD-Core Version:    0.7.0.1
 */