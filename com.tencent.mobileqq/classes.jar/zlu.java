import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class zlu
  implements WXShareHelper.WXShareListener
{
  zlu(zlp paramzlp) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((zlp.c(this.a) == null) || (!zlp.c(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(zlp.a(this.a), 1, "分享失败", 0).a();
      return;
    }
    QQToast.a(zlp.a(this.a), 2, "分享成功", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlu
 * JD-Core Version:    0.7.0.1
 */