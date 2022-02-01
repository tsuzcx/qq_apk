package com.tencent.qqmail.model.qmdomain;

import com.tencent.qqmail.model.mail.loader.MailContentLoaderCallback;
import com.tencent.qqmail.note.NoteUtil;
import java.util.HashMap;
import java.util.List;

class QMComposeNote$1
  implements MailContentLoaderCallback
{
  QMComposeNote$1(QMComposeNote paramQMComposeNote, HashMap paramHashMap, List paramList, Runnable paramRunnable) {}
  
  public void onError(String paramString1, String paramString2)
  {
    this.val$doneList.put(paramString1, "");
    this.this$0.checkCompleteAndReplaceLocalFile(this.val$localCids, this.val$doneList, this.val$continuation);
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    this.val$doneList.put(paramString1, paramString2);
    paramString2 = NoteUtil.addProtocal(this.this$0.saveCidFileToLocal(paramString2, paramString1));
    this.this$0.replaceContentCid(paramString1, paramString2);
    this.this$0.checkCompleteAndReplaceLocalFile(this.val$localCids, this.val$doneList, this.val$continuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMComposeNote.1
 * JD-Core Version:    0.7.0.1
 */