package com.tencent.mobileqq.statistics;

import acxq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import anfa;
import anot;
import anot.a;
import aqiw;
import aurf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;

public class ReportControllerImpl
  extends anot
  implements Handler.Callback, BusinessObserver
{
  private ProxyManager a;
  private volatile Boolean aE;
  private long amK;
  private QQAppInterface app;
  private aurf c;
  private final HashMap<String, Reporting> mReportings = new HashMap();
  private int mSeqKey;
  
  private ReportControllerImpl(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Create:" + paramQQAppInterface);
    }
    this.c = new aurf(ThreadManager.getSubThreadLooper(), this);
    try
    {
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "ActionReportInterval");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        this.amK = (Long.parseLong(paramQQAppInterface) * 1000L);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label99:
      break label99;
    }
    if (this.amK <= 1000L) {
      this.amK = 86400000L;
    }
  }
  
  private void V(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "addReporting:" + paramString2 + ", " + paramInt);
    }
    String str = paramString1 + ":" + paramString2;
    Reporting localReporting = (Reporting)this.mReportings.get(str);
    if (localReporting == null)
    {
      localReporting = new Reporting();
      localReporting.mTag = paramString1;
      localReporting.mDetail = paramString2;
      localReporting.mCount = paramInt;
      localReporting.mDetailHashCode = localReporting.mDetail.hashCode();
      this.mReportings.put(str, localReporting);
      if ((this.aE != null) && (this.aE.booleanValue())) {
        this.a.addMsgQueue("", 0, "Reporting", localReporting, 3, null);
      }
      paramString1 = localReporting;
      if (QLog.isColorLevel())
      {
        QLog.d("ReportController", 2, "handleAddReporting:r.mTag=" + localReporting.mTag + ", r.mDetail=" + localReporting.mDetail + ", r.mDetailHashCode=" + localReporting.mDetailHashCode);
        paramString1 = localReporting;
      }
      if (this.aE != null)
      {
        if (!this.aE.booleanValue()) {
          break label443;
        }
        if (this.mReportings.size() >= 40)
        {
          handleReport();
          if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "handleAddReporting: handleReport r.mTag=" + paramString1.mTag + ", r.mDetail=" + paramString1.mDetail + ", r.mDetailHashCode=" + paramString1.mDetailHashCode);
          }
        }
      }
    }
    label443:
    do
    {
      do
      {
        return;
        localReporting.mCount += paramInt;
        if ((this.aE != null) && (this.aE.booleanValue())) {
          this.a.addMsgQueue("", 0, "Reporting", localReporting.clone(), 4, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReportController", 2, "handleAddReporting:r.mTag=" + localReporting.mTag + ", r.mDetail=" + localReporting.mDetail + ", r.mDetailHashCode=" + localReporting.mDetailHashCode);
        }
        paramString1 = localReporting;
        break;
      } while (this.c.hasMessages(9528));
      this.c.sendEmptyMessage(9528);
    } while (!QLog.isColorLevel());
    QLog.d("ReportController", 2, "handleAddReporting: savedata r.mTag=" + paramString1.mTag + ", r.mDetail=" + paramString1.mDetail + ", r.mDetailHashCode=" + paramString1.mDetailHashCode);
  }
  
  public static anot a(QQAppInterface paramQQAppInterface)
  {
    return new ReportControllerImpl(paramQQAppInterface);
  }
  
  private boolean ayB()
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.sApplication)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "doReportClickEvent:" + this.app);
    }
    int k = this.mReportings.size();
    Object localObject1 = new ArrayList(20);
    Object localObject2 = new ArrayList(20);
    int i = nextSeqKey();
    Iterator localIterator = this.mReportings.keySet().iterator();
    int j = 0;
    Object localObject3;
    Reporting localReporting;
    if (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      localReporting = (Reporting)this.mReportings.get(localObject3);
      if ((localReporting.mDetailHashCode != 0) && (localReporting.mDetail.hashCode() != localReporting.mDetailHashCode))
      {
        localIterator.remove();
        this.a.addMsgQueue("", 0, "Reporting", localReporting, 5, null);
        k -= 1;
      }
      for (;;)
      {
        if ((j % 20 == 0) || (j >= k))
        {
          localObject3 = new NewIntent(this.app.getApplication(), anfa.class);
          ((NewIntent)localObject3).putExtra("sendType", 10);
          ((NewIntent)localObject3).putExtra("seqKey", i);
          ((NewIntent)localObject3).putExtra("tags", (Serializable)localObject1);
          ((NewIntent)localObject3).putExtra("retryTime", 0);
          ((NewIntent)localObject3).putExtra("contents", (Serializable)localObject2);
          ((NewIntent)localObject3).setObserver(this);
          this.app.startServlet((NewIntent)localObject3);
          localObject2 = new ArrayList(20);
          localObject1 = new ArrayList(20);
          if (j < k)
          {
            i = nextSeqKey();
            label313:
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
            if (pu(localReporting.mTag))
            {
              localObject3 = a(localReporting.mTag);
              if (localObject3 != null) {
                ((anot.a)localObject3).a(localReporting);
              }
              localIterator.remove();
              this.a.addMsgQueue("", 0, "Reporting", localReporting, 5, null);
              k -= 1;
              continue;
            }
            ((ArrayList)localObject1).add(localReporting.mTag);
            localObject3 = localReporting.mDetail.replace("${count_unknown}", String.valueOf(localReporting.mCount));
            if (!((String)localObject3).startsWith("${report_seq_prefix}")) {
              break label572;
            }
            localObject3 = ((String)localObject3).substring(((String)localObject3).indexOf("|") + 1);
          }
        }
      }
    }
    label572:
    for (;;)
    {
      ((ArrayList)localObject2).add(localObject3);
      localIterator.remove();
      this.a.addMsgQueue("", 0, "Reporting", localReporting, 5, null);
      if (QLog.isColorLevel()) {
        QLog.d("ReportController", 2, "Report: " + localReporting.mTag + ", " + (String)localObject3 + ", " + i);
      }
      j += 1;
      break;
      dSJ();
      return true;
      break label313;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label313;
    }
  }
  
  private void cFR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "handleInit:" + this.app);
    }
    Object localObject = this.app.a().createEntityManager().query(Reporting.class);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Reporting localReporting1 = (Reporting)((Iterator)localObject).next();
        String str = localReporting1.mTag + ":" + localReporting1.mDetail;
        Reporting localReporting2 = (Reporting)this.mReportings.get(str);
        if (localReporting2 != null)
        {
          int i = localReporting1.mCount;
          localReporting2.mCount += i;
        }
        this.mReportings.put(str, localReporting1);
      }
    }
  }
  
  private void dX(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "saveReportData:" + paramQQAppInterface);
    }
    Object localObject = this.mReportings.values();
    if ((localObject != null) && (((Collection)localObject).size() > 0)) {}
    try
    {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      EntityTransaction localEntityTransaction = paramQQAppInterface.getTransaction();
      localEntityTransaction.begin();
      for (;;)
      {
        Reporting localReporting;
        try
        {
          localObject = ((Collection)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            localReporting = (Reporting)((Iterator)localObject).next();
            if (localReporting.getStatus() == 1000) {
              paramQQAppInterface.persistOrReplace(localReporting);
            }
          }
          else
          {
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localEntityTransaction.commit();
          localEntityTransaction.end();
          paramQQAppInterface.close();
        }
        paramQQAppInterface.update(localReporting);
      }
      return;
    }
    catch (Throwable paramQQAppInterface) {}
  }
  
  private void handleReport()
  {
    this.c.removeMessages(9527);
    try
    {
      ayB();
      Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences(this.app.getAccount(), 0);
      long l = System.currentTimeMillis();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("pre_report_time", l);
      ((SharedPreferences.Editor)localObject).commit();
      this.c.sendEmptyMessageDelayed(9527, this.amK);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ReportController", 4, "report exception:" + localException);
        }
      }
    }
  }
  
  private int nextSeqKey()
  {
    for (;;)
    {
      try
      {
        if (this.mSeqKey <= 0)
        {
          this.mSeqKey = (new Random().nextInt(1000000) + 100);
          int i = this.mSeqKey;
          return i;
        }
        if (this.mSeqKey >= 1000100) {
          this.mSeqKey = 100;
        } else {
          this.mSeqKey += 1;
        }
      }
      finally {}
    }
  }
  
  public void U(String paramString1, String paramString2, int paramInt)
  {
    b localb = new b();
    localb.mTag = paramString1;
    localb.mDetail = paramString2;
    localb.mCount = paramInt;
    this.c.obtainMessage(9529, localb).sendToTarget();
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    this.app = paramQQAppInterface;
    this.a = paramProxyManager;
    this.aE = Boolean.valueOf(true);
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Init:" + paramQQAppInterface);
    }
    this.c.sendEmptyMessage(9530);
  }
  
  protected void b(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    this.aE = Boolean.valueOf(false);
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Destory:" + paramQQAppInterface);
    }
    this.c.sendEmptyMessage(9528);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9529)
    {
      paramMessage = (b)paramMessage.obj;
      V(paramMessage.mTag, paramMessage.mDetail, paramMessage.mCount);
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 9527) {
        handleReport();
      } else if (paramMessage.what == 9528) {
        dX(this.app);
      } else if (paramMessage.what == 9530) {
        cFR();
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10)
    {
      int i = paramBundle.getInt("seqKey");
      paramInt = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReportController", 2, "OnReceive: isSuccess-" + paramBoolean + ", seqKey = " + i);
      }
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      QQAppInterface localQQAppInterface = this.app;
      if ((!paramBoolean) && (paramInt < 2) && (localQQAppInterface != null))
      {
        NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), anfa.class);
        localNewIntent.putExtra("sendType", 10);
        localNewIntent.putExtra("seqKey", i);
        localNewIntent.putExtra("tags", paramBundle.getStringArrayList("tags"));
        localNewIntent.putExtra("contents", paramBundle.getStringArrayList("contents"));
        localNewIntent.putExtra("retryTime", paramInt + 1);
        localNewIntent.setObserver(this);
        localQQAppInterface.startServlet(localNewIntent);
      }
    }
  }
  
  public void start(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      if (this.app.getAccount() != null)
      {
        localObject = this.app.getAccount();
        localObject = localBaseApplicationImpl.getSharedPreferences((String)localObject, 0);
        long l = System.currentTimeMillis();
        if (Math.abs(l - ((SharedPreferences)localObject).getLong("pre_report_time", l)) >= this.amK) {
          break label75;
        }
      }
    }
    label75:
    while (this.c.hasMessages(9527))
    {
      return;
      localObject = "10000";
      break;
    }
    this.c.sendEmptyMessage(9527);
  }
  
  public void stop()
  {
    this.c.removeMessages(9527);
  }
  
  public static class a
    extends acxq
  {
    public a(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
    {
      super(paramProxyManager);
    }
    
    public void destory()
    {
      anot localanot = this.app.a();
      if ((localanot != null) && ((localanot instanceof ReportControllerImpl))) {
        ((ReportControllerImpl)localanot).b(this.app, this.a);
      }
    }
    
    public void init()
    {
      anot localanot = this.app.a();
      if ((localanot != null) && ((localanot instanceof ReportControllerImpl))) {
        ((ReportControllerImpl)localanot).a(this.app, this.a);
      }
    }
  }
  
  public static class b
  {
    public int mCount;
    public String mDetail;
    public String mTag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportControllerImpl
 * JD-Core Version:    0.7.0.1
 */