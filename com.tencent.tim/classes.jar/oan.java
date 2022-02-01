import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.2;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.3;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class oan
{
  protected Boolean K = Boolean.valueOf(false);
  public Object aF = new Object();
  protected boolean avV = true;
  protected boolean avW;
  protected boolean avX;
  protected boolean avY;
  public ConcurrentHashMap<String, Integer> bA = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, PublicAccountInfo> bB = new ConcurrentHashMap();
  public int bdB;
  protected final Map<String, TroopBarData> dt = new HashMap();
  protected String mAccount;
  Comparator<TroopBarData> mComparator = new oao(this);
  public List<TroopBarData> mDataList;
  protected long mLastReadTime;
  protected long yv;
  
  private void G(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (!paramQQAppInterface.getAccount().equals(this.mAccount)) {}
      synchronized (this.K)
      {
        this.K = Boolean.valueOf(false);
        this.mAccount = paramQQAppInterface.getAccount();
        ??? = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        this.avV = ((SharedPreferences)???).getBoolean("troopbar_assist_show_in_msg", true);
        this.mLastReadTime = ((SharedPreferences)???).getLong("troopbar_assist_last_read_time", 0L);
        this.avX = ((SharedPreferences)???).getBoolean("troopbar_assist_deleted", false);
      }
    }
    synchronized (this.aF)
    {
      this.mDataList = null;
      aw(paramQQAppInterface);
      this.avW = false;
      return;
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private TroopBarData a(QQAppInterface arg1, String paramString)
  {
    am(???);
    synchronized (this.dt)
    {
      paramString = (TroopBarData)this.dt.get(paramString);
      return paramString;
    }
  }
  
  private TroopBarData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    am(paramQQAppInterface);
    synchronized (this.dt)
    {
      TroopBarData localTroopBarData = (TroopBarData)this.dt.get(paramString);
      paramEntityManager = localTroopBarData;
      if (localTroopBarData == null)
      {
        localTroopBarData = new TroopBarData();
        localTroopBarData.mUin = paramString;
        paramQQAppInterface = paramQQAppInterface.b();
        paramEntityManager = localTroopBarData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString, 1008);
          paramEntityManager = localTroopBarData;
          if (paramQQAppInterface != null)
          {
            localTroopBarData.mLastDraftTime = paramQQAppInterface.getTime();
            paramEntityManager = localTroopBarData;
          }
        }
      }
      return paramEntityManager;
    }
  }
  
  private List<TroopBarData> a(QQAppInterface paramQQAppInterface, List<TroopBarData> paramList)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    ArrayList localArrayList = new ArrayList();
    while (paramList.hasNext())
    {
      TroopBarData localTroopBarData = (TroopBarData)paramList.next();
      if (nyn.h(paramQQAppInterface, localTroopBarData.mUin)) {
        localArrayList.add(localTroopBarData);
      }
    }
    return localArrayList;
  }
  
  public static oan a()
  {
    try
    {
      if (oan.a.a == null) {
        oan.a.a = new oan();
      }
      oan localoan = oan.a.a;
      return localoan;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager, TroopBarData paramTroopBarData)
  {
    if (paramTroopBarData == null) {
      return;
    }
    paramEntityManager = (TroopBarData)this.dt.get(paramTroopBarData.mUin);
    synchronized (this.dt)
    {
      this.dt.put(paramTroopBarData.mUin, paramTroopBarData);
    }
    for (;;)
    {
      synchronized (this.aF)
      {
        if (this.mDataList != null)
        {
          if (paramEntityManager != null) {
            this.mDataList.remove(paramEntityManager);
          }
          this.mDataList.remove(paramTroopBarData);
          this.mDataList.add(this.mDataList.size(), paramTroopBarData);
          if (QLog.isColorLevel()) {
            QLog.i("TroopBarAssistantManager", 2, "save TroopBarData " + paramTroopBarData.mUin + " to dataList");
          }
        }
        bcU();
        paramEntityManager = (ProxyManager)paramQQAppInterface.getManager(18);
        if (paramTroopBarData.getStatus() == 1000)
        {
          paramEntityManager.addMsgQueue(paramQQAppInterface.getAccount(), 0, paramTroopBarData.getTableName(), paramTroopBarData, 3, null);
          paramQQAppInterface = (KandianMergeManager)paramQQAppInterface.getManager(162);
          paramQQAppInterface.aIM();
          paramQQAppInterface.g(null);
          return;
          paramQQAppInterface = finally;
          throw paramQQAppInterface;
        }
      }
      paramEntityManager.addMsgQueue(paramQQAppInterface.getAccount(), 0, paramTroopBarData.getTableName(), paramTroopBarData, 4, null);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!nyn.h(paramQQAppInterface, paramString)) {
      return;
    }
    aw(paramQQAppInterface);
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      if (!this.bA.containsKey(paramString)) {
        break label108;
      }
      this.bA.put(paramString, Integer.valueOf(((Integer)this.bA.get(paramString)).intValue() + 1));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopBarAssistantManager", 2, "add uin " + paramString + " to newMsgMap");
      }
      ao(paramQQAppInterface);
      return;
      label108:
      this.bA.put(paramString, Integer.valueOf(1));
    }
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!nyn.h(paramQQAppInterface, paramString)) {
      return;
    }
    aw(paramQQAppInterface);
    if (paramQQAppInterface.a().A(paramString, 1008) > 0)
    {
      if (!this.bA.containsKey(paramString)) {
        break label73;
      }
      this.bA.put(paramString, Integer.valueOf(((Integer)this.bA.get(paramString)).intValue() + 1));
    }
    for (;;)
    {
      ao(paramQQAppInterface);
      return;
      label73:
      this.bA.put(paramString, Integer.valueOf(1));
    }
  }
  
  private void ao(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new TroopBarAssistantManager.2(this, paramQQAppInterface));
  }
  
  private void aw(QQAppInterface paramQQAppInterface)
  {
    if (this.K.booleanValue()) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.K)
      {
        if (!this.K.booleanValue())
        {
          this.bA.clear();
          Object localObject = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getString("troopbar_assist_new_unread_list", "");
          if (awit.isColorLevel()) {
            QLog.i("TroopBarAssistantManager", 2, "changeAccount, get newMsgStr from sp:" + (String)localObject);
          }
          try
          {
            localObject = new JSONArray((String)localObject);
            i = 0;
            if (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              Iterator localIterator = localJSONObject.keys();
              if (!localIterator.hasNext()) {
                break label255;
              }
              String str = (String)localIterator.next();
              if (!nyn.h(paramQQAppInterface, str)) {
                continue;
              }
              this.bA.put(str, Integer.valueOf(localJSONObject.getInt(str)));
              continue;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("TroopBarAssistantManager", 2, "initNewMsgMapIfNeeds:" + paramQQAppInterface.toString());
            }
            this.K = Boolean.valueOf(true);
            if (awit.isColorLevel()) {
              QLog.i("TroopBarAssistantManager", 2, "initNewMsgMapIfNeeds, succ");
            }
          }
        }
        else
        {
          return;
        }
      }
      label255:
      i += 1;
    }
  }
  
  private void b(EntityManager arg1, QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = ???.query(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          Collections.sort((List)localObject, this.mComparator);
        }
        long l;
        localObject = ((TroopBarData)this.mDataList.get(i)).mUin;
      }
      catch (Exception ???)
      {
        synchronized (this.aF)
        {
          this.mDataList = ((List)localObject);
          if (this.mDataList == null)
          {
            this.mDataList = new ArrayList(15);
            synchronized (this.dt)
            {
              this.dt.clear();
              paramQQAppInterface = this.mDataList.iterator();
              if (!paramQQAppInterface.hasNext()) {
                break label368;
              }
              localObject = (TroopBarData)paramQQAppInterface.next();
              this.dt.put(((TroopBarData)localObject).mUin, localObject);
            }
            ??? = ???;
            if (QLog.isColorLevel()) {
              QLog.e("TroopBarAssistantManager", 2, "initTroopBarAssistRecent doInit error: ", ???);
            }
            return;
          }
          l = e(paramQQAppInterface);
          i = 0;
          if (i >= this.mDataList.size()) {
            continue;
          }
          localObject = (TroopBarData)this.mDataList.get(i);
          if (localObject == null)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TroopBarAssistantManager", 2, "doInit==> pad == null");
            }
            this.mDataList.remove(i);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopBarAssistantManager", 2, "doInit==> uin:" + ((TroopBarData)localObject).mUin + ", lastMsgTime:" + ((TroopBarData)localObject).mLastMsgTime);
            }
            if (((TroopBarData)localObject).mLastMsgTime < l) {
              this.mDataList.remove(i);
            }
          }
        }
      }
      finally {}
      ((TroopBarData)this.mDataList.get(i)).mLatestMessage = paramQQAppInterface.b().d((String)localObject, 1008);
      break label371;
      label368:
      return;
      label371:
      i += 1;
    }
  }
  
  private boolean b(EntityManager paramEntityManager, String paramString)
  {
    TroopBarData localTroopBarData;
    Object localObject2;
    synchronized (this.dt)
    {
      localTroopBarData = (TroopBarData)this.dt.remove(paramString);
      localObject2 = this.aF;
      ??? = localTroopBarData;
    }
    for (;;)
    {
      try
      {
        if (this.mDataList != null)
        {
          ??? = localTroopBarData;
          if (localTroopBarData == null)
          {
            Iterator localIterator = this.mDataList.iterator();
            ??? = localTroopBarData;
            if (localIterator.hasNext())
            {
              ??? = (TroopBarData)localIterator.next();
              if (!TextUtils.equals(((TroopBarData)???).mUin, paramString)) {
                continue;
              }
            }
          }
          this.mDataList.remove(???);
        }
        if (??? == null) {
          break;
        }
        if (paramEntityManager.remove((Entity)???)) {
          break label177;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopBarAssistantManager", 2, "remove TroopBarData " + ((TroopBarData)???).mUin + " from em fail");
        }
        return true;
      }
      finally {}
      paramEntityManager = finally;
      throw paramEntityManager;
      label177:
      if (QLog.isColorLevel()) {
        QLog.i("TroopBarAssistantManager", 2, "remove TroopBarData " + ((TroopBarData)???).mUin + " from em success");
      }
    }
    return false;
  }
  
  private void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    a(paramString, paramQQAppInterface, false);
  }
  
  private boolean c(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int j = 0;
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    acxw localacxw = paramQQAppInterface.a().a();
    if (localObject == null) {
      return false;
    }
    int i = j;
    if (this.avV)
    {
      i = j;
      if (!this.avX) {
        i = 1;
      }
    }
    if (i != 0)
    {
      localObject = localacxw.a(acbn.bkZ, 7210);
      if (((RecentUser)localObject).lastmsgtime < paramLong) {
        ((RecentUser)localObject).lastmsgtime = paramLong;
      }
      if (q(paramQQAppInterface)) {
        localacxw.e((RecentUser)localObject);
      }
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      return true;
      TroopBarData localTroopBarData = a(paramQQAppInterface);
      if (localTroopBarData == null) {
        break;
      }
      ((RecentUser)localObject).lastmsgtime = localTroopBarData.mLastMsgTime;
      ((RecentUser)localObject).lastmsgdrafttime = localTroopBarData.mLastDraftTime;
      break;
      localObject = localacxw.b(acbn.bkZ, 7210);
      if (localObject != null) {
        localacxw.f((RecentUser)localObject);
      }
    }
  }
  
  public static void destroy()
  {
    try
    {
      oan.a.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private long e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    if (!this.avW)
    {
      this.yv = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getLong("troopbar_recent_item_last_del_time", 0L);
      this.avW = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBarAssistantManager", 2, "getTroopBarRecentItemLastDelTime, lastDelTime:" + this.yv);
    }
    return this.yv;
  }
  
  private void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.f(paramString);
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i = 0;
    tog localtog = paramQQAppInterface.a();
    Object localObject1 = paramQQAppInterface.b();
    if ((localtog == null) || (localObject1 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopBarAssistantManager", 2, "countAllSubscriptionUnread getConversationFacade fail");
      }
      return 0;
    }
    label184:
    label187:
    label192:
    label195:
    label201:
    label209:
    for (;;)
    {
      int j;
      synchronized (this.aF)
      {
        if (this.mDataList != null)
        {
          Iterator localIterator = this.mDataList.iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break label209;
          }
          TroopBarData localTroopBarData = (TroopBarData)localIterator.next();
          localObject1 = localTroopBarData.mLatestMessage;
          if (localObject1 != null) {
            break label184;
          }
          localObject1 = paramQQAppInterface.b().d(localTroopBarData.mUin, 1008);
          if ((localObject1 != null) && (nyn.h(paramQQAppInterface, ((MessageRecord)localObject1).frienduin)))
          {
            j = localtog.A(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
            if (!paramBoolean) {
              break label201;
            }
            if (j <= 0) {
              break label195;
            }
            j = 1;
            break label187;
          }
        }
        else
        {
          return i;
        }
      }
      break label192;
      continue;
      for (i = j + i;; i = j + i)
      {
        break;
        j = 0;
        break label187;
      }
    }
  }
  
  public TroopBarData a(QQAppInterface paramQQAppInterface)
  {
    am(paramQQAppInterface);
    for (;;)
    {
      TroopBarData localTroopBarData;
      synchronized (this.aF)
      {
        if ((this.mDataList == null) || (this.mDataList.size() <= 0)) {
          break;
        }
        long l = e(paramQQAppInterface);
        Iterator localIterator = this.mDataList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localTroopBarData = (TroopBarData)localIterator.next();
        if (localTroopBarData.mLastMsgTime < l) {
          localIterator.remove();
        }
      }
      DraftSummaryInfo localDraftSummaryInfo = paramQQAppInterface.b().a(localTroopBarData.mUin, 1008);
      if (localDraftSummaryInfo != null) {
        localTroopBarData.mLastDraftTime = localDraftSummaryInfo.getTime();
      } else {
        localTroopBarData.mLastDraftTime = 0L;
      }
    }
    bcU();
    paramQQAppInterface = a(paramQQAppInterface, this.mDataList);
    if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty())) {}
    for (paramQQAppInterface = (TroopBarData)paramQQAppInterface.get(0);; paramQQAppInterface = null)
    {
      return paramQQAppInterface;
      if (QLog.isColorLevel()) {
        QLog.w("TroopBarAssistantManager", 2, "getFirstData return null");
      }
    }
  }
  
  public String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = ((acja)paramQQAppInterface.getManager(56)).a(paramString);
    if (paramString != null) {
      return paramString.name;
    }
    return "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<PublicAccountInfo> paramList)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.getAccount().equals(this.mAccount))) {}
    do
    {
      return;
      if (((acja)paramQQAppInterface.getManager(56)).bIJ) {
        break;
      }
    } while (!awit.isColorLevel());
    QLog.w("TroopBarAssistantManager", 2, "refreshSettings but padm not cached");
    return;
    this.avY = true;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.bB.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramList.next();
        this.bB.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
      }
    }
    as(paramQQAppInterface);
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData = a(paramEntityManager, paramQQAppInterface, paramString);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > paramLong))
    {
      localTroopBarData.mLastMsgTime = paramMessageRecord.time;
      localTroopBarData.mLatestMessage = paramMessageRecord;
    }
    for (;;)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.b().a(localTroopBarData.mUin, 1008);
      if (localMessage != null)
      {
        long l = localMessage.time;
        if (l > localTroopBarData.mLastMsgTime)
        {
          localTroopBarData.mLastMsgTime = l;
          localTroopBarData.mLatestMessage = localMessage;
        }
      }
      a(paramQQAppInterface, paramEntityManager, localTroopBarData);
      a(paramMessageRecord, paramString, paramQQAppInterface);
      if (this.avX) {
        f(paramQQAppInterface, false);
      }
      g(paramQQAppInterface, paramString);
      c(paramQQAppInterface, paramLong);
      return;
      localTroopBarData.mLastMsgTime = paramLong;
    }
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      am(paramQQAppInterface);
      acxw localacxw = paramQQAppInterface.a().a();
      Object localObject2 = localacxw.q(false);
      long l = System.currentTimeMillis() / 1000L;
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if (((((RecentUser)localObject3).getType() == 1008) || (((RecentUser)localObject3).getType() == 1024)) && (e(paramQQAppInterface, ((RecentUser)localObject3).uin, ((RecentUser)localObject3).getType()))) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (((List)localObject1).size() > 0)
      {
        l = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(paramEntityManager, paramQQAppInterface, ((RecentUser)localObject2).uin);
          ((TroopBarData)localObject3).mLastDraftTime = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = paramQQAppInterface.b().a(((TroopBarData)localObject3).mUin, 1008);
            if (localMessage == null) {}
          }
          for (((TroopBarData)localObject3).mLastMsgTime = localMessage.time;; ((TroopBarData)localObject3).mLastMsgTime = ((RecentUser)localObject2).lastmsgtime)
          {
            a(paramQQAppInterface, paramEntityManager, (TroopBarData)localObject3);
            localacxw.f((RecentUser)localObject2);
            a(((TroopBarData)localObject3).mUin, paramQQAppInterface);
            break;
          }
        }
      }
      ((PublicAccountHandler)paramQQAppInterface.getBusinessHandler(11)).cLi();
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troopbar_assist", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, Context paramContext, acje paramacje)
  {
    ocp.a(paramQQAppInterface, paramContext, paramString, true, paramacje);
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aw(paramQQAppInterface);
    if (((paramBoolean) || (paramQQAppInterface.a().A(paramString, 1008) > 0)) && (this.bA.containsKey(paramString))) {
      this.bA.remove(paramString);
    }
    ao(paramQQAppInterface);
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = a(paramQQAppInterface, paramString);
    if (paramString != null) {
      return paramString.mIsSticky;
    }
    return false;
  }
  
  public void am(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.aF)
    {
      int i;
      if (this.mDataList == null)
      {
        i = 1;
        if (i != 0)
        {
          ??? = paramQQAppInterface.a().createEntityManager();
          b((EntityManager)???, paramQQAppInterface);
          ((EntityManager)???).close();
          paramQQAppInterface = ((acja)paramQQAppInterface.getManager(56)).ec();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            this.bB.clear();
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext())
            {
              ??? = (PublicAccountInfo)paramQQAppInterface.next();
              this.bB.put(((PublicAccountInfo)???).getUin(), ???);
            }
          }
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void an(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopBarAssistManager", 2, "app == null; what happen.");
      }
    }
    TroopBarData localTroopBarData;
    do
    {
      return;
      if (!paramQQAppInterface.getAccount().equals(this.mAccount)) {
        G(paramQQAppInterface);
      }
      if (q(paramQQAppInterface))
      {
        h(paramQQAppInterface, false);
        g(paramQQAppInterface, false);
        c(paramQQAppInterface, NetConnInfoCenter.getServerTime());
        return;
      }
      localTroopBarData = a(paramQQAppInterface);
    } while (localTroopBarData == null);
    c(paramQQAppInterface, localTroopBarData.mLastMsgTime);
  }
  
  public void ap(QQAppInterface paramQQAppInterface)
  {
    this.bA.clear();
    if (awit.isColorLevel()) {
      QLog.i("TroopBarAssistantManager", 2, "setFirstEnterFeeds, newMsgStr clear in memory");
    }
    ao(paramQQAppInterface);
  }
  
  public void aq(QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData = a(paramQQAppInterface);
    if (localTroopBarData != null) {}
    for (long l = localTroopBarData.mLastMsgTime;; l = NetConnInfoCenter.getServerTime())
    {
      f(paramQQAppInterface, l);
      return;
    }
  }
  
  public void ar(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new TroopBarAssistantManager.3(this, paramQQAppInterface));
  }
  
  public void as(QQAppInterface paramQQAppInterface)
  {
    acxw localacxw = paramQQAppInterface.a().a();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ??? = localacxw.q(false);
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).getType() == 1008) && (e(paramQQAppInterface, ((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType())) && (!((RecentUser)localObject4).shouldShowInRecentList(paramQQAppInterface))) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    am(paramQQAppInterface);
    Object localObject5;
    synchronized (this.aF)
    {
      if ((this.mDataList != null) && (this.mDataList.size() > 0))
      {
        localObject4 = this.mDataList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (TroopBarData)((Iterator)localObject4).next();
          if (!e(paramQQAppInterface, ((TroopBarData)localObject5).mUin, 1008)) {
            ((ArrayList)localObject1).add(localObject5);
          }
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      if (this.avX) {
        f(paramQQAppInterface, false);
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject2).next();
        localObject4 = a(localEntityManager, paramQQAppInterface, ((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject5 = paramQQAppInterface.b().a(((TroopBarData)localObject4).mUin, 1008);
          if (localObject5 == null) {}
        }
        for (((TroopBarData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((TroopBarData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a(paramQQAppInterface, localEntityManager, (TroopBarData)localObject4);
          localacxw.f((RecentUser)???);
          a(((RecentUser)???).uin, paramQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (TroopBarData)((Iterator)localObject2).next();
        localObject4 = localacxw.a(((TroopBarData)???).mUin, 1008);
        ((RecentUser)localObject4).uin = ((TroopBarData)???).mUin;
        ((RecentUser)localObject4).setType(1008);
        ((RecentUser)localObject4).lastmsgtime = ((TroopBarData)???).mLastMsgTime;
        ((RecentUser)localObject4).lastmsgdrafttime = ((TroopBarData)???).mLastDraftTime;
        if (awit.isColorLevel())
        {
          localObject1 = (acja)paramQQAppInterface.getManager(56);
          QLog.i("TroopBarAssistantManager", 2, "uinConfigMap size: " + this.bB.size() + ", pam cache: " + ((acja)localObject1).bIJ);
          QLog.i("TroopBarAssistantManager", 2, "to remove incognizance TroopBarData " + ((TroopBarData)???).mUin + " from dataList");
        }
        if (b(localEntityManager, ((TroopBarData)???).mUin))
        {
          if (this.bB == null) {}
          for (localObject1 = null;; localObject1 = (PublicAccountInfo)this.bB.get(((TroopBarData)???).mUin))
          {
            if (localObject1 != null) {
              localacxw.e((RecentUser)localObject4);
            }
            if (awit.isColorLevel()) {
              QLog.i("TroopBarAssistantManager", 2, "to remove incognizance uin " + ((TroopBarData)???).mUin + " from newMsgSet");
            }
            c(((TroopBarData)???).mUin, paramQQAppInterface);
            break;
          }
        }
      }
    }
    localObject1 = a(paramQQAppInterface);
    if (localObject1 != null) {
      c(paramQQAppInterface, ((TroopBarData)localObject1).mLastMsgTime);
    }
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
  
  public void at(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(SubscriptFeedsActivity.class);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.removeMessages(1002);
      paramQQAppInterface.sendEmptyMessage(1002);
      paramQQAppInterface.removeMessages(1005);
      paramQQAppInterface.sendEmptyMessage(1005);
    }
  }
  
  public void au(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit();
      this.yv = NetConnInfoCenter.getServerTime();
      paramQQAppInterface.putLong("troopbar_recent_item_last_del_time", this.yv);
      paramQQAppInterface.commit();
    } while (!QLog.isColorLevel());
    QLog.d("TroopBarAssistantManager", 2, "saveTroopBarRecentItemLastDelTime, lastDelTime:" + this.yv);
  }
  
  public void av(QQAppInterface paramQQAppInterface)
  {
    a().i(paramQQAppInterface, false);
    this.bdB = 0;
  }
  
  public void ax(QQAppInterface paramQQAppInterface)
  {
    try
    {
      G(paramQQAppInterface);
      if (p(paramQQAppInterface) == true)
      {
        EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
        a(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      an(paramQQAppInterface);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public List<TroopBarData> b(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    am(paramQQAppInterface);
    for (;;)
    {
      int j;
      synchronized (this.aF)
      {
        if (this.mDataList != null)
        {
          int i = 0;
          long l = e(paramQQAppInterface);
          j = this.mDataList.size() - 1;
          if (j >= 0)
          {
            TroopBarData localTroopBarData = (TroopBarData)this.mDataList.get(j);
            if (localTroopBarData == null)
            {
              this.mDataList.remove(j);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopBarAssistantManager", 2, "getUseTroopBarAssistList==> uin:" + localTroopBarData.mUin + ", lastMsgTime:" + localTroopBarData.mLastMsgTime);
              }
              if (localTroopBarData.mLastMsgTime < l)
              {
                this.mDataList.remove(j);
              }
              else
              {
                MessageRecord localMessageRecord = paramQQAppInterface.b().d(localTroopBarData.mUin, 1008);
                if (localMessageRecord == null)
                {
                  this.mDataList.remove(j);
                }
                else if (localMessageRecord.time > localTroopBarData.mLastMsgTime)
                {
                  ((TroopBarData)this.mDataList.get(j)).mLastMsgTime = localMessageRecord.time;
                  i = 1;
                }
              }
            }
          }
          else
          {
            if (i != 0) {
              Collections.sort(this.mDataList, this.mComparator);
            }
            localArrayList.addAll(this.mDataList);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      j -= 1;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (q(paramQQAppInterface)) {
      if ((!this.avV) || (this.avX)) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = paramQQAppInterface.a().a().a(acbn.bkZ, 7210);
        if (paramMessageRecord.time >= ((RecentUser)localObject).lastmsgtime) {
          h(paramQQAppInterface, false);
        }
      }
      Object localObject = paramQQAppInterface.a().createEntityManager();
      a(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, (EntityManager)localObject, paramQQAppInterface);
      ((EntityManager)localObject).close();
      return;
    }
  }
  
  public void bcU()
  {
    synchronized (this.aF)
    {
      if ((this.mDataList != null) && (this.mDataList.size() > 0)) {
        Collections.sort(this.mDataList, this.mComparator);
      }
      return;
    }
  }
  
  public int c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    if (this.bA != null)
    {
      paramQQAppInterface = this.bA.keySet().iterator();
      while (paramQQAppInterface.hasNext())
      {
        Object localObject = (String)paramQQAppInterface.next();
        if (paramString.equals(localObject))
        {
          localObject = (Integer)this.bA.get(localObject);
          if (localObject != null) {
            return ((Integer)localObject).intValue();
          }
        }
      }
    }
    return 0;
  }
  
  public List<oal> c(QQAppInterface paramQQAppInterface)
  {
    am(paramQQAppInterface);
    Object localObject1 = new ArrayList();
    Object localObject3;
    for (;;)
    {
      long l;
      TroopBarData localTroopBarData;
      synchronized (this.aF)
      {
        if (this.mDataList == null) {
          break label285;
        }
        l = e(paramQQAppInterface);
        localObject3 = this.mDataList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localTroopBarData = (TroopBarData)((Iterator)localObject3).next();
        if (localTroopBarData == null) {
          ((Iterator)localObject3).remove();
        }
      }
      Object localObject4 = paramQQAppInterface.b().d(localTroopBarData.mUin, 1008);
      if (localObject4 == null)
      {
        ((Iterator)localObject3).remove();
      }
      else
      {
        localTroopBarData.mLatestMessage = ((MessageRecord)localObject4);
        localTroopBarData.mLastMsgTime = ((MessageRecord)localObject4).time;
        localObject4 = paramQQAppInterface.b().a(localTroopBarData.mUin, 1008);
        if (localObject4 != null) {}
        for (localTroopBarData.mLastDraftTime = ((DraftSummaryInfo)localObject4).getTime();; localTroopBarData.mLastDraftTime = 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopBarAssistantManager", 2, "getUseTroopBarAssistList==> uin:" + localTroopBarData.mUin + ", lastMsgTime:" + localTroopBarData.mLastMsgTime + ", lastDraftTime: " + localTroopBarData.mLastDraftTime);
          }
          if (localTroopBarData.mLastMsgTime >= l) {
            break;
          }
          ((Iterator)localObject3).remove();
          break;
        }
      }
    }
    bcU();
    ((List)localObject1).addAll(a(paramQQAppInterface, this.mDataList));
    label285:
    ??? = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (TroopBarData)((Iterator)localObject1).next();
      localObject3 = oal.a(paramQQAppInterface, paramQQAppInterface.getApplication().getApplicationContext(), (TroopBarData)localObject3);
      if ((localObject3 != null) && (!((List)???).contains(localObject3))) {
        ((List)???).add(localObject3);
      }
    }
    return ???;
  }
  
  public List<PublicAccountInfo> d(QQAppInterface paramQQAppInterface)
  {
    Object localObject = ((acja)paramQQAppInterface.getManager(56)).ec();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if (nyn.h(paramQQAppInterface, localPublicAccountInfo.getUin())) {
          localArrayList.add(localPublicAccountInfo);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    if (b(localEntityManager, paramString)) {
      c(paramString, paramQQAppInterface);
    }
    localEntityManager.close();
  }
  
  public void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.dt)
    {
      paramString = (TroopBarData)this.dt.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = true;
      paramString.mLastStickyTime = (System.currentTimeMillis() / 1000L);
      ((ProxyManager)paramQQAppInterface.getManager(18)).addMsgQueue(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      bcU();
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null)
      {
        paramString.sendEmptyMessage(1009);
        return;
      }
    }
  }
  
  public boolean e(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return (paramInt == 1008) && (nyn.h(paramQQAppInterface, paramString));
  }
  
  public long f(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().a().a(acbn.bkZ, 7210);
    long l = 0L;
    if (paramQQAppInterface != null) {
      l = paramQQAppInterface.lastmsgtime;
    }
    return l;
  }
  
  public void f(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.mAccount)) {
      G(paramQQAppInterface);
    }
    this.mLastReadTime = paramLong;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troopbar_assist_last_read_time", paramLong).commit();
    RecentUser localRecentUser = paramQQAppInterface.a().a().a(acbn.bkZ, 7210);
    if (localRecentUser != null) {
      localRecentUser.lastmsgtime = paramLong;
    }
    this.bA.clear();
    if (awit.isColorLevel()) {
      QLog.i("TroopBarAssistantManager", 2, "setLastReadTime, newMsgStr clear in memory");
    }
    ao(paramQQAppInterface);
  }
  
  public void f(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troopbar_assist_deleted", paramBoolean).commit();
    this.avX = paramBoolean;
  }
  
  public void f(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.dt)
    {
      paramString = (TroopBarData)this.dt.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = false;
      paramString.mLastStickyTime = 0L;
      ((ProxyManager)paramQQAppInterface.getManager(18)).addMsgQueue(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      bcU();
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null)
      {
        paramString.sendEmptyMessage(1009);
        return;
      }
    }
  }
  
  public int g(QQAppInterface arg1)
  {
    int i = 0;
    if (!???.getAccount().equals(this.mAccount)) {
      return 0;
    }
    for (;;)
    {
      synchronized (this.K)
      {
        if (this.K.booleanValue())
        {
          Iterator localIterator = this.bA.values().iterator();
          i = 0;
          if (localIterator.hasNext()) {
            i += ((Integer)localIterator.next()).intValue();
          }
        }
        else
        {
          return i;
        }
      }
    }
  }
  
  public void g(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_login", paramBoolean).commit();
  }
  
  public String getNickName(String paramString)
  {
    if (this.bB != null)
    {
      paramString = (PublicAccountInfo)this.bB.get(paramString);
      if (paramString != null) {
        return paramString.name;
      }
    }
    return "";
  }
  
  public void h(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("subscribe_setTop_flag", paramBoolean).commit();
  }
  
  public void i(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe", paramBoolean).commit();
  }
  
  public void j(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe_no_reset", paramBoolean).commit();
  }
  
  public boolean j(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (this.mDataList == null) {}
    synchronized (this.bB)
    {
      if (this.mDataList == null)
      {
        EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
        b(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      return this.bB.containsKey(paramString);
    }
  }
  
  public void l(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    aw(paramQQAppInterface);
    if ((this.bA != null) && (this.bA.keySet().contains(paramString))) {
      this.bA.put(paramString, Integer.valueOf(0));
    }
    ao(paramQQAppInterface);
    aalb.l(paramQQAppInterface, paramString, ocp.e(paramQQAppInterface, paramString));
  }
  
  public boolean p(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troopbar_assist", true);
  }
  
  public boolean q(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("subscribe_setTop_flag", false);
  }
  
  public boolean r(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("first_enter_subscribe_no_reset", true);
  }
  
  public int rd()
  {
    int j;
    if (this.dt != null)
    {
      Iterator localIterator = this.dt.values().iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label59;
      }
      if (!((TroopBarData)localIterator.next()).mIsSticky) {
        break label61;
      }
      i += 1;
    }
    label59:
    label61:
    for (;;)
    {
      break;
      j = 0;
      return j;
    }
  }
  
  public static class a
  {
    static oan a = new oan(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oan
 * JD-Core Version:    0.7.0.1
 */