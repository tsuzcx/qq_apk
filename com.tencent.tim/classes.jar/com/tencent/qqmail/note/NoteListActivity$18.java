package com.tencent.qqmail.note;

import android.util.Log;
import com.tencent.qqmail.utilities.observer.ICallBack;

class NoteListActivity$18
  implements ICallBack
{
  NoteListActivity$18(NoteListActivity paramNoteListActivity) {}
  
  public void callback(Object paramObject)
  {
    if ((this.this$0.mIsLoading) && (paramObject != null))
    {
      this.this$0.mIsLoading = false;
      NoteListActivity.access$2100(this.this$0, new NoteListActivity.18.1(this));
    }
    if (!this.this$0.mIsLoading)
    {
      Log.d("NoteListActivity", "receive noteListUpdateIObserver");
      NoteListActivity.access$100(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.18
 * JD-Core Version:    0.7.0.1
 */