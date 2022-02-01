import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@ProxyService(proxy=ThirdAppProxy.class)
public class asxb
  extends ThirdAppProxy
{
  private HashMap<String, JSONObject> mAppJsonInfo = new HashMap();
  private Context mContext;
  private HashMap<String, ThirdAppProxy.AppDownloadListener> mDownloadListenerMap;
  private HashMap<String, AsyncResult> mInstallCallbackMap = new HashMap();
  private boolean mIsInitFlag;
  private HashMap<String, Integer> mProgressMap = new HashMap();
  private HashMap<String, AsyncResult> mQueryCallbackMap = new HashMap();
  private HashMap<String, List<AsyncResult>> mQueryDownloadInfoListenerMap = new HashMap();
  private int mRetryCount;
  private awoe mWadlCallback = new asxc(this);
  private HashMap<String, WadlParams> mWadlParams = new HashMap();
  private awol mWadlProxyService;
  
  private WadlParams createWadlParams(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      WadlParams localWadlParams = new WadlParams();
      localWadlParams.via = "SmallGame";
      localWadlParams.apkChannel = "10036618";
      localWadlParams.from = 6;
      localWadlParams.apkUrl = paramJSONObject.optString("android_download_url");
      localWadlParams.appId = paramJSONObject.optString("appid");
      localWadlParams.versionCode = paramJSONObject.optInt("version_code");
      localWadlParams.packageName = paramJSONObject.optString("pkg_name");
      localWadlParams.appName = paramJSONObject.optString("app_name");
      localWadlParams.iconUrl = paramJSONObject.optString("app_icon");
      localWadlParams.bLE = "interrupt";
      return localWadlParams;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.i("ThirdAppProxyImpl", 1, "createWadlParams exception happend:", paramJSONObject);
    }
    return null;
  }
  
  public void a(String paramString, ThirdAppProxy.AppDownloadListener paramAppDownloadListener)
  {
    if (this.mDownloadListenerMap == null) {
      this.mDownloadListenerMap = new HashMap();
    }
    this.mDownloadListenerMap.put(paramString, paramAppDownloadListener);
  }
  
  public void init()
  {
    if (this.mIsInitFlag) {
      return;
    }
    this.mIsInitFlag = true;
    this.mRetryCount = 0;
    this.mDownloadListenerMap = new HashMap();
    this.mWadlProxyService = new awol();
    this.mWadlProxyService.a(this.mWadlCallback);
  }
  
  public boolean installApp(String paramString, AsyncResult paramAsyncResult)
  {
    if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString)) || (paramAsyncResult == null)) {
      return false;
    }
    WadlParams localWadlParams2 = createWadlParams((JSONObject)this.mAppJsonInfo.get(paramString));
    WadlParams localWadlParams1 = localWadlParams2;
    if (localWadlParams2 == null) {
      localWadlParams1 = (WadlParams)this.mWadlParams.get(paramString);
    }
    if (localWadlParams1 == null)
    {
      paramAsyncResult.onReceiveResult(false, null);
      return false;
    }
    localWadlParams1.setFlags(2);
    localWadlParams1.ekZ = 5;
    this.mWadlProxyService.c(localWadlParams1);
    paramAsyncResult.onReceiveResult(true, null);
    return true;
  }
  
  public void queryApkDownloadInfo(String paramString, AsyncResult paramAsyncResult)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAsyncResult == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new asxb.a(paramString, paramAsyncResult);
    awot.a().a(paramString);
    awot.a().D("10036618", localArrayList);
  }
  
  public void queryDownloadTask(String paramString, AsyncResult paramAsyncResult)
  {
    if (paramAsyncResult == null) {
      return;
    }
    if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString))) {
      paramAsyncResult.onReceiveResult(false, null);
    }
    this.mQueryCallbackMap.put(paramString, paramAsyncResult);
    paramAsyncResult = new ArrayList();
    paramAsyncResult.add(paramString);
    this.mWadlProxyService.fz(paramAsyncResult);
  }
  
  public void startDownload(String paramString, JSONObject paramJSONObject, boolean paramBoolean, ThirdAppProxy.AppDownloadListener paramAppDownloadListener)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null))
    {
      QLog.i("ThirdAppProxyImpl", 1, "startDownload, url is empty!");
      if (paramAppDownloadListener != null) {
        paramAppDownloadListener.onDownloadFailed(-1000, -1, "url is invalid");
      }
      return;
    }
    if (paramAppDownloadListener != null) {
      a(paramString, paramAppDownloadListener);
    }
    for (;;)
    {
      try
      {
        this.mAppJsonInfo.put(paramString, paramJSONObject);
        paramString = createWadlParams(paramJSONObject);
        if (paramString == null) {
          break;
        }
        if (!paramBoolean) {
          break label124;
        }
        paramString.setFlags(7);
        paramString.ekZ = 2;
        this.mWadlProxyService.h(paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.i("ThirdAppProxyImpl", 1, "startDownload---exception happend:", paramString);
      }
      if (paramAppDownloadListener == null) {
        break;
      }
      paramAppDownloadListener.onDownloadFailed(-1000, -2, "url is invalid");
      return;
      label124:
      paramString.setFlags(6);
    }
  }
  
  public boolean stopDownloadTask(String paramString)
  {
    if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    WadlParams localWadlParams = createWadlParams((JSONObject)this.mAppJsonInfo.get(paramString));
    if (localWadlParams == null) {
      return false;
    }
    localWadlParams.setFlags(2);
    localWadlParams.ekZ = 3;
    this.mWadlProxyService.eE(6, paramString);
    return true;
  }
  
  public void unInit()
  {
    if (this.mDownloadListenerMap != null)
    {
      this.mDownloadListenerMap.clear();
      this.mDownloadListenerMap = null;
    }
    this.mIsInitFlag = false;
    this.mRetryCount = 0;
    this.mContext = null;
    if (this.mWadlProxyService != null)
    {
      this.mWadlProxyService.b(this.mWadlCallback);
      this.mWadlProxyService.destroy();
      this.mWadlProxyService = null;
    }
  }
  
  class a
    implements awos
  {
    private AsyncResult jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult;
    private String mAppid;
    
    public a(String paramString, AsyncResult paramAsyncResult)
    {
      this.mAppid = paramString;
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult = paramAsyncResult;
    }
    
    public HashSet<String> getFilterCmds()
    {
      HashSet localHashSet = new HashSet();
      localHashSet.add("13169");
      return localHashSet;
    }
    
    public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
    {
      paramIntent = null;
      Object localObject = null;
      QLog.i("ThirdAppProxyImpl", 1, "onCmdRsp ret=" + paramLong + ",cmd=" + paramString + ",dataJson=" + paramJSONObject);
      AsyncResult localAsyncResult;
      if ("13169".equals(paramString))
      {
        try
        {
          localAsyncResult = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult;
          if (localAsyncResult == null) {
            return;
          }
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult = null;
          if (paramLong != 0L)
          {
            localAsyncResult.onReceiveResult(false, null);
            return;
          }
        }
        catch (Throwable paramIntent)
        {
          QLog.e("ThirdAppProxyImpl", 1, "exception. ", paramIntent);
          return;
        }
        paramString = localObject;
      }
      for (;;)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("v_appd_down_load_info");
          if (paramJSONObject == null) {
            break label186;
          }
          paramString = localObject;
          paramIntent = paramJSONObject.getJSONObject(0);
        }
        catch (Throwable paramIntent)
        {
          QLog.e("ThirdAppProxyImpl", 1, "exception. ", paramIntent);
          if (paramString == null) {
            break label179;
          }
        }
        paramString = paramIntent;
        localAsyncResult.onReceiveResult(bool, paramIntent);
        return;
        boolean bool = true;
        label162:
        localAsyncResult.onReceiveResult(bool, paramString);
        return;
        label179:
        label186:
        do
        {
          bool = false;
          break;
          bool = false;
          break label162;
          return;
        } while (paramIntent == null);
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxb
 * JD-Core Version:    0.7.0.1
 */