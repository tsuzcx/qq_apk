package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.utilities.ui.PtrListView;

class NoteListActivity$StandardArrayAdapter$3
  implements View.OnLongClickListener
{
  NoteListActivity$StandardArrayAdapter$3(NoteListActivity.StandardArrayAdapter paramStandardArrayAdapter, int paramInt, long paramLong) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((this.this$1.this$0.mNoteListListView.getOnItemLongClickListener() == null) || (this.this$1.this$0.mIsEditing)) {
      return false;
    }
    AdapterView.OnItemLongClickListener localOnItemLongClickListener = this.this$1.this$0.mNoteListListView.getOnItemLongClickListener();
    PtrListView localPtrListView = this.this$1.this$0.mNoteListListView;
    int i = this.val$position;
    localOnItemLongClickListener.onItemLongClick(localPtrListView, paramView, this.this$1.this$0.mNoteListListView.getHeaderViewsCount() + i, this.val$id);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.StandardArrayAdapter.3
 * JD-Core Version:    0.7.0.1
 */