package com.tencent.widget;

import android.view.View;

public class AbsListView$1
  implements Runnable
{
  AbsListView$1(AbsListView paramAbsListView, View paramView, AbsListView.PerformClick paramPerformClick) {}
  
  public void run()
  {
    this.this$0.mTouchMode = -1;
    this.hI.setPressed(false);
    this.this$0.setPressed(false);
    if (!this.this$0.mDataChanged) {
      this.a.run();
    }
    AbsListView.access$1002(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.1
 * JD-Core Version:    0.7.0.1
 */