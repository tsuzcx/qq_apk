import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class uxa
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
  
  public static void a(Activity paramActivity)
  {
    String str1 = umu.a().b();
    String str2 = umu.a().a();
    uya.d("AppMarketUtils", "goAppMarket :\npackageName = " + str2 + "\nurl = " + str1);
    try
    {
      paramActivity.startActivity(a(str1, str2));
      return;
    }
    catch (Exception paramActivity)
    {
      uya.d("AppMarketUtils", "goAppMarket error messaage = " + paramActivity.getMessage());
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (paramActivity == null) {
      uya.d("AppMarketUtils", "tryGoAppMarket:activity = null");
    }
    do
    {
      return false;
      paramActivity = umu.a().b();
      String str = umu.a().a();
      uya.c("AppMarketUtils", "goAppMarket:\nappStorePackageName = " + str + "\nappStoreVendorId =" + umu.a().b() + "\nappStoreScheme =" + paramActivity);
    } while ((TextUtils.isEmpty(paramActivity)) || (paramActivity.startsWith("http")));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxa
 * JD-Core Version:    0.7.0.1
 */