package com.tencent.qqmail.note;

import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.utilities.observer.ICallBack;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

class ReadNoteActivity$12
  implements ICallBack
{
  ReadNoteActivity$12(ReadNoteActivity paramReadNoteActivity) {}
  
  public void callback(Object paramObject)
  {
    Object localObject = (HashMap)paramObject;
    paramObject = (String)((HashMap)localObject).get("fromNetwork");
    localObject = (QMNNote)((HashMap)localObject).get("data");
    if ((localObject == null) || (((QMNNote)localObject).information == null) || (!StringUtils.equals(((QMNNote)localObject).information.noteId, ReadNoteActivity.access$700(this.this$0)))) {
      return;
    }
    this.this$0.loadNoteSucc(localObject, StringUtils.equals("true", paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.12
 * JD-Core Version:    0.7.0.1
 */