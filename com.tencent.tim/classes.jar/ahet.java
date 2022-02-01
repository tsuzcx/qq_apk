import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import mqq.app.AppRuntime;

public abstract class ahet
{
  public static int cZN = 1;
  public static int cZO = 2;
  private String mChannelName;
  
  public ahet(String paramString, BinaryMessenger paramBinaryMessenger)
  {
    this.mChannelName = paramString;
  }
  
  public AppRuntime c()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public String getAccount()
  {
    AppRuntime localAppRuntime = c();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return "";
  }
  
  public String im()
  {
    return this.mChannelName;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.BaseChannel", 2, String.format("channel: %s is destroy", new Object[] { im() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahet
 * JD-Core Version:    0.7.0.1
 */