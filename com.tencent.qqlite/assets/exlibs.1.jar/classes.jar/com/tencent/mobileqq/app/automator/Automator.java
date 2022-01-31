package com.tencent.mobileqq.app.automator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.app.QQBroadcastReceiver;

public class Automator
  extends BusinessHandler
  implements Runnable
{
  public static final int a = 1;
  public static final String a = "QQInitHandler";
  private static Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  public static final boolean a = true;
  public static final int b = 2;
  public static final String b = "acc_info";
  public static final boolean b = false;
  public static final int c = 3;
  public static final String c = "isConvertOldQQHeadOK";
  public static final String d = "isFriendlistok";
  public static final String e = "isTrooplistok";
  public static final int f = 40001;
  public static final String f = "isPublicAccountListOK";
  public static final int g = 1;
  public static final String g = "isDiscussionlistok";
  public static final int h = 2;
  public static final String h = "isFirstQQInit";
  public static final int i = 3;
  private static final boolean i = true;
  private static final int j = 3;
  public long a;
  public SharedPreferences a;
  private LinearGroup jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public Timer a;
  private LinkedList b = new LinkedList();
  public boolean c = false;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public boolean f = false;
  public boolean g = false;
  private volatile boolean h;
  private int k = 0;
  
  public Automator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilTimer = null;
  }
  
  private void a(LinearGroup paramLinearGroup)
  {
    boolean bool = true;
    if ("{{4,3,5,6},[11,13],16,19,20,21,36,37,[49,24,10,25,26,27,28,29,30,32,33,34,35,39,40,45,41,43,44,48,50],46,51}".equals(paramLinearGroup.b)) {
      this.b.clear();
    }
    do
    {
      if (bool) {
        this.b.add(paramLinearGroup);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addWaitingMode_Locked " + paramLinearGroup.b + " " + bool);
      }
      return;
      if ((!"{[12,15],18,20,22,38,47,48}".equals(paramLinearGroup.b)) && (!"{14,17,20,23}".equals(paramLinearGroup.b))) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null);
    bool = StepFactory.b(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup);
    Iterator localIterator = this.b.iterator();
    label125:
    if (localIterator.hasNext())
    {
      LinearGroup localLinearGroup = (LinearGroup)localIterator.next();
      if ((!"{{4,3,5,6},[11,13],16,19,20,21,36,37,[49,24,10,25,26,27,28,29,30,32,33,34,35,39,40,45,41,43,44,48,50],46,51}".equals(localLinearGroup.b)) && (!localLinearGroup.b.equals(paramLinearGroup.b))) {
        break label243;
      }
      bool = false;
    }
    label243:
    for (;;)
    {
      break label125;
      break;
      if (!"{{4,3,5,6},36,37,[49,24,10,25,26,27,28,29,30,32,33,34,35,39,40,45,41,43,44,48,50],46}".equals(paramLinearGroup.b)) {
        break;
      }
      localIterator = this.b.iterator();
      bool = true;
      if (localIterator.hasNext())
      {
        if ("{{4,3,5,6},[11,13],16,19,20,21,36,37,[49,24,10,25,26,27,28,29,30,32,33,34,35,39,40,45,41,43,44,48,50],46,51}".equals(((LinearGroup)localIterator.next()).b)) {
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
  
  public static void g()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "trySuicide true, " + ((QQAppInterface)localObject).isBackground_Pause + ", " + ((QQAppInterface)localObject).isBackground_Stop + " with " + BaseActivity.sTopActivity);
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((((QQAppInterface)localObject).isBackground_Pause) && (((QQAppInterface)localObject).isBackground_Stop) && (localBaseActivity != null))
    {
      localObject = new Intent("com.tencent.qqlite.broadcast.qq");
      ((Intent)localObject).putExtra("k_start_mode", 1);
      localBaseActivity.sendBroadcast((Intent)localObject);
      localObject = new Intent(localBaseActivity, QQBroadcastReceiver.class);
      ((Intent)localObject).putExtra("k_start_mode", 1);
      localBaseActivity.sendBroadcast((Intent)localObject);
      System.exit(0);
    }
  }
  
  public int a()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup);
    }
    if (this.h) {
      return 1;
    }
    return -1;
  }
  
  public AsyncStep a(ArrayList paramArrayList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          AsyncStep localAsyncStep = (AsyncStep)paramArrayList.next();
          if (this.jdField_a_of_type_JavaUtilLinkedList.remove(localAsyncStep)) {
            return localAsyncStep;
          }
        }
      }
      return null;
    }
  }
  
  public CheckUpdateItemInterface a(int paramInt)
  {
    return (CheckUpdateItemInterface)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  protected Class a()
  {
    return AutomatorObserver.class;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.k -= 1;
      AsyncStep localAsyncStep = (AsyncStep)this.jdField_a_of_type_JavaUtilLinkedList.poll();
      if (localAsyncStep != null) {
        b(localAsyncStep);
      }
      return;
    }
  }
  
  public void a(int paramInt, CheckUpdateItemInterface paramCheckUpdateItemInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramCheckUpdateItemInterface);
  }
  
  public void a(AsyncStep arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "start " + ???.b);
    }
    LinearGroup localLinearGroup = (LinearGroup)???;
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = localLinearGroup;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "run " + localLinearGroup.b);
        }
        if (jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
          jdField_a_of_type_JavaUtilConcurrentExecutor = new ThreadPoolExecutor(0, 4, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24));
        }
        jdField_a_of_type_JavaUtilConcurrentExecutor.execute(this);
        return;
      }
      a(localLinearGroup);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    new RuntimeException("u should never be here");
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramBoolean)) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFriendlistok", false).commit();
    }
    StringBuilder localStringBuilder = new StringBuilder().append("{");
    if (paramBoolean) {}
    for (int m = 7;; m = 8)
    {
      a(StepFactory.a(this, m + "}"));
      return;
    }
  }
  
  public boolean a()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup);
    }
    return true;
  }
  
  public void b()
  {
    a(0, true, null);
  }
  
  protected void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.k < 3)
      {
        this.k += 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramAsyncStep);
        return;
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramAsyncStep);
    }
  }
  
  public boolean b()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.b(localLinearGroup);
    }
    return true;
  }
  
  public void c()
  {
    if (!this.h) {}
    for (;;)
    {
      return;
      boolean bool1 = true;
      boolean bool2 = true;
      LinkedList localLinkedList;
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
      {
        localLinkedList = this.b;
        bool1 = bool2;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.a(4);
          bool1 = b();
        }
        if (!bool1) {
          continue;
        }
        a(StepFactory.a(this, "{[12,15],18,20,22,38,47,48}"));
        return;
      }
      finally {}
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onDestroy");
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.k = 0;
    }
    synchronized (this.b)
    {
      this.b.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.a(8);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = null;
      }
      this.jdField_a_of_type_Long = 0L;
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void e()
  {
    a(StepFactory.a(this, "{14,17,20,23}"));
  }
  
  public void f()
  {
    a(4, true, null);
  }
  
  public void run()
  {
    int m;
    if (!this.h) {
      m = 0;
    }
    for (;;)
    {
      synchronized (this.b)
      {
        if (!this.h)
        {
          m = 1;
          this.h = true;
        }
        if (m != 0) {
          StepFactory.a(this, "2").run();
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
        if (??? != null) {
          ((AsyncStep)???).run();
        }
      }
      synchronized (this.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = ((LinearGroup)this.b.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null)
        {
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.Automator
 * JD-Core Version:    0.7.0.1
 */