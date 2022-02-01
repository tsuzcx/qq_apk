import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class vur
  implements biyn
{
  vur(String paramString) {}
  
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
      znl.a(1, 2131718766);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      znl.a(2, 2131718784);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vur
 * JD-Core Version:    0.7.0.1
 */