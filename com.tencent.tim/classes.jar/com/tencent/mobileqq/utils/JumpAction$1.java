package com.tencent.mobileqq.utils;

import acky;
import aqhv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PushBannerReportLog;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class JumpAction$1
  extends Thread
{
  public JumpAction$1(aqhv paramaqhv) {}
  
  public void run()
  {
    Object localObject1 = (String)this.this$0.attrs.get("version");
    Object localObject3 = acky.f(this.this$0.cti, this.this$0.ctj, (String)localObject1, "");
    localObject1 = this.this$0.app.a().createEntityManager();
    Object localObject4 = ((EntityManager)localObject1).query(PushBannerReportLog.class);
    Object localObject2;
    if ((localObject4 != null) && (((List)localObject4).size() >= 9))
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put(localObject3, Integer.valueOf(1));
      localObject3 = ((List)localObject4).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (PushBannerReportLog)((Iterator)localObject3).next();
        if (((HashMap)localObject2).containsKey(((PushBannerReportLog)localObject4).getLog())) {
          ((HashMap)localObject2).put(((PushBannerReportLog)localObject4).getLog(), Integer.valueOf(((Integer)((HashMap)localObject2).get(((PushBannerReportLog)localObject4).getLog())).intValue() + 1));
        } else {
          ((HashMap)localObject2).put(((PushBannerReportLog)localObject4).getLog(), Integer.valueOf(1));
        }
      }
      localObject3 = new ArrayList();
      localObject4 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject6 = (Map.Entry)((Iterator)localObject4).next();
        localObject5 = (String)((Map.Entry)localObject6).getKey();
        localObject6 = (Integer)((Map.Entry)localObject6).getValue();
        ((List)localObject3).add((String)localObject5 + "|" + localObject6);
      }
      localObject4 = this.this$0.app;
      Object localObject5 = this.this$0.app;
      ((acky)((QQAppInterface)localObject4).getBusinessHandler(5)).M((String[])((List)localObject3).toArray(new String[((List)localObject3).size()]));
      ((EntityManager)localObject1).drop(PushBannerReportLog.class);
      ((HashMap)localObject2).clear();
    }
    for (;;)
    {
      ((EntityManager)localObject1).close();
      return;
      localObject2 = new PushBannerReportLog();
      ((PushBannerReportLog)localObject2).setLog((String)localObject3);
      ((EntityManager)localObject1).persist((Entity)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.1
 * JD-Core Version:    0.7.0.1
 */