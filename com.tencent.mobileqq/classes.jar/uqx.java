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
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.BaseRecentUser;
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

public class uqx
{
  protected long a;
  protected Boolean a;
  public Object a;
  protected String a;
  Comparator<TroopBarData> a;
  public List<TroopBarData> a;
  protected final Map<String, TroopBarData> a;
  public ConcurrentHashMap<String, Integer> a;
  protected boolean a;
  protected long b;
  protected final ConcurrentHashMap<String, PublicAccountInfo> b;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  
  private uqx()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilComparator = new uqy(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private long a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getLong("troopbar_recent_item_last_del_time", 0L);
      this.jdField_b_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBarAssistantManager", 2, "getTroopBarRecentItemLastDelTime, lastDelTime:" + this.jdField_b_of_type_Long);
    }
    return this.jdField_b_of_type_Long;
  }
  
  private TroopBarData a(QQAppInterface arg1, String paramString)
  {
    a(???);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private TroopBarData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      TroopBarData localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      paramEntityManager = localTroopBarData;
      if (localTroopBarData == null)
      {
        localTroopBarData = new TroopBarData();
        localTroopBarData.mUin = paramString;
        paramQQAppInterface = paramQQAppInterface.getMessageFacade();
        paramEntityManager = localTroopBarData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramString, 1008);
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
      if (uot.d(paramQQAppInterface, localTroopBarData.mUin)) {
        localArrayList.add(localTroopBarData);
      }
    }
    return localArrayList;
  }
  
  public static uqx a()
  {
    try
    {
      if (uqz.a == null) {
        uqz.a = new uqx();
      }
      uqx localuqx = uqz.a;
      return localuqx;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager, TroopBarData paramTroopBarData)
  {
    if (paramTroopBarData == null) {
      return;
    }
    paramEntityManager = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramTroopBarData.mUin);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramTroopBarData.mUin, paramTroopBarData);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          if (paramEntityManager != null) {
            this.jdField_a_of_type_JavaUtilList.remove(paramEntityManager);
          }
          this.jdField_a_of_type_JavaUtilList.remove(paramTroopBarData);
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramTroopBarData);
          if (QLog.isColorLevel()) {
            QLog.i("TroopBarAssistantManager", 2, "save TroopBarData " + paramTroopBarData.mUin + " to dataList");
          }
        }
        a();
        paramEntityManager = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
        if (paramTroopBarData.getStatus() == 1000)
        {
          paramEntityManager.addMsgQueue(paramQQAppInterface.getAccount(), 0, paramTroopBarData.getTableName(), paramTroopBarData, 3, null);
          paramQQAppInterface = (KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
          paramQQAppInterface.l();
          paramQQAppInterface.b(null);
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
    if (!uot.d(paramQQAppInterface, paramString)) {
      return;
    }
    l(paramQQAppInterface);
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break label108;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue() + 1));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopBarAssistantManager", 2, "add uin " + paramString + " to newMsgMap");
      }
      k(paramQQAppInterface);
      return;
      label108:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(1));
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int j = 0;
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    aoxz localaoxz = paramQQAppInterface.getProxyManager().a();
    if (localObject == null) {
      return false;
    }
    int i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      i = j;
      if (!this.c) {
        i = 1;
      }
    }
    if (i != 0)
    {
      localObject = (RecentUser)localaoxz.findRecentUserByUin(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
      if (((RecentUser)localObject).lastmsgtime < paramLong) {
        ((RecentUser)localObject).lastmsgtime = paramLong;
      }
      if (b(paramQQAppInterface)) {
        localaoxz.saveRecentUser((BaseRecentUser)localObject);
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
      localObject = (RecentUser)localaoxz.findRecentUser(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
      if (localObject != null) {
        localaoxz.delRecentUser((BaseRecentUser)localObject);
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    TroopBarData localTroopBarData;
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      localObject2 = this.jdField_a_of_type_JavaLangObject;
      ??? = localTroopBarData;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          ??? = localTroopBarData;
          if (localTroopBarData == null)
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            ??? = localTroopBarData;
            if (localIterator.hasNext())
            {
              ??? = (TroopBarData)localIterator.next();
              if (!TextUtils.equals(((TroopBarData)???).mUin, paramString)) {
                continue;
              }
            }
          }
          this.jdField_a_of_type_JavaUtilList.remove(???);
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
  
  public static void b()
  {
    try
    {
      uqz.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
    paramString = (RecentUser)paramQQAppInterface.findRecentUser(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.delRecentUser(paramString);
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
          Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
        }
        long l;
        localObject = ((TroopBarData)this.jdField_a_of_type_JavaUtilList.get(i)).mUin;
      }
      catch (Exception ???)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList = ((List)localObject);
          if (this.jdField_a_of_type_JavaUtilList == null)
          {
            this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
            synchronized (this.jdField_a_of_type_JavaUtilMap)
            {
              this.jdField_a_of_type_JavaUtilMap.clear();
              paramQQAppInterface = this.jdField_a_of_type_JavaUtilList.iterator();
              if (!paramQQAppInterface.hasNext()) {
                break label368;
              }
              localObject = (TroopBarData)paramQQAppInterface.next();
              this.jdField_a_of_type_JavaUtilMap.put(((TroopBarData)localObject).mUin, localObject);
            }
            ??? = ???;
            if (QLog.isColorLevel()) {
              QLog.e("TroopBarAssistantManager", 2, "initTroopBarAssistRecent doInit error: ", ???);
            }
            return;
          }
          l = a(paramQQAppInterface);
          i = 0;
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            continue;
          }
          localObject = (TroopBarData)this.jdField_a_of_type_JavaUtilList.get(i);
          if (localObject == null)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TroopBarAssistantManager", 2, "doInit==> pad == null");
            }
            this.jdField_a_of_type_JavaUtilList.remove(i);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopBarAssistantManager", 2, "doInit==> uin:" + ((TroopBarData)localObject).mUin + ", lastMsgTime:" + ((TroopBarData)localObject).mLastMsgTime);
            }
            if (((TroopBarData)localObject).mLastMsgTime < l) {
              this.jdField_a_of_type_JavaUtilList.remove(i);
            }
          }
        }
      }
      finally {}
      ((TroopBarData)this.jdField_a_of_type_JavaUtilList.get(i)).mLatestMessage = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab((String)localObject, 1008);
      break label371;
      label368:
      return;
      label371:
      i += 1;
    }
  }
  
  private void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    a(paramString, paramQQAppInterface, false);
  }
  
  private void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!uot.d(paramQQAppInterface, paramString)) {
      return;
    }
    l(paramQQAppInterface);
    if (paramQQAppInterface.getConversationFacade().a(paramString, 1008) > 0)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break label73;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue() + 1));
    }
    for (;;)
    {
      k(paramQQAppInterface);
      return;
      label73:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(1));
    }
  }
  
  private void j(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {}
      synchronized (this.jdField_a_of_type_JavaLangBoolean)
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
        ??? = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        this.jdField_a_of_type_Boolean = ((SharedPreferences)???).getBoolean("troopbar_assist_show_in_msg", true);
        this.jdField_a_of_type_Long = ((SharedPreferences)???).getLong("troopbar_assist_last_read_time", 0L);
        this.c = ((SharedPreferences)???).getBoolean("troopbar_assist_deleted", false);
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList = null;
      l(paramQQAppInterface);
      this.jdField_b_of_type_Boolean = false;
      return;
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void k(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new TroopBarAssistantManager.2(this, paramQQAppInterface));
  }
  
  private void l(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangBoolean)
      {
        if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          Object localObject = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getString("troopbar_assist_new_unread_list", "");
          if (bmhv.b()) {
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
              if (!uot.d(paramQQAppInterface, str)) {
                continue;
              }
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(localJSONObject.getInt(str)));
              continue;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("TroopBarAssistantManager", 2, "initNewMsgMapIfNeeds:" + paramQQAppInterface.toString());
            }
            this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
            if (bmhv.b()) {
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
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
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
  
  public int a(QQAppInterface arg1)
  {
    int i = 0;
    if (!???.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
      return 0;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangBoolean)
      {
        if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
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
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      paramQQAppInterface = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (paramQQAppInterface.hasNext())
      {
        Object localObject = (String)paramQQAppInterface.next();
        if (paramString.equals(localObject))
        {
          localObject = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          if (localObject != null) {
            return ((Integer)localObject).intValue();
          }
        }
      }
    }
    return 0;
  }
  
  public TroopBarData a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    for (;;)
    {
      TroopBarData localTroopBarData;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break;
        }
        long l = a(paramQQAppInterface);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localTroopBarData = (TroopBarData)localIterator.next();
        if (localTroopBarData.mLastMsgTime < l) {
          localIterator.remove();
        }
      }
      DraftSummaryInfo localDraftSummaryInfo = paramQQAppInterface.getMessageFacade().getDraftSummaryInfo(localTroopBarData.mUin, 1008);
      if (localDraftSummaryInfo != null) {
        localTroopBarData.mLastDraftTime = localDraftSummaryInfo.getTime();
      } else {
        localTroopBarData.mLastDraftTime = 0L;
      }
    }
    a();
    paramQQAppInterface = a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList);
    if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty())) {}
    for (paramQQAppInterface = (TroopBarData)paramQQAppInterface.get(0);; paramQQAppInterface = null)
    {
      return paramQQAppInterface;
      if (QLog.isColorLevel()) {
        QLog.w("TroopBarAssistantManager", 2, "getFirstData return null");
      }
    }
  }
  
  public String a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      paramString = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        return paramString.name;
      }
    }
    return "";
  }
  
  public String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = ((aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(paramString);
    if (paramString != null) {
      return paramString.name;
    }
    return "";
  }
  
  public List<TroopBarData> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramQQAppInterface);
    for (;;)
    {
      int j;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          int i = 0;
          long l = a(paramQQAppInterface);
          j = this.jdField_a_of_type_JavaUtilList.size() - 1;
          if (j >= 0)
          {
            TroopBarData localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localTroopBarData == null)
            {
              this.jdField_a_of_type_JavaUtilList.remove(j);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopBarAssistantManager", 2, "getUseTroopBarAssistList==> uin:" + localTroopBarData.mUin + ", lastMsgTime:" + localTroopBarData.mLastMsgTime);
              }
              if (localTroopBarData.mLastMsgTime < l)
              {
                this.jdField_a_of_type_JavaUtilList.remove(j);
              }
              else
              {
                MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(localTroopBarData.mUin, 1008);
                if (localMessageRecord == null)
                {
                  this.jdField_a_of_type_JavaUtilList.remove(j);
                }
                else if (localMessageRecord.time > localTroopBarData.mLastMsgTime)
                {
                  ((TroopBarData)this.jdField_a_of_type_JavaUtilList.get(j)).mLastMsgTime = localMessageRecord.time;
                  i = 1;
                }
              }
            }
          }
          else
          {
            if (i != 0) {
              Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
            }
            localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
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
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        i = 1;
        if (i != 0)
        {
          ??? = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          b((EntityManager)???, paramQQAppInterface);
          ((EntityManager)???).close();
          paramQQAppInterface = ((aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext())
            {
              ??? = (PublicAccountInfo)paramQQAppInterface.next();
              this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PublicAccountInfo)???).getUin(), ???);
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
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
      j(paramQQAppInterface);
    }
    this.jdField_a_of_type_Long = paramLong;
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troopbar_assist_last_read_time", paramLong).commit();
    RecentUser localRecentUser = (RecentUser)paramQQAppInterface.getProxyManager().a().findRecentUserByUin(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
    if (localRecentUser != null) {
      localRecentUser.lastmsgtime = paramLong;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (bmhv.b()) {
      QLog.i("TroopBarAssistantManager", 2, "setLastReadTime, newMsgStr clear in memory");
    }
    k(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    l(paramQQAppInterface);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().contains(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
    }
    k(paramQQAppInterface);
    alik.b(paramQQAppInterface, paramString, uuc.b(paramQQAppInterface, paramString));
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<PublicAccountInfo> paramList)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      if (((aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).jdField_a_of_type_Boolean) {
        break;
      }
    } while (!bmhv.b());
    QLog.w("TroopBarAssistantManager", 2, "refreshSettings but padm not cached");
    return;
    this.d = true;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramList.next();
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
      }
    }
    f(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troopbar_assist_deleted", paramBoolean).commit();
    this.c = paramBoolean;
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (b(paramQQAppInterface)) {
      if ((!this.jdField_a_of_type_Boolean) || (this.c)) {
        break label99;
      }
    }
    label99:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = (RecentUser)paramQQAppInterface.getProxyManager().a().findRecentUserByUin(AppConstants.TROOP_BAR_ASSISTANT_UIN, 7210);
        if (paramMessageRecord.time >= ((RecentUser)localObject).lastmsgtime) {
          c(paramQQAppInterface, false);
        }
      }
      Object localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      a(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, (EntityManager)localObject, paramQQAppInterface);
      ((EntityManager)localObject).close();
      return;
    }
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
      QQMessageFacade.Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(localTroopBarData.mUin, 1008);
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
      if (this.c) {
        a(paramQQAppInterface, false);
      }
      b(paramQQAppInterface, paramString);
      a(paramQQAppInterface, paramLong);
      return;
      localTroopBarData.mLastMsgTime = paramLong;
    }
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      a(paramQQAppInterface);
      aoxz localaoxz = paramQQAppInterface.getProxyManager().a();
      Object localObject2 = localaoxz.getRecentList(false);
      long l = System.currentTimeMillis() / 1000L;
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if (((((RecentUser)localObject3).getType() == 1008) || (((RecentUser)localObject3).getType() == 1024)) && (a(paramQQAppInterface, ((RecentUser)localObject3).uin, ((RecentUser)localObject3).getType()))) {
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
            localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopBarData)localObject3).mUin, 1008);
            if (localMessage == null) {}
          }
          for (((TroopBarData)localObject3).mLastMsgTime = localMessage.time;; ((TroopBarData)localObject3).mLastMsgTime = ((RecentUser)localObject2).lastmsgtime)
          {
            a(paramQQAppInterface, paramEntityManager, (TroopBarData)localObject3);
            localaoxz.delRecentUser((BaseRecentUser)localObject2);
            e(((TroopBarData)localObject3).mUin, paramQQAppInterface);
            break;
          }
        }
      }
      ((PublicAccountHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).c();
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troopbar_assist", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (a(localEntityManager, paramString)) {
      d(paramString, paramQQAppInterface);
    }
    localEntityManager.close();
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, Context paramContext, aoav paramaoav)
  {
    uuc.a(paramQQAppInterface, paramContext, paramString, true, paramaoav);
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    l(paramQQAppInterface);
    if (((paramBoolean) || (paramQQAppInterface.getConversationFacade().a(paramString, 1008) > 0)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    k(paramQQAppInterface);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troopbar_assist", true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        b(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return (paramInt == 1008) && (uot.d(paramQQAppInterface, paramString));
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = a(paramQQAppInterface, paramString);
    if (paramString != null) {
      return paramString.mIsSticky;
    }
    return false;
  }
  
  public List<uqv> b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    Object localObject1 = new ArrayList();
    Object localObject3;
    for (;;)
    {
      long l;
      TroopBarData localTroopBarData;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label285;
        }
        l = a(paramQQAppInterface);
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localTroopBarData = (TroopBarData)((Iterator)localObject3).next();
        if (localTroopBarData == null) {
          ((Iterator)localObject3).remove();
        }
      }
      Object localObject4 = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(localTroopBarData.mUin, 1008);
      if (localObject4 == null)
      {
        ((Iterator)localObject3).remove();
      }
      else
      {
        localTroopBarData.mLatestMessage = ((MessageRecord)localObject4);
        localTroopBarData.mLastMsgTime = ((MessageRecord)localObject4).time;
        localObject4 = paramQQAppInterface.getMessageFacade().getDraftSummaryInfo(localTroopBarData.mUin, 1008);
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
    a();
    ((List)localObject1).addAll(a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList));
    label285:
    ??? = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (TroopBarData)((Iterator)localObject1).next();
      localObject3 = uqv.a(paramQQAppInterface, paramQQAppInterface.getApplication().getApplicationContext(), (TroopBarData)localObject3);
      if ((localObject3 != null) && (!((List)???).contains(localObject3))) {
        ((List)???).add(localObject3);
      }
    }
    return ???;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
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
      if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString)) {
        j(paramQQAppInterface);
      }
      if (b(paramQQAppInterface))
      {
        c(paramQQAppInterface, false);
        b(paramQQAppInterface, false);
        a(paramQQAppInterface, NetConnInfoCenter.getServerTime());
        return;
      }
      localTroopBarData = a(paramQQAppInterface);
    } while (localTroopBarData == null);
    a(paramQQAppInterface, localTroopBarData.mLastMsgTime);
  }
  
  public void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_login", paramBoolean).commit();
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = true;
      paramString.mLastStickyTime = (System.currentTimeMillis() / 1000L);
      ((ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).addMsgQueue(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      a();
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null)
      {
        paramString.sendEmptyMessage(1009);
        return;
      }
    }
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("subscribe_setTop_flag", false);
  }
  
  public List<PublicAccountInfo> c(QQAppInterface paramQQAppInterface)
  {
    Object localObject = ((aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if (uot.d(paramQQAppInterface, localPublicAccountInfo.getUin())) {
          localArrayList.add(localPublicAccountInfo);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (bmhv.b()) {
      QLog.i("TroopBarAssistantManager", 2, "setFirstEnterFeeds, newMsgStr clear in memory");
    }
    k(paramQQAppInterface);
  }
  
  public void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("subscribe_setTop_flag", paramBoolean).commit();
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = false;
      paramString.mLastStickyTime = 0L;
      ((ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).addMsgQueue(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      a();
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null)
      {
        paramString.sendEmptyMessage(1009);
        return;
      }
    }
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("first_enter_subscribe_no_reset", true);
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData = a(paramQQAppInterface);
    if (localTroopBarData != null) {}
    for (long l = localTroopBarData.mLastMsgTime;; l = NetConnInfoCenter.getServerTime())
    {
      a(paramQQAppInterface, l);
      return;
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe", paramBoolean).commit();
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new TroopBarAssistantManager.3(this, paramQQAppInterface));
  }
  
  public void e(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe_no_reset", paramBoolean).commit();
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    aoxz localaoxz = paramQQAppInterface.getProxyManager().a();
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ??? = localaoxz.getRecentList(false);
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).getType() == 1008) && (a(paramQQAppInterface, ((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType())) && (!((RecentUser)localObject4).shouldShowInRecentList(paramQQAppInterface))) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    a(paramQQAppInterface);
    Object localObject5;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (TroopBarData)((Iterator)localObject4).next();
          if (!a(paramQQAppInterface, ((TroopBarData)localObject5).mUin, 1008)) {
            ((ArrayList)localObject1).add(localObject5);
          }
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      if (this.c) {
        a(paramQQAppInterface, false);
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject2).next();
        localObject4 = a(localEntityManager, paramQQAppInterface, ((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject5 = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopBarData)localObject4).mUin, 1008);
          if (localObject5 == null) {}
        }
        for (((TroopBarData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((TroopBarData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a(paramQQAppInterface, localEntityManager, (TroopBarData)localObject4);
          localaoxz.delRecentUser((BaseRecentUser)???);
          e(((RecentUser)???).uin, paramQQAppInterface);
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
        localObject4 = (RecentUser)localaoxz.findRecentUserByUin(((TroopBarData)???).mUin, 1008);
        ((RecentUser)localObject4).uin = ((TroopBarData)???).mUin;
        ((RecentUser)localObject4).setType(1008);
        ((RecentUser)localObject4).lastmsgtime = ((TroopBarData)???).mLastMsgTime;
        ((RecentUser)localObject4).lastmsgdrafttime = ((TroopBarData)???).mLastDraftTime;
        if (bmhv.b())
        {
          localObject1 = (aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
          QLog.i("TroopBarAssistantManager", 2, "uinConfigMap size: " + this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ", pam cache: " + ((aoan)localObject1).jdField_a_of_type_Boolean);
          QLog.i("TroopBarAssistantManager", 2, "to remove incognizance TroopBarData " + ((TroopBarData)???).mUin + " from dataList");
        }
        if (a(localEntityManager, ((TroopBarData)???).mUin))
        {
          if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
          for (localObject1 = null;; localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(((TroopBarData)???).mUin))
          {
            if (localObject1 != null) {
              localaoxz.saveRecentUser((BaseRecentUser)localObject4);
            }
            if (bmhv.b()) {
              QLog.i("TroopBarAssistantManager", 2, "to remove incognizance uin " + ((TroopBarData)???).mUin + " from newMsgSet");
            }
            d(((TroopBarData)???).mUin, paramQQAppInterface);
            break;
          }
        }
      }
    }
    localObject1 = a(paramQQAppInterface);
    if (localObject1 != null) {
      a(paramQQAppInterface, ((TroopBarData)localObject1).mLastMsgTime);
    }
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
  
  public void g(QQAppInterface paramQQAppInterface)
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
  
  public void h(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit();
      this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
      paramQQAppInterface.putLong("troopbar_recent_item_last_del_time", this.jdField_b_of_type_Long);
      paramQQAppInterface.commit();
    } while (!QLog.isColorLevel());
    QLog.d("TroopBarAssistantManager", 2, "saveTroopBarRecentItemLastDelTime, lastDelTime:" + this.jdField_b_of_type_Long);
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    try
    {
      j(paramQQAppInterface);
      if (a(paramQQAppInterface) == true)
      {
        EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        a(localEntityManager, paramQQAppInterface);
        localEntityManager.close();
      }
      b(paramQQAppInterface);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqx
 * JD-Core Version:    0.7.0.1
 */