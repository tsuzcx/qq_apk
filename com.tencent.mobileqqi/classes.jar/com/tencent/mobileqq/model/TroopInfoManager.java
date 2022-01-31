package com.tencent.mobileqq.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopAppFlagInfoEntity;
import com.tencent.mobileqq.data.TroopAppUpdateTimeEntity;
import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.data.TroopVideoUrlEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;
import ggy;
import ggz;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopInfoManager
  extends Observable
  implements Manager
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "TROOP_INFO_MANAGER_CONFIG";
  public static final int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "VIDEO_GET_TIME";
  public static final int c = 1;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 2;
  private static final int g = 1;
  private static final int h = 2;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private List jdField_a_of_type_JavaUtilList = null;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private Handler jdField_b_of_type_AndroidOsHandler = null;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  private boolean jdField_b_of_type_Boolean = false;
  private Handler jdField_c_of_type_AndroidOsHandler = new ggz(this, ThreadManager.b());
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopInfoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      try
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        return;
      }
      finally {}
    }
  }
  
  private void a(List paramList)
  {
    Object localObject;
    TroopVideoUrlEntity localTroopVideoUrlEntity;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTroopVideoUrlEntity = (TroopVideoUrlEntity)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopVideoUrlEntity);
      }
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        localTroopVideoUrlEntity = new TroopVideoUrlEntity();
        localTroopVideoUrlEntity.videoUrl = ((String)localObject);
        this.jdField_a_of_type_JavaUtilList.add(localTroopVideoUrlEntity);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopVideoUrlEntity);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new ggy(this, ThreadManager.b());
    }
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1, 0, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 500L);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAppUpdateTimeEntity.class, false, null, null, null, null, null, null);
      if (localArrayList != null)
      {
        int k = localArrayList.size();
        int i = 0;
        int j = 0;
        while (i < k)
        {
          TroopAppUpdateTimeEntity localTroopAppUpdateTimeEntity = (TroopAppUpdateTimeEntity)localArrayList.get(i);
          TroopAppFlagInfoEntity localTroopAppFlagInfoEntity = new TroopAppFlagInfoEntity();
          localTroopAppFlagInfoEntity.timestamp = localTroopAppUpdateTimeEntity.timestamp;
          localTroopAppFlagInfoEntity.troopCode = localTroopAppUpdateTimeEntity.troopCode;
          localTroopAppFlagInfoEntity.isUpdated = false;
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(localTroopAppUpdateTimeEntity.troopCode), localTroopAppFlagInfoEntity);
          j += 1;
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean == true) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopMessageNavigateInfo.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)((Iterator)localObject).next();
          if (localTroopMessageNavigateInfo != null) {
            if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localTroopMessageNavigateInfo.troopCode))
            {
              localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localTroopMessageNavigateInfo.troopCode);
              if ((localTroopMessageNavigateInfo != null) && (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD))
              {
                localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_MODIFY;
                this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopMessageNavigateInfo.troopCode, localTroopMessageNavigateInfo);
              }
            }
            else
            {
              localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_NORMAL;
              this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopMessageNavigateInfo.troopCode, localTroopMessageNavigateInfo);
            }
          }
        }
      }
    }
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localIterator.next();
      if (localTroopMessageNavigateInfo != null) {
        if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 3, null);
        }
        else if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_MODIFY)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 4, null);
        }
        else if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE)
        {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localTroopMessageNavigateInfo.troopCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 5, null);
        }
      }
    }
  }
  
  private void f()
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = new JSONObject(HttpUtil.a(BaseApplication.getContext(), "http://pub.idqqimg.com/pc/misc/shouq/videohost/whitelist", "GET", null, null));
        if (((JSONObject)localObject1).getInt("ret") == 0)
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("domains");
          if (localObject1 != null)
          {
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
              if (localObject2 == null) {
                break label115;
              }
              localObject2 = ((JSONObject)localObject2).getString("dm");
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label115;
              }
              localArrayList.add(localObject2);
              break label115;
            }
          }
        }
        a(localArrayList);
        return;
      }
      catch (Exception localException)
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      label115:
      i += 1;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopVideoUrlEntity.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TroopVideoUrlEntity localTroopVideoUrlEntity = (TroopVideoUrlEntity)((Iterator)localObject).next();
          this.jdField_a_of_type_JavaUtilList.add(localTroopVideoUrlEntity);
        }
      }
    }
  }
  
  private void h()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("TROOP_INFO_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l1 = localSharedPreferences.getLong("VIDEO_GET_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_b_of_type_Boolean) && (l2 - l1 < 86400L)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("VIDEO_GET_TIME", l2).commit();
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(this.jdField_c_of_type_AndroidOsHandler.obtainMessage(0, 0, 0));
  }
  
  public int a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)))
    {
      paramString = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString.status == TroopMessageNavigateInfo.STATUS_DELETE) {
        return -1;
      }
      return paramString.type;
    }
    return -1;
  }
  
  public long a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)))
    {
      paramString = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString.status == TroopMessageNavigateInfo.STATUS_DELETE) {
        return 0L;
      }
      return paramString.msgseq;
    }
    return 0L;
  }
  
  public TroopAppFlagInfoEntity a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      c();
    }
    TroopAppFlagInfoEntity localTroopAppFlagInfoEntity = new TroopAppFlagInfoEntity();
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramString != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null)) {
      localTroopAppFlagInfoEntity.copyFrom((TroopAppFlagInfoEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
    }
    return localTroopAppFlagInfoEntity;
  }
  
  public MessageInfo a(String paramString)
  {
    return (MessageInfo)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public MessageInfo a(String paramString, MessageInfo paramMessageInfo)
  {
    MessageInfo localMessageInfo = (MessageInfo)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((paramMessageInfo == null) || (!paramMessageInfo.a())) {
      return localMessageInfo;
    }
    if (localMessageInfo == null)
    {
      paramMessageInfo = new MessageInfo(paramMessageInfo);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramMessageInfo);
      return paramMessageInfo;
    }
    localMessageInfo.a(paramMessageInfo);
    return localMessageInfo;
  }
  
  public void a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("TROOP_INFO_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l1 = localSharedPreferences.getLong("VIDEO_GET_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_b_of_type_Boolean) && (l2 - l1 < 86400L)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("VIDEO_GET_TIME", l2).commit();
    f();
  }
  
  public void a(String paramString, int paramInt)
  {
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((paramInt == localTroopMessageNavigateInfo.type) || (paramInt == 0))
      {
        if (localTroopMessageNavigateInfo.status != TroopMessageNavigateInfo.STATUS_ADD) {
          break label55;
        }
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      }
    }
    return;
    label55:
    localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_DELETE;
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (paramInt <= 0) {}
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    do
    {
      return;
      localTroopMessageNavigateInfo = new TroopMessageNavigateInfo();
      localTroopMessageNavigateInfo.type = paramInt;
      localTroopMessageNavigateInfo.troopCode = paramString1;
      localTroopMessageNavigateInfo.msgseq = paramLong;
      localTroopMessageNavigateInfo.summary = paramString2;
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)) {
        break;
      }
      paramString2 = (TroopMessageNavigateInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    } while ((paramInt < paramString2.type) && (paramString2.status != TroopMessageNavigateInfo.STATUS_DELETE));
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localTroopMessageNavigateInfo);
    if (paramString2.status == TroopMessageNavigateInfo.STATUS_ADD)
    {
      localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
      return;
    }
    localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_MODIFY;
    return;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localTroopMessageNavigateInfo);
    localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
  }
  
  public void a(String paramString, TroopAppFlagInfoEntity paramTroopAppFlagInfoEntity)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      c();
    }
    TroopAppFlagInfoEntity localTroopAppFlagInfoEntity = new TroopAppFlagInfoEntity();
    localTroopAppFlagInfoEntity.copyFrom(paramTroopAppFlagInfoEntity);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localTroopAppFlagInfoEntity);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramTroopAppFlagInfoEntity.setStatus(1000);
    paramString.a(paramTroopAppFlagInfoEntity);
  }
  
  public void a(String paramString, MessageInfo paramMessageInfo)
  {
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramMessageInfo);
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) && (!this.jdField_b_of_type_Boolean);
  }
  
  public boolean a(String paramString)
  {
    g();
    if (a()) {
      return true;
    }
    h();
    paramString = paramString.toLowerCase();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (paramString.indexOf(((TroopVideoUrlEntity)localIterator.next()).videoUrl.toLowerCase()) != -1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public MessageInfo b(String paramString)
  {
    return (MessageInfo)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public boolean b()
  {
    boolean bool = VersionUtils.d();
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    int i;
    if (str1.equalsIgnoreCase("Xiaomi")) {
      if ((str2.equalsIgnoreCase("MI 1S")) || (str2.equalsIgnoreCase("MI 1SC"))) {
        i = 0;
      }
    }
    for (;;)
    {
      if ((bool) && (i != 0))
      {
        return true;
        if (str2.equalsIgnoreCase("MI-ONE Plus")) {
          i = 0;
        }
      }
      else
      {
        return false;
      }
      i = 1;
    }
  }
  
  public void onDestroy()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.TroopInfoManager
 * JD-Core Version:    0.7.0.1
 */