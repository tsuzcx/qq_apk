package wf7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class es
  extends BroadcastReceiver
{
  public abstract void a(Context paramContext, Intent paramIntent);
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      a(paramContext, paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.es
 * JD-Core Version:    0.7.0.1
 */