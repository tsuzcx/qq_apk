import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class xbj
  implements bcww
{
  xbj(String paramString) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a == null) || (!this.a.equals(paramBaseResp.transaction))) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      wij.a(1, 2131719487);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      wij.a(2, 2131719506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xbj
 * JD-Core Version:    0.7.0.1
 */