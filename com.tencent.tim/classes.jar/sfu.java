import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;

class sfu
  implements rxc.a<CertifiedAccountRead.StGetFeedDetailRsp>
{
  sfu(sft paramsft, ryt paramryt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    if (this.jdField_a_of_type_Ryt != null) {
      this.jdField_a_of_type_Ryt.u(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetFeedDetailRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfu
 * JD-Core Version:    0.7.0.1
 */