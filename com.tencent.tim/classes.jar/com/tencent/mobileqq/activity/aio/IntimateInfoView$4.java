package com.tencent.mobileqq.activity.aio;

import aejw;
import aejx;
import ahpl;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import wll;

public class IntimateInfoView$4
  implements Runnable
{
  public IntimateInfoView$4(wll paramwll) {}
  
  public void run()
  {
    if ((this.this$0.mApp != null) && (!TextUtils.isEmpty(this.this$0.mFriendUin)))
    {
      ahpl localahpl = (ahpl)this.this$0.mApp.getManager(323);
      IntimateInfo localIntimateInfo = localahpl.a(this.this$0.mFriendUin);
      if (localIntimateInfo != null)
      {
        wll.a(this.this$0, localIntimateInfo);
        Message localMessage = wll.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        wll.a(this.this$0).sendMessage(localMessage);
      }
      localahpl.gi(aejx.a().byI, aejx.a().byJ);
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", new Object[] { this.this$0.mFriendUin, localIntimateInfo }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.4
 * JD-Core Version:    0.7.0.1
 */