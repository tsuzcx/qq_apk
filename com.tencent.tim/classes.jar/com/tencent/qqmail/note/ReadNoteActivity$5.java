package com.tencent.qqmail.note;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import java.util.HashMap;

class ReadNoteActivity$5
  implements ICallBack
{
  ReadNoteActivity$5(ReadNoteActivity paramReadNoteActivity) {}
  
  public void callback(Object paramObject)
  {
    HashMap localHashMap = (HashMap)paramObject;
    QMLog.log(4, "ReadNoteActivity_noteTempId ", paramObject.toString() + " _ " + ReadNoteActivity.access$700(this.this$0));
    paramObject = (String)localHashMap.get(ReadNoteActivity.access$700(this.this$0));
    if (paramObject != null) {
      ReadNoteActivity.access$702(this.this$0, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.5
 * JD-Core Version:    0.7.0.1
 */