import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.wadl.WadlJsBridgeCallBack.1;
import com.tencent.open.wadl.WadlJsBridgeCallBack.2;
import com.tencent.smtt.sdk.WebView;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class asby
  implements awoe, awos
{
  public static String TAG = "WadlJsBridgeCallBack";
  private ArrayList<WadlResult> DF = new ArrayList();
  private arxp a;
  protected long awE;
  private boolean ddO;
  private boolean ddP;
  protected final int elc = 1000;
  private long lastUpdateTime;
  private Handler mHandler;
  
  public asby(boolean paramBoolean, arxp paramarxp)
  {
    this.ddO = paramBoolean;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.a = paramarxp;
  }
  
  private void XF(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.DF.iterator();
      while (localIterator.hasNext())
      {
        WadlResult localWadlResult = (WadlResult)localIterator.next();
        if ((localWadlResult.a != null) && (TextUtils.equals(localWadlResult.a.appId, paramString))) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void Xk(String paramString)
  {
    if (!this.ddO) {}
    for (;;)
    {
      return;
      asbt.i(TAG, "doJsCallBack loadJs=" + paramString);
      try
      {
        WebView localWebView = this.a.getWebview();
        if (localWebView != null)
        {
          this.mHandler.post(new WadlJsBridgeCallBack.1(this, localWebView, paramString));
          return;
        }
      }
      catch (Exception paramString)
      {
        asbt.e(TAG, "doJsCallback exception", paramString);
      }
    }
  }
  
  private void a(int paramInt, WadlParams paramWadlParams)
  {
    if (paramWadlParams == null) {
      return;
    }
    int j = 1;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i != 0)
    {
      showToast(ascc.gy(paramInt));
      return;
      awok.a().cC(0, paramWadlParams.appId);
      i = j;
      continue;
      awok.a().eE(0, paramWadlParams.appId);
      this.mHandler.post(new WadlJsBridgeCallBack.2(this, paramWadlParams));
      i = 0;
    }
  }
  
  private void emC()
  {
    if (this.a == null) {}
    while ((System.currentTimeMillis() - this.lastUpdateTime <= 1000L) && (!this.ddP)) {
      return;
    }
    Object localObject1 = new JSONArray();
    Object localObject2 = this.DF.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((JSONArray)localObject1).put(ascc.a((WadlResult)((Iterator)localObject2).next()));
    }
    localObject1 = ((JSONArray)localObject1).toString();
    localObject2 = this.a.getJsCallbackMethod();
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (localObject1 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + (String)localObject1 + ");}void(0);";; localObject1 = "javascript:" + (String)localObject2 + "(" + (String)localObject1 + ")")
    {
      Xk((String)localObject1);
      this.DF.clear();
      this.lastUpdateTime = System.currentTimeMillis();
      this.ddP = false;
      return;
    }
  }
  
  private void l(WadlResult paramWadlResult)
  {
    if (paramWadlResult != null)
    {
      Iterator localIterator = this.DF.iterator();
      while (localIterator.hasNext())
      {
        WadlResult localWadlResult = (WadlResult)localIterator.next();
        if ((localWadlResult.a != null) && (paramWadlResult.a != null) && (TextUtils.equals(localWadlResult.a.appId, paramWadlResult.a.appId))) {
          localWadlResult.progress = paramWadlResult.progress;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.DF.add(paramWadlResult);
      }
      if (paramWadlResult.progress == 100) {
        this.ddP = true;
      }
      return;
    }
  }
  
  public HashSet<String> getFilterCmds()
  {
    asbv localasbv = (asbv)asbw.a().w("comminfo");
    if (localasbv != null) {
      return localasbv.i();
    }
    return awot.bU;
  }
  
  public void k(WadlResult paramWadlResult)
  {
    String str;
    if ((paramWadlResult != null) && (this.ddO))
    {
      paramWadlResult = ascc.a(paramWadlResult).toString();
      str = this.a.getJsCallbackMethod();
      if (!TextUtils.isEmpty(str)) {
        break label67;
      }
    }
    label67:
    for (paramWadlResult = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + paramWadlResult + ");}void(0);";; paramWadlResult = "javascript:" + str + "(" + paramWadlResult + ")")
    {
      Xk(paramWadlResult);
      return;
    }
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    asbt.i(TAG, "onCmdRsp cmd=" + paramString + ",isSucc");
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getStringExtra("webssoReqJson");; paramIntent = null)
    {
      paramJSONObject = paramIntent;
      if (paramIntent == null) {
        paramJSONObject = "";
      }
      paramIntent = localJSONObject.toString();
      Xk("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": " + paramString + ", \"webssoReq\":" + paramJSONObject + ", \"ret\":" + paramLong + ", \"data\":" + paramIntent + "});}void(0);");
      return;
    }
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    asbt.i(TAG, "onQueryCallback params:" + paramArrayList);
    JSONArray localJSONArray;
    if (paramArrayList != null) {
      try
      {
        localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(ascc.a((WadlResult)paramArrayList.next()));
          continue;
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        asbt.e(TAG, "onQueryCallback exception:" + paramArrayList.getMessage());
      }
    }
    Xk("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": " + "1" + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);");
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList)
  {
    asbt.i(TAG, "onQueryCallbackVia params:" + paramArrayList);
    JSONArray localJSONArray;
    if (paramArrayList != null) {
      try
      {
        localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(ascc.a((WadlResult)paramArrayList.next()));
          continue;
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        asbt.e(TAG, "onQueryCallbackVia exception:" + paramArrayList.getMessage());
      }
    }
    Xk("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadActionByVia',{\"guid\": " + "1" + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);");
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.a == null))
    {
      asbt.e(TAG, "onWadlTaskStatusChanged error wadlResult is null");
      return;
    }
    WadlParams localWadlParams = paramWadlResult.a;
    String str = localWadlParams.appId;
    int i = ascc.kR(paramWadlResult.bBa);
    asbx.XD(localWadlParams.appId);
    asbt.i(TAG, "onWadlTaskStatusChanged:" + paramWadlResult + ",localStatus:" + i);
    switch (i)
    {
    default: 
      asbt.e(TAG, "download status not response!");
      return;
    case 3: 
    case 4: 
    case 6: 
    case 9: 
    case 10: 
    case 13: 
    case 20: 
      XF(str);
      k(paramWadlResult);
      return;
    case -2: 
      i = ascc.kS(paramWadlResult.errCode);
      asbt.e(TAG, "onWadlTaskStatusChanged  error,wadlErrCode=" + i);
      XF(str);
      a(i, localWadlParams);
      k(paramWadlResult);
      return;
    }
    l(paramWadlResult);
    emC();
  }
  
  public void showToast(String paramString)
  {
    try
    {
      if ((BaseActivity.sTopActivity.isResume()) && (System.currentTimeMillis() - this.awE > 1000L))
      {
        this.awE = System.currentTimeMillis();
        arxa.a().showToast(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      asbt.e(TAG, "showToast>>>", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asby
 * JD-Core Version:    0.7.0.1
 */