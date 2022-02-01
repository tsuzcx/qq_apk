package com.tencent.qqmail.note;

import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import java.util.HashMap;

class ReadNoteActivity$7$1
  implements Runnable
{
  ReadNoteActivity$7$1(ReadNoteActivity.7 param7, Object paramObject) {}
  
  public void run()
  {
    QMNNote localQMNNote = (QMNNote)((HashMap)this.val$data).get("note");
    ReadNoteActivity.access$200(this.this$1.this$0, localQMNNote);
    ReadNoteActivity.access$102(this.this$1.this$0, new QMComposeNote(localQMNNote));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.7.1
 * JD-Core Version:    0.7.0.1
 */