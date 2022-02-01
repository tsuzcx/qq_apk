package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;

class ComposeMailActivity$18$1
  extends QMTips.QMTipsCallback
{
  ComposeMailActivity$18$1(ComposeMailActivity.18 param18) {}
  
  public void onCancel(QMTips paramQMTips)
  {
    ComposeMailActivity.access$2502(this.this$1.this$0, 2);
    paramQMTips.showInfo(this.this$1.this$0.getString(2131691888));
    ComposeMailActivity.access$402(this.this$1.this$0, "");
    ComposeMailActivity.access$2600(this.this$1.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.18.1
 * JD-Core Version:    0.7.0.1
 */