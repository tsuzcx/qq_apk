package com.tencent.qqmail.note;

import com.tencent.qqmail.utilities.observer.ICallBack;

class NoteListActivity$16
  implements ICallBack
{
  NoteListActivity$16(NoteListActivity paramNoteListActivity) {}
  
  public void callback(Object paramObject)
  {
    if ((this.this$0.mIsEditing) && (this.this$0.mNoteListListView != null)) {
      this.this$0.toNormalView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.16
 * JD-Core Version:    0.7.0.1
 */