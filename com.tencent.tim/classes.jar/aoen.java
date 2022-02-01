import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

public class aoen
  implements WXShareHelper.a
{
  public aoen(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity, String paramString) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (!this.XY.equals(paramBaseResp.transaction)) {
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
      WXShareHelper.a().b(this.a.b);
      return;
      rwt.ez(2, 2131720175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoen
 * JD-Core Version:    0.7.0.1
 */