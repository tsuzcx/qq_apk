import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class wsj
{
  public static void a(Context paramContext, int paramInt, wsq paramwsq)
  {
    bfol localbfol = bfol.a(paramContext);
    localbfol.a(String.format(paramContext.getString(2131719946), new Object[] { Integer.valueOf(paramInt) }));
    localbfol.b(2131719945);
    localbfol.c(2131690596);
    localbfol.a(new wsn(paramwsq, localbfol));
    localbfol.a(new wso(paramwsq, localbfol));
    if (!localbfol.isShowing()) {
      localbfol.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, wsq paramwsq, wsp paramwsp)
  {
    a(paramContext, null, paramStFeed, paramwsq, paramwsp);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, wsq paramwsq, wsp paramwsp)
  {
    bfol localbfol = bfol.a(paramContext);
    localbfol.a(paramContext.getString(2131719947));
    localbfol.a(2131719948, 3);
    localbfol.c(2131690596);
    localbfol.a(new wsk(localbfol, paramwsp));
    localbfol.a(new wsl(paramStUser, paramStFeed, paramwsq, paramwsp, localbfol));
    if (!localbfol.isShowing()) {
      localbfol.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, wsq paramwsq, wsp paramwsp)
  {
    a(paramContext, paramStUser, null, paramwsq, paramwsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsj
 * JD-Core Version:    0.7.0.1
 */