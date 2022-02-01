package com.tencent.tim.cloudfile.feeds;

import atgi;
import atmf;
import atmh;
import atmh.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CloudUploadingListActivity$6$1
  implements Runnable
{
  public CloudUploadingListActivity$6$1(atmf paramatmf, long paramLong, int paramInt) {}
  
  public void run()
  {
    atmh.a locala = (atmh.a)CloudUploadingListActivity.a(this.a.this$0).get(Long.valueOf(this.val$taskId));
    if (locala == null)
    {
      QLog.d("CloudUploadingListActivity", 1, "onStartUpload taskId[" + this.val$taskId + "] can not find task in fetchlist, so check fetch again");
      CloudUploadingListActivity.d(this.a.this$0);
      return;
    }
    if (this.val$errCode == 0) {
      locala.uploadStatus = 0;
    }
    for (;;)
    {
      this.a.this$0.a.notifyDataSetChanged();
      this.a.this$0.eua();
      return;
      locala.uploadStatus = 4;
      locala.errCode = this.val$errCode;
      locala.errMsg = atgi.a().getErrorMsgOf(this.val$errCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.1
 * JD-Core Version:    0.7.0.1
 */