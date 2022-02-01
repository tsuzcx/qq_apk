package com.tencent.tim.cloudfile.feeds;

import atmf;
import atmh;
import atmh.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CloudUploadingListActivity$6$4
  implements Runnable
{
  public CloudUploadingListActivity$6$4(atmf paramatmf, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void run()
  {
    atmh.a locala = (atmh.a)CloudUploadingListActivity.a(this.a.this$0).get(Long.valueOf(this.val$taskId));
    if (locala == null)
    {
      QLog.d("CloudUploadingListActivity", 1, "onStopUpload taskId[" + this.val$taskId + "] can not find task in fetchlist");
      return;
    }
    locala.progress = this.axV;
    locala.ayl = this.axX;
    locala.uploadStatus = 1;
    if (locala.ayk == 0L) {
      locala.ayk = this.axW;
    }
    QLog.i("CloudUploadingListActivity", 2, this.axX + " " + String.valueOf(this.axX));
    this.a.this$0.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.4
 * JD-Core Version:    0.7.0.1
 */