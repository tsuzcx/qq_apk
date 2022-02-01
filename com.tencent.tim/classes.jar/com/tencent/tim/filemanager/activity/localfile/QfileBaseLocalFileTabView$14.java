package com.tencent.tim.filemanager.activity.localfile;

import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView;

class QfileBaseLocalFileTabView$14
  implements Runnable
{
  QfileBaseLocalFileTabView$14(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.this$0.b.a(this.this$0);
    if (this.this$0.a != null)
    {
      this.this$0.a.expandGroup(this.cWQ);
      if (this.cWR - 2 >= 0) {}
    }
    else
    {
      return;
    }
    this.this$0.a.setSelectedChild(this.cWQ, this.cWR - 2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView.14
 * JD-Core Version:    0.7.0.1
 */