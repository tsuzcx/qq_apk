package com.tencent.mobileqq.troop.utils;

import acff;
import acms;
import acnd;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aptp;
import aptw;
import apuh;
import aqft;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TroopNameHelper
{
  ConcurrentLinkedQueue<Task> M = new ConcurrentLinkedQueue();
  acms jdField_a_of_type_Acms = (acms)this.app.getBusinessHandler(20);
  public TroopManager a;
  Task jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task;
  QQAppInterface app = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  acnd b = new aptp(this);
  acff c = (acff)this.app.getManager(51);
  public ConcurrentHashMap<String, Long> iU = new ConcurrentHashMap();
  public ConcurrentHashMap<String, GenTroopNameTask> iV = new ConcurrentHashMap();
  
  public TroopNameHelper()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
    this.app.addObserver(this.b);
  }
  
  public static void TU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    TroopNameHelper localTroopNameHelper;
    do
    {
      do
      {
        return;
      } while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface));
      localObject = (TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(52);
      localTroopNameHelper = ((TroopManager)localObject).a();
      localObject = ((TroopManager)localObject).c(paramString);
    } while ((localObject == null) || (((TroopInfo)localObject).hasSetTroopName()));
    localTroopNameHelper.a(paramString, null);
  }
  
  public static void TV(String paramString)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNameHelper", 2, "onFriendNameChaned uin = " + paramString);
      }
      TroopNameHelper localTroopNameHelper = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(52)).a();
      localTroopNameHelper.getClass();
      localTroopNameHelper.a(new FriendNameChanedTask(localTroopNameHelper, paramString));
    }
  }
  
  private void a(Task paramTask)
  {
    if ((!this.M.contains(paramTask)) && (!paramTask.isRunning)) {
      this.M.add(paramTask);
    }
    runNext();
  }
  
  public static void di(String paramString, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      TroopNameHelper localTroopNameHelper = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(52)).a();
      GenTroopNameTask localGenTroopNameTask = (GenTroopNameTask)localTroopNameHelper.iV.get(paramString);
      if (localGenTroopNameTask == null) {
        break label64;
      }
      localTroopNameHelper.a(localGenTroopNameTask);
      localTroopNameHelper.iV.remove(paramString);
    }
    label64:
    while (!paramBoolean) {
      return;
    }
    TU(paramString);
  }
  
  private void runNext()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task.isRunning))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task = null;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task = ((Task)this.M.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task.isRunning = true;
          ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task, 8, null, false);
        }
      }
      return;
    }
    finally {}
  }
  
  public static String y(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size()) {
        localStringBuffer.append((String)paramArrayList.get(i)).append("、");
      }
      try
      {
        int j = localStringBuffer.toString().getBytes("utf-8").length;
        if (j > 48)
        {
          if (localStringBuffer.toString().endsWith("、")) {
            localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
          }
          return localStringBuffer.toString();
        }
      }
      catch (Exception localException)
      {
        QLog.e("TroopNameHelper", 1, "get length failed!", localException);
        i += 1;
      }
    }
  }
  
  public void a(String paramString, a parama)
  {
    a(new GenTroopNameTask(paramString, parama));
  }
  
  public void destroy()
  {
    this.app.removeObserver(this.b);
    this.M.clear();
    this.iV.clear();
  }
  
  public boolean qU(String paramString)
  {
    return this.iV.containsKey(paramString);
  }
  
  public class FriendNameChanedTask
    extends TroopNameHelper.Task
  {
    String uin;
    
    FriendNameChanedTask(String paramString)
    {
      super();
      this.uin = paramString;
    }
    
    public void hW()
    {
      Object localObject2 = TroopNameHelper.this.a.cE();
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      label182:
      for (;;)
      {
        TroopInfo localTroopInfo;
        if (((Iterator)localObject2).hasNext())
        {
          localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
          if ((localTroopInfo != null) && (!localTroopInfo.hasSetTroopName()))
          {
            Object localObject3 = TroopNameHelper.this.a.al(localTroopInfo.troopuin);
            if (localObject3 != null)
            {
              localObject3 = ((List)localObject3).iterator();
              TroopMemberInfo localTroopMemberInfo;
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject3).next();
              } while (!this.uin.equals(localTroopMemberInfo.memberuin));
            }
          }
        }
        else
        {
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label182;
            }
            ((ArrayList)localObject1).add(localTroopInfo.troopuin);
            break;
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              TroopNameHelper.TU((String)((Iterator)localObject1).next());
            }
            return;
          }
        }
      }
    }
  }
  
  public class GenTroopNameTask
    extends TroopNameHelper.Task
  {
    TroopNameHelper.a a;
    String mTroopUin;
    
    GenTroopNameTask(String paramString, TroopNameHelper.a parama)
    {
      super();
      this.mTroopUin = paramString;
      this.a = parama;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof GenTroopNameTask)) {
        return ((GenTroopNameTask)paramObject).mTroopUin.equals(this.mTroopUin);
      }
      return super.equals(paramObject);
    }
    
    public void hW()
    {
      Object localObject1 = null;
      Object localObject2 = TroopNameHelper.this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.al(this.mTroopUin);
      localObject2 = TroopNameHelper.this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(this.mTroopUin, (List)localObject2);
      ArrayList localArrayList = new ArrayList();
      TroopInfo localTroopInfo = TroopNameHelper.this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(this.mTroopUin);
      if (localTroopInfo == null) {}
      do
      {
        return;
        if (TextUtils.isEmpty(localTroopInfo.troopowneruin))
        {
          TroopNameHelper.this.jdField_a_of_type_Acms.a(Long.parseLong(this.mTroopUin), 0L, 1, 0, 0);
          TroopNameHelper.this.iV.put(this.mTroopUin, this);
          return;
        }
        if ((localObject2 != null) && (((List)localObject2).size() != 0) && ((localTroopInfo.wMemberNum <= 1) || (((List)localObject2).size() > 1))) {
          break;
        }
        localObject1 = (Long)TroopNameHelper.this.iU.get(this.mTroopUin);
      } while ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() <= 86400000L));
      TroopNameHelper.this.jdField_a_of_type_Acms.Ff(this.mTroopUin);
      TroopNameHelper.this.iV.put(this.mTroopUin, this);
      TroopNameHelper.this.iU.put(this.mTroopUin, Long.valueOf(System.currentTimeMillis()));
      return;
      aptw localaptw = (aptw)TroopNameHelper.this.app.getManager(203);
      Iterator localIterator = ((List)localObject2).iterator();
      Object localObject3 = null;
      for (;;)
      {
        label262:
        if (localIterator.hasNext())
        {
          Object localObject4 = (TroopMemberInfo)localIterator.next();
          if ((aqft.rl(((TroopMemberInfo)localObject4).memberuin)) && (!localaptw.gM(((TroopMemberInfo)localObject4).memberuin)) && (!((TroopMemberInfo)localObject4).memberuin.equals("50000000")))
          {
            localObject2 = new a();
            ((a)localObject2).uin = ((TroopMemberInfo)localObject4).memberuin;
            ((a)localObject2).nick = ((TroopMemberInfo)localObject4).friendnick;
            ((a)localObject2).aRl = ((TroopMemberInfo)localObject4).troopnick;
            ((a)localObject2).isOwner = apuh.f(TroopNameHelper.this.app, this.mTroopUin, ((a)localObject2).uin);
            ((a)localObject2).bE = TroopNameHelper.this.app.getCurrentAccountUin().equals(((a)localObject2).uin);
            localObject4 = TroopNameHelper.this.c.e(((a)localObject2).uin);
            if ((localObject4 != null) && (((Friends)localObject4).isFriend()))
            {
              ((a)localObject2).remark = ((Friends)localObject4).remark;
              ((a)localObject2).nick = ((Friends)localObject4).name;
            }
            if ((localObject4 != null) && (((a)localObject2).bE)) {
              ((a)localObject2).nick = ((Friends)localObject4).name;
            }
            if (!TextUtils.isEmpty(((a)localObject2).aRl))
            {
              ((a)localObject2).displayName = ((a)localObject2).aRl;
              ((a)localObject2).cri = ChnToSpell.aJ(((a)localObject2).aRl, 2);
              label498:
              if ((!((a)localObject2).bE) && (!((a)localObject2).isOwner) && (!TextUtils.isEmpty(((a)localObject2).displayName))) {
                localArrayList.add(localObject2);
              }
              if (((a)localObject2).isOwner) {
                localObject3 = localObject2;
              }
              if (!((a)localObject2).bE) {
                break label827;
              }
              localObject1 = localObject2;
            }
          }
        }
      }
      label827:
      for (;;)
      {
        break label262;
        if (!TextUtils.isEmpty(((a)localObject2).remark))
        {
          ((a)localObject2).displayName = ((a)localObject2).remark;
          ((a)localObject2).cri = ChnToSpell.aJ(((a)localObject2).remark, 2);
          break label498;
        }
        if (TextUtils.isEmpty(((a)localObject2).nick)) {
          break label498;
        }
        ((a)localObject2).displayName = ((a)localObject2).nick;
        ((a)localObject2).cri = ChnToSpell.aJ(((a)localObject2).nick, 2);
        break label498;
        Collections.sort(localArrayList);
        if ((localObject3 != null) && (localObject1 != null))
        {
          if (!((a)localObject3).uin.equals(((a)localObject1).uin)) {
            break label717;
          }
          localArrayList.add(localArrayList.size(), localObject3);
        }
        for (;;)
        {
          localObject1 = new ArrayList();
          localObject2 = localArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (a)((Iterator)localObject2).next();
            if (!TextUtils.isEmpty(((a)localObject3).displayName)) {
              ((ArrayList)localObject1).add(((a)localObject3).displayName);
            }
          }
          label717:
          localArrayList.add(0, localObject3);
          localArrayList.add(localArrayList.size(), localObject1);
        }
        localObject1 = TroopNameHelper.y((ArrayList)localObject1);
        localTroopInfo.newTroopName = ((String)localObject1);
        localTroopInfo.newTroopNameTimeStamp = System.currentTimeMillis();
        TroopNameHelper.this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.i(localTroopInfo);
        localObject2 = this.mTroopUin;
        TroopNameHelper.this.jdField_a_of_type_Acms.notifyUI(116, true, new Object[] { localObject2, localObject1 });
        if (this.a == null) {
          break;
        }
        this.a.onResult(this.mTroopUin, (String)localObject1);
        return;
      }
    }
    
    class a
      implements Comparable<a>
    {
      String aRl;
      boolean bE;
      String cri;
      String displayName;
      boolean isOwner;
      String nick;
      String remark;
      String uin;
      
      a() {}
      
      public int a(@NonNull a parama)
      {
        int i = -1;
        if ((this.cri != null) && (parama.cri != null)) {
          i = this.cri.compareTo(parama.cri);
        }
        do
        {
          do
          {
            return i;
            if (this.cri != null) {
              break;
            }
          } while (parama.cri == null);
          return 1;
        } while (parama.cri == null);
        return 0;
      }
    }
  }
  
  public abstract class Task
    implements Runnable
  {
    public volatile boolean isRunning;
    
    Task() {}
    
    public abstract void hW();
    
    public final void run()
    {
      this.isRunning = true;
      hW();
      this.isRunning = false;
      TroopNameHelper.this.M.remove(this);
      TroopNameHelper.a(TroopNameHelper.this);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onResult(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNameHelper
 * JD-Core Version:    0.7.0.1
 */