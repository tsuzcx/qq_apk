import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.open.appcommon.now.download.js.DownloadCallbackWebImpl.1;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arvb
  implements arva
{
  protected static arvb a;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  
  public static arvb a()
  {
    if (a == null) {
      a = new arvb();
    }
    return a;
  }
  
  protected void Xk(String paramString)
  {
    arvf localarvf = arvf.a();
    for (;;)
    {
      int i;
      try
      {
        int j = localarvf.eg().size();
        i = 0;
        if (i < j)
        {
          Object localObject = (arxp)localarvf.eg().get(i);
          WebView localWebView = ((arxp)localObject).getWebview();
          if (localWebView != null) {
            if (TextUtils.isEmpty(((arxp)localObject).getJsCallbackMethod()))
            {
              localObject = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + paramString + ");}void(0);";
              arwt.v("DownloadCallbackWebImpl", " commonJsCallBack >>> " + (String)localObject);
              this.mHandler.post(new DownloadCallbackWebImpl.1(this, localWebView, (String)localObject));
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
        arwt.e("DownloadCallbackWebImpl", "doJsCallback >>> ", paramString);
      }
      i += 1;
    }
  }
  
  public void Zp(int paramInt)
  {
    Xk(gt(paramInt));
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
        arwt.e("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", paramString1);
      }
    }
  }
  
  public JSONObject a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramDownloadInfo.appId);
      localJSONObject.put("state", paramDownloadInfo.getState());
      localJSONObject.put("pro", paramDownloadInfo.progress);
      localJSONObject.put("packagename", paramDownloadInfo.packageName);
      localJSONObject.put("ismyapp", paramDownloadInfo.downloadType);
      localJSONObject.put("download_from", paramDownloadInfo.from);
      localJSONObject.put("realDownloadType", paramDownloadInfo.elk);
      localJSONObject.put("via", paramDownloadInfo.via);
      localJSONObject.put("writecodestate", paramDownloadInfo.elm);
      localJSONObject.put("extraInfo", paramDownloadInfo.extraData);
      localJSONObject.put("isAutoInstallBySDK", paramDownloadInfo.isAutoInstallBySDK);
      localJSONObject.put("queryResult", paramInt);
      return localJSONObject;
    }
    catch (JSONException paramDownloadInfo)
    {
      arwt.e("DownloadCallbackWebImpl", "onNetworkConnect " + paramDownloadInfo.getMessage(), paramDownloadInfo);
    }
    return localJSONObject;
  }
  
  public void e(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if (paramDownloadInfo != null) {
      Xk(a(paramDownloadInfo, paramInt).toString());
    }
  }
  
  protected String gt(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("nettype", paramInt);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        arwt.e("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", localJSONException);
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
        arwt.e("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", paramString1);
      }
    }
  }
  
  public void nn(List<DownloadInfo> paramList) {}
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      Xk(a(paramDownloadInfo, -1).toString());
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
      Xk(a(paramDownloadInfo, -1).toString());
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      Xk(a(paramDownloadInfo, -1).toString());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(a((DownloadInfo)paramList.next(), -1));
      }
      Xk(localJSONArray.toString());
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      Xk(a(paramDownloadInfo, -1).toString());
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
 * Qualified Name:     arvb
 * JD-Core Version:    0.7.0.1
 */