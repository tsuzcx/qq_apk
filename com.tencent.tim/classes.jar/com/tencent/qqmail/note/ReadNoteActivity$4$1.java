package com.tencent.qqmail.note;

import java.util.HashMap;

class ReadNoteActivity$4$1
  implements Runnable
{
  ReadNoteActivity$4$1(ReadNoteActivity.4 param4) {}
  
  public void run()
  {
    if ((!this.this$1.this$0.mFromCatalogName.equals(this.this$1.this$0.getString(2131690287))) && (!this.this$1.this$0.mFromCatalogName.equals(this.this$1.this$0.getString(2131720427))))
    {
      ReadNoteActivity.access$600(this.this$1.this$0);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("noteId", ReadNoteActivity.access$700(this.this$1.this$0));
    localHashMap.put("position", Integer.valueOf(ReadNoteActivity.access$800(this.this$1.this$0)));
    ReadNoteActivity.access$900(this.this$1.this$0, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.4.1
 * JD-Core Version:    0.7.0.1
 */