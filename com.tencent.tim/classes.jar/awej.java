import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PublishEventTag;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awej
  extends awfr
  implements avzi
{
  public static String PKG_NAME = "Qzone";
  public static String cPv = "addfriends";
  private String callback;
  
  private void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    try
    {
      paramWebViewPlugin = new JSONObject(paramArrayOfString[0]);
      long l = paramWebViewPlugin.getLong("uin");
      int i = paramWebViewPlugin.optInt("sourceId", 3011);
      int j = paramWebViewPlugin.optInt("subSourceId", 21);
      paramWebViewPlugin = parama.getActivity();
      paramWebViewPlugin.startActivity(AddFriendLogicActivity.a(paramWebViewPlugin, 1, String.valueOf(l), "", i, j, null, null, null, null, null));
      return;
    }
    catch (JSONException paramWebViewPlugin)
    {
      paramWebViewPlugin.printStackTrace();
    }
  }
  
  private void aaH(String paramString)
  {
    try
    {
      this.callback = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(this.callback)) {
        avzf.a().a().eCL();
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneEventTagJsPlugin", 1, "getHistoryEventTag error", paramString);
    }
  }
  
  private void aaI(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("list");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = paramString.optJSONObject(0);
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", paramString.optString("uin"));
        localBundle.putString("time", paramString.optString("time"));
        localBundle.putString("title", paramString.optString("title"));
        localBundle.putString("picUrl", paramString.optString("picUrl"));
        localBundle.putString("id", paramString.optString("id"));
        avzf.a().a().el(localBundle);
        return;
      }
      avzf.a().a().el(null);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneEventTagJsPlugin", 1, "setHistoryEventTag error", paramString);
    }
  }
  
  private void aaJ(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new Bundle();
      paramString.putString("uin", ((JSONObject)localObject).optString("uin"));
      paramString.putString("time", ((JSONObject)localObject).optString("time"));
      paramString.putString("title", ((JSONObject)localObject).optString("title"));
      paramString.putString("picUrl", ((JSONObject)localObject).optString("picUrl"));
      paramString.putString("id", ((JSONObject)localObject).optString("id"));
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject = ((JSONObject)localObject).optJSONObject("joinList");
      if (localObject != null)
      {
        if (((JSONObject)localObject).has("names")) {
          localStringBuilder1.append(((JSONObject)localObject).optString("names"));
        }
        if (((JSONObject)localObject).has("middle"))
        {
          String str = ((JSONObject)localObject).optString("middle");
          localStringBuilder1.append(str);
          localStringBuilder2.append(str);
        }
        if (((JSONObject)localObject).has("suffix"))
        {
          localObject = ((JSONObject)localObject).optString("suffix");
          localStringBuilder1.append((String)localObject);
          localStringBuilder2.append((String)localObject);
        }
      }
      paramString.putString("desc", localStringBuilder1.toString());
      paramString.putString("truncateNum", localStringBuilder2.toString());
      avzf.a().a().em(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneEventTagJsPlugin", 1, "selectHistoryEventTag error", paramString);
    }
  }
  
  private void aaK(String paramString)
  {
    if (paramString == null) {
      return;
    }
    QLog.w("QZoneEventTagJsPlugin", 1, "errorCallBack error");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", -1);
      this.f.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QZoneEventTagJsPlugin", 1, "errorCallBack error", paramString);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!paramString2.equals(PKG_NAME)) || (this.f == null) || (this.f.mRuntime == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (!paramString3.equals(cPv)) {
          break;
        }
        bool1 = bool2;
      } while (paramVarArgs == null);
      bool1 = bool2;
    } while (paramVarArgs.length <= 0);
    a(this.f, this.f.mRuntime, paramVarArgs);
    return true;
    if ("getHistoryEventTag".equals(paramString3))
    {
      avzf.a().a(this);
      aaH(paramVarArgs[0]);
      return true;
    }
    if ("setHistoryEventTag".equals(paramString3))
    {
      aaI(paramVarArgs[0]);
      return true;
    }
    if ("selectEventTag".equals(paramString3))
    {
      aaJ(paramVarArgs[0]);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!"cmd.getHistoryEventTag".equals(paramString))) {}
    do
    {
      return;
      if (!paramBundle.containsKey("data")) {
        break;
      }
      paramString = paramBundle.getBundle("data");
      if (paramString == null)
      {
        QLog.e("QZoneEventTagJsPlugin", 1, "call js function,bundle is empty");
        return;
      }
      try
      {
        paramBundle = paramString.getParcelableArrayList("event_tag");
        paramString = new JSONArray();
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          PublishEventTag localPublishEventTag = (PublishEventTag)paramBundle.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", localPublishEventTag.uin);
          localJSONObject.put("time", localPublishEventTag.time);
          localJSONObject.put("title", localPublishEventTag.title);
          localJSONObject.put("picUrl", localPublishEventTag.picUrl);
          localJSONObject.put("id", localPublishEventTag.id);
          paramString.put(localJSONObject);
        }
        paramBundle = new JSONObject();
      }
      catch (JSONException paramString)
      {
        QLog.e("QZoneEventTagJsPlugin", 1, "onWebEvent error", paramString);
        return;
      }
      paramBundle.put("list", paramString);
    } while (this.callback == null);
    this.f.callJs(this.callback, new String[] { paramBundle.toString() });
    return;
    aaK(this.callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awej
 * JD-Core Version:    0.7.0.1
 */