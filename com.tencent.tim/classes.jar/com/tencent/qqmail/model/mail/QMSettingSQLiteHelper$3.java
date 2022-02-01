package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import org.apache.commons.lang3.StringUtils;

class QMSettingSQLiteHelper$3
  implements Runnable
{
  QMSettingSQLiteHelper$3(QMSettingSQLiteHelper paramQMSettingSQLiteHelper, SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString) {}
  
  public void run()
  {
    this.val$writableDb.delete("QM_SETTING", "id IN (" + StringUtils.repeat("?", ",", this.val$ks.length) + ")", this.val$ks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSettingSQLiteHelper.3
 * JD-Core Version:    0.7.0.1
 */