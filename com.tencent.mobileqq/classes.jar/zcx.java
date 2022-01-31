import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class zcx
  implements WXShareHelper.WXShareListener
{
  zcx(zcw paramzcw) {}
  
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
      if (paramBaseResp.errCode != 0) {
        break;
      }
    } while ((ApolloGameInvitation.a(this.a.a) == null) || (ApolloGameInvitation.a(this.a.a) == null) || ((AppInterface)ApolloGameInvitation.a(this.a.a).get() == null));
    VipUtils.a(null, "cmshow", "Apollo", "wechat_invite_sent", 0, 0, new String[] { Integer.toString(ApolloGameInvitation.a(this.a.a).e) });
    if (paramBaseResp.errCode == 0) {
      ApolloGameInvitation.a(this.a.a, 0, 2);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (paramBaseResp.errCode == -2) {
        ApolloGameInvitation.a(this.a.a, 2, 2);
      } else {
        ApolloGameInvitation.a(this.a.a, 1, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zcx
 * JD-Core Version:    0.7.0.1
 */