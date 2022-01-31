package com.tencent.mobileqq.managers;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQLSRecentManager
{
  public static int a;
  public static long a;
  private static QQLSRecentManager jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
  private static CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static long b;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    b = 0L;
    jdField_a_of_type_Int = 0;
  }
  
  public static QQLSRecentManager a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager == null) {
        jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager = new QQLSRecentManager();
      }
      return jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    }
  }
  
  public CopyOnWriteArrayList a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
      return localCopyOnWriteArrayList;
    }
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "mDataList clear");
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        Iterator localIterator = paramQQAppInterface.a().a().a().iterator();
        if (!localIterator.hasNext()) {
          break label237;
        }
        localObject = (RecentUser)localIterator.next();
        if ((localObject == null) || (!paramString.equals(((RecentUser)localObject).uin)) || (((RecentUser)localObject).type != paramInt)) {
          continue;
        }
        paramString = (String)localObject;
        if (paramString == null) {
          return;
        }
      }
      if (paramQQAppInterface.a().a(paramString.uin, paramString.type) > 0)
      {
        paramQQAppInterface = ConversationDataFactory.a(paramString, paramQQAppInterface, paramQQAppInterface.a());
        paramString = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (paramString.hasNext())
        {
          localObject = (RecentBaseData)paramString.next();
          if ((((RecentBaseData)localObject).a().equals(paramQQAppInterface.a())) && (((RecentBaseData)localObject).a() == paramQQAppInterface.a())) {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject);
          }
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramQQAppInterface);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      }
      return;
      label237:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.QQLSRecentManager
 * JD-Core Version:    0.7.0.1
 */