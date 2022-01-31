import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class yll
{
  public static void a(Context paramContext, int paramInt, yls paramyls)
  {
    bhuf localbhuf = bhuf.a(paramContext);
    localbhuf.a(String.format(paramContext.getString(2131720504), new Object[] { Integer.valueOf(paramInt) }));
    localbhuf.b(2131720503);
    localbhuf.c(2131690648);
    localbhuf.a(new ylp(paramyls, localbhuf));
    localbhuf.a(new ylq(paramyls, localbhuf));
    if (!localbhuf.isShowing()) {
      localbhuf.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, yls paramyls, ylr paramylr)
  {
    a(paramContext, null, paramStFeed, paramyls, paramylr);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, yls paramyls, ylr paramylr)
  {
    bhuf localbhuf = bhuf.a(paramContext);
    localbhuf.a(paramContext.getString(2131720505));
    localbhuf.a(2131720506, 3);
    localbhuf.c(2131690648);
    localbhuf.a(new ylm(localbhuf, paramylr));
    localbhuf.a(new yln(paramStUser, paramStFeed, paramyls, paramylr, localbhuf));
    if (!localbhuf.isShowing()) {
      localbhuf.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, yls paramyls, ylr paramylr)
  {
    a(paramContext, paramStUser, null, paramyls, paramylr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yll
 * JD-Core Version:    0.7.0.1
 */