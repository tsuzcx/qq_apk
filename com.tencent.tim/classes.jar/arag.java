import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import cooperation.comic.ui.QQComicFragment;
import cooperation.qqreader.ui.ReaderCommentPageFragment;
import cooperation.qqreader.ui.ReaderContentPageFragment;
import cooperation.qqreader.ui.ReaderHomeTabFragment;
import cooperation.qzone.QzoneTranslucentBrowserFragment;

public class arag
{
  public static WebViewFragment a(aqzs paramaqzs, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    paramIntent.putExtra("url", paramWebViewTabBarData.url);
    int i = paramIntent.getIntExtra("fragmentStyle", 0);
    if (i == 2) {
      return QzoneTranslucentBrowserFragment.a(paramIntent);
    }
    if (i == 1) {
      return QQComicFragment.b(paramIntent);
    }
    if (i == 3)
    {
      if (paramWebViewTabBarData.url.contains("signatureEdit=1")) {
        return SignatureEditFragment.a(paramIntent);
      }
      paramIntent.removeExtra("isTransparentTitle");
      if (paramaqzs != null) {
        return paramaqzs.a(paramIntent);
      }
      return WebViewFragment.b(paramIntent);
    }
    if (i == 4)
    {
      i = paramIntent.getIntExtra("item_type", 1);
      if ((i == 1) && (TextUtils.isDigitsOnly(paramWebViewTabBarData.tag)))
      {
        paramIntent.putExtra("key_tab_id", Integer.valueOf(paramWebViewTabBarData.tag));
        avoc.i("WebViewFragmentBuilder", "tab_id =" + paramWebViewTabBarData.tag);
        return ReaderHomeTabFragment.b(paramIntent);
      }
      if (i == 4) {
        return ReaderCommentPageFragment.b(paramIntent);
      }
      return ReaderContentPageFragment.b(paramIntent);
    }
    paramWebViewTabBarData = Uri.parse(paramWebViewTabBarData.url);
    if ((paramWebViewTabBarData.isHierarchical()) && ("4".equals(paramWebViewTabBarData.getQueryParameter("_webviewtype"))))
    {
      paramIntent.putExtra("fragmentStyle", 1);
      paramIntent.putExtra("tabBarStyle", 1);
      paramIntent.putExtra("titleBarStyle", 1);
      paramIntent.putExtra("hide_operation_bar", true);
      paramIntent.putExtra("hide_more_button", true);
      paramIntent.putExtra("isScreenOrientationPortrait", true);
      return QQComicFragment.b(paramIntent);
    }
    if (paramaqzs != null) {
      return paramaqzs.a(paramIntent);
    }
    return WebViewFragment.b(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arag
 * JD-Core Version:    0.7.0.1
 */