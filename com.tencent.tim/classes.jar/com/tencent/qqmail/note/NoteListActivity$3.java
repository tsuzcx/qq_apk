package com.tencent.qqmail.note;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.thread.Threads;

class NoteListActivity$3
  implements ICallBack
{
  NoteListActivity$3(NoteListActivity paramNoteListActivity) {}
  
  public void callback(Object paramObject)
  {
    Threads.runOnMainThread(new NoteListActivity.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.3
 * JD-Core Version:    0.7.0.1
 */