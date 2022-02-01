package com.tencent.tim.mvp.cloudfile;

import aqcx;
import auhr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;

public class CloudSendRecvPresenter$3
  implements Runnable
{
  public CloudSendRecvPresenter$3(auhr paramauhr, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.a instanceof CloudFileSendRecvActivity))
    {
      CloudFileSendRecvActivity localCloudFileSendRecvActivity = (CloudFileSendRecvActivity)this.this$0.a;
      QQToast.a(localCloudFileSendRecvActivity, 1, this.val$errMsg, 0).show(aqcx.dip2px(localCloudFileSendRecvActivity, 44.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.cloudfile.CloudSendRecvPresenter.3
 * JD-Core Version:    0.7.0.1
 */