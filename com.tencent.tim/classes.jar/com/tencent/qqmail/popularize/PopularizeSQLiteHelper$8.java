package com.tencent.qqmail.popularize;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeSQLiteHelper$8
  implements Runnable
{
  PopularizeSQLiteHelper$8(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, long paramLong, SQLiteDatabase paramSQLiteDatabase, Popularize paramPopularize) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("lastRenderTime", Long.valueOf(this.val$time));
    this.val$writableDb.update("QM_POPULARIZE", localContentValues, "id=?", new String[] { String.valueOf(this.val$popularize.getId()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.8
 * JD-Core Version:    0.7.0.1
 */