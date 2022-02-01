package com.tencent.moai.downloader.model;

import com.tencent.moai.downloader.exception.ConnectTaskError;
import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.listener.ConnectTaskListener;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.moai.downloader.util.Logger;

class DownloadTask$3
  implements ConnectTaskListener
{
  DownloadTask$3(DownloadTask paramDownloadTask) {}
  
  public void onConnectError(String paramString, ConnectTaskError paramConnectTaskError)
  {
    Logger.e("DownloadTask", " onConnectError url" + paramString + " error:" + paramConnectTaskError.getMessage());
    DownloadTask.access$300(this.this$0).setStatus(5);
    DownloadTask.access$500(this.this$0).onFail(DownloadTask.access$400(this.this$0), paramString, new DownloadTaskError(paramConnectTaskError.getErrorCode(), paramConnectTaskError.getMessage()));
  }
  
  public void onConnectSuccess(String paramString, long paramLong, boolean paramBoolean)
  {
    Logger.i("DownloadTask", " onConnectSuccess url" + paramString + " contentSize:" + paramLong + " acceptRange:" + paramBoolean);
    paramString = this.this$0;
    if (paramLong > 0L)
    {
      paramString.setFileSize(paramLong);
      this.this$0.setAcceptRange(paramBoolean);
      if (!this.this$0.isAcceptRange()) {
        break label104;
      }
      DownloadTask.access$000(this.this$0);
    }
    for (;;)
    {
      DownloadTask.access$200(this.this$0);
      return;
      paramLong = this.this$0.getFileSize();
      break;
      label104:
      DownloadTask.access$100(this.this$0);
    }
  }
  
  public void onConnecting(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.model.DownloadTask.3
 * JD-Core Version:    0.7.0.1
 */