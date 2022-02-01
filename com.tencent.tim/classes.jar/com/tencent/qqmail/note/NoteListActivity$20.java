package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NoteListActivity$20
  implements View.OnClickListener
{
  NoteListActivity$20(NoteListActivity paramNoteListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.mIsEditing)
    {
      this.this$0.onBackPressed();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    NoteListActivity localNoteListActivity = this.this$0;
    if (!NoteListActivity.access$2300(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      NoteListActivity.access$2400(localNoteListActivity, bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.20
 * JD-Core Version:    0.7.0.1
 */