import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;

class wmp
  implements wre<Object>
{
  wmp(wmn paramwmn, xgu paramxgu) {}
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4)) {
      this.jdField_a_of_type_Xgu.a(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (CertifiedAccountRead.StGetFeedDetailRsp)paramVarArgs[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wmp
 * JD-Core Version:    0.7.0.1
 */