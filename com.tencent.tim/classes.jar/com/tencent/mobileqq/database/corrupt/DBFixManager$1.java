package com.tencent.mobileqq.database.corrupt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class DBFixManager$1
  implements Runnable
{
  DBFixManager$1(DBFixManager paramDBFixManager) {}
  
  public void run()
  {
    Object localObject = this.this$0.mApp.getApplication().getSharedPreferences(DBFixManager.bCE, 0);
    String str = this.this$0.mApp.getCurrentAccountUin();
    if (((SharedPreferences)localObject).getBoolean(str + DBFixManager.bCG, false))
    {
      this.this$0.aiF();
      if ((((SharedPreferences)localObject).getInt(str + DBFixManager.bCH, 0) < DBFixManager.cPT) && (DBFixManager.bXb)) {
        this.this$0.mApp.runOnUiThread(new DBFixManager.1.1(this));
      }
    }
    else
    {
      return;
    }
    QLog.d(DBFixManager.access$000(), 1, "DBFixDialogUI 1, max count, delete db");
    this.this$0.HG(false);
    this.this$0.cYj();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.bCG);
    ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.bCH);
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixManager.1
 * JD-Core Version:    0.7.0.1
 */