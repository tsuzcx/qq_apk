package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CustomFunction;
import com.tencent.qqmail.utilities.QMMath;

final class QMMailSQLiteHelper$2
  implements SQLiteDatabase.CustomFunction
{
  public long callback(String[] paramArrayOfString)
  {
    Log.d("QMMailSQLite", "CustomFunction: hashint(" + paramArrayOfString[0] + ")");
    return QMMath.hashInt(paramArrayOfString[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailSQLiteHelper.2
 * JD-Core Version:    0.7.0.1
 */