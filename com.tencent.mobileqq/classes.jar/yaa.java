import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class yaa
  implements yvn<CertifiedAccountRead.StGetFeedListRsp>
{
  yaa(xzz paramxzz, yeb paramyeb) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramBoolean) && (paramLong == 0L))
    {
      if ((!this.jdField_a_of_type_Yeb.c()) && (!this.jdField_a_of_type_Yeb.d())) {
        break label122;
      }
      paramString = this.jdField_a_of_type_Xzz;
      localList = paramStGetFeedListRsp.vecFeed.get();
      localStCommonExt = paramStGetFeedListRsp.extInfo;
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label117;
      }
      paramBoolean = bool1;
      paramString.a(localList, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
      this.jdField_a_of_type_Xzz.b("share_key_continue_feeds", new ydw(paramStGetFeedListRsp.vecFeed.get()));
    }
    label117:
    label122:
    while (!this.jdField_a_of_type_Yeb.e()) {
      for (;;)
      {
        return;
        paramBoolean = false;
      }
    }
    paramString = this.jdField_a_of_type_Xzz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yaa
 * JD-Core Version:    0.7.0.1
 */