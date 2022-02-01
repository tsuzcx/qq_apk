package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.mail.loader.MailContentLoaderCallback;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;

class ComposeNoteActivity$15
  implements MailContentLoaderCallback
{
  ComposeNoteActivity$15(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void onError(String paramString1, String paramString2)
  {
    QMLog.log(6, "ComposeNoteActivity", "error original : " + paramString1 + " -- > " + paramString2);
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    QMLog.log(4, "ComposeNoteActivity", "original : " + paramString1 + " -- > " + paramString2);
    ComposeNoteActivity.access$2100(this.this$0, QMMath.hashInt(paramString1), paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.15
 * JD-Core Version:    0.7.0.1
 */