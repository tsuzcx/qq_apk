package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import aczc.b;
import android.os.Bundle;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

class IVCommonInterfaceImpl$1$1
  extends aczc.b
{
  IVCommonInterfaceImpl$1$1(IVCommonInterfaceImpl.1 param1, String paramString, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onLocationFinish code : ").append(paramInt).append(" info : ");
      if (paramSosoLbsInfo != null) {
        break label186;
      }
    }
    label186:
    for (Object localObject = null;; localObject = paramSosoLbsInfo.a)
    {
      QLog.i("IVCommonInterfaceImpl", 2, localObject);
      localObject = new Bundle();
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
      {
        ((Bundle)localObject).putDouble("lat", paramSosoLbsInfo.a.cd);
        ((Bundle)localObject).putDouble("lon", paramSosoLbsInfo.a.ce);
        ((Bundle)localObject).putString("nation", IVCommonInterfaceImpl.access$000(this.this$1.this$0, paramSosoLbsInfo.a.nation));
        ((Bundle)localObject).putString("province", IVCommonInterfaceImpl.access$000(this.this$1.this$0, paramSosoLbsInfo.a.province));
        ((Bundle)localObject).putString("city", IVCommonInterfaceImpl.access$000(this.this$1.this$0, paramSosoLbsInfo.a.city));
      }
      ((Bundle)localObject).putInt("code", paramInt);
      this.val$result[0] = localObject;
      this.val$latch.countDown();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */