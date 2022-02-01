import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class jza
  implements INetInfoHandler
{
  jza(jyy paramjyy) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetMobile2None");
    }
    jyy.b(this.this$0);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetNone2Mobile");
    }
    jyy.b(this.this$0);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetWifi2Mobile");
    }
    jyy.b(this.this$0);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetWifi2None");
    }
    jyy.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jza
 * JD-Core Version:    0.7.0.1
 */