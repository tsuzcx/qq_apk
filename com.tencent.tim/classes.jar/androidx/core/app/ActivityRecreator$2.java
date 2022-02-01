package androidx.core.app;

import android.app.Application;

final class ActivityRecreator$2
  implements Runnable
{
  ActivityRecreator$2(Application paramApplication, ActivityRecreator.LifecycleCheckCallbacks paramLifecycleCheckCallbacks) {}
  
  public void run()
  {
    this.val$application.unregisterActivityLifecycleCallbacks(this.val$callbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.app.ActivityRecreator.2
 * JD-Core Version:    0.7.0.1
 */