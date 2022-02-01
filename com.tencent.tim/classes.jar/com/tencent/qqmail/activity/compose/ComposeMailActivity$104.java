package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;

class ComposeMailActivity$104
  extends QMTips.QMTipsCallback
{
  ComposeMailActivity$104(ComposeMailActivity paramComposeMailActivity, QMTips.QMTipsCallback paramQMTipsCallback) {}
  
  public void onCancel(QMTips paramQMTips)
  {
    super.onCancel(paramQMTips);
  }
  
  public void onHide(QMTips paramQMTips)
  {
    super.onHide(paramQMTips);
    ComposeMailActivity.access$10000(this.this$0).setCallback(this.val$fn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.104
 * JD-Core Version:    0.7.0.1
 */