import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class vnj
{
  public static void bv(Activity paramActivity)
  {
    bw(paramActivity);
  }
  
  private static void bw(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("last_key_words", "");
    localIntent.putExtra("from_key", 2);
    localIntent.putExtra(ClassificationSearchActivity.aZc, ClassificationSearchActivity.caf);
    localIntent.setClass(paramActivity, ClassificationSearchActivity.class);
    ClassificationSearchActivity.a(paramActivity, localIntent, null);
  }
  
  public static void d(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountBrowser.class);
    if (TextUtils.isEmpty(paramString2)) {
      if ((paramActivity instanceof BaseActivity)) {
        localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramActivity).getAppRuntime()).getCurrentAccountUin());
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        localIntent.putExtra("leftViewText", paramString1);
        localIntent.putExtra("assignBackText", paramString1);
      }
      if (arap.sPluginNameSpaceHashMap.containsKey("PublicAccountJs")) {
        localIntent.putExtra("insertPluginsArray", new String[] { "PublicAccountJs" });
      }
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = "https://dyzx.mp.qq.com/static/v8/page/subscribeindex.html?_wv=67109947&_bid=2278&_wwv=1";
      }
      localIntent.putExtra("fromLocalUrl", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("hideRightButton", true);
      paramActivity.startActivity(localIntent);
      return;
      localIntent.putExtra("uin", paramString2);
    }
  }
  
  public static void x(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountBrowser.class);
    if ((paramActivity instanceof BaseActivity)) {
      localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramActivity).getAppRuntime()).getCurrentAccountUin());
    }
    if (arap.sPluginNameSpaceHashMap.containsKey("PublicAccountJs")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "PublicAccountJs" });
    }
    localIntent.putExtra("fromLocalUrl", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hideRightButton", true);
    localIntent.putExtra("leftViewText", paramActivity.getString(2131697387));
    localIntent.putExtra("assignBackText", paramActivity.getString(2131697387));
    if (TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("url", obt.Yc);
    }
    for (;;)
    {
      paramActivity.startActivity(localIntent);
      return;
      localIntent.putExtra("url", "https://find.mp.qq.com/search/index?_wv=67109947&keyword=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnj
 * JD-Core Version:    0.7.0.1
 */