import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.text.TextUtils;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

public class yfg
  implements yvn<CertifiedAccountRead.StGetMainPageRsp>
{
  public yfg(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    SubscribePersonalDetailFragment.a(this.a, paramBoolean);
    if (paramBoolean)
    {
      if (paramStGetMainPageRsp != null)
      {
        wsv.c("SubscribePersonalDetail", "sendRequest GetMainPage success");
        SubscribePersonalDetailFragment.a(this.a, paramStGetMainPageRsp);
        if ((this.a.a != null) && (SubscribePersonalDetailFragment.a(this.a).user != null)) {
          this.a.a.poster.set(SubscribePersonalDetailFragment.a(this.a).user.get());
        }
        xxf.a(paramStGetMainPageRsp);
        SubscribePersonalDetailFragment.a(this.a, paramString);
        SubscribePersonalDetailFragment.a(this.a);
        SubscribePersonalDetailFragment.a(this.a).d(true);
        if (paramStGetMainPageRsp.user.type.get() == 0) {
          yvu.b(paramStGetMainPageRsp.user.id.get(), "auth_person", "user_exp", 0, 0, new String[0]);
        }
      }
      yvu.a("subscribe_personal_detail_page_request", yvu.a(0L, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.a)));
      return;
    }
    wsv.c("SubscribePersonalDetail", "sendRequest GetMainPage error");
    paramStGetMainPageRsp = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      paramStGetMainPageRsp = alpo.a(2131715026);
    }
    if (this.a.getActivity() != null) {
      QQToast.a(this.a.getActivity(), paramStGetMainPageRsp, 0).a();
    }
    yvu.a("subscribe_personal_detail_page_request", yvu.a(paramLong, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfg
 * JD-Core Version:    0.7.0.1
 */