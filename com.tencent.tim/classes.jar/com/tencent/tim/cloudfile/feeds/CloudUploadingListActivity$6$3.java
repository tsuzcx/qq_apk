package com.tencent.tim.cloudfile.feeds;

import atgi;
import atmf;
import atmh.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CloudUploadingListActivity$6$3
  implements Runnable
{
  public CloudUploadingListActivity$6$3(atmf paramatmf, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (this.val$errCode != 0)
    {
      String str = atgi.a().getErrorMsgOf(this.val$errCode);
      QQToast.a(this.a.this$0, 1, str, 3000).show();
      return;
    }
    if ((atmh.a)CloudUploadingListActivity.a(this.a.this$0).get(Long.valueOf(this.val$taskId)) == null)
    {
      QLog.d("CloudUploadingListActivity", 1, "onStopUpload taskId[" + this.val$taskId + "] can not find task in fetchlist");
      return;
    }
    CloudUploadingListActivity.a(this.a.this$0).remove(Long.valueOf(this.val$taskId));
    CloudUploadingListActivity.a(this.a.this$0);
    this.a.this$0.eua();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.3
 * JD-Core Version:    0.7.0.1
 */