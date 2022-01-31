package com.tencent.mobileqq.servlet;

import KQQ.PluginInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
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
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
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
    d();
    a();
  }
  
  private void d()
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
  
  private void e()
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
    return ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a().h;
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
    Object localObject = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((localObject == null) || (!((File)localObject).exists())) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
    }
    for (;;)
    {
      return;
      if (FileUtils.a((File)localObject) == null)
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
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
        localTimeRspBody.mergeFrom(FileUtils.a((File)localObject));
        int m = 0;
        while (m < localTimeRspBody.rptMsgAppInfo.size())
        {
          localObject = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(m);
          if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0) {
            this.b.put(((BusinessInfoCheckUpdate.AppInfo)localObject).path.get(), Integer.valueOf(((BusinessInfoCheckUpdate.AppInfo)localObject).type.get()));
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
      e();
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "clearUnread.pluginId=" + paramLong);
      }
    }
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
      ((GameCenterManagerImp.UnreadData)localObject).jdField_a_of_type_Boolean = paramBoolean;
      ((GameCenterManagerImp.UnreadData)localObject).jdField_a_of_type_Long = paramLong2;
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localObject);
      e();
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GameCenterServlet.class);
      ((NewIntent)localObject).setAction("gc_refresh_ui");
      if ((paramLong2 <= 0L) && (!paramBoolean)) {
        break label138;
      }
      if (paramLong2 <= 0L) {
        break label126;
      }
      ((NewIntent)localObject).putExtra("gc_notify_type", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
      label126:
      ((NewIntent)localObject).putExtra("gc_notify_type", 1);
      continue;
      label138:
      ((NewIntent)localObject).putExtra("gc_notify_type", 3);
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
    e();
  }
  
  public boolean a()
  {
    RedTouchInfo localRedTouchInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a();
    return (localRedTouchInfo.f > 0) || (localRedTouchInfo.i > 0);
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean a(List paramList)
  {
    boolean bool1;
    int m;
    int n;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = false;
      m = -1;
      int i2 = 0;
      if (i2 < paramList.size())
      {
        PluginInfo localPluginInfo = (PluginInfo)paramList.get(i2);
        boolean bool3 = bool1;
        int i1 = m;
        if (localPluginInfo != null) {
          if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localPluginInfo.Id)) != null) {}
        }
        GameCenterManagerImp.UnreadData localUnreadData;
        boolean bool2;
        label296:
        do
        {
          i2 += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.i=" + i2 + ",plugin:" + localPluginInfo.toString());
          }
          localUnreadData = (GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localPluginInfo.Id));
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.i=" + i2 + ",before unreaddata:" + localUnreadData.toString());
          }
          if (localPluginInfo.Count > 0L)
          {
            n = m;
            if (localUnreadData.jdField_a_of_type_Long != localPluginInfo.Count)
            {
              bool2 = true;
              bool1 = bool2;
              n = m;
              if (localPluginInfo.Tab)
              {
                n = 0;
                bool1 = bool2;
              }
            }
            localUnreadData.jdField_a_of_type_Long = localPluginInfo.Count;
            localUnreadData.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
            localUnreadData.jdField_a_of_type_Boolean = false;
            localUnreadData.jdField_b_of_type_Boolean = false;
            if (TextUtils.isEmpty(localUnreadData.jdField_a_of_type_JavaLangString))
            {
              localUnreadData.jdField_a_of_type_Int = 1;
              localUnreadData.c = localPluginInfo.Tab;
              bool2 = bool1;
            }
          }
          do
          {
            bool3 = bool2;
            i1 = n;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.i=" + i2 + ",unreaddata:" + localUnreadData.toString());
              i1 = n;
              bool3 = bool2;
            }
            bool1 = bool3;
            m = i1;
            break;
            localUnreadData.jdField_a_of_type_Int = 4;
            break label296;
            if (localPluginInfo.Flag)
            {
              if (localUnreadData.jdField_a_of_type_Long > 0L) {
                break;
              }
              n = m;
              if (!localUnreadData.jdField_a_of_type_Boolean)
              {
                bool2 = true;
                bool1 = bool2;
                n = m;
                if (localPluginInfo.Tab) {
                  if (m != -1)
                  {
                    bool1 = bool2;
                    n = m;
                    if (m != 4) {}
                  }
                  else
                  {
                    n = 1;
                    bool1 = bool2;
                  }
                }
              }
              localUnreadData.jdField_a_of_type_Boolean = localPluginInfo.Flag;
              localUnreadData.jdField_b_of_type_Boolean = false;
              localUnreadData.jdField_a_of_type_Long = 0L;
              localUnreadData.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
              if (TextUtils.isEmpty(localUnreadData.jdField_a_of_type_JavaLangString)) {}
              for (localUnreadData.jdField_a_of_type_Int = 3;; localUnreadData.jdField_a_of_type_Int = 6)
              {
                localUnreadData.c = localPluginInfo.Tab;
                bool2 = bool1;
                break;
              }
            }
            bool2 = bool1;
            n = m;
          } while (!localPluginInfo.RedPoint);
        } while ((localUnreadData.jdField_a_of_type_Long > 0L) || ((localPluginInfo.Id == 769L) && (localUnreadData.jdField_a_of_type_Boolean)));
        n = m;
        if (!localUnreadData.jdField_b_of_type_Boolean)
        {
          bool2 = true;
          bool1 = bool2;
          n = m;
          if (m == -1)
          {
            bool1 = bool2;
            n = m;
            if (localPluginInfo.Tab)
            {
              n = 4;
              bool1 = bool2;
            }
          }
        }
        localUnreadData.jdField_b_of_type_Boolean = localPluginInfo.RedPoint;
        localUnreadData.jdField_a_of_type_Boolean = false;
        localUnreadData.jdField_a_of_type_Long = 0L;
        localUnreadData.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
        localUnreadData.jdField_b_of_type_JavaLangString = localPluginInfo.PicUrl;
        if (TextUtils.isEmpty(localUnreadData.jdField_a_of_type_JavaLangString)) {
          if (TextUtils.isEmpty(localUnreadData.jdField_b_of_type_JavaLangString)) {
            localUnreadData.jdField_a_of_type_Int = 2;
          }
        }
        for (;;)
        {
          localUnreadData.c = localPluginInfo.Tab;
          bool2 = bool1;
          break;
          localUnreadData.jdField_a_of_type_Int = 7;
          continue;
          localUnreadData.jdField_a_of_type_Int = 5;
        }
      }
      e();
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.changeType=" + m + ",ischange:" + bool1);
      }
      if (m != -1)
      {
        paramList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GameCenterServlet.class);
        paramList.setAction("gc_refresh_ui");
        paramList.putExtra("gc_notify_type", m);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramList);
        n = m;
      }
    }
    for (;;)
    {
      if (n != -1)
      {
        return true;
        n = m;
        if (bool1)
        {
          paramList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GameCenterServlet.class);
          paramList.setAction("gc_refresh_ui");
          paramList.putExtra("gc_notify_type", 3);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramList);
          n = m;
        }
      }
      else
      {
        return false;
        n = -1;
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "sendReqToGetUnread.mpluginids=" + this.jdField_a_of_type_JavaUtilArrayList);
      }
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GameCenterServlet.class);
      localNewIntent.setAction("gc_get_newandunreadmsg");
      localNewIntent.putExtra("gc_pluginid_list", this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterManagerImp", 2, "sendReqToGetUnread.no plugin.");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GameCenterServlet.class);
    localNewIntent.setAction("gc_refresh_ui");
    localNewIntent.putExtra("gc_notify_type", 2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean b()
  {
    return ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a().g > 0;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    int m = ((SharedPreferences)localObject).getInt("businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 600);
    int n = ((SharedPreferences)localObject).getInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    int i1 = (int)(System.currentTimeMillis() / 1000L);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebatab.GameCenterManagerImp", 4, "onGetCheckUpdate:lastCheckTime=" + n + ",nowSystemTime=" + i1);
    }
    if ((i1 - n > m) || (i1 < n))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 4, "onGetCheckUpdate:start send check update new info update time.");
      }
      ((SharedPreferences)localObject).edit().putInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (int)(System.currentTimeMillis() / 1000L)).commit();
      localObject = new ProfileCardCheckUpdate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (((ProfileCardCheckUpdate)localObject).a()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(111, (CheckUpdateItemInterface)localObject);
      }
      localObject = new BusinessInfoCheckUpdateItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 110);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(110, (CheckUpdateItemInterface)localObject);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true, 2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(Integer.valueOf(110));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(Integer.valueOf(111));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GameCenterManagerImp
 * JD-Core Version:    0.7.0.1
 */