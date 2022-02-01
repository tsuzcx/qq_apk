package com.tencent.qqmail.note;

import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ReadNoteActivity$29$1
  implements QMUIDialogAction.ActionListener
{
  ReadNoteActivity$29$1(ReadNoteActivity.29 param29) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    ReadNoteActivity.access$2200(this.this$1.this$0, ReadNoteActivity.access$100(this.this$1.this$0).information.noteId);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.29.1
 * JD-Core Version:    0.7.0.1
 */