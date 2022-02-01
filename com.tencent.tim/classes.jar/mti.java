import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class mti
  implements INetInfoHandler
{
  mti(mtg parammtg) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetMobile2None()");
    }
    mtg.b(this.this$0);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetMobile2Wifi() ssid=" + paramString);
    }
    mtg.a(this.this$0, true);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetNone2Mobile() apn=" + paramString);
    }
    mtg.a(this.this$0, false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetNone2Wifi() ssid=" + paramString);
    }
    mtg.a(this.this$0, true);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetWifi2Mobile() apn=" + paramString);
    }
    mtg.a(this.this$0, false);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "INetInfoHandler onNetWifi2None()");
    }
    mtg.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mti
 * JD-Core Version:    0.7.0.1
 */