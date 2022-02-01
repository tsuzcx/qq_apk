package com.tencent.mobileqq.confess;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ConfessMsgUtil$3
  implements Runnable
{
  public ConfessMsgUtil$3(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.val$app.b().a(this.val$uin, this.val$type, this.cgk, this.bTM, this.bIv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.3
 * JD-Core Version:    0.7.0.1
 */