import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.voip.VoipBuyGoods.BuyGoodsRsp;
import com.tencent.mobileqq.activity.voip.VoipTencentPayActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class exg
  extends Handler
{
  public exg(VoipTencentPayActivity paramVoipTencentPayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (VoipBuyGoods.BuyGoodsRsp)paramMessage.obj;
    if (paramMessage.error_code.get() == 0)
    {
      VoipTencentPayActivity.a(this.a, paramMessage.url_params.get());
      VoipTencentPayActivity.b(this.a);
      return;
    }
    VoipTencentPayActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exg
 * JD-Core Version:    0.7.0.1
 */