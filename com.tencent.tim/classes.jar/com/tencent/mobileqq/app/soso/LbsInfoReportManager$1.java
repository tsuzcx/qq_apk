package com.tencent.mobileqq.app.soso;

import aczb;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsInfoReportManager$1
  implements Runnable
{
  public LbsInfoReportManager$1(aczb paramaczb, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    LbsReportInfo localLbsReportInfo = new LbsReportInfo();
    localLbsReportInfo.operTime = NetConnInfoCenter.getServerTime();
    localLbsReportInfo.lat = this.ca;
    localLbsReportInfo.lng = this.cb;
    localLbsReportInfo.alt = this.cc;
    localLbsReportInfo.accuracy = this.sV;
    localLbsReportInfo.businessTag = this.brf;
    localLbsReportInfo.nation = this.brg;
    localLbsReportInfo.province = this.brh;
    localLbsReportInfo.city = this.val$city;
    localLbsReportInfo.district = this.bri;
    localLbsReportInfo.createContent();
    aczb.a(this.this$0).add(localLbsReportInfo);
    aczb.a(this.this$0, this.ca);
    aczb.b(this.this$0, this.cb);
    aczb.a(this.this$0, SystemClock.elapsedRealtime());
    if (QLog.isColorLevel()) {
      QLog.i("LBSReport", 2, "onReceiveLbsInfo cache size : " + aczb.a(this.this$0).size() + " lastReportTime: " + aczb.a(this.this$0) + " currentTime: " + NetConnInfoCenter.getServerTime());
    }
    int i;
    if ((aczb.a(this.this$0).a != null) && (!aczb.a(this.this$0).a.He()))
    {
      i = 1;
      if (i != 0) {
        break label245;
      }
    }
    label245:
    do
    {
      return;
      i = 0;
      break;
      if (!aczb.a(this.this$0)) {
        aczb.a(this.this$0);
      }
      if ((aczb.a(this.this$0).size() >= 20) || (NetConnInfoCenter.getServerTime() - aczb.a(this.this$0) >= 1200L))
      {
        this.this$0.C(aczb.a(this.this$0), 0);
        if (!aczb.b(this.this$0)) {
          this.this$0.a(aczb.a(this.this$0, aczb.a(this.this$0)), LbsReportInfo.convert2StrList(aczb.a(this.this$0)), aczb.a(this.this$0), 0);
        }
        aczb.a(this.this$0).clear();
        aczb.a(this.this$0).a().createEntityManager().delete(LbsReportInfo.class.getSimpleName(), null, null);
        aczb.b(this.this$0, NetConnInfoCenter.getServerTime());
        return;
      }
      aczb.a(this.this$0).a().createEntityManager().persist(localLbsReportInfo);
    } while (!QLog.isColorLevel());
    QLog.d("LBSReport", 2, "update db");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsInfoReportManager.1
 * JD-Core Version:    0.7.0.1
 */