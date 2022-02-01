package com.tencent.qqmail.popularize;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeSQLiteHelper$10
  implements Runnable
{
  PopularizeSQLiteHelper$10(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase, Popularize paramPopularize) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.val$isRender) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("isRender", Integer.valueOf(i));
      this.val$writableDb.update("QM_POPULARIZE", localContentValues, "id=?", new String[] { String.valueOf(this.val$popularize.getId()) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.10
 * JD-Core Version:    0.7.0.1
 */