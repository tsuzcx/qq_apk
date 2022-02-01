import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.WebViewDownloadListener.1;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arzy
  implements aryx
{
  protected static arzy a;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  
  public static arzy a()
  {
    if (a == null) {
      a = new arzy();
    }
    return a;
  }
  
  protected void Xk(String paramString)
  {
    arxq localarxq = arxq.a();
    for (;;)
    {
      int i;
      try
      {
        int j = localarxq.eg().size();
        i = 0;
        if (i < j)
        {
          Object localObject = (arxp)localarxq.eg().get(i);
          WebView localWebView = ((arxp)localObject).getWebview();
          if (localWebView != null) {
            if (TextUtils.isEmpty(((arxp)localObject).getJsCallbackMethod()))
            {
              localObject = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + paramString + ");}void(0);";
              arwt.v("WebViewDownloadListener", " commonJsCallBack >>> " + (String)localObject);
              this.mHandler.post(new WebViewDownloadListener.1(this, localWebView, (String)localObject));
            }
            else
            {
              localObject = "javascript:" + ((arxp)localObject).getJsCallbackMethod() + "(" + paramString + ")";
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        arwt.e("WebViewDownloadListener", "doJsCallback >>> ", paramString);
      }
      i += 1;
    }
  }
  
  protected String a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4, int paramInt5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("pro", paramInt2);
      localJSONObject.put("ismyapp", paramInt3);
      localJSONObject.put("errorMsg", paramString3);
      localJSONObject.put("errorCode", paramInt4);
      localJSONObject.put("writecodestate", paramInt5);
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        arwt.e("WebViewDownloadListener", "getCallBackJsonObject >>> ", paramString1);
      }
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Xk(l(paramString1, 6, paramString2));
  }
  
  protected String l(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt);
      localJSONObject.put("pro", 0);
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        arwt.e("WebViewDownloadListener", "getCallBackJsonObject >>> ", paramString1);
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      Xk(paramDownloadInfo.toJSONObject().toString());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (paramDownloadInfo != null) {
      Xk(a(paramDownloadInfo.appId, paramInt2, paramDownloadInfo.progress, paramDownloadInfo.packageName, paramDownloadInfo.downloadType, paramString, paramInt1, paramDownloadInfo.elm));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      Xk(paramDownloadInfo.toJSONObject().toString());
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      Xk(paramDownloadInfo.toJSONObject().toString());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(((DownloadInfo)paramList.next()).toJSONObject());
      }
      Xk(localJSONArray.toString());
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      Xk(paramDownloadInfo.toJSONObject().toString());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Xk(l(paramString1, 13, paramString2));
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Xk(l(paramString1, 9, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzy
 * JD-Core Version:    0.7.0.1
 */