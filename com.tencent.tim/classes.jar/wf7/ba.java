package wf7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class ba
  extends BroadcastReceiver
{
  public abstract void a(Context paramContext, Intent paramIntent);
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    ar localar = bz.av().u().z();
    if ((localar != null) && (localar.B()) && (paramIntent != null)) {
      localar.a("broadcast", paramIntent.getAction());
    }
    try
    {
      a(paramContext, paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      bz.av().A().z().a(new Thread(), paramContext, "broadcast receiver failed", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ba
 * JD-Core Version:    0.7.0.1
 */