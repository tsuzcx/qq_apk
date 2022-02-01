package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.cache.SettingItem;

class QMSettingSQLiteHelper$1
  implements Runnable
{
  QMSettingSQLiteHelper$1(QMSettingSQLiteHelper paramQMSettingSQLiteHelper, SQLiteDatabase paramSQLiteDatabase, SettingItem paramSettingItem) {}
  
  public void run()
  {
    this.this$0.insertItem(this.val$writableDb, this.val$item);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSettingSQLiteHelper.1
 * JD-Core Version:    0.7.0.1
 */