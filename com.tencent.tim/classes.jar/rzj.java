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

public class rzj
  implements rxc.a<CertifiedAccountRead.StGetRecommendUserListRsp>
{
  rzj(rzi paramrzi) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    if (paramBoolean)
    {
      ram.i("FollowedRecommendBanner", "sendRequest GetRecommendUserList success");
      if (paramStGetRecommendUserListRsp != null)
      {
        paramString = new ArrayList();
        if (paramStGetRecommendUserListRsp.vecUser.get() != null)
        {
          Iterator localIterator = paramStGetRecommendUserListRsp.vecUser.get().iterator();
          while (localIterator.hasNext()) {
            paramString.add(new sam((CertifiedAccountMeta.StUser)localIterator.next()));
          }
        }
        rzi.a(this.a, (COMM.StCommonExt)paramStGetRecommendUserListRsp.extInfo.get());
        if (paramStGetRecommendUserListRsp.isFinish.get() != 1) {
          break label161;
        }
      }
      label161:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ThreadManager.getUIHandler().post(new FollowedRecommendBannerModel.1.1(this, paramString, paramBoolean));
        sqn.n("subscribe_personal_detail_page_request", sqn.i(0L, System.currentTimeMillis() - rzi.a(this.a)));
        return;
      }
    }
    ram.i("FollowedRecommendBanner", "sendRequest GetRecommendUserList error");
    sqn.n("subscribe_personal_detail_page_request", sqn.i(paramLong, System.currentTimeMillis() - rzi.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzj
 * JD-Core Version:    0.7.0.1
 */