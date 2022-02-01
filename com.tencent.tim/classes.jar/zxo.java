import Wallet.IdiomRedPackMatchReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class zxo
  implements aagm.a
{
  zxo(zxj paramzxj, zxi paramzxi, String paramString, SessionInfo paramSessionInfo, long paramLong, int paramInt) {}
  
  public void zP(String paramString)
  {
    int i = 1;
    IdiomRedPackMatchReq localIdiomRedPackMatchReq = new IdiomRedPackMatchReq();
    localIdiomRedPackMatchReq.grabUin = zxj.a(this.this$0).getLongAccountUin();
    localIdiomRedPackMatchReq.billno = this.b.redBagId;
    localIdiomRedPackMatchReq.inputIdiom = this.SS;
    localIdiomRedPackMatchReq.hbIdiom = zxj.a(this.this$0, this.b);
    localIdiomRedPackMatchReq.makeUin = Long.parseLong(this.b.baZ);
    localIdiomRedPackMatchReq.sKey = paramString;
    localIdiomRedPackMatchReq.appid = AppSetting.getAppId();
    localIdiomRedPackMatchReq.subchannel = this.b.ys();
    if (this.a.cZ == 1) {}
    for (;;)
    {
      localIdiomRedPackMatchReq.fromType = i;
      localIdiomRedPackMatchReq.platform = 0;
      localIdiomRedPackMatchReq.qqVersion = "3.4.4";
      zyb.a(localIdiomRedPackMatchReq, new zxp(this));
      return;
      if (this.a.cZ == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxo
 * JD-Core Version:    0.7.0.1
 */