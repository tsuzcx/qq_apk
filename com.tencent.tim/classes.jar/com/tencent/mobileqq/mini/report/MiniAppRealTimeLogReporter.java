package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniAppRealTimeLogReporter
{
  public static final int MAX_PAGE_COUNT = 10;
  private static final String TAG = "[mini] MiniAppRealTimeLogReporter";
  public static MiniAppRealTimeLogReporter instance;
  private static byte[] lock = new byte[0];
  private List<RealTimeLog> allLogs = new LinkedList();
  
  private RealTimeLog findLogByPage(int paramInt)
  {
    Object localObject;
    if (this.allLogs != null)
    {
      localObject = this.allLogs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RealTimeLog localRealTimeLog = (RealTimeLog)((Iterator)localObject).next();
        if (localRealTimeLog.page == paramInt) {
          return localRealTimeLog;
        }
      }
    }
    if (this.allLogs.size() <= 10)
    {
      localObject = new RealTimeLog(paramInt);
      this.allLogs.add(localObject);
      return localObject;
    }
    return null;
  }
  
  public static MiniAppRealTimeLogReporter getInstance()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new MiniAppRealTimeLogReporter();
      }
      return instance;
    }
  }
  
  private RealTimeLog getLogById(int paramInt)
  {
    Iterator localIterator = this.allLogs.iterator();
    while (localIterator.hasNext())
    {
      RealTimeLog localRealTimeLog = (RealTimeLog)localIterator.next();
      if (localRealTimeLog.page == paramInt) {
        return localRealTimeLog;
      }
    }
    return null;
  }
  
  private boolean report(int paramInt1, JSONArray paramJSONArray, int paramInt2, long paramLong, String paramString)
  {
    RealTimeLog localRealTimeLog = findLogByPage(paramInt1);
    if (localRealTimeLog == null)
    {
      QLog.e("[mini] MiniAppRealTimeLogReporter", 1, "current log has reached its max size");
      return false;
    }
    paramInt1 = QzoneConfig.getInstance().getConfig("qqminiapp", "RealTimeLogMaxContentSize", 5120);
    int i = QzoneConfig.getInstance().getConfig("qqminiapp", "RealTimeLogMaxCallNum", 200);
    if (localRealTimeLog.curLogContentSize >= paramInt1)
    {
      QLog.e("[mini] MiniAppRealTimeLogReporter", 1, "current log content has reached its current max size");
      return false;
    }
    if (localRealTimeLog.logitems.size() >= i)
    {
      QLog.e("[mini] MiniAppRealTimeLogReporter", 1, "current log item size has reached its current max size");
      return false;
    }
    localRealTimeLog.filterMsg = paramJSONArray;
    if (localRealTimeLog.curLogContentSize + paramString.length() > paramInt1)
    {
      i = localRealTimeLog.curLogContentSize;
      int j = paramString.length();
      localRealTimeLog.logitems.add(new RealTimeLogItem(paramLong, paramInt2, "UserLog:fail Log Size " + (i + j - paramInt1) + " Exceed"));
    }
    localRealTimeLog.logitems.add(new RealTimeLogItem(paramLong, paramInt2, paramString));
    localRealTimeLog.curLogContentSize += paramString.length();
    return true;
  }
  
  public boolean flush(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    RealTimeLog localRealTimeLog = getLogById(paramInt);
    if (localRealTimeLog != null)
    {
      Object localObject = null;
      if (localRealTimeLog.filterMsg != null)
      {
        String[] arrayOfString = new String[localRealTimeLog.filterMsg.length()];
        paramInt = 0;
        for (;;)
        {
          localObject = arrayOfString;
          if (paramInt >= localRealTimeLog.filterMsg.length()) {
            break;
          }
          arrayOfString[paramInt] = localRealTimeLog.filterMsg.optString(paramInt, "");
          paramInt += 1;
        }
      }
      if (localRealTimeLog.logitems.size() > 0) {
        MiniAppCmdUtil.getInstance().realTimeLogReport(paramString1, paramString2, paramString3, localObject, localRealTimeLog.logitems, new MiniAppRealTimeLogReporter.1(this));
      }
      this.allLogs.remove(localRealTimeLog);
    }
    return true;
  }
  
  public boolean report(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      int i = localJSONObject.getInt("page");
      JSONArray localJSONArray = localJSONObject.getJSONArray("filterMsg");
      String str = localJSONObject.getString("content");
      boolean bool = report(i, localJSONArray, localJSONObject.getInt("level"), localJSONObject.getLong("time"), str);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] MiniAppRealTimeLogReporter", 1, "MiniAppRealTimeLogReporter.report failed:" + paramString);
    }
    return false;
  }
  
  public class RealTimeLog
  {
    public int curLogContentSize;
    public JSONArray filterMsg;
    public ArrayList<RealTimeLogItem> logitems = new ArrayList();
    public int page;
    
    public RealTimeLog(int paramInt)
    {
      this.page = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppRealTimeLogReporter
 * JD-Core Version:    0.7.0.1
 */