package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import mqq.app.MobileQQ;

class PluginInterface$1
  implements IBinder.DeathRecipient
{
  PluginInterface$1(PluginInterface paramPluginInterface, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
    this.val$binder.unlinkToDeath(this, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginInterface.1
 * JD-Core Version:    0.7.0.1
 */