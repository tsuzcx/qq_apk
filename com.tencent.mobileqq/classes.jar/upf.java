import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class upf
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
    String str1 = ugd.a().b();
    String str2 = ugd.a().a();
    uqf.d("AppMarketUtils", "goAppMarket :\npackageName = " + str2 + "\nurl = " + str1);
    try
    {
      paramActivity.startActivity(a(str1, str2));
      return;
    }
    catch (Exception paramActivity)
    {
      uqf.d("AppMarketUtils", "goAppMarket error messaage = " + paramActivity.getMessage());
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (paramActivity == null) {
      uqf.d("AppMarketUtils", "tryGoAppMarket:activity = null");
    }
    do
    {
      return false;
      paramActivity = ugd.a().b();
      String str = ugd.a().a();
      uqf.c("AppMarketUtils", "goAppMarket:\nappStorePackageName = " + str + "\nappStoreVendorId =" + ugd.a().b() + "\nappStoreScheme =" + paramActivity);
    } while ((TextUtils.isEmpty(paramActivity)) || (paramActivity.startsWith("http")));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upf
 * JD-Core Version:    0.7.0.1
 */