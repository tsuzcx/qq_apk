package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMNetworkHandler.NetworkListener;

final class FtnManagerImpl$1
  implements QMNetworkHandler.NetworkListener
{
  public void onNetworkChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (FtnManagerImpl.access$000())
      {
        FtnManagerImpl.access$000().notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */