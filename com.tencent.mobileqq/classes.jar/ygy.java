import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class ygy
{
  public static void a(Context paramContext, int paramInt, yhf paramyhf)
  {
    bhpy localbhpy = bhpy.a(paramContext);
    localbhpy.a(String.format(paramContext.getString(2131720492), new Object[] { Integer.valueOf(paramInt) }));
    localbhpy.b(2131720491);
    localbhpy.c(2131690648);
    localbhpy.a(new yhc(paramyhf, localbhpy));
    localbhpy.a(new yhd(paramyhf, localbhpy));
    if (!localbhpy.isShowing()) {
      localbhpy.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, yhf paramyhf, yhe paramyhe)
  {
    a(paramContext, null, paramStFeed, paramyhf, paramyhe);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, yhf paramyhf, yhe paramyhe)
  {
    bhpy localbhpy = bhpy.a(paramContext);
    localbhpy.a(paramContext.getString(2131720493));
    localbhpy.a(2131720494, 3);
    localbhpy.c(2131690648);
    localbhpy.a(new ygz(localbhpy, paramyhe));
    localbhpy.a(new yha(paramStUser, paramStFeed, paramyhf, paramyhe, localbhpy));
    if (!localbhpy.isShowing()) {
      localbhpy.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, yhf paramyhf, yhe paramyhe)
  {
    a(paramContext, paramStUser, null, paramyhf, paramyhe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygy
 * JD-Core Version:    0.7.0.1
 */