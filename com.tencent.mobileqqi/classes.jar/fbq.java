import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.activity.voip.VoipTencentPayActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.Timer;

public class fbq
  implements IPluginManager.OnPluginReadyListener
{
  public fbq(VoipTencentPayActivity paramVoipTencentPayActivity) {}
  
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean)
    {
      paramContext = new fbr(this);
      new Timer().schedule(paramContext, 100L);
      return;
    }
    VoipTencentPayActivity.a().post(new fbs(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fbq
 * JD-Core Version:    0.7.0.1
 */