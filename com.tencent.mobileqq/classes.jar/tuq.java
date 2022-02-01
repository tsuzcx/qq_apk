import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.JSAPIAdapter.1;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.IJSApiAdapter;
import com.tencent.viola.adapter.IJSApiAdapter.OnInovkeCallback;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import org.json.JSONException;
import org.json.JSONObject;

public class tuq
  implements IJSApiAdapter
{
  private JSONObject a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fail", "exception");
      localJSONObject.put("msg", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("JSAPIAdapter", 2, "exceptionCall JSONException" + paramString.getMessage());
    }
    return localJSONObject;
  }
  
  private static void b(Context paramContext, String paramString, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramString == null)) {
      return;
    }
    if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramString.startsWith("https://")))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("url", paramString);
        localBundle.putBoolean("hide_operation_bar", true);
        paramString = new Intent(paramContext, QQBrowserActivity.class);
        paramString.setFlags(268435456);
        paramString.putExtras(localBundle);
        if (paramBundle != null) {
          paramString.putExtras(paramBundle);
        }
        paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        paramContext.startActivity(paramString);
        return;
      }
      paramBundle = new Intent(paramContext, JumpActivity.class);
      paramBundle.setFlags(268435456);
      paramString = Uri.parse(paramString);
      paramBundle.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramBundle.setData(paramString);
      paramContext.startActivity(paramBundle);
      return;
    }
  }
  
  public void invoke(String paramString, JSONObject paramJSONObject, IJSApiAdapter.OnInovkeCallback paramOnInovkeCallback, ViolaInstance paramViolaInstance)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        if ("openUrl".equals(paramString))
        {
          paramString = new JSAPIAdapter.1(this, paramJSONObject);
          ViolaSDKManager.getInstance().postOnUiThread(paramString, 0L);
          return;
        }
        if ("getCache".equals(paramString))
        {
          try
          {
            if ((!paramJSONObject.has("url")) || (!paramJSONObject.has("key")) || (!paramJSONObject.has("host")) || (!paramJSONObject.has("path"))) {
              continue;
            }
            paramJSONObject.put("callid", 0);
            sfq.a().a(paramJSONObject.getString("url"), paramJSONObject.toString(), new tur(paramOnInovkeCallback));
            return;
          }
          catch (JSONException paramString)
          {
            paramOnInovkeCallback.callback(a(paramString.getMessage()));
          }
          if (QLog.isColorLevel()) {
            QLog.e("JSAPIAdapter", 2, "METHOD_GET_CACHE JSONException" + paramString.getMessage());
          }
        }
        else if ("writeCache".equals(paramString))
        {
          try
          {
            if ((paramJSONObject.has("url")) && (paramJSONObject.has("key")) && (paramJSONObject.has("host")) && (paramJSONObject.has("path")) && (paramJSONObject.has("data")))
            {
              paramJSONObject.put("callid", 0);
              sfq.a().a(paramJSONObject.getString("url"), paramJSONObject.toString(), null, paramJSONObject);
              return;
            }
          }
          catch (JSONException paramString)
          {
            paramOnInovkeCallback.callback(a(paramString.getMessage()));
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("JSAPIAdapter", 2, "METHOD_WRITE_CACHE fail" + paramString.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tuq
 * JD-Core Version:    0.7.0.1
 */