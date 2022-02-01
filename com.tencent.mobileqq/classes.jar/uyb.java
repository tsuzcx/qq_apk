import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class uyb
  implements bjig
{
  uyb(String paramString) {}
  
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
      zyx.a(1, 2131718139);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      zyx.a(2, 2131718157);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyb
 * JD-Core Version:    0.7.0.1
 */