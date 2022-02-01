import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.text.TextUtils;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

public class seu
  implements rxc.a<CertifiedAccountRead.StGetMainPageRsp>
{
  public seu(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    SubscribePersonalDetailFragment.a(this.this$0, paramBoolean);
    if (paramBoolean)
    {
      if (paramStGetMainPageRsp != null)
      {
        ram.i("SubscribePersonalDetail", "sendRequest GetMainPage success");
        SubscribePersonalDetailFragment.a(this.this$0, paramStGetMainPageRsp);
        if ((this.this$0.a != null) && (SubscribePersonalDetailFragment.a(this.this$0).user != null)) {
          this.this$0.a.poster.set(SubscribePersonalDetailFragment.a(this.this$0).user.get());
        }
        ryz.c(paramStGetMainPageRsp);
        SubscribePersonalDetailFragment.a(this.this$0, paramString);
        SubscribePersonalDetailFragment.a(this.this$0);
        SubscribePersonalDetailFragment.a(this.this$0).notifyLoadingComplete(true);
        if (paramStGetMainPageRsp.user.type.get() == 0) {
          sqn.c(paramStGetMainPageRsp.user.id.get(), "auth_person", "user_exp", 0, 0, new String[0]);
        }
      }
      sqn.n("subscribe_personal_detail_page_request", sqn.i(0L, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.this$0)));
      return;
    }
    ram.i("SubscribePersonalDetail", "sendRequest GetMainPage error");
    paramStGetMainPageRsp = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      paramStGetMainPageRsp = acfp.m(2131715064);
    }
    if (this.this$0.getActivity() != null) {
      QQToast.a(this.this$0.getActivity(), paramStGetMainPageRsp, 0).show();
    }
    sqn.n("subscribe_personal_detail_page_request", sqn.i(paramLong, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     seu
 * JD-Core Version:    0.7.0.1
 */