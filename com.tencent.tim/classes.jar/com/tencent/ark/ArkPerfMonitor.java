package com.tencent.ark;

import android.text.TextUtils;
import java.util.HashMap;

public class ArkPerfMonitor
{
  private static final ArkPerfMonitor _instance = new ArkPerfMonitor();
  private HashMap<PerfRecordKey, PerfRecord> _records = new HashMap();
  
  public static ArkPerfMonitor getInstance()
  {
    return _instance;
  }
  
  public void addRecord(String paramString1, String paramString2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (paramLong < 30L) {
      return;
    }
    synchronized (this._records)
    {
      PerfRecord localPerfRecord2 = (PerfRecord)this._records.get(new PerfRecordKey(paramString1, paramString2));
      PerfRecord localPerfRecord1 = localPerfRecord2;
      if (localPerfRecord2 == null)
      {
        localPerfRecord1 = new PerfRecord(null);
        this._records.put(new PerfRecordKey(paramString1, paramString2), localPerfRecord1);
      }
      localPerfRecord1.totalTime += paramLong;
      localPerfRecord1.count += 1;
      return;
    }
  }
  
  public void doReport(String paramString1, String paramString2, IReport paramIReport)
  {
    int i = 0;
    synchronized (this._records)
    {
      PerfRecord localPerfRecord = (PerfRecord)this._records.get(new PerfRecordKey(paramString1, paramString2));
      if (localPerfRecord != null)
      {
        i = (int)(localPerfRecord.totalTime / localPerfRecord.count);
        localPerfRecord.count = 0;
        localPerfRecord.totalTime = 0.0D;
      }
      if ((i != 0) && (paramIReport != null)) {
        paramIReport.report(paramString1, paramString2, i);
      }
      return;
    }
  }
  
  public static abstract interface IReport
  {
    public abstract void report(String paramString1, String paramString2, int paramInt);
  }
  
  static class PerfRecord
  {
    public int count = 1;
    public double totalTime = 0.0D;
  }
  
  static class PerfRecordKey
  {
    public final String appID;
    public final String view;
    
    PerfRecordKey(String paramString1, String paramString2)
    {
      this.appID = paramString1;
      this.view = paramString2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (PerfRecordKey)paramObject;
      } while ((this.appID.equals(paramObject.appID)) && (this.view.equals(paramObject.view)));
      return false;
    }
    
    public int hashCode()
    {
      return this.appID.hashCode() + this.view.hashCode();
    }
  }
  
  static class ReportItem
  {
    public String appID;
    int time;
    public String view;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkPerfMonitor
 * JD-Core Version:    0.7.0.1
 */