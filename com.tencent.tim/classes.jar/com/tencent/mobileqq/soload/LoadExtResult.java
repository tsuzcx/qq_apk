package com.tencent.mobileqq.soload;

import android.text.TextUtils;
import anlo;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LoadExtResult
  implements Serializable
{
  private int downloadSoNum;
  private int failIndex;
  public anlo failInfo;
  private boolean isFirstlyLoad = true;
  private String reportStr = "";
  int resCode;
  private int soNum;
  private Map<String, String> soPaths = new HashMap();
  
  private LoadExtResult a(LoadExtResult paramLoadExtResult)
  {
    if (paramLoadExtResult == null) {
      return this;
    }
    this.soNum += paramLoadExtResult.soNum;
    this.resCode = paramLoadExtResult.resCode;
    this.downloadSoNum += paramLoadExtResult.downloadSoNum;
    if ((this.isFirstlyLoad) || (paramLoadExtResult.isFirstlyLoad)) {}
    for (boolean bool = true;; bool = false)
    {
      this.isFirstlyLoad = bool;
      if (!TextUtils.isEmpty(paramLoadExtResult.reportStr))
      {
        if (!TextUtils.isEmpty(this.reportStr)) {
          this.reportStr += "&";
        }
        this.reportStr += paramLoadExtResult.reportStr;
      }
      if (paramLoadExtResult.soPaths.size() <= 0) {
        break;
      }
      Iterator localIterator = paramLoadExtResult.soPaths.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.soPaths.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    this.failInfo = paramLoadExtResult.failInfo;
    return this;
  }
  
  private boolean bn(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 3) && ((paramInt2 == -104) || (paramInt2 == -111) || (paramInt2 == -114));
  }
  
  private boolean bo(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 2) && (paramInt2 == -2);
  }
  
  public static LoadExtResult create(int paramInt1, int paramInt2)
  {
    return create(paramInt1, paramInt2, false, true, null, null);
  }
  
  public static LoadExtResult create(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    int i = 0;
    LoadExtResult localLoadExtResult = new LoadExtResult();
    localLoadExtResult.soNum = paramInt2;
    localLoadExtResult.resCode = paramInt1;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      localLoadExtResult.downloadSoNum = paramInt2;
      localLoadExtResult.isFirstlyLoad = paramBoolean2;
      if (localLoadExtResult.resCode != 0) {
        break label127;
      }
    }
    label127:
    for (paramInt2 = i;; paramInt2 = 1)
    {
      localLoadExtResult.failIndex = paramInt2;
      if (!TextUtils.isEmpty(paramString1))
      {
        localLoadExtResult.reportStr = (paramString1 + "=" + paramInt1);
        if (!TextUtils.isEmpty(paramString2)) {
          localLoadExtResult.soPaths.put(paramString1, paramString2);
        }
      }
      return localLoadExtResult;
      paramInt2 = 0;
      break;
    }
  }
  
  public static LoadExtResult mergeExtResult(LoadExtResult paramLoadExtResult1, LoadExtResult paramLoadExtResult2)
  {
    if (paramLoadExtResult2 == null) {
      return paramLoadExtResult1;
    }
    return paramLoadExtResult2.a(paramLoadExtResult1);
  }
  
  public long getDelayAyncTime()
  {
    if ((this.failInfo != null) && (this.failInfo.amf != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoadExtResult", 2, "[getDelayAyncTime]FailInfo:" + this.failInfo);
      }
      if ((!bn(this.failInfo.dJZ, this.failInfo.dKa)) && (!bo(this.failInfo.dJZ, this.failInfo.dKa))) {
        break label164;
      }
      int i = aqiw.getNetworkType(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.i("LoadExtResult", 2, "[getDelayAyncTime]curNetType:" + i);
      }
      if (this.failInfo.netType == i) {}
    }
    else
    {
      return 0L;
    }
    label164:
    for (long l = 300000L;; l = 600000L) {
      return l + this.failInfo.amf - NetConnInfoCenter.getServerTimeMillis();
    }
  }
  
  public int getReportCode()
  {
    int j = this.soNum;
    int k = this.resCode;
    int m = this.failIndex;
    int n = this.downloadSoNum;
    if (this.isFirstlyLoad) {}
    for (int i = 0;; i = 1) {
      return i + (n * 10 + (j * 100000 + k * 1000 + m * 100));
    }
  }
  
  public String getReportStr()
  {
    return this.reportStr;
  }
  
  public int getResultCode()
  {
    return this.resCode;
  }
  
  public String getSoLoadPath(String paramString)
  {
    return (String)this.soPaths.get(paramString);
  }
  
  public boolean isSucc()
  {
    return this.resCode == 0;
  }
  
  public void setFailIndex(int paramInt)
  {
    this.failIndex = paramInt;
  }
  
  public String toString()
  {
    return "LRes{rCode=" + this.resCode + ",isSucc=" + isSucc() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.LoadExtResult
 * JD-Core Version:    0.7.0.1
 */