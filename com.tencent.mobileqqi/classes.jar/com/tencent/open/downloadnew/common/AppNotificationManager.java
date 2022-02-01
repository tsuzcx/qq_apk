package com.tencent.open.downloadnew.common;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.business.base.AppUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AppNotificationManager
{
  public static final int a = 0;
  protected static AppNotificationManager a;
  protected static final String a;
  public static final int b = 1;
  protected static final String b = "APP_NOTIFICATION_IDS";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  protected NotificationManager a;
  protected AppNotificationManager.NotificationStyleDiscover a;
  protected final ConcurrentHashMap a;
  protected AtomicInteger a;
  protected int g = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppNotificationManager.class.getName();
    jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager = null;
  }
  
  protected AppNotificationManager()
  {
    this.jdField_a_of_type_AndroidAppNotificationManager = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidAppNotificationManager = ((NotificationManager)CommonDataAdapter.a().a().getSystemService("notification"));
  }
  
  public static AppNotificationManager a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager == null)
    {
      jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager = new AppNotificationManager();
      jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager.b();
      jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager.g);
    }
    return jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      AppNotificationManager.NoticeIdentity localNoticeIdentity = new AppNotificationManager.NoticeIdentity(this);
      localNoticeIdentity.jdField_a_of_type_JavaLangString = paramString1;
      localNoticeIdentity.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      localNoticeIdentity.jdField_b_of_type_Int = paramInt;
      localNoticeIdentity.jdField_b_of_type_JavaLangString = paramString2;
      localNoticeIdentity.jdField_a_of_type_Long = (System.currentTimeMillis() + localNoticeIdentity.jdField_a_of_type_Int);
      a(localNoticeIdentity);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localNoticeIdentity);
    }
    return ((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      AppNotificationManager.NoticeIdentity localNoticeIdentity = new AppNotificationManager.NoticeIdentity(this);
      localNoticeIdentity.jdField_a_of_type_JavaLangString = paramString1;
      localNoticeIdentity.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      localNoticeIdentity.jdField_b_of_type_Int = paramInt;
      localNoticeIdentity.jdField_b_of_type_JavaLangString = paramString2;
      localNoticeIdentity.jdField_a_of_type_Long = (System.currentTimeMillis() + localNoticeIdentity.jdField_a_of_type_Int);
      a(localNoticeIdentity);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localNoticeIdentity);
    }
    return ((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((CommonDataAdapter.a().a() == null) || (paramNoticeParam == null))
    {
      LogUtility.e(jdField_a_of_type_JavaLangString, "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(CommonDataAdapter.a().a().getPackageName(), 2130903334);
    Object localObject = IntentFactory.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setTextViewText(2131232120, StringAddition.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130838627;
      localRemoteViews.setImageViewResource(2131232118, 2130838623);
      localRemoteViews.setViewVisibility(2131232122, 8);
      localRemoteViews.setViewVisibility(2131232123, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131232117, (PendingIntent)localObject);
      }
    }
    for (;;)
    {
      localNotification.contentView = localRemoteViews;
      return localNotification;
      localNotification.contentIntent = ((PendingIntent)localObject);
      continue;
      if ((paramNoticeParam.jdField_b_of_type_Int == 0) || (paramNoticeParam.jdField_b_of_type_Int == 2) || (paramNoticeParam.jdField_b_of_type_Int == 3))
      {
        localNotification.icon = 2130838627;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131232122, CommonDataAdapter.a().a().getString(2131560026));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131232118, 2130838623);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131232122, CommonDataAdapter.a().a().getString(2131560023));
          localObject = AppUtil.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131232118, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = IntentFactory.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131232122, CommonDataAdapter.a().a().getString(2131560026));
          localObject = IntentFactory.a(4, paramNoticeParam);
          Bitmap localBitmap = ImageUtil.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label428;
          }
          localRemoteViews.setImageViewBitmap(2131232118, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131232117, (PendingIntent)localObject);
              break;
              label428:
              LogUtility.b(jdField_a_of_type_JavaLangString, ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131232118, 2130838623);
              continue;
            }
            localNotification.contentIntent = ((PendingIntent)localObject);
            break;
          }
        }
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
      else if (paramNoticeParam.jdField_b_of_type_Int == 4)
      {
        localNotification.icon = 2130838627;
        localRemoteViews.setImageViewResource(2131232118, 2130838623);
        localRemoteViews.setTextViewText(2131232122, CommonDataAdapter.a().a().getString(2131560029));
        localRemoteViews.setViewVisibility(2131232122, 0);
        localRemoteViews.setViewVisibility(2131232123, 8);
        paramNoticeParam = IntentFactory.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130838192;
        localRemoteViews.setImageViewResource(2131232118, 2130838193);
        localRemoteViews.setTextViewText(2131232122, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public AppNotificationManager.NoticeIdentity a(String paramString)
  {
    paramString = paramString.split(",");
    if (paramString.length < 4) {
      return null;
    }
    AppNotificationManager.NoticeIdentity localNoticeIdentity = new AppNotificationManager.NoticeIdentity(this);
    localNoticeIdentity.jdField_a_of_type_Int = Integer.parseInt(paramString[0]);
    localNoticeIdentity.jdField_b_of_type_JavaLangString = paramString[1];
    localNoticeIdentity.jdField_b_of_type_Int = Integer.parseInt(paramString[2]);
    localNoticeIdentity.jdField_a_of_type_JavaLangString = paramString[3];
    return localNoticeIdentity;
  }
  
  public ConcurrentHashMap a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "cancel");
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null)
    {
      this.jdField_a_of_type_AndroidAppNotificationManager.cancelAll();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    c();
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover == null) || (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() == null)) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover = new AppNotificationManager.NotificationStyleDiscover(this, CommonDataAdapter.a().a());
    }
    LogUtility.b("notificationtest", "title color:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b());
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b() != null) {
      paramRemoteViews.setTextColor(2131232120, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b().intValue());
    }
    LogUtility.b("notificationtest", "text color:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() != null) {
      paramRemoteViews.setTextColor(2131232122, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a().intValue());
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() != null) {
      paramRemoteViews.setTextColor(2131232121, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a().intValue());
    }
    LogUtility.b("notificationtest", "text size:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() > 0.0F) {
      paramRemoteViews.setFloat(2131232122, "setTextSize", this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a() > 0.0F) {
      paramRemoteViews.setFloat(2131232121, "setTextSize", this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.a());
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b() > 0.0F) {
      paramRemoteViews.setFloat(2131232120, "setTextSize", this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b());
    }
    ApplicationInfo localApplicationInfo = CommonDataAdapter.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonAppNotificationManager$NotificationStyleDiscover.b().intValue();
      paramRemoteViews.setInt(2131232117, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
      return;
    }
    catch (Exception paramRemoteViews) {}
  }
  
  protected void a(AppNotificationManager.NoticeIdentity paramNoticeIdentity)
  {
    try
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "***尝试  保存至本地：" + paramNoticeIdentity.toString());
      Object localObject = CommonDataAdapter.a().a().getSharedPreferences("APP_NOTIFICATION_IDS", 0);
      LogUtility.d(jdField_a_of_type_JavaLangString, "***保存至本地：" + paramNoticeIdentity.toString());
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramNoticeIdentity.jdField_a_of_type_JavaLangString, paramNoticeIdentity.toString());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramNoticeIdentity)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "saveToLocal>>>", paramNoticeIdentity);
    }
  }
  
  public void a(NoticeParam paramNoticeParam)
  {
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.notify(a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), a(paramNoticeParam));
    }
  }
  
  public void a(String paramString)
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_AndroidAppNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)))
    {
      this.jdField_a_of_type_AndroidAppNotificationManager.cancel(((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      c(paramString);
    }
  }
  
  protected void b()
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "------------从本地初始化ID------------");
    for (;;)
    {
      Map.Entry localEntry;
      try
      {
        Object localObject = CommonDataAdapter.a().a().getSharedPreferences("APP_NOTIFICATION_IDS", 0).getAll();
        if (localObject != null) {
          LogUtility.a(jdField_a_of_type_JavaLangString, "%%%共有" + ((Map)localObject).size() + "条数据");
        }
        if ((localObject == null) || (((Map)localObject).size() <= 0)) {
          break;
        }
        localObject = ((Map)localObject).entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject).next();
        LogUtility.a(jdField_a_of_type_JavaLangString, ">>>数据：key=" + (String)localEntry.getKey() + ",value=" + (String)localEntry.getValue());
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localEntry.getKey()))
        {
          LogUtility.d(jdField_a_of_type_JavaLangString, "列表已经包含，跳过");
          continue;
        }
        localNoticeIdentity = a((String)localEntry.getValue());
      }
      catch (Exception localException)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "init id from local error:" + localException.getMessage(), localException);
        return;
      }
      AppNotificationManager.NoticeIdentity localNoticeIdentity;
      if (localNoticeIdentity != null)
      {
        LogUtility.a(jdField_a_of_type_JavaLangString, ">>>转换为数据对象：" + localNoticeIdentity.toString());
        this.g = Math.max(this.g, localNoticeIdentity.jdField_a_of_type_Int);
        LogUtility.d(jdField_a_of_type_JavaLangString, ">>>initValue=" + this.g);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEntry.getKey(), localNoticeIdentity);
      }
      else
      {
        LogUtility.e(jdField_a_of_type_JavaLangString, "init id from local en.getValue() error:");
      }
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "------------从本地初始化ID 结束------------");
  }
  
  public void b(String paramString)
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_AndroidAppNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_AndroidAppNotificationManager.cancel(((AppNotificationManager.NoticeIdentity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
  
  public void c()
  {
    try
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "&&&从本地清除 clearLocal");
      SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("APP_NOTIFICATION_IDS", 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "clear nid from local error:" + localException.getMessage(), localException);
    }
  }
  
  protected void c(String paramString)
  {
    try
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "&&&从本地删除 removeFromLocal:" + paramString);
      SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("APP_NOTIFICATION_IDS", 0).edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "remove nid from local error:" + paramString.getMessage(), paramString);
    }
  }
  
  protected void finalize()
  {
    LogUtility.e(jdField_a_of_type_JavaLangString, "finalize 清理 sp数据");
    c();
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.AppNotificationManager
 * JD-Core Version:    0.7.0.1
 */