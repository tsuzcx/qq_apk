package com.tencent.qqmail.note;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadNoteActivity$31
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadNoteActivity$31(ReadNoteActivity paramReadNoteActivity, boolean paramBoolean, String paramString) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramView = this.this$0;
    if (!this.val$starred)
    {
      paramInt = 2131695669;
      if (paramString.equals(paramView.getString(paramInt)))
      {
        paramView = this.this$0;
        paramString = this.val$noteId;
        if (this.val$starred) {
          break label68;
        }
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      ReadNoteActivity.access$2400(paramView, paramString, bool);
      paramQMBottomDialog.dismiss();
      return;
      paramInt = 2131695672;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.31
 * JD-Core Version:    0.7.0.1
 */