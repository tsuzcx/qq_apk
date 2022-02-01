import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerModel.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class zqs
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetRecommendUserListRsp>
{
  zqs(zqr paramzqr) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    if (paramBoolean)
    {
      ykq.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList success");
      if (paramStGetRecommendUserListRsp != null)
      {
        paramVSBaseRequest = new ArrayList();
        if (paramStGetRecommendUserListRsp.vecUser.get() != null)
        {
          paramString = paramStGetRecommendUserListRsp.vecUser.get().iterator();
          while (paramString.hasNext()) {
            paramVSBaseRequest.add(new zse((CertifiedAccountMeta.StUser)paramString.next()));
          }
        }
        zqr.a(this.a, (COMM.StCommonExt)paramStGetRecommendUserListRsp.extInfo.get());
        if (paramStGetRecommendUserListRsp.isFinish.get() != 1) {
          break label158;
        }
      }
      label158:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ThreadManager.getUIHandler().post(new FollowedRecommendBannerModel.1.1(this, paramVSBaseRequest, paramBoolean));
        aanb.a("subscribe_personal_detail_page_request", aanb.a(0L, System.currentTimeMillis() - zqr.a(this.a)));
        return;
      }
    }
    ykq.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList error");
    aanb.a("subscribe_personal_detail_page_request", aanb.a(paramLong, System.currentTimeMillis() - zqr.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqs
 * JD-Core Version:    0.7.0.1
 */