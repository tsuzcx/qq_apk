package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMNetworkHandler.NetworkListener;
import java.util.concurrent.atomic.AtomicBoolean;

class SendMailManager$6
  implements QMNetworkHandler.NetworkListener
{
  SendMailManager$6(SendMailManager paramSendMailManager, AtomicBoolean paramAtomicBoolean) {}
  
  public void onNetworkChanged(boolean paramBoolean)
  {
    this.val$hasChanged.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.6
 * JD-Core Version:    0.7.0.1
 */