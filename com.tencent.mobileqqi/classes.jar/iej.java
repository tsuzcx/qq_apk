import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;

public final class iej
  implements IPluginManager.OnPluginReadyListener
{
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean)
    {
      IPluginManager.b((Activity)paramContext, paramPluginParams);
      return;
    }
    Toast.makeText(paramContext, "加载失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iej
 * JD-Core Version:    0.7.0.1
 */