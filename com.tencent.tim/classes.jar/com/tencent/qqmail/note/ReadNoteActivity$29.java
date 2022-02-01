package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class ReadNoteActivity$29
  implements View.OnClickListener
{
  ReadNoteActivity$29(ReadNoteActivity paramReadNoteActivity) {}
  
  public void onClick(View paramView)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0).setTitle(2131691978)).setMessage(2131691977).addAction(2131691246, new ReadNoteActivity.29.2(this))).addAction(0, 2131691840, 2, new ReadNoteActivity.29.1(this))).create().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.29
 * JD-Core Version:    0.7.0.1
 */