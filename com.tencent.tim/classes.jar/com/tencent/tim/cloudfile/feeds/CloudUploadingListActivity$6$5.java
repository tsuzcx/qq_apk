package com.tencent.tim.cloudfile.feeds;

import atgi;
import atmf;
import atmh;
import atmh.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CloudUploadingListActivity$6$5
  implements Runnable
{
  public CloudUploadingListActivity$6$5(atmf paramatmf, long paramLong, int paramInt) {}
  
  public void run()
  {
    atmh.a locala = (atmh.a)CloudUploadingListActivity.a(this.a.this$0).get(Long.valueOf(this.val$taskId));
    if (locala == null)
    {
      QLog.d("CloudUploadingListActivity", 1, "onStopUpload taskId[" + this.val$taskId + "] can not find task in fetchlist");
      return;
    }
    if (this.val$errCode == 0)
    {
      CloudUploadingListActivity.a(this.a.this$0).remove(Long.valueOf(this.val$taskId));
      CloudUploadingListActivity.a(this.a.this$0);
      this.a.this$0.eua();
    }
    for (;;)
    {
      this.a.this$0.a.notifyDataSetChanged();
      return;
      locala.errCode = this.val$errCode;
      if (this.val$errCode == 3)
      {
        locala.uploadStatus = 3;
      }
      else
      {
        locala.uploadStatus = 4;
        locala.errMsg = atgi.a().getErrorMsgOf(this.val$errCode);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.5
 * JD-Core Version:    0.7.0.1
 */