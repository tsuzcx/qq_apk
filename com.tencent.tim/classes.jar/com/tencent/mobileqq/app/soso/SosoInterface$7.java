package com.tencent.mobileqq.app.soso;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tlm;
import tlm.a;
import tlm.b;
import tlo;
import tlo.a;

final class SosoInterface$7
  implements Runnable
{
  public void run()
  {
    tlo.a().a(BaseApplication.getContext(), new tlo.a());
    Object localObject = new tlm.a();
    ((tlm.a)localObject).aJy = "8b5c3a";
    localObject = tlm.a(BaseApplication.getContext(), (tlm.a)localObject);
    if (localObject != null) {
      localObject = ((tlm.b)localObject).b;
    }
    for (;;)
    {
      if (localObject != null) {
        SosoInterface.brj = ((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get();
      }
      if (!TextUtils.isEmpty(SosoInterface.brj))
      {
        if (SosoInterface.a() == null) {
          SosoInterface.a(TencentLocationManager.getInstance(BaseApplicationImpl.getContext()));
        }
        try
        {
          SosoInterface.a().setDeviceID(new Pair("oaId", SosoInterface.brj));
          if (QLog.isColorLevel()) {
            QLog.d("SOSO.LBS", 2, "mLocationManager.setDeviceId（） mOaid = " + SosoInterface.brj);
          }
          return;
          localObject = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("SOSO.LBS", 1, "setDeviceId（） has exception = " + localException);
          }
        }
      }
    }
    QLog.d("SOSO.LBS", 1, "getOaid（） mOaid is empty ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.7
 * JD-Core Version:    0.7.0.1
 */