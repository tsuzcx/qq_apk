import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class sbg
  implements rxc.a<CertifiedAccountRead.StGetFeedListRsp>
{
  sbg(sbf paramsbf, rxt paramrxt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramBoolean) && (paramLong == 0L))
    {
      if ((!this.a.Mg()) && (!this.a.Mh())) {
        break label122;
      }
      paramString = this.c;
      localList = paramStGetFeedListRsp.vecFeed.get();
      localStCommonExt = paramStGetFeedListRsp.extInfo;
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label117;
      }
      paramBoolean = bool1;
      paramString.a(localList, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
      this.c.setShareData("share_key_continue_feeds", new rxn.b(paramStGetFeedListRsp.vecFeed.get()));
    }
    label117:
    label122:
    while (!this.a.Mi()) {
      for (;;)
      {
        return;
        paramBoolean = false;
      }
    }
    paramString = this.c;
    List localList = paramStGetFeedListRsp.vecFeed.get();
    COMM.StCommonExt localStCommonExt = paramStGetFeedListRsp.extInfo;
    if (paramStGetFeedListRsp.isFinish.get() == 1) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramString.b(localList, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbg
 * JD-Core Version:    0.7.0.1
 */