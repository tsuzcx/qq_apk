import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

final class ope
  implements WXShareHelper.a
{
  public void a(BaseResp paramBaseResp)
  {
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      arxa.a().showToast(2131720152);
    }
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ope
 * JD-Core Version:    0.7.0.1
 */