import Wallet.GetRandomHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.BusinessObserver;

class zxq
  implements aagm.a
{
  zxq(zxj paramzxj, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver) {}
  
  public void zP(String paramString)
  {
    if (zxj.a(this.this$0) != null)
    {
      GetRandomHbIdiomReq localGetRandomHbIdiomReq = new GetRandomHbIdiomReq();
      localGetRandomHbIdiomReq.makeUin = zxj.a(this.this$0).getLongAccountUin();
      localGetRandomHbIdiomReq.subchannel = this.cfw;
      localGetRandomHbIdiomReq.sKey = paramString;
      localGetRandomHbIdiomReq.appid = AppSetting.getAppId();
      localGetRandomHbIdiomReq.fromType = this.lM;
      localGetRandomHbIdiomReq.platform = 0;
      localGetRandomHbIdiomReq.qqVersion = "3.4.4";
      zyb.a(localGetRandomHbIdiomReq, this.val$observer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxq
 * JD-Core Version:    0.7.0.1
 */