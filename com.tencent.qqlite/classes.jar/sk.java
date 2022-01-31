import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class sk
  implements WXShareHelper.WXShareListener
{
  public sk(Share paramShare) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.l == null) || (!this.a.l.equals(paramBaseResp.transaction))) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QRUtils.a(1, 2131363700);
      return;
    }
    QRUtils.a(2, 2131363699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     sk
 * JD-Core Version:    0.7.0.1
 */