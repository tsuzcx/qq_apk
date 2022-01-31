import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import wifiphoto.WifiPhotoDataCenter;
import wifiphoto.WifiPhotoStatusMgr;

public class cso
  extends TimerTask
{
  public cso(DataLineHandler paramDataLineHandler) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("wifiphoto", 2, "wifiphoto heart beat check");
    }
    long l = System.currentTimeMillis();
    if ((DataLineHandler.a.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr.b()) && (l > DataLineHandler.a.jdField_a_of_type_Long) && (l - DataLineHandler.a.jdField_a_of_type_Long > 45000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wifiphoto", 2, "wifiphoto heart beat timer out");
      }
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cso
 * JD-Core Version:    0.7.0.1
 */