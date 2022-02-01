package com.tencent.upload.network.session;

import com.tencent.upload.network.base.IConnectionCallback;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.UploadLog;

class UploadSession$4
  implements Runnable
{
  UploadSession$4(UploadSession paramUploadSession, int paramInt, IConnectionCallback paramIConnectionCallback) {}
  
  public void run()
  {
    int i = this.val$socketStatus;
    if (SessionPool.isNetworkUnavailable(this.val$socketStatus)) {
      i = Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode();
    }
    UploadLog.w("UploadSession", "Session Error. sid=" + UploadSession.access$100(this.this$0) + " socket_status=" + this.val$socketStatus);
    UploadSession.access$600(this.this$0, this.val$callback, i, "NDK Network Error: " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.4
 * JD-Core Version:    0.7.0.1
 */