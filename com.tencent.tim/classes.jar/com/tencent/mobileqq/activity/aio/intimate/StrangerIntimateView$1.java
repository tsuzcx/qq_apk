package com.tencent.mobileqq.activity.aio.intimate;

import ahpl;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import wxz;

public class StrangerIntimateView$1
  implements Runnable
{
  public StrangerIntimateView$1(wxz paramwxz) {}
  
  public void run()
  {
    if ((this.this$0.mApp != null) && (!TextUtils.isEmpty(this.this$0.mMemberUin)))
    {
      IntimateInfo localIntimateInfo = ((ahpl)this.this$0.mApp.getManager(323)).a(this.this$0.mMemberUin);
      if (localIntimateInfo != null)
      {
        wxz.a(this.this$0, localIntimateInfo);
        Message localMessage = wxz.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        wxz.a(this.this$0).sendMessage(localMessage);
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", new Object[] { this.this$0.mMemberUin, localIntimateInfo }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.1
 * JD-Core Version:    0.7.0.1
 */