import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class wqo
  implements xgx<CertifiedAccountRead.StGetMainPageRsp>
{
  wqo(wqn paramwqn, wlj paramwlj) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    boolean bool = true;
    List localList;
    COMM.StCommonExt localStCommonExt;
    if ((paramBoolean) && (paramStGetMainPageRsp != null))
    {
      paramString = this.jdField_a_of_type_Wlj;
      localList = paramStGetMainPageRsp.vecFeed.get();
      localStCommonExt = paramStGetMainPageRsp.extInfo;
      if (paramStGetMainPageRsp.isFinish.get() != 1) {
        break label61;
      }
    }
    label61:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.b(localList, localStCommonExt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqo
 * JD-Core Version:    0.7.0.1
 */