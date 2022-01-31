import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;

public class dwz
  extends BroadcastReceiver
{
  public dwz(UiApiPlugin paramUiApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      do
      {
        boolean bool;
        int j;
        do
        {
          do
          {
            return;
            i = paramIntent.getIntExtra("mode", 0);
            bool = paramIntent.getBooleanExtra("exclude", false);
            j = paramIntent.getIntExtra("sender", 0);
            paramContext = this.a.mRuntime.a();
          } while ((paramContext == null) || (paramContext.isFinishing()));
          if (j != this.a.d) {
            break;
          }
        } while (bool);
        paramContext.finish();
        return;
        if (j <= this.a.d) {
          break;
        }
      } while ((i != 0) && (i != 2));
      paramContext.finish();
      return;
    } while ((i != 0) && (i != 1));
    paramContext.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dwz
 * JD-Core Version:    0.7.0.1
 */