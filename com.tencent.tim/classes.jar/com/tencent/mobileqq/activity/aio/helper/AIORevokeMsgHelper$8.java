package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import arhz;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import wuc;

public class AIORevokeMsgHelper$8
  implements Runnable
{
  public AIORevokeMsgHelper$8(wuc paramwuc, int paramInt) {}
  
  public void run()
  {
    if (this.val$resultCode > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.val$resultCode), ", type: ", Integer.valueOf(wuc.a(this.this$0).cZ) });
      }
      QQToast.a(wuc.a(this.this$0), wuc.a(this.this$0).getString(2131696071), 0).show(wuc.a(this.this$0).getTitleBarHeight());
    }
    if ((this.val$resultCode == 0) && (BaseChatItemLayout.bdx)) {
      wuc.a(this.this$0).a(false, null, false);
    }
    if (wuc.a(this.this$0).a != null) {
      wuc.a(this.this$0).a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.8
 * JD-Core Version:    0.7.0.1
 */