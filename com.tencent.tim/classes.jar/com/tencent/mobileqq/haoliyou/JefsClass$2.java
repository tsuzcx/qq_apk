package com.tencent.mobileqq.haoliyou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

class JefsClass$2
  implements TeleScreenRunnable
{
  JefsClass$2(JefsClass paramJefsClass, Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      ((PluginProxyActivity)this.r).superStartActivityForResult(this.val$intent, this.val$i, this.val$bundle);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.2
 * JD-Core Version:    0.7.0.1
 */