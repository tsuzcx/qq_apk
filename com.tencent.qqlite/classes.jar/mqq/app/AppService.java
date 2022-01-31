package mqq.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AppService
  extends Service
{
  protected static final int CONFIG_NEED_RUNTIME = 0;
  protected static final int CONFIG_NO_NEED_RUNTIME = 1;
  protected AppRuntime app;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  protected int onConfigRuntime()
  {
    return 0;
  }
  
  public void onCreate()
  {
    super.onCreate();
    MobileQQ.sMobileQQ.onActivityCreate(this, null);
    if (onConfigRuntime() == 0) {
      this.app = MobileQQ.getMobileQQ().waitAppRuntime(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.app.AppService
 * JD-Core Version:    0.7.0.1
 */