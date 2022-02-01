package com.tencent.tim.filemanager.activity.cloudfile;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView;

class QfileBaseCloudFileTabView$17
  implements Runnable
{
  QfileBaseCloudFileTabView$17(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView, int paramInt) {}
  
  public void run()
  {
    this.this$0.b.a(this.this$0);
    if ((this.this$0.a != null) && (QfileBaseCloudFileTabView.d(this.this$0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i(QfileBaseCloudFileTabView.TAG, 2, "setSelect[" + this.val$pos + "] success mFileListView");
      }
      this.this$0.a.expandGroup(this.val$pos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.17
 * JD-Core Version:    0.7.0.1
 */