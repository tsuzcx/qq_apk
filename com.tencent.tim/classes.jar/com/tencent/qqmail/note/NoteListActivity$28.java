package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NoteListActivity$28
  implements View.OnClickListener
{
  NoteListActivity$28(NoteListActivity paramNoteListActivity) {}
  
  public void onClick(View paramView)
  {
    NoteListActivity.access$3300(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.28
 * JD-Core Version:    0.7.0.1
 */