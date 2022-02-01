package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.protocol.MailUtil;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailSQLite$2
  implements Runnable
{
  QMMailSQLite$2(QMMailSQLite paramQMMailSQLite, String paramString, SQLiteDatabase paramSQLiteDatabase, long paramLong) {}
  
  public void run()
  {
    try
    {
      String str = MailUtil.removeContentTag(this.val$content);
      this.val$writableDb.execSQL("REPLACE INTO QM_MAIL_CONTENT_FTS_SEARCH ( docid,content) VALUES (?,?)", new Object[] { Long.valueOf(this.val$mailId), str });
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMMailSQLite", "insert mail content fts fail: " + this.val$mailId + "\n" + Log.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailSQLite.2
 * JD-Core Version:    0.7.0.1
 */