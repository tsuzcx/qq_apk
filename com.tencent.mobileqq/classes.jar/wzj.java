import Wallet.GoldMsgGetReq;
import Wallet.GoldMsgGetRsp;
import Wallet.GoldMsgSetReq;
import Wallet.GoldMsgSetRsp;
import com.tencent.mobileqq.activity.qwallet.GoldConfigObserver;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;

public class wzj
  extends GoldConfigObserver
{
  public wzj(GoldMsgSettingActivity paramGoldMsgSettingActivity) {}
  
  public void a(boolean paramBoolean, GoldMsgGetReq paramGoldMsgGetReq, GoldMsgGetRsp paramGoldMsgGetRsp)
  {
    if (this.a.a != null) {
      this.a.a.a(paramBoolean, paramGoldMsgGetReq, paramGoldMsgGetRsp);
    }
  }
  
  public void a(boolean paramBoolean, GoldMsgSetReq paramGoldMsgSetReq, GoldMsgSetRsp paramGoldMsgSetRsp)
  {
    if (this.a.a != null) {
      this.a.a.a(paramBoolean, paramGoldMsgSetReq, paramGoldMsgSetRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzj
 * JD-Core Version:    0.7.0.1
 */