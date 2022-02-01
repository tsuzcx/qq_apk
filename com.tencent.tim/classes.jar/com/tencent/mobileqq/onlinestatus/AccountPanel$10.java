package com.tencent.mobileqq.onlinestatus;

import akrv;
import anxk;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;

public class AccountPanel$10
  implements Runnable
{
  public AccountPanel$10(akrv paramakrv, QQAppInterface paramQQAppInterface, SimpleAccount paramSimpleAccount) {}
  
  public void run()
  {
    this.val$app.b().ca(this.f.getUin(), 7000);
    anxk.c(this.val$app, false, null, this.f.getUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.10
 * JD-Core Version:    0.7.0.1
 */