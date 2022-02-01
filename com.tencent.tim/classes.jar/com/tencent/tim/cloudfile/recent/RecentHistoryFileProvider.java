package com.tencent.tim.cloudfile.recent;

import atgi;
import atmo;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class RecentHistoryFileProvider
{
  private a a;
  private String ajb;
  private QQAppInterface mApp;
  
  public RecentHistoryFileProvider(QQAppInterface paramQQAppInterface, String paramString, a parama)
  {
    this.mApp = paramQQAppInterface;
    this.ajb = paramString;
    this.a = parama;
  }
  
  private void a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {
      bool = false;
    }
    if (this.a != null) {
      this.a.a(this.ajb, bool, paramCloudHistoryInfo.historyId, paramCloudHistoryInfo, paramObject);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3)
  {
    ThreadManager.postImmediately(new FetchRecentFileTask(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3), null, true);
  }
  
  public void nM(List<CloudHistoryInfo> paramList)
  {
    ThreadManager.postImmediately(new RecentHistoryFileProvider.1(this, paramList), null, true);
  }
  
  public class FetchRecentFileTask
    implements Runnable
  {
    private long ayq;
    private long ayr;
    private int fileType;
    private long fromTime;
    private int limit;
    private int operateType;
    
    public FetchRecentFileTask(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3)
    {
      this.fileType = paramInt1;
      this.limit = paramInt2;
      this.operateType = paramInt3;
      this.ayq = paramLong1;
      this.fromTime = paramLong2;
      this.ayr = paramLong3;
    }
    
    public void run()
    {
      int j = 63;
      if (QLog.isColorLevel()) {
        QLog.e("RecentHistoryFileProvider", 1, "waterchen fetch thread will be start. threadId[" + Thread.currentThread().getId() + "]");
      }
      int i = j;
      switch (this.fileType)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RecentHistoryFileProvider", 1, "waterchen getRecentFileList : fileType[" + i + "] hID[" + this.ayq + "] hFromTime[" + this.fromTime + "] hSeq[" + this.ayr + "]");
        }
        atgi.a().a(i, this.limit, this.ayq, this.fromTime, this.ayr, new atmo(this, i));
        return;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 8;
        continue;
        i = 52;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, List<CloudHistoryInfo> paramList, boolean paramBoolean, int paramInt, String paramString2);
    
    public abstract void a(String paramString, boolean paramBoolean, long paramLong, CloudHistoryInfo paramCloudHistoryInfo, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider
 * JD-Core Version:    0.7.0.1
 */