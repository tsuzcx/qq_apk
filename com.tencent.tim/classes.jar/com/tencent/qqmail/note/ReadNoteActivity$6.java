package com.tencent.qqmail.note;

import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.utilities.observer.ICallBack;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

class ReadNoteActivity$6
  implements ICallBack
{
  ReadNoteActivity$6(ReadNoteActivity paramReadNoteActivity) {}
  
  public void callback(Object paramObject)
  {
    Object localObject = (HashMap)paramObject;
    paramObject = (String)((HashMap)localObject).get("noteId");
    localObject = (String)((HashMap)localObject).get("fromNetwork");
    if (ReadNoteActivity.access$700(this.this$0).equals(paramObject))
    {
      paramObject = new HashMap();
      paramObject.put("NoteId", ReadNoteActivity.access$700(this.this$0));
      if (StringUtils.equals("true", (CharSequence)localObject)) {
        paramObject.put("fromNetwork", localObject);
      }
      NoteManager.sharedInstance().loadNoteWithNotification(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.6
 * JD-Core Version:    0.7.0.1
 */