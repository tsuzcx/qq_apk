package com.tencent.mobileqq.utils;

import android.os.Handler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RoamSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import evs;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;

public class RoamSettingController
  implements Manager
{
  public static final int a = 3;
  public static final long a = 45000L;
  public static final String a = "RoamSetting";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  boolean d = false;
  
  public RoamSettingController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  public static int a(String paramString)
  {
    if (paramString.contains("message.group.policy.")) {
      return 1;
    }
    if (paramString.contains("message.group.ring")) {
      return 2;
    }
    if (paramString.contains("message.group.vibrate")) {
      return 3;
    }
    if (paramString.contains("message.ring.switch")) {
      return 4;
    }
    if (paramString.contains("message.vibrate.switch")) {
      return 5;
    }
    if (paramString.contains("sync.c2c_message")) {
      return 6;
    }
    return -1;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      paramString = "message.group.policy." + paramString;
    }
    do
    {
      return paramString;
      if (paramInt == 2) {
        return "message.group.ring";
      }
      if (paramInt == 3) {
        return "message.group.vibrate";
      }
      if (paramInt == 4) {
        return "message.ring.switch";
      }
      if (paramInt == 5) {
        return "message.vibrate.switch";
      }
    } while (paramInt != 6);
    return "sync.c2c_message";
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "uploadNewValue...");
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("uploadNewValue return directly, app.isRunning=");
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label75;
        }
        localObject = "null";
        QLog.d("RoamSetting", 2, localObject);
      }
    }
    label75:
    label223:
    do
    {
      do
      {
        do
        {
          return;
          localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning());
          break;
          if (this.jdField_b_of_type_Boolean)
          {
            if ((this.jdField_b_of_type_Long <= 0L) || (this.jdField_b_of_type_Long + 45000L >= System.currentTimeMillis())) {
              break label223;
            }
            if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "uploadNewValue state_allLoading=" + this.jdField_b_of_type_Boolean + " more than 45s, forced to stop");
            }
            this.jdField_b_of_type_Long = 0L;
            this.jdField_b_of_type_Boolean = false;
          }
          if (!this.c) {
            break label263;
          }
        } while (!QLog.isColorLevel());
        QLog.d("RoamSetting", 2, "uploadNewValue but return, state_allLoading= " + this.jdField_b_of_type_Boolean + " state_uploadingSetting=" + this.c);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("RoamSetting", 2, "uploadNewValue but return, state_allLoading=" + this.jdField_b_of_type_Boolean + ", time_allLoading less than 60s, waitting...");
      return;
      this.c = true;
      b();
      localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    } while (localObject == null);
    label263:
    ((FriendListHandler)localObject).a(a().a(), this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap);
  }
  
  public static String b(String paramString, int paramInt)
  {
    String str = null;
    if (paramInt == 1)
    {
      if (paramString.contains("message.group.policy."))
      {
        String[] arrayOfString = paramString.split("\\.");
        paramString = str;
        if (arrayOfString != null)
        {
          paramString = str;
          if (arrayOfString.length > 0) {
            paramString = arrayOfString[(arrayOfString.length - 1)];
          }
        }
        str = paramString;
      }
    }
    else
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return str;
                str = paramString;
              } while (paramInt == 2);
              str = paramString;
            } while (paramInt == 3);
            str = paramString;
          } while (paramInt == 4);
          str = paramString;
        } while (paramInt == 5);
        str = paramString;
      } while (paramInt != 6);
      return paramString;
    }
    return null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.d = false;
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "copyNewValue2Uploading, change state_newValue=false, mapUploading:" + this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.toString());
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (Integer)((Map.Entry)localObject2).getValue();
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(((Integer)localObject2).intValue()));
        }
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    this.d = true;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 1;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return ((Integer)a(localArrayList, paramInt).get(paramString)).intValue();
  }
  
  RoamSettingManager a()
  {
    return (RoamSettingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
  }
  
  public Map a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new HashMap();
    }
    Map localMap = DBUtils.a().a(paramList, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      String str;
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        str = (String)paramList.next();
        str = "message.group.policy." + str;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
        {
          localMap.put(str, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).intValue()));
          continue;
        }
        if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
          continue;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      localMap.put(str, Integer.valueOf(((Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).intValue()));
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    return localMap;
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, FriendListHandler paramFriendListHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "loadRoamSettingsByPage,localRevision=" + paramInt1 + " offset=" + paramLong + " respRevision=" + paramInt2 + " needTroopSettings=" + paramBoolean + " thread=" + Thread.currentThread().getName());
    }
    if (paramFriendListHandler == null) {
      paramFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    }
    for (;;)
    {
      paramFriendListHandler.a(paramInt1, paramLong, paramInt2, paramBoolean);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    this.d = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramInteger);
      System.out.println("setRoamSettingNewValue path = " + paramString + " value = " + paramInteger);
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "state_newValue=" + this.d + " setRoamSettingNewValue, path=" + paramString + " value=" + paramInteger + " uploadingCount=" + this.jdField_b_of_type_Int);
      }
      a();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(boolean paramBoolean, FriendListHandler paramFriendListHandler)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("loadAllRoamSetting return directly, app.isRunning=");
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label64;
        }
        paramFriendListHandler = "null";
        QLog.d("RoamSetting", 2, paramFriendListHandler);
      }
    }
    label64:
    do
    {
      return;
      paramFriendListHandler = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning());
      break;
      if (!this.jdField_b_of_type_Boolean) {
        break label121;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RoamSetting", 2, "loadAllRoamSettings but return, state_allUpdating=" + this.jdField_b_of_type_Boolean);
    return;
    label121:
    this.jdField_b_of_type_Boolean = true;
    int i = a().a();
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "loadAllRoamSettings, localRevision=" + i + " needTroopSettings=" + paramBoolean + " thread=" + Thread.currentThread().getName());
    }
    a(i, 0L, -1, paramBoolean, paramFriendListHandler);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "onGetAllSettingsFinish isSucc=" + paramBoolean1 + " next=" + paramBoolean2);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    if ((paramBoolean2) && (this.d)) {
      a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int < 3;
  }
  
  public int b(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        paramInt = ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
        return paramInt;
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        paramInt = ((Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
        return paramInt;
      }
      return a().a(paramString, paramInt);
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "onUploadRomingSettingsFinish isSuccess=" + paramBoolean1 + " reload=" + paramBoolean2);
    }
    System.out.println("onUploadRomingSettingsFinish isSuccess=" + paramBoolean1 + " reload=" + paramBoolean2);
    this.c = false;
    if (paramBoolean1)
    {
      d();
      if (paramBoolean2) {
        a(true, null);
      }
    }
    label101:
    do
    {
      do
      {
        int i;
        do
        {
          break label101;
          do
          {
            return;
          } while (!this.d);
          if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "onUploadRomingSettingsFinish and goto uploadNewValue, state_newValue=" + this.d);
          }
          a();
          return;
          c();
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int >= 3) {
            break label279;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
            break;
          }
          i = this.jdField_b_of_type_Int * 15 * 1000;
          ThreadManager.b().postDelayed(new evs(this), i);
        } while (!QLog.isColorLevel());
        QLog.d("RoamSetting", 2, "onUploadRomingSettingFinish fail, wait for " + i + "ms. uploadTryCount=" + this.jdField_b_of_type_Int);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("RoamSetting", 2, "onUploadRomingSettingFinish fail and qqApp isRunning false.");
      return;
    } while (!QLog.isColorLevel());
    label279:
    QLog.d("RoamSetting", 2, "onUploadRomingSettingFinish has no retry chance, wait for next newValue. uploadTryCount=" + this.jdField_b_of_type_Int);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RoamSettingController
 * JD-Core Version:    0.7.0.1
 */