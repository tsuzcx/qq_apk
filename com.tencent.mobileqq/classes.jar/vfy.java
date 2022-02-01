import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class vfy
  implements WXShareHelper.WXShareListener
{
  vfy(String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.a == null) || (!this.a.equals(paramBaseResp.transaction))) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      yyi.a(1, 2131718380);
    }
    for (;;)
    {
      WXShareHelper.getInstance().removeObserver(this);
      return;
      yyi.a(2, 2131718398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfy
 * JD-Core Version:    0.7.0.1
 */