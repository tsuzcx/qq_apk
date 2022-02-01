import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class nvb
  implements INetInfoHandler
{
  public nvb(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
    }
    this.this$0.getNetType(this.val$callback);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=" + paramString);
    }
    this.this$0.getNetType(this.val$callback);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_XG,ssid=" + paramString);
    }
    this.this$0.getNetType(this.val$callback);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=" + paramString);
    }
    this.this$0.getNetType(this.val$callback);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_XG,ssid=" + paramString);
    }
    this.this$0.getNetType(this.val$callback);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
    }
    this.this$0.getNetType(this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvb
 * JD-Core Version:    0.7.0.1
 */