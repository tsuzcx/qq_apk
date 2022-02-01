import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

final class avfy
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "handleOtherProcess onPluginManagerLoaded");
    }
    avfw.a(paramPluginManagerClient);
    avfw.a(null);
    while (!avfw.a().isEmpty())
    {
      paramPluginManagerClient = (avfw.e)avfw.a().poll();
      if (paramPluginManagerClient != null) {
        avfw.d(paramPluginManagerClient.context, paramPluginManagerClient.jdField_b_of_type_Avfw$d, paramPluginManagerClient.jdField_b_of_type_Avfw$b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfy
 * JD-Core Version:    0.7.0.1
 */