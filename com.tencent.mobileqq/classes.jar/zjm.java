import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class zjm
{
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, zjr paramzjr, zjq paramzjq)
  {
    a(paramContext, null, paramStFeed, paramzjr, paramzjq);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, zjr paramzjr, zjq paramzjq)
  {
    bjnw localbjnw = bjnw.a(paramContext);
    localbjnw.a(paramContext.getString(2131718734));
    localbjnw.a(2131718735, 3);
    localbjnw.c(2131690620);
    localbjnw.a(new zjn(localbjnw, paramzjq));
    localbjnw.a(new zjo(paramStUser, paramStFeed, paramzjr, paramzjq, localbjnw));
    if (!localbjnw.isShowing()) {
      localbjnw.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, zjr paramzjr, zjq paramzjq)
  {
    a(paramContext, paramStUser, null, paramzjr, paramzjq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjm
 * JD-Core Version:    0.7.0.1
 */