package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.ReadMailCallback;
import com.tencent.qqmail.model.qmdomain.Mail;

class QMMailSQLite$1
  implements Runnable
{
  QMMailSQLite$1(QMMailSQLite paramQMMailSQLite, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean1, boolean paramBoolean2, Mail paramMail, ReadMailCallback paramReadMailCallback) {}
  
  public void run()
  {
    this.this$0.readMailExtra(this.val$readableDb, this.val$isSearchMail, this.val$isEmlMail, this.val$mail);
    if (this.val$callback != null) {
      this.val$callback.onComplete(this.val$mail);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailSQLite.1
 * JD-Core Version:    0.7.0.1
 */