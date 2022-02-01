package com.tencent.mobileqq.pushdialog;

import aljf;
import android.database.sqlite.SQLiteException;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Date;

public class PushDialogDbUtil$3
  implements Runnable
{
  public PushDialogDbUtil$3(aljf paramaljf, EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void run()
  {
    synchronized (aljf.a(this.this$0))
    {
      try
      {
        this.val$entityManager.persist(this.b);
        if (QLog.isColorLevel()) {
          QLog.d("PushDialogDbUtil", 3, "PushDialogTemplate insert: " + new Date(this.b.time) + "," + this.b.mUin + "," + this.b.c2c_type);
        }
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PushDialogDbUtil", 0, localSQLiteException.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3
 * JD-Core Version:    0.7.0.1
 */