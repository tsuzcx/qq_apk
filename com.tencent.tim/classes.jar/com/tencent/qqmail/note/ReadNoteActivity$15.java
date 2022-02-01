package com.tencent.qqmail.note;

import com.tencent.qqmail.utilities.observer.ICallBack;

class ReadNoteActivity$15
  implements ICallBack
{
  ReadNoteActivity$15(ReadNoteActivity paramReadNoteActivity) {}
  
  public void callback(Object paramObject)
  {
    if (paramObject.toString().equals(ReadNoteActivity.access$700(this.this$0))) {
      this.this$0.loadNoteError(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.15
 * JD-Core Version:    0.7.0.1
 */