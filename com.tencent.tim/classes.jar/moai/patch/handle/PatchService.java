package moai.patch.handle;

import android.app.IntentService;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import moai.patch.log.PatchLog;
import moai.patch.util.PatchUtil;

public class PatchService
  extends IntentService
{
  static final int ID = 813;
  private boolean isPatching = false;
  
  public PatchService()
  {
    super("PatchService");
  }
  
  private void foreground()
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (;;)
    {
      return;
      try
      {
        startForeground(813, getNotification(this));
        label20:
        Object localObject = null;
        try
        {
          ComponentName localComponentName = startService(new Intent(this, PatchHideService.class));
          localObject = localComponentName;
        }
        catch (Throwable localThrowable3)
        {
          label39:
          break label39;
        }
        if (localObject != null) {
          continue;
        }
        try
        {
          stopForeground(true);
          return;
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        break label20;
      }
    }
  }
  
  public static Notification getNotification(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      paramContext = new Notification();
      paramContext.icon = 2130842106;
      return paramContext;
    }
    paramContext = new Notification.Builder(paramContext);
    paramContext.setSmallIcon(2130842106);
    return paramContext.build();
  }
  
  public void onCreate()
  {
    super.onCreate();
    foreground();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      long l = PatchUtil.getAvailableInternalMemorySize();
      if (paramIntent.getBooleanExtra("reodex", false))
      {
        new PatchTask().reodex(this);
        return;
      }
      String str = paramIntent.getStringExtra("patchFilePath");
      paramIntent = paramIntent.getStringExtra("patchKey");
      PatchLog.w(10000, "onHandleIntent, internal_mem_left:" + l + ",path:" + str + ",key:" + paramIntent);
      if (this.isPatching)
      {
        PatchLog.i(10001, "patching. ignore:" + str + "," + paramIntent);
        return;
      }
      this.isPatching = true;
      new PatchTask().install(this, paramIntent, str);
      this.isPatching = false;
      return;
    }
    PatchLog.i(10002, "patch service null intent");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchService
 * JD-Core Version:    0.7.0.1
 */