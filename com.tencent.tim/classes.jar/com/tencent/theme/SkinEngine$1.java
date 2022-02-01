package com.tencent.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.concurrent.RejectedExecutionException;

class SkinEngine$1
  extends BroadcastReceiver
{
  SkinEngine$1(SkinEngine paramSkinEngine) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (SkinEngine.SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "UpdateReceiver.onReceive ACTION_THEME_UPDATE");
    }
    try
    {
      new SkinEngine.a(this.a, null).execute(new Context[] { paramContext });
      return;
    }
    catch (RejectedExecutionException paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.theme.SkinEngine.1
 * JD-Core Version:    0.7.0.1
 */