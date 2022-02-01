package androidx.core.app;

import android.util.Log;
import java.lang.reflect.Method;

final class ActivityRecreator$3
  implements Runnable
{
  ActivityRecreator$3(Object paramObject1, Object paramObject2) {}
  
  public void run()
  {
    try
    {
      if (ActivityRecreator.performStopActivity3ParamsMethod != null)
      {
        ActivityRecreator.performStopActivity3ParamsMethod.invoke(this.val$activityThread, new Object[] { this.val$token, Boolean.valueOf(false), "AppCompat recreation" });
        return;
      }
      ActivityRecreator.performStopActivity2ParamsMethod.invoke(this.val$activityThread, new Object[] { this.val$token, Boolean.valueOf(false) });
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if ((localRuntimeException.getClass() == RuntimeException.class) && (localRuntimeException.getMessage() != null) && (localRuntimeException.getMessage().startsWith("Unable to stop"))) {
        throw localRuntimeException;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("ActivityRecreator", "Exception while invoking performStopActivity", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.app.ActivityRecreator.3
 * JD-Core Version:    0.7.0.1
 */