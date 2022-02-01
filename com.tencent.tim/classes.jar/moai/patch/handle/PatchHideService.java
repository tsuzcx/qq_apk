package moai.patch.handle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PatchHideService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    try
    {
      startForeground(813, PatchService.getNotification(this));
      label15:
      stopForeground(true);
      stopSelf();
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchHideService
 * JD-Core Version:    0.7.0.1
 */