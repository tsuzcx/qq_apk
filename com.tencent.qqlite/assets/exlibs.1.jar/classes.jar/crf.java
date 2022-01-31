import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.qphone.base.util.QLog;
import wifiphoto.WifiPhotoDataCenter;

public class crf
  extends Thread
{
  public crf(DataLineHandler paramDataLineHandler) {}
  
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
 * Qualified Name:     crf
 * JD-Core Version:    0.7.0.1
 */