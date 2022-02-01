package com.tencent.mobileqq.app.asyncdb.cache;

import aagv;
import aajt;
import aako;
import acbn;
import acra;
import ahta;
import ahtc;
import alkm;
import anaz;
import anaz.d;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import aobw;
import asgx;
import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import ocp;
import tog;
import top;
import wvo;

public class RecentUserCache
  extends FullCache
{
  Comparator<Entity> L = new a(false);
  private QQAppInterface app;
  private Handler cB;
  Comparator<Entity> comparator = new a(true);
  protected ConcurrentHashMap<String, ConcurrentHashMap<String, Entity>> eu = new ConcurrentHashMap(64);
  private ConcurrentHashMap<String, Long> ev = new ConcurrentHashMap(64);
  
  public RecentUserCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, RecentUser.class);
    this.app = paramQQAppInterface;
    this.cacheMap = new CacheMap(null);
    doInit();
  }
  
  private RecentUser a(RecentUser paramRecentUser)
  {
    if (paramRecentUser.uin == null) {
      paramRecentUser.uin = "";
    }
    if (paramRecentUser.troopUin == null) {
      paramRecentUser.troopUin = "";
    }
    if (paramRecentUser.displayName == null) {
      paramRecentUser.displayName = "";
    }
    return paramRecentUser;
  }
  
  private void c(RecentUser paramRecentUser, boolean paramBoolean)
  {
    String str = aajt.makeKey(paramRecentUser.uin, paramRecentUser.getType());
    long l = Math.max(Math.max(paramRecentUser.opTime, paramRecentUser.showUpTime), Math.max(paramRecentUser.lastmsgtime, paramRecentUser.lastmsgdrafttime));
    if ((!paramBoolean) && (this.ev.containsKey(str)) && (((Long)this.ev.get(str)).longValue() >= l))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "saveParcelDataToRecentData repeat， key=", str, " opTime=", Long.valueOf(paramRecentUser.opTime), " showUpTime=", Long.valueOf(paramRecentUser.showUpTime), " lastmsgtime=", Long.valueOf(paramRecentUser.lastmsgtime), " lastmsgdrafttime=", Long.valueOf(paramRecentUser.lastmsgdrafttime) });
      }
      return;
    }
    if (this.cB == null) {
      this.cB = new Handler(ThreadManager.getRecentThreadLooper());
    }
    this.cB.post(new RecentUserCache.5(this, str, paramRecentUser, l));
  }
  
  private void cNl()
  {
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("new_friend_upgrade_pref" + this.app.getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_newfriend_when_upgrade", true)) {
      if (this.cacheMap == null) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | descRecentList == null");
        }
      }
    }
    do
    {
      do
      {
        return;
        ThreadManager.getSubThreadHandler().post(new RecentUserCache.2(this, localSharedPreferences));
      } while (!localSharedPreferences.getBoolean("check_newfriend_when_upgrade_V2", true));
      if (this.cacheMap != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | descRecentList == null");
    return;
    ThreadManager.getSubThreadHandler().post(new RecentUserCache.3(this, localSharedPreferences));
  }
  
  private void cNm()
  {
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("pubaccount_assistant_upgrade_pref" + this.app.getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_pubaccountassistant_when_upgrade", true))
    {
      if (this.cacheMap != null) {
        break label71;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | descRecentList == null");
      }
    }
    return;
    label71:
    this.app.execute(new RecentUserCache.4(this, localSharedPreferences));
  }
  
  private void cNn()
  {
    if (this.cacheMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkKandianUpgrade | descRecentList == null");
      }
      return;
    }
    synchronized (this.cacheMap)
    {
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        if ((!awit.cA(this.app)) && (localRecentUser.getType() == 7220))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove kandian merge");
          }
        }
        if ((awit.cA(this.app)) && (((localRecentUser.getType() == 1008) && (TextUtils.equals(localRecentUser.uin, acbn.blw))) || (localRecentUser.getType() == 7210)))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove troop_bar_assist or kandian uin:" + localRecentUser.uin);
          }
        }
      }
    }
  }
  
  private final String getShortUinStr(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 4);
    return paramString.substring(0, 4);
  }
  
  private void jn(List<RecentUser> paramList)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (localRecentUser != null) {
        if ((localObject1 == null) && (acbn.bkD.equals(localRecentUser.uin)))
        {
          localObject1 = localRecentUser;
        }
        else if ((localObject2 == null) && ((acbn.bkA.equals(localRecentUser.uin)) || (4000 == localRecentUser.getType())))
        {
          if ((localRecentUser.msg == null) && (localRecentUser.msgData != null)) {
            localRecentUser.doParse();
          }
          if ((localRecentUser.msg != null) && (!(localRecentUser.msg instanceof String))) {
            localObject2 = localRecentUser;
          }
        }
        else if ((localObject3 == null) && (acbn.bkQ.equals(localRecentUser.uin)))
        {
          localObject3 = localRecentUser;
        }
      }
    }
    if (localObject1 != null) {
      paramList.remove(localObject1);
    }
    if (localObject3 != null) {
      paramList.remove(localObject3);
    }
    if (localObject2 != null)
    {
      paramList.remove(localObject2);
      long l = localObject2.getId();
      this.app.execute(new RecentUserCache.1(this, l));
    }
  }
  
  private String u(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  public void FK(String paramString)
  {
    Object localObject = (ConcurrentHashMap)this.eu.get(paramString);
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).isEmpty()))
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "findRecentUserByUin, uin:" + paramString + ",type:" + str);
          }
          int i = Integer.valueOf(str).intValue();
          if (i != 7000) {
            f(a(paramString, i));
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void Jn(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType, type:" + paramInt);
    }
    if (this.cacheMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType cacheMap  is null");
      }
      return;
    }
    synchronized (this.cacheMap)
    {
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (((RecentUser)((Map.Entry)localIterator.next()).getValue()).getType() == paramInt)
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType remove ru");
          }
        }
      }
    }
  }
  
  public boolean R(String paramString, int paramInt)
  {
    synchronized (this.cacheMap)
    {
      return (RecentUser)this.cacheMap.get(u(paramString, paramInt)) != null;
    }
  }
  
  public anaz.d a(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    Object localObject;
    try
    {
      localArrayList = new ArrayList(this.cacheMap.size());
      localObject = this.cacheMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)((Iterator)localObject).next()).getValue();
        localRecentUser.parse();
        localArrayList.add(localRecentUser);
      }
      Collections.sort(localArrayList, this.comparator);
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getRecentConvInfo is error!", paramString);
      }
      return null;
    }
    paramString = (RecentUser)this.cacheMap.get(u(paramString, paramInt));
    int i;
    if (paramString != null)
    {
      i = localArrayList.indexOf(paramString) + 1;
      long l = System.currentTimeMillis() / 1000L;
      paramString = localArrayList.iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (RecentUser)paramString.next();
      } while (l - ((RecentUser)localObject).lastmsgtime <= anaz.dET);
    }
    for (paramInt = localArrayList.indexOf(localObject) + 1;; paramInt = -1)
    {
      if (paramInt == -1) {
        paramInt = localArrayList.size();
      }
      for (;;)
      {
        paramString = new anaz.d();
        paramString.dEU = i;
        paramString.dEV = paramInt;
        paramString.convCount = localArrayList.size();
        return paramString;
        i = -1;
        break;
      }
    }
  }
  
  public RecentUser a(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramString != null) && (paramString.length() <= 2)) {}
    RecentUser localRecentUser = (RecentUser)this.cacheMap.get(u(paramString, paramInt));
    if (localRecentUser == null)
    {
      paramString = new RecentUser(paramString, paramInt);
      paramString.displayName = paramString.uin;
      paramString.parse();
      a(paramString);
    }
    do
    {
      return paramString;
      paramString = localRecentUser;
    } while (localRecentUser.msg != null);
    if (localRecentUser.mIsParsed)
    {
      localRecentUser.reParse();
      return localRecentUser;
    }
    localRecentUser.parse();
    return localRecentUser;
  }
  
  public List<RecentUser> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.cacheMap.size());
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        localRecentUser.parse();
        if (a(localRecentUser, paramBoolean2)) {
          localArrayList.add(localRecentUser);
        }
        if ("2010741172".equals(localRecentUser.uin)) {
          QLog.d("Q.db.Cache.RecentUserCache", 1, "recentuser has PUBLIC_ACCOUNT_QQ_MAIL uin");
        }
      }
      if (!paramBoolean1) {
        break label155;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getCacheList is error!", localException);
      }
      return new ArrayList();
    }
    if (paramBoolean3)
    {
      Collections.sort(localException, this.comparator);
      label155:
      if (!QLog.isColorLevel()) {
        break label220;
      }
      if (localException != null) {
        break label208;
      }
    }
    label208:
    for (int i = 0;; i = localException.size())
    {
      QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getRecentList, size = %s", new Object[] { Integer.valueOf(i) }));
      break label220;
      Collections.sort(localException, this.L);
      break;
    }
    label220:
    return localException;
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((paramRecentUser == null) || (paramRecentUser.getType() < 0) || (paramRecentUser.uin == null) || (paramRecentUser.uin.length() <= 2)) {
      a(paramRecentUser);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "saveRecentUser user: " + paramRecentUser.uin + " type " + paramRecentUser.getType() + " msgType " + paramRecentUser.msgType);
      }
    } while (paramRecentUser.getType() == 1036);
    Object localObject1;
    Object localObject2;
    if ((paramRecentUser.getType() == 10007) && (ahtc.aS(this.app)) && (ahta.isInited()))
    {
      localObject1 = (ahta)this.app.getManager(358);
      if (((ahta)localObject1).anX())
      {
        localObject1 = ((ahta)localObject1).fi();
        localObject2 = u("2747277822", 10007);
        if ((!this.cacheMap.containsKey(localObject2)) && (localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 1, "addCache ##--10007");
          }
          addCache(a("2747277822", 1008));
        }
      }
    }
    if (acra.j(this.app, paramRecentUser.uin, paramRecentUser.getType()))
    {
      QLog.d("Q.db.Cache.RecentUserCache", 1, "find save invalid user:" + paramRecentUser.uin + " type:" + paramRecentUser.getType(), new RuntimeException("invalid user"));
      acra.FY(paramRecentUser.uin);
    }
    if ((paramRecentUser.getType() == 1) || (paramRecentUser.getType() == 0))
    {
      boolean bool = wvo.a(paramRecentUser.uin, paramRecentUser.getType(), this.app);
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "saveRecentUser user: " + paramRecentUser.uin + " type " + paramRecentUser.getType() + " isHidden " + bool + " user.isHiddenChat=" + paramRecentUser.isHiddenChat);
      }
      if (!bool) {
        break label606;
      }
    }
    label606:
    for (int i = 1;; i = 0)
    {
      paramRecentUser.isHiddenChat = i;
      if (paramRecentUser.getType() == 1)
      {
        localObject1 = ((TroopManager)this.app.getManager(52)).a(paramRecentUser.uin);
        if (localObject1 != null) {
          paramRecentUser.showUpTime = ((CommonlyUsedTroop)localObject1).addedTimestamp;
        }
      }
      localObject1 = paramRecentUser;
      if (paramRecentUser.getType() == 1) {
        break label866;
      }
      localObject1 = paramRecentUser;
      if (paramRecentUser.getType() == 3000) {
        break label866;
      }
      localObject1 = paramRecentUser;
      if (paramRecentUser.getType() == 7000) {
        break label866;
      }
      if (asgx.ag(this.app, paramRecentUser.uin)) {
        paramRecentUser.setType(1024);
      }
      localObject2 = new ArrayList();
      localObject1 = top.eW;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        int k = localObject1[i];
        if (k != paramRecentUser.getType())
        {
          String str = u(paramRecentUser.uin, k);
          if (this.cacheMap.containsKey(str)) {
            ((ArrayList)localObject2).add(str);
          }
        }
        i += 1;
      }
    }
    int j = ((ArrayList)localObject2).size();
    if (j > 0)
    {
      i = 0;
      localObject1 = paramRecentUser;
      if (i < j)
      {
        if (i == 0)
        {
          localObject1 = (RecentUser)this.cacheMap.remove(((ArrayList)localObject2).get(i));
          if (localObject1 != null) {}
        }
        for (;;)
        {
          i += 1;
          break;
          ((RecentUser)localObject1).setType(paramRecentUser.getType());
          ((RecentUser)localObject1).displayName = paramRecentUser.displayName;
          ((RecentUser)localObject1).lastmsgtime = paramRecentUser.lastmsgtime;
          ((RecentUser)localObject1).showUpTime = Math.max(((RecentUser)localObject1).showUpTime, paramRecentUser.showUpTime);
          ((RecentUser)localObject1).troopUin = paramRecentUser.troopUin;
          ((RecentUser)localObject1).lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
          ((RecentUser)localObject1).msgData = paramRecentUser.msgData;
          ((RecentUser)localObject1).msgType = paramRecentUser.msgType;
          ((RecentUser)localObject1).lFlag = paramRecentUser.lFlag;
          ((RecentUser)localObject1).isHiddenChat = paramRecentUser.isHiddenChat;
          ((RecentUser)localObject1).opTime = Math.max(((RecentUser)localObject1).opTime, paramRecentUser.opTime);
          this.cacheMap.remove(((ArrayList)localObject2).get(i));
          paramRecentUser = (RecentUser)localObject1;
          continue;
          this.cacheMap.remove(((ArrayList)localObject2).get(i));
          this.proxyManager.addQueue((Entity)this.cacheMap.get(((ArrayList)localObject2).get(i)), 2, 0, null);
        }
      }
    }
    else
    {
      localObject1 = paramRecentUser;
    }
    alkm.C(this.app, ((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
    label866:
    a((RecentUser)localObject1);
    if ((((RecentUser)localObject1).getType() == 7220) && (!this.cacheMap.contains(localObject1)))
    {
      paramRecentUser = (KandianMergeManager)this.app.getManager(162);
      if (paramRecentUser.aMV != -1) {
        if (paramRecentUser.aMV != 1) {
          break label976;
        }
      }
    }
    label976:
    for (long l = System.currentTimeMillis() / 1000L;; l = 0L)
    {
      ((RecentUser)localObject1).showUpTime = l;
      addCache((Entity)localObject1);
      if ((((RecentUser)localObject1).isHiddenChat != 0) || (!aako.L(this.app))) {
        break;
      }
      try
      {
        c((RecentUser)localObject1, paramBoolean);
        return;
      }
      catch (Throwable paramRecentUser)
      {
        return;
      }
    }
  }
  
  @VisibleForTesting
  protected boolean a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (TextUtils.equals(acbn.bla, paramRecentUser.uin)) {}
    label123:
    do
    {
      do
      {
        return false;
        if ((!TextUtils.equals(paramRecentUser.uin, acbn.blw)) && (!TextUtils.equals(paramRecentUser.uin, acbn.bkZ))) {
          break;
        }
      } while (awit.cA(this.app));
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if ((TextUtils.equals(paramRecentUser.uin, acbn.blx)) || (TextUtils.equals(paramRecentUser.uin, acbn.blO))) {
                break;
              }
              if (TextUtils.equals(paramRecentUser.uin, acbn.bkA))
              {
                if (paramBoolean) {
                  break;
                }
                return true;
              }
              if (!TextUtils.equals(paramRecentUser.uin, acbn.blM)) {
                break label123;
              }
            } while (aobw.bK(this.app));
            return false;
            if ((!TextUtils.equals(paramRecentUser.uin, acbn.blO)) && (!TextUtils.equals(paramRecentUser.uin, acbn.blP))) {
              break label161;
            }
          } while (awit.ua(paramRecentUser.uin));
          return false;
          if (TextUtils.equals(acbn.bkE, paramRecentUser.uin)) {
            break;
          }
          if (!TextUtils.equals(acbn.blQ, paramRecentUser.uin)) {
            break label200;
          }
        } while (LoginWelcomeManager.c(this.app, paramRecentUser));
        return false;
        if (paramRecentUser.getType() == 1038) {
          return aagv.aG(false);
        }
        if ((paramRecentUser.isHiddenChat == 1) || (TextUtils.equals(acbn.blR, paramRecentUser.uin)) || (paramRecentUser.getType() == 10007)) {
          break;
        }
      } while (paramRecentUser.getType() != 1008);
    } while (!ocp.ew(paramRecentUser.uin));
    label161:
    label200:
    return true;
  }
  
  public RecentUser b(String paramString, int paramInt)
  {
    for (;;)
    {
      synchronized (this.cacheMap)
      {
        paramString = (RecentUser)this.cacheMap.get(u(paramString, paramInt));
        if (paramString == null) {
          return null;
        }
        if (paramString.msg == null)
        {
          if (paramString.mIsParsed) {
            paramString.reParse();
          }
        }
        else {
          return paramString;
        }
      }
      paramString.parse();
    }
  }
  
  public List<RecentUser> b(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2, true);
  }
  
  public void b(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + getShortUinStr(paramRecentUser.uin) + " type " + paramRecentUser.getType() + " msgType " + paramRecentUser.msgType + ",uin = " + paramRecentUser.uin);
    }
    if (paramBoolean) {
      this.app.a().D(paramRecentUser.uin, paramRecentUser.getType(), 0);
    }
    removeCache(paramRecentUser);
  }
  
  public void bR(String paramString, boolean paramBoolean)
  {
    int[] arrayOfInt = top.eW;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = u(paramString, k);
      if (this.cacheMap.containsKey(localObject))
      {
        localObject = (RecentUser)this.cacheMap.get(localObject);
        if (paramBoolean) {
          this.app.a().D(((RecentUser)localObject).uin, ((RecentUser)localObject).getType(), 0);
        }
        ((RecentUser)localObject).setType(k);
        removeCache((Entity)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + getShortUinStr(((RecentUser)localObject).uin) + " type " + ((RecentUser)localObject).getType() + " msgType " + ((RecentUser)localObject).msgType);
        }
      }
      i += 1;
    }
  }
  
  public void cNj()
  {
    this.cacheMap.clear();
  }
  
  public void cNk()
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    ??? = Integer.toString(50);
    Object localObject3 = localEntityManager.query(RecentUser.class, false, "type=?", new String[] { String.valueOf(10007) }, null, null, "lastmsgtime desc", (String)???);
    int i = this.cacheMap.size();
    if (localObject3 != null) {
      synchronized (this.cacheMap)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
          String str = getKey(localRecentUser);
          if (!this.cacheMap.containsKey(str)) {
            this.cacheMap.put(str, localRecentUser);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "preLoadTinyRecentUser is called. preCount = " + i + ", afterCount = " + this.cacheMap.size());
    }
    localObject1.close();
  }
  
  public void destroy() {}
  
  protected void doInit()
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    Object localObject1;
    Object localObject2;
    if (ocp.t(this.app))
    {
      localObject1 = acbn.blv;
      localObject2 = Integer.toString(150);
      localObject1 = localEntityManager.query(RecentUser.class, false, "uin!=?", new String[] { localObject1 }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject2);
    }
    Object localObject3;
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject2 = RecentUser.class.getSimpleName();
        localObject1 = localEntityManager.query(RecentUser.class, (String)localObject2, false, null, null, null, null, "showUpTime desc, lastmsgtime desc", Integer.toString(150));
        if (localObject1 != null)
        {
          localObject3 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
              localRecentUser.setStatus(1000);
              localRecentUser.setId(-1L);
              addCache(localRecentUser, 2, null);
              continue;
              localObject1 = Integer.toString(150);
              localObject1 = localEntityManager.query(RecentUser.class, false, "type!=?", new String[] { String.valueOf(10007) }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject1);
              break;
            }
          }
          localEntityManager.drop((String)localObject2);
        }
      }
    }
    label529:
    label547:
    label554:
    for (;;)
    {
      localEntityManager.close();
      jn((List)localObject1);
      Collections.sort((List)localObject1, this.comparator);
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label529;
          }
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          a((RecentUser)localObject2);
          this.cacheMap.put(getKey((Entity)localObject2), localObject2);
          continue;
          localObject1 = new ArrayList(20);
          break;
          if (((List)localObject1).size() <= 149) {
            break label554;
          }
          long l = System.currentTimeMillis();
          try
          {
            localObject2 = new RecentUser().getTableName();
            localObject3 = (RecentUser)((List)localObject1).get(140);
            bool = localEntityManager.execSQL("delete from " + (String)localObject2 + " where showUpTime < " + ((RecentUser)localObject3).showUpTime + " or showUpTime = " + ((RecentUser)localObject3).showUpTime + " and max(lastmsgtime, lastmsgdrafttime) < " + Math.max(((RecentUser)localObject3).lastmsgtime, ((RecentUser)localObject3).lastmsgdrafttime) + "; ");
            if (!bool) {
              break label547;
            }
            localObject2 = new ArrayList(((List)localObject1).subList(0, 140));
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              boolean bool;
              continue;
              localObject2 = localObject1;
            }
          }
          localObject1 = localObject2;
          try
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.db.Cache.RecentUserCache", 2, "doInit int recentUserProxy delete recent table >199 isOk = " + bool + "; time = " + (System.currentTimeMillis() - l));
            localObject1 = localObject2;
          }
          catch (Exception localException1)
          {
            localObject1 = localObject2;
          }
        }
        localException1.printStackTrace();
        break;
      }
      cNl();
      cNm();
      cNn();
      return;
    }
  }
  
  public void e(RecentUser paramRecentUser)
  {
    a(paramRecentUser, false);
  }
  
  public List<RecentUser> ei()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.cacheMap.size());
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        localRecentUser.parse();
        if (localRecentUser.isHiddenChat == 1) {
          localArrayList.add(localRecentUser);
        }
      }
      if (!QLog.isColorLevel()) {
        return localException;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getHiddenCacheList is error!", localException);
      }
      return new ArrayList();
    }
    if (localException == null) {}
    for (int i = 0;; i = localException.size())
    {
      QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getHiddenRecentList, size = %s", new Object[] { Integer.valueOf(i) }));
      break;
    }
    return localException;
  }
  
  public void f(RecentUser paramRecentUser)
  {
    b(paramRecentUser, true);
  }
  
  public boolean gO(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = (ConcurrentHashMap)this.eu.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty()) && ((!paramString.containsKey(String.valueOf(7000))) || (paramString.keySet().size() > 1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String getKey(Entity paramEntity)
  {
    paramEntity = (RecentUser)paramEntity;
    return paramEntity.uin + "&" + paramEntity.getType();
  }
  
  public void init() {}
  
  public boolean kG(String paramString)
  {
    paramString = (ConcurrentHashMap)this.eu.get(paramString);
    return (paramString != null) && (!paramString.isEmpty());
  }
  
  public void onDestroy()
  {
    if (this.cB == null) {
      return;
    }
    this.cB.removeCallbacksAndMessages(null);
  }
  
  public List<RecentUser> q(boolean paramBoolean)
  {
    return b(paramBoolean, true);
  }
  
  class CacheMap
    extends ConcurrentHashMap<String, Entity>
  {
    private CacheMap() {}
    
    public void clear()
    {
      RecentUserCache.this.eu.clear();
      super.clear();
    }
    
    public Entity put(String paramString, Entity paramEntity)
    {
      Object localObject1 = paramString.split("&");
      if (localObject1.length >= 2)
      {
        Object localObject2 = localObject1[0];
        Object localObject3 = localObject1[1];
        ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)RecentUserCache.this.eu.get(localObject2);
        localObject1 = localConcurrentHashMap;
        if (localConcurrentHashMap == null)
        {
          localObject1 = new ConcurrentHashMap();
          RecentUserCache.this.eu.put(localObject2, localObject1);
        }
        ((ConcurrentHashMap)localObject1).put(localObject3, paramEntity);
      }
      return (Entity)super.put(paramString, paramEntity);
    }
    
    public Entity remove(Object paramObject)
    {
      Object localObject2 = ((String)paramObject).split("&");
      if (localObject2.length >= 2)
      {
        Object localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)RecentUserCache.this.eu.get(localObject1);
        if (localConcurrentHashMap != null)
        {
          localConcurrentHashMap.remove(localObject2);
          if (localConcurrentHashMap.isEmpty()) {
            RecentUserCache.this.eu.remove(localObject1);
          }
        }
      }
      return (Entity)super.remove(paramObject);
    }
  }
  
  static class a
    implements Comparator<Entity>
  {
    private boolean bJH;
    
    public a(boolean paramBoolean)
    {
      this.bJH = paramBoolean;
    }
    
    public int a(Entity paramEntity1, Entity paramEntity2)
    {
      paramEntity1 = (RecentUser)paramEntity1;
      paramEntity2 = (RecentUser)paramEntity2;
      long l3 = Math.max(paramEntity1.lastmsgtime, paramEntity1.lastmsgdrafttime);
      long l2 = Math.max(paramEntity2.lastmsgtime, paramEntity2.lastmsgdrafttime);
      long l1;
      if (this.bJH) {
        if ((paramEntity1.showUpTime > 0L) && (l3 == 0L))
        {
          l1 = Math.max(paramEntity1.opTime, paramEntity1.showUpTime);
          if ((paramEntity2.showUpTime <= 0L) || (l2 != 0L)) {
            break label194;
          }
          l3 = Math.max(paramEntity2.opTime, paramEntity2.showUpTime);
          l2 = l1;
          l1 = l3;
        }
      }
      for (;;)
      {
        if (l2 > l1)
        {
          l1 = 3L;
          label117:
          l3 = l1;
          if (!this.bJH) {
            break label280;
          }
          l2 = l1;
          if (paramEntity1.showUpTime > 0L) {
            l2 = l1 | 0x1000;
          }
          l3 = l2;
          if (paramEntity2.showUpTime <= 0L) {
            break label280;
          }
          l1 = 0x2 | 0x1000;
          label167:
          if (l2 >= l1) {
            break label269;
          }
          return 1;
          l1 = l3;
          if (l3 != 0L) {
            break;
          }
          l1 = paramEntity1.opTime;
          break;
          label194:
          if (l2 != 0L) {
            break label310;
          }
          l3 = paramEntity2.opTime;
          l2 = l1;
          l1 = l3;
          continue;
          if (l3 != 0L) {
            break label304;
          }
        }
        label269:
        label280:
        label304:
        for (l1 = paramEntity1.opTime;; l1 = l3)
        {
          if (l2 == 0L)
          {
            l3 = paramEntity2.opTime;
            l2 = l1;
            l1 = l3;
            break;
            if (l2 < l1)
            {
              l1 = 1L;
              break label117;
            }
            l1 = 2L;
            break label117;
            if (l2 == l1) {
              return 0;
            }
            return -1;
            l2 = l3;
            l1 = 2L;
            break label167;
          }
          l3 = l1;
          l1 = l2;
          l2 = l3;
          break;
        }
        label310:
        l3 = l1;
        l1 = l2;
        l2 = l3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache
 * JD-Core Version:    0.7.0.1
 */