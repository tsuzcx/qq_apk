package com.tencent.mobileqq.activity.aio.helper;

import ajig;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import wwd;

public class MultiWindowAIOHelper$1
  implements Runnable
{
  public MultiWindowAIOHelper$1(wwd paramwwd) {}
  
  public void run()
  {
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)wwd.a(this.this$0).a(15);
    if ((!BaseChatItemLayout.bdx) && (!localAIOLongShotHelper.RS()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiWindowAIOHelper", 2, "AIO start multi window!");
      }
      ajig.a(wwd.a(this.this$0).mActivity, wwd.a(this.this$0).sessionInfo.aTl, wwd.a(this.this$0).sessionInfo.cZ, wwd.a(this.this$0).sessionInfo.aTn, "open_from_aio");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */