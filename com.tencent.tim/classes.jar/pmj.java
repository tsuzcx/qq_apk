import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryHaloManager.2;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabHaloEntity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lpuh;>;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class pmj
  implements Manager
{
  private static long Ac;
  private Boolean O;
  acfd jdField_a_of_type_Acfd = new pmk(this);
  private pxu jdField_a_of_type_Pxu;
  private volatile String atL;
  private Set<Long> az;
  private acff jdField_b_of_type_Acff;
  private Double jdField_b_of_type_JavaLangDouble;
  private final Object bh = new Object();
  private Map<Long, puh> fB;
  private final QQAppInterface mApp;
  
  public pmj(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    init();
  }
  
  public static long H(long paramLong)
  {
    int i = 86400 * (int)(paramLong / 86400);
    if (QLog.isColorLevel())
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC+8"));
      localObject = ((SimpleDateFormat)localObject).format(new Date(i * 1000L));
      QLog.i("StoryHaloManager", 2, "todayDawnSecond: invoked. Message: wholeDaySecond: " + i + " format: " + (String)localObject);
    }
    return i;
  }
  
  private static boolean Is()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - Ac;
    if ((l2 > 0L) && (l2 < 3000L)) {
      return true;
    }
    Ac = l1;
    return false;
  }
  
  private int a(List<puh> paramList, puh parampuh)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (parampuh.uid == ((puh)paramList.get(i)).uid) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int a(puh parampuh)
  {
    boolean bool1 = b(parampuh);
    if (!bool1) {}
    boolean bool2;
    do
    {
      return -3;
      bool2 = c(parampuh);
    } while (!bool2);
    boolean bool3 = a(parampuh);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "tellHaloState: invoked. Message: storyNodeRecently: " + bool2 + " storyNodeVideoAllRead: " + bool3 + " storyVideoExisted: " + bool1);
    }
    if (!bool3) {
      return -1;
    }
    return -2;
  }
  
  private List<Long> a(Set<Long> paramSet, List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramSet == null) && (paramList == null)) {
      localObject = localArrayList;
    }
    do
    {
      return localObject;
      if (paramSet != null) {
        break;
      }
      localObject = paramList;
    } while (paramList != null);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (Long)paramList.next();
      if (!paramSet.contains(localObject)) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  private boolean a(@Nullable puh parampuh)
  {
    if (parampuh == null) {}
    while (parampuh.unreadCount <= 0) {
      return true;
    }
    return false;
  }
  
  private boolean b(@Nullable puh parampuh)
  {
    if (parampuh == null) {}
    while (parampuh.iO.size() <= 0) {
      return false;
    }
    return true;
  }
  
  private boolean c(@Nullable puh parampuh)
  {
    if (parampuh == null) {}
    long l1;
    long l3;
    long l4;
    do
    {
      return false;
      l1 = NetConnInfoCenter.getServerTime();
      long l2 = parampuh.nodeInfoTimeStamp;
      l3 = H(l2);
      l4 = dG();
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "isStoryNodeRecently: invoked. Message: timeoutSecond: " + l4 + " serverTime: " + l1 + " nodeInfoTimeStamp: " + l2);
      }
    } while (l1 - l3 >= l4);
    return true;
  }
  
  private void init()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "init: invoked.  this: " + this);
    }
    this.fB = new ConcurrentHashMap(99);
    this.jdField_a_of_type_Pxu = new pxu(this.mApp);
    this.jdField_b_of_type_Acff = ((acff)this.mApp.getManager(51));
    this.mApp.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  private void qN(String paramString)
    throws Exception
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "parseJsonConfig: invoked. Message: json: " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.O = Boolean.valueOf(false);
      this.jdField_b_of_type_JavaLangDouble = Double.valueOf(0.0D);
      return;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    if (localJSONObject.optInt("enabled") == 1) {}
    for (paramString = Boolean.TRUE;; paramString = Boolean.FALSE)
    {
      this.O = paramString;
      this.jdField_b_of_type_JavaLangDouble = Double.valueOf(localJSONObject.optDouble("timeout_day", 0.0D));
      return;
    }
  }
  
  public void A(int paramInt, List<Long> paramList)
  {
    synchronized (this.bh)
    {
      if (Is()) {
        return;
      }
      List localList = a(this.az, paramList);
      if (localList.size() > 0)
      {
        this.az = new HashSet(paramList);
        z(paramInt, localList);
      }
      return;
    }
  }
  
  @Nullable
  public puh a(@NonNull String paramString)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().getEntityManagerFactory().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), new String[] { paramString }, null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryUinNode: invoked. Message: msgTabHaloEntities: " + localList);
    }
    paramString = localMsgTabHaloEntity;
    if (localList != null)
    {
      paramString = localMsgTabHaloEntity;
      if (localList.size() > 0)
      {
        localMsgTabHaloEntity = (MsgTabHaloEntity)localList.get(0);
        paramString = new puh();
        paramString.a(localMsgTabHaloEntity);
      }
    }
    return paramString;
  }
  
  @Nullable
  public puh a(@NonNull puh parampuh)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().getEntityManagerFactory().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), MsgTabHaloEntity.getSelectionArgs(parampuh), null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryUserNode: invoked. Message: msgTabHaloEntities: " + localList);
    }
    parampuh = localMsgTabHaloEntity;
    if (localList != null)
    {
      parampuh = localMsgTabHaloEntity;
      if (localList.size() > 0)
      {
        localMsgTabHaloEntity = (MsgTabHaloEntity)localList.get(0);
        parampuh = new puh();
        parampuh.a(localMsgTabHaloEntity);
      }
    }
    return parampuh;
  }
  
  public void a(View paramView, @NonNull RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "onClick: invoked. Message: uin: " + paramRecentItemChatMsgData.qx());
    }
    Bosses.get().postLightWeightJob(new StoryHaloManager.2(this, paramRecentItemChatMsgData, paramView), 0);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.bn(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    String str;
    if (i != j)
    {
      str = aevk.a(paramConfig, j, paramConfig.type.get());
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "handleConfig: invoked. Message: configJson: " + str);
      }
      if (!TextUtils.isEmpty(str)) {
        break label87;
      }
    }
    label87:
    do
    {
      return;
      aqmj.f(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramConfig.version.get(), str);
      try
      {
        qN(str);
        return;
      }
      catch (Exception paramConfig) {}
    } while (!QLog.isColorLevel());
    QLog.e("StoryHaloManager", 2, "handleConfig: failed. Message: exception: " + paramConfig);
  }
  
  public void a(@NonNull puh parampuh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "handlePushPacket: invoked. Message: msgTabNodeInfo: " + parampuh);
    }
    d(parampuh);
    puh localpuh = a(parampuh);
    if ((localpuh != null) && (localpuh.reqTimeStamp < parampuh.reqTimeStamp))
    {
      c(parampuh);
      b(parampuh);
    }
    while ((localpuh != null) || (parampuh == null)) {
      return;
    }
    c(parampuh);
    b(parampuh);
  }
  
  @NonNull
  public List<Long> aj(List<RecentBaseData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = new ArrayList(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (r(localObject))
      {
        localObject = (RecentItemChatMsgData)localObject;
        try
        {
          localArrayList.add(Long.valueOf(Long.valueOf(((RecentItemChatMsgData)localObject).qx()).longValue()));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("StoryHaloManager", 1, "getFriendUins: failed.  exception: " + localNumberFormatException);
        }
      }
    }
    return localArrayList;
  }
  
  @Nullable
  public puh b(@NonNull String paramString)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().getEntityManagerFactory().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, "unionId=?", new String[] { paramString }, null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryUnionIdNode: invoked. Message: msgTabHaloEntities: " + localList);
    }
    paramString = localMsgTabHaloEntity;
    if (localList != null)
    {
      paramString = localMsgTabHaloEntity;
      if (localList.size() > 0)
      {
        localMsgTabHaloEntity = (MsgTabHaloEntity)localList.get(0);
        paramString = new puh();
        paramString.a(localMsgTabHaloEntity);
      }
    }
    return paramString;
  }
  
  public void b(RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (!getEnabled())
    {
      paramRecentItemChatMsgData.haloState = 0;
      return;
    }
    Object localObject = paramRecentItemChatMsgData.qx();
    try
    {
      long l = Long.valueOf((String)localObject).longValue();
      localObject = (puh)this.fB.get(Long.valueOf(l));
      int i = a((puh)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "assignHaloState: invoked. Message: haloState: " + i + " uin: " + l + " msgTabNodeInfo: " + localObject);
      }
      paramRecentItemChatMsgData.haloState = i;
      return;
    }
    catch (NumberFormatException paramRecentItemChatMsgData)
    {
      QLog.e("StoryHaloManager", 1, "assignHaloState: failed.  exception: " + paramRecentItemChatMsgData);
    }
  }
  
  public void b(puh parampuh)
  {
    if (parampuh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "tinkerHaloStateMap: invoked.  msgTabNodeInfo: " + parampuh);
      }
      return;
    }
    long l = parampuh.uid;
    this.fB.put(Long.valueOf(l), parampuh);
  }
  
  public List<puh> bI()
  {
    Object localObject = QQStoryContext.a().getEntityManagerFactory().createEntityManager().query(MsgTabHaloEntity.class);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryAllNode: invoked. Message: entities: " + localObject);
    }
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabHaloEntity localMsgTabHaloEntity = (MsgTabHaloEntity)((Iterator)localObject).next();
      puh localpuh = new puh();
      localpuh.a(localMsgTabHaloEntity);
      localArrayList.add(localpuh);
    }
    return localArrayList;
  }
  
  public void blT()
  {
    pxu.a locala = new pxu.a(true);
    pmi.a().dispatch(locala);
  }
  
  public void c(puh parampuh)
  {
    if (parampuh.noUpdate == 1) {
      return;
    }
    QQStoryContext.a().getEntityManagerFactory().createEntityManager().persistOrReplace(parampuh.a());
  }
  
  public void d(puh parampuh)
  {
    if (parampuh == null) {}
    do
    {
      return;
      i = a(parampuh);
    } while (i == -3);
    if (i == -1) {}
    for (int i = 1;; i = 2)
    {
      rar.a("msg_tab", "circle_exp", 0, i, new String[] { String.valueOf(parampuh.uid) });
      return;
    }
  }
  
  public long dG()
  {
    String str;
    if (this.jdField_b_of_type_JavaLangDouble == null) {
      str = aqmj.aj(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    }
    try
    {
      qN(str);
      return (86400 * this.jdField_b_of_type_JavaLangDouble.doubleValue());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StoryHaloManager", 2, "getEnabled: failed. Message: exception: " + localException);
        }
        this.jdField_b_of_type_JavaLangDouble = Double.valueOf(0.0D);
      }
    }
  }
  
  public void dS(@NonNull List<puh> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(this.fB);
    this.fB.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      puh localpuh1 = (puh)paramList.next();
      if (localpuh1.noUpdate != 1)
      {
        b(localpuh1);
      }
      else
      {
        puh localpuh2 = (puh)localConcurrentHashMap.get(Long.valueOf(localpuh1.uid));
        if (localpuh2 == null)
        {
          localpuh1 = a(String.valueOf(localpuh1.uid));
          if (QLog.isColorLevel()) {
            QLog.i("StoryHaloManager", 2, "updateHaloStateMap: invoked. use db cache. dbMsgNode: " + localpuh1);
          }
          b(localpuh1);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("StoryHaloManager", 2, "updateHaloStateMap: invoked. use memory cache. backupNode: " + localpuh2);
          }
          b(localpuh2);
        }
      }
    }
  }
  
  public boolean getEnabled()
  {
    String str;
    if (this.O == null) {
      str = aqmj.aj(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    }
    try
    {
      qN(str);
      return Boolean.TRUE.equals(this.O);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StoryHaloManager", 2, "getEnabled: failed. Message: exception: " + localException);
        }
        this.O = Boolean.valueOf(false);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "onDestroy: invoked.  this: " + this);
    }
    if (this.jdField_a_of_type_Pxu != null) {
      this.jdField_a_of_type_Pxu.destroy();
    }
    if (this.mApp != null) {
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
    }
    this.fB.clear();
  }
  
  public void qS(String paramString)
  {
    this.atL = paramString;
  }
  
  public boolean r(@Nullable Object paramObject)
  {
    return false;
  }
  
  public boolean s(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (r(paramObject))
    {
      paramObject = (RecentItemChatMsgData)paramObject;
      if (paramObject.haloState != -1)
      {
        bool1 = bool2;
        if (paramObject.haloState != -2) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void v(List<puh> paramList, boolean paramBoolean)
  {
    List localList = bI();
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    label174:
    for (;;)
    {
      try
      {
        Object localObject = new MsgTabHaloEntity();
        ((MsgTabHaloEntity)localObject).setStatus(1001);
        localEntityManager.remove((Entity)localObject, null, null);
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (puh)localIterator.next();
        paramList = (List<puh>)localObject;
        int i;
        if (((puh)localObject).noUpdate == 1)
        {
          i = a(localList, (puh)localObject);
          if (i != -1) {
            break label174;
          }
          paramList = (List<puh>)localObject;
          if (QLog.isColorLevel())
          {
            QLog.e("StoryHaloManager", 2, "dbBuildAllNodes: failed.  exception: info: " + localObject);
            paramList = (List<puh>)localObject;
          }
        }
        localEntityManager.persistOrReplace(paramList.a());
        continue;
        paramList = (puh)localList.get(i);
      }
      finally
      {
        localEntityManager.getTransaction().end();
      }
    }
    localEntityManager.getTransaction().commit();
    localEntityManager.getTransaction().end();
  }
  
  public void z(int paramInt, List<Long> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmj
 * JD-Core Version:    0.7.0.1
 */