package com.tencent.tim.cloudfile;

import android.view.View;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;

class CloudFileSendRecvActivity$15
  implements Runnable
{
  CloudFileSendRecvActivity$15(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public void run()
  {
    CloudFileSendRecvActivity.c(this.this$0).setVisibility(8);
    aqmj.d(this.this$0.getActivity(), this.this$0.app.getCurrentAccountUin(), aqmj.getAppVersionCode(this.this$0), "acount_uin_first_use_sendrecv");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSendRecvActivity.15
 * JD-Core Version:    0.7.0.1
 */