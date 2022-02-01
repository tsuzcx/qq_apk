package com.tencent.qqmail.popularize;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class PopularizeSQLiteHelper$18
  implements Runnable
{
  PopularizeSQLiteHelper$18(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, int paramInt1, SQLiteDatabase paramSQLiteDatabase, int paramInt2) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("move", Integer.valueOf(this.val$move));
    this.val$writableDb.update("QM_POPULARIZE", localContentValues, "id=?", new String[] { String.valueOf(this.val$popularizeId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.18
 * JD-Core Version:    0.7.0.1
 */