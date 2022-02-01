import Wallet.GetBroadCastHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.ArrayList;

class zxm
  implements aagm.a
{
  zxm(zxj paramzxj, ArrayList paramArrayList, SessionInfo paramSessionInfo) {}
  
  public void zP(String paramString)
  {
    int i = 1;
    GetBroadCastHbIdiomReq localGetBroadCastHbIdiomReq = new GetBroadCastHbIdiomReq();
    localGetBroadCastHbIdiomReq.billnos = this.rR;
    localGetBroadCastHbIdiomReq.sKey = paramString;
    localGetBroadCastHbIdiomReq.appid = AppSetting.getAppId();
    if (this.a.cZ == 1) {}
    for (;;)
    {
      localGetBroadCastHbIdiomReq.fromType = i;
      localGetBroadCastHbIdiomReq.platform = 0;
      localGetBroadCastHbIdiomReq.qqVersion = "3.4.4";
      zyb.a(localGetBroadCastHbIdiomReq, new zxn(this));
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
 * Qualified Name:     zxm
 * JD-Core Version:    0.7.0.1
 */