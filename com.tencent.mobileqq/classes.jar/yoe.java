import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

public class yoe
  extends BroadcastReceiver
{
  public yoe(CmGameLauncher paramCmGameLauncher) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (CmGameLauncher.a(this.a) == null) {}
    do
    {
      return;
      if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
      {
        CmGameLauncher.a(this.a).onResume();
        return;
      }
    } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
    CmGameLauncher.a(this.a).setPreserveEGLContextOnPause(true);
    CmGameLauncher.a(this.a).onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yoe
 * JD-Core Version:    0.7.0.1
 */