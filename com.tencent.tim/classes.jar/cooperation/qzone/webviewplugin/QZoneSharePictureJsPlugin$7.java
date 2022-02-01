package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import avpw;
import avqq;
import awey;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONObject;

public class QZoneSharePictureJsPlugin$7
  implements Runnable
{
  public QZoneSharePictureJsPlugin$7(awey paramawey, JSONObject paramJSONObject, String paramString, WebViewPlugin.a parama) {}
  
  public void run()
  {
    String str1 = this.val$jsonObject.optString("base64UBBText");
    if (!TextUtils.isEmpty(str1)) {}
    for (;;)
    {
      try
      {
        str1 = new String(Base64.decode(str1, 2));
        boolean bool = TextUtils.isEmpty(str1);
        if (!bool)
        {
          String str2 = this.val$jsonObject.optString("shareSource");
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(URLDecoder.decode(this.val$filePath));
          Bundle localBundle = new Bundle();
          localBundle.putStringArrayList("images", localArrayList);
          localBundle.putInt("req_type", 1);
          localBundle.putBoolean("key_need_save_draft", false);
          localBundle.putString("shareSource", str2);
          int i = avpw.a(this.this$0.f, this.a, 5);
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("summary", str1);
          }
          avqq.a(this.a.a(), this.a.getActivity(), localBundle, null, i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QZoneSharePictureJsPlugin", 1, "writeMood: parse base64UBBText error:", localThrowable);
      }
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */