package com.tencent.qqmail.model.mail;

import android.database.Cursor;
import com.tencent.qqmail.model.qmdomain.MailTranslate;

class QMMailSQLite$3
  implements Runnable
{
  QMMailSQLite$3(QMMailSQLite paramQMMailSQLite, Cursor paramCursor, ReadMailTranslateCallback paramReadMailTranslateCallback) {}
  
  public void run()
  {
    MailTranslate localMailTranslate = new MailTranslate();
    localMailTranslate.setMailId(this.val$cursor.getLong(this.val$cursor.getColumnIndex("id")));
    localMailTranslate.setTranslateSubj(this.val$cursor.getString(this.val$cursor.getColumnIndex("translate_subj")));
    localMailTranslate.setTranslateContent(this.val$cursor.getString(this.val$cursor.getColumnIndex("translate_content")));
    if (this.val$callback != null) {
      this.val$callback.onComplete(localMailTranslate);
    }
    this.val$cursor.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailSQLite.3
 * JD-Core Version:    0.7.0.1
 */