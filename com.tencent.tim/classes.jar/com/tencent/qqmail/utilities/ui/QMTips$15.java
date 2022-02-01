package com.tencent.qqmail.utilities.ui;

class QMTips$15
  extends QMTips.QMTipsCallback
{
  QMTips$15(QMTips paramQMTips, QMTips.QMTipsCallback paramQMTipsCallback) {}
  
  public void onCancel(QMTips paramQMTips)
  {
    super.onCancel(paramQMTips);
    this.this$0.setCallback(this.val$fn);
  }
  
  public void onHide(QMTips paramQMTips)
  {
    super.onHide(paramQMTips);
    this.this$0.setCallback(this.val$fn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMTips.15
 * JD-Core Version:    0.7.0.1
 */