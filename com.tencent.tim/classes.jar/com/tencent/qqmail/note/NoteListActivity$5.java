package com.tencent.qqmail.note;

import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.utilities.ui.PtrListView.OnRefreshListener;

class NoteListActivity$5
  extends PtrListView.OnRefreshListener
{
  NoteListActivity$5(NoteListActivity paramNoteListActivity) {}
  
  public void onRefresh()
  {
    if (!this.this$0.mIsLoading)
    {
      this.this$0.mIsLoading = true;
      NoteListActivity.access$800(this.this$0).loadNoteList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.5
 * JD-Core Version:    0.7.0.1
 */