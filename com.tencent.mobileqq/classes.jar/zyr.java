import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class zyr
{
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, zyw paramzyw, zyv paramzyv)
  {
    a(paramContext, null, paramStFeed, paramzyw, paramzyv);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, zyw paramzyw, zyv paramzyv)
  {
    bkzi localbkzi = bkzi.a(paramContext);
    localbkzi.a(paramContext.getString(2131719123));
    localbkzi.a(2131719124, 3);
    localbkzi.c(2131690697);
    localbkzi.a(new zys(localbkzi, paramzyv));
    localbkzi.a(new zyt(paramStUser, paramStFeed, paramzyw, paramzyv, localbkzi));
    if (!localbkzi.isShowing()) {
      localbkzi.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, zyw paramzyw, zyv paramzyv)
  {
    a(paramContext, paramStUser, null, paramzyw, paramzyv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyr
 * JD-Core Version:    0.7.0.1
 */