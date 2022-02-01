import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.activity.voip.VoipTencentPayActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.Timer;

public class exb
  implements IPluginManager.OnPluginReadyListener
{
  public exb(VoipTencentPayActivity paramVoipTencentPayActivity) {}
  
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean)
    {
      paramContext = new exc(this);
      new Timer().schedule(paramContext, 100L);
      return;
    }
    VoipTencentPayActivity.a().post(new exd(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exb
 * JD-Core Version:    0.7.0.1
 */