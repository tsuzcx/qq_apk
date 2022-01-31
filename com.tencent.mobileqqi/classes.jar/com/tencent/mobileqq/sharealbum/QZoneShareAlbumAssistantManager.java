package com.tencent.mobileqq.sharealbum;

import ShareAlbumHelperProtocol.GetMyAlbumListRsp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper.LocalConfig;
import gjt;
import gju;
import gjv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.s2c.msgtype0x210.submsgtype0x4b.submsgtype0x4b.MsgBody;

public class QZoneShareAlbumAssistantManager
{
  private static QZoneShareAlbumAssistantManager jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager;
  private static final String jdField_a_of_type_JavaLangString = "ShareAlbumAssistantManager";
  protected static final boolean a = true;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QZoneRecentItemQZonePhotoAssistant jdField_a_of_type_ComTencentMobileqqSharealbumQZoneRecentItemQZonePhotoAssistant;
  QZoneShareAlbumAssistantData jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData;
  private QZoneShareAlbumAssistantManager.onShareAlbumResultListener jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener;
  QZoneShareAlbumAssistantTabData jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData;
  private Comparator jdField_a_of_type_JavaUtilComparator = new gjt(this);
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  
  private int a(List paramList)
  {
    int j = 0;
    int i = j;
    if (paramList != null)
    {
      i = j;
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          Object localObject = (String)paramList.next();
          if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() <= 0)) {
            break label105;
          }
          localObject = (QZoneShareAlbumAssistantItemData)this.jdField_a_of_type_JavaUtilMap.get(localObject);
          if ((localObject == null) || (!((QZoneShareAlbumAssistantItemData)localObject).isUnread)) {
            break label105;
          }
          i += 1;
        }
      }
    }
    label105:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public static QZoneShareAlbumAssistantManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager == null) {
        jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager = new QZoneShareAlbumAssistantManager();
      }
      return jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager;
    }
    finally {}
  }
  
  private String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      a(paramQQAppInterface);
      paramQQAppInterface.a();
      if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null) {
        return this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.account;
      }
      return "";
    }
    return "";
  }
  
  private void a(EntityManager paramEntityManager)
  {
    if ((a() != null) || (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null)) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData = ((QZoneShareAlbumAssistantTabData)paramEntityManager.a(QZoneShareAlbumAssistantTabData.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        if (QLog.isColorLevel())
        {
          if ("ShareAlbum get assitant data:" + this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData == null)
          {
            paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.account;
            QLog.d("ShareAlbumAssistantManager", 2, paramEntityManager);
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null) || (a() == null)) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData = new QZoneShareAlbumAssistantTabData(a().getAccount());
          return;
        }
      }
      catch (Exception paramEntityManager)
      {
        for (;;)
        {
          paramEntityManager.printStackTrace();
          if (QLog.isColorLevel())
          {
            QLog.e("ShareAlbumAssistantManager", 2, "ShareAlbum doInitTabData error " + paramEntityManager.getMessage());
            continue;
            paramEntityManager = "null";
          }
        }
      }
    }
  }
  
  private void a(QZoneShareAlbumAssistantData paramQZoneShareAlbumAssistantData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.albumNum = paramQZoneShareAlbumAssistantData.myAlbumNames.size();
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.lastmsgtime = paramQZoneShareAlbumAssistantData.showTime;
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.msg = paramQZoneShareAlbumAssistantData.showText;
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.unread = paramQZoneShareAlbumAssistantData.showUnread;
    }
  }
  
  private void a(QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData, QQAppInterface paramQQAppInterface)
  {
    if (paramQZoneShareAlbumAssistantItemData == null) {
      return;
    }
    if (paramQQAppInterface == null) {}
    for (QQAppInterface localQQAppInterface = a();; localQQAppInterface = paramQQAppInterface)
    {
      a(a(), paramQZoneShareAlbumAssistantItemData);
      if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData != null) {
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.addPushAlbumID(paramQZoneShareAlbumAssistantItemData.albumID);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.albumNum = this.jdField_a_of_type_JavaUtilList.size();
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.unread = a(this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.myAlbumNames);
        i(localQQAppInterface);
      }
      if ((a(paramQQAppInterface)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        b(paramQQAppInterface, false);
      }
      e(localQQAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener.a(paramQZoneShareAlbumAssistantItemData);
      return;
    }
  }
  
  private void a(submsgtype0x4b.MsgBody paramMsgBody, QQAppInterface paramQQAppInterface)
  {
    if (paramMsgBody.string_albumid.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum 1相册id:" + paramMsgBody.string_albumid.get() + "");
      }
    }
    for (String str1 = paramMsgBody.string_albumid.get();; str1 = "")
    {
      if (paramMsgBody.string_coverUrl.has()) {
        if (QLog.isColorLevel()) {
          QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum 2相册封面url:" + paramMsgBody.string_coverUrl.get() + "");
        }
      }
      for (String str2 = paramMsgBody.string_coverUrl.get();; str2 = "")
      {
        if (paramMsgBody.string_albumName.has()) {
          if (QLog.isColorLevel()) {
            QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum 3相册名:" + paramMsgBody.string_albumName.get() + "");
          }
        }
        for (String str3 = paramMsgBody.string_albumName.get();; str3 = "")
        {
          long l1 = 0L;
          if (paramMsgBody.uint64_opuin.has())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum 4操作者UIN:" + paramMsgBody.uint64_opuin.get() + "");
            }
            l1 = paramMsgBody.uint64_opuin.get();
          }
          if (paramMsgBody.uint32_time.has()) {
            if (QLog.isColorLevel()) {
              QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum 5操作时间:" + paramMsgBody.uint32_time.get() + "");
            }
          }
          for (int i = paramMsgBody.uint32_time.get();; i = 0)
          {
            if (paramMsgBody.uint32_pic_cnt.has()) {
              if (QLog.isColorLevel()) {
                QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum 6上传张数（上传push时填）:" + paramMsgBody.uint32_pic_cnt.get() + "");
              }
            }
            for (int j = paramMsgBody.uint32_pic_cnt.get();; j = 0)
            {
              if (paramMsgBody.string_push_msg_helper.has()) {
                if (QLog.isColorLevel()) {
                  QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum 7PUSH消息(助手消息):" + paramMsgBody.string_push_msg_helper.get() + "");
                }
              }
              for (String str4 = paramMsgBody.string_push_msg_helper.get();; str4 = "")
              {
                if (paramMsgBody.string_push_msg_album.has()) {
                  if (QLog.isColorLevel()) {
                    QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum 8PUSH消息(相册列表):" + paramMsgBody.string_push_msg_album.get() + "");
                  }
                }
                for (String str5 = paramMsgBody.string_push_msg_album.get();; str5 = "")
                {
                  Object localObject = new ArrayList();
                  if (paramMsgBody.rpt_uint64_user.has()) {
                    localObject = paramMsgBody.rpt_uint64_user.get();
                  }
                  for (;;)
                  {
                    if (TextUtils.isEmpty(str1)) {
                      return;
                    }
                    QZoneShareAlbumAssistantItemData localQZoneShareAlbumAssistantItemData = (QZoneShareAlbumAssistantItemData)this.jdField_a_of_type_JavaUtilMap.get(str1);
                    if (localQZoneShareAlbumAssistantItemData == null) {
                      localQZoneShareAlbumAssistantItemData = new QZoneShareAlbumAssistantItemData();
                    }
                    for (;;)
                    {
                      localQZoneShareAlbumAssistantItemData.albumID = str1;
                      localQZoneShareAlbumAssistantItemData.albumName = str3;
                      if (!TextUtils.isEmpty(str5)) {
                        localQZoneShareAlbumAssistantItemData.desc = str5;
                      }
                      if (paramMsgBody.uint32_usr_total.has()) {
                        localQZoneShareAlbumAssistantItemData.userCount = paramMsgBody.uint32_usr_total.get();
                      }
                      localQZoneShareAlbumAssistantItemData.users = "";
                      if ((localObject != null) && (((List)localObject).size() > 0))
                      {
                        paramMsgBody = ((List)localObject).iterator();
                        int k = 0;
                        if (paramMsgBody.hasNext())
                        {
                          long l2 = ((Long)paramMsgBody.next()).longValue();
                          k += 1;
                          if (k == ((List)localObject).size()) {}
                          for (localQZoneShareAlbumAssistantItemData.users += l2;; localQZoneShareAlbumAssistantItemData.users = (localQZoneShareAlbumAssistantItemData.users + l2 + ";")) {
                            break;
                          }
                        }
                      }
                      localQZoneShareAlbumAssistantItemData.lastmsgtime = i;
                      if (!TextUtils.isEmpty(str2)) {
                        localQZoneShareAlbumAssistantItemData.url = str2;
                      }
                      if ((paramQQAppInterface != null) && (paramQQAppInterface.getAccount() != null) && (paramQQAppInterface.getAccount().equals(String.valueOf(l1)))) {}
                      for (;;)
                      {
                        if ((!TextUtils.isEmpty(str4)) && (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null))
                        {
                          this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.msg = str4;
                          this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.lastmsgtime = i;
                        }
                        if (i > 0) {
                          a(i);
                        }
                        a(localQZoneShareAlbumAssistantItemData, paramQQAppInterface);
                        return;
                        if (j == 0) {}
                        localQZoneShareAlbumAssistantItemData.unreadCount += 1L;
                        if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener != null) {
                          localQZoneShareAlbumAssistantItemData.isUnread = false;
                        } else {
                          localQZoneShareAlbumAssistantItemData.isUnread = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    boolean bool;
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (QZoneShareAlbumAssistantItemData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      if (paramString == null) {}
    }
    return false;
  }
  
  /* Error */
  private void b(EntityManager arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 203	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: ifnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 31	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +12 -> 30
    //   21: ldc 9
    //   23: iconst_2
    //   24: ldc_w 374
    //   27: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aload_1
    //   31: ldc 71
    //   33: iconst_0
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: ldc_w 376
    //   41: aconst_null
    //   42: invokevirtual 379	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +147 -> 194
    //   50: aload_1
    //   51: invokeinterface 46 1 0
    //   56: ifle +138 -> 194
    //   59: aload_1
    //   60: aload_0
    //   61: getfield 38	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantManager:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   64: invokestatic 385	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   67: aload_0
    //   68: new 301	java/util/ArrayList
    //   71: dup
    //   72: aload_1
    //   73: invokespecial 388	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   76: putfield 203	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   79: aload_0
    //   80: getfield 203	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   83: ifnonnull +29 -> 112
    //   86: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +12 -> 101
    //   92: ldc 9
    //   94: iconst_2
    //   95: ldc_w 390
    //   98: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_0
    //   102: new 301	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 302	java/util/ArrayList:<init>	()V
    //   109: putfield 203	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   112: aload_0
    //   113: getfield 203	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   116: invokeinterface 50 1 0
    //   121: astore_1
    //   122: aload_1
    //   123: invokeinterface 56 1 0
    //   128: ifeq +58 -> 186
    //   131: aload_1
    //   132: invokeinterface 60 1 0
    //   137: checkcast 71	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantItemData
    //   140: astore_3
    //   141: aload_3
    //   142: ifnull -20 -> 122
    //   145: aload_3
    //   146: getfield 198	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantItemData:albumID	Ljava/lang/String;
    //   149: ifnull -27 -> 122
    //   152: aload_0
    //   153: getfield 31	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   156: aload_3
    //   157: getfield 198	com/tencent/mobileqq/sharealbum/QZoneShareAlbumAssistantItemData:albumID	Ljava/lang/String;
    //   160: aload_3
    //   161: invokeinterface 394 3 0
    //   166: pop
    //   167: goto -45 -> 122
    //   170: astore_1
    //   171: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +12 -> 186
    //   177: ldc 9
    //   179: iconst_2
    //   180: ldc_w 396
    //   183: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_2
    //   187: monitorexit
    //   188: return
    //   189: astore_1
    //   190: aload_2
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    //   194: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq -118 -> 79
    //   200: ldc 9
    //   202: iconst_2
    //   203: ldc_w 398
    //   206: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: goto -130 -> 79
    //   212: astore_1
    //   213: aload_1
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	QZoneShareAlbumAssistantManager
    //   12	179	2	localMap	Map
    //   140	21	3	localQZoneShareAlbumAssistantItemData	QZoneShareAlbumAssistantItemData
    // Exception table:
    //   from	to	target	type
    //   15	30	170	java/lang/Exception
    //   30	46	170	java/lang/Exception
    //   50	79	170	java/lang/Exception
    //   79	101	170	java/lang/Exception
    //   101	112	170	java/lang/Exception
    //   112	122	170	java/lang/Exception
    //   122	141	170	java/lang/Exception
    //   145	167	170	java/lang/Exception
    //   194	209	170	java/lang/Exception
    //   186	188	189	finally
    //   190	192	189	finally
    //   213	215	189	finally
    //   15	30	212	finally
    //   30	46	212	finally
    //   50	79	212	finally
    //   79	101	212	finally
    //   101	112	212	finally
    //   112	122	212	finally
    //   122	141	212	finally
    //   145	167	212	finally
    //   171	186	212	finally
    //   194	209	212	finally
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      localEntityManager.a(QZoneShareAlbumAssistantItemData.class);
      localEntityManager.a(QZoneShareAlbumAssistantTabData.class);
      localEntityManager.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void d()
  {
    if (a() == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    b(localEntityManager);
    a(localEntityManager);
    e();
    localEntityManager.a();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData == null) {
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData = new QZoneShareAlbumAssistantData(a().getAccount());
    }
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.ensusureLocalName(this.jdField_a_of_type_JavaUtilMap);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.albumNum != this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.myAlbumNames.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum recovery failed reset post time 0");
      }
      a(0L);
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager != null) && (jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager = null;
    }
  }
  
  private void n(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void o(QQAppInterface paramQQAppInterface)
  {
    if (a() == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(1009));
  }
  
  private void p(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData != null)
    {
      Object localObject2 = a(a());
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new HashMap();
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.getAlbumRemoveItems((Map)localObject1);
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.getAlbumItems((Map)localObject1);
        a((List)localObject2, paramQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.showUnread = a(this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.myAlbumNames);
        a(this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData);
        a(a(), this.jdField_a_of_type_JavaUtilList);
        i(a());
      }
    }
  }
  
  public int a()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.unread;
  }
  
  public long a()
  {
    if (a() == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return 0L;
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    } while (localSharedPreferences == null);
    return localSharedPreferences.getLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131562905) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0L);
  }
  
  public QZoneShareAlbumAssistantData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData;
  }
  
  public QZoneShareAlbumAssistantItemData a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return (QZoneShareAlbumAssistantItemData)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return null;
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null) {
      return this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.msg;
    }
    return "";
  }
  
  public List a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      d();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public Map a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      d();
    }
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.unread = 0;
      i(a());
    }
  }
  
  public void a(long paramLong)
  {
    if (a() == null) {}
    do
    {
      return;
      localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    } while (localObject == null);
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131562905) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramLong);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void a(GetMyAlbumListRsp paramGetMyAlbumListRsp, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    n(paramQQAppInterface);
    d();
    this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.decodeRsp(paramGetMyAlbumListRsp);
    p(paramQQAppInterface);
    if ((a(paramQQAppInterface)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      b(paramQQAppInterface, false);
    }
    f(paramQQAppInterface);
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData instanceof QZoneRecentItemQZonePhotoAssistant)) {
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneRecentItemQZonePhotoAssistant = ((QZoneRecentItemQZonePhotoAssistant)paramRecentBaseData);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = a(paramQQAppInterface);
      }
      if ((this.jdField_b_of_type_JavaLangString == null) || ((str != null) && (!this.jdField_b_of_type_JavaLangString.equals(str))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareAlbumAssistantManager", 2, "sharealbum changeAccout");
        }
        this.jdField_b_of_type_JavaLangString = str;
        this.jdField_a_of_type_JavaUtilList = null;
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData = null;
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData = null;
        this.jdField_a_of_type_JavaUtilMap.clear();
        c();
        a(0L);
      }
      d();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      n(paramQQAppInterface);
    } while (paramQZoneShareAlbumAssistantItemData == null);
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    a(paramQQAppInterface, paramQZoneShareAlbumAssistantItemData);
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum saveShareAlbumInfos album:" + paramQZoneShareAlbumAssistantItemData.albumID);
    }
    paramQQAppInterface.a();
    QZoneHelper.LocalConfig.a(paramQZoneShareAlbumAssistantItemData.albumID + "_cover", paramQZoneShareAlbumAssistantItemData.url);
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      n(paramQQAppInterface);
    } while ((paramList == null) || (paramList.size() <= 0));
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      QZoneShareAlbumAssistantItemData localQZoneShareAlbumAssistantItemData = (QZoneShareAlbumAssistantItemData)paramList.get(i);
      if ((localQZoneShareAlbumAssistantItemData != null) && (!TextUtils.isEmpty(localQZoneShareAlbumAssistantItemData.albumID)))
      {
        a(paramQQAppInterface, localQZoneShareAlbumAssistantItemData);
        if (QLog.isColorLevel()) {
          QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum saveShareAlbumInfos album:" + localQZoneShareAlbumAssistantItemData.albumID);
        }
      }
      i += 1;
    }
    paramQQAppInterface.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    n(paramQQAppInterface);
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApplication().getApplicationContext());
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(paramQQAppInterface.getApplication().getApplicationContext().getString(2131561959) + paramQQAppInterface.getAccount(), paramBoolean);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (!paramBoolean)
    {
      g(paramQQAppInterface);
      return;
    }
    b(paramQQAppInterface, false);
    e(paramQQAppInterface);
    a(0L);
    b(paramQQAppInterface);
  }
  
  public void a(EntityManager paramEntityManager, QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData)
  {
    if (paramQZoneShareAlbumAssistantItemData == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramQZoneShareAlbumAssistantItemData.albumID, paramQZoneShareAlbumAssistantItemData);
      this.jdField_a_of_type_JavaUtilList.remove(paramQZoneShareAlbumAssistantItemData);
      this.jdField_a_of_type_JavaUtilList.add(paramQZoneShareAlbumAssistantItemData);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      if (paramQZoneShareAlbumAssistantItemData.getStatus() == 1000)
      {
        paramEntityManager.a(paramQZoneShareAlbumAssistantItemData);
        return;
      }
    }
    paramEntityManager.a(paramQZoneShareAlbumAssistantItemData);
  }
  
  public void a(EntityManager paramEntityManager, QZoneShareAlbumAssistantTabData paramQZoneShareAlbumAssistantTabData)
  {
    if (paramQZoneShareAlbumAssistantTabData == null) {
      return;
    }
    if (paramQZoneShareAlbumAssistantTabData.getStatus() == 1000)
    {
      paramEntityManager.a(paramQZoneShareAlbumAssistantTabData);
      return;
    }
    paramEntityManager.a(paramQZoneShareAlbumAssistantTabData);
  }
  
  public void a(QZoneShareAlbumAssistantManager.onShareAlbumResultListener paramonShareAlbumResultListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener = paramonShareAlbumResultListener;
  }
  
  public void a(QZoneShareAlbumAssistantManager.onShareAlbumResultListener paramonShareAlbumResultListener, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      if (paramonShareAlbumResultListener != null) {
        paramonShareAlbumResultListener.a(false);
      }
      return;
    }
    n(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener = paramonShareAlbumResultListener;
    ThreadManager.a(new gjv(this, paramQQAppInterface));
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (QZoneShareAlbumAssistantItemData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString != null) && (paramString.unreadCount > 0L))
      {
        paramString.unreadCount = 0L;
        paramString.isUnread = false;
        a(paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null) {
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.unread = a(this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.myAlbumNames);
      }
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
        n(paramQQAppInterface);
      } while (TextUtils.isEmpty(paramString));
      QZoneShareAlbumAssistantItemData localQZoneShareAlbumAssistantItemData = (QZoneShareAlbumAssistantItemData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localQZoneShareAlbumAssistantItemData != null)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        this.jdField_a_of_type_JavaUtilList.remove(localQZoneShareAlbumAssistantItemData);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null) {
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.albumNum = this.jdField_a_of_type_JavaUtilMap.size();
      }
      i(paramQQAppInterface);
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      if ((!a(paramQQAppInterface, paramString)) && (QLog.isColorLevel())) {
        QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum fail to remove:" + paramString);
      }
      paramQQAppInterface.a();
    } while (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener == null);
    this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener.a(true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = (QZoneShareAlbumAssistantItemData)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
      if (paramString1 != null)
      {
        paramString1.albumName = paramString2;
        a(paramString1);
        if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener.a(paramString1);
        }
      }
    }
  }
  
  public void a(List paramList, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      n(paramQQAppInterface);
    } while ((paramList == null) || (paramList.size() <= 0));
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)paramList.get(i);
      if ((!TextUtils.isEmpty(str)) && (!a(paramQQAppInterface, str)) && (QLog.isColorLevel())) {
        QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum fail to remove:" + str);
      }
      i += 1;
    }
    paramQQAppInterface.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum response onRsp:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData == null) {
      a(0L);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData != null) && (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.myAlbumNames != null) && (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.myAlbumNames.size() == 0)) {
      a(0L);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantManager$onShareAlbumResultListener.a(paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface)
  {
    if (!b(paramQQAppInterface)) {}
    for (;;)
    {
      return;
      submsgtype0x4b.MsgBody localMsgBody = new submsgtype0x4b.MsgBody();
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (localMsgBody != null)
        {
          a(localMsgBody, paramQQAppInterface);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return true;
      n(paramQQAppInterface);
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApplication().getApplicationContext());
    } while ((localSharedPreferences == null) || (paramQQAppInterface == null));
    return localSharedPreferences.getBoolean(paramQQAppInterface.getApplication().getApplicationContext().getString(2131561359) + paramQQAppInterface.getAccount(), true);
  }
  
  public boolean a(QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQZoneShareAlbumAssistantItemData != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramQZoneShareAlbumAssistantItemData.albumID))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilMap != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramQZoneShareAlbumAssistantItemData.albumID))
            {
              this.jdField_a_of_type_JavaUtilMap.remove(paramQZoneShareAlbumAssistantItemData.albumID);
              this.jdField_a_of_type_JavaUtilMap.put(paramQZoneShareAlbumAssistantItemData.albumID, paramQZoneShareAlbumAssistantItemData);
              a(a(), paramQZoneShareAlbumAssistantItemData);
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null) {
      return this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.lastmsgtime;
    }
    return 0L;
  }
  
  public void b()
  {
    EntityManager localEntityManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData != null) && (a() != null))
    {
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.getStatus() != 1000) {
        break label51;
      }
      localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData);
    }
    for (;;)
    {
      localEntityManager.a();
      return;
      label51:
      localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    n(paramQQAppInterface);
    g(paramQQAppInterface);
    if (b(paramQQAppInterface))
    {
      if (!a(paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum add to rencent assitant onlogin");
        }
        e(paramQQAppInterface);
      }
      ThreadManager.a(new gju(this, paramQQAppInterface));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum no need to show");
    }
    g(paramQQAppInterface);
  }
  
  public void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      n(paramQQAppInterface);
      localObject = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApplication().getApplicationContext());
    } while (localObject == null);
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(paramQQAppInterface.getApplication().getApplicationContext().getString(2131561359) + paramQQAppInterface.getAccount(), paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      n(paramQQAppInterface);
      a(paramQQAppInterface);
      if (!b(paramQQAppInterface)) {
        break;
      }
    } while (a(paramQQAppInterface));
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum add to rencent assitant onlogin");
    }
    e(paramQQAppInterface);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum no need to show");
    }
    g(paramQQAppInterface);
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    n(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum sendRequest");
    }
    long l = Long.parseLong(paramQQAppInterface.getAccount());
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), QZoneShareAlbumServlet.class);
    localNewIntent.putExtra("timestamp", System.currentTimeMillis() / 1000L);
    localNewIntent.putExtra("hostuin", l);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    while ((a(paramQQAppInterface)) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))) {
      return;
    }
    n(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum add assistant to recent");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneRecentItemQZonePhotoAssistant != null)
    {
      paramQQAppInterface.getApplication();
      this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneRecentItemQZonePhotoAssistant.a(paramQQAppInterface, BaseApplication.getContext());
    }
    try
    {
      ((RecentManagerFor3rdPart)paramQQAppInterface.getManager(31)).a(AppConstants.ae, 7100, BaseApplication.getContext().getString(2131559292), b(), b());
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          ((RecentManagerFor3rdPart)paramQQAppInterface.getManager(31)).a(AppConstants.ae, 7100, b());
          this.jdField_b_of_type_Boolean = true;
          o(paramQQAppInterface);
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("ShareAlbumAssistantManager", 2, "ShareAlbum add to list error");
          }
          localException1.printStackTrace();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("ShareAlbumAssistantManager", 2, "ShareAlbum refresh recent list error");
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    n(paramQQAppInterface);
    if (a().b(paramQQAppInterface))
    {
      e(paramQQAppInterface);
      return;
    }
    g(paramQQAppInterface);
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    n(paramQQAppInterface);
    RecentManagerFor3rdPart localRecentManagerFor3rdPart = (RecentManagerFor3rdPart)paramQQAppInterface.getManager(31);
    if (localRecentManagerFor3rdPart != null) {
      localRecentManagerFor3rdPart.b(AppConstants.ae, 7100);
    }
    this.jdField_b_of_type_Boolean = false;
    o(paramQQAppInterface);
  }
  
  public void h(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantManager", 2, "sharealbum clearUnreadAsssitant");
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.unread > 0)
      {
        i = 1;
        this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.unread = 0;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        int j = 0;
        while (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          ((QZoneShareAlbumAssistantItemData)this.jdField_a_of_type_JavaUtilList.get(j)).isUnread = false;
          j += 1;
        }
      }
      if (paramQQAppInterface == null) {}
      while (i == 0) {
        return;
      }
      n(paramQQAppInterface);
      long l = Long.parseLong(paramQQAppInterface.getAccount());
      NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), QZoneShareAlbumUnreadServlet.class);
      localNewIntent.putExtra("hostuin", l);
      paramQQAppInterface.startServlet(localNewIntent);
      return;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      n(paramQQAppInterface);
    } while (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData == null);
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData);
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData != null)) {
        QLog.d("ShareAlbumAssistantManager", 2, "ShareAlbum saveShareAlbumInfos album:" + this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantData.uin);
      }
      paramQQAppInterface.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShareAlbumAssistantManager", 2, "ShareAlbum saveShareAlbumAssistantTabData err:" + localException.getMessage());
        }
      }
    }
  }
  
  public void j(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    n(paramQQAppInterface);
    String str2 = "1";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantTabData.unread > 0) {
        str1 = "0";
      }
    }
    ReportController.b(paramQQAppInterface, "CliOper", "Qzone_Share_photo", "", "Share_photo", "Share_photo_clk", 0, 0, str1, "", "", "");
  }
  
  public void l(QQAppInterface paramQQAppInterface)
  {
    b(paramQQAppInterface, true);
  }
  
  public void m(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    l(paramQQAppInterface);
    paramQQAppInterface.C();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager
 * JD-Core Version:    0.7.0.1
 */