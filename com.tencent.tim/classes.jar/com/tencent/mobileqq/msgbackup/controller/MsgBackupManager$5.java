package com.tencent.mobileqq.msgbackup.controller;

import ajdx;
import ajee;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class MsgBackupManager$5
  implements Runnable
{
  public MsgBackupManager$5(ajee paramajee) {}
  
  public void run()
  {
    List localList = ajee.a(this.this$0).b().cv();
    if (ajee.a(this.this$0) != null) {
      ajee.a(this.this$0).lq(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5
 * JD-Core Version:    0.7.0.1
 */