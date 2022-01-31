package com.tencent.mobileqq.app;

import KQQ.ResRichSigInfo;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.CircleGroup;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.search.ContactsSearchableCircleBuddy;
import com.tencent.mobileqq.service.circle.IFriendObserver;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.mobileqq.service.circle.ISwitchObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ezo;
import ezp;
import ezr;
import ezs;
import ezt;
import ezu;
import ezv;
import ezw;
import ezx;
import ezy;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import tencent.im.cs.cmd0x6ff.subcmd0x111.GroupInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x111.OneRenMaiFrd;
import tencent.im.cs.cmd0x6ff.subcmd0x111.RenMaiInfo;

public class CircleManager
  implements Manager
{
  public static final int a = -2;
  public static final String a = "CircleManager";
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "param_WIFICircleDownloadFlow", "param_WIFIFlow", "param_Flow" };
  public static final int b = -1;
  public static final String b = "CircleManager_Detail";
  private static final boolean jdField_b_of_type_Boolean = true;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "param_XGCircleDownloadFlow", "param_XGFlow", "param_Flow" };
  public static final int c = 0;
  private static final String jdField_c_of_type_JavaLangString = "pref_circle_";
  public static final int d = 1;
  private static long jdField_d_of_type_Long = 0L;
  private static final String jdField_d_of_type_JavaLangString = "circle_data_update_stamp";
  private static final boolean jdField_d_of_type_Boolean = false;
  public static final int e = 2;
  private static final long jdField_e_of_type_Long = 30000L;
  private static final String jdField_e_of_type_JavaLangString = "circle_server_req_interval";
  private static final boolean jdField_e_of_type_Boolean = false;
  public static final int f = 3;
  private static final long jdField_f_of_type_Long = 4294967296L;
  private static final String jdField_f_of_type_JavaLangString = "circle_server_stamp";
  public static final int g = -1000;
  private static final long jdField_g_of_type_Long = 2400000L;
  private static final String jdField_g_of_type_JavaLangString = "_circle_svc";
  public static final int h = 1;
  private static final long h = 60000L;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 0;
  public static final int l = 1;
  @Deprecated
  public static final int m = 2;
  private static final int o = 1;
  private static final int q = 400;
  private static int r = 2;
  private static int s = 1;
  private static int t = 0;
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private volatile AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  private CircleObserver jdField_a_of_type_ComTencentMobileqqAppCircleObserver = new ezy(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ezx(this);
  private FriendsManagerImp jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ezo(this);
  @SuppressLint({"UseSparseArrays"})
  public HashMap a;
  public LinkedList a;
  public ConcurrentHashMap a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ezp(this);
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private long jdField_b_of_type_Long = 0L;
  public LinkedList b;
  private byte[] jdField_b_of_type_ArrayOfByte = null;
  private volatile long jdField_c_of_type_Long = 300000L;
  public LinkedList c;
  private boolean jdField_c_of_type_Boolean = false;
  private String[] jdField_c_of_type_ArrayOfJavaLangString = null;
  private int n = 0;
  private int p = 0;
  private int u = 0;
  
  static
  {
    d = 120000L;
  }
  
  public CircleManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilLinkedList = null;
    this.jdField_b_of_type_JavaUtilLinkedList = null;
    this.jdField_c_of_type_JavaUtilLinkedList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppCircleObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("pref_circle_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("circle_data_update_stamp", 0L);
    this.p = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("circle_server_stamp", 0);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("circle_server_req_interval", this.jdField_c_of_type_Long);
    e();
  }
  
  private int a()
  {
    int i2 = 0;
    int i1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("$checkUpdate | mGroupMap=");
      if (this.jdField_a_of_type_JavaUtilHashMap == null)
      {
        i1 = 0;
        localStringBuilder2.append(i1);
        localStringBuilder1.append(" | current").append(System.currentTimeMillis() / 1000L);
        localStringBuilder1.append(" | lastStamp=").append(this.jdField_a_of_type_Long / 1000L);
        localStringBuilder1.append(" | interval=").append(this.jdField_c_of_type_Long / 1000L);
        QLog.d("CircleManager", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        break label127;
      }
      i1 = 1;
    }
    label127:
    do
    {
      return i1;
      i1 = this.jdField_a_of_type_JavaUtilHashMap.size();
      break;
      i1 = i2;
    } while (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) <= this.jdField_c_of_type_Long);
    return 2;
  }
  
  private int a(boolean paramBoolean)
  {
    if (a() != 2) {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "$updateCircle_remote | checkUpdate is not remote");
      }
    }
    long l1;
    do
    {
      return -1;
      l1 = System.currentTimeMillis();
      boolean bool = NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "updateCircle_remote | isRequesting=" + this.jdField_c_of_type_Boolean + " net avaliable=" + bool + " | now=" + l1 + " | circleDataUpdateFlag=" + this.jdField_b_of_type_Long);
      }
      if (this.jdField_c_of_type_Boolean) {
        return 0;
      }
      if (!bool) {
        return -2;
      }
    } while ((Math.abs(l1 - this.jdField_b_of_type_Long) < d) && (!paramBoolean));
    c();
    return 0;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    return a(localStringBuilder.toString(), paramInt2);
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    localStringBuffer.append("http://").append(paramString);
    if (paramInt != 80) {
      localStringBuffer.append(":").append(paramInt);
    }
    localStringBuffer.append("/");
    return localStringBuffer.toString();
  }
  
  private void a(List paramList1, List paramList2, int paramInt, String paramString, boolean paramBoolean)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      CircleBuddy localCircleBuddy = (CircleBuddy)paramList1.next();
      if ((!paramBoolean) || (!a(localCircleBuddy.uin))) {
        paramList2.add(new ContactsSearchableCircleBuddy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCircleBuddy, 4294967296L, paramInt, paramString));
      }
    }
  }
  
  private void a(subcmd0x111.RenMaiInfo paramRenMaiInfo, boolean paramBoolean)
  {
    int i1 = paramRenMaiInfo.uint32_next_start_time.get();
    if (paramBoolean)
    {
      this.p = i1;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("circle_server_stamp", this.p).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "$saveRenmaiInfo | next interval = " + paramRenMaiInfo.uint32_next_interval.get());
    }
    int i2 = paramRenMaiInfo.uint32_next_interval.get();
    i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    this.jdField_c_of_type_Long = ((i1 + 300) * 1000L);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("circle_server_req_interval", this.jdField_c_of_type_Long).commit();
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  @SuppressLint({"UseSparseArrays"})
  private boolean a(subcmd0x111.RenMaiInfo paramRenMaiInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleGroup.class);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleBuddy.class);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Object localObject1 = paramRenMaiInfo.rpt_msg_group_info.get();
    HashMap localHashMap = new HashMap();
    int i1;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = ((List)localObject1).iterator();
      i1 = 0;
    }
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (subcmd0x111.GroupInfo)((Iterator)localObject1).next();
      localObject3 = new CircleGroup();
      ((CircleGroup)localObject3).showIndex = i1;
      ((CircleGroup)localObject3).groupId = ((subcmd0x111.GroupInfo)localObject2).uint32_type.get();
      ((CircleGroup)localObject3).groupName = ((subcmd0x111.GroupInfo)localObject2).bytes_name.get().toStringUtf8();
      a((Entity)localObject3);
      localHashMap.put(Integer.valueOf(((CircleGroup)localObject3).groupId), localObject3);
      i1 += 1;
      continue;
      throw new RuntimeException("msg_group_info's size is 0");
    }
    paramRenMaiInfo = paramRenMaiInfo.rpt_msg_frd.get();
    if ((paramRenMaiInfo != null) && (paramRenMaiInfo.size() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "rebuildCircleCache: updateFriendList size=" + paramRenMaiInfo.size());
      }
      localObject2 = paramRenMaiInfo.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (subcmd0x111.OneRenMaiFrd)((Iterator)localObject2).next();
        String str = String.valueOf(((subcmd0x111.OneRenMaiFrd)localObject3).uint64_uin.get());
        localObject1 = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        paramRenMaiInfo = (subcmd0x111.RenMaiInfo)localObject1;
        if (localObject1 == null) {
          paramRenMaiInfo = new CircleBuddy();
        }
        paramRenMaiInfo.uin = str;
        paramRenMaiInfo.nickName = ((subcmd0x111.OneRenMaiFrd)localObject3).bytes_nick.get().toStringUtf8();
        paramRenMaiInfo.remark = ((subcmd0x111.OneRenMaiFrd)localObject3).bytes_remark.get().toStringUtf8();
        paramRenMaiInfo.closeness = ((subcmd0x111.OneRenMaiFrd)localObject3).uint32_closeness.get();
        paramRenMaiInfo.groupId = ((subcmd0x111.OneRenMaiFrd)localObject3).uint32_group.get();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramRenMaiInfo);
        paramRenMaiInfo = (CircleGroup)localHashMap.get(paramRenMaiInfo.uin);
        if (paramRenMaiInfo != null) {
          paramRenMaiInfo.buddyCount += 1;
        }
      }
    }
    paramRenMaiInfo = localHashMap.values().iterator();
    while (paramRenMaiInfo.hasNext())
    {
      localObject1 = (CircleGroup)paramRenMaiInfo.next();
      ((CircleGroup)localObject1).buddyList = new ArrayList(((CircleGroup)localObject1).buddyCount);
    }
    paramRenMaiInfo = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (paramRenMaiInfo.hasNext())
    {
      localObject1 = (CircleBuddy)paramRenMaiInfo.next();
      if (a(((CircleBuddy)localObject1).uin))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "$updateCircle_local | buddy is friend or black");
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((CircleBuddy)localObject1).uin);
      }
      else
      {
        localObject2 = (CircleGroup)localHashMap.get(Integer.valueOf(((CircleBuddy)localObject1).groupId));
        if (localObject2 != null) {
          ((CircleGroup)localObject2).buddyList.add(localObject1);
        } else if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "$updateCircle_local | cannot find buddy" + ((CircleBuddy)localObject1).uin.substring(0, 3) + "'s group");
        }
      }
    }
    paramRenMaiInfo = localHashMap.values().iterator();
    while (paramRenMaiInfo.hasNext())
    {
      localObject1 = (CircleGroup)paramRenMaiInfo.next();
      ((CircleGroup)localObject1).buddyCount = ((CircleGroup)localObject1).buddyList.size();
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "rebuildCircleCache: groupId=" + ((CircleGroup)localObject1).groupId + "|groupName=" + ((CircleGroup)localObject1).groupName + "| buddyCount=" + ((CircleGroup)localObject1).buddyCount);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
    return true;
  }
  
  private int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "updateCircle_Local");
    }
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "updateCircle_Local | real do");
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new ezu(this).execute(new Void[0]);
    return 0;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new ezt(this));
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new ezv(this, paramString));
  }
  
  @SuppressLint({"UseSparseArrays"})
  private boolean b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleGroup.class);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleBuddy.class);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    return true;
  }
  
  private boolean b(subcmd0x111.RenMaiInfo arg1)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleGroup.class);
    Object localObject1 = ???.rpt_msg_group_info.get();
    HashMap localHashMap = new HashMap();
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = ((List)localObject1).iterator();
      i1 = 0;
    }
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (subcmd0x111.GroupInfo)((Iterator)localObject1).next();
      ??? = new CircleGroup();
      ((CircleGroup)???).showIndex = i1;
      ((CircleGroup)???).groupId = ((subcmd0x111.GroupInfo)???).uint32_type.get();
      ((CircleGroup)???).groupName = ((subcmd0x111.GroupInfo)???).bytes_name.get().toStringUtf8();
      ??? = (CircleGroup)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((CircleGroup)???).groupId));
      if (??? != null) {
        ((CircleGroup)???).buddyList = ((CircleGroup)???).buddyList;
      }
      a((Entity)???);
      localHashMap.put(Integer.valueOf(((CircleGroup)???).groupId), ???);
      i1 += 1;
      continue;
      throw new RuntimeException("msg_group_info's size is 0");
    }
    localObject1 = ???.rpt_msg_frd.get();
    boolean bool1 = bool2;
    Object localObject5;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((List)localObject1).size() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "incrementalUpdateCircle: updateFriendList size=" + ((List)localObject1).size());
        }
        ??? = ((List)localObject1).iterator();
        if (((Iterator)???).hasNext())
        {
          ??? = (subcmd0x111.OneRenMaiFrd)((Iterator)???).next();
          localObject5 = String.valueOf(((subcmd0x111.OneRenMaiFrd)???).uint64_uin.get());
          localObject1 = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject5);
          if (localObject1 == null) {
            localObject1 = new CircleBuddy();
          }
        }
      }
    }
    label1239:
    for (int i1 = 1;; i1 = 1)
    {
      for (;;)
      {
        ((CircleBuddy)localObject1).uin = ((String)localObject5);
        ((CircleBuddy)localObject1).nickName = ((subcmd0x111.OneRenMaiFrd)???).bytes_nick.get().toStringUtf8();
        ((CircleBuddy)localObject1).remark = ((subcmd0x111.OneRenMaiFrd)???).bytes_remark.get().toStringUtf8();
        ((CircleBuddy)localObject1).closeness = ((subcmd0x111.OneRenMaiFrd)???).uint32_closeness.get();
        ((CircleBuddy)localObject1).groupId = ((subcmd0x111.OneRenMaiFrd)???).uint32_group.get();
        a((Entity)localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject5, localObject1);
        if (i1 == 0) {
          break;
        }
        localObject5 = (CircleGroup)localHashMap.get(Integer.valueOf(((CircleBuddy)localObject1).groupId));
        if (localObject5 != null) {
          synchronized (((CircleGroup)localObject5).buddyList)
          {
            ((CircleGroup)localObject5).buddyList.add(localObject1);
            if (!QLog.isColorLevel()) {
              break;
            }
            break;
            if (((subcmd0x111.OneRenMaiFrd)???).uint32_group.get() != ((CircleBuddy)localObject1).groupId)
            {
              CircleGroup localCircleGroup = (CircleGroup)localHashMap.get(Integer.valueOf(((CircleBuddy)localObject1).groupId));
              if (localCircleGroup != null) {
                synchronized (localCircleGroup.buddyList)
                {
                  localCircleGroup.buddyList.remove(localObject1);
                }
              }
              if (!QLog.isColorLevel()) {
                break label1239;
              }
              QLog.d("CircleManager", 2, "incrementalUpdateCircle | Exception: can't find buddy " + ((CircleBuddy)localObject1).uin + " in group " + ((CircleBuddy)localObject1).groupId);
              break label1239;
            }
            i1 = 0;
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CircleManager_Detail", 2, "incrementalUpdateCircle | Exception: can't find group id " + ((CircleBuddy)localObject1).groupId + "while adding " + b(((CircleBuddy)localObject1).uin));
      break;
      bool1 = true;
      ??? = ???.rpt_uint64_del_frd.get();
      bool2 = bool1;
      if (??? != null)
      {
        bool2 = bool1;
        if (???.size() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CircleManager", 2, "incrementalUpdateCircle | deleteUinList size=" + ???.size() + " | " + ???.toString());
          }
          ??? = ???.iterator();
          while (???.hasNext())
          {
            ??? = String.valueOf(((Long)???.next()).longValue());
            localObject1 = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(???);
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("CircleManager", 2, "delete uin:" + b((String)???));
              }
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(???);
              ??? = (CircleGroup)localHashMap.get(Integer.valueOf(((CircleBuddy)localObject1).groupId));
              if (??? != null) {
                synchronized (((CircleGroup)???).buddyList)
                {
                  ((CircleGroup)???).buddyList.remove(localObject1);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("CircleManager", 2, "incrementalUpdateCircle | Exception: can't find group id " + ((CircleBuddy)localObject1).groupId + " while deleting");
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("CircleManager", 2, "$incrementalUpdateCircle | can't find " + b((String)???) + " in buddy cache map");
            }
          }
          bool2 = true;
        }
      }
      localObject1 = localHashMap.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ??? = (CircleGroup)((Iterator)localObject1).next();
        synchronized (((CircleGroup)???).buddyList)
        {
          ??? = ???.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject5 = (CircleBuddy)((Iterator)???).next();
            if (a(((CircleBuddy)localObject5).uin))
            {
              if (QLog.isColorLevel()) {
                QLog.d("CircleManager", 2, "$updateCircle_local | buddy is friend or black");
              }
              ((Iterator)???).remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject5);
            }
          }
        }
        ((CircleGroup)???).buddyCount = ???.size();
        if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "incrementalUpdateCircle | groupId=" + ((CircleGroup)???).groupId + "|groupName=" + ((CircleGroup)???).groupName + "|buddyCount=" + ???.size());
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
      return bool2;
    }
  }
  
  private void c()
  {
    CircleServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.p);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new ezw(this));
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: new 662	java/io/ObjectInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 173	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: invokevirtual 204	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: new 206	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: getfield 173	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 664	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   25: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 47
    //   30: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 668	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   39: invokespecial 671	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_3
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: invokevirtual 674	java/io/ObjectInputStream:readInt	()I
    //   49: istore_1
    //   50: iload_1
    //   51: ifle +23 -> 74
    //   54: aload_3
    //   55: astore_2
    //   56: aload_0
    //   57: iload_1
    //   58: newarray byte
    //   60: putfield 160	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: aload_0
    //   67: getfield 160	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   70: invokevirtual 678	java/io/ObjectInputStream:read	([B)I
    //   73: pop
    //   74: aload_3
    //   75: astore_2
    //   76: aload_3
    //   77: invokevirtual 674	java/io/ObjectInputStream:readInt	()I
    //   80: istore_1
    //   81: iload_1
    //   82: ifle +23 -> 105
    //   85: aload_3
    //   86: astore_2
    //   87: aload_0
    //   88: iload_1
    //   89: newarray byte
    //   91: putfield 162	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: aload_0
    //   98: getfield 162	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   101: invokevirtual 678	java/io/ObjectInputStream:read	([B)I
    //   104: pop
    //   105: aload_3
    //   106: astore_2
    //   107: aload_0
    //   108: aload_3
    //   109: invokevirtual 674	java/io/ObjectInputStream:readInt	()I
    //   112: putfield 166	com/tencent/mobileqq/app/CircleManager:u	I
    //   115: aload_3
    //   116: astore_2
    //   117: aload_0
    //   118: aload_3
    //   119: invokevirtual 681	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   122: checkcast 682	[Ljava/lang/String;
    //   125: checkcast 682	[Ljava/lang/String;
    //   128: putfield 164	com/tencent/mobileqq/app/CircleManager:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 685	java/io/ObjectInputStream:close	()V
    //   139: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +32 -> 174
    //   145: ldc 12
    //   147: iconst_2
    //   148: new 206	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 687
    //   158: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 166	com/tencent/mobileqq/app/CircleManager:u	I
    //   165: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 166	com/tencent/mobileqq/app/CircleManager:u	I
    //   179: return
    //   180: astore 4
    //   182: aconst_null
    //   183: astore_3
    //   184: aload_3
    //   185: astore_2
    //   186: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +35 -> 224
    //   192: aload_3
    //   193: astore_2
    //   194: ldc 12
    //   196: iconst_2
    //   197: new 206	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 689
    //   207: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 4
    //   212: invokevirtual 692	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_3
    //   225: ifnull -86 -> 139
    //   228: aload_3
    //   229: invokevirtual 685	java/io/ObjectInputStream:close	()V
    //   232: goto -93 -> 139
    //   235: astore_2
    //   236: goto -97 -> 139
    //   239: astore_3
    //   240: aconst_null
    //   241: astore_2
    //   242: aload_2
    //   243: ifnull +7 -> 250
    //   246: aload_2
    //   247: invokevirtual 685	java/io/ObjectInputStream:close	()V
    //   250: aload_3
    //   251: athrow
    //   252: astore_2
    //   253: goto -114 -> 139
    //   256: astore_2
    //   257: goto -7 -> 250
    //   260: astore_3
    //   261: goto -19 -> 242
    //   264: astore 4
    //   266: goto -82 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	CircleManager
    //   49	40	1	i1	int
    //   44	150	2	localObjectInputStream1	java.io.ObjectInputStream
    //   235	1	2	localIOException1	java.io.IOException
    //   241	6	2	localObject1	Object
    //   252	1	2	localIOException2	java.io.IOException
    //   256	1	2	localIOException3	java.io.IOException
    //   42	187	3	localObjectInputStream2	java.io.ObjectInputStream
    //   239	12	3	localObject2	Object
    //   260	1	3	localObject3	Object
    //   180	31	4	localException1	java.lang.Exception
    //   264	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	43	180	java/lang/Exception
    //   228	232	235	java/io/IOException
    //   0	43	239	finally
    //   135	139	252	java/io/IOException
    //   246	250	256	java/io/IOException
    //   45	50	260	finally
    //   56	63	260	finally
    //   65	74	260	finally
    //   76	81	260	finally
    //   87	94	260	finally
    //   96	105	260	finally
    //   107	115	260	finally
    //   117	131	260	finally
    //   186	192	260	finally
    //   194	224	260	finally
    //   45	50	264	java/lang/Exception
    //   56	63	264	java/lang/Exception
    //   65	74	264	java/lang/Exception
    //   76	81	264	java/lang/Exception
    //   87	94	264	java/lang/Exception
    //   96	105	264	java/lang/Exception
    //   107	115	264	java/lang/Exception
    //   117	131	264	java/lang/Exception
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: new 694	java/io/ObjectOutputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 173	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: invokevirtual 204	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: new 206	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: getfield 173	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 664	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   25: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 47
    //   30: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_0
    //   37: invokevirtual 698	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   40: invokespecial 701	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: astore_2
    //   44: aload_2
    //   45: astore_1
    //   46: aload_0
    //   47: getfield 160	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   50: ifnull +13 -> 63
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 160	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   59: arraylength
    //   60: ifne +71 -> 131
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: iconst_0
    //   67: invokevirtual 704	java/io/ObjectOutputStream:writeInt	(I)V
    //   70: aload_2
    //   71: astore_1
    //   72: aload_0
    //   73: getfield 162	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   76: ifnull +13 -> 89
    //   79: aload_2
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 162	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   85: arraylength
    //   86: ifne +120 -> 206
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: iconst_0
    //   93: invokevirtual 704	java/io/ObjectOutputStream:writeInt	(I)V
    //   96: aload_2
    //   97: astore_1
    //   98: aload_2
    //   99: aload_0
    //   100: getfield 166	com/tencent/mobileqq/app/CircleManager:u	I
    //   103: invokevirtual 704	java/io/ObjectOutputStream:writeInt	(I)V
    //   106: aload_2
    //   107: astore_1
    //   108: aload_2
    //   109: aload_0
    //   110: getfield 164	com/tencent/mobileqq/app/CircleManager:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   113: invokevirtual 708	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   116: aload_2
    //   117: astore_1
    //   118: aload_2
    //   119: invokevirtual 711	java/io/ObjectOutputStream:flush	()V
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 712	java/io/ObjectOutputStream:close	()V
    //   130: return
    //   131: aload_2
    //   132: astore_1
    //   133: aload_2
    //   134: aload_0
    //   135: getfield 160	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   138: arraylength
    //   139: invokevirtual 704	java/io/ObjectOutputStream:writeInt	(I)V
    //   142: aload_2
    //   143: astore_1
    //   144: aload_2
    //   145: aload_0
    //   146: getfield 160	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   149: invokevirtual 716	java/io/ObjectOutputStream:write	([B)V
    //   152: goto -82 -> 70
    //   155: astore_3
    //   156: aload_2
    //   157: astore_1
    //   158: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +34 -> 195
    //   164: aload_2
    //   165: astore_1
    //   166: ldc 12
    //   168: iconst_2
    //   169: new 206	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 718
    //   179: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_3
    //   183: invokevirtual 692	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload_2
    //   196: ifnull -66 -> 130
    //   199: aload_2
    //   200: invokevirtual 712	java/io/ObjectOutputStream:close	()V
    //   203: return
    //   204: astore_1
    //   205: return
    //   206: aload_2
    //   207: astore_1
    //   208: aload_2
    //   209: aload_0
    //   210: getfield 162	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   213: arraylength
    //   214: invokevirtual 704	java/io/ObjectOutputStream:writeInt	(I)V
    //   217: aload_2
    //   218: astore_1
    //   219: aload_2
    //   220: aload_0
    //   221: getfield 162	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   224: invokevirtual 716	java/io/ObjectOutputStream:write	([B)V
    //   227: goto -131 -> 96
    //   230: astore_3
    //   231: aload_1
    //   232: astore_2
    //   233: aload_3
    //   234: astore_1
    //   235: aload_2
    //   236: ifnull +7 -> 243
    //   239: aload_2
    //   240: invokevirtual 712	java/io/ObjectOutputStream:close	()V
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: return
    //   247: astore_2
    //   248: goto -5 -> 243
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_2
    //   254: goto -19 -> 235
    //   257: astore_3
    //   258: aconst_null
    //   259: astore_2
    //   260: goto -104 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	CircleManager
    //   45	121	1	localObject1	Object
    //   204	1	1	localException1	java.lang.Exception
    //   207	37	1	localObject2	Object
    //   245	1	1	localException2	java.lang.Exception
    //   251	1	1	localObject3	Object
    //   43	197	2	localObject4	Object
    //   247	1	2	localException3	java.lang.Exception
    //   253	7	2	localObject5	Object
    //   155	28	3	localException4	java.lang.Exception
    //   230	4	3	localObject6	Object
    //   257	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   46	53	155	java/lang/Exception
    //   55	63	155	java/lang/Exception
    //   65	70	155	java/lang/Exception
    //   72	79	155	java/lang/Exception
    //   81	89	155	java/lang/Exception
    //   91	96	155	java/lang/Exception
    //   98	106	155	java/lang/Exception
    //   108	116	155	java/lang/Exception
    //   118	122	155	java/lang/Exception
    //   133	142	155	java/lang/Exception
    //   144	152	155	java/lang/Exception
    //   208	217	155	java/lang/Exception
    //   219	227	155	java/lang/Exception
    //   199	203	204	java/lang/Exception
    //   46	53	230	finally
    //   55	63	230	finally
    //   65	70	230	finally
    //   72	79	230	finally
    //   81	89	230	finally
    //   91	96	230	finally
    //   98	106	230	finally
    //   108	116	230	finally
    //   118	122	230	finally
    //   133	142	230	finally
    //   144	152	230	finally
    //   158	164	230	finally
    //   166	195	230	finally
    //   208	217	230	finally
    //   219	227	230	finally
    //   126	130	245	java/lang/Exception
    //   239	243	247	java/lang/Exception
    //   0	44	251	finally
    //   0	44	257	java/lang/Exception
  }
  
  private void g()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 1) {
      return 2130838688;
    }
    if (paramInt == 3) {
      return 2130838689;
    }
    if (paramInt == 2) {
      return 2130838690;
    }
    return 2130840349;
  }
  
  public int a(int paramInt, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("list is null!");
    }
    paramArrayList.clear();
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return 1;
    }
    Object localObject1 = (CircleGroup)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject1 != null)
    {
      localObject1 = ((CircleGroup)localObject1).buddyList;
      Object localObject2;
      if (paramBoolean) {
        try
        {
          localObject2 = new Random();
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            CircleBuddy localCircleBuddy = (CircleBuddy)localIterator.next();
            localCircleBuddy.randomCloseness = (localCircleBuddy.closeness * (((Random)localObject2).nextInt(3) + 5));
          }
          Collections.sort((List)localObject1, new ezs(this));
        }
        finally {}
      }
      paramArrayList.ensureCapacity(((List)localObject1).size());
      try
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramArrayList.add((CircleBuddy)((Iterator)localObject2).next());
        }
      }
      finally {}
    }
    return a();
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      return b();
    }
    if (paramInt == 2) {
      return a(paramBoolean);
    }
    return -1;
  }
  
  public int a(String paramString)
  {
    paramString = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    long l1 = System.currentTimeMillis();
    if (paramString == null) {
      return 0;
    }
    if ((Math.abs(l1 - paramString.checkUpdateTime) < 2400000L) || (Math.abs(l1 - paramString.reqCheckTimeFlag) < 60000L)) {
      return 0;
    }
    return 2;
  }
  
  public int a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("list is null!");
    }
    paramArrayList.clear();
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CircleGroup localCircleGroup = (CircleGroup)((Iterator)localObject).next();
        if (localCircleGroup.buddyCount != 0) {
          paramArrayList.add(localCircleGroup);
        }
      }
    }
    Collections.sort(paramArrayList, new ezr(this));
    return a();
  }
  
  public CircleBuddy a(String paramString)
  {
    CircleBuddy localCircleBuddy2 = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    CircleBuddy localCircleBuddy1 = localCircleBuddy2;
    if (localCircleBuddy2 == null)
    {
      localCircleBuddy2 = (CircleBuddy)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleBuddy.class, paramString);
      localCircleBuddy1 = localCircleBuddy2;
      if (localCircleBuddy2 != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localCircleBuddy2);
        localCircleBuddy1 = localCircleBuddy2;
      }
    }
    return localCircleBuddy1;
  }
  
  public RichStatus a(String paramString, int paramInt)
  {
    paramString = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null)
    {
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false) {
        return paramString.getRichStatus(bool);
      }
    }
    return RichStatus.a();
  }
  
  String a()
  {
    String[] arrayOfString = this.jdField_c_of_type_ArrayOfJavaLangString;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      this.u %= arrayOfString.length;
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "getCircleSrvUrl | usingIndex = " + this.u + " | count = " + arrayOfString.length + " | result = " + arrayOfString[this.u]);
      }
      return arrayOfString[this.u];
    }
    return null;
  }
  
  public String a(CircleBuddy paramCircleBuddy)
  {
    if ((paramCircleBuddy.remark != null) && (paramCircleBuddy.remark.length() != 0)) {
      return paramCircleBuddy.remark;
    }
    if ((paramCircleBuddy.nickName != null) && (paramCircleBuddy.nickName.length() != 0)) {
      return paramCircleBuddy.nickName;
    }
    return "";
  }
  
  public String a(String paramString)
  {
    paramString = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      return a(paramString);
    }
    return "";
  }
  
  public ArrayList a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "getFourHundredSearchableBuddyies");
    }
    ArrayList localArrayList = new ArrayList(400);
    ??? = this.jdField_a_of_type_JavaUtilHashMap;
    if (??? != null)
    {
      if (??? != null)
      {
        a(new ArrayList());
        float f1 = 400.0F / this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
        Iterator localIterator = ((HashMap)???).values().iterator();
        while (localIterator.hasNext())
        {
          CircleGroup localCircleGroup = (CircleGroup)localIterator.next();
          synchronized (localCircleGroup.buddyList)
          {
            int i1 = Math.min((int)(localCircleGroup.buddyCount * f1), localCircleGroup.buddyList.size());
            a(localCircleGroup.buddyList.subList(0, i1), localArrayList, 0, null, false);
          }
        }
      }
    }
    else
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleBuddy.class, false, null, null, null, null, null, "400");
      ??? = localList;
      if (localList == null) {
        ??? = new ArrayList();
      }
      localArrayList.ensureCapacity(((List)???).size());
      a((List)???, localArrayList, 0, null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "getFourHundredSearchableBuddyies | result size = " + localArrayList.size());
    }
    b();
    return localArrayList;
  }
  
  public ArrayList a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "getSearchableBuddies | groupId=" + paramInt1);
    }
    ArrayList localArrayList = new ArrayList();
    ??? = this.jdField_a_of_type_JavaUtilHashMap;
    Object localObject3;
    if (??? != null)
    {
      if (paramInt1 == -1000) {
        localArrayList.ensureCapacity(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      }
      for (;;)
      {
        Iterator localIterator = ((HashMap)???).values().iterator();
        while (localIterator.hasNext())
        {
          CircleGroup localCircleGroup = (CircleGroup)localIterator.next();
          if ((paramInt1 == -1000) || (paramInt1 == localCircleGroup.groupId)) {
            synchronized (localCircleGroup.buddyList)
            {
              a(localCircleGroup.buddyList, localArrayList, paramInt2, localCircleGroup.groupName, false);
            }
          }
        }
        localObject3 = (CircleGroup)((HashMap)???).get(Integer.valueOf(paramInt1));
        if (localObject3 != null) {
          localArrayList.ensureCapacity(((CircleGroup)localObject3).buddyCount);
        }
      }
    }
    if (paramInt2 == 0) {
      if (paramInt1 == -1000) {
        break label328;
      }
    }
    label328:
    for (??? = "groupId=" + paramInt1;; ??? = null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleBuddy.class, false, (String)???, null, null, null, null, null);
      ??? = localObject3;
      if (localObject3 == null) {
        ??? = new ArrayList();
      }
      localArrayList.ensureCapacity(((List)???).size());
      a((List)???, localArrayList, paramInt2, null, true);
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "getSearchableBuddies | groupId=" + paramInt1 + " | inputSet size=" + localArrayList.size());
      }
      b();
      return localArrayList;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "onResponseException | current index = " + this.u);
    }
    this.u += 1;
  }
  
  void a(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      return;
    }
    label17:
    QQAppInterface localQQAppInterface;
    String str;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (!bool) {
        break label98;
      }
    }
    label98:
    for (String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;; arrayOfString = jdField_b_of_type_ArrayOfJavaLangString)
    {
      localQQAppInterface.a(str, arrayOfString, paramInt);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CircleManager", 2, "$doFlowReport | iswifi=" + bool + " | size=" + paramInt);
      return;
      bool = false;
      break label17;
    }
  }
  
  public void a(ResRichSigInfo paramResRichSigInfo)
  {
    if ((paramResRichSigInfo.cStatus == 0) || (paramResRichSigInfo.cStatus == 1))
    {
      CircleBuddy localCircleBuddy = a(String.valueOf(paramResRichSigInfo.lUin));
      if (localCircleBuddy != null)
      {
        localCircleBuddy.checkUpdateTime = System.currentTimeMillis();
        if (paramResRichSigInfo.cStatus == 1)
        {
          localCircleBuddy.setRichBuffer(paramResRichSigInfo.vbSigInfo, paramResRichSigInfo.dwTime);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCircleBuddy);
        }
      }
    }
  }
  
  void a(Card paramCard)
  {
    CircleBuddy localCircleBuddy = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramCard.uin);
    if (localCircleBuddy != null)
    {
      localCircleBuddy.nickName = paramCard.strNick;
      localCircleBuddy.setRichBuffer(paramCard.vRichSign, paramCard.lSignModifyTime);
      a(localCircleBuddy);
      localCircleBuddy.checkUpdateTime = System.currentTimeMillis();
      b(paramCard.uin);
    }
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramObject instanceof ISwitchObserver)) {
              break;
            }
            if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
              this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
            }
          } while (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject));
          this.jdField_a_of_type_JavaUtilLinkedList.add((ISwitchObserver)paramObject);
          return;
          if (!(paramObject instanceof IGroupObserver)) {
            break;
          }
          if (this.jdField_b_of_type_JavaUtilLinkedList == null) {
            this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
          }
        } while (this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject));
        this.jdField_b_of_type_JavaUtilLinkedList.add((IGroupObserver)paramObject);
        return;
      } while (!(paramObject instanceof IFriendObserver));
      if (this.jdField_c_of_type_JavaUtilLinkedList == null) {
        this.jdField_c_of_type_JavaUtilLinkedList = new LinkedList();
      }
    } while (this.jdField_c_of_type_JavaUtilLinkedList.contains(paramObject));
    this.jdField_c_of_type_JavaUtilLinkedList.add((IFriendObserver)paramObject);
  }
  
  void a(String paramString)
  {
    CircleBuddy localCircleBuddy = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localCircleBuddy != null)
    {
      ??? = (CircleGroup)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localCircleBuddy.groupId));
      if (??? == null) {}
    }
    synchronized (((CircleGroup)???).buddyList)
    {
      ((List)???).remove(localCircleBuddy);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localCircleBuddy);
      d();
      return;
    }
  }
  
  public void a(List paramList)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
      if (localObject2 != null) {
        ((CircleBuddy)localObject2).reqCheckTimeFlag = l1;
      }
    }
    localObject1 = new String[paramList.size()];
    paramList.toArray((Object[])localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "$updateRichStatus | size = " + localObject1.length);
    }
    paramList = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("isHighPriority", true);
    paramList.a((String[])localObject1, (Bundle)localObject2);
  }
  
  /* Error */
  void a(subcmd0x111.RenMaiInfo paramRenMaiInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 923	tencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo:uint32_sync_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6: invokevirtual 387	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9: istore_3
    //   10: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +41 -> 54
    //   16: ldc 12
    //   18: iconst_2
    //   19: new 206	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 925
    //   29: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokestatic 258	java/lang/System:currentTimeMillis	()J
    //   35: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc_w 927
    //   41: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_3
    //   45: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: iload_3
    //   55: getstatic 107	com/tencent/mobileqq/app/CircleManager:s	I
    //   58: if_icmpeq +75 -> 133
    //   61: iconst_1
    //   62: istore_2
    //   63: iload_2
    //   64: ifeq +203 -> 267
    //   67: aload_0
    //   68: getfield 193	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   71: invokevirtual 930	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   74: astore 5
    //   76: aload 5
    //   78: ifnull +8 -> 86
    //   81: aload 5
    //   83: invokevirtual 934	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   86: iload_3
    //   87: getstatic 105	com/tencent/mobileqq/app/CircleManager:r	I
    //   90: if_icmpne +48 -> 138
    //   93: aload_0
    //   94: invokespecial 936	com/tencent/mobileqq/app/CircleManager:b	()Z
    //   97: istore 4
    //   99: aload 5
    //   101: ifnull +8 -> 109
    //   104: aload 5
    //   106: invokevirtual 937	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   109: iload_2
    //   110: ifeq +10 -> 120
    //   113: aload_0
    //   114: aload_1
    //   115: iload 4
    //   117: invokespecial 939	com/tencent/mobileqq/app/CircleManager:a	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;Z)V
    //   120: aload 5
    //   122: ifnull +8 -> 130
    //   125: aload 5
    //   127: invokevirtual 940	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: iconst_0
    //   134: istore_2
    //   135: goto -72 -> 63
    //   138: iload_3
    //   139: getstatic 107	com/tencent/mobileqq/app/CircleManager:s	I
    //   142: if_icmpne +13 -> 155
    //   145: aload_0
    //   146: aload_1
    //   147: invokespecial 942	com/tencent/mobileqq/app/CircleManager:a	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;)Z
    //   150: istore 4
    //   152: goto -53 -> 99
    //   155: iload_3
    //   156: getstatic 109	com/tencent/mobileqq/app/CircleManager:t	I
    //   159: if_icmpne +13 -> 172
    //   162: aload_0
    //   163: aload_1
    //   164: invokespecial 944	com/tencent/mobileqq/app/CircleManager:b	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;)Z
    //   167: istore 4
    //   169: goto -70 -> 99
    //   172: new 485	java/lang/RuntimeException
    //   175: dup
    //   176: new 206	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 946
    //   186: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload_3
    //   190: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokespecial 490	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   199: athrow
    //   200: astore_1
    //   201: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +32 -> 236
    //   207: ldc 12
    //   209: iconst_2
    //   210: new 206	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 948
    //   220: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_1
    //   224: invokevirtual 692	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   227: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 5
    //   238: ifnull -108 -> 130
    //   241: aload 5
    //   243: invokevirtual 940	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   246: goto -116 -> 130
    //   249: astore_1
    //   250: aload_0
    //   251: monitorexit
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: aload 5
    //   257: ifnull +8 -> 265
    //   260: aload 5
    //   262: invokevirtual 940	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   265: aload_1
    //   266: athrow
    //   267: aconst_null
    //   268: astore 5
    //   270: goto -194 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	CircleManager
    //   0	273	1	paramRenMaiInfo	subcmd0x111.RenMaiInfo
    //   62	73	2	i1	int
    //   9	181	3	i2	int
    //   97	71	4	bool	boolean
    //   74	195	5	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   81	86	200	java/lang/Exception
    //   86	99	200	java/lang/Exception
    //   104	109	200	java/lang/Exception
    //   113	120	200	java/lang/Exception
    //   138	152	200	java/lang/Exception
    //   155	169	200	java/lang/Exception
    //   172	200	200	java/lang/Exception
    //   2	54	249	finally
    //   54	61	249	finally
    //   67	76	249	finally
    //   125	130	249	finally
    //   241	246	249	finally
    //   260	265	249	finally
    //   265	267	249	finally
    //   81	86	254	finally
    //   86	99	254	finally
    //   104	109	254	finally
    //   113	120	254	finally
    //   138	152	254	finally
    //   155	169	254	finally
    //   172	200	254	finally
    //   201	236	254	finally
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      CircleServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean1);
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562225) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean1).commit();
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool1 = bool2;
    if (paramArrayOfByte1 != null) {}
    for (bool1 = bool2;; bool1 = bool2) {
      try
      {
        if (paramArrayOfByte1.length > 0)
        {
          this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
          bool1 = true;
        }
        bool2 = bool1;
        if (paramArrayOfByte2 != null)
        {
          bool2 = bool1;
          if (paramArrayOfByte2.length > 0)
          {
            this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
            bool2 = true;
          }
        }
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
        {
          this.u = 0;
          this.jdField_c_of_type_ArrayOfJavaLangString = paramArrayOfString;
          bool1 = bool3;
          if (bool1) {
            f();
          }
          if (QLog.isColorLevel()) {
            QLog.d("CircleManager", 2, "saveCircleSrvParam | changed = " + bool1 + " | usingIndex = " + this.u);
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    BaseApplicationImpl.a.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    return true;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp == null) || (paramString.length() < 4)) {
      bool = false;
    }
    do
    {
      Friends localFriends;
      do
      {
        return bool;
        localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a(paramString);
        if ((localFriends == null) || (localFriends.groupid < 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CircleManager", 2, "$beFriendOrBlack | " + b(paramString) + " is friend, " + localFriends.groupid);
      return true;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CircleManager", 2, "$beFriendOrBlack | " + b(paramString) + " is in black list");
    return true;
    return false;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      CircleServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562225) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
  }
  
  byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int b(int paramInt)
  {
    return paramInt - 1;
  }
  
  String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() < 4)) {
      return paramString;
    }
    return paramString.substring(0, 3);
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (this.jdField_b_of_type_JavaUtilLinkedList != null) {
        this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
      }
    } while (this.jdField_c_of_type_JavaUtilLinkedList == null);
    this.jdField_c_of_type_JavaUtilLinkedList.remove(paramObject);
  }
  
  /* Error */
  public void b(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 193	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 930	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 934	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   12: aload_1
    //   13: invokeinterface 349 1 0
    //   18: astore_1
    //   19: aload_1
    //   20: invokeinterface 354 1 0
    //   25: ifeq +66 -> 91
    //   28: aload_1
    //   29: invokeinterface 358 1 0
    //   34: checkcast 360	com/tencent/mobileqq/data/CircleBuddy
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 193	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   42: aload_3
    //   43: invokevirtual 423	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   46: pop
    //   47: goto -28 -> 19
    //   50: astore_1
    //   51: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +32 -> 86
    //   57: ldc 12
    //   59: iconst_2
    //   60: new 206	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 1004
    //   70: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 692	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_2
    //   87: invokevirtual 940	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   90: return
    //   91: aload_2
    //   92: invokevirtual 937	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   95: aload_2
    //   96: invokevirtual 940	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   99: return
    //   100: astore_1
    //   101: aload_2
    //   102: invokevirtual 940	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	CircleManager
    //   0	107	1	paramList	List
    //   7	95	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   37	6	3	localCircleBuddy	CircleBuddy
    // Exception table:
    //   from	to	target	type
    //   8	19	50	java/lang/Exception
    //   19	47	50	java/lang/Exception
    //   91	95	50	java/lang/Exception
    //   8	19	100	finally
    //   19	47	100	finally
    //   51	86	100	finally
    //   91	95	100	finally
  }
  
  /* Error */
  void b(subcmd0x111.RenMaiInfo paramRenMaiInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 923	tencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo:uint32_sync_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6: invokevirtual 387	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9: istore_2
    //   10: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +41 -> 54
    //   16: ldc 12
    //   18: iconst_2
    //   19: new 206	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 1006
    //   29: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokestatic 258	java/lang/System:currentTimeMillis	()J
    //   35: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc_w 927
    //   41: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_2
    //   45: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: getstatic 107	com/tencent/mobileqq/app/CircleManager:s	I
    //   57: istore_3
    //   58: iload_2
    //   59: iload_3
    //   60: if_icmpeq +6 -> 66
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 1008	com/tencent/mobileqq/app/CircleManager:c	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;)V
    //   71: aload_0
    //   72: aload_1
    //   73: iconst_1
    //   74: invokespecial 939	com/tencent/mobileqq/app/CircleManager:a	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;Z)V
    //   77: goto -14 -> 63
    //   80: astore_1
    //   81: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq -21 -> 63
    //   87: ldc 12
    //   89: iconst_2
    //   90: aload_1
    //   91: invokestatic 1014	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   94: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: goto -34 -> 63
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	CircleManager
    //   0	105	1	paramRenMaiInfo	subcmd0x111.RenMaiInfo
    //   9	52	2	i1	int
    //   57	4	3	i2	int
    // Exception table:
    //   from	to	target	type
    //   66	77	80	java/lang/Exception
    //   2	54	100	finally
    //   54	58	100	finally
    //   66	77	100	finally
    //   81	97	100	finally
  }
  
  byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public int c(int paramInt)
  {
    return a(paramInt, false);
  }
  
  /* Error */
  public void c(subcmd0x111.RenMaiInfo paramRenMaiInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 135	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 135	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: invokevirtual 802	java/util/concurrent/ConcurrentHashMap:size	()I
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 135	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   22: invokevirtual 1020	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   25: aload_0
    //   26: getfield 135	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: invokevirtual 802	java/util/concurrent/ConcurrentHashMap:size	()I
    //   32: anewarray 89	java/lang/String
    //   35: invokeinterface 1023 2 0
    //   40: checkcast 682	[Ljava/lang/String;
    //   43: astore 7
    //   45: aload 7
    //   47: arraylength
    //   48: bipush 100
    //   50: idiv
    //   51: iconst_1
    //   52: iadd
    //   53: istore 4
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: iload 4
    //   60: if_icmpge +132 -> 192
    //   63: aconst_null
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 193	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: invokevirtual 930	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   72: astore 6
    //   74: aload 6
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 934	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   81: iload_2
    //   82: iconst_1
    //   83: iadd
    //   84: bipush 100
    //   86: imul
    //   87: aload 7
    //   89: arraylength
    //   90: invokestatic 806	java/lang/Math:min	(II)I
    //   93: istore 5
    //   95: iload_2
    //   96: bipush 100
    //   98: imul
    //   99: istore_3
    //   100: iload_3
    //   101: iload 5
    //   103: if_icmpge +34 -> 137
    //   106: aload_0
    //   107: getfield 135	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   110: aload 7
    //   112: iload_3
    //   113: aaload
    //   114: invokevirtual 511	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: checkcast 360	com/tencent/mobileqq/data/CircleBuddy
    //   120: astore 6
    //   122: aload 6
    //   124: ifnull +123 -> 247
    //   127: aload_0
    //   128: aload 6
    //   130: invokespecial 473	com/tencent/mobileqq/app/CircleManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   133: pop
    //   134: goto +113 -> 247
    //   137: aload_1
    //   138: ifnull +7 -> 145
    //   141: aload_1
    //   142: invokevirtual 937	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 940	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   153: iload_2
    //   154: iload 4
    //   156: iconst_1
    //   157: isub
    //   158: if_icmpge +9 -> 167
    //   161: ldc2_w 1024
    //   164: invokestatic 1031	java/lang/Thread:sleep	(J)V
    //   167: iload_2
    //   168: iconst_1
    //   169: iadd
    //   170: istore_2
    //   171: goto -114 -> 57
    //   174: astore 6
    //   176: aload 6
    //   178: athrow
    //   179: astore 6
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 940	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   189: aload 6
    //   191: athrow
    //   192: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -178 -> 17
    //   198: ldc 12
    //   200: iconst_2
    //   201: new 206	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 1033
    //   211: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload 4
    //   216: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: return
    //   226: astore_1
    //   227: goto -60 -> 167
    //   230: astore 6
    //   232: aconst_null
    //   233: astore_1
    //   234: goto -53 -> 181
    //   237: astore 6
    //   239: goto -58 -> 181
    //   242: astore 6
    //   244: goto -68 -> 176
    //   247: iload_3
    //   248: iconst_1
    //   249: iadd
    //   250: istore_3
    //   251: goto -151 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	CircleManager
    //   0	254	1	paramRenMaiInfo	subcmd0x111.RenMaiInfo
    //   56	115	2	i1	int
    //   99	152	3	i2	int
    //   53	162	4	i3	int
    //   93	11	5	i4	int
    //   72	57	6	localObject1	Object
    //   174	3	6	localException1	java.lang.Exception
    //   179	11	6	localObject2	Object
    //   230	1	6	localObject3	Object
    //   237	1	6	localObject4	Object
    //   242	1	6	localException2	java.lang.Exception
    //   43	68	7	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   65	74	174	java/lang/Exception
    //   176	179	179	finally
    //   161	167	226	java/lang/Exception
    //   65	74	230	finally
    //   77	95	237	finally
    //   106	122	237	finally
    //   127	134	237	finally
    //   141	145	237	finally
    //   77	95	242	java/lang/Exception
    //   106	122	242	java/lang/Exception
    //   127	134	242	java/lang/Exception
    //   141	145	242	java/lang/Exception
  }
  
  public void onDestroy()
  {
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CircleManager
 * JD-Core Version:    0.7.0.1
 */