package com.tencent.mobileqq.microapp.apkg;

import aafv;
import abhh;
import abmt;
import android.text.TextUtils;
import aqrb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class UsedAppListManager
  implements Manager
{
  private static final String TAG = "UsedAppListManager";
  public Runnable initLocalDataRunnable = new UsedAppListManager.1(this);
  private QQAppInterface mApp;
  private List<AppInfo> mUsedAppInfos = Collections.synchronizedList(new LinkedList());
  
  public UsedAppListManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("UsedAppListManager", 2, "UsedAppListManager init");
    }
    ThreadManager.excute(this.initLocalDataRunnable, 32, null, true);
  }
  
  private List<AppInfo> getLocalUsedAppInfos()
  {
    if ((this.mUsedAppInfos != null) && (this.mUsedAppInfos.size() > 0)) {
      synchronized (this.mUsedAppInfos)
      {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(this.mUsedAppInfos);
        return localLinkedList;
      }
    }
    return null;
  }
  
  private void insertAppInfo(AppInfo paramAppInfo)
  {
    if ((paramAppInfo == null) || (!paramAppInfo.isValid()))
    {
      QLog.e("UsedAppListManager", 1, "insertAppInfo error app info is invalid");
      return;
    }
    for (;;)
    {
      synchronized (this.mUsedAppInfos)
      {
        Object localObject = this.mUsedAppInfos.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label195;
        }
        AppInfo localAppInfo = (AppInfo)((Iterator)localObject).next();
        if (!localAppInfo.id.equals(paramAppInfo.id)) {
          continue;
        }
        if (localAppInfo.timestamp < paramAppInfo.timestamp)
        {
          ((Iterator)localObject).remove();
          break label195;
          if (i >= this.mUsedAppInfos.size()) {
            break label190;
          }
          localObject = (AppInfo)this.mUsedAppInfos.get(i);
          if (paramAppInfo.timestamp > ((AppInfo)localObject).timestamp)
          {
            this.mUsedAppInfos.add(i, paramAppInfo);
            i = 1;
            if (i == 0) {
              this.mUsedAppInfos.add(paramAppInfo);
            }
            saveToDB(paramAppInfo);
          }
        }
        else
        {
          return;
        }
      }
      i += 1;
      continue;
      label190:
      int i = 0;
      continue;
      label195:
      i = 0;
    }
  }
  
  public static void recordAppStart(AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = BaseApplicationImpl.getApplication().getRuntime();
          } while (localObject == null);
          if (!(localObject instanceof QQAppInterface)) {
            break;
          }
        } while (paramAppInfo.isCollectionPage());
        if (QLog.isColorLevel()) {
          QLog.d("UsedAppListManager", 2, new Object[] { "recordAppStart app id:", paramAppInfo.id, ",type:", Integer.valueOf(paramAppInfo.type) });
        }
        localObject = (QQAppInterface)localObject;
        UsedAppListManager localUsedAppListManager = (UsedAppListManager)((QQAppInterface)localObject).getManager(288);
        paramAppInfo.updateTimeStamp();
        localUsedAppListManager.insertAppInfo(paramAppInfo);
      } while (paramAppInfo.type != 2);
      paramAppInfo = (abhh)((QQAppInterface)localObject).getManager(153);
    } while ((paramAppInfo.bCL) && (paramAppInfo.Yj()));
    abmt.Hx(4);
    return;
    aafv.recordAppStart(paramAppInfo);
  }
  
  private void saveToDB(Entity paramEntity)
  {
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    EntityTransaction localEntityTransaction;
    if ((localEntityManager != null) && (paramEntity != null))
    {
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
    }
    try
    {
      updateEntity(localEntityManager, paramEntity);
      localEntityTransaction.commit();
      return;
    }
    catch (Exception paramEntity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UsedAppListManager", 2, "saveToDB exception: ", paramEntity);
      }
      return;
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
  
  private boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return paramEntityManager.update(paramEntity);
      }
    }
    QLog.d("UsedAppListManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public void getUsedAppList()
  {
    ((aqrb)this.mApp.getBusinessHandler(71)).getUsedAppList();
  }
  
  public void onDestroy() {}
  
  public void removeAllAppInfo()
  {
    if (this.mApp == null) {}
    for (;;)
    {
      return;
      QLog.i("UsedAppListManager", 1, "removeAllAppInfo");
      if (this.mUsedAppInfos != null) {}
      EntityManager localEntityManager;
      synchronized (this.mUsedAppInfos)
      {
        this.mUsedAppInfos.clear();
        localEntityManager = this.mApp.a().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.getTransaction();
      }
    }
  }
  
  /* Error */
  public void saveAppInfoList(List<AppInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 75 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 33	com/tencent/mobileqq/microapp/apkg/UsedAppListManager:mUsedAppInfos	Ljava/util/List;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 33	com/tencent/mobileqq/microapp/apkg/UsedAppListManager:mUsedAppInfos	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 33	com/tencent/mobileqq/microapp/apkg/UsedAppListManager:mUsedAppInfos	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 79 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 42	com/tencent/mobileqq/microapp/apkg/UsedAppListManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: ifnull -32 -> 13
    //   48: aload_0
    //   49: getfield 42	com/tencent/mobileqq/microapp/apkg/UsedAppListManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 203	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   55: invokevirtual 209	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -47 -> 13
    //   63: aload_3
    //   64: invokevirtual 215	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 220	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   72: new 252	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   79: astore 4
    //   81: aload_1
    //   82: invokeinterface 97 1 0
    //   87: astore_1
    //   88: aload_1
    //   89: invokeinterface 102 1 0
    //   94: ifeq +75 -> 169
    //   97: aload_1
    //   98: invokeinterface 106 1 0
    //   103: checkcast 85	com/tencent/mobileqq/microapp/apkg/AppInfo
    //   106: astore 5
    //   108: aload_0
    //   109: aload_3
    //   110: aload 5
    //   112: invokespecial 224	com/tencent/mobileqq/microapp/apkg/UsedAppListManager:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   115: pop
    //   116: aload 4
    //   118: ldc_w 297
    //   121: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 5
    //   126: getfield 300	com/tencent/mobileqq/microapp/apkg/AppInfo:name	Ljava/lang/String;
    //   129: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 302
    //   135: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: goto -51 -> 88
    //   142: astore_1
    //   143: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +13 -> 159
    //   149: ldc 10
    //   151: iconst_2
    //   152: ldc_w 304
    //   155: aload_1
    //   156: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   159: aload_2
    //   160: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   163: return
    //   164: astore_1
    //   165: aload_2
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +27 -> 199
    //   175: ldc 10
    //   177: iconst_2
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: ldc_w 306
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: aload 4
    //   192: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   199: aload_2
    //   200: invokevirtual 227	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   203: aload_2
    //   204: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   207: return
    //   208: astore_1
    //   209: aload_2
    //   210: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   213: aload_1
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	UsedAppListManager
    //   0	215	1	paramList	List<AppInfo>
    //   25	185	2	localObject	Object
    //   58	52	3	localEntityManager	EntityManager
    //   79	112	4	localStringBuilder	java.lang.StringBuilder
    //   106	19	5	localAppInfo	AppInfo
    // Exception table:
    //   from	to	target	type
    //   72	88	142	java/lang/Exception
    //   88	139	142	java/lang/Exception
    //   169	199	142	java/lang/Exception
    //   199	203	142	java/lang/Exception
    //   28	41	164	finally
    //   165	167	164	finally
    //   72	88	208	finally
    //   88	139	208	finally
    //   143	159	208	finally
    //   169	199	208	finally
    //   199	203	208	finally
  }
  
  public void syncRoamUsedListFromSrv(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UsedAppListManager", 2, "syncRoamUsedListFromSrv :" + paramString);
    }
    LinkedList localLinkedList;
    if (!TextUtils.isEmpty(paramString)) {
      localLinkedList = new LinkedList();
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("data");
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        String str1 = localJSONObject.optString("icon");
        String str2 = localJSONObject.optString("id");
        String str3 = localJSONObject.optString("name");
        long l = localJSONObject.optLong("ts");
        localLinkedList.add(new AppInfo(localJSONObject.optInt("type"), str2, str1, str3, l * 1000L, localJSONObject.optString("launchUrl")));
        i += 1;
      }
      if (localLinkedList.size() > 0)
      {
        removeAllAppInfo();
        saveAppInfoList(localLinkedList);
      }
      if (QLog.isColorLevel()) {
        QLog.d("UsedAppListManager", 2, "syncRoamUsedListFromSrv get app list:" + localLinkedList);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("UsedAppListManager", 1, "syncRoamUsedListFromSrv Exception:", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.UsedAppListManager
 * JD-Core Version:    0.7.0.1
 */