package com.tencent.mobileqq.location.net;

import aiqs;
import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class LocationHandler$3
  implements Runnable
{
  public LocationHandler$3(aiqs paramaiqs, SoftReference paramSoftReference) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked. call over time runnable");
    }
    if (aiqs.a(this.this$0) != null)
    {
      this.this$0.f(aiqs.a(this.this$0).getSessionType(), aiqs.a(this.this$0).xc(), aiqs.a(this.this$0), 4);
      this.this$0.a(aiqs.a(this.this$0), true);
    }
    QQToast.a(BaseApplicationImpl.context, "位置获取失败，请稍后再试", 0).show();
    Activity localActivity = (Activity)this.u.get();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      this.u.clear();
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.3
 * JD-Core Version:    0.7.0.1
 */