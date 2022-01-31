import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.activity.voip.VoipTencentPayActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.Timer;

public class exc
  implements IPluginManager.OnPluginReadyListener
{
  public exc(VoipTencentPayActivity paramVoipTencentPayActivity) {}
  
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean)
    {
      paramContext = new exd(this);
      new Timer().schedule(paramContext, 100L);
      return;
    }
    VoipTencentPayActivity.a().post(new exe(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exc
 * JD-Core Version:    0.7.0.1
 */