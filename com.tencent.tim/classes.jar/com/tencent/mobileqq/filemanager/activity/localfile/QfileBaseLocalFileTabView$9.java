package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;

class QfileBaseLocalFileTabView$9
  implements Runnable
{
  QfileBaseLocalFileTabView$9(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      this.this$0.b.expandGroup(this.cWQ);
      if (this.cWR - 2 >= 0) {}
    }
    else
    {
      return;
    }
    this.this$0.b.setSelectedChild(this.cWQ, this.cWR - 2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.9
 * JD-Core Version:    0.7.0.1
 */