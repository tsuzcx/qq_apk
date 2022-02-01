import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

public class zxp
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetMainPageRsp>
{
  public zxp(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    SubscribePersonalDetailFragment.a(this.a, paramBoolean);
    if (paramBoolean)
    {
      if (paramStGetMainPageRsp != null)
      {
        ykq.c("SubscribePersonalDetail", "sendRequest GetMainPage success");
        SubscribePersonalDetailFragment.a(this.a, paramStGetMainPageRsp);
        if ((this.a.a != null) && (SubscribePersonalDetailFragment.a(this.a).user != null)) {
          this.a.a.poster.set(SubscribePersonalDetailFragment.a(this.a).user.get());
        }
        zqh.a(paramStGetMainPageRsp);
        SubscribePersonalDetailFragment.a(this.a, paramString);
        SubscribePersonalDetailFragment.a(this.a);
        SubscribePersonalDetailFragment.a(this.a).a(true);
        if (paramStGetMainPageRsp.user.type.get() == 0) {
          aanb.b(paramStGetMainPageRsp.user.id.get(), "auth_person", "user_exp", 0, 0, new String[0]);
        }
      }
      aanb.a("subscribe_personal_detail_page_request", aanb.a(0L, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.a)));
      return;
    }
    ykq.c("SubscribePersonalDetail", "sendRequest GetMainPage error");
    paramVSBaseRequest = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      paramVSBaseRequest = anvx.a(2131714027);
    }
    if (this.a.getActivity() != null) {
      QQToast.a(this.a.getActivity(), paramVSBaseRequest, 0).a();
    }
    aanb.a("subscribe_personal_detail_page_request", aanb.a(paramLong, System.currentTimeMillis() - SubscribePersonalDetailFragment.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxp
 * JD-Core Version:    0.7.0.1
 */