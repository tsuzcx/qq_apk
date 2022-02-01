import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class apnq
  extends apms
{
  public apnq(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 17;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (((paramObject instanceof apab.a)) && (((apab.a)paramObject).cPu)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_hongbao", 0, 0, this.sessionInfo.aTl, "", "", "");
      anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_hongbao", 0, 0, this.sessionInfo.aTl, "", "", "");
      return;
    }
    anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_sf", 0, 0, this.sessionInfo.aTl, "", "", "");
    anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_special_focus", 0, 0, this.sessionInfo.aTl, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apnq
 * JD-Core Version:    0.7.0.1
 */