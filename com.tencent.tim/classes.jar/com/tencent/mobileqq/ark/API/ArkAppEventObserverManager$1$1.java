package com.tencent.mobileqq.ark.API;

import adno;
import adno.d;
import adno.h;
import adnp;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(adnp paramadnp, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(adno.a(this.a.this$0)).append(", mPositionCallbackId=").append(adno.b(this.a.this$0)).append(", mGetCurrentPositionCallback=").append(adno.a(this.a.this$0)).append(", mGetCurrentPositionCallbackId=").append(adno.a(this.a.this$0)).append(", lbsInfo=").append(this.e).append(", lbsInfo.mLocation=");
      if (this.e != null)
      {
        localObject = this.e.a;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((adno.a(this.a.this$0) != null) || (adno.a(this.a.this$0) != null)) {
        break label180;
      }
      SosoInterface.c(adno.a(this.a.this$0));
    }
    label180:
    label367:
    double d1;
    double d2;
    label588:
    do
    {
      do
      {
        return;
        localObject = "NULL";
        break;
      } while ((this.e == null) || (this.e.a == null));
      if (QLog.isColorLevel())
      {
        if (adno.a(this.a.this$0) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.GE + ", positionCallback=" + adno.a(this.a.this$0) + ", lat02=" + this.e.a.cd + ", lon02=" + this.e.a.ce + ", lat84=" + this.e.a.cf + ", lon84=" + this.e.a.cg + ", mLastLat=" + adno.b(this.a.this$0) + ", mLastLon=" + adno.a(this.a.this$0));
      }
      double d3 = this.e.a.cf;
      double d4 = this.e.a.cg;
      d1 = d3;
      d2 = d4;
      if (d3 <= 1.0E-006D)
      {
        d1 = d3;
        d2 = d4;
        if (d4 <= 1.0E-006D)
        {
          localObject = adno.b(this.e.a.ce, this.e.a.cd);
          d3 = localObject[0];
          d4 = localObject[1];
          d1 = d4;
          d2 = d3;
          if (QLog.isColorLevel())
          {
            QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish gcj02towgs84 curLat=" + d4 + ", curLon=" + d3);
            d2 = d3;
            d1 = d4;
          }
        }
      }
      if ((adno.a(this.a.this$0) != null) && ((Math.abs(d1 - adno.b(this.a.this$0)) >= 1.0E-006D) || (Math.abs(d2 - adno.a(this.a.this$0)) >= 1.0E-006D)))
      {
        localObject = adno.a(this.a.this$0);
        if (this.GE != 0) {
          break label927;
        }
        bool = true;
        ((adno.h)localObject).b(bool, d1, d2);
        adno.a(this.a.this$0, d1);
        adno.b(this.a.this$0, d2);
      }
    } while (adno.a(this.a.this$0) == null);
    Object localObject = adno.a(this.a.this$0);
    if (this.GE == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((adno.d)localObject).b(bool, d1, d2);
      if (adno.a(this.a.this$0) != 0L) {
        adno.a(this.a.this$0).iT(adno.a(this.a.this$0));
      }
      adno.a(this.a.this$0, null);
      adno.a(this.a.this$0, 0L);
      if (adno.a(this.a.this$0) != null) {
        break;
      }
      SosoInterface.c(adno.a(this.a.this$0));
      return;
      label760:
      if (adno.a(this.a.this$0) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.GE + ", getcurrentPositionCallback=" + adno.a(this.a.this$0) + ", lat02=" + this.e.a.cd + ", lon02=" + this.e.a.ce + ", lat84=" + this.e.a.cf + ", lon84=" + this.e.a.cg + ", mLastLat=" + adno.b(this.a.this$0) + ", mLastLon=" + adno.a(this.a.this$0));
      break label367;
      label927:
      bool = false;
      break label588;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.1
 * JD-Core Version:    0.7.0.1
 */