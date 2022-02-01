package com.tencent.qqmail.popularize;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;

class PopularizeSQLiteHelper$28
  implements Runnable
{
  PopularizeSQLiteHelper$28(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase, PopularizeSubItem paramPopularizeSubItem) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.val$isClickMyApp) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("isClickMyApp", Integer.valueOf(i));
      this.val$writableDb.update("QM_POPULARIZE_SUBITEM", localContentValues, "id=?", new String[] { String.valueOf(this.val$subitem.getId()) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.28
 * JD-Core Version:    0.7.0.1
 */