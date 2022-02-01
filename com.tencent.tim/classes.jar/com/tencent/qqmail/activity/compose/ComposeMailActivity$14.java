package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;
import moai.oss.KvHelper;

class ComposeMailActivity$14
  extends QMTips.QMTipsCallback
{
  ComposeMailActivity$14(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onCancel(QMTips paramQMTips)
  {
    super.onCancel(paramQMTips);
    KvHelper.eventSendDraftCancel(new double[0]);
    ComposeMailActivity.access$900(this.this$0);
  }
  
  public void onHide(QMTips paramQMTips)
  {
    super.onHide(paramQMTips);
    ComposeMailActivity.access$1000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.14
 * JD-Core Version:    0.7.0.1
 */