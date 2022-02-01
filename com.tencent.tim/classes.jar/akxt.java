import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;

public class akxt
  implements WXShareHelper.a
{
  public akxt(PicShareToWX paramPicShareToWX, int paramInt) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 1, "onWXShareResp resp.errCode = " + paramBaseResp.errCode + ", fromType = " + this.lM);
    }
    if (paramBaseResp.errCode == 0)
    {
      PicShareToWX.bJ(this.lM, true);
      PicShareToWX.a(this.this$0, true, 0, 1);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      PicShareToWX.bJ(this.lM, false);
      PicShareToWX.a(this.this$0, false, paramBaseResp.errCode, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxt
 * JD-Core Version:    0.7.0.1
 */