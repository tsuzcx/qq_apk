package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RecentDataListManager
{
  private static RecentDataListManager jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public List a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  
  private RecentDataListManager()
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
  }
  
  public static RecentDataListManager a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager = new RecentDataListManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "-" + paramInt;
  }
  
  public RecentBaseData a(String paramString)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
      {
        paramString = (RecentBaseData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, paramString.toString());
      }
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)) && (paramRecentBaseData != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramRecentBaseData);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    FriendsManagerImp localFriendsManagerImp;
    if (paramQQAppInterface == null)
    {
      localFriendsManagerImp = null;
      if (paramQQAppInterface != null) {
        break label101;
      }
      localObject = null;
      label17:
      if (localObject == null) {
        break label183;
      }
    }
    label37:
    label183:
    for (Object localObject = ((RecentUserProxy)localObject).a();; localObject = null)
    {
      int i;
      int j;
      if (localObject == null)
      {
        i = 0;
        j = Math.min(8, i);
        if (j > 0)
        {
          if (paramBoolean) {
            break label125;
          }
          localFriendsManagerImp.a((List)localObject);
          ConversationDataFactory.a((List)localObject, paramQQAppInterface, paramContext, this.jdField_a_of_type_JavaUtilList, j);
        }
      }
      for (;;)
      {
        paramBoolean = bool;
        if (j > 0) {
          paramBoolean = true;
        }
        return paramBoolean;
        localFriendsManagerImp = (FriendsManagerImp)paramQQAppInterface.getManager(8);
        break;
        label101:
        localObject = paramQQAppInterface.a().a();
        break label17;
        i = ((List)localObject).size();
        break label37;
        label125:
        paramQQAppInterface = new RecentFaceDecoder(paramQQAppInterface);
        i = 0;
        while (i < j)
        {
          paramContext = (RecentUser)((List)localObject).get(i);
          if (paramContext != null) {
            paramQQAppInterface.a(paramContext.type, paramContext.uin);
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentDataListManager
 * JD-Core Version:    0.7.0.1
 */