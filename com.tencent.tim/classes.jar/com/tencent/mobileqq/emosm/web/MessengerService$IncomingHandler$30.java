package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;

class MessengerService$IncomingHandler$30
  implements Runnable
{
  MessengerService$IncomingHandler$30(MessengerService.a parama, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface, Bundle paramBundle1, Bundle paramBundle2, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    MessengerService.a.a(this.this$0, this.val$service, this.val$qqApp, this.val$reqbundle, this.aH, this.val$startCheckParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.30
 * JD-Core Version:    0.7.0.1
 */