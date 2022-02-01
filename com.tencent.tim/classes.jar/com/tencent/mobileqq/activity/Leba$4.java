package com.tencent.mobileqq.activity;

import acgu;
import aevs;
import ahyj;
import aneb;
import aneo;
import anpc;
import avpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jnv;
import jsp;
import rar;
import vqn;
import zjq;

class Leba$4
  implements Runnable
{
  Leba$4(Leba paramLeba) {}
  
  public void run()
  {
    Object localObject = zjq.a().e(this.this$0.app);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aevs localaevs = (aevs)((Iterator)localObject).next();
        if ((localaevs != null) && (localaevs.a.uiResId == jsp.aCT)) {
          rar.a("dynamic", "exp_story", 0, ((jnv)this.this$0.app.getManager(70)).mP(), new String[0]);
        }
      }
    }
    Leba.a(this.this$0).begin();
    avpw.bp(this.this$0.app, "Leba");
    Leba.a(this.this$0);
    localObject = (aneo)this.this$0.app.getManager(10);
    boolean bool;
    if (localObject != null)
    {
      if ((this.this$0.app.a() != null) && (this.this$0.app.a().aav()))
      {
        bool = true;
        vqn.a((aneo)localObject, true, bool);
        if (((aneo)localObject).jn(1) <= 0) {
          break label467;
        }
        localObject = new QZoneClickReport.a();
        ((QZoneClickReport.a)localObject).actionType = "1";
        ((QZoneClickReport.a)localObject).cMI = "5";
        QZoneClickReport.report(this.this$0.app.getAccount(), (QZoneClickReport.a)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("unread_type", "5");
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.app.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
    }
    else {
      label268:
      if (System.currentTimeMillis() - LocalMultiProcConfig.getLong(BaseApplicationImpl.getContext().getString(2131718977) + this.this$0.app.getAccount(), 0L) > 86400000L)
      {
        localObject = new HashMap();
        if (!LocalMultiProcConfig.getBool(BaseApplicationImpl.getContext().getString(2131718976) + this.this$0.app.getAccount(), true)) {
          break label556;
        }
        ((HashMap)localObject).put("myfeednotifypush", "0");
        label375:
        if (!aneb.ac(BaseApplicationImpl.getContext(), "com.qzone")) {
          break label568;
        }
        ((HashMap)localObject).put("qzoneinstalled", "0");
      }
    }
    for (;;)
    {
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.app.getAccount(), "qzonepushstate", true, 0L, 0L, (HashMap)localObject, null);
      LocalMultiProcConfig.putLong(BaseApplicationImpl.getContext().getString(2131718977) + this.this$0.app.getAccount(), System.currentTimeMillis());
      return;
      bool = false;
      break;
      label467:
      if (((aneo)localObject).jn(2) <= 0) {
        break label268;
      }
      localObject = new QZoneClickReport.a();
      ((QZoneClickReport.a)localObject).actionType = "1";
      ((QZoneClickReport.a)localObject).cMI = "6";
      QZoneClickReport.report(this.this$0.app.getAccount(), (QZoneClickReport.a)localObject, false);
      localObject = new HashMap();
      ((HashMap)localObject).put("unread_type", "6");
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.app.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      break label268;
      label556:
      ((HashMap)localObject).put("myfeednotifypush", "1");
      break label375;
      label568:
      ((HashMap)localObject).put("qzoneinstalled", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.4
 * JD-Core Version:    0.7.0.1
 */