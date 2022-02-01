package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.HashMap;
import java.util.List;

class NoteQueueManager$1
  implements MailManagerDelegate.DataCallback
{
  NoteQueueManager$1(NoteQueueManager paramNoteQueueManager, String paramString) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    paramObject2 = (HashMap)paramObject2;
    paramObject1 = NoteQueueManager.access$000(this.this$0).readUnsendNote(this.val$noteId);
    if (paramObject2 != null)
    {
      Object localObject = (List)paramObject2.get("conflictnts");
      if ((localObject == null) || (!((List)localObject).contains(this.val$noteId))) {
        break label159;
      }
      QMLog.log(5, "NoteQueueManager", "noteId:" + this.val$noteId + " conflicted:" + StringExtention.join((List)localObject, "***"));
      paramObject2 = new StringBuilder();
      localObject = paramObject1.information;
      ((QMNNoteInformation)localObject).subject += "(冲突)";
      paramObject1.status.status = 1;
      paramObject1.getComposeMailKey();
    }
    for (;;)
    {
      NoteQueueManager.access$100(this.this$0, paramObject1, this.val$noteId);
      return;
      label159:
      paramObject2 = paramObject2.get(NoteQueueManager.NEW_SEQ_KEY);
      if (paramObject2 != null) {
        try
        {
          if (Double.parseDouble(paramObject2.toString()) > 10.0D)
          {
            double d = Double.parseDouble(paramObject2.toString());
            NoteQueueManager.access$000(this.this$0).setSeq(this.val$noteId, d);
            QMLog.log(4, "NoteQueueManager", " getnewSeq ok noteId:" + this.val$noteId + "seq:" + paramObject2.toString());
          }
        }
        catch (Exception paramObject2)
        {
          QMLog.log(6, "NoteQueueManager", paramObject2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.NoteQueueManager.1
 * JD-Core Version:    0.7.0.1
 */