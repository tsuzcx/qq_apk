import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class zwg
  implements bjig
{
  public zwg(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.a.g == null) || (!this.a.g.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      zyx.a(1, 2131718139);
      return;
    }
    zyx.a(2, 2131718157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwg
 * JD-Core Version:    0.7.0.1
 */