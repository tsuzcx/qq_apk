import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.text.TextUtils;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wdf
  implements wxx<CertifiedAccountRead.StGetMainPageRsp>
{
  public wdf(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    SubscribePersonalDetailFragment.a(this.a, paramBoolean);
    if (paramBoolean)
    {
      if (paramStGetMainPageRsp != null)
      {
        urk.c("SubscribePersonalDetail", "sendRequest GetMainPage success");
        SubscribePersonalDetailFragment.a(this.a, paramStGetMainPageRsp);
        if ((this.a.a != null) && (SubscribePersonalDetailFragment.a(this.a).user != null)) {
          this.a.a.poster.set(SubscribePersonalDetailFragment.a(this.a).user.get());
        }
        vvt.a(SubscribePersonalDetailFragment.a(this.a).user);
        SubscribePersonalDetailFragment.a(this.a, paramString);
        SubscribePersonalDetailFragment.a(this.a);
        SubscribePersonalDetailFragment.a(this.a).d(true);
        if (paramStGetMainPageRsp.user.type.get() == 0) {
          wye.b(paramStGetMainPageRsp.user.id.get(), "auth_person", "user_exp", 0, 0, new String[0]);
        }
      }
      wye.a("subscribe_personal_detail_page_request", wye.a(0L, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.a)));
      return;
    }
    urk.c("SubscribePersonalDetail", "sendRequest GetMainPage error");
    paramStGetMainPageRsp = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      paramStGetMainPageRsp = ajjy.a(2131648854);
    }
    if (this.a.getActivity() != null) {
      bbmy.a(this.a.getActivity(), paramStGetMainPageRsp, 0).a();
    }
    wye.a("subscribe_personal_detail_page_request", wye.a(paramLong, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wdf
 * JD-Core Version:    0.7.0.1
 */