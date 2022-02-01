package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;

final class ShortcutManagerCompat$1
  extends BroadcastReceiver
{
  ShortcutManagerCompat$1(IntentSender paramIntentSender) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      this.val$callback.sendIntent(paramContext, 0, null, null, null);
      return;
    }
    catch (IntentSender.SendIntentException paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.content.pm.ShortcutManagerCompat.1
 * JD-Core Version:    0.7.0.1
 */