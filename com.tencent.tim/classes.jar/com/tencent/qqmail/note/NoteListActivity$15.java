package com.tencent.qqmail.note;

import android.os.Handler;
import com.tencent.qqmail.utilities.observer.ICallBack;

class NoteListActivity$15
  implements ICallBack
{
  NoteListActivity$15(NoteListActivity paramNoteListActivity) {}
  
  public void callback(Object paramObject)
  {
    if (this.this$0.mIsLoading)
    {
      this.this$0.mIsLoading = false;
      NoteListActivity.access$1500(this.this$0, new NoteListActivity.15.1(this));
    }
    NoteListActivity.access$1700(this.this$0).post(NoteListActivity.access$1600(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.15
 * JD-Core Version:    0.7.0.1
 */