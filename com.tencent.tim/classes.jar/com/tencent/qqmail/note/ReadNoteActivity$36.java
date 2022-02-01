package com.tencent.qqmail.note;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadNoteActivity$36
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadNoteActivity$36(ReadNoteActivity paramReadNoteActivity) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new ReadNoteActivity.36.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.36
 * JD-Core Version:    0.7.0.1
 */