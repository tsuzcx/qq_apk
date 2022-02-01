import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class sgs
{
  public static void a(Context paramContext, int paramInt, sgs.b paramb)
  {
    ausj localausj = ausj.b(paramContext);
    localausj.setMainTitle(String.format(paramContext.getString(2131720651), new Object[] { Integer.valueOf(paramInt) }));
    localausj.addButton(2131720650);
    localausj.addCancelButton(2131721058);
    localausj.a(new sgw(paramb, localausj));
    localausj.a(new sgx(paramb, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, sgs.b paramb, sgs.a parama)
  {
    a(paramContext, null, paramStFeed, paramb, parama);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, sgs.b paramb, sgs.a parama)
  {
    ausj localausj = ausj.b(paramContext);
    localausj.setMainTitle(paramContext.getString(2131720652));
    localausj.addButton(2131720653, 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new sgt(localausj, parama));
    localausj.a(new sgu(paramStUser, paramStFeed, paramb, parama, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, sgs.b paramb, sgs.a parama)
  {
    a(paramContext, paramStUser, null, paramb, parama);
  }
  
  public static abstract interface a
  {
    public abstract void ut(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgs
 * JD-Core Version:    0.7.0.1
 */