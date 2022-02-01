package com.tencent.qqmail.note;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadNoteActivity$52
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadNoteActivity$52(ReadNoteActivity paramReadNoteActivity, String paramString) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131696621)))
    {
      this.this$0.openUrl(this.val$urlAddress);
      paramQMBottomDialog.dismiss();
    }
    while (!paramString.equals(this.this$0.getString(2131692324))) {
      return;
    }
    this.this$0.copy(this.val$urlAddress);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.52
 * JD-Core Version:    0.7.0.1
 */