package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMMailCGIManager$19$2$2
  implements QMMailCGIManager.IDelMailAfterSync
{
  QMMailCGIManager$19$2$2(QMMailCGIManager.19.2 param2, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run(long[] paramArrayOfLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    QMMailCGIManager.access$000(this.this$2.this$1.this$0).mail.deleteMails(this.val$writableDb, paramArrayOfLong);
    QMMailCGIManager.access$1500(this.this$2.this$1.this$0).cancelNewMailNotify(this.val$accountId, paramArrayOfLong);
    if (paramBoolean1) {
      QMMailCGIManager.access$1500(this.this$2.this$1.this$0).updateAdvertiseEntrance(this.val$writableDb, this.val$accountId);
    }
    if (paramBoolean2) {
      QMMailCGIManager.access$1500(this.this$2.this$1.this$0).updateSubscribeEntrance(this.val$writableDb, this.val$accountId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.19.2.2
 * JD-Core Version:    0.7.0.1
 */