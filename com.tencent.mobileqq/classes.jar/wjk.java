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
import java.util.List<Lwvn;>;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class wjk
  implements Manager
{
  private static long jdField_a_of_type_Long;
  anyu jdField_a_of_type_Anyu = new wjl(this);
  private anyw jdField_a_of_type_Anyw;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private Double jdField_a_of_type_JavaLangDouble;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile String jdField_a_of_type_JavaLangString;
  private Map<Long, wvn> jdField_a_of_type_JavaUtilMap;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private xav jdField_a_of_type_Xav;
  
  public wjk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private int a(List<wvn> paramList, wvn paramwvn)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (paramwvn.jdField_b_of_type_Long == ((wvn)paramList.get(i)).jdField_b_of_type_Long) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int a(wvn paramwvn)
  {
    boolean bool1 = b(paramwvn);
    if (!bool1) {}
    boolean bool2;
    do
    {
      return -3;
      bool2 = c(paramwvn);
    } while (!bool2);
    boolean bool3 = a(paramwvn);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "tellHaloState: invoked. Message: storyNodeRecently: " + bool2 + " storyNodeVideoAllRead: " + bool3 + " storyVideoExisted: " + bool1);
    }
    if (!bool3) {
      return -1;
    }
    return -2;
  }
  
  public static long a(long paramLong)
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
  
  private boolean a(@Nullable wvn paramwvn)
  {
    if (paramwvn == null) {}
    while (paramwvn.jdField_b_of_type_Int <= 0) {
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "init: invoked.  this: " + this);
    }
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(99);
    this.jdField_a_of_type_Xav = new xav(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Anyw = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "parseJsonConfig: invoked. Message: json: " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      this.jdField_a_of_type_JavaLangDouble = Double.valueOf(0.0D);
      return;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    if (localJSONObject.optInt("enabled") == 1) {}
    for (paramString = Boolean.TRUE;; paramString = Boolean.FALSE)
    {
      this.jdField_a_of_type_JavaLangBoolean = paramString;
      this.jdField_a_of_type_JavaLangDouble = Double.valueOf(localJSONObject.optDouble("timeout_day", 0.0D));
      return;
    }
  }
  
  private static boolean b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - jdField_a_of_type_Long;
    if ((l2 > 0L) && (l2 < 3000L)) {
      return true;
    }
    jdField_a_of_type_Long = l1;
    return false;
  }
  
  private boolean b(@Nullable wvn paramwvn)
  {
    if (paramwvn == null) {}
    while (paramwvn.a.size() <= 0) {
      return false;
    }
    return true;
  }
  
  private boolean c(@Nullable wvn paramwvn)
  {
    if (paramwvn == null) {}
    long l1;
    long l3;
    long l4;
    do
    {
      return false;
      l1 = NetConnInfoCenter.getServerTime();
      long l2 = paramwvn.d;
      l3 = a(l2);
      l4 = a();
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "isStoryNodeRecently: invoked. Message: timeoutSecond: " + l4 + " serverTime: " + l1 + " nodeInfoTimeStamp: " + l2);
      }
    } while (l1 - l3 >= l4);
    return true;
  }
  
  public long a()
  {
    String str;
    if (this.jdField_a_of_type_JavaLangDouble == null) {
      str = bhsi.r(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    try
    {
      b(str);
      return (86400 * this.jdField_a_of_type_JavaLangDouble.doubleValue());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StoryHaloManager", 2, "getEnabled: failed. Message: exception: " + localException);
        }
        this.jdField_a_of_type_JavaLangDouble = Double.valueOf(0.0D);
      }
    }
  }
  
  public List<wvn> a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class);
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
      wvn localwvn = new wvn();
      localwvn.a(localMsgTabHaloEntity);
      localArrayList.add(localwvn);
    }
    return localArrayList;
  }
  
  @NonNull
  public List<Long> a(List<RecentBaseData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = new ArrayList(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (a(localObject))
      {
        localObject = (RecentItemChatMsgData)localObject;
        try
        {
          localArrayList.add(Long.valueOf(Long.valueOf(((RecentItemChatMsgData)localObject).getRecentUserUin()).longValue()));
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
  public wvn a(@NonNull String paramString)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), new String[] { paramString }, null, null, null, null);
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
        paramString = new wvn();
        paramString.a(localMsgTabHaloEntity);
      }
    }
    return paramString;
  }
  
  @Nullable
  public wvn a(@NonNull wvn paramwvn)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), MsgTabHaloEntity.getSelectionArgs(paramwvn), null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryUserNode: invoked. Message: msgTabHaloEntities: " + localList);
    }
    paramwvn = localMsgTabHaloEntity;
    if (localList != null)
    {
      paramwvn = localMsgTabHaloEntity;
      if (localList.size() > 0)
      {
        localMsgTabHaloEntity = (MsgTabHaloEntity)localList.get(0);
        paramwvn = new wvn();
        paramwvn.a(localMsgTabHaloEntity);
      }
    }
    return paramwvn;
  }
  
  public void a()
  {
    xaw localxaw = new xaw(true);
    wjj.a().dispatch(localxaw);
  }
  
  public void a(int paramInt, List<Long> paramList) {}
  
  public void a(View paramView, @NonNull RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "onClick: invoked. Message: uin: " + paramRecentItemChatMsgData.getRecentUserUin());
    }
    Bosses.get().postLightWeightJob(new StoryHaloManager.2(this, paramRecentItemChatMsgData, paramView), 0);
  }
  
  public void a(RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (!a())
    {
      paramRecentItemChatMsgData.haloState = 0;
      return;
    }
    Object localObject = paramRecentItemChatMsgData.getRecentUserUin();
    try
    {
      long l = Long.valueOf((String)localObject).longValue();
      localObject = (wvn)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
      int i = a((wvn)localObject);
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
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = bhsi.aE(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str;
    if (i != j)
    {
      str = arry.b(paramConfig, j, paramConfig.type.get());
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
      bhsi.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramConfig.version.get(), str);
      try
      {
        b(str);
        return;
      }
      catch (Exception paramConfig) {}
    } while (!QLog.isColorLevel());
    QLog.e("StoryHaloManager", 2, "handleConfig: failed. Message: exception: " + paramConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NonNull List<wvn> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_JavaUtilMap.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wvn localwvn1 = (wvn)paramList.next();
      if (localwvn1.e != 1)
      {
        b(localwvn1);
      }
      else
      {
        wvn localwvn2 = (wvn)localConcurrentHashMap.get(Long.valueOf(localwvn1.jdField_b_of_type_Long));
        if (localwvn2 == null)
        {
          localwvn1 = a(String.valueOf(localwvn1.jdField_b_of_type_Long));
          if (QLog.isColorLevel()) {
            QLog.i("StoryHaloManager", 2, "updateHaloStateMap: invoked. use db cache. dbMsgNode: " + localwvn1);
          }
          b(localwvn1);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("StoryHaloManager", 2, "updateHaloStateMap: invoked. use memory cache. backupNode: " + localwvn2);
          }
          b(localwvn2);
        }
      }
    }
  }
  
  public void a(List<wvn> paramList, boolean paramBoolean)
  {
    List localList = a();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
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
        localObject = (wvn)localIterator.next();
        paramList = (List<wvn>)localObject;
        int i;
        if (((wvn)localObject).e == 1)
        {
          i = a(localList, (wvn)localObject);
          if (i != -1) {
            break label174;
          }
          paramList = (List<wvn>)localObject;
          if (QLog.isColorLevel())
          {
            QLog.e("StoryHaloManager", 2, "dbBuildAllNodes: failed.  exception: info: " + localObject);
            paramList = (List<wvn>)localObject;
          }
        }
        localEntityManager.persistOrReplace(paramList.a());
        continue;
        paramList = (wvn)localList.get(i);
      }
      finally
      {
        localEntityManager.getTransaction().end();
      }
    }
    localEntityManager.getTransaction().commit();
    localEntityManager.getTransaction().end();
  }
  
  public void a(@NonNull wvn paramwvn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "handlePushPacket: invoked. Message: msgTabNodeInfo: " + paramwvn);
    }
    d(paramwvn);
    wvn localwvn = a(paramwvn);
    if ((localwvn != null) && (localwvn.c < paramwvn.c))
    {
      c(paramwvn);
      b(paramwvn);
    }
    while ((localwvn != null) || (paramwvn == null)) {
      return;
    }
    c(paramwvn);
    b(paramwvn);
  }
  
  public boolean a()
  {
    String str;
    if (this.jdField_a_of_type_JavaLangBoolean == null) {
      str = bhsi.r(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    try
    {
      b(str);
      return Boolean.TRUE.equals(this.jdField_a_of_type_JavaLangBoolean);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StoryHaloManager", 2, "getEnabled: failed. Message: exception: " + localException);
        }
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
    }
  }
  
  public boolean a(@Nullable Object paramObject)
  {
    return false;
  }
  
  @Nullable
  public wvn b(@NonNull String paramString)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, "unionId=?", new String[] { paramString }, null, null, null, null);
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
        paramString = new wvn();
        paramString.a(localMsgTabHaloEntity);
      }
    }
    return paramString;
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (b()) {
        return;
      }
      List localList = a(this.jdField_a_of_type_JavaUtilSet, paramList);
      if (localList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet(paramList);
        a(paramInt, localList);
      }
      return;
    }
  }
  
  public void b(wvn paramwvn)
  {
    if (paramwvn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "tinkerHaloStateMap: invoked.  msgTabNodeInfo: " + paramwvn);
      }
      return;
    }
    long l = paramwvn.jdField_b_of_type_Long;
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), paramwvn);
  }
  
  public boolean b(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a(paramObject))
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
  
  public void c(wvn paramwvn)
  {
    if (paramwvn.e == 1) {
      return;
    }
    QQStoryContext.a().a().createEntityManager().persistOrReplace(paramwvn.a());
  }
  
  public void d(wvn paramwvn)
  {
    if (paramwvn == null) {}
    do
    {
      return;
      i = a(paramwvn);
    } while (i == -3);
    if (i == -1) {}
    for (int i = 1;; i = 2)
    {
      yup.a("msg_tab", "circle_exp", 0, i, new String[] { String.valueOf(paramwvn.jdField_b_of_type_Long) });
      return;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "onDestroy: invoked.  this: " + this);
    }
    if (this.jdField_a_of_type_Xav != null) {
      this.jdField_a_of_type_Xav.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjk
 * JD-Core Version:    0.7.0.1
 */