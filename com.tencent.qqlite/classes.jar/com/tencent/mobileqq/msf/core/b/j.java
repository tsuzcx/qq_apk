package com.tencent.mobileqq.msf.core.b;

import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class j
  extends Thread
{
  int a = 0;
  
  public j(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    Object localObject5;
    Object localObject6;
    Object localObject7;
    if (this.a == 0)
    {
      Object localObject1 = MsfStore.getNativeConfigStore().getConfig("MSF_NetflowRdmReport");
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
        try
        {
          localObject1 = HexUtil.hexStr2Bytes((String)localObject1);
          localObject5 = new h();
          ((h)localObject5).readFrom(new JceInputStream((byte[])localObject1));
          localObject1 = ((h)localObject5).a.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject5 = (l)((Iterator)localObject1).next();
            i.c.a("actNetworkFlowCollection", true, 0L, ((l)localObject5).b, ((l)localObject5).c, true, false);
            localObject6 = ((l)localObject5).c.entrySet().iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (Map.Entry)((Iterator)localObject6).next();
              if (!((String)((Map.Entry)localObject7).getKey()).equals("uin")) {
                QLog.d("MSF.C.NetworkTraffic", 1, "reportRDM for " + MsfSdkUtils.getShortUin(((l)localObject5).a) + " " + (String)((Map.Entry)localObject7).getKey() + ":" + (String)((Map.Entry)localObject7).getValue());
              }
            }
          }
          try
          {
            localIterator = i.a.a.entrySet().iterator();
            if (localIterator.hasNext())
            {
              localObject5 = (Map.Entry)localIterator.next();
              localObject6 = new StringBuffer();
              localObject7 = ((q)((Map.Entry)localObject5).getValue()).c.entrySet().iterator();
              while (((Iterator)localObject7).hasNext())
              {
                localEntry = (Map.Entry)((Iterator)localObject7).next();
                ((StringBuffer)localObject6).append((String)localEntry.getKey() + ":" + localEntry.getValue() + " ");
              }
            }
            return;
          }
          catch (Exception localException2)
          {
            QLog.d("MSF.C.NetworkTraffic", 1, "get monthData error " + localException2, localException2);
          }
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetworkTraffic", 2, "do reportRDM error " + localException1, localException1);
          }
          MsfStore.getNativeConfigStore().removeConfig("MSF_NetflowRdmReport");
        }
      }
    }
    Object localObject4;
    do
    {
      for (;;)
      {
        Iterator localIterator;
        Map.Entry localEntry;
        QLog.d("MSF.C.NetworkTraffic", 1, MsfSdkUtils.getShortUin((String)((Map.Entry)localObject5).getKey()) + " monthData " + localObject6);
      }
      Object localObject2 = MsfStore.getNativeConfigStore().getConfig("MONITOR_NetflowRdmReport");
      if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
        try
        {
          localObject2 = HexUtil.hexStr2Bytes((String)localObject2);
          localObject5 = new h();
          ((h)localObject5).readFrom(new JceInputStream((byte[])localObject2));
          localObject2 = ((h)localObject5).a.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject5 = (l)((Iterator)localObject2).next();
            i.c.a("monitorNetFlowResultReportRDM", true, 0L, ((l)localObject5).b, ((l)localObject5).c, true, false);
            localObject6 = ((l)localObject5).c.entrySet().iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (Map.Entry)((Iterator)localObject6).next();
              if (!((String)((Map.Entry)localObject7).getKey()).equals("uin")) {
                QLog.d("MSF.C.MonitorNetFlowStore", 1, "reportRDM new netflow for " + MsfSdkUtils.getShortUin(((l)localObject5).a) + " " + (String)((Map.Entry)localObject7).getKey() + ":" + (String)((Map.Entry)localObject7).getValue());
              }
            }
          }
          localObject3 = MsfStore.getNativeConfigStore().getConfig("cautionNetFlowSize");
        }
        catch (Exception localException3)
        {
          QLog.d("MSF.C.MonitorNetFlowStore", 1, "do reportRDM error ", localException3);
          MsfStore.getNativeConfigStore().removeConfig("MONITOR_NetflowRdmReport");
        }
      }
      Object localObject3;
      if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
        try
        {
          localObject3 = HexUtil.hexStr2Bytes((String)localObject3);
          localObject5 = new h();
          ((h)localObject5).readFrom(new JceInputStream((byte[])localObject3));
          localObject3 = ((h)localObject5).a.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (l)((Iterator)localObject3).next();
            i.c.a("monitorNetFlowCautionReportRDM", true, 0L, ((l)localObject5).b, ((l)localObject5).c, true, false);
            localObject6 = ((l)localObject5).c.entrySet().iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (Map.Entry)((Iterator)localObject6).next();
              if (!((String)((Map.Entry)localObject7).getKey()).equals("uin")) {
                QLog.d("MSF.C.MonitorNetFlowStore", 1, "reportRDM caution netflow for " + MsfSdkUtils.getShortUin(((l)localObject5).a) + " " + (String)((Map.Entry)localObject7).getKey() + ":" + (String)((Map.Entry)localObject7).getValue());
              }
            }
          }
          localObject4 = MsfStore.getNativeConfigStore().getConfig("MONITOR_NetflowRdmReportwithStatus");
        }
        catch (Exception localException4)
        {
          QLog.d("MSF.C.MonitorNetFlowStore", 1, "do reportRDM error ", localException4);
          MsfStore.getNativeConfigStore().removeConfig("cautionNetFlowSize");
        }
      }
    } while ((localObject4 == null) || (((String)localObject4).length() <= 0));
    try
    {
      localObject4 = HexUtil.hexStr2Bytes((String)localObject4);
      localObject5 = new h();
      ((h)localObject5).readFrom(new JceInputStream((byte[])localObject4));
      localObject4 = ((h)localObject5).a.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (l)((Iterator)localObject4).next();
        i.c.a("monitorNetFlowResultReportRDMWithStatus", true, 0L, ((l)localObject5).b, ((l)localObject5).c, true, false);
        localObject6 = ((l)localObject5).c.entrySet().iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (Map.Entry)((Iterator)localObject6).next();
          if (!((String)((Map.Entry)localObject7).getKey()).equals("uin")) {
            QLog.d("MSF.C.MonitorNetFlowStore", 1, "reportRDM new netflow with status for " + MsfSdkUtils.getShortUin(((l)localObject5).a) + " " + (String)((Map.Entry)localObject7).getKey() + ":" + (String)((Map.Entry)localObject7).getValue());
          }
        }
      }
      return;
    }
    catch (Exception localException5)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "do reportRDM error ", localException5);
      MsfStore.getNativeConfigStore().removeConfig("MONITOR_NetflowRdmReportwithStatus");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.j
 * JD-Core Version:    0.7.0.1
 */