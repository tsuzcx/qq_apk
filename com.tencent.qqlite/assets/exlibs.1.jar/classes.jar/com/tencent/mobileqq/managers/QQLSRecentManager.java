package com.tencent.mobileqq.managers;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dxg;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public class QQLSRecentManager
  implements Observer, Manager
{
  public static int a = 0;
  public static long a = 0L;
  public static final String a = "QQLSActivity";
  private static CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  public static boolean a;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  public static long b;
  public static String b;
  public static volatile boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_b_of_type_Boolean = false;
    c = false;
    d = false;
    e = false;
    f = false;
    jdField_b_of_type_JavaLangString = "";
  }
  
  public QQLSRecentManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_b_of_type_JavaLangString = Build.MANUFACTURER + "-" + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31));
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.addObserver(this);
    }
  }
  
  public static boolean a()
  {
    d = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.lock_screen.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "isPhoneNeedBright need bright before sensor = " + d);
    }
    return d;
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
    for (;;)
    {
      RecentBaseData localRecentBaseData;
      int i;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        }
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localRecentBaseData = (RecentBaseData)localIterator.next();
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localRecentBaseData.a(), localRecentBaseData.a());
        if (localRecentBaseData.a().equals(AppConstants.Z))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.Z, localRecentBaseData.a());
          if (i != 0) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
        }
      }
      if (localRecentBaseData.a().equals(AppConstants.V)) {
        i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).a();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "after removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (jdField_b_of_type_JavaLangString.equalsIgnoreCase("HUAWEI-HUAWEI T8833")) {
      return;
    }
    Object localObject = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningTasks(1);
    int i;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "locking activity:" + ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName());
      }
      localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName();
      if ((((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) || (((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) || (((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager.getInstance().isLsonResume:" + jdField_b_of_type_Boolean);
      }
      if (paramInt == 1) {}
      for (c = true;; c = false)
      {
        if (i != 0) {
          break label222;
        }
        new Handler(Looper.getMainLooper()).post(new dxg(this, paramQQAppInterface, paramString, paramInt));
        return;
        i = 0;
        break;
      }
      label222:
      break;
      i = 0;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "threadId =" + Thread.currentThread().getId());
        }
        localObject2 = paramQQAppInterface.a().a().b().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label659;
        }
        localObject1 = (RecentUser)((Iterator)localObject2).next();
        if (localObject1 == null) {
          break label659;
        }
        if (TextUtils.isEmpty(((RecentUser)localObject1).uin))
        {
          paramString = null;
          if (paramString == null) {
            return false;
          }
        }
        else
        {
          if ((localObject1 != null) && (paramString.equals(((RecentUser)localObject1).uin)) && (((RecentUser)localObject1).type == paramInt))
          {
            paramString = (String)localObject1;
            continue;
          }
          if ((localObject1 != null) && (((RecentUser)localObject1).type == paramInt) && (AppConstants.Z.equals(((RecentUser)localObject1).uin)))
          {
            paramString = (String)localObject1;
            continue;
          }
          if ((localObject1 == null) || (!AppConstants.V.equals(((RecentUser)localObject1).uin)) || (!paramString.equals(((RecentUser)localObject1).uin))) {
            continue;
          }
          paramString = (String)localObject1;
          continue;
        }
        localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label368;
        }
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        paramInt = paramQQAppInterface.a().a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a());
        if (((RecentBaseData)localObject2).a().equals(AppConstants.Z))
        {
          paramInt = paramQQAppInterface.a().a(AppConstants.Z, ((RecentBaseData)localObject2).a());
          if (paramInt != 0) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        }
      }
      if (((RecentBaseData)localObject2).a().equals(AppConstants.V))
      {
        paramInt = ((NewFriendManager)paramQQAppInterface.getManager(31)).a();
        continue;
        label368:
        paramInt = paramQQAppInterface.a().a(paramString.uin, paramString.type);
        if (paramString.uin.equals(AppConstants.Z))
        {
          paramInt = paramQQAppInterface.a().a(AppConstants.Z, paramString.type);
          if (paramInt > 0)
          {
            paramQQAppInterface = ConversationDataFactory.a(paramString, paramQQAppInterface, paramQQAppInterface.a());
            paramString = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            label433:
            if (paramString.hasNext())
            {
              localObject1 = (RecentBaseData)paramString.next();
              if ((!((RecentBaseData)localObject1).a().equals(paramQQAppInterface.a())) || (((RecentBaseData)localObject1).a() != paramQQAppInterface.a())) {
                break label577;
              }
              jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject1);
            }
          }
        }
        for (;;)
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
          }
          if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0) {
            break label657;
          }
          return true;
          if (!paramString.uin.equals(AppConstants.V)) {
            break;
          }
          paramInt = ((NewFriendManager)paramQQAppInterface.getManager(31)).a();
          break;
          label577:
          if ((paramQQAppInterface.a().equals(AppConstants.Z)) && (((RecentBaseData)localObject1).a().equals(paramQQAppInterface.a())))
          {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject1);
          }
          else
          {
            if ((!paramQQAppInterface.a().equals(AppConstants.V)) || (!((RecentBaseData)localObject1).a().equals(paramQQAppInterface.a()))) {
              break label433;
            }
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject1);
          }
        }
        label657:
        return false;
        label659:
        paramString = null;
      }
    }
  }
  
  public void b()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "mDataList clear");
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof NewFriendMessage)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager new friend update~~~~~ " + Thread.currentThread().getId());
      }
      if (!((NewFriendMessage)paramObject).jdField_a_of_type_Boolean) {
        break label59;
      }
    }
    label59:
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            return;
            if (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun ");
          return;
          i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).a();
        } while (TextUtils.isEmpty(((NewFriendMessage)paramObject).jdField_a_of_type_JavaLangString));
        if ((i != 0) && (!f)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + f);
      return;
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363745), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363278), "qqsetting_notify_showcontent_key", true);
    } while ((!Boolean.valueOf(bool1).booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.V, 4000, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.QQLSRecentManager
 * JD-Core Version:    0.7.0.1
 */