import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class wdu
{
  public static void a(Context paramContext, int paramInt, web paramweb)
  {
    begr localbegr = begr.a(paramContext);
    localbegr.a(String.format(paramContext.getString(2131654058), new Object[] { Integer.valueOf(paramInt) }));
    localbegr.b(2131654057);
    localbegr.c(2131625035);
    localbegr.a(new wdy(paramweb, localbegr));
    localbegr.a(new wdz(paramweb, localbegr));
    if (!localbegr.isShowing()) {
      localbegr.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, web paramweb, wea paramwea)
  {
    a(paramContext, null, paramStFeed, paramweb, paramwea);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, web paramweb, wea paramwea)
  {
    begr localbegr = begr.a(paramContext);
    localbegr.a(paramContext.getString(2131654059));
    localbegr.a(2131654060, 3);
    localbegr.c(2131625035);
    localbegr.a(new wdv(localbegr, paramwea));
    localbegr.a(new wdw(paramStUser, paramStFeed, paramweb, paramwea, localbegr));
    if (!localbegr.isShowing()) {
      localbegr.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, web paramweb, wea paramwea)
  {
    a(paramContext, paramStUser, null, paramweb, paramwea);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wdu
 * JD-Core Version:    0.7.0.1
 */