import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

public final class efp
  extends PluginRecoverReceiver
{
  protected void onRecver(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      ReportController.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "NetPlugins", "Download", 9527, 0, "0", "0", paramString, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     efp
 * JD-Core Version:    0.7.0.1
 */