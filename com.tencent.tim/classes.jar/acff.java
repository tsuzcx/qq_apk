import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager.2;
import com.tencent.mobileqq.app.FriendsManager.3;
import com.tencent.mobileqq.app.FriendsManager.5;
import com.tencent.mobileqq.app.FriendsManager.6;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import friendlist.SimpleOnlineFriendInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RecommendReason;

public class acff
  implements Manager
{
  private ConcurrentHashMap<String, Entity> E = new ConcurrentHashMap(16);
  private ConcurrentHashMap<String, Entity> F = new QQConcurrentHashMap(1011, 0, 400);
  private ConcurrentHashMap<String, Entity> G = new QQConcurrentHashMap(1012, 0, 400);
  private ConcurrentHashMap<String, ArrayList<Entity>> H = new ConcurrentHashMap(4);
  private ConcurrentHashMap<String, SpecialCareInfo> I = new ConcurrentHashMap();
  private SharedPreferences K;
  private AtomicBoolean U = new AtomicBoolean(false);
  private final aluf a = new aluf();
  private QQAppInterface app;
  public boolean bHA;
  public boolean bHB = true;
  private boolean bHC;
  private boolean bHw;
  public volatile boolean bHx;
  private boolean bHy;
  private boolean bHz;
  private MQLruCache<String, DateNickNameInfo> c = new MQLruCache(500);
  public int cvA = 6;
  public int cvB = -1;
  public int cvC;
  private int cvD;
  int cvE = 0;
  public int cvl = 3;
  public int cvm = 30;
  public int cvn = 7;
  public int cvo = 30;
  public int cvp = 3;
  public int cvq = 30;
  public int cvr = 3;
  public int cvs = 30;
  public int cvt = 3;
  public int cvu = 30;
  public int cvv = 5;
  public int cvw = 7;
  public int cvx = 30;
  public int cvy = 7;
  public int cvz = 30;
  private ConcurrentHashMap<String, Groups> dU;
  private ConcurrentHashMap<String, Integer> dV;
  private ConcurrentHashMap<String, String> dW;
  ConcurrentHashMap<String, String> dX = new ConcurrentHashMap(6);
  private AccountObserver e = new acfg(this);
  private EntityManager em;
  private volatile boolean fh;
  private final MQLruCache<String, Card> k = new MQLruCache(20);
  private ArrayList<Entity> tc;
  private ArrayList<String> td;
  private ArrayList<String> te;
  
  @Deprecated
  public acff() {}
  
  public acff(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager)
  {
    this.app = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.e);
    this.em = paramEntityManager;
    cIU();
  }
  
  private void DM(String paramString)
  {
    for (;;)
    {
      int m;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int n = this.cvC;
        localStringBuilder.append("checkAndLog, ").append(paramString);
        m = 0;
        int i = 0;
        int j = 0;
        if ((this.tc != null) && (m < this.tc.size()))
        {
          paramString = (Groups)this.tc.get(m);
          if (paramString != null)
          {
            if (QLog.isColorLevel()) {
              localStringBuilder.append(", [").append(paramString.group_id).append(",").append(paramString.group_friend_count).append("]");
            }
            j += paramString.group_friend_count;
            paramString = (ArrayList)this.H.get(String.valueOf(paramString.group_id));
            if (paramString != null) {
              i = paramString.size() + i;
            }
          }
        }
        else
        {
          localStringBuilder.append(", count1: ").append(j);
          localStringBuilder.append(", count2: ").append(i);
          localStringBuilder.append(", count3: ").append(n);
          if ((j != n) || (i != n))
          {
            paramString = this.app.getPreferences();
            i = paramString.getInt("friend_count_from_server", -1);
            j = paramString.getInt("friend_count_from_group", -1);
            localStringBuilder.append(", count4: ").append(i);
            localStringBuilder.append(", count5: ").append(j);
          }
          QLog.i("friend", 1, localStringBuilder.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        QLog.i("friend", 1, paramString.toString(), paramString);
        return;
      }
      m += 1;
    }
  }
  
  private void Ja(int paramInt)
  {
    int i = 0;
    try
    {
      SharedPreferences localSharedPreferences = this.app.getPreferences();
      localSharedPreferences.edit().putInt("friend_count_from_server", paramInt).apply();
      if (this.dU != null)
      {
        Iterator localIterator = this.dU.entrySet().iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          Groups localGroups = (Groups)((Map.Entry)localIterator.next()).getValue();
          if (localGroups != null) {
            i += localGroups.group_friend_count;
          }
        }
        localSharedPreferences.edit().putInt("friend_count_from_group", i).apply();
      }
      QLog.i("friend", 1, String.format("saveFrdCount [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.i("friend", 1, localThrowable.toString(), localThrowable);
    }
  }
  
  private ConcurrentHashMap<String, ArrayList<Entity>> a(boolean paramBoolean)
  {
    label563:
    label566:
    label569:
    label572:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject4;
      int i;
      Object localObject3;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildNormalAndGatheredUiMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject4 = new ConcurrentHashMap(4);
        int j = this.E.size();
        Iterator localIterator = this.E.entrySet().iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Friends localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
          if (localFriends.gathtertype != 1) {
            break label569;
          }
          i += 1;
          if (paramBoolean)
          {
            if (localFriends.gathtertype != 1) {}
          }
          else
          {
            if (localFriends.gathtertype == 0) {
              break label566;
            }
            if (localFriends.gathtertype == 2) {
              continue;
            }
          }
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
            acdb.d(localFriends);
          }
          String str = localFriends.groupid + "";
          localObject3 = (ArrayList)localConcurrentHashMap.get(str);
          Object localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = new ArrayList();
            localConcurrentHashMap.put(str, localObject1);
            if (this.tc == null) {
              break label563;
            }
            localObject3 = this.tc.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label563;
            }
            Groups localGroups = (Groups)((Iterator)localObject3).next();
            if (localGroups.group_id != localFriends.groupid) {
              continue;
            }
            ((ArrayList)localObject1).ensureCapacity(Math.min(j, localGroups.group_friend_count));
          }
          ((ArrayList)localObject1).add(localFriends);
          if (!paramBoolean) {
            break label572;
          }
          int m = aqgv.c(localFriends);
          if ((m == 0) || (m == 6)) {
            break label572;
          }
          localObject1 = (Integer)((ConcurrentHashMap)localObject4).get(str);
          if (localObject1 == null) {
            ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(1));
          } else {
            ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(((Integer)localObject1).intValue() + 1));
          }
        }
      }
      finally {}
      if (paramBoolean) {
        this.dV = ((ConcurrentHashMap)localObject4);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(300);
        localStringBuilder.append("buildNormalAndGatheredUiMaps end " + localConcurrentHashMap.size() + ": ");
        localObject3 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localStringBuilder.append((String)localObject4).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject4)).size()).append("; ");
        }
        localStringBuilder.append(" gatherCount=").append(i);
        QLog.d("Q.contacttab.friend", 2, localStringBuilder.toString());
      }
      this.cvD = i;
      return localConcurrentHashMap;
      continue;
      continue;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap(10);
    String str;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      str = "1";
      localHashMap.put("param_IsMainThread", str);
      localHashMap.put("param_OptType", paramString1);
      localHashMap.put("param_bustag", paramString2);
      if (!paramBoolean) {
        break label135;
      }
    }
    label135:
    for (paramString1 = "1";; paramString1 = "0")
    {
      localHashMap.put("param_intrans", paramString1);
      localHashMap.put("param_OptTotalCost", String.valueOf(paramLong));
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "actFriendSqliteOpt", true, paramLong, 0L, localHashMap, null, false);
      return;
      str = "0";
      break;
    }
  }
  
  private void a(Friends[] paramArrayOfFriends)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfFriends.length)
    {
      localArrayList.add(paramArrayOfFriends[i].uin);
      i += 1;
    }
    ujt.a(this.app, BaseApplication.getContext(), localArrayList);
  }
  
  private void cIU()
  {
    ThreadManager.executeOnSubThread(new FriendsManager.2(this));
  }
  
  private void cIX()
  {
    aean localaean = aean.a(this.app);
    boolean bool = localaean.agd();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, new Object[] { "doResetRingIdOfExtensionInfo: invoked. ", " hasResetGrayUserRingId: ", Boolean.valueOf(bool) });
    }
    if (!bool)
    {
      localaean.f(this.F);
      localaean.cVu();
    }
  }
  
  private void cIY()
  {
    ??? = (ArrayList)this.em.query(NoC2CExtensionInfo.class);
    if (??? != null)
    {
      Iterator localIterator = ((ArrayList)???).iterator();
      while (localIterator.hasNext())
      {
        NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)localIterator.next();
        if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.uin != null)) {
          synchronized (this.G)
          {
            String str = NoC2CExtensionInfo.getNoC2Ckey(localNoC2CExtensionInfo.type, localNoC2CExtensionInfo.uin);
            this.G.put(str, localNoC2CExtensionInfo);
          }
        }
      }
    }
  }
  
  private boolean isValidUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin empty uin");
      }
    }
    for (;;)
    {
      return false;
      if (paramString.length() >= 4) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin uin=" + paramString);
      }
    }
    return true;
  }
  
  private SharedPreferences r()
  {
    if (this.K == null) {
      this.K = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "add_friend_request_sp", 0);
    }
    return this.K;
  }
  
  public void A(@NonNull ArrayList<Friends> paramArrayList, int paramInt)
  {
    Object localObject2;
    Friends localFriends;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(paramArrayList.size() * 12 + 48);
      ((StringBuilder)localObject1).append("saveGatherList size=").append(paramArrayList.size()).append(" startIndex=").append(paramInt).append(" uin=");
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localFriends = (Friends)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(localFriends.uin + ",");
      }
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramArrayList.size() > 0) {
      this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit().putBoolean("everHasGatheredContacts", true).commit();
    }
    Object localObject1 = this.em.getTransaction();
    try
    {
      ((EntityTransaction)localObject1).begin();
      if (paramInt == 0)
      {
        localObject2 = this.E.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 1)
          {
            localFriends.gathtertype = 0;
            a(localFriends);
            if (this.td == null) {
              this.td = new ArrayList();
            }
            this.td.add(localFriends.uin);
          }
        }
      }
    }
    catch (Exception paramArrayList)
    {
      QLog.e("Q.contacttab.", 1, "saveGatherList", paramArrayList);
      return;
      this.cvD = 0;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = (Friends)this.E.get(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 1;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
          this.cvD += 1;
          if (this.te == null) {
            this.te = new ArrayList();
          }
          this.te.add(localFriends.uin);
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).end();
    }
    ((EntityTransaction)localObject1).end();
  }
  
  public int As()
  {
    Iterator localIterator = this.E.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((Friends)localIterator.next()).isFriend()) {
        break label51;
      }
      i += 1;
    }
    label51:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public int At()
  {
    return this.E.size() - this.cvD;
  }
  
  public int Au()
  {
    return this.cvD;
  }
  
  public int Av()
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll(this.E.values());
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = ((ArrayList)localObject1).iterator();
    int i;
    for (int j = 0; ((Iterator)localObject1).hasNext(); j = i)
    {
      Object localObject2 = (Friends)((Iterator)localObject1).next();
      i = j;
      if (((Friends)localObject2).isFriend())
      {
        localObject2 = a(((Friends)localObject2).uin);
        i = j;
        if (localObject2 != null) {
          if ((((ExtensionInfo)localObject2).intimate_type != 1) && (((ExtensionInfo)localObject2).intimate_type != 2))
          {
            i = j;
            if (((ExtensionInfo)localObject2).intimate_type != 3) {}
          }
          else
          {
            j += 1;
            i = j;
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("\nuin:").append(((ExtensionInfo)localObject2).uin).append(" type:").append(((ExtensionInfo)localObject2).intimate_type).append(" level:").append(((ExtensionInfo)localObject2).intimate_level);
              i = j;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("\ncount:").append(j);
      QLog.d("Q.contacttab.", 2, "getBindIntimateRelationshipFriendCount " + localStringBuilder.toString());
    }
    return j;
  }
  
  public ArrayList<Entity> B(String paramString)
  {
    return (ArrayList)this.H.get(paramString);
  }
  
  public void DN(String paramString)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getInt("hotDisableInteractive", 1) == 1) {
      this.bHA = true;
    }
    for (;;)
    {
      String[] arrayOfString = paramString.split("\\|");
      if (arrayOfString.length >= 9) {}
      try
      {
        this.cvl = Integer.valueOf(arrayOfString[0]).intValue();
        this.cvm = Integer.valueOf(arrayOfString[1]).intValue();
        this.cvp = Integer.valueOf(arrayOfString[2]).intValue();
        this.cvq = Integer.valueOf(arrayOfString[3]).intValue();
        this.cvr = Integer.valueOf(arrayOfString[4]).intValue();
        this.cvs = Integer.valueOf(arrayOfString[5]).intValue();
        this.cvt = Integer.valueOf(arrayOfString[6]).intValue();
        this.cvu = Integer.valueOf(arrayOfString[7]).intValue();
        this.cvv = Integer.valueOf(arrayOfString[8]).intValue();
        if (arrayOfString.length < 11) {}
      }
      catch (Exception localException3)
      {
        try
        {
          this.cvn = Integer.valueOf(arrayOfString[9]).intValue();
          this.cvo = Integer.valueOf(arrayOfString[10]).intValue();
          if (arrayOfString.length < 13) {}
        }
        catch (Exception localException3)
        {
          try
          {
            do
            {
              for (;;)
              {
                this.cvw = Integer.valueOf(arrayOfString[11]).intValue();
                this.cvx = Integer.valueOf(arrayOfString[12]).intValue();
                ajol.a(localSharedPreferences, this);
                return;
                this.bHA = false;
                break;
                localException2 = localException2;
                if (QLog.isColorLevel()) {
                  QLog.e("Q.contacttab.", 2, paramString, localException2);
                }
              }
              localException3 = localException3;
            } while (!QLog.isColorLevel());
            QLog.e("Q.contacttab.", 2, paramString, localException3);
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.contacttab.", 2, paramString, localException1);
              }
            }
          }
        }
      }
    }
  }
  
  public void DO(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() > 3)) {
      QLog.d("Q.contacttab.", 2, "add friend to black list " + paramString.substring(0, 2));
    }
    if (this.dW != null) {
      this.dW.put(paramString, "");
    }
    localObject2 = null;
    localObject1 = null;
    try
    {
      localEntityTransaction = this.em.getTransaction();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.begin();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      paramString = d(paramString);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      if (paramString.groupid >= 0)
      {
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        Groups localGroups = a(String.valueOf(paramString.groupid));
        if (localGroups != null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localGroups.group_friend_count -= 1;
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          a(localGroups);
        }
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      paramString.groupid = -1002;
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      this.E.remove(paramString.uin);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      a(paramString);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.commit();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        EntityTransaction localEntityTransaction;
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.e("Q.contacttab.group", 2, "addFriendToBlackList ex", paramString);
        }
        if (localObject1 != null) {
          localObject1.end();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label287;
      }
      localObject2.end();
    }
    cIV();
  }
  
  public void DP(String paramString)
  {
    if (this.dW != null) {
      this.dW.remove(paramString);
    }
    paramString = d(paramString);
    paramString.groupid = -1;
    a(paramString);
  }
  
  public void DQ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "deleteSpecialCareInfo: uin=" + paramString);
    }
    SpecialCareInfo localSpecialCareInfo = null;
    if (this.I != null) {}
    for (;;)
    {
      synchronized (this.I)
      {
        localSpecialCareInfo = (SpecialCareInfo)this.I.remove(paramString);
        if (localSpecialCareInfo != null) {
          break label147;
        }
        paramString = (SpecialCareInfo)this.em.find(SpecialCareInfo.class, paramString);
        if (paramString != null)
        {
          if (!anpc.lH(10)) {
            break label142;
          }
          l = SystemClock.uptimeMillis();
          this.em.remove(paramString);
          if (l != 0L) {
            a(SystemClock.uptimeMillis() - l, false, "delete", "SpecialCare");
          }
        }
        return;
      }
      label142:
      long l = 0L;
      continue;
      label147:
      paramString = localSpecialCareInfo;
    }
  }
  
  public void DR(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    acxw localacxw = this.app.a().a();
    RecentUser localRecentUser = localacxw.b(paramString, 0);
    if (localRecentUser == null)
    {
      localRecentUser = new RecentUser();
      localRecentUser.uin = paramString;
      localRecentUser.setType(0);
      localRecentUser.lastmsgtime = NetConnInfoCenter.getServerTime();
      paramString = localRecentUser;
    }
    for (;;)
    {
      paramString.lastmsgdrafttime = paramString.lastmsgtime;
      localacxw.e(paramString);
      paramString = this.app.getHandler(Conversation.class);
      if (paramString == null) {
        break;
      }
      paramString.sendEmptyMessage(1009);
      return;
      long l = NetConnInfoCenter.getServerTime();
      paramString = localRecentUser;
      if (localRecentUser.lastmsgtime < l)
      {
        localRecentUser.lastmsgtime = l;
        paramString = localRecentUser;
      }
    }
  }
  
  /* Error */
  public void Jb(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 809	java/lang/StringBuffer
    //   5: dup
    //   6: invokespecial 810	java/lang/StringBuffer:<init>	()V
    //   9: astore 6
    //   11: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +19 -> 33
    //   17: aload 6
    //   19: ldc_w 812
    //   22: invokevirtual 815	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   25: pop
    //   26: aload 6
    //   28: iload_1
    //   29: invokevirtual 818	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   32: pop
    //   33: aload_0
    //   34: iload_1
    //   35: invokevirtual 822	acff:p	(I)Ljava/util/ArrayList;
    //   38: astore 5
    //   40: aconst_null
    //   41: astore_3
    //   42: aload_0
    //   43: getfield 179	acff:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   46: invokevirtual 606	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   49: astore 4
    //   51: aload 4
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 611	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   58: aload 5
    //   60: invokevirtual 373	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   63: astore 4
    //   65: aload 4
    //   67: invokeinterface 313 1 0
    //   72: ifeq +115 -> 187
    //   75: aload 4
    //   77: invokeinterface 317 1 0
    //   82: checkcast 375	com/tencent/mobileqq/persistence/Entity
    //   85: checkcast 346	com/tencent/mobileqq/data/Friends
    //   88: astore 7
    //   90: aload 7
    //   92: iconst_0
    //   93: putfield 365	com/tencent/mobileqq/data/Friends:groupid	I
    //   96: aload_0
    //   97: aload 7
    //   99: invokevirtual 621	acff:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   102: pop
    //   103: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -41 -> 65
    //   109: aload 6
    //   111: ldc_w 824
    //   114: invokevirtual 815	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: aload 6
    //   120: aload 7
    //   122: getfield 483	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   125: iconst_0
    //   126: iconst_4
    //   127: invokevirtual 709	java/lang/String:substring	(II)Ljava/lang/String;
    //   130: invokevirtual 815	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   133: pop
    //   134: goto -69 -> 65
    //   137: astore 4
    //   139: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +32 -> 174
    //   145: ldc_w 728
    //   148: iconst_2
    //   149: new 188	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 826
    //   159: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload_1
    //   163: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: aload 4
    //   171: invokestatic 627	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   182: aload_0
    //   183: invokevirtual 726	acff:cIV	()V
    //   186: return
    //   187: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +15 -> 205
    //   193: ldc_w 728
    //   196: iconst_2
    //   197: aload 6
    //   199: invokevirtual 827	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   202: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_0
    //   206: iconst_0
    //   207: invokestatic 238	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   210: invokevirtual 717	acff:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   213: astore 4
    //   215: aload 4
    //   217: ifnull +26 -> 243
    //   220: aload 4
    //   222: aload 4
    //   224: getfield 230	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   227: aload 5
    //   229: invokevirtual 205	java/util/ArrayList:size	()I
    //   232: iadd
    //   233: putfield 230	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   236: aload_0
    //   237: aload 4
    //   239: invokevirtual 720	acff:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   242: pop
    //   243: aload_0
    //   244: new 188	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   251: iload_1
    //   252: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc_w 367
    //   258: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokevirtual 717	acff:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   267: astore 4
    //   269: aload_0
    //   270: getfield 298	acff:dU	Ljava/util/concurrent/ConcurrentHashMap;
    //   273: ifnull +31 -> 304
    //   276: aload_0
    //   277: getfield 298	acff:dU	Ljava/util/concurrent/ConcurrentHashMap;
    //   280: new 188	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   287: iload_1
    //   288: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc_w 367
    //   294: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokevirtual 723	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: pop
    //   304: aload_0
    //   305: getfield 199	acff:tc	Ljava/util/ArrayList;
    //   308: invokevirtual 830	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   311: checkcast 201	java/util/ArrayList
    //   314: astore 5
    //   316: iload_2
    //   317: aload 5
    //   319: invokevirtual 205	java/util/ArrayList:size	()I
    //   322: if_icmpge +26 -> 348
    //   325: iload_1
    //   326: aload 5
    //   328: iload_2
    //   329: invokevirtual 209	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   332: checkcast 211	com/tencent/mobileqq/data/Groups
    //   335: getfield 222	com/tencent/mobileqq/data/Groups:group_id	I
    //   338: if_icmpne +41 -> 379
    //   341: aload 5
    //   343: iload_2
    //   344: invokevirtual 832	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   347: pop
    //   348: aload_0
    //   349: aload 5
    //   351: putfield 199	acff:tc	Ljava/util/ArrayList;
    //   354: aload_0
    //   355: getfield 179	acff:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   358: aload 4
    //   360: invokevirtual 752	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   363: pop
    //   364: aload_3
    //   365: invokevirtual 646	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   368: aload_3
    //   369: ifnull -187 -> 182
    //   372: aload_3
    //   373: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   376: goto -194 -> 182
    //   379: iload_2
    //   380: iconst_1
    //   381: iadd
    //   382: istore_2
    //   383: goto -67 -> 316
    //   386: astore 4
    //   388: aconst_null
    //   389: astore_3
    //   390: aload_3
    //   391: ifnull +7 -> 398
    //   394: aload_3
    //   395: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   398: aload 4
    //   400: athrow
    //   401: astore 4
    //   403: goto -13 -> 390
    //   406: astore 4
    //   408: goto -18 -> 390
    //   411: astore 4
    //   413: goto -274 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	acff
    //   0	416	1	paramInt	int
    //   1	382	2	i	int
    //   41	354	3	localObject1	Object
    //   49	27	4	localObject2	Object
    //   137	33	4	localException1	Exception
    //   213	146	4	localGroups	Groups
    //   386	13	4	localObject3	Object
    //   401	1	4	localObject4	Object
    //   406	1	4	localObject5	Object
    //   411	1	4	localException2	Exception
    //   38	312	5	localArrayList	ArrayList
    //   9	189	6	localStringBuffer	java.lang.StringBuffer
    //   88	33	7	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   54	65	137	java/lang/Exception
    //   65	134	137	java/lang/Exception
    //   187	205	137	java/lang/Exception
    //   205	215	137	java/lang/Exception
    //   220	243	137	java/lang/Exception
    //   243	304	137	java/lang/Exception
    //   304	316	137	java/lang/Exception
    //   316	348	137	java/lang/Exception
    //   348	368	137	java/lang/Exception
    //   42	51	386	finally
    //   54	65	401	finally
    //   65	134	401	finally
    //   187	205	401	finally
    //   205	215	401	finally
    //   220	243	401	finally
    //   243	304	401	finally
    //   304	316	401	finally
    //   316	348	401	finally
    //   348	368	401	finally
    //   139	174	406	finally
    //   42	51	411	java/lang/Exception
  }
  
  public void Jc(int paramInt)
  {
    this.cvE = paramInt;
  }
  
  public aluf a()
  {
    if (!this.a.mIsInit) {
      ThreadManager.excute(new FriendsManager.6(this), 16, null, true);
    }
    return this.a;
  }
  
  public Card a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.k)
      {
        paramString = (Card)this.k.get(paramString);
        return paramString;
      }
    }
    return null;
  }
  
  public Card a(String paramString, boolean paramBoolean)
  {
    long l;
    if (anpc.lH(7))
    {
      l = SystemClock.uptimeMillis();
      aiih.dsz();
    }
    for (;;)
    {
      ??? = null;
      if (!TextUtils.isEmpty(paramString)) {}
      synchronized (this.k)
      {
        ??? = (Card)this.k.get(paramString);
        ??? = ???;
        if (??? == null)
        {
          ??? = (Card)this.em.find(Card.class, paramString);
          if ((??? == null) || (TextUtils.isEmpty(paramString))) {}
        }
        synchronized (this.k)
        {
          this.k.put(paramString, ???);
          ??? = ???;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.contacttab.", 2, String.format(Locale.getDefault(), "findFriendCardByUin find from DB uin=%s card=%s", new Object[] { paramString, ??? }));
            ??? = ???;
          }
          if (l != 0L) {
            a(SystemClock.uptimeMillis() - l, false, "query", "Card");
          }
          ??? = ???;
          if (??? == null)
          {
            ??? = ???;
            if (paramBoolean)
            {
              ??? = new Card();
              ((Card)???).uin = paramString;
              ((Card)???).shGender = -1;
              if (anpc.lH(8)) {
                l = SystemClock.uptimeMillis();
              }
              if (TextUtils.isEmpty(paramString)) {}
            }
          }
        }
      }
      synchronized (this.k)
      {
        this.k.put(paramString, ???);
        this.em.persist((Entity)???);
        if (l != 0L) {
          a(SystemClock.uptimeMillis() - l, false, "insert", "Card");
        }
        ??? = ???;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, String.format(Locale.getDefault(), "findFriendCardByUin new uin=%s card=%s", new Object[] { paramString, ??? }));
          ??? = ???;
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder(200);
          ((StringBuilder)???).append("findFriendCardByUin  uin=").append(paramString).append(", card=").append(???);
          if (??? != null) {
            ((StringBuilder)???).append(", medalSwitchDisable=").append(((Card)???).medalSwitchDisable).append(", bSuperVipOpen=").append(((Card)???).bSuperVipOpen).append(", bQQVipOpen =").append(((Card)???).bQQVipOpen).append(", showOnlineFriends=").append(((Card)???).showOnlineFriends);
          }
          QLog.d("Q.contacttab.", 2, ((StringBuilder)???).toString());
        }
        return ???;
        paramString = finally;
        throw paramString;
        paramString = finally;
        throw paramString;
      }
      l = 0L;
    }
  }
  
  public ContactCard a(String paramString)
  {
    return (ContactCard)this.em.find(ContactCard.class, paramString);
  }
  
  public DateNickNameInfo a(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    if (!this.bHC) {
      ThreadManager.postImmediately(new FriendsManager.5(this), null, false);
    }
    return (DateNickNameInfo)this.c.get(paramString);
  }
  
  public ExtensionInfo a(String paramString)
  {
    return a(paramString, true);
  }
  
  public ExtensionInfo a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      ??? = null;
      return ???;
    }
    ExtensionInfo localExtensionInfo;
    if (this.F != null) {
      synchronized (this.F)
      {
        localExtensionInfo = (ExtensionInfo)this.F.get(paramString);
      }
    }
    do
    {
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
      ??? = localExtensionInfo;
      if (this.fh) {
        break;
      }
      localExtensionInfo = (ExtensionInfo)this.em.find(ExtensionInfo.class, paramString);
      ??? = localExtensionInfo;
      if (localExtensionInfo == null) {
        break;
      }
      synchronized (this.F)
      {
        this.F.put(paramString, localExtensionInfo);
        return localExtensionInfo;
      }
      localExtensionInfo = null;
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
    } while (paramBoolean);
    return null;
  }
  
  public Friends a(String paramString)
  {
    if (!isValidUin(paramString)) {
      return null;
    }
    return (Friends)this.E.get(paramString);
  }
  
  public Friends a(String paramString1, String paramString2)
  {
    paramString1 = d(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.name = paramString2;
      paramString1.datetime = System.currentTimeMillis();
      if (!this.E.containsKey(paramString1.uin)) {
        this.E.put(paramString1.uin, paramString1);
      }
      acdb.d(paramString1);
    }
    return paramString1;
  }
  
  public Groups a(String paramString)
  {
    Object localObject;
    if (this.dU == null) {
      localObject = null;
    }
    Groups localGroups;
    do
    {
      do
      {
        return localObject;
        localGroups = (Groups)this.dU.get(paramString);
        localObject = localGroups;
      } while (localGroups != null);
      localGroups = (Groups)this.em.find(Groups.class, paramString);
      localObject = localGroups;
    } while (localGroups == null);
    this.dU.put(paramString, localGroups);
    this.tc = acdb.a(this.tc, localGroups);
    return localGroups;
  }
  
  public KplCard a(String paramString)
  {
    long l;
    if (anpc.lH(7))
    {
      l = SystemClock.uptimeMillis();
      aiih.dsz();
    }
    for (;;)
    {
      paramString = (KplCard)this.em.find(KplCard.class, paramString);
      if (l != 0L) {
        a(SystemClock.uptimeMillis() - l, false, "query", "Card");
      }
      if (paramString != null) {
        paramString.transStringToList();
      }
      if ((QLog.isColorLevel()) && (paramString != null)) {
        QLog.d("Q.contacttab.", 2, "findFriendCardByUin qqNick=" + paramString.qqNick + ",gameNick=" + paramString.gameNick + ",uin = " + paramString.uin);
      }
      return paramString;
      l = 0L;
    }
  }
  
  public NoC2CExtensionInfo a(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = NoC2CExtensionInfo.getNoC2Ckey(paramInt, paramString);
    NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)this.G.get(str);
    ??? = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      ??? = localNoC2CExtensionInfo;
      if (paramBoolean)
      {
        ??? = localNoC2CExtensionInfo;
        if (!this.fh)
        {
          paramString = (NoC2CExtensionInfo)this.em.find(NoC2CExtensionInfo.class, "type=? and uin=?", new String[] { String.valueOf(paramInt), paramString });
          ??? = paramString;
          if (paramString != null) {
            synchronized (this.G)
            {
              this.G.put(str, paramString);
              return paramString;
            }
          }
        }
      }
    }
    return ???;
  }
  
  public SpecialCareInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    ??? = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.U.get()) {
        break label28;
      }
      ??? = localObject1;
    }
    for (;;)
    {
      return ???;
      label28:
      localObject1 = localObject3;
      if (this.I != null) {}
      synchronized (this.I)
      {
        localObject1 = (SpecialCareInfo)this.I.get(paramString);
        ??? = localObject1;
        if (localObject1 == null) {
          continue;
        }
        return (SpecialCareInfo)((SpecialCareInfo)localObject1).clone();
      }
    }
  }
  
  public EntityTransaction a()
  {
    return this.em.getTransaction();
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (TextUtils.isEmpty(paramExtensionInfo.uin))) {}
    do
    {
      return;
      a(paramExtensionInfo);
    } while (this.F == null);
    synchronized (this.F)
    {
      this.F.put(paramExtensionInfo.uin, paramExtensionInfo);
      return;
    }
  }
  
  public void a(Groups paramGroups)
  {
    int m = 0;
    if (this.dU == null) {
      this.dU = new ConcurrentHashMap();
    }
    int i;
    if (paramGroups.getStatus() == 1000)
    {
      this.em.persist(paramGroups);
      this.dU.put(paramGroups.group_id + "", paramGroups);
      i = 0;
    }
    for (;;)
    {
      int j = m;
      if (i < this.tc.size())
      {
        Groups localGroups = (Groups)this.tc.get(i);
        if (localGroups.group_id == paramGroups.group_id)
        {
          localGroups.datetime = paramGroups.datetime;
          localGroups.group_friend_count = paramGroups.group_friend_count;
          localGroups.group_id = paramGroups.group_id;
          localGroups.group_name = paramGroups.group_name;
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          this.tc = acdb.a(this.tc, paramGroups);
        }
        cIV();
        return;
        this.em.update(paramGroups);
        break;
      }
      i += 1;
    }
  }
  
  /* Error */
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +34 -> 37
    //   6: aload_1
    //   7: getfield 1002	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   10: invokestatic 556	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +24 -> 37
    //   16: aload_1
    //   17: getfield 1005	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   20: invokestatic 556	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +14 -> 37
    //   26: aload_1
    //   27: getfield 1008	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   30: lstore_2
    //   31: lload_2
    //   32: lconst_0
    //   33: lcmp
    //   34: ifgt +6 -> 40
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: new 930	com/tencent/mobileqq/data/DateNickNameInfo
    //   43: dup
    //   44: aload_1
    //   45: getfield 1005	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   48: aload_1
    //   49: getfield 1008	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   52: invokespecial 1011	com/tencent/mobileqq/data/DateNickNameInfo:<init>	(Ljava/lang/String;J)V
    //   55: astore 4
    //   57: aload_0
    //   58: getfield 109	acff:c	Landroid/support/v4/util/MQLruCache;
    //   61: aload_1
    //   62: getfield 1002	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   65: aload 4
    //   67: invokevirtual 855	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: goto -34 -> 37
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	acff
    //   0	79	1	paramNearbyPeopleCard	NearbyPeopleCard
    //   30	2	2	l	long
    //   55	11	4	localDateNickNameInfo	DateNickNameInfo
    // Exception table:
    //   from	to	target	type
    //   6	31	74	finally
    //   40	71	74	finally
  }
  
  public void a(NoC2CExtensionInfo paramNoC2CExtensionInfo, boolean paramBoolean)
  {
    if ((paramNoC2CExtensionInfo == null) || (paramNoC2CExtensionInfo.uin == null)) {}
    for (;;)
    {
      return;
      if (this.G == null) {
        continue;
      }
      synchronized (this.G)
      {
        String str = NoC2CExtensionInfo.getNoC2Ckey(paramNoC2CExtensionInfo.type, paramNoC2CExtensionInfo.uin);
        this.G.put(str, paramNoC2CExtensionInfo);
        if (!paramBoolean) {
          continue;
        }
        a(paramNoC2CExtensionInfo);
        return;
      }
    }
  }
  
  public void a(SpecialCareInfo paramSpecialCareInfo)
  {
    if ((paramSpecialCareInfo == null) || (paramSpecialCareInfo.uin == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo, specailCareInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo: " + paramSpecialCareInfo.toString());
    }
    if (this.I != null) {}
    synchronized (this.I)
    {
      this.I.put(paramSpecialCareInfo.uin, paramSpecialCareInfo);
      a(paramSpecialCareInfo);
      return;
    }
  }
  
  public void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    Friends localFriends;
    if (paramGetOnlineInfoResp != null)
    {
      localFriends = (Friends)this.E.get(paramString);
      if (localFriends != null) {
        break label21;
      }
    }
    label21:
    do
    {
      for (;;)
      {
        return;
        localFriends.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
        localFriends.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
        localFriends.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
        localFriends.eNetwork = paramGetOnlineInfoResp.eNetworkType;
        localFriends.netTypeIconId = paramGetOnlineInfoResp.eIconType;
        localFriends.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
        localFriends.uExtOnlineStatus = paramGetOnlineInfoResp.uExtOnlineStatus;
        localFriends.iBatteryStatus = paramGetOnlineInfoResp.iBatteryStatus;
        akum.b(localFriends, paramGetOnlineInfoResp.vecMusicInfo, "AIO");
        aktp.a(localFriends, paramGetOnlineInfoResp.vecPoiInfo, "AIO");
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, new Object[] { "updateOnlineStatus uin:", paramString, " extOnline:", Long.valueOf(paramGetOnlineInfoResp.uExtOnlineStatus), " battery:", Integer.valueOf(paramGetOnlineInfoResp.iBatteryStatus) });
        }
        CustomOnlineStatusPb.CustomOnlineStatusMsg localCustomOnlineStatusMsg = new CustomOnlineStatusPb.CustomOnlineStatusMsg();
        try
        {
          aqqb.a().Vs(paramString);
          localCustomOnlineStatusMsg.mergeFrom(paramGetOnlineInfoResp.strCustomOnlineStatusDesc.getBytes());
          localFriends.customOnlineStatusType = aqqb.b.b(localCustomOnlineStatusMsg);
          localFriends.customOnlineStatus = aqqb.b.a(localCustomOnlineStatusMsg);
          localFriends.customModel = aqqb.b.b(localCustomOnlineStatusMsg);
          if (QLog.isDevelopLevel())
          {
            QLog.d("CustomOnlineStatusManager", 4, "updateOnlineStatus : customOnlineStatusType = " + localFriends.customOnlineStatusType + " customOnlineStatus = " + localFriends.customOnlineStatus);
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("CustomOnlineStatusManager", 2, paramString, new Object[0]);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte1, short paramShort, byte paramByte2)
  {
    byte b = 1;
    if ((jqs.cU(paramByte1)) && (!asgx.mS(paramByte1))) {
      return;
    }
    paramString1 = d(paramString1);
    paramString1.cSpecialFlag = paramByte1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.", 2, "saveFriendInfoByUin uin=" + paramString1.uin + ", cSpecialFlag=" + paramString1.cSpecialFlag);
    }
    paramString1.name = paramString2;
    if (paramShort == 0) {
      paramByte1 = b;
    }
    for (;;)
    {
      paramString1.gender = paramByte1;
      paramString1.age = paramByte2;
      paramString1.datetime = System.currentTimeMillis();
      if (!this.E.containsKey(paramString1.uin)) {
        this.E.put(paramString1.uin, paramString1);
      }
      acdb.d(paramString1);
      a(paramString1);
      return;
      if (paramShort == 1) {
        paramByte1 = 2;
      } else {
        paramByte1 = 0;
      }
    }
  }
  
  public void a(List<SpecialCareInfo> paramList, long paramLong, boolean paramBoolean)
  {
    int m = 0;
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "syncSpecialCareInfos: " + i + ", " + paramLong + ", " + paramBoolean);
      }
      int j;
      if (this.I != null)
      {
        localObject = this.I;
        j = 0;
        for (;;)
        {
          if (j < i) {}
          Iterator localIterator;
          try
          {
            this.I.put(((SpecialCareInfo)paramList.get(j)).uin, paramList.get(j));
            j += 1;
          }
          finally {}
        }
        if (paramBoolean)
        {
          localIterator = this.I.entrySet().iterator();
          while (localIterator.hasNext()) {
            if (((SpecialCareInfo)((Map.Entry)localIterator.next()).getValue()).dateTime < paramLong) {
              localIterator.remove();
            }
          }
        }
      }
      Object localObject = this.em.getTransaction();
      try
      {
        ((EntityTransaction)localObject).begin();
        j = m;
        while (j < i)
        {
          a((Entity)paramList.get(j));
          j += 1;
        }
        if (paramBoolean)
        {
          paramList = ((SpecialCareInfo)SpecialCareInfo.class.newInstance()).getTableName();
          i = this.em.delete(paramList, "dateTime<" + paramLong, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.", 2, "syncSpecialCareInfos delete from table " + paramList + " ret = " + i);
          }
        }
        ((EntityTransaction)localObject).commit();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)localObject).end();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    this.bHy = paramBoolean1;
    this.bHz = paramBoolean2;
    this.cvl = paramInt1;
    this.cvm = paramInt2;
    this.cvp = paramInt3;
    this.cvq = paramInt4;
    this.cvr = paramInt5;
    this.cvs = paramInt6;
    this.cvt = paramInt7;
    this.cvu = paramInt8;
    this.cvv = paramInt11;
    this.cvw = paramInt9;
    this.cvx = paramInt10;
  }
  
  public void a(Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean)
  {
    int j;
    EntityTransaction localEntityTransaction;
    long l;
    label120:
    int i;
    if (paramArrayOfFriends != null)
    {
      j = paramArrayOfFriends.length;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveFriendsList: " + j + ", " + paramLong + ", " + paramBoolean);
      }
      localEntityTransaction = this.em.getTransaction();
      l = 0L;
      for (;;)
      {
        try
        {
          if (anpc.lH(11)) {
            l = SystemClock.uptimeMillis();
          }
          localEntityTransaction.begin();
          if (l == 0L) {
            break label365;
          }
          a(SystemClock.uptimeMillis() - l, false, "trans", "Friends");
        }
        catch (Exception localException)
        {
          Iterator localIterator;
          localException.printStackTrace();
          localEntityTransaction.end();
          continue;
        }
        finally
        {
          localEntityTransaction.end();
        }
        if (i < j)
        {
          this.E.put(paramArrayOfFriends[i].uin, paramArrayOfFriends[i]);
          a(paramArrayOfFriends[i]);
          i += 1;
        }
        else if (paramBoolean)
        {
          i = 0;
          localIterator = this.E.entrySet().iterator();
        }
      }
    }
    label362:
    label365:
    label377:
    for (;;)
    {
      Friends localFriends;
      if (localIterator.hasNext())
      {
        localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
        if (!localFriends.isFriend()) {
          break label362;
        }
        i += 1;
      }
      for (;;)
      {
        if ((localFriends.datetime < paramLong) && (localFriends.isFriend()))
        {
          localIterator.remove();
          l = 0L;
          if (anpc.lH(10)) {
            l = SystemClock.uptimeMillis();
          }
          this.em.remove(localFriends);
          if (l != 0L)
          {
            a(SystemClock.uptimeMillis() - l, true, "delete", "Friends");
            break label377;
            Ja(i);
            localEntityTransaction.commit();
            localEntityTransaction.end();
            if (j > 0) {
              a(paramArrayOfFriends);
            }
            cIV();
            return;
            continue;
            i = 0;
            break label120;
            j = -1;
            break;
          }
        }
      }
    }
  }
  
  /* Error */
  public void a(Groups[] paramArrayOfGroups)
  {
    // Byte code:
    //   0: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: new 188	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 1214
    //   16: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore_3
    //   20: aload_1
    //   21: ifnull +31 -> 52
    //   24: aload_1
    //   25: arraylength
    //   26: istore_2
    //   27: ldc_w 414
    //   30: iconst_2
    //   31: aload_3
    //   32: iload_2
    //   33: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: ifnull +8 -> 51
    //   46: aload_1
    //   47: arraylength
    //   48: ifne +9 -> 57
    //   51: return
    //   52: iconst_m1
    //   53: istore_2
    //   54: goto -27 -> 27
    //   57: new 201	java/util/ArrayList
    //   60: dup
    //   61: aload_1
    //   62: arraylength
    //   63: invokespecial 1215	java/util/ArrayList:<init>	(I)V
    //   66: astore 4
    //   68: new 81	java/util/concurrent/ConcurrentHashMap
    //   71: dup
    //   72: aload_1
    //   73: arraylength
    //   74: invokespecial 84	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   77: astore 5
    //   79: aload_0
    //   80: getfield 179	acff:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   83: invokevirtual 606	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   86: astore_3
    //   87: aload_3
    //   88: invokevirtual 611	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   91: iconst_0
    //   92: istore_2
    //   93: iload_2
    //   94: aload_1
    //   95: arraylength
    //   96: if_icmpge +61 -> 157
    //   99: aload 5
    //   101: new 188	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: iload_2
    //   110: aaload
    //   111: getfield 222	com/tencent/mobileqq/data/Groups:group_id	I
    //   114: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 367
    //   120: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aload_1
    //   127: iload_2
    //   128: aaload
    //   129: invokevirtual 372	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload 4
    //   135: aload_1
    //   136: iload_2
    //   137: aaload
    //   138: invokevirtual 388	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   141: pop
    //   142: aload_0
    //   143: aload_1
    //   144: iload_2
    //   145: aaload
    //   146: invokevirtual 720	acff:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   149: pop
    //   150: iload_2
    //   151: iconst_1
    //   152: iadd
    //   153: istore_2
    //   154: goto -61 -> 93
    //   157: aload_1
    //   158: arraylength
    //   159: iconst_1
    //   160: if_icmple +11 -> 171
    //   163: aload 4
    //   165: getstatic 1218	acdb:K	Ljava/util/Comparator;
    //   168: invokestatic 1224	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   171: aload_0
    //   172: getfield 298	acff:dU	Ljava/util/concurrent/ConcurrentHashMap;
    //   175: ifnull +114 -> 289
    //   178: aload_0
    //   179: getfield 298	acff:dU	Ljava/util/concurrent/ConcurrentHashMap;
    //   182: invokevirtual 302	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   185: invokeinterface 308 1 0
    //   190: astore_1
    //   191: aload_1
    //   192: invokeinterface 313 1 0
    //   197: ifeq +92 -> 289
    //   200: aload_1
    //   201: invokeinterface 317 1 0
    //   206: checkcast 319	java/util/Map$Entry
    //   209: astore 6
    //   211: aload 5
    //   213: aload 6
    //   215: invokeinterface 1227 1 0
    //   220: checkcast 234	java/lang/String
    //   223: invokevirtual 954	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   226: ifne -35 -> 191
    //   229: aload_0
    //   230: getfield 179	acff:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   233: aload 6
    //   235: invokeinterface 322 1 0
    //   240: checkcast 375	com/tencent/mobileqq/persistence/Entity
    //   243: invokevirtual 752	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   246: pop
    //   247: goto -56 -> 191
    //   250: astore_1
    //   251: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +14 -> 268
    //   257: ldc_w 728
    //   260: iconst_2
    //   261: ldc_w 1229
    //   264: aload_1
    //   265: invokestatic 627	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: aload_3
    //   269: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   272: aload_0
    //   273: aload 4
    //   275: putfield 199	acff:tc	Ljava/util/ArrayList;
    //   278: aload_0
    //   279: aload 5
    //   281: putfield 298	acff:dU	Ljava/util/concurrent/ConcurrentHashMap;
    //   284: aload_0
    //   285: invokevirtual 726	acff:cIV	()V
    //   288: return
    //   289: aload_3
    //   290: invokevirtual 646	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   293: aload_3
    //   294: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   297: goto -25 -> 272
    //   300: astore_1
    //   301: aload_3
    //   302: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   305: aload_1
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	acff
    //   0	307	1	paramArrayOfGroups	Groups[]
    //   26	128	2	i	int
    //   19	283	3	localObject	Object
    //   66	208	4	localArrayList	ArrayList
    //   77	203	5	localConcurrentHashMap	ConcurrentHashMap
    //   209	25	6	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   87	91	250	java/lang/Exception
    //   93	150	250	java/lang/Exception
    //   157	171	250	java/lang/Exception
    //   171	191	250	java/lang/Exception
    //   191	247	250	java/lang/Exception
    //   289	293	250	java/lang/Exception
    //   87	91	300	finally
    //   93	150	300	finally
    //   157	171	300	finally
    //   171	191	300	finally
    //   191	247	300	finally
    //   251	268	300	finally
    //   289	293	300	finally
  }
  
  public boolean a(Card paramCard)
  {
    if (paramCard == null) {
      return false;
    }
    if (QLog.isDevelopLevel()) {}
    for (;;)
    {
      synchronized (this.k)
      {
        Card localCard = (Card)this.k.get(paramCard.uin);
        if (localCard != paramCard) {
          QLog.i("Q.contacttab.", 4, String.format(Locale.getDefault(), "saveCard uin=%s cacheOne=%s card=%s", new Object[] { paramCard.uin, localCard, paramCard }));
        }
        if (anpc.lH(9))
        {
          l = SystemClock.uptimeMillis();
          boolean bool = a(paramCard);
          if (l != 0L) {
            a(SystemClock.uptimeMillis() - l, false, "update", "Card");
          }
          return bool;
        }
      }
      long l = 0L;
    }
  }
  
  public boolean a(ContactCard paramContactCard)
  {
    return a(paramContactCard);
  }
  
  public boolean a(Friends paramFriends)
  {
    boolean bool = false;
    if (this.em.isOpen()) {
      if (paramFriends.getStatus() == 1000)
      {
        this.em.persist(paramFriends);
        if (paramFriends.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return bool;
      } while ((paramFriends.getStatus() != 1001) && (paramFriends.getStatus() != 1002));
      return this.em.update(paramFriends);
    }
    QLog.d("Q.contacttab.friend", 2, "updateFriendEntity em closed f=" + paramFriends.uin);
    return false;
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.em.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.em.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.em.update(paramEntity);
      }
    }
    QLog.d("Q.contacttab.friend", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(Friends[] paramArrayOfFriends, int paramInt)
  {
    if ((paramArrayOfFriends == null) || (paramArrayOfFriends.length == 0)) {
      return true;
    }
    EntityTransaction localEntityTransaction = this.em.getTransaction();
    try
    {
      localEntityTransaction.begin();
      int i = 0;
      while (i < paramInt)
      {
        acdb.d(paramArrayOfFriends[i]);
        a(paramArrayOfFriends[i]);
        i += 1;
      }
      localEntityTransaction.commit();
      return true;
    }
    catch (Exception paramArrayOfFriends)
    {
      paramArrayOfFriends.printStackTrace();
      return true;
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
  
  public boolean aL(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = this.bHA;
    if (this.cvB == -1)
    {
      if (!paramBoolean) {
        break label98;
      }
      ((CardHandler)this.app.getBusinessHandler(2)).cHC();
      paramBoolean = bool1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "getEnableReactive disableReactive" + paramBoolean + "IsDisableInteractive=" + this.cvB);
      }
      return paramBoolean;
      paramBoolean = bool2;
      if (this.cvB != 1)
      {
        paramBoolean = false;
        continue;
        label98:
        paramBoolean = bool1;
      }
    }
  }
  
  public boolean aac()
  {
    boolean bool = aad();
    init();
    this.bHy = aqmj.d(this.app.getApp(), this.app.getCurrentAccountUin(), 0);
    this.bHz = aqmj.d(this.app.getApp(), this.app.getCurrentAccountUin(), 1);
    DN(aqmj.bs(this.app.getApp()));
    DM("buildFriends");
    return bool;
  }
  
  public boolean aad()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache begin");
    }
    localObject2 = (ArrayList)this.em.query(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
    int i;
    ConcurrentHashMap localConcurrentHashMap;
    StringBuilder localStringBuilder;
    ArrayList localArrayList;
    label114:
    Friends localFriends;
    if (localObject2 != null)
    {
      i = ((ArrayList)localObject2).size();
      localConcurrentHashMap = new ConcurrentHashMap(i);
      this.cvE = 0;
      this.cvC = 0;
      localStringBuilder = new StringBuilder();
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        break label366;
      }
      localArrayList = new ArrayList();
      i = 0;
      if (i >= ((ArrayList)localObject2).size()) {
        break label297;
      }
      localFriends = (Friends)((ArrayList)localObject2).get(i);
      asgx.a(this.app, localFriends);
      if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
      {
        acdb.d(localFriends);
        localArrayList.add(localFriends);
      }
      localConcurrentHashMap.put(localFriends.uin, localFriends);
      if (localFriends.isFriend()) {
        this.cvC += 1;
      }
      if (localFriends.gathtertype == 1) {
        localStringBuilder.append(localFriends.uin + ";");
      }
      if (localFriends.gathtertype != 2) {
        break label275;
      }
      this.cvE += 1;
    }
    for (;;)
    {
      i += 1;
      break label114;
      i = 0;
      break;
      label275:
      if (localFriends.gathtertype == 1) {
        this.cvD += 1;
      }
    }
    label297:
    if (localArrayList.size() > 0)
    {
      localObject2 = this.em.getTransaction();
      ((EntityTransaction)localObject2).begin();
      i = 0;
    }
    try
    {
      while (i < localArrayList.size())
      {
        a((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label366:
        ((EntityTransaction)localObject2).end();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).end();
    }
    localArrayList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache end: " + localConcurrentHashMap.size());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "mRecomCount: " + this.cvE + " ; mGatheredCount = " + this.cvD + " ; initFriendCache gathered : " + localStringBuilder);
    }
    this.E.putAll(localConcurrentHashMap);
    this.bHw = true;
    if (localConcurrentHashMap.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean aae()
  {
    return (this.tc != null) && ((this.E.size() > 0) || (this.tc.size() > 0));
  }
  
  public boolean aaf()
  {
    return this.fh;
  }
  
  public boolean aag()
  {
    return this.U.get();
  }
  
  public boolean aah()
  {
    return this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getBoolean("show_vip_red_name", true);
  }
  
  public Card b(String paramString)
  {
    return a(paramString, false);
  }
  
  public ContactCard b(String paramString)
  {
    ContactCard localContactCard2 = (ContactCard)this.em.find(ContactCard.class, paramString);
    ContactCard localContactCard1 = localContactCard2;
    if (localContactCard2 == null)
    {
      localContactCard1 = new ContactCard();
      localContactCard1.mobileNo = paramString;
      this.em.persist(localContactCard1);
    }
    return localContactCard1;
  }
  
  public Friends b(String paramString)
  {
    if (!isValidUin(paramString)) {
      localObject = null;
    }
    Friends localFriends;
    do
    {
      do
      {
        do
        {
          return localObject;
          localFriends = (Friends)this.E.get(paramString);
          localObject = localFriends;
        } while (localFriends != null);
        localObject = localFriends;
      } while (this.bHw);
      localFriends = (Friends)this.em.find(Friends.class, paramString);
      if (localFriends != null) {
        this.E.put(localFriends.uin, localFriends);
      }
      localObject = localFriends;
    } while (!QLog.isColorLevel());
    Object localObject = "findFriendEntifyFromCache from db uin = " + paramString + ",f=";
    if (localFriends == null) {}
    for (paramString = "null";; paramString = aqmr.getSimpleUinForPrint(localFriends.uin))
    {
      QLog.d("Q.contacttab.", 2, new Object[] { localObject, paramString });
      return localFriends;
    }
  }
  
  public Friends b(String paramString1, String paramString2)
  {
    Friends localFriends = d(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (!paramString1.equals(localFriends.remark))
    {
      localFriends.remark = paramString1;
      localFriends.datetime = System.currentTimeMillis();
      this.E.put(localFriends.uin, localFriends);
      acdb.d(localFriends);
      a(localFriends);
      cIV();
    }
    return localFriends;
  }
  
  public boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      l2 = r().getLong(paramString, 0L);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (paramString.startsWith("+")) {
          l1 = r().getLong(paramString.replace("+", ""), 0L);
        }
      }
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (paramString.startsWith("+86")) {
          l2 = r().getLong(paramString.replace("+86", ""), 0L);
        }
      }
    } while (l2 == 0L);
    long l2 = System.currentTimeMillis() - l2;
    if (paramBoolean1) {}
    for (long l1 = 259200000L;; l1 = 500654080L)
    {
      if (paramBoolean2) {
        l1 = 86400000L;
      }
      if ((l2 <= 0L) || (l2 >= l1)) {
        break;
      }
      return true;
    }
    r().edit().remove(paramString).commit();
    return false;
  }
  
  public void bF(String paramString, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      r().edit().putLong(paramString, System.currentTimeMillis()).commit();
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        ((FriendListHandler)this.app.getBusinessHandler(1)).notifyUI(105, paramBoolean, paramString);
      }
      return;
      if (r().contains(paramString))
      {
        r().edit().remove(paramString).commit();
        i = 1;
      }
    }
  }
  
  public Card c(String paramString)
  {
    return a(paramString, true);
  }
  
  public Friends c(String paramString)
  {
    if (!isValidUin(paramString)) {
      return null;
    }
    return (Friends)this.E.get(paramString);
  }
  
  /* Error */
  public void c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnull +278 -> 282
    //   7: aload_2
    //   8: ifnull +274 -> 282
    //   11: aconst_null
    //   12: astore 6
    //   14: aload_0
    //   15: getfield 179	acff:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 606	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 7
    //   23: aload 7
    //   25: astore 6
    //   27: aload 6
    //   29: invokevirtual 611	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   32: new 809	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 810	java/lang/StringBuffer:<init>	()V
    //   39: astore 7
    //   41: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +12 -> 56
    //   47: aload 7
    //   49: ldc_w 1390
    //   52: invokevirtual 815	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   55: pop
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: istore 4
    //   61: iload 5
    //   63: aload_1
    //   64: arraylength
    //   65: if_icmpge +218 -> 283
    //   68: iload_3
    //   69: istore 4
    //   71: aload_0
    //   72: aload_1
    //   73: iload 5
    //   75: baload
    //   76: invokestatic 238	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 717	acff:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   82: astore 8
    //   84: iload_3
    //   85: istore 4
    //   87: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +70 -> 160
    //   93: iload_3
    //   94: istore 4
    //   96: aload 7
    //   98: ldc_w 1392
    //   101: invokevirtual 815	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   104: pop
    //   105: iload_3
    //   106: istore 4
    //   108: aload 7
    //   110: aload_1
    //   111: iload 5
    //   113: baload
    //   114: invokevirtual 818	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: iload_3
    //   119: istore 4
    //   121: aload 7
    //   123: ldc_w 1394
    //   126: invokevirtual 815	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: iload_3
    //   131: istore 4
    //   133: aload 7
    //   135: aload_2
    //   136: iload 5
    //   138: baload
    //   139: invokevirtual 818	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload 8
    //   145: ifnonnull +15 -> 160
    //   148: iload_3
    //   149: istore 4
    //   151: aload 7
    //   153: ldc_w 1396
    //   156: invokevirtual 815	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: iload_3
    //   161: istore 4
    //   163: aload 8
    //   165: ifnull +222 -> 387
    //   168: iload_3
    //   169: istore 4
    //   171: aload 8
    //   173: getfield 1399	com/tencent/mobileqq/data/Groups:seqid	B
    //   176: aload_2
    //   177: iload 5
    //   179: baload
    //   180: if_icmpne +9 -> 189
    //   183: iload_3
    //   184: istore 4
    //   186: goto +201 -> 387
    //   189: iload_3
    //   190: istore 4
    //   192: aload 8
    //   194: aload_2
    //   195: iload 5
    //   197: baload
    //   198: putfield 1399	com/tencent/mobileqq/data/Groups:seqid	B
    //   201: iconst_1
    //   202: istore_3
    //   203: iconst_1
    //   204: istore 4
    //   206: aload_0
    //   207: aload 8
    //   209: invokevirtual 720	acff:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   212: pop
    //   213: iload_3
    //   214: istore 4
    //   216: goto +171 -> 387
    //   219: astore_2
    //   220: aload 6
    //   222: astore_1
    //   223: iload 4
    //   225: istore_3
    //   226: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +33 -> 262
    //   232: ldc_w 728
    //   235: iconst_2
    //   236: new 188	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1401
    //   246: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_2
    //   250: invokevirtual 1404	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_1
    //   263: ifnull +118 -> 381
    //   266: aload_1
    //   267: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   270: iload_3
    //   271: istore 4
    //   273: iload 4
    //   275: ifeq +7 -> 282
    //   278: aload_0
    //   279: invokevirtual 1407	acff:cJb	()V
    //   282: return
    //   283: iload_3
    //   284: istore 4
    //   286: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +18 -> 307
    //   292: iload_3
    //   293: istore 4
    //   295: ldc_w 728
    //   298: iconst_2
    //   299: aload 7
    //   301: invokevirtual 827	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   304: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: iload_3
    //   308: istore 4
    //   310: aload 6
    //   312: invokevirtual 646	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   315: iload_3
    //   316: istore 4
    //   318: aload 6
    //   320: ifnull -47 -> 273
    //   323: aload 6
    //   325: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   328: iload_3
    //   329: istore 4
    //   331: goto -58 -> 273
    //   334: astore_1
    //   335: aconst_null
    //   336: astore 6
    //   338: aload 6
    //   340: ifnull +8 -> 348
    //   343: aload 6
    //   345: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   348: aload_1
    //   349: athrow
    //   350: astore_1
    //   351: goto -13 -> 338
    //   354: astore_2
    //   355: aload_1
    //   356: astore 6
    //   358: aload_2
    //   359: astore_1
    //   360: goto -22 -> 338
    //   363: astore_2
    //   364: iconst_0
    //   365: istore_3
    //   366: aload 6
    //   368: astore_1
    //   369: goto -143 -> 226
    //   372: astore_2
    //   373: aload 6
    //   375: astore_1
    //   376: iconst_0
    //   377: istore_3
    //   378: goto -152 -> 226
    //   381: iload_3
    //   382: istore 4
    //   384: goto -111 -> 273
    //   387: iload 5
    //   389: iconst_1
    //   390: iadd
    //   391: istore 5
    //   393: iload 4
    //   395: istore_3
    //   396: goto -338 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	acff
    //   0	399	1	paramArrayOfByte1	byte[]
    //   0	399	2	paramArrayOfByte2	byte[]
    //   57	339	3	i	int
    //   59	335	4	j	int
    //   1	391	5	m	int
    //   12	362	6	localObject1	Object
    //   21	279	7	localObject2	Object
    //   82	126	8	localGroups	Groups
    // Exception table:
    //   from	to	target	type
    //   61	68	219	java/lang/Exception
    //   71	84	219	java/lang/Exception
    //   87	93	219	java/lang/Exception
    //   96	105	219	java/lang/Exception
    //   108	118	219	java/lang/Exception
    //   121	130	219	java/lang/Exception
    //   133	143	219	java/lang/Exception
    //   151	160	219	java/lang/Exception
    //   171	183	219	java/lang/Exception
    //   192	201	219	java/lang/Exception
    //   206	213	219	java/lang/Exception
    //   286	292	219	java/lang/Exception
    //   295	307	219	java/lang/Exception
    //   310	315	219	java/lang/Exception
    //   14	23	334	finally
    //   27	56	350	finally
    //   61	68	350	finally
    //   71	84	350	finally
    //   87	93	350	finally
    //   96	105	350	finally
    //   108	118	350	finally
    //   121	130	350	finally
    //   133	143	350	finally
    //   151	160	350	finally
    //   171	183	350	finally
    //   192	201	350	finally
    //   206	213	350	finally
    //   286	292	350	finally
    //   295	307	350	finally
    //   310	315	350	finally
    //   226	262	354	finally
    //   14	23	363	java/lang/Exception
    //   27	56	372	java/lang/Exception
  }
  
  public void cIV()
  {
    label544:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject5;
      Object localObject4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildUIMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject5 = new ConcurrentHashMap(4);
        int i = this.E.size();
        Iterator localIterator = this.E.values().iterator();
        if (!localIterator.hasNext()) {
          break label326;
        }
        Friends localFriends = (Friends)localIterator.next();
        if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
          acdb.d(localFriends);
        }
        String str = localFriends.groupid + "";
        localObject4 = (ArrayList)localConcurrentHashMap.get(str);
        Object localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new ArrayList();
          localConcurrentHashMap.put(str, localObject1);
          if (this.tc == null) {
            break label544;
          }
          localObject4 = this.tc.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label544;
          }
          Groups localGroups = (Groups)((Iterator)localObject4).next();
          if (localGroups.group_id != localFriends.groupid) {
            continue;
          }
          ((ArrayList)localObject1).ensureCapacity(Math.min(i, localGroups.group_friend_count));
        }
        ((ArrayList)localObject1).add(localFriends);
        int j = aqgv.aU(localFriends.detalStatusFlag, localFriends.iTermType);
        if ((j == 0) || (j == 6)) {
          continue;
        }
        localObject1 = (Integer)((ConcurrentHashMap)localObject5).get(str);
        if (localObject1 == null)
        {
          ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(1));
          continue;
        }
        ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(localObject2.intValue() + 1));
      }
      finally {}
      continue;
      label326:
      Object localObject3;
      if (this.tc != null)
      {
        localObject3 = this.tc.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ArrayList)localConcurrentHashMap.get(String.valueOf(((Groups)((Iterator)localObject3).next()).group_id));
          if (localObject4 != null) {
            Collections.sort((List)localObject4, acdb.K);
          }
        }
      }
      this.dV = ((ConcurrentHashMap)localObject5);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder(300);
        ((StringBuilder)localObject3).append("buildUIMaps end " + localConcurrentHashMap.size() + ": ");
        localObject4 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject5).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject5)).size()).append("; ");
        }
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject3).toString());
      }
      this.H = localConcurrentHashMap;
      return;
    }
  }
  
  public void cIW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache begin");
    }
    Object localObject5;
    Object localObject3;
    if (!this.fh)
    {
      if (this.fh) {
        return;
      }
      if (this.E.size() >= 100) {
        break label398;
      }
      localObject5 = this.E.entrySet().iterator();
      ??? = new StringBuilder(this.E.size() * 20);
      localObject3 = new ArrayList(this.E.size());
      while (((Iterator)localObject5).hasNext())
      {
        Friends localFriends = (Friends)((Map.Entry)((Iterator)localObject5).next()).getValue();
        if (localFriends.isFriend())
        {
          ((StringBuilder)???).append("uin=? or ");
          ((List)localObject3).add(localFriends.uin);
        }
      }
      if (((StringBuilder)???).length() <= 4) {
        break label395;
      }
      ??? = ((StringBuilder)???).delete(((StringBuilder)???).length() - 4, ((StringBuilder)???).length());
    }
    label171:
    label346:
    Object localObject2;
    label395:
    label398:
    for (??? = this.em.query(ExtensionInfo.class, true, ((StringBuilder)???).toString(), (String[])((List)localObject3).toArray(new String[((List)localObject3).size()]), null, null, null, null);; localObject2 = null)
    {
      for (;;)
      {
        localObject3 = ???;
        if (??? == null) {}
        try
        {
          localObject3 = (ArrayList)this.em.query(ExtensionInfo.class);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (ExtensionInfo)((Iterator)localObject3).next();
              if ((localObject5 != null) && (((ExtensionInfo)localObject5).uin != null) && (isFriend(((ExtensionInfo)localObject5).uin))) {
                synchronized (this.F)
                {
                  this.F.put(((ExtensionInfo)localObject5).uin, localObject5);
                }
              }
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            ArrayList localArrayList = new ArrayList(0);
            QLog.e("Q.contacttab.", 1, "initExtensionInfoCache error oom", localOutOfMemoryError);
          }
          cIY();
        }
        try
        {
          cIX();
          this.fh = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache end: " + this.F.size());
          return;
        }
        catch (Throwable localThrowable)
        {
          break label346;
        }
      }
      break label171;
    }
  }
  
  protected void cIZ()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList begin");
    }
    this.tc = ((ArrayList)this.em.query(Groups.class, false, "group_id>=?", new String[] { "0" }, null, null, "seqid asc", null));
    Object localObject;
    if (this.tc != null)
    {
      localObject = new ConcurrentHashMap(this.tc.size());
      i = 0;
      while (i < this.tc.size())
      {
        Groups localGroups = (Groups)this.tc.get(i);
        ((ConcurrentHashMap)localObject).put(localGroups.group_id + "", localGroups);
        i += 1;
      }
      this.dU = ((ConcurrentHashMap)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("initGroupList end: ");
      if (this.dU != null) {
        break label190;
      }
    }
    label190:
    for (int i = j;; i = this.dU.size())
    {
      QLog.d("Q.contacttab.friend", 2, i);
      return;
    }
  }
  
  public void cJa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache begin");
    }
    if (!this.U.get())
    {
      Object localObject1 = (ArrayList)this.em.query(SpecialCareInfo.class, false, "globalSwitch!=?", new String[] { "0" }, null, null, null, null);
      if (localObject1 != null) {
        synchronized (this.I)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)((Iterator)localObject1).next();
            if ((localSpecialCareInfo != null) && (localSpecialCareInfo.uin != null)) {
              this.I.put(localSpecialCareInfo.uin, localSpecialCareInfo);
            }
          }
        }
      }
      this.U.set(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache end: " + this.I.size());
    }
  }
  
  void cJb()
  {
    cIZ();
    cIV();
  }
  
  public void cJc()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.bHC;
        if (bool) {
          return;
        }
        long l = System.currentTimeMillis();
        try
        {
          ArrayList localArrayList = (ArrayList)this.em.query(NearbyPeopleCard.class, false, "lastUpdateNickTime>?", new String[] { "0" }, null, null, "_id desc", String.valueOf(100));
          if (!QLog.isColorLevel()) {
            break label217;
          }
          if (localArrayList == null)
          {
            i = 0;
            QLog.d("Q.contacttab.", 2, "nearby people card count = " + i);
            break label217;
            if (i >= localArrayList.size()) {
              continue;
            }
            NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localArrayList.get(i);
            if (localNearbyPeopleCard == null) {
              break label227;
            }
            a(localNearbyPeopleCard);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.em.drop(NearbyPeopleCard.class.getSimpleName());
          Object localObject1 = null;
          continue;
          i = localObject1.size();
          continue;
          this.bHC = true;
        }
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("Q.contacttab.", 4, "initDateNickNameCache cost time:" + (System.currentTimeMillis() - l));
        continue;
        if (localObject2 == null) {
          continue;
        }
      }
      finally {}
      label217:
      int i = 0;
      continue;
      label227:
      i += 1;
    }
  }
  
  public void cJd()
  {
    Iterator localIterator;
    String str;
    if (this.te != null)
    {
      localIterator = this.te.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((this.td != null) && (this.td.contains(str))) {
          this.td.remove(str);
        } else {
          yil.v(this.app, str);
        }
      }
    }
    if (this.td != null)
    {
      localIterator = this.td.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        yil.x(this.app, str);
      }
    }
    this.td = null;
    this.te = null;
  }
  
  public ArrayList<Friends> cn()
  {
    if (!this.bHw) {
      aad();
    }
    if (!this.E.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(10);
      Iterator localIterator = this.E.values().iterator();
      while (localIterator.hasNext())
      {
        Friends localFriends = (Friends)localIterator.next();
        if (localFriends.isShield()) {
          localArrayList.add(localFriends);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public int co(String paramString)
  {
    paramString = b(paramString);
    if ((paramString == null) || (!paramString.isFriend())) {
      return 0;
    }
    return paramString.friendType;
  }
  
  @UiThread
  public ArrayList<Entity> co()
  {
    if (this.tc == null) {
      ThreadManager.postImmediately(new FriendsManager.3(this), null, false);
    }
    return this.tc;
  }
  
  public int cp(String paramString)
  {
    paramString = e(paramString);
    if (paramString != null) {
      return paramString.detalStatusFlag;
    }
    return 10;
  }
  
  public ArrayList<Entity> cp()
  {
    if (this.tc == null)
    {
      init();
      DM("buildGroupList");
    }
    return this.tc;
  }
  
  public ArrayList<Entity> cq()
  {
    ArrayList localArrayList = new ArrayList(16);
    if (this.tc != null)
    {
      Iterator localIterator = this.tc.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Groups)localIterator.next();
        localObject = (List)this.H.get(String.valueOf(((Groups)localObject).group_id));
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<Entity> cr()
  {
    if (this.tc == null) {
      cIZ();
    }
    return this.tc;
  }
  
  public ArrayList<Entity> cs()
  {
    new ConcurrentHashMap(4);
    ConcurrentHashMap localConcurrentHashMap = a(true);
    ArrayList localArrayList = new ArrayList(16);
    if (this.tc != null)
    {
      Iterator localIterator = this.tc.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localConcurrentHashMap.get(String.valueOf(((Groups)localIterator.next()).group_id));
        if (localList != null) {
          localArrayList.addAll(localList);
        }
      }
    }
    return localArrayList;
  }
  
  public Friends d(String paramString)
  {
    Friends localFriends2 = e(paramString);
    Friends localFriends1 = localFriends2;
    if (localFriends2 == null)
    {
      localFriends1 = new Friends();
      localFriends1.uin = paramString;
      this.E.put(paramString, localFriends1);
      e(localFriends1);
    }
    return localFriends1;
  }
  
  public void dC(ArrayList<SimpleOnlineFriendInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      Object localObject1 = new StringBuilder(100);
      ((StringBuilder)localObject1).append("updateOnlineStatus size:").append(paramArrayList.size()).append("\n");
      HashMap localHashMap = new HashMap(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      Object localObject2;
      while (paramArrayList.hasNext())
      {
        localObject2 = (SimpleOnlineFriendInfo)paramArrayList.next();
        String str = String.valueOf(((SimpleOnlineFriendInfo)localObject2).friendUin);
        Friends localFriends = (Friends)this.E.get(str);
        if (localFriends != null)
        {
          localFriends.detalStatusFlag = ((SimpleOnlineFriendInfo)localObject2).detalStatusFlag;
          localFriends.iTermType = ((SimpleOnlineFriendInfo)localObject2).iTermType;
          localFriends.abilityBits = ((SimpleOnlineFriendInfo)localObject2).uAbiFlag;
          localFriends.eNetwork = ((SimpleOnlineFriendInfo)localObject2).eNetworkType;
          localFriends.netTypeIconId = ((SimpleOnlineFriendInfo)localObject2).eIconType;
          localFriends.strTermDesc = ((SimpleOnlineFriendInfo)localObject2).strTermDesc;
          localFriends.iBatteryStatus = ((SimpleOnlineFriendInfo)localObject2).iBatteryStatus;
          localFriends.uExtOnlineStatus = ((SimpleOnlineFriendInfo)localObject2).uExtOnlineStatus;
          ((StringBuilder)localObject1).append("uin:").append(str).append(" battery:").append(((SimpleOnlineFriendInfo)localObject2).iBatteryStatus).append(" extOnline:").append(((SimpleOnlineFriendInfo)localObject2).uExtOnlineStatus).append("\n");
          akum.b(localFriends, ((SimpleOnlineFriendInfo)localObject2).vecMusicInfo, "SimpleOnlie");
          aktp.a(localFriends, ((SimpleOnlineFriendInfo)localObject2).vecPoiInfo, "SimpleOnlie");
          localHashMap.put(str, Boolean.TRUE);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject1).toString());
      }
      paramArrayList = this.E.keySet().iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (Friends)this.E.get(localObject1);
        if (((Boolean)localHashMap.get(localObject1) == null) && (((Friends)localObject2).isFriend()))
        {
          ((Friends)localObject2).detalStatusFlag = 20;
          ((Friends)localObject2).abilityBits = 0L;
          ((Friends)localObject2).eNetwork = 0;
        }
      }
    }
  }
  
  public List<SpecialCareInfo> dU()
  {
    if ((!this.U.get()) || (this.I == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "getSpecailCareInfos isSpecialCareInfoCacheInited is false or specailCareInfoCache is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.I)
    {
      Iterator localIterator = this.I.values().iterator();
      while (localIterator.hasNext())
      {
        SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)localIterator.next();
        if (localSpecialCareInfo.globalSwitch != 0) {
          localArrayList.add((SpecialCareInfo)localSpecialCareInfo.clone());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getSpecailCareInfos: size=" + localList.size());
    }
    return localList;
  }
  
  public List<SpecialCareInfo> dV()
  {
    List localList = dU();
    if (localList != null) {
      Collections.sort(localList, new acfh(this));
    }
    return localList;
  }
  
  public void dw(String paramString, int paramInt)
  {
    Friends localFriends = e(paramString);
    int i;
    Groups localGroups1;
    Groups localGroups2;
    if (localFriends != null)
    {
      i = localFriends.groupid;
      localGroups1 = a(String.valueOf(i));
      if ((i >= 0) && (localGroups1 != null)) {
        localGroups1.group_friend_count -= 1;
      }
      localGroups2 = a(String.valueOf(paramInt));
      if (localGroups2 != null) {
        localGroups2.group_friend_count += 1;
      }
      localFriends.groupid = paramInt;
      localObject = null;
      paramString = null;
    }
    try
    {
      EntityTransaction localEntityTransaction = this.em.getTransaction();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.begin();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      a(localFriends);
      if ((i >= 0) && (localGroups1 != null))
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups1);
      }
      if (localGroups2 != null)
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups2);
      }
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.commit();
      if (localEntityTransaction != null) {
        localEntityTransaction.end();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          localObject = paramString;
          QLog.e("Q.contacttab.group", 2, "setFriendGroup ex=", localException);
        }
        if (paramString != null) {
          paramString.end();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label239;
      }
      ((EntityTransaction)localObject).end();
    }
    cIV();
  }
  
  public String dx(int paramInt)
  {
    return (String)this.dX.get(String.valueOf(paramInt));
  }
  
  public Friends e(String paramString)
  {
    Object localObject2;
    if (!isValidUin(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = b(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = (Friends)this.em.find(Friends.class, paramString);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, "findFriendEntityByUin from db isFriendCacheInited=" + this.bHw + " f=" + localObject2 + " uin=" + paramString);
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    this.E.put(paramString, localObject1);
    return localObject1;
  }
  
  public void e(Friends paramFriends)
  {
    if (paramFriends != null)
    {
      acdb.d(paramFriends);
      this.E.put(paramFriends.uin, paramFriends);
      a(paramFriends);
    }
  }
  
  public void e(String paramString1, String paramString2, byte paramByte)
  {
    NearbyPeopleCard localNearbyPeopleCard2 = (NearbyPeopleCard)this.em.find(NearbyPeopleCard.class, "uin=?", new String[] { paramString1 });
    NearbyPeopleCard localNearbyPeopleCard1 = localNearbyPeopleCard2;
    if (localNearbyPeopleCard2 == null)
    {
      localNearbyPeopleCard1 = new NearbyPeopleCard();
      localNearbyPeopleCard1.uin = paramString1;
    }
    localNearbyPeopleCard1.lastUpdateNickTime = System.currentTimeMillis();
    localNearbyPeopleCard1.nickname = paramString2;
    if (paramByte != -1) {
      localNearbyPeopleCard1.gender = paramByte;
    }
    a(localNearbyPeopleCard1);
    a(localNearbyPeopleCard1);
  }
  
  /* Error */
  public boolean e(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +50 -> 56
    //   9: ldc_w 728
    //   12: iconst_2
    //   13: new 188	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 1590
    //   23: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 408
    //   33: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload_2
    //   37: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc_w 408
    //   43: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_3
    //   47: invokevirtual 898	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 179	acff:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   60: invokevirtual 606	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   63: astore 11
    //   65: aload 11
    //   67: astore 12
    //   69: aload 11
    //   71: invokevirtual 611	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   74: aload 11
    //   76: astore 12
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 714	acff:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   83: astore 10
    //   85: aload 11
    //   87: astore 12
    //   89: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +48 -> 140
    //   95: aload 11
    //   97: astore 12
    //   99: ldc_w 590
    //   102: iconst_2
    //   103: new 188	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 1592
    //   113: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 1594
    //   123: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 10
    //   128: getfield 350	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   131: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload 11
    //   142: astore 12
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 1597	acff:kb	(Ljava/lang/String;)Z
    //   149: ifeq +12 -> 161
    //   152: aload 11
    //   154: astore 12
    //   156: aload_0
    //   157: aload_1
    //   158: invokevirtual 1599	acff:DP	(Ljava/lang/String;)V
    //   161: aload 11
    //   163: astore 12
    //   165: aload 10
    //   167: getfield 365	com/tencent/mobileqq/data/Friends:groupid	I
    //   170: iconst_m1
    //   171: if_icmpne +336 -> 507
    //   174: aload 11
    //   176: astore 12
    //   178: aload 10
    //   180: iload_2
    //   181: putfield 365	com/tencent/mobileqq/data/Friends:groupid	I
    //   184: iconst_m1
    //   185: istore 6
    //   187: iconst_1
    //   188: istore 8
    //   190: aload 11
    //   192: astore 12
    //   194: aload 10
    //   196: invokestatic 948	java/lang/System:currentTimeMillis	()J
    //   199: putfield 951	com/tencent/mobileqq/data/Friends:datetime	J
    //   202: iload_3
    //   203: ifeq +476 -> 679
    //   206: aload 11
    //   208: astore 12
    //   210: aload 10
    //   212: getfield 350	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   215: istore 5
    //   217: iload 5
    //   219: iconst_1
    //   220: if_icmpeq +314 -> 534
    //   223: iconst_1
    //   224: istore 5
    //   226: aload 11
    //   228: astore 12
    //   230: aload 10
    //   232: iconst_1
    //   233: putfield 350	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   236: aload 11
    //   238: astore 12
    //   240: aload 10
    //   242: ldc_w 1600
    //   245: invokestatic 1605	acfp:m	(I)Ljava/lang/String;
    //   248: putfield 642	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   251: aload 11
    //   253: astore 12
    //   255: aload_0
    //   256: aload_0
    //   257: getfield 416	acff:cvD	I
    //   260: iconst_1
    //   261: iadd
    //   262: putfield 416	acff:cvD	I
    //   265: aload 11
    //   267: astore 12
    //   269: aload_0
    //   270: aload 10
    //   272: getfield 483	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   275: invokevirtual 1607	acff:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   278: astore 13
    //   280: aload 13
    //   282: ifnull +43 -> 325
    //   285: aload 11
    //   287: astore 12
    //   289: aload 13
    //   291: getfield 875	com/tencent/mobileqq/data/Card:shGender	S
    //   294: ifne +246 -> 540
    //   297: iconst_1
    //   298: istore 4
    //   300: aload 11
    //   302: astore 12
    //   304: aload 10
    //   306: iload 4
    //   308: putfield 639	com/tencent/mobileqq/data/Friends:gender	B
    //   311: aload 11
    //   313: astore 12
    //   315: aload 10
    //   317: aload 13
    //   319: getfield 1609	com/tencent/mobileqq/data/Card:age	B
    //   322: putfield 633	com/tencent/mobileqq/data/Friends:age	I
    //   325: aload 11
    //   327: astore 12
    //   329: aload_0
    //   330: aload 10
    //   332: invokevirtual 720	acff:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   335: pop
    //   336: aload 11
    //   338: astore 12
    //   340: aload_0
    //   341: iload_2
    //   342: invokestatic 238	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   345: invokevirtual 717	acff:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   348: astore 10
    //   350: aload 10
    //   352: ifnull +33 -> 385
    //   355: aload 11
    //   357: astore 12
    //   359: aload 10
    //   361: aload 10
    //   363: getfield 230	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   366: iconst_1
    //   367: iadd
    //   368: putfield 230	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   371: aload 11
    //   373: astore 12
    //   375: aload_0
    //   376: getfield 179	acff:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   379: aload 10
    //   381: invokevirtual 998	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   384: pop
    //   385: iload 8
    //   387: ifne +61 -> 448
    //   390: iload 6
    //   392: iflt +56 -> 448
    //   395: iload 6
    //   397: iload_2
    //   398: if_icmpeq +50 -> 448
    //   401: aload 11
    //   403: astore 12
    //   405: aload_0
    //   406: iload 6
    //   408: invokestatic 238	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   411: invokevirtual 717	acff:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   414: astore 10
    //   416: aload 10
    //   418: ifnull +30 -> 448
    //   421: aload 11
    //   423: astore 12
    //   425: aload 10
    //   427: aload 10
    //   429: getfield 230	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   432: iconst_1
    //   433: isub
    //   434: putfield 230	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   437: aload 11
    //   439: astore 12
    //   441: aload_0
    //   442: aload 10
    //   444: invokevirtual 720	acff:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   447: pop
    //   448: aload 11
    //   450: astore 12
    //   452: aload 11
    //   454: invokevirtual 646	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   457: iload 5
    //   459: istore 6
    //   461: iload 8
    //   463: istore 9
    //   465: aload 11
    //   467: ifnull +16 -> 483
    //   470: aload 11
    //   472: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   475: iload 8
    //   477: istore 9
    //   479: iload 5
    //   481: istore 6
    //   483: aload_0
    //   484: invokevirtual 726	acff:cIV	()V
    //   487: iload_3
    //   488: ifeq +16 -> 504
    //   491: iload 6
    //   493: ifeq +11 -> 504
    //   496: aload_0
    //   497: getfield 171	acff:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   500: aload_1
    //   501: invokestatic 1491	yil:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   504: iload 9
    //   506: ireturn
    //   507: aload 11
    //   509: astore 12
    //   511: aload 10
    //   513: getfield 365	com/tencent/mobileqq/data/Friends:groupid	I
    //   516: istore 6
    //   518: aload 11
    //   520: astore 12
    //   522: aload 10
    //   524: iload_2
    //   525: putfield 365	com/tencent/mobileqq/data/Friends:groupid	I
    //   528: iconst_0
    //   529: istore 8
    //   531: goto -341 -> 190
    //   534: iconst_0
    //   535: istore 5
    //   537: goto -311 -> 226
    //   540: aload 11
    //   542: astore 12
    //   544: aload 13
    //   546: getfield 875	com/tencent/mobileqq/data/Card:shGender	S
    //   549: istore 7
    //   551: iload 7
    //   553: iconst_1
    //   554: if_icmpne -254 -> 300
    //   557: iconst_2
    //   558: istore 4
    //   560: goto -260 -> 300
    //   563: astore 10
    //   565: aconst_null
    //   566: astore 11
    //   568: iconst_0
    //   569: istore 8
    //   571: iconst_0
    //   572: istore_2
    //   573: aload 11
    //   575: astore 12
    //   577: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq +19 -> 599
    //   583: aload 11
    //   585: astore 12
    //   587: ldc_w 728
    //   590: iconst_2
    //   591: ldc_w 1611
    //   594: aload 10
    //   596: invokestatic 627	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   599: iload_2
    //   600: istore 6
    //   602: iload 8
    //   604: istore 9
    //   606: aload 11
    //   608: ifnull -125 -> 483
    //   611: aload 11
    //   613: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   616: iload_2
    //   617: istore 6
    //   619: iload 8
    //   621: istore 9
    //   623: goto -140 -> 483
    //   626: astore_1
    //   627: aconst_null
    //   628: astore 12
    //   630: aload 12
    //   632: ifnull +8 -> 640
    //   635: aload 12
    //   637: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   640: aload_1
    //   641: athrow
    //   642: astore_1
    //   643: goto -13 -> 630
    //   646: astore 10
    //   648: iconst_0
    //   649: istore 8
    //   651: iconst_0
    //   652: istore_2
    //   653: goto -80 -> 573
    //   656: astore 10
    //   658: iconst_0
    //   659: istore_2
    //   660: goto -87 -> 573
    //   663: astore 10
    //   665: iload 5
    //   667: istore_2
    //   668: goto -95 -> 573
    //   671: astore 10
    //   673: iload 5
    //   675: istore_2
    //   676: goto -103 -> 573
    //   679: iconst_0
    //   680: istore 5
    //   682: goto -357 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	acff
    //   0	685	1	paramString	String
    //   0	685	2	paramInt	int
    //   0	685	3	paramBoolean	boolean
    //   1	558	4	b	byte
    //   215	466	5	i	int
    //   185	433	6	j	int
    //   549	6	7	m	int
    //   188	462	8	bool1	boolean
    //   463	159	9	bool2	boolean
    //   83	440	10	localObject	Object
    //   563	32	10	localException1	Exception
    //   646	1	10	localException2	Exception
    //   656	1	10	localException3	Exception
    //   663	1	10	localException4	Exception
    //   671	1	10	localException5	Exception
    //   63	549	11	localEntityTransaction1	EntityTransaction
    //   67	569	12	localEntityTransaction2	EntityTransaction
    //   278	267	13	localCard	Card
    // Exception table:
    //   from	to	target	type
    //   56	65	563	java/lang/Exception
    //   56	65	626	finally
    //   69	74	642	finally
    //   78	85	642	finally
    //   89	95	642	finally
    //   99	140	642	finally
    //   144	152	642	finally
    //   156	161	642	finally
    //   165	174	642	finally
    //   178	184	642	finally
    //   194	202	642	finally
    //   210	217	642	finally
    //   230	236	642	finally
    //   240	251	642	finally
    //   255	265	642	finally
    //   269	280	642	finally
    //   289	297	642	finally
    //   304	311	642	finally
    //   315	325	642	finally
    //   329	336	642	finally
    //   340	350	642	finally
    //   359	371	642	finally
    //   375	385	642	finally
    //   405	416	642	finally
    //   425	437	642	finally
    //   441	448	642	finally
    //   452	457	642	finally
    //   511	518	642	finally
    //   522	528	642	finally
    //   544	551	642	finally
    //   577	583	642	finally
    //   587	599	642	finally
    //   69	74	646	java/lang/Exception
    //   78	85	646	java/lang/Exception
    //   89	95	646	java/lang/Exception
    //   99	140	646	java/lang/Exception
    //   144	152	646	java/lang/Exception
    //   156	161	646	java/lang/Exception
    //   165	174	646	java/lang/Exception
    //   178	184	646	java/lang/Exception
    //   511	518	646	java/lang/Exception
    //   522	528	646	java/lang/Exception
    //   194	202	656	java/lang/Exception
    //   210	217	656	java/lang/Exception
    //   230	236	663	java/lang/Exception
    //   240	251	663	java/lang/Exception
    //   255	265	663	java/lang/Exception
    //   269	280	663	java/lang/Exception
    //   289	297	663	java/lang/Exception
    //   304	311	663	java/lang/Exception
    //   315	325	663	java/lang/Exception
    //   544	551	663	java/lang/Exception
    //   329	336	671	java/lang/Exception
    //   340	350	671	java/lang/Exception
    //   359	371	671	java/lang/Exception
    //   375	385	671	java/lang/Exception
    //   405	416	671	java/lang/Exception
    //   425	437	671	java/lang/Exception
    //   441	448	671	java/lang/Exception
    //   452	457	671	java/lang/Exception
  }
  
  public void eJ(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {
      return;
    }
    Friends localFriends = d(paramString1);
    localFriends.alias = paramString2;
    localFriends.datetime = System.currentTimeMillis();
    if (paramString1.equals(this.app.getAccount())) {
      this.app.getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString1, paramString2);
    }
    a(localFriends);
  }
  
  public void eK(String paramString1, String paramString2)
  {
    paramString1 = d(paramString1);
    paramString1.name = paramString2;
    paramString1.datetime = System.currentTimeMillis();
    if (!this.E.containsKey(paramString1.uin)) {
      this.E.put(paramString1.uin, paramString1);
    }
    acdb.d(paramString1);
    a(paramString1);
  }
  
  public void f(Friends paramFriends)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "updateSingleFriend: " + paramFriends.uin);
    }
    this.E.put(paramFriends.uin, paramFriends);
    e(paramFriends);
    cIV();
  }
  
  public void f(String paramString, byte paramByte)
  {
    paramString = a(paramString, true);
    if (paramString != null)
    {
      paramString.bSingle = paramByte;
      a(paramString);
    }
  }
  
  public void hu(long paramLong)
  {
    if (!Friends.isValidUin(paramLong)) {}
    Friends localFriends;
    int i;
    do
    {
      do
      {
        return;
        localFriends = (Friends)this.E.get(String.valueOf(paramLong));
      } while (localFriends == null);
      i = aqgv.aU(localFriends.detalStatusFlag, localFriends.iTermType);
    } while ((i != 0) && (i != 6));
    localFriends.detalStatusFlag = 10;
  }
  
  public void iG(List<String> paramList)
  {
    auvk.traceBegin("queryFriends_" + paramList.size());
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int i = 1;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        i += 1;
      }
      paramList = this.em.query(Friends.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Friends)paramList.next();
          this.E.put(((Friends)localObject).uin, localObject);
          asgx.a(this.app, (Friends)localObject);
        }
      }
    }
    auvk.traceEnd();
  }
  
  public void iN(List<ExtensionInfo> arg1)
  {
    if ((??? == null) || (???.size() == 0)) {}
    for (;;)
    {
      return;
      if (???.size() == 1)
      {
        a((ExtensionInfo)???.get(0));
        return;
      }
      Object localObject1 = this.em.getTransaction();
      ((EntityTransaction)localObject1).begin();
      try
      {
        Iterator localIterator = ???.iterator();
        while (localIterator.hasNext())
        {
          ExtensionInfo localExtensionInfo2 = (ExtensionInfo)localIterator.next();
          if (!TextUtils.isEmpty(localExtensionInfo2.uin)) {
            a(localExtensionInfo2);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.extension", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((EntityTransaction)localObject1).end();
        for (;;)
        {
          localObject1 = ???.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ExtensionInfo localExtensionInfo1 = (ExtensionInfo)((Iterator)localObject1).next();
            if ((!TextUtils.isEmpty(localExtensionInfo1.uin)) && (this.F != null)) {
              synchronized (this.F)
              {
                this.F.put(localExtensionInfo1.uin, localExtensionInfo1);
              }
            }
          }
          localObject2.commit();
          localObject2.end();
        }
      }
      finally
      {
        localObject2.end();
      }
    }
  }
  
  /* Error */
  public void iO(List<SpecialCareInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 1165 1 0
    //   10: ifne +20 -> 30
    //   13: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +13 -> 29
    //   19: ldc_w 414
    //   22: iconst_2
    //   23: ldc_w 1676
    //   26: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: return
    //   30: aload_1
    //   31: invokeinterface 1165 1 0
    //   36: iconst_1
    //   37: if_icmpne +18 -> 55
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_0
    //   43: invokeinterface 1171 2 0
    //   48: checkcast 736	com/tencent/mobileqq/data/SpecialCareInfo
    //   51: invokevirtual 1678	acff:a	(Lcom/tencent/mobileqq/data/SpecialCareInfo;)V
    //   54: return
    //   55: aload_0
    //   56: getfield 112	acff:I	Ljava/util/concurrent/ConcurrentHashMap;
    //   59: ifnull +73 -> 132
    //   62: aload_0
    //   63: getfield 112	acff:I	Ljava/util/concurrent/ConcurrentHashMap;
    //   66: astore_2
    //   67: aload_2
    //   68: monitorenter
    //   69: aload_1
    //   70: invokeinterface 1432 1 0
    //   75: astore_3
    //   76: aload_3
    //   77: invokeinterface 313 1 0
    //   82: ifeq +48 -> 130
    //   85: aload_3
    //   86: invokeinterface 317 1 0
    //   91: checkcast 736	com/tencent/mobileqq/data/SpecialCareInfo
    //   94: astore 4
    //   96: aload 4
    //   98: getfield 1014	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   101: invokestatic 556	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne -28 -> 76
    //   107: aload_0
    //   108: getfield 112	acff:I	Ljava/util/concurrent/ConcurrentHashMap;
    //   111: aload 4
    //   113: getfield 1014	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   116: aload 4
    //   118: invokevirtual 372	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: goto -46 -> 76
    //   125: astore_1
    //   126: aload_2
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: aload_2
    //   131: monitorexit
    //   132: aload_0
    //   133: getfield 179	acff:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   136: invokevirtual 606	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 611	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   144: aload_1
    //   145: invokeinterface 1432 1 0
    //   150: astore_1
    //   151: aload_1
    //   152: invokeinterface 313 1 0
    //   157: ifeq +110 -> 267
    //   160: aload_1
    //   161: invokeinterface 317 1 0
    //   166: checkcast 736	com/tencent/mobileqq/data/SpecialCareInfo
    //   169: astore_3
    //   170: aload_3
    //   171: getfield 1014	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   174: invokestatic 556	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne -26 -> 151
    //   180: aload_0
    //   181: aload_3
    //   182: invokevirtual 720	acff:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   185: pop
    //   186: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -38 -> 151
    //   192: ldc_w 414
    //   195: iconst_2
    //   196: new 188	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 1680
    //   206: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_3
    //   210: invokevirtual 1019	com/tencent/mobileqq/data/SpecialCareInfo:toString	()Ljava/lang/String;
    //   213: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: goto -71 -> 151
    //   225: astore_1
    //   226: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +33 -> 262
    //   232: ldc_w 1670
    //   235: iconst_2
    //   236: new 188	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1682
    //   246: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual 1404	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_2
    //   263: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   266: return
    //   267: aload_2
    //   268: invokevirtual 646	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   271: aload_2
    //   272: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   275: return
    //   276: astore_1
    //   277: aload_2
    //   278: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   281: aload_1
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	acff
    //   0	283	1	paramList	List<SpecialCareInfo>
    //   66	212	2	localObject1	Object
    //   75	135	3	localObject2	Object
    //   94	23	4	localSpecialCareInfo	SpecialCareInfo
    // Exception table:
    //   from	to	target	type
    //   69	76	125	finally
    //   76	122	125	finally
    //   126	128	125	finally
    //   130	132	125	finally
    //   144	151	225	java/lang/Exception
    //   151	222	225	java/lang/Exception
    //   267	271	225	java/lang/Exception
    //   144	151	276	finally
    //   151	222	276	finally
    //   226	262	276	finally
    //   267	271	276	finally
  }
  
  /* Error */
  public void iP(List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 1165 1 0
    //   10: ifgt +4 -> 14
    //   13: return
    //   14: new 201	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 368	java/util/ArrayList:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 179	acff:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: invokevirtual 606	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 611	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   34: aload_1
    //   35: invokeinterface 1432 1 0
    //   40: astore_1
    //   41: aload_1
    //   42: invokeinterface 313 1 0
    //   47: ifeq +96 -> 143
    //   50: aload_1
    //   51: invokeinterface 317 1 0
    //   56: checkcast 234	java/lang/String
    //   59: astore 4
    //   61: aload_0
    //   62: getfield 86	acff:E	Ljava/util/concurrent/ConcurrentHashMap;
    //   65: aload 4
    //   67: invokevirtual 241	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 346	com/tencent/mobileqq/data/Friends
    //   73: astore 5
    //   75: aload 5
    //   77: ifnull -36 -> 41
    //   80: aload 5
    //   82: getfield 350	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   85: ifeq +10 -> 95
    //   88: aload_3
    //   89: aload 4
    //   91: invokevirtual 388	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: aload 5
    //   97: iconst_0
    //   98: putfield 350	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   101: aload_0
    //   102: aload 5
    //   104: invokevirtual 621	acff:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   107: pop
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 416	acff:cvD	I
    //   113: iconst_1
    //   114: isub
    //   115: putfield 416	acff:cvD	I
    //   118: goto -77 -> 41
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 1194	java/lang/Exception:printStackTrace	()V
    //   126: aload_2
    //   127: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   130: aload_0
    //   131: invokevirtual 726	acff:cIV	()V
    //   134: aload_0
    //   135: getfield 171	acff:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   138: aload_3
    //   139: invokestatic 1687	yil:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   142: return
    //   143: aload_2
    //   144: invokevirtual 646	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   147: aload_2
    //   148: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   151: goto -21 -> 130
    //   154: astore_1
    //   155: aload_2
    //   156: invokevirtual 630	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	acff
    //   0	161	1	paramList	List<String>
    //   29	127	2	localEntityTransaction	EntityTransaction
    //   21	118	3	localArrayList	ArrayList
    //   59	31	4	str	String
    //   73	30	5	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   30	41	121	java/lang/Exception
    //   41	75	121	java/lang/Exception
    //   80	95	121	java/lang/Exception
    //   95	118	121	java/lang/Exception
    //   143	147	121	java/lang/Exception
    //   30	41	154	finally
    //   41	75	154	finally
    //   80	95	154	finally
    //   95	118	154	finally
    //   122	126	154	finally
    //   143	147	154	finally
  }
  
  public void iQ(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    EntityTransaction localEntityTransaction = this.em.getTransaction();
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          continue;
        }
        localObject = (String)paramList.next();
        localFriends = (Friends)this.E.get(localObject);
        if (localFriends == null) {
          continue;
        }
        if (localFriends.gathtertype == 2) {
          this.cvE -= 1;
        }
        if ((localFriends.gathtertype != 2) && (localFriends.gathtertype != 0)) {
          continue;
        }
        if (localFriends.gathtertype == 0) {
          localFriends.recommReason = acfp.m(2131706639);
        }
        if (localFriends.gathtertype != 1) {
          localArrayList.add(localObject);
        }
        localFriends.gathtertype = 1;
        localObject = b(localFriends.uin);
        if (localObject == null) {
          continue;
        }
        if (((Card)localObject).shGender != 0) {
          continue;
        }
        b = 1;
      }
      catch (Exception paramList)
      {
        Object localObject;
        Friends localFriends;
        paramList.printStackTrace();
        localEntityTransaction.end();
        cIV();
        yil.c(this.app, localArrayList);
        return;
        if (((Card)localObject).shGender != 1) {
          break label276;
        }
        b = 2;
        continue;
        localEntityTransaction.commit();
        localEntityTransaction.end();
        continue;
      }
      finally
      {
        localEntityTransaction.end();
      }
      localFriends.gender = b;
      localFriends.age = ((Card)localObject).age;
      a(localFriends);
      this.cvD += 1;
      continue;
      label276:
      byte b = 0;
    }
  }
  
  public void iR(List<cmd0x7c4.RecommendReason> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (cmd0x7c4.RecommendReason)paramList.next();
        String str = String.valueOf(((cmd0x7c4.RecommendReason)localObject).uint32_reason_id.get());
        localObject = ((cmd0x7c4.RecommendReason)localObject).bytes_recommend_reason.get().toStringUtf8();
        this.dX.put(str, localObject);
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "key : " + str + " ; reason : " + (String)localObject);
        }
      }
    }
  }
  
  public void init()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init begin");
    }
    cIZ();
    cIV();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init end");
    }
  }
  
  public boolean isFriend(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.isFriend();
    }
    return false;
  }
  
  public boolean it(int paramInt)
  {
    return false;
  }
  
  public String ji(String paramString)
  {
    Friends localFriends = e(paramString);
    String str = paramString;
    if (localFriends != null)
    {
      str = paramString;
      if (localFriends.alias != null)
      {
        str = paramString;
        if (localFriends.alias.length() > 0) {
          str = localFriends.alias;
        }
      }
    }
    return str;
  }
  
  public boolean kb(String paramString)
  {
    if (this.dW == null)
    {
      this.dW = new ConcurrentHashMap();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList begin");
      }
      Object localObject = this.em.query(Groups.class, false, "group_id=?", new String[] { "-1002" }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          this.dW.put(localFriends.uin, "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList end, size=" + this.dW.size());
      }
    }
    return this.dW.containsKey(paramString);
  }
  
  public boolean kc(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.isFriend();
    }
    return false;
  }
  
  public boolean kd(String paramString)
  {
    return w(paramString, false);
  }
  
  public boolean ke(String paramString)
  {
    paramString = e(paramString);
    if (paramString != null) {
      return paramString.isShield();
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "FriendsManager onDestory");
    }
    this.em.close();
  }
  
  public ArrayList<Entity> p(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.E.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Friends)this.E.get(localObject);
      if (((Friends)localObject).groupid == paramInt) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public ConcurrentHashMap<String, ArrayList<Entity>> p()
  {
    return a(false);
  }
  
  public boolean w(String paramString, boolean paramBoolean)
  {
    return b(paramString, paramBoolean, false);
  }
  
  public void yZ(String paramString)
  {
    Object localObject4 = (Friends)this.E.remove(paramString);
    if (localObject4 != null)
    {
      if (((Friends)localObject4).gathtertype != 2) {
        break label257;
      }
      this.cvE -= 1;
    }
    for (;;)
    {
      localObject2 = null;
      localObject1 = null;
      try
      {
        localEntityTransaction = this.em.getTransaction();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.begin();
        Object localObject3 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localObject3 = (Friends)this.em.find(Friends.class, paramString);
        }
        if (localObject3 != null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localObject4 = a(String.valueOf(((Friends)localObject3).groupid));
          if (localObject4 != null)
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            ((Groups)localObject4).group_friend_count -= 1;
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            a((Entity)localObject4);
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          this.em.remove((Entity)localObject3);
        }
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.commit();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          EntityTransaction localEntityTransaction;
          localObject2 = localObject1;
          QLog.e("Q.contacttab.", 1, "", localException);
          if (localObject1 != null) {
            localObject1.end();
          }
        }
      }
      finally
      {
        if (localObject2 == null) {
          break;
        }
        localObject2.end();
      }
      cIV();
      if (abbf.e(paramString, this.app)) {
        abbf.h(paramString, this.app);
      }
      if (abbf.f(paramString, this.app)) {
        abbf.i(paramString, this.app);
      }
      DQ(paramString);
      paramString = a(paramString);
      if (paramString != null)
      {
        paramString.removeAllMutualMark();
        a(paramString);
      }
      return;
      label257:
      if (((Friends)localObject4).gathtertype == 1) {
        this.cvD -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acff
 * JD-Core Version:    0.7.0.1
 */