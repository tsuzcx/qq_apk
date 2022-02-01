package com.tencent.tim.filemanager.activity.recentfile;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView;

class QfileBaseRecentFileTabView$14
  implements Runnable
{
  QfileBaseRecentFileTabView$14(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView, int paramInt) {}
  
  public void run()
  {
    this.this$0.b.a(this.this$0);
    if ((this.this$0.a != null) && (QfileBaseRecentFileTabView.b(this.this$0)))
    {
      QLog.e(QfileBaseRecentFileTabView.TAG, 1, "setSelect[" + this.val$pos + "] success mFileListView");
      this.this$0.a.expandGroup(this.val$pos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView.14
 * JD-Core Version:    0.7.0.1
 */