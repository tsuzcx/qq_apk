import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

public class yrk
  extends BroadcastReceiver
{
  public yrk(CmGameLauncher paramCmGameLauncher) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (CmGameLauncher.a(this.a) == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"android.intent.action.SCREEN_ON".equals(paramIntent.getAction())) {
            break;
          }
          if (CmGameLauncher.a(this.a))
          {
            CmGameLauncher.a(this.a).queueEvent(CmGameLauncher.a(this.a));
            return;
          }
        } while (CmGameLauncher.a(this.a) == null);
        CmGameLauncher.a(this.a).onResume();
        return;
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!CmGameLauncher.a(this.a)) {
        break;
      }
    } while (CmGameLauncher.a(this.a) == null);
    CmGameLauncher.a(this.a).queueEvent(CmGameLauncher.b(this.a));
    return;
    CmGameLauncher.a(this.a).setPreserveEGLContextOnPause(true);
    CmGameLauncher.a(this.a).onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yrk
 * JD-Core Version:    0.7.0.1
 */