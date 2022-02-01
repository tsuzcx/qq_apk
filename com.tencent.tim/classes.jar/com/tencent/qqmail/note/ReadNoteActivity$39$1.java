package com.tencent.qqmail.note;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;

class ReadNoteActivity$39$1
  extends QMTips.QMTipsCallback
{
  ReadNoteActivity$39$1(ReadNoteActivity.39 param39, View paramView) {}
  
  public void onCancel(QMTips paramQMTips)
  {
    super.onCancel(paramQMTips);
    this.val$v.setSelected(false);
  }
  
  public void onHide(QMTips paramQMTips)
  {
    super.onHide(paramQMTips);
    this.val$v.setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.39.1
 * JD-Core Version:    0.7.0.1
 */