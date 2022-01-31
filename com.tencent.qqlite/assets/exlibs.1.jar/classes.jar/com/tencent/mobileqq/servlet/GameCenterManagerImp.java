package com.tencent.mobileqq.servlet;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PreloadInfoCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchInfo;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class GameCenterManagerImp
  implements Manager
{
  public static final int a = 0;
  public static final String a = "gc_notify_type";
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 1;
  public static final String b = "gc_pluginid_list";
  private static final boolean jdField_b_of_type_Boolean = true;
  public static final int c = 2;
  private static final String c = "Q.lebatab.GameCenterManagerImp";
  public static final int d = 3;
  private static final String d = "gamecenter_prefername";
  public static final int e = 4;
  private static final String e = "gc_unread";
  public static final int f = 5;
  private static final String f = "gc_newmsg";
  public static final int g = 6;
  private static final String g = "gc_pluginid";
  public static final int h = 7;
  private static final String h = "gc_redpoint";
  private static final String i = "gc_tab";
  private static final String j = "gc_text";
  private static final String k = "gc_icon";
  private static final String l = "gc_type";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  
  public GameCenterManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.a().getSharedPreferences("gamecenter_prefername", 0);
    c();
    a();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterManagerImp", 2, "loadGameCenterUnread.");
    }
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = new HashMap();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if (!TextUtils.isEmpty(str1))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_pluginid" + str1, null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split("&");
        if ((localObject != null) && (localObject.length > 0))
        {
          int m = 0;
          for (;;)
          {
            if (m >= localObject.length) {
              return;
            }
            String str2 = localObject[m];
            try
            {
              long l1 = Long.parseLong(str2);
              if (l1 > 0L)
              {
                GameCenterManagerImp.UnreadData localUnreadData = new GameCenterManagerImp.UnreadData(this);
                localUnreadData.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("gc_unread" + str1 + "_" + str2, 0L);
                localUnreadData.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_newmsg" + str1 + "_" + str2, false);
                localUnreadData.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_redpoint" + str1 + "_" + str2, false);
                localUnreadData.c = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_tab" + str1 + "_" + str2, false);
                localUnreadData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_text" + str1 + "_" + str2, "");
                localUnreadData.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_icon" + str1 + "_" + str2, "");
                localUnreadData.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("gc_type" + str1 + "_" + str2, -1);
                this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l1));
                this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), localUnreadData);
              }
            }
            catch (Exception localException)
            {
              label501:
              break label501;
            }
            m += 1;
          }
        }
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      String str1 = "";
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        long l1 = ((Long)localIterator.next()).longValue();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(l1)))
        {
          if (str1.length() > 0) {}
          for (str1 = str1 + "&" + l1;; str1 = str1 + l1)
          {
            GameCenterManagerImp.UnreadData localUnreadData = (GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l1));
            localEditor.putLong("gc_unread" + str2 + "_" + l1, localUnreadData.jdField_a_of_type_Long);
            localEditor.putBoolean("gc_newmsg" + str2 + "_" + l1, localUnreadData.jdField_a_of_type_Boolean);
            localEditor.putBoolean("gc_redpoint" + str2 + "_" + l1, localUnreadData.jdField_b_of_type_Boolean);
            localEditor.putBoolean("gc_tab" + str2 + "_" + l1, localUnreadData.c);
            localEditor.putString("gc_text" + str2 + "_" + l1, localUnreadData.jdField_a_of_type_JavaLangString);
            localEditor.putString("gc_icon" + str2 + "_" + l1, localUnreadData.jdField_b_of_type_JavaLangString);
            localEditor.putInt("gc_type" + str2 + "_" + l1, localUnreadData.jdField_a_of_type_Int);
            break;
          }
        }
      }
      localEditor.putString("gc_pluginid" + str2, str1);
      localEditor.commit();
    }
  }
  
  public int a()
  {
    return ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a().i;
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      return (int)((GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Long;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return ((Integer)this.b.get(paramString)).intValue();
    }
    return -1;
  }
  
  public GameCenterManagerImp.UnreadData a(long paramLong)
  {
    return (GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public void a()
  {
    Object localObject1 = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((localObject1 == null) || (!((File)localObject1).exists())) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
    }
    for (;;)
    {
      return;
      Object localObject2 = FileUtils.a((File)localObject1);
      if (localObject2 == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "Can not translate BusinessInfoCheckUpdateItem pb file to byte");
        return;
      }
      this.b.clear();
      try
      {
        localObject1 = new BusinessInfoCheckUpdate.TimeRspBody();
        ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).mergeFrom((byte[])localObject2);
        int m = 0;
        while (m < ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.size())
        {
          localObject2 = (BusinessInfoCheckUpdate.AppInfo)((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get(m);
          if (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0) {
            this.b.put(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get(), Integer.valueOf(((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get()));
          }
          m += 1;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      GameCenterManagerImp.UnreadData localUnreadData = (GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      localUnreadData.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localUnreadData);
      d();
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "clearUnread.pluginId=" + paramLong);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      this.b.remove(paramString);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong)) {}
      for (paramArrayList = (GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(localLong);; paramArrayList = new GameCenterManagerImp.UnreadData(this))
      {
        localHashMap.put(localLong, paramArrayList);
        break;
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap);
    d();
  }
  
  public boolean a()
  {
    RedTouchInfo localRedTouchInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a();
    return (localRedTouchInfo.g > 0) || (localRedTouchInfo.j > 0);
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("check_update_sp_key", 0);
    int n = ((SharedPreferences)localObject).getInt("businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 600);
    int i1 = ((SharedPreferences)localObject).getInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    int m = (int)(System.currentTimeMillis() / 1000L);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebatab.GameCenterManagerImp", 4, "onGetCheckUpdate:lastCheckTime=" + i1 + ",nowSystemTime=" + m);
    }
    if ((m - i1 > n) || (m < i1))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 4, "onGetCheckUpdate:start send check update new info update time.");
      }
      ((SharedPreferences)localObject).edit().putInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (int)(System.currentTimeMillis() / 1000L)).commit();
      localObject = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 0);
      n = ((SharedPreferences)localObject).getInt("key_check_update_interval" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 259200);
      i1 = ((SharedPreferences)localObject).getInt("key_last_check_update_timestamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      if ((m - i1 > n) || (m < i1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.GameCenterManagerImp", 2, "getPreloadInfo:start send check update new info update time.");
        }
        ((SharedPreferences)localObject).edit().putInt("key_last_check_update_timestamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (int)(System.currentTimeMillis() / 1000L)).commit();
        localObject = new PreloadInfoCheckUpdateItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(123, (CheckUpdateItemInterface)localObject);
      }
      for (;;)
      {
        localObject = new BusinessInfoCheckUpdateItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 110);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(110, (CheckUpdateItemInterface)localObject);
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true, 2);
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(Integer.valueOf(123));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(Integer.valueOf(110));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(Integer.valueOf(122));
  }
  
  public boolean b()
  {
    return ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a().h > 0;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GameCenterManagerImp
 * JD-Core Version:    0.7.0.1
 */