package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.log.QMLog;
import rx.functions.Action1;

class NoteSender$1
  implements Action1<Void>
{
  NoteSender$1(NoteSender paramNoteSender) {}
  
  public void call(Void paramVoid)
  {
    this.this$0.buildNoteData();
    if ((NoteSender.access$000(this.this$0) != null) && (NoteSender.access$100(this.this$0) != null))
    {
      this.this$0.sendNoteInBackground(NoteSender.access$000(this.this$0), NoteSender.access$100(this.this$0));
      return;
    }
    QMLog.log(6, NoteSender.access$200(this.this$0), "can not send because data invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.NoteSender.1
 * JD-Core Version:    0.7.0.1
 */