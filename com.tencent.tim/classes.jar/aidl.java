import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.qphone.base.util.QLog;

public final class aidl
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginLauncher", 2, "onReceive ACTION_FORCE_UPDATE");
    }
    if (TextUtils.equals(paramIntent.getAction(), "action_iv_plugin_update"))
    {
      paramIntent = (InstalledPlugin)paramIntent.getSerializableExtra("plugin");
      if (paramIntent != null)
      {
        boolean bool = aido.a(paramContext, paramIntent).aoT();
        if (QLog.isColorLevel()) {
          QLog.d("HuayangPluginLauncher", 2, "onReceive isCalled:" + bool);
        }
        if (!bool)
        {
          com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity.abo = 0L;
          Process.killProcess(Process.myPid());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidl
 * JD-Core Version:    0.7.0.1
 */