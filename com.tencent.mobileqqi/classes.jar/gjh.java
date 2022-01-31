import com.tencent.mobileqq.servlet.QZoneServlet;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.TimerTask;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class gjh
  extends TimerTask
{
  private gjh(QZoneServlet paramQZoneServlet) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = this.a.getAppRuntime();
    this.a.a = ReflectedMethods.a(BaseApplication.getContext(), "QZONE_UNREAD");
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), QZoneServlet.class);
    localNewIntent.setAction("QZone_Get_Unread");
    localNewIntent.putExtra("bNotWorkInBackGround", true);
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjh
 * JD-Core Version:    0.7.0.1
 */