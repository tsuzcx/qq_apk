package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import avpq;
import avqa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import mqq.app.AppRuntime;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class HybridWebReporter
{
  private static ArrayList<a> Dj = new ArrayList();
  private static HybridWebReporter a;
  public static String czG;
  private static final Object obj = new Object();
  private static long startTime = SystemClock.uptimeMillis();
  private Random random;
  
  public static HybridWebReporter a()
  {
    if (a == null) {}
    synchronized (obj)
    {
      if (a == null) {
        a = new HybridWebReporter();
      }
      return a;
    }
  }
  
  public static void ehw()
  {
    if (Dj.isEmpty()) {
      return;
    }
    synchronized (Dj)
    {
      ArrayList localArrayList2 = new ArrayList(Dj);
      Dj.clear();
      startTime = SystemClock.uptimeMillis();
      ThreadManager.executeOnNetWorkThread(new ReportRunnable(localArrayList2));
      return;
    }
  }
  
  private boolean mG(int paramInt)
  {
    if (paramInt <= 0) {}
    do
    {
      return false;
      if (this.random == null) {
        this.random = new Random(System.currentTimeMillis());
      }
    } while (this.random.nextInt() % paramInt != 0);
    return true;
  }
  
  public void a(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      long l1 = SystemClock.uptimeMillis();
      long l2 = startTime;
      int j = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchInterval", 600);
      int k = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatUploadBatchCount", 10);
      if (QLog.isColorLevel()) {
        QLog.d("HybridWebReporter", 2, "add report, isreported(" + parama.isReported + "), url: " + parama.url);
      }
      if ((parama.eeG == 0) || (parama.isReported)) {
        continue;
      }
      parama.isReported = true;
      if (parama.eeG < 0) {
        parama.eeG = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatDefaultSampling", 20);
      }
      try
      {
        i = Integer.valueOf(parama.czJ).intValue();
        if (((parama.eeC != 1000) && (parama.eeC != 0)) || (i < 100) || (i > 400)) {
          parama.eeG = 1;
        }
        if (QLog.isColorLevel()) {
          parama.eeG = 1;
        }
        if (!mG(parama.eeG)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        synchronized (Dj)
        {
          Dj.add(parama);
          if ((Dj.size() < k) && ((l1 - l2 < j * 1000) || (Dj.size() <= 0))) {
            continue;
          }
          ehw();
          return;
          localException = localException;
          int i = 200;
        }
      }
    }
  }
  
  static class ReportRunnable
    implements Runnable
  {
    int VL = 0;
    String body;
    boolean inited = false;
    ArrayList<HybridWebReporter.a> listToSend;
    boolean successed = false;
    int tryCount = 0;
    
    public ReportRunnable(ArrayList<HybridWebReporter.a> paramArrayList)
    {
      this.listToSend = paramArrayList;
    }
    
    private void init()
    {
      if (this.inited) {
        return;
      }
      if (this.listToSend.isEmpty())
      {
        QLog.e("HybridWebReporter", 1, "listToSend is empty.");
        return;
      }
      Object localObject2 = this.listToSend;
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray;
      Object localObject1;
      try
      {
        localJSONArray = new JSONArray();
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localJSONArray.put(((HybridWebReporter.a)((Iterator)localObject2).next()).toJSON());
            continue;
            if (localObject1 == null) {
              break;
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.w("HybridWebReporter", 1, localException.toString());
        localObject1 = null;
      }
      for (;;)
      {
        this.body = localObject1.toString();
        if (QLog.isColorLevel()) {
          QLog.i("HybridWebReporter", 2, "json : " + this.body);
        }
        this.inited = true;
        return;
        localObject1.put("data", localJSONArray);
      }
    }
    
    public void run()
    {
      Object localObject = QzoneConfig.getInstance().getConfig("QzUrlCache", "QzhwStatCgiURL", "https://h5.qzone.qq.com/report/native");
      String str2 = (String)localObject + "?uin=" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
      init();
      if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(this.body))) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("HybridWebReporter", 2, "start report thread.");
      }
      label85:
      if ((!this.successed) && (this.VL <= 1)) {
        if (this.tryCount > 1)
        {
          new Handler(ThreadManager.getSubThreadLooper()).postDelayed(this, 300000L);
          this.VL += 1;
          this.tryCount = 0;
          return;
        }
      }
      for (;;)
      {
        int i;
        try
        {
          for (;;)
          {
            localObject = avqa.executeHttpPost(BaseApplication.getContext(), str2, new StringEntity(this.body, "UTF-8"));
            if (((HttpResponse)localObject).getStatusLine().getStatusCode() != 200) {
              break label419;
            }
            this.listToSend.clear();
            this.successed = true;
            QLog.d("HybridWebReporter", 4, "report success.");
            try
            {
              Header[] arrayOfHeader = ((HttpResponse)localObject).getHeaders("Content-Encoding");
              int k = arrayOfHeader.length;
              i = 0;
              int j = 0;
              if (i < k)
              {
                if (!arrayOfHeader[i].getValue().equals("gzip")) {
                  break label469;
                }
                j = 1;
                break label469;
              }
              localObject = ((HttpResponse)localObject).getEntity();
              if (j == 0) {
                break label409;
              }
              localObject = HttpBaseUtil.convertStreamToString(new GZIPInputStream(((HttpEntity)localObject).getContent()));
              if (QLog.isColorLevel()) {
                QLog.d("HybridWebReporter", 2, "HybridWeb report response result = " + (String)localObject);
              }
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break;
              }
              localObject = new JSONObject((String)localObject);
              if (!(((JSONObject)localObject).opt("urlPrefixConfig") instanceof JSONArray)) {
                break label85;
              }
              HybridWebReporter.czG = ((JSONObject)localObject).toString();
              LocalMultiProcConfig.putString("urlPrefixConfig", HybridWebReporter.czG);
            }
            catch (Throwable localThrowable1)
            {
              QLog.w("HybridWebReporter", 1, "save url prefix report err.", localThrowable1);
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          this.tryCount += 1;
          QLog.w("HybridWebReporter", 1, "exception when report", localThrowable2);
        }
        break label85;
        label409:
        String str1 = EntityUtils.toString(localThrowable2);
        continue;
        label419:
        QLog.e("HybridWebReporter", 1, "HttpStatus error when report : " + str1.getStatusLine().getStatusCode());
        this.tryCount += 1;
        break label85;
        break;
        label469:
        i += 1;
      }
    }
  }
  
  public static class a
  {
    public String apn = NetworkState.getAPN();
    public String app = "QQ";
    public long avt;
    public boolean cYY;
    public boolean cYZ;
    public boolean cZa;
    private AtomicInteger cl = new AtomicInteger(0);
    public String cnH = "";
    public String czH = "";
    public String czI = "";
    public String czJ = "";
    public String czK = "";
    public String czL = "";
    public String czM = "html";
    public String czN = avpq.getQUA3();
    public String detail = "";
    public int eeB;
    public int eeC;
    public int eeD;
    public int eeE;
    public int eeF;
    public int eeG = -1;
    public boolean isReported;
    public String platform = "Android";
    public String port = "";
    public long uin;
    public String url;
    
    public void reset()
    {
      this.eeF = 0;
      this.czM = "html";
      this.avt = 0L;
    }
    
    public JSONObject toJSON()
    {
      label423:
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", this.uin);
          String str = this.url;
          if (!TextUtils.isEmpty(this.url))
          {
            int j = this.url.indexOf('?');
            i = j;
            if (j < 0) {
              i = this.url.length();
            }
            str = this.url.substring(0, i);
          }
          localJSONObject.put("url", this.url);
          localJSONObject.put("path", str);
          localJSONObject.put("errordomain", this.czH);
          localJSONObject.put("errorcode", this.czI);
          localJSONObject.put("httpstatus", this.czJ);
          localJSONObject.put("userip", this.czK);
          localJSONObject.put("serverip", this.cnH);
          localJSONObject.put("port", this.port);
          localJSONObject.put("dnsresult", this.czL);
          localJSONObject.put("apn", this.apn);
          localJSONObject.put("timecost", this.eeB / 1000.0F);
          localJSONObject.put("app", this.app);
          localJSONObject.put("appversion", this.czN);
          localJSONObject.put("platform", this.platform);
          localJSONObject.put("sampling", this.eeG);
          localJSONObject.put("usewns", this.cYY);
          int i = this.eeC;
          if (i != 1000) {
            if (i == 0)
            {
              break label423;
              localJSONObject.put("wnscode", i);
              localJSONObject.put("detail", this.detail);
              localJSONObject.put("usecache", this.cYZ);
              localJSONObject.put("cachehasdata", this.cZa);
              localJSONObject.put("cacheupdatepolicy", this.eeD);
              localJSONObject.put("cacheupdatetimecost", this.eeE / 1000.0F);
              localJSONObject.put("serviceversion", this.eeF);
              localJSONObject.put("webso3_type", this.czM);
              localJSONObject.put("datasize", this.avt);
              return localJSONObject;
            }
            else
            {
              i = this.eeC;
              i += 300000;
              continue;
            }
          }
          i = 0;
        }
        catch (Exception localException)
        {
          QLog.e("HybridWebReporter", 1, localException, new Object[0]);
          return null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HybridWebReporter
 * JD-Core Version:    0.7.0.1
 */