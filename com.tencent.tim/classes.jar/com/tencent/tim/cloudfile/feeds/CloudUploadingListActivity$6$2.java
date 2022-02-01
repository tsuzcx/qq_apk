package com.tencent.tim.cloudfile.feeds;

import atgi;
import atmf;
import atmh;
import atmh.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CloudUploadingListActivity$6$2
  implements Runnable
{
  public CloudUploadingListActivity$6$2(atmf paramatmf, long paramLong, int paramInt) {}
  
  public void run()
  {
    atmh.a locala = (atmh.a)CloudUploadingListActivity.a(this.a.this$0).get(Long.valueOf(this.val$taskId));
    if (locala == null)
    {
      QLog.d("CloudUploadingListActivity", 1, "onStopUpload taskId[" + this.val$taskId + "] can not find task in fetchlist");
      return;
    }
    locala.errCode = this.val$errCode;
    if ((this.val$errCode == 3) || (this.val$errCode == 0)) {
      locala.uploadStatus = 3;
    }
    for (;;)
    {
      this.a.this$0.a.notifyDataSetChanged();
      this.a.this$0.eua();
      return;
      locala.uploadStatus = 4;
      locala.errMsg = atgi.a().getErrorMsgOf(this.val$errCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.2
 * JD-Core Version:    0.7.0.1
 */