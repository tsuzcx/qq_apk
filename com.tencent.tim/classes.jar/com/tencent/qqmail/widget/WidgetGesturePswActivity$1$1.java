package com.tencent.qqmail.widget;

import com.tencent.qqmail.view.FolderLockDialog;

class WidgetGesturePswActivity$1$1
  implements Runnable
{
  WidgetGesturePswActivity$1$1(WidgetGesturePswActivity.1 param1) {}
  
  public void run()
  {
    WidgetGesturePswActivity.access$000(this.this$1.this$0).cancelDialog();
    WidgetGesturePswActivity.access$000(this.this$1.this$0).dismissTips();
    this.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.WidgetGesturePswActivity.1.1
 * JD-Core Version:    0.7.0.1
 */