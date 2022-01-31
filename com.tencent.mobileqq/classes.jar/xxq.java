import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerModel.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class xxq
  implements yvn<CertifiedAccountRead.StGetRecommendUserListRsp>
{
  xxq(xxp paramxxp) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    if (paramBoolean)
    {
      wsv.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList success");
      if (paramStGetRecommendUserListRsp != null)
      {
        paramString = new ArrayList();
        if (paramStGetRecommendUserListRsp.vecUser.get() != null)
        {
          Iterator localIterator = paramStGetRecommendUserListRsp.vecUser.get().iterator();
          while (localIterator.hasNext()) {
            paramString.add(new xze((CertifiedAccountMeta.StUser)localIterator.next()));
          }
        }
        xxp.a(this.a, (COMM.StCommonExt)paramStGetRecommendUserListRsp.extInfo.get());
        if (paramStGetRecommendUserListRsp.isFinish.get() != 1) {
          break label161;
        }
      }
      label161:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ThreadManager.getUIHandler().post(new FollowedRecommendBannerModel.1.1(this, paramString, paramBoolean));
        yvu.a("subscribe_personal_detail_page_request", yvu.a(0L, System.currentTimeMillis() - xxp.a(this.a)));
        return;
      }
    }
    wsv.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList error");
    yvu.a("subscribe_personal_detail_page_request", yvu.a(paramLong, System.currentTimeMillis() - xxp.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xxq
 * JD-Core Version:    0.7.0.1
 */