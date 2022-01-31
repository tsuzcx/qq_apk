package com.tencent.mobileqq.servlet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper.LocalConfig;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class QZoneManagerImp
  implements QZoneManager
{
  private static long jdField_a_of_type_Long = 600000L;
  public static final String a = "http://scannon.3g.qq.com/api";
  private static final long jdField_b_of_type_Long = 300000L;
  public static final String b = "http://scannon.3g.qq.com/";
  public static final int c = 0;
  private static long c = 30000L;
  public static final String c = "QZONE_UNREAD";
  public static final int d = 1;
  public static final String d = "notify_type";
  public static final int e = 0;
  private static final String e = "Q.lebatab.QZoneManagerImp";
  public static final int f = 1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private long[] jdField_a_of_type_ArrayOfLong;
  private boolean jdField_b_of_type_Boolean;
  private int g = 1;
  private int h = 0;
  
  public QZoneManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = ReflectedMethods.a(paramQQAppInterface.a(), "QZONE_UNREAD");
    b();
    a(jdField_a_of_type_Long);
  }
  
  private void a()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLong.length)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((str != null) && (str.length() > 0)) {
          localEditor.putLong(str + i + "", this.jdField_a_of_type_ArrayOfLong[i]);
        }
      }
      i += 1;
    }
    localEditor.commit();
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    return QZoneHelper.LocalConfig.a(paramQQAppInterface.a().getApplicationContext().getString(2131563433) + paramQQAppInterface.getAccount(), true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ArrayOfLong = new long[5];
    int i = 0;
    while (i < 5)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((str != null) && (str.length() > 0)) {
          this.jdField_a_of_type_ArrayOfLong[i] = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str + i + "", 0L);
        }
      }
      i += 1;
    }
  }
  
  public int a(QZoneManager.FeedType paramFeedType)
  {
    int i = 0;
    if (paramFeedType == QZoneManager.FeedType.mySpacefeed) {
      i = (int)this.jdField_a_of_type_ArrayOfLong[1];
    }
    while (paramFeedType != QZoneManager.FeedType.friendSpace) {
      return i;
    }
    return (int)this.jdField_a_of_type_ArrayOfLong[0];
  }
  
  public long a()
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      l1 = l2;
      if (this.h < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        l2 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(this.h)).longValue();
        this.h += 1;
        l1 = l2;
        if (this.h >= this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.h = 0;
          l1 = l2;
        }
      }
    }
    return l1;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ArrayOfLong[3]);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.QZoneManagerImp", 2, "sendGetFeedByTime.begin.");
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return;
          if (this.g == 0)
          {
            localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneServlet.class);
            localNewIntent.setAction("QZone_Get_Unread");
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.QZoneManagerImp", 2, "sendGetFeedByTime. by servlet.");
          }
          if (paramInt != 1) {
            break;
          }
          localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
          localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
          localNewIntent.putExtra("qzone_send_by_time", paramInt);
          localNewIntent.putExtra("scene", 103);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
        } while (!QLog.isColorLevel());
        QLog.d("Q.lebatab.QZoneManagerImp", 2, "sendGetFeedByTime.switch to forground.");
        return;
      } while ((paramInt != 2) || (System.currentTimeMillis() - QZoneNotifyServlet.jdField_a_of_type_Long <= c) || (a(QZoneManager.FeedType.mySpacefeed) > 0));
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
      localNewIntent.putExtra("qzone_send_by_time", paramInt);
      localNewIntent.putExtra("scene", 103);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.QZoneManagerImp", 2, "sendGetFeedByTime.click leba.");
  }
  
  public void a(long paramLong)
  {
    if ((paramLong != jdField_a_of_type_Long) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
    {
      jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      while (paramLong >= 300000L)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(300000L));
        paramLong -= 300000L;
      }
      if (paramLong > 0L) {
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
      }
      this.h = 0;
    }
  }
  
  public void a(QZoneManager.FeedType paramFeedType)
  {
    if (paramFeedType == QZoneManager.FeedType.mySpacefeed) {
      this.jdField_a_of_type_ArrayOfLong[1] = 0L;
    }
    for (;;)
    {
      a();
      if (paramFeedType != QZoneManager.FeedType.friendSpace) {
        break;
      }
      paramFeedType = new Intent("com.tencent.qqi.syncFriendFeedMessage");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramFeedType);
      do
      {
        return;
      } while (paramFeedType != QZoneManager.FeedType.friendSpace);
      this.jdField_a_of_type_ArrayOfLong[0] = 0L;
    }
    paramFeedType = new Intent("com.tencent.qqi.syncMyFeedMessage");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramFeedType);
  }
  
  public void a(QZoneManager.FeedType paramFeedType, int paramInt, long paramLong, String paramString)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.QZoneManagerImp", 2, "setFeedCount.feedtype=" + paramFeedType + ",count=" + paramInt + ",uin=" + paramLong);
    }
    NewIntent localNewIntent;
    if (paramFeedType == QZoneManager.FeedType.friendSpace)
    {
      if (this.jdField_a_of_type_ArrayOfLong[0] != paramInt) {}
      this.jdField_a_of_type_ArrayOfLong[0] = paramInt;
      this.jdField_a_of_type_ArrayOfLong[3] = paramLong;
      a();
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      localNewIntent.setAction("Qzone_Refresh_UI");
      if (paramFeedType != QZoneManager.FeedType.mySpacefeed) {
        break label214;
      }
    }
    label214:
    for (paramInt = i;; paramInt = 0)
    {
      localNewIntent.putExtra("notify_type", paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      if (paramFeedType != QZoneManager.FeedType.friendSpace) {
        break label219;
      }
      paramFeedType = new Intent("com.tencent.qqi.syncFriendFeedMessage");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramFeedType);
      do
      {
        return;
      } while (paramFeedType != QZoneManager.FeedType.mySpacefeed);
      if (this.jdField_a_of_type_ArrayOfLong[1] != paramInt) {}
      this.jdField_a_of_type_ArrayOfLong[1] = paramInt;
      this.jdField_a_of_type_ArrayOfLong[4] = paramLong;
      break;
    }
    label219:
    paramFeedType = new Intent("com.tencent.qqi.syncMyFeedMessage");
    if (!TextUtils.isEmpty(paramString))
    {
      paramFeedType.putExtra("com.tencent.qqi.syncMyFeedMessagelist", paramString);
      paramFeedType.putExtra("com.tencent.qqi.syncMyFeedMessageUin", paramLong);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramFeedType);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.g == 0)
    {
      paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneServlet.class);
      paramString1.setAction("QZone_Get_Unread");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      paramString1.setAction("Qzone_Get_NewAndUnread_Count");
      paramString1.putExtra("scene", 100);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.QZoneManagerImp", 2, "setEnterQZone.isenter=" + paramBoolean);
    }
    this.b = paramBoolean;
  }
  
  public void a(long[] paramArrayOfLong, ArrayList paramArrayList)
  {
    int j = 1;
    if (this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.QZoneManagerImp", 2, "setFeedCount.user enter qzone.dismiss data.");
      }
      return;
    }
    int i = a(QZoneManager.FeedType.friendSpace);
    int k = a(QZoneManager.FeedType.mySpacefeed);
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
    if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_a_of_type_ArrayOfLong[1] = k;
    }
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.QZoneManagerImp", 2, "setFeedCount.olddata:friendfeed=" + i + ",myfeed=" + k);
    }
    if (paramArrayOfLong.length == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.QZoneManagerImp", 2, "setFeedCount.friendfeed=" + paramArrayOfLong[0] + ",myfeed=" + paramArrayOfLong[1] + ",2=" + paramArrayOfLong[2]);
      }
      if (this.jdField_a_of_type_ArrayOfLong[0] == i) {
        break label367;
      }
    }
    label365:
    label367:
    for (i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_ArrayOfLong[1] != k) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label365;
        }
        if (j == 0)
        {
          paramArrayOfLong = new Intent("com.tencent.qqi.syncFriendFeedMessage");
          if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
            paramArrayOfLong.putExtra("com.tencent.qqi.syncFriendFeedFriends", paramArrayList);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfLong);
          return;
          if ((paramArrayOfLong.length < 4) || (!QLog.isColorLevel())) {
            break;
          }
          QLog.d("Q.lebatab.QZoneManagerImp", 2, "setFeedCount.friendfeed=" + paramArrayOfLong[0] + ",myfeed=" + paramArrayOfLong[1] + ",2=" + paramArrayOfLong[2] + ",3=" + paramArrayOfLong[3]);
          break;
        }
        paramArrayOfLong = new Intent("com.tencent.qqi.syncMyFeedMessage");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfLong);
        return;
        j = 0;
      }
      break;
    }
  }
  
  public boolean a()
  {
    return this.h == 0;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp
 * JD-Core Version:    0.7.0.1
 */