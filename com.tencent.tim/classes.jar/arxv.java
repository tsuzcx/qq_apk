import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class arxv
{
  public static void a(Context paramContext, WebView paramWebView, String paramString1, boolean paramBoolean, String paramString2)
  {
    arwt.d("AppUpdate", "httpRequest >>> " + paramString1.toString());
    try
    {
      localObject1 = new JSONObject(paramString1);
      str1 = ((JSONObject)localObject1).optString("guid");
      str2 = ((JSONObject)localObject1).optString("url");
      str3 = ((JSONObject)localObject1).optString("method");
      str4 = ((JSONObject)localObject1).optString("oncomplate");
      str5 = ((JSONObject)localObject1).optString("onerror");
      if (((JSONObject)localObject1).optInt("supportetag", 1) != 1) {
        break label307;
      }
      i = 1;
    }
    catch (JSONException paramContext)
    {
      Object localObject1;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      Bundle localBundle;
      for (;;)
      {
        arwt.e("AppUpdate", "httpRequest JSONException", paramContext);
        return;
        i = 0;
        continue;
        paramString1 = "0";
      }
      if (i == 0) {
        break label340;
      }
      localBundle.putString("needhttpcache", "");
      arwt.d("AppUpdate", "use supportEtag");
      if (paramBoolean) {
        break label548;
      }
      paramString1 = arxn.u(paramContext);
      if ((paramString1 == null) || (paramString1.size() <= 0)) {
        break label548;
      }
      paramString2 = new StringBuilder();
      int i = 0;
      while (i < paramString1.size())
      {
        localObject1 = (PackageInfo)paramString1.get(i);
        paramString2.append("[\"");
        paramString2.append(((PackageInfo)localObject1).packageName);
        paramString2.append("\",");
        paramString2.append(((PackageInfo)localObject1).versionCode);
        paramString2.append(",\"");
        paramString2.append(((PackageInfo)localObject1).versionName);
        paramString2.append("\"]");
        paramString2.append(",");
        i += 1;
      }
      if (paramString2.length() <= 0) {
        break label506;
      }
      paramString2.delete(paramString2.length() - 1, paramString2.length());
      localBundle.putString("package", "[" + paramString2.toString() + "]");
      localBundle.remove("update_data");
      arwt.d("AppUpdate", "execute asyncTask url >>> " + str2 + " methodName " + str3);
      aSyncTaskExecute(new arxh(str2, str3, new arxv.a(paramContext, paramWebView, str1, str4, str5, paramBoolean)), localBundle);
      return;
    }
    catch (Exception paramContext)
    {
      arwt.e("AppUpdate", "httpRequest Exception", paramContext);
    }
    localBundle = new Bundle();
    localBundle.putString("platform", aroi.a().getPlatform());
    localBundle.putString("keystr", aroi.a().getSkey());
    localBundle.putString("uin", paramString2);
    localBundle.putString("resolution", arxr.getResolution());
    localBundle.putString("keytype", "256");
    if (arxn.ct(paramContext))
    {
      paramString1 = "1";
      localBundle.putString("allowScan", paramString1);
      if (!str3.equals("POST")) {
        break label319;
      }
      paramString1 = ((JSONObject)localObject1).optJSONObject("params");
      if (paramString1 == null) {
        break label340;
      }
      paramString2 = paramString1.keys();
      while (paramString2.hasNext())
      {
        localObject1 = paramString2.next().toString();
        Object localObject2 = paramString1.get((String)localObject1);
        arwt.d("AppUpdate", "key = " + (String)localObject1 + " value = " + localObject2.toString());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localBundle.putString((String)localObject1, localObject2.toString());
        }
      }
    }
    label307:
    label319:
    label340:
    label506:
    return;
  }
  
  @TargetApi(11)
  protected static void aSyncTaskExecute(arxh paramarxh, Bundle paramBundle)
  {
    Executor localExecutor = obtainMultiExecutor();
    if (localExecutor != null)
    {
      paramarxh.executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    paramarxh.execute(new Bundle[] { paramBundle });
  }
  
  @TargetApi(11)
  protected static Executor obtainMultiExecutor()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return AsyncTask.THREAD_POOL_EXECUTOR;
    }
    return null;
  }
  
  public static class a
    implements arxh.a
  {
    protected final String cCA;
    protected final String cCz;
    protected Context context;
    protected boolean ddt;
    protected final String guid;
    protected final WebView webView;
    
    public a(Context paramContext, WebView paramWebView, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      this.context = paramContext;
      this.webView = paramWebView;
      this.cCA = paramString3;
      this.cCz = paramString2;
      this.guid = paramString1;
      this.ddt = paramBoolean;
    }
    
    public void ai(JSONObject paramJSONObject)
    {
      JSONObject localJSONObject = paramJSONObject;
      if (paramJSONObject == null) {
        localJSONObject = new JSONObject();
      }
      arwt.d("AppUpdate", "AppUpdate onResult >>> " + localJSONObject.toString());
      paramJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          paramJSONObject.put("guid", this.guid);
          paramJSONObject.put("content", localJSONObject.toString());
          if (TextUtils.isEmpty(this.cCz))
          {
            localObject = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpSuccess'," + paramJSONObject.toString() + ");}void(0);";
            paramJSONObject = (JSONObject)localObject;
            if (!this.ddt)
            {
              paramJSONObject = (JSONObject)localObject;
              if (arxn.ct(this.context))
              {
                if (localJSONObject.optInt("code", -1) != 0) {
                  continue;
                }
                arxu.fP(this.context);
                paramJSONObject = (JSONObject)localObject;
              }
            }
          }
        }
        catch (JSONException paramJSONObject)
        {
          Object localObject;
          if (TextUtils.isEmpty(this.cCA))
          {
            paramJSONObject = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.guid + "\"});}void(0);";
            continue;
          }
          paramJSONObject = "javascript:" + this.cCA + "({\"guid\":\"" + this.guid + "\",\"err\":\"json format error\"});void(0);";
          continue;
        }
        try
        {
          localObject = this.webView;
          if (localObject == null) {}
        }
        catch (Exception paramJSONObject)
        {
          return;
        }
        try
        {
          this.webView.loadUrl(paramJSONObject);
          return;
        }
        catch (Exception paramJSONObject) {}
        localObject = "javascript:" + this.cCz + "(" + paramJSONObject.toString() + ");void(0);";
        continue;
        arxu.fQ(this.context);
        paramJSONObject = (JSONObject)localObject;
      }
    }
    
    public void onException(Exception paramException)
    {
      arwt.d("AppUpdate", "AppUpdate onException >>> " + paramException.toString());
      if ((!this.ddt) && (arxn.ct(this.context))) {
        arxu.fQ(this.context);
      }
      if (TextUtils.isEmpty(this.cCA)) {}
      for (paramException = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.guid + "\"});}void(0);";; paramException = "javascript:" + this.cCA + "({\"guid\":\"" + this.guid + "\",\"err\":\"\"});void(0);") {
        try
        {
          this.webView.loadUrl(paramException);
          return;
        }
        catch (Exception paramException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxv
 * JD-Core Version:    0.7.0.1
 */