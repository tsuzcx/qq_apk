import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ywe
  implements WXShareHelper.WXShareListener
{
  ywe(ywd paramywd) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {}
    do
    {
      do
      {
        return;
      } while ((ApolloGameInvitation.a(this.a.a) == null) || (!ApolloGameInvitation.a(this.a.a).equals(paramBaseResp.transaction)));
      QLog.i("ApolloGameInvitation", 1, "[onWXShareResp], resp.errCode:" + paramBaseResp.errCode);
    } while ((paramBaseResp.errCode != 0) || (ApolloGameInvitation.a(this.a.a) == null) || (ApolloGameInvitation.a(this.a.a) == null) || ((AppInterface)ApolloGameInvitation.a(this.a.a).get() == null));
    VipUtils.a(null, "cmshow", "Apollo", "wechat_invite_sent", 0, 0, new String[] { Integer.toString(ApolloGameInvitation.a(this.a.a).e) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ywe
 * JD-Core Version:    0.7.0.1
 */