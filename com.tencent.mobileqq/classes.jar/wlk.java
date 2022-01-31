import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class wlk
  implements xgx<CertifiedAccountRead.StGetFeedListRsp>
{
  wlk(wlj paramwlj, wpn paramwpn) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramBoolean) && (paramLong == 0L))
    {
      if ((!this.jdField_a_of_type_Wpn.c()) && (!this.jdField_a_of_type_Wpn.d())) {
        break label122;
      }
      paramString = this.jdField_a_of_type_Wlj;
      localList = paramStGetFeedListRsp.vecFeed.get();
      localStCommonExt = paramStGetFeedListRsp.extInfo;
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label117;
      }
      paramBoolean = bool1;
      paramString.a(localList, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
      this.jdField_a_of_type_Wlj.b("share_key_continue_feeds", new wpi(paramStGetFeedListRsp.vecFeed.get()));
    }
    label117:
    label122:
    while (!this.jdField_a_of_type_Wpn.e()) {
      for (;;)
      {
        return;
        paramBoolean = false;
      }
    }
    paramString = this.jdField_a_of_type_Wlj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlk
 * JD-Core Version:    0.7.0.1
 */