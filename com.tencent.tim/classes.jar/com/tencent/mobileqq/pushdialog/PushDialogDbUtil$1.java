package com.tencent.mobileqq.pushdialog;

import aljf;
import aljf.a;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class PushDialogDbUtil$1
  implements Runnable
{
  public PushDialogDbUtil$1(aljf paramaljf, EntityManager paramEntityManager, String[] paramArrayOfString, long paramLong1, long paramLong2, aljf.a parama) {}
  
  public void run()
  {
    synchronized (aljf.a(this.this$0))
    {
      List localList = this.val$entityManager.query(PushDialogTemplate.class, true, "mUin=? AND time>=?", this.gj, null, null, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("PushDialogDbUtil", 3, "PushDialogTemplate query: " + this.val$uin + ", queryTime: " + new Date(this.agK));
      }
      if (this.a != null) {
        this.a.lR(localList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1
 * JD-Core Version:    0.7.0.1
 */