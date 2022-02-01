package com.tencent.tim.cloudfile.feeds;

import android.widget.Button;
import android.widget.LinearLayout;
import atmh;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class CloudUploadingListActivity$7
  implements Runnable
{
  CloudUploadingListActivity$7(CloudUploadingListActivity paramCloudUploadingListActivity, List paramList) {}
  
  public void run()
  {
    QLog.w("CloudUploadingListActivity", 1, "refresh begin at " + System.currentTimeMillis());
    this.this$0.a.nL(this.KC);
    this.this$0.a.notifyDataSetChanged();
    if (this.KC.size() > 0)
    {
      CloudUploadingListActivity.a(this.this$0).setEnabled(true);
      CloudUploadingListActivity.b(this.this$0).setEnabled(true);
      CloudUploadingListActivity.a(this.this$0).setVisibility(8);
      CloudUploadingListActivity.b(this.this$0).setVisibility(0);
      CloudUploadingListActivity.c(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      QLog.w("CloudUploadingListActivity", 1, "refresh end at " + System.currentTimeMillis());
      return;
      CloudFileUploadingStatusBar.setNeedShowCompletedState();
      CloudUploadingListActivity.a(this.this$0).setEnabled(false);
      CloudUploadingListActivity.b(this.this$0).setEnabled(false);
      CloudUploadingListActivity.a(this.this$0).setVisibility(0);
      CloudUploadingListActivity.b(this.this$0).setVisibility(8);
      CloudUploadingListActivity.c(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.7
 * JD-Core Version:    0.7.0.1
 */