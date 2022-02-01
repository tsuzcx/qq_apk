package com.tencent.qqmail.note;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.ui.ShortcutUtility;

class NoteListActivity$6
  implements QMUIDialogAction.ActionListener
{
  NoteListActivity$6(NoteListActivity paramNoteListActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    ShortcutUtility.addApplicationShortcut(this.this$0.getString(2131690417), 2130842234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.6
 * JD-Core Version:    0.7.0.1
 */