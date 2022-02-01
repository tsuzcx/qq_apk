import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class zlz
  implements WXShareHelper.WXShareListener
{
  zlz(zlv paramzlv) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((zlv.a(this.a) == null) || (!zlv.a(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.a.a, 1, amtj.a(2131713681), 0).a();
      return;
    }
    QQToast.a(this.a.a, 2, amtj.a(2131713683), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlz
 * JD-Core Version:    0.7.0.1
 */