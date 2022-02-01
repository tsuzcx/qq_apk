package com.tencent.tim.cloudfile;

import agne;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class CloudFileSendRecvActivity$12
  implements Runnable
{
  CloudFileSendRecvActivity$12(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public void run()
  {
    if (!aqmj.b(this.this$0.getActivity(), this.this$0.app.getCurrentAccountUin(), aqmj.getAppVersionCode(this.this$0), "acount_uin_first_use_sendrecv")) {
      return;
    }
    List localList = this.this$0.app.a().eU();
    if (QLog.isColorLevel()) {
      QLog.i("SendRecvActivity", 2, "before get files size " + localList.size());
    }
    if (localList.size() > 0)
    {
      CloudFileSendRecvActivity.a(this.this$0, localList);
      return;
    }
    aqmj.d(this.this$0.getActivity(), this.this$0.app.getCurrentAccountUin(), aqmj.getAppVersionCode(this.this$0), "acount_uin_first_use_sendrecv");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSendRecvActivity.12
 * JD-Core Version:    0.7.0.1
 */