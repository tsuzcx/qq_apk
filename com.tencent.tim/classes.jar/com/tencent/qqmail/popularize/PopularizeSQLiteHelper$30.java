package com.tencent.qqmail.popularize;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class PopularizeSQLiteHelper$30
  implements Runnable
{
  PopularizeSQLiteHelper$30(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.val$isCancel) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("isCancel", Integer.valueOf(i));
      this.val$writableDb.update("QM_POPULARIZE_SUBITEM", localContentValues, "id=?", new String[] { String.valueOf(this.val$subItemId) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.30
 * JD-Core Version:    0.7.0.1
 */