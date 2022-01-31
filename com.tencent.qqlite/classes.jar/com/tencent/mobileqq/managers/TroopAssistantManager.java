package com.tencent.mobileqq.managers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dxi;
import dxj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TroopAssistantManager
{
  public static final int a = -1;
  private static TroopAssistantManager jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager;
  public static final String a = "init_troop_assistant";
  protected static final boolean a = true;
  public static final int b = 1;
  public static final String b = "show_troop_assistant_list_notity";
  public static final int c = 3;
  public static final String c = "troop_assistant_be_del";
  public static final int d = 2;
  public static final String d = "troop_message_setting_first";
  protected static final int e = 0;
  public static final String e = "troop_assis_show_in_msg";
  protected static final int f = 1;
  public static final String f = "troop_assis_show_on_top";
  protected static final int g = 2;
  public static final String g = "troop_assis_last_read_time";
  protected static final int h = 3;
  public static final String h = "troop_assis_new_unread_list";
  public static final int i = 99;
  private static final String jdField_j_of_type_JavaLangString = "should_update_troop_assistant";
  private static final int jdField_k_of_type_Int = 2;
  private static final String jdField_k_of_type_JavaLangString = "tag_troop_ignore_tip";
  private static final String jdField_l_of_type_JavaLangString = "tag_troop_assist_tip_time";
  private long jdField_a_of_type_Long = 0L;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d;
  private boolean e = false;
  private boolean f = false;
  private String i;
  private int jdField_j_of_type_Int;
  private int jdField_l_of_type_Int;
  
  private TroopAssistantManager()
  {
    this.j = 0;
    this.l = -1;
  }
  
  private TroopAssistantData a(QQAppInterface arg1, String paramString)
  {
    a(???);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopAssistantData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private TroopAssistantData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      paramEntityManager = localTroopAssistantData;
      if (localTroopAssistantData == null)
      {
        localTroopAssistantData = new TroopAssistantData();
        localTroopAssistantData.troopUin = paramString;
        paramQQAppInterface = paramQQAppInterface.a();
        paramEntityManager = localTroopAssistantData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString, 1);
          paramEntityManager = localTroopAssistantData;
          if (paramQQAppInterface != null)
          {
            localTroopAssistantData.lastdrafttime = paramQQAppInterface.getTime();
            paramEntityManager = localTroopAssistantData;
          }
        }
      }
      return paramEntityManager;
    }
  }
  
  public static TroopAssistantManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager == null) {
        jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager = new TroopAssistantManager();
      }
      TroopAssistantManager localTroopAssistantManager = jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager;
      return localTroopAssistantManager;
    }
    finally {}
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      k(paramQQAppInterface);
      return;
    }
    finally {}
  }
  
  private void a(EntityManager arg1)
  {
    try
    {
      localObject1 = ???.a(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort((List)localObject1, new dxj(this));
      }
    }
    catch (Exception ???)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        Object localObject1;
        this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
        }
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          this.jdField_a_of_type_JavaUtilMap.clear();
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label166;
          }
          TroopAssistantData localTroopAssistantData = (TroopAssistantData)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilMap.put(localTroopAssistantData.troopUin, localTroopAssistantData);
        }
        ??? = ???;
        if (QLog.isColorLevel()) {
          QLog.e("TroopAssistantManager", 2, "initTroopAssistantRecent");
        }
        return;
      }
    }
    finally {}
    label166:
  }
  
  private void a(EntityManager paramEntityManager, TroopAssistantData paramTroopAssistantData)
  {
    if (paramTroopAssistantData == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramTroopAssistantData.troopUin, paramTroopAssistantData);
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramTroopAssistantData);
        int n = this.jdField_a_of_type_JavaUtilList.size();
        m = 0;
        if (m >= n) {
          break label195;
        }
        TroopAssistantData localTroopAssistantData = (TroopAssistantData)this.jdField_a_of_type_JavaUtilList.get(m);
        if (Math.max(paramTroopAssistantData.lastmsgtime, paramTroopAssistantData.lastdrafttime) > Math.max(localTroopAssistantData.lastmsgtime, localTroopAssistantData.lastdrafttime))
        {
          this.jdField_a_of_type_JavaUtilList.add(m, paramTroopAssistantData);
          m = 1;
          if (m == 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramTroopAssistantData);
          }
          if (paramTroopAssistantData.getStatus() == 1000)
          {
            paramEntityManager.a(paramTroopAssistantData);
            return;
            paramEntityManager = finally;
            throw paramEntityManager;
          }
        }
        else
        {
          m += 1;
        }
      }
      paramEntityManager.a(paramTroopAssistantData);
      return;
      label195:
      int m = 0;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    boolean bool = false;
    Object localObject = (FriendManager)paramQQAppInterface.getManager(8);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    if (localObject == null) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      if ((this.c) && (!this.f) && (!((FriendManager)localObject).c())) {
        bool = true;
      }
      break;
    case 2: 
      if (bool)
      {
        localObject = localRecentUserProxy.a(AppConstants.U, 5000);
        ((RecentUser)localObject).uin = AppConstants.U;
        ((RecentUser)localObject).type = 5000;
        if (((RecentUser)localObject).lastmsgtime < paramLong) {
          ((RecentUser)localObject).lastmsgtime = paramLong;
        }
        if (b())
        {
          ((RecentUser)localObject).lastmsgtime = 9223372036854775805L;
          label148:
          localRecentUserProxy.a((RecentUser)localObject);
        }
      }
      break;
    }
    for (;;)
    {
      return true;
      bool = true;
      break;
      bool = this.c;
      break;
      bool = false;
      break;
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface == null)
      {
        if ((((RecentUser)localObject).lastmsgtime != 9223372036854775805L) && (((RecentUser)localObject).lastmsgtime > 0L)) {
          break label148;
        }
        ((RecentUser)localObject).lastmsgtime = (System.currentTimeMillis() / 1000L);
        break label148;
      }
      ((RecentUser)localObject).lastmsgtime = paramQQAppInterface.lastmsgtime;
      ((RecentUser)localObject).lastmsgdrafttime = paramQQAppInterface.lastdrafttime;
      break label148;
      if (paramInt != 3)
      {
        paramQQAppInterface = localRecentUserProxy.b(AppConstants.U, 5000);
        if (paramQQAppInterface != null) {
          localRecentUserProxy.b(paramQQAppInterface);
        }
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopAssistantData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      if (paramString != null)
      {
        return paramEntityManager.b(paramString);
        paramEntityManager = finally;
        throw paramEntityManager;
      }
    }
    return false;
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1);
    if ((paramString != null) && (!paramString.shouldShowInRecentList())) {
      paramQQAppInterface.b(paramString);
    }
  }
  
  private void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, 1) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      k(paramQQAppInterface);
      return;
    }
  }
  
  private void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, 1) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      k(paramQQAppInterface);
      return;
    }
  }
  
  private boolean f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("should_update_troop_assistant", true);
  }
  
  private void k(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.b(new dxi(this, paramQQAppInterface));
  }
  
  private void l(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null)) {
      return;
    }
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("should_update_troop_assistant", false).commit();
  }
  
  public int a()
  {
    return this.j;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.b(paramString);
  }
  
  public int a(QQMessageFacade paramQQMessageFacade)
  {
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      int m = this.jdField_a_of_type_JavaUtilSet.size();
      this.j = m;
      return m;
    }
    this.j = 0;
    return 0;
  }
  
  public TroopAssistantData a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = null;
    a(paramQQAppInterface);
    Object localObject2 = this.jdField_b_of_type_JavaLangObject;
    paramQQAppInterface = localObject1;
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        paramQQAppInterface = localObject1;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          paramQQAppInterface = (TroopAssistantData)this.jdField_a_of_type_JavaUtilList.get(0);
        }
      }
      return paramQQAppInterface;
    }
    finally {}
  }
  
  public List a(QQAppInterface arg1)
  {
    a(???);
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          m = this.jdField_a_of_type_JavaUtilList.size();
          ArrayList localArrayList = new ArrayList(m);
          if (this.jdField_a_of_type_JavaUtilList != null) {
            localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          }
          return localArrayList;
        }
      }
      int m = 0;
    }
  }
  
  public Map a(QQAppInterface paramQQAppInterface, List paramList)
  {
    return paramQQAppInterface.a(paramList);
  }
  
  public Map a(QQAppInterface paramQQAppInterface, String... paramVarArgs)
  {
    return a(paramQQAppInterface, Arrays.asList(paramVarArgs));
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        m = 1;
        if (m != 0)
        {
          paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
          a(paramQQAppInterface);
          paramQQAppInterface.a();
        }
        return;
      }
      int m = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.i)) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troop_assis_last_read_time", paramLong).commit();
    this.jdField_a_of_type_Long = paramLong;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      k(paramQQAppInterface);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.edit().putBoolean("tag_troop_ignore_tip_" + paramString, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("troopassist_guide", 2, "setTroopIgnoreTip key=tag_troop_ignore_tip_" + paramString);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface.a(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assistant_be_del", paramBoolean).commit();
    this.f = paramBoolean;
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    a(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, localEntityManager, paramQQAppInterface);
    localEntityManager.a();
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopAssistantData localTroopAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > paramLong)) {}
    for (localTroopAssistantData.lastmsgtime = paramMessageRecord.time;; localTroopAssistantData.lastmsgtime = paramLong)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(localTroopAssistantData.troopUin, 1);
      if (localMessage != null)
      {
        long l1 = localMessage.time;
        if (l1 > localTroopAssistantData.lastmsgtime) {
          localTroopAssistantData.lastmsgtime = l1;
        }
      }
      a(paramEntityManager, localTroopAssistantData);
      a(paramMessageRecord, paramString, paramQQAppInterface);
      if (this.f) {
        a(paramQQAppInterface, false);
      }
      b(paramQQAppInterface, paramString);
      a(paramQQAppInterface, 0, paramLong);
      return;
    }
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      a(paramQQAppInterface);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      Object localObject2 = localRecentUserProxy.b();
      long l1 = System.currentTimeMillis() / 1000L;
      this.jdField_b_of_type_Boolean = c(paramQQAppInterface);
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if ((((RecentUser)localObject3).type == 1) && (a(paramQQAppInterface, ((RecentUser)localObject3).uin))) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (((List)localObject1).size() > 0)
      {
        long l2 = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        l1 = l2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(paramEntityManager, paramQQAppInterface, ((RecentUser)localObject2).uin);
          ((TroopAssistantData)localObject3).lastdrafttime = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = paramQQAppInterface.a().a(((TroopAssistantData)localObject3).troopUin, 1);
            if (localMessage == null) {}
          }
          for (((TroopAssistantData)localObject3).lastmsgtime = localMessage.time;; ((TroopAssistantData)localObject3).lastmsgtime = ((RecentUser)localObject2).lastmsgtime)
          {
            a(paramEntityManager, (TroopAssistantData)localObject3);
            localRecentUserProxy.b((RecentUser)localObject2);
            e(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
            break;
          }
        }
      }
      a(paramQQAppInterface, 0, l1);
      paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troop_assistant", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void a(String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopAssistantData localTroopAssistantData;
    if (paramLong == 0L)
    {
      localTroopAssistantData = a(paramQQAppInterface, paramString);
      if (localTroopAssistantData != null)
      {
        localTroopAssistantData.lastdrafttime = paramLong;
        if ((paramLong != 0L) || (localTroopAssistantData.lastmsgtime != 0L)) {
          break label94;
        }
        b(paramQQAppInterface, paramString);
      }
    }
    for (;;)
    {
      if (this.f) {
        a(paramQQAppInterface, false);
      }
      b(paramQQAppInterface, paramString);
      a(paramQQAppInterface, 0, paramLong);
      return;
      localTroopAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
      break;
      label94:
      a(paramEntityManager, localTroopAssistantData);
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.b(paramString, 1);
    QQMessageFacade.Message localMessage;
    if (localRecentUser != null)
    {
      paramString = a(localEntityManager, paramQQAppInterface, paramString);
      if (localRecentUser.lastmsgtime != 0L) {
        break label205;
      }
      localMessage = paramQQAppInterface.a().a(paramString.troopUin, 1);
      if (localMessage == null) {}
    }
    label205:
    for (paramString.lastmsgtime = localMessage.time;; paramString.lastmsgtime = localRecentUser.lastmsgtime)
    {
      paramString.lastdrafttime = localRecentUser.lastmsgdrafttime;
      a(localEntityManager, paramString);
      e(paramString.troopUin, paramQQAppInterface);
      RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.type);
      if ((!(localRecentUser.msg instanceof TroopAtMeMsg)) && (!(localRecentUser.msg instanceof TroopSpecialAttentionMsg)) && (!(localRecentUser.msg instanceof TroopAtAllMsg))) {
        localRecentUserProxy.b(localRecentUser);
      }
      paramString = a(paramQQAppInterface);
      if (paramString != null) {
        a(paramQQAppInterface, 0, paramString.lastmsgtime);
      }
      localEntityManager.a();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troop_assistant", true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.b(paramString) == 2;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!paramQQAppInterface.getAccount().equals(this.i)) {
      b(paramQQAppInterface);
    }
    this.c = paramBoolean;
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assis_show_in_msg", paramBoolean).commit();
    int m;
    if (paramBoolean)
    {
      m = 1;
      paramBoolean = a(paramQQAppInterface, m, 0L);
      if ((!this.c) || (!paramBoolean)) {
        break label99;
      }
    }
    label99:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      m = 2;
      break;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject2;
    Object localObject3;
    if (paramQQAppInterface != null)
    {
      this.i = paramQQAppInterface.getAccount();
      localObject2 = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      this.c = ((SharedPreferences)localObject2).getBoolean("troop_assis_show_in_msg", true);
      this.d = ((SharedPreferences)localObject2).getBoolean("troop_assis_show_on_top", false);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject2).getLong("troop_assis_last_read_time", 0L);
      this.jdField_b_of_type_Boolean = c(paramQQAppInterface);
      this.f = ((SharedPreferences)localObject2).getBoolean("troop_assistant_be_del", false);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList = null;
        localObject3 = a(paramQQAppInterface);
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet = SharedPreferencesHandler.a((SharedPreferences)localObject2, "troop_assis_new_unread_list", null);
      if (this.jdField_a_of_type_JavaUtilSet == null)
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        if (f(paramQQAppInterface))
        {
          l(paramQQAppInterface);
          localObject2 = paramQQAppInterface.a();
          if (localObject2 == null)
          {
            return;
            paramQQAppInterface = finally;
            throw paramQQAppInterface;
          }
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            TroopAssistantData localTroopAssistantData = (TroopAssistantData)((Iterator)localObject3).next();
            QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localTroopAssistantData.troopUin, 1);
            if ((paramQQAppInterface.a().a(localTroopAssistantData.troopUin, 1) > 0) && (localMessage.time > this.jdField_a_of_type_Long)) {
              e(localMessage.frienduin, paramQQAppInterface);
            }
          }
        }
      }
    }
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    if (a(localEntityManager, paramString)) {
      d(paramString, paramQQAppInterface);
    }
    localEntityManager.a();
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return this.f;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        bool1 = bool2;
        if (paramQQAppInterface != null) {
          bool1 = paramQQAppInterface.getBoolean("tag_troop_ignore_tip_" + paramString, false);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopassist_guide", 2, "checkTroopIgnoreTip ignore=" + bool1);
    }
    return bool1;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (!paramQQAppInterface.getAccount().equals(this.i)) {
      b(paramQQAppInterface);
    }
    this.d = paramBoolean;
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_assis_show_on_top", paramBoolean).commit();
    a(paramQQAppInterface, 3, 0L);
    paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    return this.d;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAssistantManager", 2, "app == null; what happen , fuck?.");
      }
      return;
    }
    if (!paramQQAppInterface.getAccount().equals(this.i)) {
      b(paramQQAppInterface);
    }
    a(paramQQAppInterface, 0, 0L);
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    try
    {
      EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
      localObject = localEntityManager;
      TroopAssistantData localTroopAssistantData = a(paramQQAppInterface, paramString);
      localObject = localEntityManager;
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      if (localTroopAssistantData != null)
      {
        localObject = localEntityManager;
        RecentUser localRecentUser = localRecentUserProxy.a(String.valueOf(localTroopAssistantData.troopUin), 1);
        localObject = localEntityManager;
        localRecentUser.uin = localTroopAssistantData.troopUin;
        localObject = localEntityManager;
        localRecentUser.type = 1;
        localObject = localEntityManager;
        localRecentUser.lastmsgtime = localTroopAssistantData.lastmsgtime;
        localObject = localEntityManager;
        localRecentUser.lastmsgdrafttime = localTroopAssistantData.lastdrafttime;
        localObject = localEntityManager;
        if (a(localEntityManager, paramString))
        {
          localObject = localEntityManager;
          localRecentUserProxy.a(localRecentUser);
          localObject = localEntityManager;
          d(paramString, paramQQAppInterface);
        }
      }
      localObject = localEntityManager;
      paramString = a(paramQQAppInterface);
      if (paramString != null)
      {
        localObject = localEntityManager;
        a(paramQQAppInterface, 0, paramString.lastmsgtime);
      }
      return;
    }
    finally
    {
      if (localObject != null) {
        localObject.a();
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("show_troop_assistant_list_notity", true);
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    k(paramQQAppInterface);
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("troop_message_setting_first", true);
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    int i2 = 0;
    int i1 = 0;
    int m = 0;
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int n = i2;
    try
    {
      if (this.jdField_a_of_type_JavaUtilSet != null)
      {
        n = i2;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        n = m;
        i1 = m;
        if (localIterator.hasNext())
        {
          n = m;
          String str = (String)localIterator.next();
          n = m;
          if (paramQQAppInterface.a().a(str, 1) > 0) {
            break label129;
          }
          n = m;
          localIterator.remove();
          m = 1;
        }
      }
      for (;;)
      {
        break;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i1 = n;
      if (i1 != 0) {
        k(paramQQAppInterface);
      }
      return;
    }
    finally {}
  }
  
  public boolean e(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface != null)
    {
      if (this.l < 0)
      {
        paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        if (paramQQAppInterface != null) {
          this.l = paramQQAppInterface.getInt("tag_troop_assist_tip_time", 0);
        }
      }
      if (this.l >= 2) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("troopassist_guide", 2, "getTroopAssistTipInRange time=" + this.l + ",ret=" + bool);
        }
        return bool;
        bool = true;
      }
    }
    return true;
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null)) {
      return;
    }
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("show_troop_assistant_list_notity", false).commit();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troop_message_setting_first", false).commit();
  }
  
  public void h(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.a().a();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    ??? = ((RecentUserProxy)localObject1).b();
    Object localObject5;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject5 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject5).type == 1) && (a(paramQQAppInterface, ((RecentUser)localObject5).uin)) && (!((RecentUser)localObject5).shouldShowInRecentList())) {
          ((ArrayList)localObject3).add(localObject5);
        }
      }
    }
    a(paramQQAppInterface);
    Object localObject6;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject5 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (TroopAssistantData)((Iterator)localObject5).next();
          if (!a(paramQQAppInterface, ((TroopAssistantData)localObject6).troopUin)) {
            ((ArrayList)localObject2).add(localObject6);
          }
        }
      }
    }
    if (((ArrayList)localObject3).size() > 0)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject3).next();
        localObject5 = a(localEntityManager, paramQQAppInterface, ((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject6 = paramQQAppInterface.a().a(((TroopAssistantData)localObject5).troopUin, 1);
          if (localObject6 == null) {}
        }
        for (((TroopAssistantData)localObject5).lastmsgtime = ((QQMessageFacade.Message)localObject6).time;; ((TroopAssistantData)localObject5).lastmsgtime = ((RecentUser)???).lastmsgtime)
        {
          a(localEntityManager, (TroopAssistantData)localObject5);
          ((RecentUserProxy)localObject1).b((RecentUser)???);
          e(((RecentUser)???).uin, paramQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopAssistantData)((Iterator)localObject2).next();
        ??? = ((RecentUserProxy)localObject1).a(((TroopAssistantData)localObject3).troopUin, 1);
        ((RecentUser)???).uin = ((TroopAssistantData)localObject3).troopUin;
        ((RecentUser)???).type = 1;
        ((RecentUser)???).lastmsgtime = ((TroopAssistantData)localObject3).lastmsgtime;
        ((RecentUser)???).lastmsgdrafttime = ((TroopAssistantData)localObject3).lastdrafttime;
        if (a(localEntityManager, ((TroopAssistantData)localObject3).troopUin))
        {
          ((RecentUserProxy)localObject1).a((RecentUser)???);
          d(((TroopAssistantData)localObject3).troopUin, paramQQAppInterface);
        }
      }
    }
    localObject1 = a(paramQQAppInterface);
    if (localObject1 != null) {
      a(paramQQAppInterface, 0, ((TroopAssistantData)localObject1).lastmsgtime);
    }
    if (localEntityManager != null) {
      localEntityManager.a();
    }
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      if (paramQQAppInterface != null)
      {
        if (this.l < 0) {
          this.l = paramQQAppInterface.getInt("tag_troop_assist_tip_time", 0);
        }
        this.l += 1;
        paramQQAppInterface.edit().putInt("tag_troop_assist_tip_time", this.l).commit();
        if (QLog.isColorLevel()) {
          QLog.d("troopassist_guide", 2, "addTroopAssistTipTime time=" + this.l);
        }
      }
    }
  }
  
  public void j(QQAppInterface paramQQAppInterface)
  {
    try
    {
      b(paramQQAppInterface);
      EntityManager localEntityManager;
      if (a(paramQQAppInterface) == true)
      {
        localEntityManager = paramQQAppInterface.a().createEntityManager();
        a().a(localEntityManager, paramQQAppInterface);
        localEntityManager.a();
      }
      c(paramQQAppInterface);
      if (TroopRemindSettingManager.a().a(paramQQAppInterface) == true)
      {
        localEntityManager = paramQQAppInterface.a().createEntityManager();
        TroopRemindSettingManager.a().a(localEntityManager, paramQQAppInterface);
        localEntityManager.a();
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.recent", 2, "initTroopManager error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager
 * JD-Core Version:    0.7.0.1
 */