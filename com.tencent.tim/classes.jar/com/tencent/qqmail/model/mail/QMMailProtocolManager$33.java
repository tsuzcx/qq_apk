package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.qmdomain.MailTranslate;

class QMMailProtocolManager$33
  implements MailManagerDelegate.DataCallback
{
  QMMailProtocolManager$33(QMMailProtocolManager paramQMMailProtocolManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && ((paramObject1 instanceof MailTranslate)))
    {
      MailTranslate localMailTranslate = (MailTranslate)paramObject1;
      SQLiteDatabase localSQLiteDatabase = QMMailProtocolManager.access$000(this.this$0).getWritableDatabase();
      QMMailProtocolManager.access$000(this.this$0).mail.insertMailTranslateContent(localSQLiteDatabase, localMailTranslate);
    }
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(paramObject1, paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.33
 * JD-Core Version:    0.7.0.1
 */