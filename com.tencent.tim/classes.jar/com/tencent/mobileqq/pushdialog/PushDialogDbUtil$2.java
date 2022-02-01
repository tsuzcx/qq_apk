package com.tencent.mobileqq.pushdialog;

import aljf;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Date;

public class PushDialogDbUtil$2
  implements Runnable
{
  public PushDialogDbUtil$2(aljf paramaljf, EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void run()
  {
    synchronized (aljf.a(this.this$0))
    {
      this.val$entityManager.remove(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("PushDialogDbUtil", 3, "PushDialogTemplate delete: " + new Date(this.b.time) + "," + this.b.mUin + "," + this.b.c2c_type);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2
 * JD-Core Version:    0.7.0.1
 */