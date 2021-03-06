import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.2;
import cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.3;
import cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.4;
import cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.5;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awgt
  extends awfr
  implements avzi
{
  private String TAG = awgt.class.getSimpleName();
  private String cQa;
  
  private void abx(String paramString)
  {
    try
    {
      QLog.i(this.TAG, 1, "getLocalProxyUrl. json=" + paramString);
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("playList");
      localObject = ((JSONObject)localObject).getString("callback");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.cQa = ((String)localObject);
      }
      localObject = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        ((ArrayList)localObject).add(paramString.getJSONObject(i).getString("url"));
        localArrayList.add(paramString.getJSONObject(i).getString("vid"));
        i += 1;
      }
      if (((ArrayList)localObject).size() > 0) {
        this.f.mRuntime.a().getHandler(awgt.class).post(new QzoneVideoTabJsPlugin.2(this, (ArrayList)localObject, localArrayList));
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void aby(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("state");
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        localArrayList1.add(localJSONObject.getString("url"));
        localArrayList2.add(localJSONObject.getString("state"));
        i += 1;
      }
      if (localArrayList1.size() > 0) {
        this.f.mRuntime.a().getHandler(awgt.class).post(new QzoneVideoTabJsPlugin.3(this, localArrayList1, localArrayList2));
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static Activity c(Activity paramActivity)
  {
    Activity localActivity;
    if (paramActivity == null) {
      localActivity = null;
    }
    do
    {
      return localActivity;
      localActivity = paramActivity;
    } while (!(paramActivity instanceof BasePluginActivity));
    return ((BasePluginActivity)paramActivity).getOutActivity();
  }
  
  private void fO(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("url");
      this.f.mRuntime.a().getHandler(awgt.class).post(new QzoneVideoTabJsPlugin.5(this, paramString));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(this.TAG, 1, paramString, new Object[0]);
    }
  }
  
  private void stopAll()
  {
    this.f.mRuntime.a().getHandler(awgt.class).post(new QzoneVideoTabJsPlugin.4(this));
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if (("videoProxyGetLocalProxyURL".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      avzf.a().a(this);
      abx(paramVarArgs[0]);
      return true;
    }
    if (("videoProxySetPlayState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      avzf.a().a(this);
      aby(paramVarArgs[0]);
      return true;
    }
    if ("videoProxyStopAll".equals(paramString3))
    {
      avzf.a().a(this);
      stopAll();
      return true;
    }
    if ("videoProxySaveVideoToAlbum".equals(paramString3))
    {
      paramJsBridgeListener = this.f.mRuntime.getActivity();
      if ((paramJsBridgeListener != null) && (awdb.a(paramJsBridgeListener, new awgu(this, paramVarArgs, paramJsBridgeListener), 1))) {
        fO(paramVarArgs[0]);
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    avzf.a().b(this);
    super.onDestroy();
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        return;
        paramBundle = paramBundle.getBundle("data");
        if (paramBundle == null)
        {
          QLog.e(this.TAG, 1, "call js function,bundle is empty");
          return;
        }
      } while (!"cmd.videoGetLocalProxyUrl".equals(paramString));
      paramString = paramBundle.getStringArrayList("param.videoLocalUrls");
      ArrayList localArrayList = paramBundle.getStringArrayList("param.videoId");
      paramBundle = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      if ((paramString != null) && (localArrayList != null)) {}
      try
      {
        if (paramString.size() == localArrayList.size())
        {
          int i = 0;
          while (i < paramString.size())
          {
            String str = (String)paramString.get(i);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("vid", localArrayList.get(i));
            localJSONObject.put("url", str);
            localJSONArray.put(localJSONObject);
            i += 1;
          }
        }
        paramBundle.put("proxyList", localJSONArray);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.w(this.TAG, 2, "getLocalProxyUrl result is invalid.", paramString);
        }
      }
      QLog.i(this.TAG, 1, "getLocalProxyUrl result=" + paramBundle);
    } while (TextUtils.isEmpty(this.cQa));
    this.f.callJs(this.cQa, new String[] { paramBundle.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgt
 * JD-Core Version:    0.7.0.1
 */