import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_COMM.COMM.StCommonExt;

class wmr
  implements xgx<CertifiedAccountRead.StGetFeedDetailRsp>
{
  wmr(wmq paramwmq, COMM.StCommonExt paramStCommonExt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    wmq.a(this.jdField_a_of_type_Wmq, paramBoolean, paramLong, paramString, paramStGetFeedDetailRsp, this.jdField_a_of_type_NS_COMMCOMM$StCommonExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wmr
 * JD-Core Version:    0.7.0.1
 */