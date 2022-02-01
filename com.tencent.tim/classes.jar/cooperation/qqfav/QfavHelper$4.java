package cooperation.qqfav;

import android.content.Context;
import avje;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;

public final class QfavHelper$4
  extends Thread
{
  public QfavHelper$4(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener) {}
  
  public void run()
  {
    PluginManagerHelper.getPluginInterface(this.val$context, new avje(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.4
 * JD-Core Version:    0.7.0.1
 */