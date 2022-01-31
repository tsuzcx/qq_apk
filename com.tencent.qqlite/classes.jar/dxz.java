import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class dxz
  implements WXShareHelper.WXShareListener
{
  dxz(dxy paramdxy) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.a.r == null) || (!this.a.a.r.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131363700);
      bool = false;
    }
    while (!TextUtils.isEmpty(this.a.a.q))
    {
      this.a.a.callJs(this.a.a.q, new String[] { String.valueOf(bool) });
      return;
      QRUtils.a(2, 2131363699);
      bool = true;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dxz
 * JD-Core Version:    0.7.0.1
 */