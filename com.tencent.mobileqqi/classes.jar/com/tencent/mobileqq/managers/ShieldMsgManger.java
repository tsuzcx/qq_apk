package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import gbd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class ShieldMsgManger
  implements Manager
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "ShieldMsgManger";
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private long b;
  private long c;
  
  public ShieldMsgManger(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      throw new IllegalArgumentException("ShieldMsgManger this.app = null");
    }
    new gbd(this).start();
  }
  
  private String a(String paramString)
  {
    String str2 = paramString.trim();
    String str1 = str2;
    if (!str2.startsWith("+"))
    {
      str1 = str2;
      if (str2.length() == 11) {
        str1 = "+86" + paramString;
      }
    }
    return str1;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          c();
        }
        if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramString != null) && (paramString.length() > 0))
        {
          if (paramInt != 2) {
            break label88;
          }
          str = a(paramString);
          paramString = (ShieldListInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if (paramString != null)
          {
            bool = paramString.isShieldMsg();
            return bool;
          }
        }
      }
      boolean bool = false;
      continue;
      label88:
      String str = paramString;
      if (paramInt == 1) {
        str = paramString;
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      paramEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return paramEntityManager.a(paramEntity);
  }
  
  private void b() {}
  
  private void c()
  {
    for (;;)
    {
      EntityManager localEntityManager;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        try
        {
          ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
          List localList = localEntityManager.a(ShieldListInfo.class);
          int i;
          if (localList == null)
          {
            i = 0;
            break label163;
            if (j < i)
            {
              ShieldListInfo localShieldListInfo = (ShieldListInfo)localList.get(j);
              if ((localShieldListInfo == null) || (localShieldListInfo.uin == null)) {
                break label168;
              }
              localConcurrentHashMap.put(localShieldListInfo.uin, localShieldListInfo);
              break label168;
            }
          }
          else
          {
            i = localList.size();
            break label163;
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = localConcurrentHashMap;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label138;
          }
          QLog.d("ShieldMsgManger", 2, localException.toString());
          localEntityManager.a();
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        finally
        {
          localObject2.a();
        }
        return;
      }
      label138:
      label163:
      int j = 0;
      continue;
      label168:
      j += 1;
    }
  }
  
  private void d()
  {
    this.b = 0L;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void e()
  {
    this.c = System.currentTimeMillis();
  }
  
  private void f()
  {
    long l1 = System.currentTimeMillis();
    this.b += 1L;
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = (Math.abs(l1 - this.c) + l2);
    if (QLog.isColorLevel()) {
      QLog.d("ShieldMsgManger", 2, "total_count = " + this.b + ", total_time = " + this.jdField_a_of_type_Long + ", average = " + String.valueOf(this.jdField_a_of_type_Long / this.b));
    }
  }
  
  public void a()
  {
    ((ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a();
  }
  
  public void a(int paramInt, List paramList)
  {
    ShieldListHandler localShieldListHandler = (ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17);
    int j = paramList.size();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    localShieldListHandler.a(paramInt, arrayOfLong);
  }
  
  public boolean a(String paramString)
  {
    b();
    boolean bool = a(1, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShieldMsgManger", 2, "isUinInShieldList:" + paramString + ",result:" + bool);
    }
    return bool;
  }
  
  public boolean a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return true;
    }
    for (;;)
    {
      EntityManager localEntityManager;
      EntityTransaction localEntityTransaction;
      int i;
      ShieldListInfo localShieldListInfo1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          c();
        }
        localEntityTransaction = localEntityManager.a();
        try
        {
          localEntityTransaction.a();
          int j = paramList.size();
          i = 0;
          if (i >= j) {
            break label333;
          }
          localShieldListInfo1 = (ShieldListInfo)paramList.get(i);
          localShieldListInfo2 = (ShieldListInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localShieldListInfo1.uin);
          if ((localShieldListInfo1.flags == 0) && (localShieldListInfo2 == null)) {
            break label349;
          }
          if ((localShieldListInfo2 != null) && ((localShieldListInfo2.getStatus() == 1001) || (localShieldListInfo2.getStatus() == 1002))) {
            if (localShieldListInfo1.flags != localShieldListInfo2.flags)
            {
              localShieldListInfo2.flags = localShieldListInfo1.flags;
              localShieldListInfo2.source_id = localShieldListInfo1.source_id;
              localShieldListInfo2.source_sub_id = localShieldListInfo1.source_sub_id;
              a(localEntityManager, localShieldListInfo2);
            }
          }
        }
        catch (Exception paramList)
        {
          ShieldListInfo localShieldListInfo2;
          paramList.printStackTrace();
          localEntityTransaction.b();
          bool = false;
          localEntityManager.a();
          b();
          return bool;
          if ((localShieldListInfo1.flags != 1) || (localShieldListInfo2.source_id == localShieldListInfo1.source_id)) {
            break label349;
          }
          localShieldListInfo2.flags = localShieldListInfo1.flags;
          localShieldListInfo2.source_id = localShieldListInfo1.source_id;
          localShieldListInfo2.source_sub_id = localShieldListInfo1.source_sub_id;
          a(localEntityManager, localShieldListInfo2);
        }
        finally
        {
          localEntityTransaction.b();
        }
      }
      a(localEntityManager, localShieldListInfo1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localShieldListInfo1.uin, localShieldListInfo1);
      break label349;
      label333:
      localEntityTransaction.c();
      localEntityTransaction.b();
      boolean bool = true;
      continue;
      label349:
      i += 1;
    }
  }
  
  public boolean a(ConcurrentHashMap paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldMsgManger", 2, "<---saveShieldListTotal : begin....");
    }
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject2 != null)
      {
        localObject3 = new ShieldListInfo().getTableName();
        ((SQLiteDatabase)localObject2).a("delete from " + (String)localObject3);
      }
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      localObject2 = new ArrayList();
      Object localObject3 = paramConcurrentHashMap.keySet().iterator();
      if (((Iterator)localObject3).hasNext()) {
        ((ArrayList)localObject2).add(paramConcurrentHashMap.get((String)((Iterator)localObject3).next()));
      }
    }
    boolean bool = a((List)localObject2);
    return bool;
  }
  
  public void b(int paramInt, List paramList)
  {
    ShieldListHandler localShieldListHandler = (ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17);
    int j = paramList.size();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    localShieldListHandler.b(paramInt, arrayOfLong);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.ShieldMsgManger
 * JD-Core Version:    0.7.0.1
 */