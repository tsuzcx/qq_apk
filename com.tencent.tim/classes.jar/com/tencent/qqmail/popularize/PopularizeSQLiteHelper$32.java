package com.tencent.qqmail.popularize;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class PopularizeSQLiteHelper$32
  implements Runnable
{
  PopularizeSQLiteHelper$32(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, String paramString1, SQLiteDatabase paramSQLiteDatabase, String paramString2) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("subInformationData", this.val$subInformationData);
    this.val$writableDb.update("QM_POPULARIZE", localContentValues, "subInformation=?", new String[] { this.val$subInfomation });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.32
 * JD-Core Version:    0.7.0.1
 */