package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.NoteStorage;

class ComposeNoteActivity$12$1$1
  implements Runnable
{
  ComposeNoteActivity$12$1$1(ComposeNoteActivity.12.1 param1) {}
  
  public void run()
  {
    ComposeNoteActivity.access$1702(this.this$2.this$1.this$0, NoteStorage.getDefaultCatId());
    ComposeNoteActivity.access$1802(this.this$2.this$1.this$0, NoteManager.getSharedInstance().findCategoryNameByCid(ComposeNoteActivity.access$1700(this.this$2.this$1.this$0)));
    ComposeNoteActivity.access$1400(this.this$2.this$1.this$0).setNoteCatalogString(ComposeNoteActivity.access$1800(this.this$2.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.12.1.1
 * JD-Core Version:    0.7.0.1
 */