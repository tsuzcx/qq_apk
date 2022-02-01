import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public final class qev
{
  public static boolean I(Context paramContext, String paramString)
  {
    boolean bool = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = null;
    try
    {
      paramString = localPackageManager.getPackageInfo(paramString, 0);
      paramContext = paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    if (paramContext != null) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, rmw.a parama)
  {
    if (parama == null) {
      return false;
    }
    return d(paramContext, String.valueOf(parama.id), String.valueOf(parama.type));
  }
  
  public static void ba(Context paramContext, String paramString)
  {
    if (I(paramContext, paramString))
    {
      bb(paramContext, paramString);
      return;
    }
    cB(paramContext);
  }
  
  public static void bb(Context paramContext, String paramString)
  {
    paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    if (paramString != null) {
      paramContext.startActivity(paramString);
    }
  }
  
  public static void cB(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/qim/transfer.html?_wv=16777219");
    paramContext.startActivity(localIntent);
  }
  
  public static boolean d(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("%s?tag_id=%s&tag_type=%s&_wv=3&_nav_alpha=0&_bid=2910", new Object[] { "https://story.now.qq.com/mobile/tag/index.html", String.valueOf(paramString1), String.valueOf(paramString2) }));
    paramContext.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qev
 * JD-Core Version:    0.7.0.1
 */