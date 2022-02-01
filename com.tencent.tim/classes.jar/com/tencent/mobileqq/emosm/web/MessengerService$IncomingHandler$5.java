package com.tencent.mobileqq.emosm.web;

import abhh;
import ablz;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;

class MessengerService$IncomingHandler$5
  implements Runnable
{
  MessengerService$IncomingHandler$5(MessengerService.a parama, QQAppInterface paramQQAppInterface, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void run()
  {
    boolean bool = ((abhh)this.val$qqApp.getManager(153)).a().jv(this.aI.getString("url"));
    Bundle localBundle = new Bundle();
    if (bool) {}
    for (int i = 0;; i = -1)
    {
      localBundle.putInt("result", i);
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.cp(this.val$reqbundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.5
 * JD-Core Version:    0.7.0.1
 */