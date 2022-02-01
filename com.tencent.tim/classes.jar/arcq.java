import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

final class arcq
  implements ValueCallback<String>
{
  arcq(WebViewFragment paramWebViewFragment) {}
  
  public void onReceiveValue(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftWebViewUtils", 2, "evaluateJavascript: " + paramString);
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {}
    for (String str = paramString.trim();; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        paramString = str;
        if (str.startsWith("\"")) {
          paramString = str.replaceFirst("\"", "");
        }
        str = paramString;
        if (paramString.endsWith("\"")) {
          str = paramString.substring(0, paramString.length() - 1);
        }
        localBundle.putString("banner_wording", String.format(acfp.m(2131715094), new Object[] { str }));
      }
      this.d.dA(localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcq
 * JD-Core Version:    0.7.0.1
 */