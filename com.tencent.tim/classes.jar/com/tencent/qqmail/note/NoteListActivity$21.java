package com.tencent.qqmail.note;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;

class NoteListActivity$21
  implements View.OnClickListener
{
  NoteListActivity$21(NoteListActivity paramNoteListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.mIsEditing)
    {
      Intent localIntent = new Intent(this.this$0.getActivity(), ComposeNoteActivity.class);
      localIntent.putExtra("noteCatId", NoteListActivity.access$2500(this.this$0));
      this.this$0.startActivity(localIntent);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      NoteListActivity.access$1400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.21
 * JD-Core Version:    0.7.0.1
 */