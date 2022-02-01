import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicPreDownloader;

public class gdz
  extends BroadcastReceiver
{
  private String a;
  
  public gdz(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent))
    {
      PicPreDownloader.a(PicPreDownloader.a());
      if (!a(paramContext))
      {
        PicPreDownloader.b(bool);
        label36:
        Logger.a("PIC_TAG_PRELOAD", "onReceive", "isScreenOn:" + PicPreDownloader.a() + ",lastScreenOnState:" + PicPreDownloader.b());
        if (PicPreDownloader.b() != PicPreDownloader.a()) {
          break label138;
        }
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
      {
        PicPreDownloader.a(PicPreDownloader.a());
        PicPreDownloader.b(false);
        break label36;
      }
      if (!"android.intent.action.USER_PRESENT".equals(paramIntent)) {
        break label36;
      }
      PicPreDownloader.a(PicPreDownloader.a());
      PicPreDownloader.b(true);
      break label36;
      try
      {
        label138:
        paramContext = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.a);
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.a();
        if (paramContext == null) {
          continue;
        }
        paramContext.d();
        PicPreDownloader.a(paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gdz
 * JD-Core Version:    0.7.0.1
 */