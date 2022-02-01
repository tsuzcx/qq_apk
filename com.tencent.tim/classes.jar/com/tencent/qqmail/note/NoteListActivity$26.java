package com.tencent.qqmail.note;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qqmail.search.fragment.SearchNoteListActivity;

class NoteListActivity$26
  implements View.OnTouchListener
{
  NoteListActivity$26(NoteListActivity paramNoteListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.this$0.mIsEditing) {}
    while (paramMotionEvent.getAction() != 1) {
      return true;
    }
    paramView = new Intent(NoteListActivity.access$2800(this.this$0), SearchNoteListActivity.class);
    paramView.putExtra("filterIndex", NoteListActivity.access$2900(this.this$0));
    paramView.putExtra("toggleheight", NoteListActivity.access$3000(this.this$0));
    paramView.putExtra("categoryId", NoteListActivity.access$2500(this.this$0));
    this.this$0.startActivity(paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.26
 * JD-Core Version:    0.7.0.1
 */