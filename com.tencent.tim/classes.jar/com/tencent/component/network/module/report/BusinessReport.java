package com.tencent.component.network.module.report;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.component.network.Global;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.HttpUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BusinessReport
{
  private static final int APP_OP_COUNT = 12;
  private static final int MAX_COUNT = 10;
  private static final int MAX_TIME = 600000;
  private static final int RADOM_PERCENT = 5;
  private static final String TAG = "BusinessReport";
  private static SparseArray<ArrayList<ReportObj>> appReportLists = new SparseArray(12);
  private static final Object init_lock;
  private static volatile boolean inited;
  private static final Object[] locks;
  private static CommonTaskThread mTaskThread = new CommonTaskThread("BusinessReport");
  private static Random r = new Random();
  private static long startTime;
  
  static
  {
    locks = new Object[12];
    init_lock = new Object();
    inited = false;
    startTime = SystemClock.uptimeMillis();
  }
  
  private static ArrayList<ReportObj> createRamdomArrayList()
  {
    return new BusinessReport.1();
  }
  
  private static int getReportPercent()
  {
    int i = 100;
    int j = Config.getReportPercent();
    if (j < 0) {
      i = 5;
    }
    while (j > 100) {
      return i;
    }
    return j;
  }
  
  public static void init()
  {
    int k = 0;
    if (inited) {
      return;
    }
    synchronized (init_lock)
    {
      if (inited) {
        return;
      }
    }
    inited = true;
    int j = 0;
    break label100;
    appReportLists.append(j, createRamdomArrayList());
    break label122;
    label53:
    appReportLists.append(j, new ArrayList());
    break label122;
    label70:
    int i;
    while (i < locks.length)
    {
      locks[i] = new Object();
      i += 1;
    }
    return;
    for (;;)
    {
      label100:
      i = k;
      if (j >= 12) {
        break label70;
      }
      if (j == 1) {
        break;
      }
      if (j != 11) {
        break label53;
      }
      break;
      label122:
      j += 1;
    }
  }
  
  public static void uploadReport(ReportObj paramReportObj, int paramInt1, int paramInt2)
  {
    if (((paramInt1 < 0) || (paramInt1 > 9)) && (paramInt1 % 2 != 0)) {}
    for (;;)
    {
      return;
      if ((paramInt2 == 0) || (paramInt2 == 1))
      {
        int i = paramInt1 + paramInt2;
        long l1 = SystemClock.uptimeMillis();
        long l2 = startTime;
        ArrayList localArrayList = (ArrayList)appReportLists.get(i);
        synchronized (locks[i])
        {
          localArrayList.add(paramReportObj);
          switch (i)
          {
          case 0: 
          case 2: 
          case 3: 
          case 4: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          default: 
            return;
          case 1: 
          case 7: 
          case 11: 
            if ((localArrayList.size() >= 10) || (l1 - l2 >= 600000L))
            {
              uploadReportImmediately(paramInt1, paramInt2);
              return;
            }
            break;
          }
        }
      }
    }
    uploadReportImmediately(paramInt1, paramInt2);
  }
  
  public static void uploadReportImmediately(int paramInt1, int paramInt2)
  {
    if (((paramInt1 < 0) || (paramInt1 > 11)) && (paramInt1 % 2 != 0)) {}
    int i;
    ArrayList localArrayList1;
    do
    {
      do
      {
        return;
      } while (((paramInt2 != 0) && (paramInt2 != 1)) || (!NetworkManager.isNetworkAvailable()));
      i = paramInt1 + paramInt2;
      localArrayList1 = (ArrayList)appReportLists.get(i);
    } while (localArrayList1.isEmpty());
    synchronized (locks[i])
    {
      ArrayList localArrayList2 = new ArrayList(localArrayList1);
      if ((i == 1) || (i == 11))
      {
        appReportLists.setValueAt(i, createRamdomArrayList());
        localArrayList1.clear();
        startTime = SystemClock.uptimeMillis();
        mTaskThread.post(new ReportRunnable(localArrayList2, paramInt1, paramInt2));
        return;
      }
      appReportLists.setValueAt(i, new ArrayList());
    }
  }
  
  public static class ReportRunnable
    implements Runnable
  {
    private static final int MAX_TRY_COUNT = 0;
    int appid;
    String body;
    boolean inited = false;
    ArrayList<ReportObj> listToSend;
    int op;
    boolean successed = false;
    int tryCount = 0;
    String url;
    
    public ReportRunnable(ArrayList<ReportObj> paramArrayList, int paramInt1, int paramInt2)
    {
      this.listToSend = paramArrayList;
      this.appid = paramInt1;
      this.op = paramInt2;
    }
    
    private void init()
    {
      if (this.inited) {
        return;
      }
      if (this.listToSend.isEmpty())
      {
        QDLog.e("BusinessReport", "listToSend is empty.");
        return;
      }
      Object localObject = this.listToSend;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("count", ((ArrayList)localObject).size());
        JSONArray localJSONArray = new JSONArray();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localJSONArray.put(((ReportObj)((Iterator)localObject).next()).toJSON());
          continue;
          this.url = ReportObj.getReportUrl(this.appid, this.op);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONObject = null;
        QDLog.e("BusinessReport", "JSONException when uploadReport.", localJSONException);
      }
      for (;;)
      {
        if (QDLog.isInfoEnable()) {
          QDLog.i("BusinessReport", "url : " + this.url);
        }
        if (localJSONObject != null) {
          this.body = localJSONObject.toString();
        }
        if (QDLog.isInfoEnable()) {
          QDLog.i("BusinessReport", "json : " + this.body);
        }
        this.inited = true;
        return;
        localJSONObject.put("data", localJSONException);
      }
    }
    
    public void run()
    {
      init();
      if ((TextUtils.isEmpty(this.url)) || (TextUtils.isEmpty(this.body))) {}
      for (;;)
      {
        return;
        if (QDLog.isInfoEnable()) {
          QDLog.i("BusinessReport", "start report thread.");
        }
        try
        {
          HttpResponse localHttpResponse = HttpUtil.executeHttpPost(Global.getContext(), this.url, new StringEntity(this.body));
          if (localHttpResponse.getStatusLine() != null)
          {
            if (localHttpResponse.getStatusLine().getStatusCode() != 200) {
              break label136;
            }
            this.listToSend.clear();
            this.successed = true;
            if (QDLog.isInfoEnable()) {
              QDLog.i("BusinessReport", "report success.");
            }
          }
          while ((!this.successed) && (this.tryCount <= 0))
          {
            BusinessReport.mTaskThread.postDelay(this, 60000L);
            return;
            label136:
            this.tryCount += 1;
            QDLog.e("BusinessReport", "HttpStatus error when report : " + localHttpResponse.getStatusLine().getStatusCode());
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            this.tryCount += 1;
            QDLog.w("BusinessReport", "exception when report", localUnsupportedEncodingException);
          }
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          for (;;)
          {
            this.tryCount += 1;
            QDLog.w("BusinessReport", "exception when report", localClientProtocolException);
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.tryCount += 1;
            QDLog.w("BusinessReport", "exception when report", localIOException);
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            this.tryCount += 1;
            QDLog.w("BusinessReport", "exception when report", localIllegalArgumentException);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            this.tryCount += 1;
            QDLog.w("BusinessReport", "exception when report", localException);
          }
        }
        catch (Error localError)
        {
          for (;;)
          {
            this.tryCount += 1;
            QDLog.w("BusinessReport", "error when report", localError);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.report.BusinessReport
 * JD-Core Version:    0.7.0.1
 */