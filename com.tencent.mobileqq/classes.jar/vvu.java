import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import com.tencent.qphone.base.util.QLog;

final class vvu
  implements wxx<CertifiedAccountRead.StGetMainPageRsp>
{
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramStGetMainPageRsp != null) {
        vvt.a((CertifiedAccountMeta.StUser)paramStGetMainPageRsp.user.get());
      }
    }
    else {
      return;
    }
    QLog.w(vvt.class.getSimpleName(), 1, "getPuinUser empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vvu
 * JD-Core Version:    0.7.0.1
 */