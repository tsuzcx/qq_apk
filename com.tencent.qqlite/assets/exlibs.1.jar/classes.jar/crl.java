import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.qphone.base.util.QLog;
import wifiphoto.WifiPhotoDataCenter;

public class crl
  extends Thread
{
  public crl(DataLineHandler paramDataLineHandler) {}
  
  public void run()
  {
    DataLineHandler.a.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("wifiphoto", 2, "openWifiPhoto is running, resendWifiPhotoBasicInfo");
    }
    DataLineHandler.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     crl
 * JD-Core Version:    0.7.0.1
 */