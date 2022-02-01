package cooperation.qqfav;

import avjv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static avjv a;
  
  public static avjv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avjv(BaseApplicationImpl.getApplication().getRuntime());
      }
      return a;
    }
    finally {}
  }
  
  public static boolean aKH()
  {
    avjv localavjv = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localavjv.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localavjv);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */