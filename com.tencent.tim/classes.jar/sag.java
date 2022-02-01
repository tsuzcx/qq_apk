import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Collections;
import mqq.os.MqqHandler;

public class sag
  implements rxc.a<CertifiedAccountRead.StGetRecommendUserListRsp>
{
  sag(saf paramsaf, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    if (paramBoolean)
    {
      ram.i("VSNetworkHelper", "sendRequest GetRecommendUserList success  time ==> " + (System.currentTimeMillis() - this.val$time));
      if (paramStGetRecommendUserListRsp != null)
      {
        paramString = saf.a(this.b, paramStGetRecommendUserListRsp);
        saf.a(this.b, (COMM.StCommonExt)paramStGetRecommendUserListRsp.extInfo.get());
        if (paramStGetRecommendUserListRsp.isFinish.get() != 1) {
          break label110;
        }
      }
      label110:
      for (paramBoolean = true;; paramBoolean = false)
      {
        Collections.shuffle(paramString);
        ThreadManager.getUIHandler().post(new TopPanelPresenter.1.1(this, paramStGetRecommendUserListRsp, paramString, paramBoolean));
        return;
      }
    }
    ram.i(saf.access$300(), "sendRequest GetRecommendUserList error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sag
 * JD-Core Version:    0.7.0.1
 */