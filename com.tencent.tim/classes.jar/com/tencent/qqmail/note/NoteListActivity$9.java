package com.tencent.qqmail.note;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.utilities.ui.PtrListView;

class NoteListActivity$9
  implements AdapterView.OnItemLongClickListener
{
  NoteListActivity$9(NoteListActivity paramNoteListActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.mIsEditing) {
      return false;
    }
    this.this$0.toEditView();
    this.this$0.mNoteListListView.getOnItemClickListener().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.9
 * JD-Core Version:    0.7.0.1
 */