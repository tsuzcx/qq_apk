import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

final class ouc
  implements WXShareHelper.a
{
  ouc(String paramString) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.XY == null) || (!this.XY.equals(paramBaseResp.transaction))) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      rwt.ez(1, 2131720152);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      rwt.ez(2, 2131720175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouc
 * JD-Core Version:    0.7.0.1
 */