import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ewx
  extends Handler
{
  public ewx() {}
  
  public ewx(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (ThemeUiPlugin.reportHandler == null) {
      ThemeUiPlugin.reportHandler = new ewx(BaseApplication.getContext().getMainLooper());
    }
    int i = paramMessage.what;
    Object localObject = (Object[])paramMessage.obj;
    if (i == 1)
    {
      if (ThemeUiPlugin.reportTimes < 3)
      {
        paramMessage = (String)localObject[0];
        localObject = (QQAppInterface)localObject[1];
        if (QLog.isColorLevel()) {
          QLog.i("ThemeUiPlugin", 2, ThemeUiPlugin.initDownloadedThemeNumForReport + "," + ThemeUiPlugin.initCurrThemeNameForReport);
        }
        ReportController.b((QQAppInterface)localObject, "CliStatus", "", "", "ThemeMall", "ThemeCount", 0, 0, "" + ThemeUiPlugin.initDownloadedThemeNumForReport, "", "", "");
        ReportController.b((QQAppInterface)localObject, "CliStatus", "", "", "ThemeMall", "ThemeOn", 0, 0, "theme_" + ThemeUiPlugin.initCurrThemeNameForReport, "", "", "");
        ThemeUiPlugin.reportTimes += 1;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeUiPlugin", 2, "reportTimes is:" + ThemeUiPlugin.reportTimes);
        }
        Message localMessage = ThemeUiPlugin.reportHandler.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = new Object[] { paramMessage, localObject };
        ThemeUiPlugin.reportHandler.sendMessageDelayed(localMessage, 120000L);
      }
    }
    else {
      return;
    }
    ThemeUiPlugin.reportTimes = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ewx
 * JD-Core Version:    0.7.0.1
 */