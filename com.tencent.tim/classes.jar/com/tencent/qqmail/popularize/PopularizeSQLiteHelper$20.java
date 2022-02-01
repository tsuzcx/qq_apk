package com.tencent.qqmail.popularize;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class PopularizeSQLiteHelper$20
  implements Runnable
{
  PopularizeSQLiteHelper$20(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isOpen", Boolean.valueOf(this.val$isOpen));
    this.val$writableDb.update("QM_POPULARIZE", localContentValues, "id=?", new String[] { String.valueOf(this.val$popularizeId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.20
 * JD-Core Version:    0.7.0.1
 */