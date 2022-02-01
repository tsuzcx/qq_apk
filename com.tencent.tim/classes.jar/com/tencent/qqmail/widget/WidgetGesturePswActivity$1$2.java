package com.tencent.qqmail.widget;

import com.tencent.qqmail.view.FolderLockDialog;

class WidgetGesturePswActivity$1$2
  implements Runnable
{
  WidgetGesturePswActivity$1$2(WidgetGesturePswActivity.1 param1) {}
  
  public void run()
  {
    WidgetGesturePswActivity.access$000(this.this$1.this$0).cancelDialog();
    WidgetGesturePswActivity.access$000(this.this$1.this$0).dismissTips();
    WidgetGesturePswActivity.access$000(this.this$1.this$0).errorDialog();
    WidgetGesturePswActivity.access$000(this.this$1.this$0).setDialogCancelable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.WidgetGesturePswActivity.1.2
 * JD-Core Version:    0.7.0.1
 */