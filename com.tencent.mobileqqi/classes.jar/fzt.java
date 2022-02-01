import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class fzt
  implements WXShareHelper.WXShareListener
{
  fzt(fzs paramfzs) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.a.c == null) || (!this.a.a.c.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131562035);
      bool = false;
    }
    while (!TextUtils.isEmpty(this.a.a.b))
    {
      this.a.a.callJs(this.a.a.b, new String[] { String.valueOf(bool) });
      return;
      QRUtils.a(2, 2131562917);
      bool = true;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzt
 * JD-Core Version:    0.7.0.1
 */