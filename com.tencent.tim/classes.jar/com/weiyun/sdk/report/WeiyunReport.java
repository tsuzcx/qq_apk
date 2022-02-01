package com.weiyun.sdk.report;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.weiyun.sdk.Global;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.NetworkUtils.NetworkProxy;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunReport
{
  private static final int BATCH_NUM = 1;
  private static final Object CLIENT_LOCK = new Object();
  private static final Object HANDLER_LOCK;
  private static final Object LOCK = new Object();
  private static final String REPORT_URL = "http://p.store.qq.com/weiyun?op=all";
  private static final String REPORT_URL_TEST = "http://113.108.67.102/weiyun?op=all";
  private static final String TAG = "WeiyunReport";
  private static final int WAIT_TIME = 600000;
  private static Handler sHandler;
  private static HttpClient sHttpClient;
  private static long sLastReportTime;
  private static List<WeiyunReportObj> sListToSend = new ArrayList();
  
  static
  {
    sLastReportTime = SystemClock.uptimeMillis();
    HANDLER_LOCK = new Object();
  }
  
  private static HttpClient createHttpClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 45000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, "android-weiyun-sdk");
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    try
    {
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      return new DefaultHttpClient(new SingleClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.i("WeiyunReport", "http register Scheme exception", localThrowable);
      }
    }
  }
  
  private static HttpResponse executeHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity)
    throws IOException
  {
    HttpPost localHttpPost = new HttpPost(paramString);
    paramString = new URL(paramString).getAuthority();
    localHttpPost.addHeader("Host", paramString);
    localHttpPost.addHeader("x-online-host", paramString);
    if ((paramHttpEntity instanceof ByteArrayEntity)) {
      localHttpPost.addHeader("Content-Type", "application/octet-stream");
    }
    localHttpPost.setEntity(paramHttpEntity);
    if (NetworkUtils.isMobileConnected(paramContext))
    {
      paramContext = NetworkUtils.getProxy(paramContext, false);
      if (paramContext != null)
      {
        paramString = new HttpHost(paramContext.host, paramContext.port);
        localHttpPost.getParams().setParameter("http.route.default-proxy", paramString);
        Log.d("WeiyunReport", "use proxy[host:" + paramContext.host + ",port:" + paramContext.port + "]");
      }
    }
    return getReportClient().execute(localHttpPost);
  }
  
  public static HttpClient getReportClient()
  {
    if (sHttpClient == null) {}
    synchronized (CLIENT_LOCK)
    {
      if (sHttpClient == null) {
        sHttpClient = createHttpClient();
      }
      return sHttpClient;
    }
  }
  
  public static Handler getReportHandler()
  {
    if (sHandler == null) {}
    synchronized (HANDLER_LOCK)
    {
      if (sHandler == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("WeiyunReport", 19);
        localHandlerThread.start();
        sHandler = new Handler(localHandlerThread.getLooper());
      }
      return sHandler;
    }
  }
  
  public static void uploadReport(WeiyunReportObj paramWeiyunReportObj)
  {
    if (paramWeiyunReportObj == null) {}
    while (!NetworkUtils.isNetworkConnectedOrConnecting(Global.getContext())) {
      return;
    }
    synchronized (LOCK)
    {
      sListToSend.add(paramWeiyunReportObj);
      long l1 = SystemClock.uptimeMillis();
      long l2 = sLastReportTime;
      if ((sListToSend.size() >= 1) || (l1 - l2 >= 600000L))
      {
        getReportHandler().post(new ReportRunnable(new ArrayList(sListToSend)));
        sListToSend.clear();
        sLastReportTime = SystemClock.uptimeMillis();
      }
      return;
    }
  }
  
  static class ReportRunnable
    implements Runnable
  {
    private static final int RETRY_DELAY_TIME = 300000;
    private static final int RETRY_MAX_COUNT = 3;
    private String mBody;
    private boolean mIsInit = false;
    private ArrayList<WeiyunReportObj> mListToSend;
    private int mRetryCount = 0;
    private final long mStartTime = SystemClock.uptimeMillis();
    private boolean mSucceed = false;
    
    public ReportRunnable(ArrayList<WeiyunReportObj> paramArrayList)
    {
      this.mListToSend = paramArrayList;
    }
    
    private void init()
    {
      if (this.mIsInit) {
        return;
      }
      if (this.mListToSend.isEmpty())
      {
        Log.w("WeiyunReport", "listToSend is empty.");
        return;
      }
      Object localObject = this.mListToSend;
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray;
      try
      {
        localJSONObject.put("count", ((ArrayList)localObject).size());
        localJSONArray = new JSONArray();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          WeiyunReportObj localWeiyunReportObj = (WeiyunReportObj)((Iterator)localObject).next();
          if (localWeiyunReportObj != null)
          {
            localJSONArray.put(localWeiyunReportObj.toJSON());
            continue;
            if (str != null) {
              break label141;
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("WeiyunReport", "init error:", localJSONException);
        str = null;
      }
      label141:
      for (String str = "";; str = str.toString())
      {
        this.mBody = str;
        this.mIsInit = true;
        return;
        str.put("data", localJSONArray);
        break;
      }
    }
    
    public void run()
    {
      init();
      if (TextUtils.isEmpty(this.mBody)) {}
      for (;;)
      {
        return;
        Log.d("WeiyunReport", "run report thread..");
        try
        {
          HttpResponse localHttpResponse = WeiyunReport.executeHttpPost(Global.getContext(), "http://p.store.qq.com/weiyun?op=all", new StringEntity(this.mBody));
          if (localHttpResponse.getStatusLine().getStatusCode() == 200)
          {
            this.mListToSend.clear();
            this.mSucceed = true;
            Log.d("WeiyunReport", "report success. cost time=" + (SystemClock.uptimeMillis() - this.mStartTime));
          }
          while ((!this.mSucceed) && (this.mRetryCount <= 3))
          {
            WeiyunReport.getReportHandler().postDelayed(this, 300000L);
            return;
            this.mRetryCount += 1;
            Log.e("WeiyunReport", "HttpStatus error when report:" + localHttpResponse.getStatusLine().getStatusCode());
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            this.mRetryCount += 1;
            Log.e("WeiyunReport", "error when report", localThrowable);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.report.WeiyunReport
 * JD-Core Version:    0.7.0.1
 */