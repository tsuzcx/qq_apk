import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class zkm
  implements biyn
{
  public zkm(QRDisplayActivity paramQRDisplayActivity) {}
  
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
      znl.a(1, 2131718766);
      return;
    }
    znl.a(2, 2131718784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkm
 * JD-Core Version:    0.7.0.1
 */