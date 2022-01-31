package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationProxy;
import com.tencent.mobileqq.app.message.MsgProxyContainer;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportControllerImpl.ReportProxyAdapter;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import dad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

public class ProxyManager
  implements Manager
{
  static final int jdField_a_of_type_Int = 10000;
  private static final String jdField_a_of_type_JavaLangString = "Q.msg.MsgProxy";
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = new Class[0];
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private DBDelayManager jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager;
  private ConversationProxy jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy;
  private MsgProxyContainer jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer;
  private MultiMsgProxy jdField_a_of_type_ComTencentMobileqqAppMessageMultiMsgProxy;
  private DataLineMsgProxy jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
  private MpfileTaskProxy jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy;
  private RecentUserProxy jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
  private FileManagerProxy jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy;
  private UniformDownloadBPTransProxy jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy;
  private ReportControllerImpl.ReportProxyAdapter jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter;
  private Thread jdField_a_of_type_JavaLangThread;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public final Vector a;
  public boolean a;
  private BaseProxy[] jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy;
  private boolean b = false;
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager = paramQQAppInterface.a().a();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer = new MsgProxyContainer(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMultiMsgProxy = new MultiMsgProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy = new DataLineMsgProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy = new MpfileTaskProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy = new FileManagerProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy = new UniformDownloadBPTransProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter = new ReportControllerImpl.ReportProxyAdapter(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy = new ConversationProxy(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = new RecentUserProxy(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy = new BaseProxy[] { this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer, this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy, this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy, this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy };
    this.jdField_a_of_type_JavaLangThread = new Thread(new dad(this));
    this.jdField_a_of_type_Boolean = false;
  }
  
  private SQLiteDatabase a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ProxyObserver)localIterator.next()).a(paramInt);
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    int i;
    if (!this.b)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
      if (i != 0) {
        break label84;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L)
      {
        this.b = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "isSaveDBAtOnce timeout30s isSaveDBAtOnceFlag:" + this.b);
        }
      }
      bool1 = false;
    }
    label84:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (i != 1);
      this.b = true;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MsgProxy", 2, "isSaveDBAtOnce unActionLoginB isSaveDBAtOnceFlag:" + this.b);
    return true;
  }
  
  private boolean a(BaseProxy paramBaseProxy)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      try
      {
        if (i < jdField_a_of_type_ArrayOfJavaLangClass.length)
        {
          Class localClass1 = paramBaseProxy.getClass();
          Class localClass2 = jdField_a_of_type_ArrayOfJavaLangClass[i];
          if (localClass1 == localClass2) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  private void g()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy.length) && (!this.jdField_a_of_type_Boolean)) {
          if (a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i]))
          {
            this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i]);
          }
          else
          {
            TraceUtils.a("i." + this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i]);
            long l = System.currentTimeMillis();
            this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i].a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i].getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
            }
            TraceUtils.a();
          }
        }
      }
      finally {}
      return;
      i += 1;
    }
  }
  
  public ConversationProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationProxy;
  }
  
  public MsgProxyContainer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxyContainer;
  }
  
  public MultiMsgProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageMultiMsgProxy;
  }
  
  public DataLineMsgProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy;
  }
  
  public MpfileTaskProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyMpfileTaskProxy;
  }
  
  public RecentUserProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
  }
  
  public FileManagerProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy;
  }
  
  public UniformDownloadBPTransProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTransProxy;
  }
  
  public ReportControllerImpl.ReportProxyAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$ReportProxyAdapter;
  }
  
  public Vector a()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          boolean bool = this.jdField_a_of_type_JavaUtilSet.isEmpty();
          if (!bool) {}
        }
        else
        {
          return;
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        if (localIterator.hasNext())
        {
          BaseProxy localBaseProxy = (BaseProxy)localIterator.next();
          TraceUtils.a("i." + localBaseProxy);
          long l = System.currentTimeMillis();
          localBaseProxy.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localBaseProxy.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
          }
          TraceUtils.a();
        }
        else
        {
          this.jdField_a_of_type_JavaUtilSet.clear();
        }
      }
      finally {}
    }
  }
  
  public void a(ProxyObserver paramProxyObserver)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramProxyObserver)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramProxyObserver);
    }
  }
  
  public void a(EntityManager paramEntityManager)
  {
    for (;;)
    {
      Object localObject2;
      EntityTransaction localEntityTransaction;
      MsgQueueItem localMsgQueueItem;
      String str;
      ProxyListener localProxyListener;
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "transSaveToDatabase writeRunable msgQueue size:" + this.jdField_a_of_type_JavaUtilVector.size());
        }
        if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {
          return;
        }
        Object localObject3 = (List)this.jdField_a_of_type_JavaUtilVector.clone();
        this.jdField_a_of_type_JavaUtilVector.clear();
        if (localObject3 != null)
        {
          localObject2 = null;
          ??? = null;
        }
        try
        {
          localEntityTransaction = paramEntityManager.a();
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localEntityTransaction.a();
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localObject3 = ((List)localObject3).iterator();
        }
        catch (Exception paramEntityManager)
        {
          localObject2 = ???;
          paramEntityManager.printStackTrace();
          localObject2 = ???;
          a(1001);
          localObject2 = ???;
          if (!QLog.isColorLevel()) {
            break label391;
          }
          localObject2 = ???;
          QLog.w("Q.msg.MsgProxy", 2, "writeRunable write exception: " + paramEntityManager.getMessage());
          if (??? == null) {
            break label399;
          }
          ((EntityTransaction)???).b();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
          return;
          paramEntityManager = finally;
          throw paramEntityManager;
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          paramEntityManager.b(localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
          if (localProxyListener == null) {
            continue;
          }
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localProxyListener.a(str);
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label466;
          }
          localObject2.b();
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (((Iterator)localObject3).hasNext())
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localMsgQueueItem = (MsgQueueItem)((Iterator)localObject3).next();
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          str = localMsgQueueItem.b;
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localProxyListener = localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener;
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          if (QLog.isColorLevel())
          {
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            QLog.d("Q.msg.MsgProxy", 2, "writeRunable QueueItem.action: " + localMsgQueueItem.i);
          }
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          switch (localMsgQueueItem.i)
          {
          case 0: 
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            paramEntityManager.b(localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
            if (localProxyListener == null) {
              continue;
            }
            ??? = localEntityTransaction;
            localObject2 = localEntityTransaction;
            localProxyListener.a(str);
          }
        }
      }
      for (;;)
      {
        label391:
        label399:
        label466:
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (QLog.isColorLevel())
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          QLog.d("StatusPush", 2, "ProxyManager batch save uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + " : " + str);
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        SQLiteDatabase localSQLiteDatabase = a();
        if (localSQLiteDatabase == null) {
          break;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        int i = localSQLiteDatabase.a(str, localMsgQueueItem.jdField_a_of_type_AndroidContentContentValues, localMsgQueueItem.c, localMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString);
        if (localProxyListener == null) {
          break;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener.a(str, i);
        break;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        paramEntityManager.a(localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
        if (localProxyListener == null) {
          break;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener.a(str, 1);
        break;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        i = a().a(str, localMsgQueueItem.c, localMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString);
        if (localProxyListener == null) {
          break;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener.b(str, i);
        break;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        paramEntityManager.b(localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
        if (localProxyListener == null) {
          break;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener.b(str, 1);
        break;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        i = a().a(str, localMsgQueueItem.c, localMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString);
        if (localProxyListener == null) {
          break;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener.b(str, i);
        break;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.c();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        a(1000);
        if (localEntityTransaction != null) {
          localEntityTransaction.b();
        }
      }
    }
  }
  
  public void a(String arg1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    paramString2 = new MsgQueueItem(???, paramInt1, paramString2, paramContentValues, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramString2);
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
          }
          e();
          return;
        }
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) && (ReflectionUtil.a(BaseApplicationImpl.a)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
    }
    e();
  }
  
  public void a(String arg1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    paramString2 = new MsgQueueItem(???, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramString2);
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
          }
          e();
          return;
        }
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) && (ReflectionUtil.a(BaseApplicationImpl.a)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue write notify");
    }
    e();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    a(paramString1, paramInt1, paramString2, null, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangThread != null) && (this.jdField_a_of_type_JavaLangThread.getState() == Thread.State.NEW))
    {
      g();
      this.jdField_a_of_type_JavaLangThread.setName("QQ_DB");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  public void b(ProxyObserver paramProxyObserver)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramProxyObserver)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramProxyObserver);
    }
  }
  
  public void b(String arg1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    paramString2 = new MsgQueueItem(???, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramString2);
      e();
      return;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "transSaveToDatabase");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).createEntityManager();
    a(localEntityManager);
    localEntityManager.a();
  }
  
  public void c(String arg1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    paramString2 = new MsgQueueItem(???, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramString2);
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "addMsgQueue after destroy");
        }
        e();
      }
      return;
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.clear();
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.c();
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.notify();
      return;
    }
  }
  
  public void f()
  {
    a(2000);
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      c();
      if (this.jdField_a_of_type_JavaUtilVector != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (this.jdField_a_of_type_JavaUtilVector != null) {
          this.jdField_a_of_type_JavaUtilVector.notify();
        }
        int i = 0;
        if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppProxyBaseProxy[i].b();
          i += 1;
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyManager
 * JD-Core Version:    0.7.0.1
 */