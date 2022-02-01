package com.tencent.mobileqq.app.automator;

import acbo;
import accg;
import acci;
import acoo;
import andh;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.Constants.Key;

public class Automator
  extends accg
  implements Runnable
{
  private static ThreadPoolExecutor h;
  protected LinkedList<AsyncStep> M = new LinkedList();
  private LinkedList<LinearGroup> N = new LinkedList();
  public SharedPreferences O;
  public long Ra;
  private LinearGroup a;
  private volatile boolean bJI;
  public boolean bJJ;
  public boolean bJK;
  public boolean bJL;
  public int cyA;
  protected int cyB;
  public int cyz = 1;
  public ConcurrentHashMap<String, Long> ew = new ConcurrentHashMap(16);
  private HashMap<Integer, andh> ji = new LinkedHashMap();
  
  public Automator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(LinearGroup paramLinearGroup)
  {
    boolean bool = true;
    if ("{86,{4,3,5,6},[11,12,14],17,20,21,22,114,109,44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58,96,106}".equals(paramLinearGroup.mName)) {
      this.N.clear();
    }
    do
    {
      if (bool) {
        this.N.add(paramLinearGroup);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addWaitingMode_Locked " + paramLinearGroup.mName + " " + bool);
      }
      return;
      if ((!"{[13,16],19,21,90,23,47,33,62,93,97,98}".equals(paramLinearGroup.mName)) && (!"{15,18,21,24}".equals(paramLinearGroup.mName))) {
        break;
      }
    } while (this.a == null);
    bool = abU();
    Iterator localIterator = this.N.iterator();
    label122:
    if (localIterator.hasNext())
    {
      AsyncStep localAsyncStep = (AsyncStep)localIterator.next();
      if ((!"{86,{4,3,5,6},[11,12,14],17,20,21,22,114,109,44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58,96,106}".equals(localAsyncStep.mName)) && (!localAsyncStep.mName.equals(paramLinearGroup.mName))) {
        break label240;
      }
      bool = false;
    }
    label240:
    for (;;)
    {
      break label122;
      break;
      if (!"{{4,3,5,6},44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58}".equals(paramLinearGroup.mName)) {
        break;
      }
      localIterator = this.N.iterator();
      bool = true;
      if (localIterator.hasNext())
      {
        if ("{86,{4,3,5,6},[11,12,14],17,20,21,22,114,109,44,46,[66,25,10,28,29,30,32,34,35,39,40,41,42,43,48,49,51,94,71,72,{92},54,55,62,78,75,36,37,38,89,85,99,103,104,111,45,115],58,96,106}".equals(((AsyncStep)localIterator.next()).mName)) {
          bool = false;
        }
        for (;;)
        {
          break;
        }
      }
      break;
    }
  }
  
  public int Bd()
  {
    LinearGroup localLinearGroup = this.a;
    if (localLinearGroup != null) {
      return acoo.a(localLinearGroup, false);
    }
    if (this.bJI) {
      return 1;
    }
    return -1;
  }
  
  public HashMap<Integer, andh> E()
  {
    return this.ji;
  }
  
  public boolean He()
  {
    LinearGroup localLinearGroup = this.a;
    if (localLinearGroup != null) {
      if (acoo.a(localLinearGroup, true) != 0) {}
    }
    while (!this.bJI)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public andh a(int paramInt)
  {
    return (andh)this.ji.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, andh paramandh)
  {
    this.ji.put(Integer.valueOf(paramInt), paramandh);
  }
  
  @TargetApi(9)
  public void a(AsyncStep arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "start " + ???.mName);
    }
    LinearGroup localLinearGroup = (LinearGroup)???;
    synchronized (this.N)
    {
      if (this.a == null)
      {
        this.a = localLinearGroup;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "run " + localLinearGroup.mName);
        }
        if (h == null)
        {
          h = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new a(null));
          if (Build.VERSION.SDK_INT > 8) {
            h.allowCoreThreadTimeOut(true);
          }
        }
        h.execute(this);
        return;
      }
      a(localLinearGroup);
    }
  }
  
  public void a(AsyncStep[] paramArrayOfAsyncStep)
  {
    for (;;)
    {
      int i;
      synchronized (this.M)
      {
        this.cyB -= 1;
        if (this.M.size() > 0)
        {
          if (paramArrayOfAsyncStep != null)
          {
            int j = paramArrayOfAsyncStep.length;
            i = 0;
            if (i < j)
            {
              AsyncStep localAsyncStep = paramArrayOfAsyncStep[i];
              if (!this.M.remove(localAsyncStep)) {
                break label94;
              }
              b(localAsyncStep);
              return;
            }
          }
          b((AsyncStep)this.M.poll());
        }
        else
        {
          return;
        }
      }
      label94:
      i += 1;
    }
  }
  
  public boolean abS()
  {
    if (!StartService.cIM) {
      return false;
    }
    LinearGroup localLinearGroup = this.a;
    if (localLinearGroup != null) {
      return acoo.a(localLinearGroup);
    }
    return true;
  }
  
  public boolean abT()
  {
    LinearGroup localLinearGroup = this.a;
    if (localLinearGroup != null) {
      return acoo.b(localLinearGroup);
    }
    return true;
  }
  
  public boolean abU()
  {
    LinearGroup localLinearGroup = this.a;
    if (localLinearGroup != null) {
      return acoo.c(localLinearGroup);
    }
    return true;
  }
  
  @TargetApi(9)
  public void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.M)
    {
      if (this.cyB < 3)
      {
        this.cyB += 1;
        if (h == null)
        {
          h = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new a(null));
          if (Build.VERSION.SDK_INT > 8) {
            h.allowCoreThreadTimeOut(true);
          }
        }
        h.execute(paramAsyncStep);
        return;
      }
      this.M.add(paramAsyncStep);
    }
  }
  
  public void cNp()
  {
    notifyUI(0, true, null);
  }
  
  public void cNq()
  {
    if (!this.bJI) {}
    for (;;)
    {
      return;
      boolean bool1 = true;
      boolean bool2 = true;
      LinkedList localLinkedList;
      if (this.a != null)
      {
        localLinkedList = this.N;
        bool1 = bool2;
      }
      try
      {
        if (this.a != null)
        {
          this.a.setResult(4);
          bool1 = abU();
        }
        if (!bool1) {
          continue;
        }
        a(acoo.a(this, "{[13,16],19,21,90,23,47,33,62,93,97,98}"));
        return;
      }
      finally {}
    }
  }
  
  public void cNr()
  {
    a(acoo.a(this, "{15,18,21,24}"));
  }
  
  public void cNs()
  {
    notifyUI(4, true, null);
  }
  
  public void d(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    boolean bool = false;
    if ((this.O != null) && (paramBoolean1)) {
      this.O.edit().putBoolean("isFriendlistok", false).commit();
    }
    if (paramLong != 0L) {
      this.app.getPreferences().edit().putLong(Constants.Key.SvcRegister_timeStamp.toString(), paramLong).commit();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshAllList isListChanged=").append(paramBoolean1).append(",timeStamp=").append(paramLong).append(",accInfoPref!=null ");
      if (this.O != null) {
        bool = true;
      }
      QLog.d("QQInitHandler", 2, bool);
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      localStringBuilder = new StringBuilder().append("{");
      if (!paramBoolean1) {
        break label198;
      }
    }
    label198:
    for (int i = 7;; i = 8)
    {
      a(acoo.a(this, i + "}"));
      return;
    }
  }
  
  public Class<? extends acci> observerClass()
  {
    return acbo.class;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onDestroy");
    }
    synchronized (this.M)
    {
      this.M.clear();
      this.cyB = 0;
    }
    synchronized (this.N)
    {
      this.N.clear();
      if (this.a != null)
      {
        this.a.setResult(8);
        this.a = null;
      }
      this.Ra = 0L;
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    new RuntimeException("WTF");
  }
  
  public void run()
  {
    int i;
    if (!this.bJI) {
      i = 0;
    }
    for (;;)
    {
      synchronized (this.N)
      {
        if (!this.bJI)
        {
          i = 1;
          this.bJI = true;
        }
        if (i != 0) {
          acoo.a(this, "2").run();
        }
        ??? = this.a;
        if (??? != null) {
          ((AsyncStep)???).run();
        }
      }
      synchronized (this.N)
      {
        this.a = ((LinearGroup)this.N.poll());
        if (this.a == null)
        {
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
    }
  }
  
  static class a
    implements ThreadFactory
  {
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable, "Automator_" + this.threadNumber.getAndIncrement());
      if (paramRunnable.getPriority() != 10) {
        paramRunnable.setPriority(10);
      }
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.Automator
 * JD-Core Version:    0.7.0.1
 */