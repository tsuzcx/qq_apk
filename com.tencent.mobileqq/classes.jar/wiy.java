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

public class wiy
  implements xgu<CertifiedAccountRead.StGetRecommendUserListRsp>
{
  wiy(wix paramwix) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    if (paramBoolean)
    {
      ved.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList success");
      if (paramStGetRecommendUserListRsp != null)
      {
        paramString = new ArrayList();
        if (paramStGetRecommendUserListRsp.vecUser.get() != null)
        {
          Iterator localIterator = paramStGetRecommendUserListRsp.vecUser.get().iterator();
          while (localIterator.hasNext()) {
            paramString.add(new wkl((CertifiedAccountMeta.StUser)localIterator.next()));
          }
        }
        wix.a(this.a, (COMM.StCommonExt)paramStGetRecommendUserListRsp.extInfo.get());
        if (paramStGetRecommendUserListRsp.isFinish.get() != 1) {
          break label161;
        }
      }
      label161:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ThreadManager.getUIHandler().post(new FollowedRecommendBannerModel.1.1(this, paramString, paramBoolean));
        xhb.a("subscribe_personal_detail_page_request", xhb.a(0L, System.currentTimeMillis() - wix.a(this.a)));
        return;
      }
    }
    ved.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList error");
    xhb.a("subscribe_personal_detail_page_request", xhb.a(paramLong, System.currentTimeMillis() - wix.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wiy
 * JD-Core Version:    0.7.0.1
 */