package com.tencent.qqmail.popularize;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class PopularizeSQLiteHelper$2
  implements Runnable
{
  PopularizeSQLiteHelper$2(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, int paramInt, SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    String str = this.val$id + "";
    this.val$writableDb.delete("QM_POPULARIZE", "id=?", new String[] { str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.2
 * JD-Core Version:    0.7.0.1
 */