package com.tencent.mobileqq.msf.core.d;

import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.k;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class g
  extends Thread
{
  int a = 0;
  
  public g(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (this.a == 0)
    {
      Object localObject1 = k.a().getConfig("MSF_NetflowRdmReport");
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
        try
        {
          localObject1 = HexUtil.hexStr2Bytes((String)localObject1);
          localObject3 = new e();
          ((e)localObject3).readFrom(new JceInputStream((byte[])localObject1));
          localObject1 = ((e)localObject3).a.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (i)((Iterator)localObject1).next();
            f.c.a("actNetworkFlowCollection", true, 0L, ((i)localObject3).b, ((i)localObject3).c, true, false);
            localObject4 = ((i)localObject3).c.entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (Map.Entry)((Iterator)localObject4).next();
              if (!((String)((Map.Entry)localObject5).getKey()).equals("uin")) {
                QLog.d("MSF.C.NetworkTraffic", 1, "reportRDM for " + MsfSdkUtils.getShortUin(((i)localObject3).a) + " " + (String)((Map.Entry)localObject5).getKey() + ":" + (String)((Map.Entry)localObject5).getValue());
              }
            }
          }
          try
          {
            localIterator = f.a.a.entrySet().iterator();
            if (localIterator.hasNext())
            {
              localObject3 = (Map.Entry)localIterator.next();
              localObject4 = new StringBuffer();
              localObject5 = ((n)((Map.Entry)localObject3).getValue()).c.entrySet().iterator();
              while (((Iterator)localObject5).hasNext())
              {
                localEntry = (Map.Entry)((Iterator)localObject5).next();
                ((StringBuffer)localObject4).append((String)localEntry.getKey() + ":" + localEntry.getValue() + " ");
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
          k.a().removeConfig("MSF_NetflowRdmReport");
        }
      }
    }
    Object localObject2;
    do
    {
      for (;;)
      {
        Iterator localIterator;
        Map.Entry localEntry;
        QLog.d("MSF.C.NetworkTraffic", 1, MsfSdkUtils.getShortUin((String)((Map.Entry)localObject3).getKey()) + " monthData " + localObject4);
      }
      localObject2 = k.a().getConfig("MONITOR_NetflowRdmReport");
    } while ((localObject2 == null) || (((String)localObject2).length() <= 0));
    try
    {
      localObject2 = HexUtil.hexStr2Bytes((String)localObject2);
      localObject3 = new e();
      ((e)localObject3).readFrom(new JceInputStream((byte[])localObject2));
      localObject2 = ((e)localObject3).a.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (i)((Iterator)localObject2).next();
        f.c.a("monitorNetFlowResultReportRDM", true, 0L, ((i)localObject3).b, ((i)localObject3).c, true, false);
        localObject4 = ((i)localObject3).c.entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          if (!((String)((Map.Entry)localObject5).getKey()).equals("uin")) {
            QLog.d("MSF.C.MonitorNetFlowStore", 1, "reportRDM new netflow for " + MsfSdkUtils.getShortUin(((i)localObject3).a) + " " + (String)((Map.Entry)localObject5).getKey() + ":" + (String)((Map.Entry)localObject5).getValue());
          }
        }
      }
      return;
    }
    catch (Exception localException3)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "do reportRDM error ", localException3);
      k.a().removeConfig("MONITOR_NetflowRdmReport");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.g
 * JD-Core Version:    0.7.0.1
 */