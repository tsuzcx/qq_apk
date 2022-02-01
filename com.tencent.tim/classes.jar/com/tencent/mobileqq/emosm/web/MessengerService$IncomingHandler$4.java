package com.tencent.mobileqq.emosm.web;

import abhh;
import ablz;
import afjs;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;

public class MessengerService$IncomingHandler$4
  implements Runnable
{
  MessengerService$IncomingHandler$4(MessengerService.a parama, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    ablz localablz = ((abhh)this.val$qqApp.getManager(153)).a();
    localablz.a(localablz.rd(), new afjs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.4
 * JD-Core Version:    0.7.0.1
 */