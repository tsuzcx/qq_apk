package com.tencent.tim.cloudfile;

import atie;
import com.tencent.qphone.base.util.QLog;

public class CloudFileWithStatusBarAdapter$6
  implements Runnable
{
  public CloudFileWithStatusBarAdapter$6(atie paramatie) {}
  
  public void run()
  {
    QLog.d("CloudFileAdapter", 1, "showCompletedState updateView");
    com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar.die = false;
    atie.a(this.this$0, null);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileWithStatusBarAdapter.6
 * JD-Core Version:    0.7.0.1
 */