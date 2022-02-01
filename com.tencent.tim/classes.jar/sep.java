import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class sep
  implements rxc.a<CertifiedAccountRead.StGetMainPageRsp>
{
  sep(seo paramseo, sbf paramsbf) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    boolean bool = true;
    List localList;
    COMM.StCommonExt localStCommonExt;
    if ((paramBoolean) && (paramStGetMainPageRsp != null))
    {
      paramString = this.b;
      localList = paramStGetMainPageRsp.vecFeed.get();
      localStCommonExt = paramStGetMainPageRsp.extInfo;
      if (paramStGetMainPageRsp.isFinish.get() != 1) {
        break label61;
      }
    }
    label61:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.c(localList, localStCommonExt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sep
 * JD-Core Version:    0.7.0.1
 */