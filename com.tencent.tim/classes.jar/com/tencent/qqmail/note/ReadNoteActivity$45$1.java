package com.tencent.qqmail.note;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class ReadNoteActivity$45$1
  implements Runnable
{
  ReadNoteActivity$45$1(ReadNoteActivity.45 param45, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.val$isContainAudio)
    {
      ReadNoteActivity.access$3200(this.this$1.this$0);
      return;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$1.this$0.getActivity()).setMessage(this.this$1.this$0.getString(2131696748)).addAction(2131696749, new ReadNoteActivity.45.1.2(this))).addAction(2131696750, new ReadNoteActivity.45.1.1(this))).create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.45.1
 * JD-Core Version:    0.7.0.1
 */