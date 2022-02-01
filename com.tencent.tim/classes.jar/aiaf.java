import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class aiaf
  implements INetInfoHandler
{
  aiaf(aiae paramaiae) {}
  
  public void onNetMobile2None()
  {
    Iterator localIterator = aiae.a(this.b).iterator();
    while (localIterator.hasNext()) {
      ((aiae.a)localIterator.next()).PJ(5);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetMobile2None onConnClose");
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    paramString = aiae.a(this.b).iterator();
    while (paramString.hasNext()) {
      ((aiae.a)paramString.next()).PJ(4);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetMobile2Wifi onConnOK");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    paramString = aiae.a(this.b).iterator();
    while (paramString.hasNext()) {
      ((aiae.a)paramString.next()).PJ(3);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetNone2Mobile onConnOK");
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    paramString = aiae.a(this.b).iterator();
    while (paramString.hasNext()) {
      ((aiae.a)paramString.next()).PJ(2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetNone2Wifi onConnOK");
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    paramString = aiae.a(this.b).iterator();
    while (paramString.hasNext()) {
      ((aiae.a)paramString.next()).PJ(1);
    }
  }
  
  public void onNetWifi2None()
  {
    Iterator localIterator = aiae.a(this.b).iterator();
    while (localIterator.hasNext()) {
      ((aiae.a)localIterator.next()).PJ(0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetWifi2None onConnClose");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiaf
 * JD-Core Version:    0.7.0.1
 */