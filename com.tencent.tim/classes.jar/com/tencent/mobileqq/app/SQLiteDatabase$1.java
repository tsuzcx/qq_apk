package com.tencent.mobileqq.app;

import android.os.Vibrator;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

class SQLiteDatabase$1
  implements Runnable
{
  SQLiteDatabase$1(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    Toast.makeText(BaseApplication.getContext(), "detect illegal message delete", 1).show();
    ((Vibrator)BaseApplication.getContext().getSystemService("vibrator")).vibrate(new long[] { 100L, 400L, 100L, 400L }, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteDatabase.1
 * JD-Core Version:    0.7.0.1
 */