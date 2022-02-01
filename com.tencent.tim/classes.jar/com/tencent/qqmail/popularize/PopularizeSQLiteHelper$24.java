package com.tencent.qqmail.popularize;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;

class PopularizeSQLiteHelper$24
  implements Runnable
{
  PopularizeSQLiteHelper$24(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, long paramLong, SQLiteDatabase paramSQLiteDatabase, PopularizeSubItem paramPopularizeSubItem) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("lastRenderTime", Long.valueOf(this.val$time));
    this.val$writableDb.update("QM_POPULARIZE_SUBITEM", localContentValues, "id=?", new String[] { String.valueOf(this.val$subitem.getId()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.24
 * JD-Core Version:    0.7.0.1
 */