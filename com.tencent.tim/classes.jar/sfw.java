import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;

class sfw
  implements rxc.a<CertifiedAccountRead.StGetMainPageRsp>
{
  sfw(sfv paramsfv, ryt paramryt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (this.jdField_a_of_type_Ryt != null) {
      this.jdField_a_of_type_Ryt.u(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetMainPageRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfw
 * JD-Core Version:    0.7.0.1
 */