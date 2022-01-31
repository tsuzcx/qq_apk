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
import java.util.List<Lutx;>;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class uhu
  implements Manager
{
  private static long jdField_a_of_type_Long;
  alox jdField_a_of_type_Alox = new uhv(this);
  private aloz jdField_a_of_type_Aloz;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private Double jdField_a_of_type_JavaLangDouble;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile String jdField_a_of_type_JavaLangString;
  private Map<Long, utx> jdField_a_of_type_JavaUtilMap;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  private uzf jdField_a_of_type_Uzf;
  
  public uhu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private int a(List<utx> paramList, utx paramutx)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (paramutx.jdField_b_of_type_Long == ((utx)paramList.get(i)).jdField_b_of_type_Long) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int a(utx paramutx)
  {
    boolean bool1 = b(paramutx);
    if (!bool1) {}
    boolean bool2;
    do
    {
      return -3;
      bool2 = c(paramutx);
    } while (!bool2);
    boolean bool3 = a(paramutx);
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
  
  private boolean a(@Nullable utx paramutx)
  {
    if (paramutx == null) {}
    while (paramutx.jdField_b_of_type_Int <= 0) {
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
    this.jdField_a_of_type_Uzf = new uzf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aloz = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
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
  
  private boolean b(@Nullable utx paramutx)
  {
    if (paramutx == null) {}
    while (paramutx.a.size() <= 0) {
      return false;
    }
    return true;
  }
  
  private boolean c(@Nullable utx paramutx)
  {
    if (paramutx == null) {}
    long l1;
    long l3;
    long l4;
    do
    {
      return false;
      l1 = NetConnInfoCenter.getServerTime();
      long l2 = paramutx.d;
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
      str = bdiv.r(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
  
  public List<utx> a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().a(MsgTabHaloEntity.class);
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
      utx localutx = new utx();
      localutx.a(localMsgTabHaloEntity);
      localArrayList.add(localutx);
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
          localArrayList.add(Long.valueOf(Long.valueOf(((RecentItemChatMsgData)localObject).a()).longValue()));
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
  public utx a(@NonNull String paramString)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().a().createEntityManager().a(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), new String[] { paramString }, null, null, null, null);
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
        paramString = new utx();
        paramString.a(localMsgTabHaloEntity);
      }
    }
    return paramString;
  }
  
  @Nullable
  public utx a(@NonNull utx paramutx)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().a().createEntityManager().a(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), MsgTabHaloEntity.getSelectionArgs(paramutx), null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryUserNode: invoked. Message: msgTabHaloEntities: " + localList);
    }
    paramutx = localMsgTabHaloEntity;
    if (localList != null)
    {
      paramutx = localMsgTabHaloEntity;
      if (localList.size() > 0)
      {
        localMsgTabHaloEntity = (MsgTabHaloEntity)localList.get(0);
        paramutx = new utx();
        paramutx.a(localMsgTabHaloEntity);
      }
    }
    return paramutx;
  }
  
  public void a()
  {
    uzg localuzg = new uzg(true);
    uht.a().dispatch(localuzg);
  }
  
  public void a(int paramInt, List<Long> paramList) {}
  
  public void a(View paramView, @NonNull RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "onClick: invoked. Message: uin: " + paramRecentItemChatMsgData.a());
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
    Object localObject = paramRecentItemChatMsgData.a();
    try
    {
      long l = Long.valueOf((String)localObject).longValue();
      localObject = (utx)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
      int i = a((utx)localObject);
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
    int j = bdiv.aE(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str;
    if (i != j)
    {
      str = aova.b(paramConfig, j, paramConfig.type.get());
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
      bdiv.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramConfig.version.get(), str);
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
  
  public void a(@NonNull List<utx> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_JavaUtilMap.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      utx localutx1 = (utx)paramList.next();
      if (localutx1.e != 1)
      {
        b(localutx1);
      }
      else
      {
        utx localutx2 = (utx)localConcurrentHashMap.get(Long.valueOf(localutx1.jdField_b_of_type_Long));
        if (localutx2 == null)
        {
          localutx1 = a(String.valueOf(localutx1.jdField_b_of_type_Long));
          if (QLog.isColorLevel()) {
            QLog.i("StoryHaloManager", 2, "updateHaloStateMap: invoked. use db cache. dbMsgNode: " + localutx1);
          }
          b(localutx1);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("StoryHaloManager", 2, "updateHaloStateMap: invoked. use memory cache. backupNode: " + localutx2);
          }
          b(localutx2);
        }
      }
    }
  }
  
  public void a(List<utx> paramList, boolean paramBoolean)
  {
    List localList = a();
    awbw localawbw = QQStoryContext.a().a().createEntityManager();
    localawbw.a().a();
    if (paramBoolean) {}
    label174:
    for (;;)
    {
      try
      {
        Object localObject = new MsgTabHaloEntity();
        ((MsgTabHaloEntity)localObject).setStatus(1001);
        localawbw.a((awbv)localObject, null, null);
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (utx)localIterator.next();
        paramList = (List<utx>)localObject;
        int i;
        if (((utx)localObject).e == 1)
        {
          i = a(localList, (utx)localObject);
          if (i != -1) {
            break label174;
          }
          paramList = (List<utx>)localObject;
          if (QLog.isColorLevel())
          {
            QLog.e("StoryHaloManager", 2, "dbBuildAllNodes: failed.  exception: info: " + localObject);
            paramList = (List<utx>)localObject;
          }
        }
        localawbw.b(paramList.a());
        continue;
        paramList = (utx)localList.get(i);
      }
      finally
      {
        localawbw.a().b();
      }
    }
    localawbw.a().c();
    localawbw.a().b();
  }
  
  public void a(@NonNull utx paramutx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "handlePushPacket: invoked. Message: msgTabNodeInfo: " + paramutx);
    }
    d(paramutx);
    utx localutx = a(paramutx);
    if ((localutx != null) && (localutx.c < paramutx.c))
    {
      c(paramutx);
      b(paramutx);
    }
    while ((localutx != null) || (paramutx == null)) {
      return;
    }
    c(paramutx);
    b(paramutx);
  }
  
  public boolean a()
  {
    String str;
    if (this.jdField_a_of_type_JavaLangBoolean == null) {
      str = bdiv.r(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
  public utx b(@NonNull String paramString)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().a().createEntityManager().a(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, "unionId=?", new String[] { paramString }, null, null, null, null);
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
        paramString = new utx();
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
  
  public void b(utx paramutx)
  {
    if (paramutx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "tinkerHaloStateMap: invoked.  msgTabNodeInfo: " + paramutx);
      }
      return;
    }
    long l = paramutx.jdField_b_of_type_Long;
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), paramutx);
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
  
  public void c(utx paramutx)
  {
    if (paramutx.e == 1) {
      return;
    }
    QQStoryContext.a().a().createEntityManager().b(paramutx.a());
  }
  
  public void d(utx paramutx)
  {
    if (paramutx == null) {}
    do
    {
      return;
      i = a(paramutx);
    } while (i == -3);
    if (i == -1) {}
    for (int i = 1;; i = 2)
    {
      wta.a("msg_tab", "circle_exp", 0, i, new String[] { String.valueOf(paramutx.jdField_b_of_type_Long) });
      return;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "onDestroy: invoked.  this: " + this);
    }
    if (this.jdField_a_of_type_Uzf != null) {
      this.jdField_a_of_type_Uzf.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhu
 * JD-Core Version:    0.7.0.1
 */