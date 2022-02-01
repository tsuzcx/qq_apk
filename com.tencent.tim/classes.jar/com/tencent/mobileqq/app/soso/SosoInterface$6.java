package com.tencent.mobileqq.app.soso;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

final class SosoInterface$6
  implements Runnable
{
  SosoInterface$6(SosoInterface.a parama) {}
  
  public void run()
  {
    Object localObject = SosoInterface.a(this.e.maxCacheInterval, this.e.goonListener, this.e.level, this.e.reqLocation);
    if (localObject != null) {
      if (this.e.uiThread)
      {
        SosoInterface.b(this.e, 0, (SosoInterface.SosoLbsInfo)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "startLocation() lis=" + this.e.tag + " use cache and callback now");
        }
        SosoInterface.b(true, this.e.reqLocation, 0L, 0, this.e.tag, "ERROR_OK", this.e.askGPS, this.e.level, true);
      }
    }
    label312:
    label584:
    label594:
    do
    {
      return;
      this.e.onLocationFinish(0, (SosoInterface.SosoLbsInfo)localObject);
      break;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("startLocation() reqLoc=").append(this.e.reqLocation).append(" askGPS=").append(this.e.askGPS).append(" level=").append(this.e.level).append(" caller=").append(this.e.tag).append(" ui=").append(this.e.uiThread).append(" goon=").append(this.e.goonListener);
        if (SosoInterface.f().get() == 0)
        {
          localObject = " do startLocation";
          QLog.d("SOSO.LBS", 2, (String)localObject);
        }
      }
      else
      {
        SosoInterface.d(this.e);
        if (SosoInterface.f().get() != 0) {
          continue;
        }
        if (this.e != SosoInterface.a()) {
          break label584;
        }
        SosoInterface.f().set(1);
        this.e.sTime = SystemClock.elapsedRealtime();
        localObject = TencentLocationRequest.create();
        ((TencentLocationRequest)localObject).setInterval(SosoInterface.cAD);
        ((TencentLocationRequest)localObject).setRequestLevel(this.e.level);
        ((TencentLocationRequest)localObject).setAllowCache(true);
        ((TencentLocationRequest)localObject).setAllowGPS(this.e.askGPS);
        ((TencentLocationRequest)localObject).setCheckInterval(30000L);
        if (this.e.reqLocation) {
          break label594;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        TencentExtraKeys.setRequestRawData((TencentLocationRequest)localObject, bool);
        ((TencentLocationRequest)localObject).getExtras().putInt("qq_level", this.e.level);
        ((TencentLocationRequest)localObject).getExtras().putBoolean("qq_reqLocation", this.e.reqLocation);
        ((TencentLocationRequest)localObject).getExtras().putString("qq_caller", this.e.tag);
        ((TencentLocationRequest)localObject).getExtras().putBoolean("qq_goonListener", this.e.goonListener);
        SosoInterface.access$902(0);
        SosoInterface.M(SystemClock.elapsedRealtime());
        SosoInterface.gL(0);
        SosoInterface.a.access$1602(this.e, true);
        if (SosoInterface.a() == null) {
          SosoInterface.a(TencentLocationManager.getInstance(BaseApplicationImpl.getContext()));
        }
        if (SosoInterface.access$200().hasMessages(1001)) {
          SosoInterface.access$200().removeMessages(1001);
        }
        SosoInterface.access$200().sendEmptyMessageDelayed(1001, 35000L);
        SosoInterface.access$602(0);
        int i = SosoInterface.a().requestLocationUpdates((TencentLocationRequest)localObject, SosoInterface.a(), ThreadManager.getSubThreadLooper());
        QLog.i("SOSO.LBS", 1, "location manager requestLocationUpdates result is: " + i);
        return;
        localObject = " waitting...";
        break;
        SosoInterface.f().set(2);
        break label312;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SOSO.LBS", 2, "status != REQ_STOP");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.6
 * JD-Core Version:    0.7.0.1
 */