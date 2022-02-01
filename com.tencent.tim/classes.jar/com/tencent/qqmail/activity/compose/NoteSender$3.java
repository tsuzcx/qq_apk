package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.NoteStorage;

class NoteSender$3
  implements MailManagerDelegate.DataCallback
{
  NoteSender$3(NoteSender paramNoteSender) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    NoteSender.access$302(this.this$0, NoteStorage.getDefaultCatId());
    NoteSender.access$402(this.this$0, NoteManager.getSharedInstance().findCategoryNameByCid(NoteSender.access$300(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.NoteSender.3
 * JD-Core Version:    0.7.0.1
 */