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

public class zbn
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetRecommendUserListRsp>
{
  zbn(zbm paramzbm) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    if (paramBoolean)
    {
      xvv.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList success");
      if (paramStGetRecommendUserListRsp != null)
      {
        paramVSBaseRequest = new ArrayList();
        if (paramStGetRecommendUserListRsp.vecUser.get() != null)
        {
          paramString = paramStGetRecommendUserListRsp.vecUser.get().iterator();
          while (paramString.hasNext()) {
            paramVSBaseRequest.add(new zcz((CertifiedAccountMeta.StUser)paramString.next()));
          }
        }
        zbm.a(this.a, (COMM.StCommonExt)paramStGetRecommendUserListRsp.extInfo.get());
        if (paramStGetRecommendUserListRsp.isFinish.get() != 1) {
          break label158;
        }
      }
      label158:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ThreadManager.getUIHandler().post(new FollowedRecommendBannerModel.1.1(this, paramVSBaseRequest, paramBoolean));
        zxp.a("subscribe_personal_detail_page_request", zxp.a(0L, System.currentTimeMillis() - zbm.a(this.a)));
        return;
      }
    }
    xvv.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList error");
    zxp.a("subscribe_personal_detail_page_request", zxp.a(paramLong, System.currentTimeMillis() - zbm.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbn
 * JD-Core Version:    0.7.0.1
 */