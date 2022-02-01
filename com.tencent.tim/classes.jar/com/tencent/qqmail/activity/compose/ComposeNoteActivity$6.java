package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;

class ComposeNoteActivity$6
  extends QMTips.QMTipsCallback
{
  ComposeNoteActivity$6(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void onCancel(QMTips paramQMTips)
  {
    this.this$0.loadingViewWasCanceled(paramQMTips);
  }
  
  public void onHide(QMTips paramQMTips)
  {
    this.this$0.loadingViewWasHidden(paramQMTips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.6
 * JD-Core Version:    0.7.0.1
 */