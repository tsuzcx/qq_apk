import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class wsg
{
  public static void a(Context paramContext, int paramInt, wsn paramwsn)
  {
    bfpc localbfpc = bfpc.a(paramContext);
    localbfpc.a(String.format(paramContext.getString(2131719957), new Object[] { Integer.valueOf(paramInt) }));
    localbfpc.b(2131719956);
    localbfpc.c(2131690596);
    localbfpc.a(new wsk(paramwsn, localbfpc));
    localbfpc.a(new wsl(paramwsn, localbfpc));
    if (!localbfpc.isShowing()) {
      localbfpc.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, wsn paramwsn, wsm paramwsm)
  {
    a(paramContext, null, paramStFeed, paramwsn, paramwsm);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, wsn paramwsn, wsm paramwsm)
  {
    bfpc localbfpc = bfpc.a(paramContext);
    localbfpc.a(paramContext.getString(2131719958));
    localbfpc.a(2131719959, 3);
    localbfpc.c(2131690596);
    localbfpc.a(new wsh(localbfpc, paramwsm));
    localbfpc.a(new wsi(paramStUser, paramStFeed, paramwsn, paramwsm, localbfpc));
    if (!localbfpc.isShowing()) {
      localbfpc.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, wsn paramwsn, wsm paramwsm)
  {
    a(paramContext, paramStUser, null, paramwsn, paramwsm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsg
 * JD-Core Version:    0.7.0.1
 */