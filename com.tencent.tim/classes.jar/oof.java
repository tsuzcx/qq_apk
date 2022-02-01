import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class oof
{
  public static Intent a(String paramString1, String paramString2)
  {
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.setPackage(paramString2);
    }
    paramString1.setFlags(536870912);
    paramString1.putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
    return paramString1;
  }
  
  public static void aY(Activity paramActivity)
  {
    String str1 = ohy.a().lp();
    String str2 = ohy.a().lo();
    ooz.e("AppMarketUtils", "goAppMarket :\npackageName = " + str2 + "\nurl = " + str1);
    try
    {
      paramActivity.startActivity(a(str1, str2));
      return;
    }
    catch (Exception paramActivity)
    {
      ooz.e("AppMarketUtils", "goAppMarket error messaage = " + paramActivity.getMessage());
    }
  }
  
  public static boolean n(Activity paramActivity)
  {
    if (paramActivity == null) {
      ooz.e("AppMarketUtils", "tryGoAppMarket:activity = null");
    }
    do
    {
      return false;
      paramActivity = ohy.a().lp();
      String str = ohy.a().lo();
      ooz.w("AppMarketUtils", "goAppMarket:\nappStorePackageName = " + str + "\nappStoreVendorId =" + ohy.a().rs() + "\nappStoreScheme =" + paramActivity);
    } while ((TextUtils.isEmpty(paramActivity)) || (paramActivity.startsWith("http")));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oof
 * JD-Core Version:    0.7.0.1
 */