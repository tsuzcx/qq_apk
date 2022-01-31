import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class gjf
  extends TimerTask
{
  public gjf(QZoneNotifyServlet paramQZoneNotifyServlet) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.QZoneNotifyServlet", 2, "QZONE GET UNREAD.QZoneFeedTimeTask run.");
    }
    AppRuntime localAppRuntime = this.a.getAppRuntime();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), QZoneNotifyServlet.class);
    localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
    localNewIntent.putExtra("bNotWorkInBackGround", true);
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjf
 * JD-Core Version:    0.7.0.1
 */