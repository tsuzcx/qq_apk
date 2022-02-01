import NearbyGroup.GroupInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager.1;
import com.tencent.mobileqq.app.MayknowRecommendManager.11;
import com.tencent.mobileqq.app.MayknowRecommendManager.13;
import com.tencent.mobileqq.app.MayknowRecommendManager.2;
import com.tencent.mobileqq.app.MayknowRecommendManager.4;
import com.tencent.mobileqq.app.MayknowRecommendManager.5;
import com.tencent.mobileqq.app.MayknowRecommendManager.6;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;
import tencent.im.oidb.oidb_0xc26.EntryDelay;
import tencent.im.oidb.oidb_0xc26.RecommendInfo;
import tencent.im.oidb.oidb_0xc26.RgroupInfo;
import tencent.im.oidb.oidb_0xc26.TabInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.MsgBody;

public class achg
  implements Manager
{
  public static long PR = 86400000L;
  public static boolean bIg;
  public static final Object cs = new Object();
  public static final Object ct = new Object();
  public static int cwk = 37;
  private static int cwl = 70;
  private static int cwm = 3;
  private long PS;
  private long PT;
  private anwa.a a = new achl(this);
  private ajdo.a b = new achk(this);
  private volatile boolean bIb;
  private volatile boolean bIc;
  public volatile boolean bId;
  boolean bIe = false;
  public boolean bIf;
  private boolean bIh;
  private boolean bIi;
  private boolean bgy;
  boolean bnF = false;
  public String box = "";
  private Object cu = new Object();
  private Object cv = new Object();
  private Object cw = new Object();
  public int cwn = -1;
  private int cwo = 2;
  private int cwp;
  private int cwq = 1;
  private ConcurrentHashMap<String, MayKnowExposure> eb;
  private ConcurrentHashMap<Integer, byte[]> ec = new ConcurrentHashMap(10);
  private ConcurrentHashMap<Integer, Boolean> ed = new ConcurrentHashMap(10);
  private EntityManager em;
  private HashMap<Integer, ArrayList> iP = new HashMap(10);
  acfd l = new achj(this);
  private Object lock = new Object();
  private QQAppInterface mApp;
  private SharedPreferences mPreferences;
  private MqqHandler r;
  private List<RecentRecommendTroopItem> tH;
  private ArrayList<MayKnowRecommend> tg;
  private final ArrayList<Integer> th;
  private ArrayList<yrh> ti;
  
  public achg(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
    this.th = new ArrayList(5);
    this.eb = new ConcurrentHashMap();
    this.tg = new ArrayList();
    this.tH = new ArrayList();
    this.mPreferences = this.mApp.getPreferences();
    this.r = new MqqHandler(ThreadManager.getSubThreadLooper());
    this.r.post(new MayknowRecommendManager.1(this));
    paramQQAppInterface.addObserver(this.l);
    if (this.b != null)
    {
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(this.b);
      }
    }
    anwa.a(this.a);
  }
  
  private void Jk(int paramInt)
  {
    synchronized (this.cw)
    {
      if ((this.iP != null) && (this.iP.containsKey(Integer.valueOf(paramInt)))) {
        return;
      }
      if ((this.em != null) && (this.em.isOpen()))
      {
        ArrayList localArrayList = (ArrayList)this.em.query(MayKnowRecommend.class, false, "tabID=?", new String[] { paramInt + "" }, null, null, null, null);
        synchronized (this.cw)
        {
          if ((this.iP != null) && (localArrayList != null)) {
            this.iP.put(Integer.valueOf(paramInt), localArrayList);
          }
          return;
        }
      }
    }
  }
  
  private void Jm(int paramInt)
  {
    StringBuilder localStringBuilder = null;
    if (this.ec.contains(Integer.valueOf(paramInt))) {
      return;
    }
    label244:
    for (;;)
    {
      synchronized (this.cv)
      {
        String str = this.mApp.getApp().getSharedPreferences("mayknow_connections_sp_" + this.mApp.getCurrentAccountUin(), 0).getString("sp_mayknow_connections_tabinfo_cookie_" + paramInt, null);
        Object localObject1 = localStringBuilder;
        if (str != null) {}
        try
        {
          localObject1 = Base64.decode(str, 2);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("loadTabCookieFromSP ").append(paramInt).append(" ");
            if (localObject1 == null)
            {
              bool = true;
              QLog.d("MayknowRecommendManager", 2, bool);
            }
          }
          else
          {
            if (localObject1 != null) {
              break label244;
            }
            localObject1 = new byte[0];
            this.ec.put(Integer.valueOf(paramInt), localObject1);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localObject1 = localStringBuilder;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MayknowRecommendManager", 2, "loadTabCookieFromSP " + localThrowable.toString());
          localObject1 = localStringBuilder;
          continue;
        }
      }
      boolean bool = false;
    }
  }
  
  private void Jn(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "deleteRecentUserByType " + paramInt);
    }
    acxw localacxw = this.mApp.a().a();
    Object localObject = localacxw.q(false);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if (localRecentUser.getType() == paramInt) {
          localacxw.f(localRecentUser);
        }
      }
    }
  }
  
  private boolean Uk()
  {
    return !((zbq)this.mApp.getManager(295)).Vf();
  }
  
  private int a(List<RecentBaseData> paramList, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 3)
    {
      if (paramInt2 <= 3) {
        return paramInt2;
      }
      int i = paramInt1;
      paramInt2 = paramInt1;
      paramInt1 = i;
      if (paramInt2 >= paramList.size()) {
        break label81;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramList.get(paramInt2);
      if (aajg.a(this.mApp, localRecentBaseData)) {
        break label78;
      }
      paramInt1 += 1;
      label58:
      if (paramInt1 != 3) {}
    }
    label78:
    label81:
    for (paramInt1 = paramInt2 + 1;; paramInt1 = 3)
    {
      return paramInt1;
      paramInt2 += 1;
      break;
      return paramInt1;
      break label58;
    }
  }
  
  private RecentRecommendTroopItem a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onJoinedTroop uin: " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      int i;
      synchronized (this.tH)
      {
        int j = this.tH.size();
        i = 0;
        if (i >= j) {
          break label258;
        }
        if (!((RecentRecommendTroopItem)this.tH.get(i)).uin.equalsIgnoreCase(paramString)) {
          break label251;
        }
        localObject2 = (RecentRecommendTroopItem)this.tH.remove(i);
        localObject1 = localObject2;
        if (this.cwp > i)
        {
          i = 0;
          localObject1 = localObject2;
          if (i < this.cwo)
          {
            this.cwp -= 1;
            i += 1;
            continue;
          }
        }
        i = this.tH.size();
        this.r.post(new MayknowRecommendManager.11(this, paramString));
        if (i == 0)
        {
          this.mApp.a().a().Jn(8113);
          return localObject1;
        }
      }
      Object localObject2 = this.mApp.a().a();
      ??? = ((acxw)localObject2).b(paramString, 8113);
      paramString = localObject1;
      if (??? == null) {
        break;
      }
      ((acxw)localObject2).f((RecentUser)???);
      return localObject1;
      label251:
      i += 1;
      continue;
      label258:
      Object localObject1 = null;
    }
  }
  
  private yrh a(oidb_0xc26.TabInfo paramTabInfo)
  {
    yrh localyrh = new yrh();
    localyrh.tab_id = paramTabInfo.uint32_tab_id.get();
    localyrh.caI = paramTabInfo.uint32_recommend_count.get();
    String str;
    if (paramTabInfo.bytes_table_name.has())
    {
      str = paramTabInfo.bytes_table_name.get().toStringUtf8();
      localyrh.aZz = str;
      if (!paramTabInfo.bytes_icon_url_select.has()) {
        break label116;
      }
      str = paramTabInfo.bytes_icon_url_select.get().toStringUtf8();
      label77:
      localyrh.aZA = str;
      if (!paramTabInfo.bytes_icon_url_unselect.has()) {
        break label122;
      }
    }
    label116:
    label122:
    for (paramTabInfo = paramTabInfo.bytes_icon_url_unselect.get().toStringUtf8();; paramTabInfo = "")
    {
      localyrh.aZB = paramTabInfo;
      return localyrh;
      str = "";
      break;
      str = "";
      break label77;
    }
  }
  
  private void a(int paramInt, ArrayList<MayKnowRecommend> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      paramArrayList = e(paramArrayList);
      if (paramInt != 23) {
        break label192;
      }
    }
    for (;;)
    {
      synchronized (cs)
      {
        if ((paramArrayList.size() > 0) && (this.tg != null) && (this.tg.size() + paramArrayList.size() < 1000)) {
          this.tg.addAll(paramArrayList);
        }
        ??? = this.em.getTransaction();
      }
      try
      {
        ((EntityTransaction)???).begin();
        if (paramBoolean)
        {
          localObject2 = "delete from MayKnowRecommend where tabID=" + paramInt;
          this.em.execSQL((String)localObject2);
        }
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            localObject2 = (MayKnowRecommend)paramArrayList.next();
            this.em.persist((Entity)localObject2);
          }
        }
      }
      catch (Exception paramArrayList)
      {
        Object localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "onGetConnectionsPersonData ex", paramArrayList);
        }
        return;
        paramArrayList = finally;
        throw paramArrayList;
        label192:
        ??? = this.cw;
        if (paramBoolean) {}
        for (;;)
        {
          try
          {
            this.iP.put(Integer.valueOf(paramInt), paramArrayList);
            break;
          }
          finally {}
          localObject2 = (ArrayList)this.iP.get(Integer.valueOf(paramInt));
          if (localObject2 != null)
          {
            ArrayList localArrayList = new ArrayList(((ArrayList)localObject2).size() + paramArrayList.size());
            localArrayList.addAll((Collection)localObject2);
            localArrayList.addAll(paramArrayList);
            this.iP.put(Integer.valueOf(paramInt), localArrayList);
          }
        }
        ((EntityTransaction)???).commit();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  private void a(RecentRecommendTroopItem paramRecentRecommendTroopItem)
  {
    int j;
    int i;
    String str;
    if ((paramRecentRecommendTroopItem.labelList != null) && (!paramRecentRecommendTroopItem.labelList.isEmpty()))
    {
      j = Math.min(3, paramRecentRecommendTroopItem.labelList.size());
      Iterator localIterator = paramRecentRecommendTroopItem.labelList.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        oidb_0x9fb.Label localLabel = (oidb_0x9fb.Label)localIterator.next();
        str = localLabel.bytes_name.get().toStringUtf8();
        if (!TextUtils.isEmpty(str))
        {
          if (localLabel.enum_type.get() != 1) {
            break label193;
          }
          str = str + acfp.m(2131708057);
        }
      }
    }
    label193:
    for (;;)
    {
      paramRecentRecommendTroopItem.labelStr += str;
      i += 1;
      if (i == j) {
        return;
      }
      paramRecentRecommendTroopItem.labelStr += "|";
      break;
    }
  }
  
  private ArrayList<RecentRecommendTroopItem> ab(ArrayList<RecentRecommendTroopItem> paramArrayList)
  {
    Object localObject;
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      localObject = new ArrayList();
      return localObject;
    }
    TroopManager localTroopManager = (TroopManager)this.mApp.getManager(52);
    int i = paramArrayList.size() - 1;
    for (;;)
    {
      localObject = paramArrayList;
      if (i < 0) {
        break;
      }
      if (localTroopManager.d(((RecentRecommendTroopItem)paramArrayList.get(i)).uin) != null) {
        paramArrayList.remove(i);
      }
      i -= 1;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new SubMsgType0x111.MsgBody();
        ((SubMsgType0x111.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x111.MsgBody)localObject).uint64_type.has()) {
          break label387;
        }
        l1 = ((SubMsgType0x111.MsgBody)localObject).uint64_type.get();
        if (QLog.isColorLevel()) {
          QLog.i("MayknowRecommendManager", 2, "decodePush0x210_0x111,type = " + l1);
        }
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
        if (l1 == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 update list");
          }
          paramQQAppInterface.P((int)l1, null);
          return;
        }
        if (l1 == 1L)
        {
          paramArrayOfByte = new ArrayList();
          if (((SubMsgType0x111.MsgBody)localObject).rpt_msg_add_recommend_persons.has()) {
            paramArrayOfByte.addAll(MayKnowRecommend.covServerPushDataToLocal(((SubMsgType0x111.MsgBody)localObject).rpt_msg_add_recommend_persons.get(), System.currentTimeMillis()));
          }
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 add " + paramArrayOfByte);
          }
          paramQQAppInterface.P((int)l1, paramArrayOfByte);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        QLog.i("MayknowRecommendManager", 1, "decodePush0x210_0x111 decode error, e=" + paramQQAppInterface.toString());
        return;
      }
      if (l1 == 2L)
      {
        paramArrayOfByte = new ArrayList();
        if (((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.has()) {
          paramArrayOfByte.addAll(((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.get());
        }
        localObject = new ArrayList();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          long l2 = ((Long)paramArrayOfByte.next()).longValue();
          if (l2 > 0L) {
            ((List)localObject).add(String.valueOf(l2));
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 del " + localObject);
        }
        paramQQAppInterface.P((int)l1, (List)localObject);
        return;
        QLog.i("MayknowRecommendManager", 1, "decodePush0x210_0x111 pbData = null");
      }
      return;
      label387:
      long l1 = -1L;
    }
  }
  
  private void cJJ()
  {
    synchronized (ct)
    {
      Object localObject2 = this.em.query(MayKnowExposure.class, false, null, null, null, null, null, null);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MayKnowExposure localMayKnowExposure = (MayKnowExposure)((Iterator)localObject2).next();
          localMayKnowExposure = (MayKnowExposure)this.eb.put(MayKnowExposure.generateKey(localMayKnowExposure), localMayKnowExposure);
        }
      }
      this.bIc = true;
      long l1 = this.mPreferences.getLong("sp_report_explosure_time", 0L);
      if (Math.abs(System.currentTimeMillis() - l1) > PR)
      {
        if (this.mApp.a.Bd() == 1) {
          cJS();
        }
      }
      else {
        return;
      }
    }
    this.r.postDelayed(new MayknowRecommendManager.2(this), 5000L);
  }
  
  private void cJK()
  {
    Object localObject1 = (ArrayList)this.em.query(RecentRecommendTroopItem.class);
    Object localObject3;
    int i;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("initRecommendTroop in db, troopItems = ");
      if (localObject1 == null)
      {
        i = 0;
        QLog.i("MayknowRecommendManager", 2, i);
      }
    }
    else
    {
      localArrayList = ab((ArrayList)localObject1);
      localObject3 = this.tH;
      if (localArrayList == null) {}
    }
    for (;;)
    {
      try
      {
        if ((!localArrayList.isEmpty()) && (this.tH.isEmpty())) {
          this.tH.addAll((Collection)localObject1);
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("filtered troop:");
          if (localArrayList != null) {
            break label205;
          }
          localObject1 = "null";
          QLog.i("MayknowRecommendManager", 2, (String)localObject1);
        }
        cJP();
        localObject1 = (FriendListHandler)this.mApp.getBusinessHandler(1);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("is_from_init", true);
        ((FriendListHandler)localObject1).notifyUI(92, true, localObject3);
        return;
      }
      finally {}
      i = ((ArrayList)localObject1).size();
      break;
      label205:
      String str = localArrayList.toString();
    }
  }
  
  private void cJL()
  {
    Bundle localBundle = null;
    ArrayList localArrayList = (ArrayList)this.em.query(MayKnowRecommend.class, false, "tabID=? or tabID is null", new String[] { "23" }, null, null, null, null);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("initMayKnowGet in db, cpMkrs = ");
      if (localArrayList == null)
      {
        ??? = "NULL";
        QLog.i("MayknowRecommendManager", 2, (String)???);
      }
    }
    else
    {
      localObject3 = e(localArrayList);
      if ((localObject3 == null) || ((this.tg != null) && (this.tg.size() > 0))) {
        break label258;
      }
    }
    for (;;)
    {
      synchronized (cs)
      {
        this.tg = ((ArrayList)localObject3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("initMayKnowGet size:");
          if (this.tg == null) {
            break label277;
          }
          ??? = Integer.valueOf(this.tg.size());
          localObject3 = ((StringBuilder)localObject3).append(???).append(" cpMkrs:");
          ??? = localBundle;
          if (localArrayList != null) {
            ??? = Integer.valueOf(localArrayList.size());
          }
          QLog.i("MayknowRecommendManager", 2, ???);
        }
        cJQ();
        ??? = (FriendListHandler)this.mApp.getBusinessHandler(1);
        localBundle = new Bundle();
        localBundle.putBoolean("is_from_init", true);
        ((FriendListHandler)???).notifyUI(92, true, localBundle);
        return;
        ??? = localArrayList.toString();
      }
      label258:
      if (QLog.isColorLevel())
      {
        QLog.i("MayknowRecommendManager", 2, "initMayKnowGet, mRecommends alread has data");
        continue;
        label277:
        ??? = null;
      }
    }
  }
  
  private void cJN()
  {
    int i = 0;
    synchronized (this.cu)
    {
      if (this.ti == null) {}
      synchronized (this.cv)
      {
        Object localObject4 = this.mApp.getApp().getSharedPreferences("mayknow_connections_sp_" + this.mApp.getCurrentAccountUin(), 0).getString("sp_mayknow_connections_tabinfo_list_json", "");
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "loadConnectionsTabInfoList " + (String)localObject4);
        }
        boolean bool = ((String)localObject4).isEmpty();
        if (!bool) {}
        try
        {
          localObject4 = new JSONArray((String)localObject4);
          ArrayList localArrayList = new ArrayList(5);
          while (i < ((JSONArray)localObject4).length())
          {
            localArrayList.add(yrh.a(((JSONArray)localObject4).getJSONObject(i)));
            i += 1;
          }
          this.ti = localArrayList;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MayknowRecommendManager", 2, "loadConnectionsTabInfoList " + localJSONException.toString());
            }
          }
        }
        return;
      }
    }
  }
  
  private void cJO()
  {
    synchronized (this.cv)
    {
      this.mApp.getApp().getSharedPreferences("mayknow_connections_sp_" + this.mApp.getCurrentAccountUin(), 0).edit().clear().commit();
      return;
    }
  }
  
  private void cJS()
  {
    if (!NetworkUtils.isNetworkAvailable(this.mApp.getApplication())) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "reportExplosure size=" + this.eb.size() + " isExplosuresInited=" + this.bIc);
      }
      if ((this.eb.size() <= 0) || (!this.bIc)) {
        continue;
      }
      synchronized (ct)
      {
        this.bIb = true;
        ((FriendListHandler)this.mApp.getBusinessHandler(1)).e(this.eb);
        if (!QLog.isColorLevel()) {
          continue;
        }
        ??? = this.eb.entrySet().iterator();
        if (!((Iterator)???).hasNext()) {
          continue;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
        QLog.d("MayknowRecommendManager", 2, "reportExplosure, Key = " + (String)localEntry.getKey() + ", Value.exposeCnt = " + ((MayKnowExposure)localEntry.getValue()).exposeCnt + ", Value.exposeTime = " + ((MayKnowExposure)localEntry.getValue()).exposeTime);
      }
    }
  }
  
  private <T extends MayKnowRecommend> ArrayList<T> e(@NonNull ArrayList<T> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    acff localacff = (acff)this.mApp.getManager(51);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramArrayList.next();
      if (!localacff.isFriend(localMayKnowRecommend.uin))
      {
        boolean bool = localacff.b(localMayKnowRecommend.uin, false, true);
        if (bool) {}
        for (int i = 1;; i = 0)
        {
          localMayKnowRecommend.friendStatus = i;
          if (bool) {
            break;
          }
          localArrayList.add(localMayKnowRecommend);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void iT(List<oidb_0xc26.TabInfo> paramList)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("saveConnectionsTabInfoList ");
      if (paramList != null) {
        break label143;
      }
    }
    label143:
    for (??? = "null";; ??? = Integer.valueOf(paramList.size()))
    {
      QLog.d("MayknowRecommendManager", 2, ???);
      if (paramList == null) {
        return;
      }
      synchronized (this.cu)
      {
        this.ti = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localObject2 = a((oidb_0xc26.TabInfo)paramList.next());
        if (((yrh)localObject2).tab_id == 23) {
          ((yrh)localObject2).caI += cw().size();
        }
        this.ti.add(localObject2);
      }
    }
    iU(this.ti);
  }
  
  private void iU(List<yrh> paramList)
  {
    for (;;)
    {
      SharedPreferences localSharedPreferences;
      JSONArray localJSONArray;
      synchronized (this.cv)
      {
        localSharedPreferences = this.mApp.getApp().getSharedPreferences("mayknow_connections_sp_" + this.mApp.getCurrentAccountUin(), 0);
        if (paramList == null)
        {
          localSharedPreferences.edit().remove("sp_mayknow_connections_tabinfo_list_json").commit();
          return;
        }
        localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        if (paramList.hasNext()) {
          localJSONArray.put(yrh.a((yrh)paramList.next()));
        }
      }
      localSharedPreferences.edit().putString("sp_mayknow_connections_tabinfo_list_json", localJSONArray.toString()).commit();
    }
  }
  
  private void initData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "initData conversationTabShowType: " + this.cwn);
    }
    boolean bool3 = acha.aaB();
    boolean bool1 = false;
    boolean bool2 = false;
    EntityTransaction localEntityTransaction;
    if (bool3) {
      localEntityTransaction = this.em.getTransaction();
    }
    try
    {
      localEntityTransaction.begin();
      this.em.execSQL("delete from MayKnowRecommend");
      this.em.execSQL("delete from MayKnowExposure");
      localEntityTransaction.commit();
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "initData ex", localException);
        }
        localEntityTransaction.end();
        bool1 = bool2;
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    this.mPreferences.edit().putLong("pull_interval_conversation_tab", 0L).commit();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "initData isLocaleIDChange =  " + bool3 + ",isDBOperateSuccess = " + bool1);
    }
    initParams();
    if (this.cwn == -1) {
      return;
    }
    if (this.cwn == 2)
    {
      cJK();
      return;
    }
    cJJ();
    cJL();
  }
  
  private void initParams()
  {
    boolean bool2 = true;
    PR = this.mPreferences.getLong("sp_report_interval", 86400000L);
    cwk = this.mPreferences.getInt("sp_config_showcount", 37);
    cwl = this.mPreferences.getInt("sp_config_expectcount", 70);
    cwm = this.mPreferences.getInt("sp_config_newfriendcount", 3);
    int i = this.mPreferences.getInt("sp_conversation_tab_show_type", -1);
    this.bIe = kl("sp_mayknow_ml_s_a_vl");
    this.bnF = kl("sp_mayknow_addpage_s_a_vl");
    this.PT = this.mPreferences.getLong("sp_contacts_tab_recommend_troop_hide_time", 0L);
    this.cwo = this.mPreferences.getInt("sp_contacts_tab_recommend_troop_count", 2);
    aeim.a locala = aeim.a();
    StringBuilder localStringBuilder;
    if (locala != null)
    {
      this.cwq = locala.pollInterval;
      this.box = locala.jumpUrl;
      if (locala.cNd == 1)
      {
        bool1 = true;
        this.bIf = bool1;
      }
    }
    else
    {
      if (this.cwn != i)
      {
        ((FriendListHandler)this.mApp.getBusinessHandler(1)).notifyUI(123, true, new Object[] { Integer.valueOf(i) });
        this.cwn = i;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("initParams ,conversationTabDisplayAsVerticalListItem = ").append(this.bIe).append(",addPageDisplayAsVerticalListItem = ").append(this.bnF).append(",conversationTabShowType=").append(this.cwn).append(",mContactsTabRecommendTroopHideTime=").append(this.PT).append(",mContactsTabRecommendTroopPollInterval=").append(this.cwq).append(",contactsTabRecommendTroopJumpUrl=").append(this.box).append(",showRecommendTroopWhenSearchEmpty=").append(this.bIf).append(",mContactsTabShowRecommendTroopCount=").append(this.cwo).append(", config is null: ");
        if (locala != null) {
          break label379;
        }
      }
    }
    label379:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("MayknowRecommendManager", 2, bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void j(int paramInt, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      SharedPreferences localSharedPreferences;
      synchronized (this.cv)
      {
        localSharedPreferences = this.mApp.getApp().getSharedPreferences("mayknow_connections_sp_" + this.mApp.getCurrentAccountUin(), 0);
        if (paramArrayOfByte != null)
        {
          String str = "";
          try
          {
            localObject1 = Base64.encodeToString(paramArrayOfByte, 2);
            localSharedPreferences.edit().putString("sp_mayknow_connections_tabinfo_cookie_" + paramInt, (String)localObject1).commit();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("saveTabCookieToSP ").append(paramInt).append(" isNull ");
              if (paramArrayOfByte != null) {
                break label283;
              }
              bool = true;
              QLog.d("MayknowRecommendManager", 2, bool);
            }
            localObject1 = paramArrayOfByte;
            if (paramArrayOfByte == null) {
              localObject1 = new byte[0];
            }
            this.ec.put(Integer.valueOf(paramInt), localObject1);
            return;
          }
          catch (Throwable localThrowable)
          {
            Object localObject1 = str;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MayknowRecommendManager", 2, "saveTabCookieToSP " + localThrowable.toString());
            localObject1 = str;
            continue;
          }
        }
      }
      localSharedPreferences.edit().remove("sp_mayknow_connections_tabinfo_cookie_" + paramInt).commit();
      continue;
      label283:
      boolean bool = false;
    }
  }
  
  public int Ay()
  {
    int k = 0;
    int i = 0;
    cJN();
    if (!((zbq)this.mApp.getManager(295)).Vf()) {}
    for (int j = 1;; j = 0) {
      label149:
      for (;;)
      {
        synchronized (this.cu)
        {
          if (this.ti != null)
          {
            Iterator localIterator = this.ti.iterator();
            k = i;
            if (localIterator.hasNext())
            {
              yrh localyrh = (yrh)localIterator.next();
              if ((localyrh.tab_id != 23) && (j == 0)) {
                break label149;
              }
              i = localyrh.caI + i;
              break label149;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonAllNum " + k);
          }
          return k;
        }
      }
    }
  }
  
  public long B(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      return 9223372036854775807L;
    case 1: 
      str = "pull_interval_conversation_tab";
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        return this.mPreferences.getLong(str, 43200000L);
        str = "pull_interval_contact_head";
        continue;
        str = "pull_interval_recommend_tab";
        continue;
        str = "pull_interval_new_friend";
        continue;
        str = "pull_interval_add_page";
      }
    }
    return 0L;
  }
  
  public void Ec(String paramString)
  {
    int i;
    synchronized (this.th)
    {
      this.th.clear();
      try
      {
        Object localObject3 = new JSONObject(paramString);
        if (((JSONObject)localObject3).has("shield_sub_source_id"))
        {
          localObject3 = ((JSONObject)localObject3).getJSONArray("shield_sub_source_id");
          i = 0;
          while ((localObject3 != null) && (i < ((JSONArray)localObject3).length()))
          {
            int j = ((JSONArray)localObject3).getInt(i);
            this.th.add(Integer.valueOf(j));
            i += 1;
          }
        }
        ??? = new StringBuilder(100);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("MayknowRecommendManager", 2, "updateShieldConfig", localException);
        }
        if (!QLog.isColorLevel()) {
          break label238;
        }
      }
      ((StringBuilder)???).append("updateShieldConfig config: ").append(paramString).append("\r\n");
      ((StringBuilder)???).append("[");
      paramString = this.th;
      i = 0;
    }
    try
    {
      while (i < this.th.size())
      {
        ((StringBuilder)???).append(this.th.get(i)).append(",");
        i += 1;
        continue;
        paramString = finally;
        throw paramString;
      }
      ((StringBuilder)???).append("]");
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
      label238:
      return;
    }
    finally {}
  }
  
  public void Ed(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    bG(paramString, true);
  }
  
  public void Ee(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onContactsTabTroopItemDeleted troop uin: " + paramString);
    }
    a(paramString);
    ((ackn)this.mApp.getManager(22)).c(paramString, new achm(this, paramString));
    this.cwo -= 1;
    paramString = this.mPreferences.edit();
    if (this.cwo == 0)
    {
      this.PT = NetConnInfoCenter.getServerTime();
      paramString.putLong("sp_contacts_tab_recommend_troop_hide_time", this.PT);
      anot.a(null, "dc00899", "Grp_recom", "", "link_top", "clk_hide", 0, 0, "", "", "", "");
    }
    paramString.putInt("sp_contacts_tab_recommend_troop_count", this.cwo);
    paramString.commit();
    ((FriendListHandler)this.mApp.getBusinessHandler(1)).notifyUI(92, true, null);
  }
  
  public void Ef(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onConversationTabTroopItemDeleted uin:" + paramString);
    }
    Object localObject = a(paramString);
    ((ackn)this.mApp.getManager(22)).c(paramString, new achh(this, paramString));
    FriendListHandler localFriendListHandler = (FriendListHandler)this.mApp.getBusinessHandler(1);
    localFriendListHandler.notifyUI(92, true, null);
    localFriendListHandler.notifyUI(122, true, new Object[] { paramString });
    if (localObject == null)
    {
      paramString = "";
      if (localObject != null) {
        break label148;
      }
    }
    label148:
    for (localObject = "";; localObject = ((RecentRecommendTroopItem)localObject).recomAlgol)
    {
      anot.a(null, "dc00899", "Grp_recom", "", "msg_tab", "slide_delete", 0, 0, paramString, (String)localObject, "", "");
      return;
      paramString = ((RecentRecommendTroopItem)localObject).uin;
      break;
    }
  }
  
  public void Eg(String paramString)
  {
    a(paramString);
    ((FriendListHandler)this.mApp.getBusinessHandler(1)).notifyUI(122, true, new Object[] { paramString });
  }
  
  public void Fd(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.eb = new ConcurrentHashMap();
      this.em.execSQL("delete from MayKnowExposure");
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "onReportExplosures , success");
      }
      this.mPreferences.edit().putLong("sp_report_explosure_time", System.currentTimeMillis());
    }
    synchronized (ct)
    {
      this.bIb = false;
      return;
    }
  }
  
  public void Jj(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "clearConnectionsPageNetworkState " + paramInt);
    }
    if (this.ed != null) {
      this.ed.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void Jl(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeConnectionTab " + paramInt);
    }
    a(paramInt, new ArrayList(0), true);
    cJN();
    for (;;)
    {
      synchronized (this.cu)
      {
        if (this.ti == null) {
          break label155;
        }
        Iterator localIterator = this.ti.iterator();
        if (localIterator.hasNext())
        {
          if (((yrh)localIterator.next()).tab_id != paramInt) {
            continue;
          }
          localIterator.remove();
          i = 1;
          j = i;
          if (i != 0)
          {
            iU(this.ti);
            j = i;
          }
          if (j != 0) {
            j(paramInt, null);
          }
          return;
        }
      }
      int i = 0;
      continue;
      label155:
      int j = 0;
    }
  }
  
  public void Jo(int paramInt)
  {
    ((FriendListHandler)this.mApp.getBusinessHandler(1)).a(null, null, paramInt, null);
  }
  
  public void Jp(int paramInt)
  {
    if (this.cwn != paramInt) {
      ((FriendListHandler)this.mApp.getBusinessHandler(1)).notifyUI(123, true, new Object[] { Integer.valueOf(paramInt) });
    }
    this.cwn = paramInt;
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putInt("sp_conversation_tab_show_type", paramInt);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "saveConversationTabShowType type is: " + paramInt);
    }
  }
  
  public void K(boolean paramBoolean, List<oidb_0xc26.RecommendInfo> arg2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("handleReqRecommendTroopList success: ").append(paramBoolean).append(" trooplist size: ");
      if (??? != null) {
        break label71;
      }
    }
    label71:
    for (int i = 0;; i = ???.size())
    {
      QLog.i("MayknowRecommendManager", 2, i);
      if ((paramBoolean) && (??? != null) && (!???.isEmpty())) {
        break;
      }
      return;
    }
    Object localObject1 = new ArrayList();
    localEntityTransaction = this.em.getTransaction();
    localEntityTransaction.begin();
    this.em.execSQL("delete from RecentRecommendTroopItem");
    Iterator localIterator1 = ???.iterator();
    while (localIterator1.hasNext())
    {
      ??? = ((oidb_0xc26.RecommendInfo)localIterator1.next()).msg_groups.get();
      if ((??? != null) && (!???.isEmpty()))
      {
        Iterator localIterator2 = ???.iterator();
        label171:
        oidb_0xc26.RgroupInfo localRgroupInfo;
        RecentRecommendTroopItem localRecentRecommendTroopItem;
        while (localIterator2.hasNext())
        {
          localRgroupInfo = (oidb_0xc26.RgroupInfo)localIterator2.next();
          localRecentRecommendTroopItem = new RecentRecommendTroopItem();
          if (localRgroupInfo.uint64_group_code.has())
          {
            localRecentRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
            if (localRgroupInfo.bytes_group_name.has()) {
              localRecentRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
            }
            if (localRgroupInfo.bytes_group_memo.has()) {
              localRecentRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
            }
            localRecentRecommendTroopItem.labelList = ackn.aN(localRgroupInfo.rpt_group_label.get());
            localRecentRecommendTroopItem.labelStr = "";
            a(localRecentRecommendTroopItem);
            localRecentRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
            localRecentRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
            if (!localRgroupInfo.bytes_algorithm.has()) {
              break label515;
            }
            ??? = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
            label372:
            localRecentRecommendTroopItem.recomAlgol = ???;
            if (!localRgroupInfo.bytes_join_group_auth.has()) {
              break label521;
            }
            ??? = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
            label401:
            localRecentRecommendTroopItem.authSig = ???;
            if (!localRgroupInfo.uint32_activity.has()) {
              break label527;
            }
            i = localRgroupInfo.uint32_activity.get();
            label427:
            localRecentRecommendTroopItem.activity = i;
            if (!localRgroupInfo.int32_uin_privilege.has()) {
              break label532;
            }
          }
        }
        label515:
        label521:
        label527:
        label532:
        for (i = localRgroupInfo.int32_uin_privilege.get();; i = -1)
        {
          localRecentRecommendTroopItem.privilege = i;
          this.em.persistOrReplace(localRecentRecommendTroopItem);
          ((List)localObject1).add(localRecentRecommendTroopItem);
          if (!QLog.isColorLevel()) {
            break label171;
          }
          QLog.d("MayknowRecommendManager", 2, "saveNotificationRecommendTroop into db, recommend troop = " + localRecentRecommendTroopItem);
          break label171;
          break;
          ??? = "";
          break label372;
          ??? = "";
          break label401;
          i = 0;
          break label427;
        }
      }
    }
    for (;;)
    {
      try
      {
        localEntityTransaction.commit();
      }
      catch (Exception ???)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MayknowRecommendManager", 2, "saveRecommendTroop commit error");
        localEntityTransaction.end();
        continue;
      }
      finally
      {
        localEntityTransaction.end();
      }
      synchronized (this.tH)
      {
        this.tH.clear();
        this.tH.addAll((Collection)localObject1);
        this.cwp = 0;
        this.PS = 0L;
        return;
      }
    }
  }
  
  public List<RecentRecommendTroopItem> R(int paramInt)
  {
    int i = 1;
    if (!kl("sp_mayknow_entry_list_head"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "getContactsTabNeedShowTroop switch not open.");
      }
      return null;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    if (l1 - this.PT < 86400L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "getContactsTabNeedShowTroop hide time in 24h. return null.");
      }
      return null;
    }
    if (this.cwo == 0)
    {
      this.cwo = 2;
      ??? = this.mPreferences.edit();
      ((SharedPreferences.Editor)???).putInt("sp_contacts_tab_recommend_troop_count", this.cwo);
      ((SharedPreferences.Editor)???).commit();
    }
    ArrayList localArrayList = new ArrayList();
    if (this.cwq < 1) {}
    while ((l1 - this.PS < i * 60) && (paramInt > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "getContactsTabNeedShowTroop in poll interval. return empty.");
      }
      return localArrayList;
      i = this.cwq;
    }
    synchronized (this.tH)
    {
      i = this.tH.size();
      if (i == 0) {
        return null;
      }
      if (this.cwp < 0) {
        this.cwp = 0;
      }
      this.cwp %= i;
      int j = Math.min(this.cwo, i);
      paramInt = 0;
      while ((this.cwp < i) && (paramInt < j))
      {
        localArrayList.add(this.tH.get(this.cwp));
        int k = this.cwp + 1;
        this.cwp = k;
        this.cwp = (k % i);
        paramInt += 1;
      }
      if (localArrayList.size() > 0) {
        this.PS = l1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "getContactsTabNeedShowTroop return troop list: " + localArrayList.toString());
      }
      return localArrayList;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemote entryType = " + paramInt1 + " tabID=" + paramInt2);
    }
    this.r.post(new MayknowRecommendManager.4(this, paramInt2, paramInt1, paramBundle));
  }
  
  public void a(int paramInt, ArrayList<MayKnowRecommend> paramArrayList, List<oidb_0xc26.TabInfo> paramList, byte[] paramArrayOfByte, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3;
    int i;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("onGetConnectionsPersonData ").append(paramInt).append(" ").append(paramBoolean).append(" ");
      if (paramArrayList == null)
      {
        ??? = "";
        QLog.d("MayknowRecommendManager", 2, ???);
      }
    }
    else
    {
      a(paramInt, paramArrayList, paramBoolean);
      cJN();
      if (paramList == null) {
        break label574;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "onGetConnectionsPersonData " + paramInt + " " + paramList.size());
      }
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          ??? = (oidb_0xc26.TabInfo)paramList.next();
          if (((oidb_0xc26.TabInfo)???).uint32_tab_id.get() == paramInt)
          {
            paramList = a((oidb_0xc26.TabInfo)???);
            ??? = q(paramInt);
            if (??? != null)
            {
              i = ((ArrayList)???).size();
              if (QLog.isColorLevel()) {
                QLog.d("MayknowRecommendManager", 2, "onGetConnectionsPersonData update count " + i + " " + paramList.caI);
              }
              paramList.caI = (i + paramList.caI);
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (paramList == null) {
          break label574;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "onGetConnectionsPersonData update tabInfo" + paramList.toString());
        }
        synchronized (this.cu)
        {
          if (this.ti != null)
          {
            localObject3 = this.ti.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              yrh localyrh = (yrh)((Iterator)localObject3).next();
              if ((localyrh.equals(paramList)) && ((localyrh.caI != paramList.caI) || (!localyrh.aZz.equals(paramList.aZz)) || (!localyrh.aZA.equals(paramList.aZA)) || (!localyrh.aZB.equals(paramList.aZB))))
              {
                localyrh.caI = paramList.caI;
                localyrh.aZz = paramList.aZz;
                localyrh.aZA = paramList.aZA;
                localyrh.aZB = paramList.aZB;
                iU(this.ti);
              }
            }
          }
          paramList = new ArrayList();
          if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            paramArrayList = paramArrayList.iterator();
            for (;;)
            {
              if (paramArrayList.hasNext())
              {
                ??? = (MayKnowRecommend)paramArrayList.next();
                if (??? != null)
                {
                  paramList.add(((MayKnowRecommend)???).uin);
                  continue;
                  ??? = Integer.valueOf(paramArrayList.size());
                  break;
                  i = 0;
                }
              }
            }
          }
        }
      }
      if (paramBundle == null)
      {
        paramArrayList = localObject2;
        if (paramBundle != null) {
          break label597;
        }
      }
      label574:
      label597:
      for (i = 3;; i = paramBundle.getInt("update_type", 3))
      {
        ContactReportUtils.a(this.mApp, i, paramList, String.valueOf(paramInt), paramArrayList);
        j(paramInt, paramArrayOfByte);
        return;
        paramArrayList = paramBundle.getString("from", "3");
        break;
      }
      paramList = null;
    }
  }
  
  public void a(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      synchronized (ct)
      {
        if ((!this.bIc) || (this.bIb)) {
          return;
        }
        ??? = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
        if (this.eb.containsKey(???))
        {
          paramMayKnowRecommend = (MayKnowExposure)this.eb.get(???);
          if (paramInt3 != 1) {
            paramMayKnowRecommend.exposeCnt += 1;
          }
          if ((paramMayKnowRecommend.startExploseTime != 0L) || (paramInt3 != 1)) {
            break;
          }
          paramMayKnowRecommend.startExploseTime = SystemClock.uptimeMillis();
          return;
        }
      }
      paramMayKnowRecommend = new MayKnowExposure(paramMayKnowRecommend.uin, paramInt1, paramInt2, paramInt3, paramMayKnowRecommend.algBuffer, paramMayKnowRecommend.additive);
      this.eb.put(???, paramMayKnowRecommend);
    }
  }
  
  /* Error */
  public void a(List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 538 1 0
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: new 163	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 170	java/util/ArrayList:<init>	()V
    //   21: astore 7
    //   23: getstatic 79	achg:cs	Ljava/lang/Object;
    //   26: astore 8
    //   28: aload 8
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 172	achg:tg	Ljava/util/ArrayList;
    //   35: invokevirtual 507	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   38: astore 9
    //   40: aload 9
    //   42: invokeinterface 346 1 0
    //   47: ifeq +92 -> 139
    //   50: aload 9
    //   52: invokeinterface 350 1 0
    //   57: checkcast 237	com/tencent/mobileqq/data/MayKnowRecommend
    //   60: astore 10
    //   62: aload 10
    //   64: ifnull -24 -> 40
    //   67: aload_1
    //   68: aload 10
    //   70: getfield 857	com/tencent/mobileqq/data/MayKnowRecommend:uin	Ljava/lang/String;
    //   73: invokeinterface 1314 2 0
    //   78: ifeq -38 -> 40
    //   81: iload 6
    //   83: ifeq +39 -> 122
    //   86: aload 10
    //   88: getfield 1317	com/tencent/mobileqq/data/MayKnowRecommend:cardDisplayTimestamp	J
    //   91: lload 4
    //   93: ladd
    //   94: lload_2
    //   95: lcmp
    //   96: ifge -56 -> 40
    //   99: aload 10
    //   101: lload_2
    //   102: putfield 1317	com/tencent/mobileqq/data/MayKnowRecommend:cardDisplayTimestamp	J
    //   105: aload 7
    //   107: aload 10
    //   109: invokevirtual 793	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   112: pop
    //   113: goto -73 -> 40
    //   116: astore_1
    //   117: aload 8
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: aload 10
    //   124: lload_2
    //   125: putfield 1317	com/tencent/mobileqq/data/MayKnowRecommend:cardDisplayTimestamp	J
    //   128: aload 7
    //   130: aload 10
    //   132: invokevirtual 793	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -96 -> 40
    //   139: aload 8
    //   141: monitorexit
    //   142: aload 7
    //   144: invokevirtual 576	java/util/ArrayList:isEmpty	()Z
    //   147: ifne -134 -> 13
    //   150: aload_0
    //   151: getfield 161	achg:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   154: invokevirtual 496	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 501	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   162: aload 7
    //   164: invokevirtual 507	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   167: astore 7
    //   169: aload 7
    //   171: invokeinterface 346 1 0
    //   176: ifeq +47 -> 223
    //   179: aload 7
    //   181: invokeinterface 350 1 0
    //   186: checkcast 237	com/tencent/mobileqq/data/MayKnowRecommend
    //   189: astore 8
    //   191: aload 8
    //   193: ifnull -24 -> 169
    //   196: aload_0
    //   197: aload 8
    //   199: invokevirtual 1320	achg:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   202: pop
    //   203: goto -34 -> 169
    //   206: astore 7
    //   208: ldc_w 309
    //   211: iconst_1
    //   212: ldc_w 1322
    //   215: invokestatic 1231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_1
    //   219: invokevirtual 519	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   222: return
    //   223: aload_1
    //   224: invokevirtual 525	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   227: aload_1
    //   228: invokevirtual 519	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   231: return
    //   232: astore 7
    //   234: aload_1
    //   235: invokevirtual 519	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   238: aload 7
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	achg
    //   0	241	1	paramList	List<String>
    //   0	241	2	paramLong1	long
    //   0	241	4	paramLong2	long
    //   0	241	6	paramBoolean	boolean
    //   21	159	7	localObject1	Object
    //   206	1	7	localThrowable	Throwable
    //   232	7	7	localObject2	Object
    //   26	172	8	localObject3	Object
    //   38	13	9	localIterator	Iterator
    //   60	71	10	localMayKnowRecommend	MayKnowRecommend
    // Exception table:
    //   from	to	target	type
    //   31	40	116	finally
    //   40	62	116	finally
    //   67	81	116	finally
    //   86	113	116	finally
    //   117	120	116	finally
    //   122	136	116	finally
    //   139	142	116	finally
    //   158	169	206	java/lang/Throwable
    //   169	191	206	java/lang/Throwable
    //   196	203	206	java/lang/Throwable
    //   223	227	206	java/lang/Throwable
    //   158	169	232	finally
    //   169	191	232	finally
    //   196	203	232	finally
    //   208	218	232	finally
    //   223	227	232	finally
  }
  
  public void a(boolean paramBoolean, ArrayList<MayKnowRecommend> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle, List<oidb_0xc26.TabInfo> paramList, byte[] arg9)
  {
    if (!paramBoolean)
    {
      QLog.i("MayknowRecommendManager", 1, "handleReqMayknownFriendList, isSuc is false");
      return;
    }
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    dG(paramArrayList);
    cJO();
    iT(paramList);
    j(23, ???);
    if (paramBundle != null)
    {
      paramList = new ArrayList();
      synchronized (cs)
      {
        Iterator localIterator = this.tg.iterator();
        while (localIterator.hasNext())
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
          if (localMayKnowRecommend != null) {
            paramList.add(localMayKnowRecommend.uin);
          }
        }
      }
      if (!paramList.isEmpty())
      {
        i = 0;
        paramBundle = paramBundle.getString("from", "");
        if (!"fetch".equals(paramBundle)) {
          break label391;
        }
        i = 3;
        ContactReportUtils.b(this.mApp, i, paramList);
      }
    }
    boolean bool;
    if (paramInt2 != 0)
    {
      bool = true;
      label186:
      localEditor.putBoolean("sp_mayknow_entry_is_up", bool);
      if (paramInt3 != 1) {
        break label414;
      }
      bool = true;
      label208:
      localEditor.putBoolean("sp_mayknow_ml_s_a_vl", bool);
      if (paramInt4 != 1) {
        break label420;
      }
      bool = true;
      label230:
      localEditor.putBoolean("sp_mayknow_addpage_s_a_vl", bool);
      localEditor.commit();
      if (paramInt3 != 1) {
        break label426;
      }
      bool = true;
      label260:
      this.bIe = bool;
      if (paramInt4 != 1) {
        break label432;
      }
      bool = true;
      label275:
      this.bnF = bool;
      if (paramBoolean)
      {
        this.bId = true;
        if (this.bIe) {
          this.bId = false;
        }
      }
      if (paramArrayList != null) {
        break label438;
      }
    }
    label391:
    label414:
    label420:
    label426:
    label432:
    label438:
    for (int i = 0;; i = paramArrayList.size())
    {
      QLog.i("MayknowRecommendManager", 1, "handleReqMayknownFriendList, isSuc = " + paramBoolean + ",dataSize=" + i + ",timestamp=" + paramInt1 + ",isMsgUp=" + paramInt2 + ",msgTabListSwitch=" + paramInt3 + ",addPageListSwitch=" + paramInt4);
      return;
      if (!"push".equals(paramBundle)) {
        break;
      }
      i = 2;
      break;
      bool = false;
      break label186;
      bool = false;
      break label208;
      bool = false;
      break label230;
      bool = false;
      break label260;
      bool = false;
      break label275;
    }
  }
  
  protected boolean a(Entity paramEntity)
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
    QLog.d("MayknowRecommendManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    Object localObject2;
    Object localObject3;
    MayKnowRecommend localMayKnowRecommend;
    if (paramBoolean)
    {
      paramList = e(new ArrayList(paramList));
      localObject2 = new ArrayList(2);
      ??? = paramList.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (MayKnowRecommend)((Iterator)???).next();
        if (localObject3 != null)
        {
          ((MayKnowRecommend)localObject3).cardDisplayTimestamp = NetConnInfoCenter.getServerTimeMillis();
          ((List)localObject2).add(((MayKnowRecommend)localObject3).uin);
        }
      }
      synchronized (cs)
      {
        if ((paramList.size() <= 0) || (this.tg.size() + paramList.size() >= 1000)) {
          break label436;
        }
        localObject3 = this.tg.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject3).next();
          if ((localMayKnowRecommend != null) && (((List)localObject2).contains(localMayKnowRecommend.uin))) {
            ((Iterator)localObject3).remove();
          }
        }
      }
      this.tg.addAll(0, paramList);
    }
    label436:
    for (paramList = new LinkedList(this.tg);; paramList = null)
    {
      localObject2 = new ArrayList();
      synchronized (cs)
      {
        localObject3 = this.tg.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject3).next();
          if (localMayKnowRecommend != null) {
            ((ArrayList)localObject2).add(localMayKnowRecommend.uin);
          }
        }
      }
      if (!((ArrayList)localObject2).isEmpty()) {
        ContactReportUtils.b(this.mApp, 1, (ArrayList)localObject2);
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        ??? = this.em.getTransaction();
        try
        {
          ((EntityTransaction)???).begin();
          this.em.execSQL("delete from MayKnowRecommend where tabID=23");
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject2 = (MayKnowRecommend)paramList.next();
            if (localObject2 != null)
            {
              ((MayKnowRecommend)localObject2).setStatus(1000);
              a((Entity)localObject2);
            }
          }
          return false;
        }
        catch (Exception paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "handleMayKnowPushAdd ex", paramList);
          }
          return false;
          ((EntityTransaction)???).commit();
          return true;
        }
        finally
        {
          ((EntityTransaction)???).end();
        }
      }
    }
  }
  
  public boolean aaC()
  {
    if (!this.bIi)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.mApp.getManager(11);
      if ((localPhoneContactManagerImp == null) || (localPhoneContactManagerImp.xy() < 9)) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      this.bIh = bool;
      this.bIi = true;
      return this.bIh;
    }
  }
  
  public boolean aaD()
  {
    boolean bool = true;
    if (this.cwn != 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "shouldShowRecommendTroop result: " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean aaE()
  {
    boolean bool1 = aaD();
    boolean bool2 = anwa.aze();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, String.format("shouldShowRecommendTroopInConversation, showRecommendTroop: %s, isStudyMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (!bool2);
  }
  
  public boolean aaF()
  {
    boolean bool1 = kl("sp_mayknow_entry_list_msg");
    boolean bool2 = anwa.aze();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, String.format("shouldShowConversationMayKnow, mayKnowListSwitch: %s, isStudyMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (!bool2);
  }
  
  public boolean aaG()
  {
    boolean bool1 = kl("sp_mayknow_entry_list_new");
    boolean bool2 = anwa.aze();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, String.format("shouldShowMayKnowInNewFriend, mayKnowListSwitch: %s, isStudyMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (!bool2);
  }
  
  public boolean ag(List<RecentBaseData> paramList)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData");
    }
    boolean bool1;
    Object localObject;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = kl("sp_mayknow_entry_list_msg");
      boolean bool3 = kl("sp_mayknow_entry_is_up");
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData showConversationMayKnow = " + bool1 + ",shouldRiseUp = " + bool3);
      }
      if ((bool1) && (bool3))
      {
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (RecentBaseData)localIterator.next();
            if ((localObject instanceof RecentItemMayKnowFriendData))
            {
              localObject = (RecentItemMayKnowFriendData)localObject;
              localIterator.remove();
              if (localObject != null)
              {
                localIterator = paramList.iterator();
                int i = 0;
                label208:
                while (localIterator.hasNext())
                {
                  if ((((RecentBaseData)localIterator.next()).mMenuFlag & 0xF0) != 32) {
                    break label579;
                  }
                  i += 1;
                }
                int j = paramList.size();
                int k = a(paramList, i, j);
                paramList.add(k, localObject);
                if (QLog.isColorLevel()) {
                  QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData insertIndex = " + k + ",setTopItemCount = " + i + ",listsize = " + j);
                }
                long l1 = NetConnInfoCenter.getServerTime();
                if (((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime < l1) {
                  ((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime = l1;
                }
                if (k > 0)
                {
                  paramList = (RecentBaseData)paramList.get(k - 1);
                  if ((paramList.mMenuFlag & 0xF0) != 32) {
                    break;
                  }
                }
                else
                {
                  label352:
                  if (QLog.isColorLevel()) {
                    QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData insertIndex = " + k + ",setTopItemCount = " + i + ",listsize = " + j + ",lastmsgtime = " + ((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime);
                  }
                  this.mApp.a().a().e(((RecentItemMayKnowFriendData)localObject).mUser);
                  this.mPreferences.edit().putBoolean("sp_mayknow_entry_is_up", false);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData result = " + bool1);
      }
      return bool1;
      if ((!(paramList instanceof RecentUserBaseData)) || (((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime <= ((RecentUserBaseData)paramList).mUser.lastmsgtime)) {
        break label352;
      }
      ((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime = (((RecentUserBaseData)paramList).mUser.lastmsgtime - 1L);
      break label352;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData mayKnowFriendData is null ");
        bool1 = bool2;
        continue;
        label579:
        break label208;
        localObject = null;
        break;
        bool1 = true;
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage entryType = " + paramInt1 + " tabID=" + paramInt2);
    }
    this.r.post(new MayknowRecommendManager.5(this, paramInt2, paramInt1, paramBundle));
  }
  
  public void b(View paramView, Context paramContext, String paramString)
  {
    int i = paramView.getId();
    if ((paramString.equals("sp_uin_for_title")) && (i == 2131376924))
    {
      paramView = ausj.b(paramContext);
      paramView.addButton(2131692270);
      paramView.addCancelButton(2131721058);
      paramView.a(new achi(this, paramView));
      paramView.show();
      anot.a(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_ellipsis", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return;
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof aaky.a)))
      {
        paramView = (aaky.a)paramView.getTag();
        if (paramView.a == null) {
          break;
        }
        if ((paramView.a.mUser != null) && ((paramView.a.mUser.extraInfo instanceof RecentRecommendTroopItem))) {}
        for (paramView = (RecentRecommendTroopItem)paramView.a.mUser.extraInfo; paramView != null; paramView = null)
        {
          Object localObject;
          if (i == 2131363896)
          {
            paramString = "mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=" + paramView.uin + "&subsource_id=10017";
            localObject = new Intent(paramContext, JoinGroupTransitActivity.class);
            ((Intent)localObject).putExtra("source_scheme", paramString);
            paramContext.startActivity((Intent)localObject);
            anot.a(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_add", 0, 0, paramView.uin, paramView.recomAlgol, "", "");
            return;
          }
          paramString = new GroupInfo();
          for (;;)
          {
            try
            {
              paramString.lCode = Long.valueOf(paramView.uin).longValue();
              paramString.strName = paramView.name;
              if (TextUtils.isEmpty(paramView.recommendReason))
              {
                paramString.strIntro = paramView.intro;
                paramString.iMemberCnt = paramView.memberNum;
                localObject = joa.a(paramView);
                if (localObject != null) {
                  paramString.labels = ((ArrayList)localObject);
                }
                paramString.strJoinSig = paramView.authSig;
                apuh.a(paramContext, apuh.a(107, paramString, 10018, false), 2);
                anot.a(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_grp", 0, 0, paramView.uin, paramView.recomAlgol, "", "");
                return;
              }
            }
            catch (Exception paramView)
            {
              QLog.d("MayknowRecommendManager", 1, "cast string2long error");
              return;
            }
            paramString.strIntro = paramView.recommendReason;
          }
        }
      }
    }
  }
  
  public void b(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (ct)
    {
      if ((!this.bIc) || (this.bIb)) {
        return;
      }
      paramMayKnowRecommend = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
      if (this.eb.containsKey(paramMayKnowRecommend))
      {
        paramMayKnowRecommend = (MayKnowExposure)this.eb.get(paramMayKnowRecommend);
        if ((paramInt3 == 1) && (paramMayKnowRecommend.startExploseTime != 0L))
        {
          paramMayKnowRecommend.exposeTime = ((int)(SystemClock.uptimeMillis() - paramMayKnowRecommend.startExploseTime + paramMayKnowRecommend.exposeTime));
          paramMayKnowRecommend.exposeCnt += 1;
          paramMayKnowRecommend.startExploseTime = 0L;
          return;
        }
      }
    }
  }
  
  public boolean b(boolean paramBoolean, List<String> arg2)
  {
    if ((??? == null) || (???.isEmpty())) {
      return false;
    }
    if (paramBoolean)
    {
      LinkedList localLinkedList = new LinkedList();
      Object localObject4;
      MayKnowRecommend localMayKnowRecommend;
      synchronized (cs)
      {
        localObject4 = this.tg.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject4).next();
          if ((localMayKnowRecommend != null) && (???.contains(localMayKnowRecommend.uin)))
          {
            localLinkedList.add(localMayKnowRecommend);
            ((Iterator)localObject4).remove();
          }
        }
      }
      ??? = new ArrayList();
      synchronized (cs)
      {
        localObject4 = this.tg.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject4).next();
          if (localMayKnowRecommend != null) {
            ((ArrayList)???).add(localMayKnowRecommend.uin);
          }
        }
      }
      if (!((ArrayList)???).isEmpty()) {
        ContactReportUtils.b(this.mApp, 1, (ArrayList)???);
      }
      if (!localObject1.isEmpty())
      {
        ??? = this.em.getTransaction();
        try
        {
          ???.begin();
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            ??? = (MayKnowRecommend)localIterator.next();
            if (??? != null)
            {
              localObject4 = ((MayKnowRecommend)???).uin;
              this.em.remove((Entity)???, "uin=?", new String[] { localObject4 });
            }
          }
          return false;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "handleMayKnowPushDel ex", localException);
          }
          return false;
          ???.commit();
          return true;
        }
        finally
        {
          ???.end();
        }
      }
    }
  }
  
  public void bG(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeMayKnowRecommend, uin=" + paramString);
    }
    for (;;)
    {
      yrh localyrh;
      int i;
      for (;;)
      {
        synchronized (cs)
        {
          ??? = this.tg.iterator();
          if (!((Iterator)???).hasNext()) {
            break label431;
          }
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)???).next();
          if (!localMayKnowRecommend.uin.equals(paramString)) {
            break;
          }
          ((Iterator)???).remove();
          if ((paramBoolean) && (localMayKnowRecommend != null)) {
            this.em.remove(localMayKnowRecommend);
          }
          cJN();
          if ((this.iP == null) || (this.ti == null)) {
            break label340;
          }
          synchronized (this.ti)
          {
            if (this.ti == null) {
              break label337;
            }
            Iterator localIterator = this.ti.iterator();
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label337;
              }
              localyrh = (yrh)localIterator.next();
              label218:
              label223:
              synchronized (this.cw)
              {
                if (localyrh.tab_id != 23) {
                  break label253;
                }
                if (localMayKnowRecommend != null)
                {
                  if (localyrh.caI <= 0) {
                    break;
                  }
                  i = localyrh.caI - 1;
                  localyrh.caI = i;
                }
              }
            }
          }
        }
        i = 0;
        break label218;
        label253:
        Object localObject3 = (ArrayList)this.iP.get(Integer.valueOf(localyrh.tab_id));
        if (localObject3 != null)
        {
          localObject3 = ((ArrayList)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            if (!((MayKnowRecommend)((Iterator)localObject3).next()).uin.equals(paramString)) {
              break label223;
            }
            ((Iterator)localObject3).remove();
            localyrh.caI -= 1;
          }
        }
      }
      label337:
      label340:
      iU(this.ti);
      if (paramBoolean) {}
      try
      {
        if (this.em.isOpen())
        {
          paramString = "delete from MayKnowRecommend where uin=" + paramString;
          this.em.execSQL(paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("MayknowRecommendManager", 2, "removeConnectionPerson, " + paramString.toString());
        return;
      }
      label431:
      MayKnowRecommend localMayKnowRecommend = null;
    }
  }
  
  public void cJI()
  {
    boolean bool = true;
    aeim.a locala = aeim.a();
    if (locala != null)
    {
      this.cwq = locala.pollInterval;
      this.box = locala.jumpUrl;
      if (locala.cNd != 1) {
        break label102;
      }
    }
    for (;;)
    {
      this.bIf = bool;
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "updateRecommendTroopConfig, mContactsTabRecommendTroopPollInterval=" + this.cwq + ",contactsTabRecommendTroopJumpUrl=" + this.box + ",showRecommendTroopWhenSearchEmpty=" + this.bIf);
      }
      return;
      label102:
      bool = false;
    }
  }
  
  public void cJM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeConnectionsDataExceptRecommendTab ");
    }
    cJN();
    if (this.ti != null)
    {
      Iterator localIterator = this.ti.iterator();
      while (localIterator.hasNext())
      {
        yrh localyrh = (yrh)localIterator.next();
        if (localyrh.tab_id != 23)
        {
          a(localyrh.tab_id, new ArrayList(0), true);
          j(localyrh.tab_id, null);
        }
      }
    }
  }
  
  public void cJP()
  {
    boolean bool = kl("sp_mayknow_entry_list_msg");
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "prepareConversationTabRecommendTroopList troopItems size: " + this.tH.size() + " switch open: " + bool);
    }
    Object localObject4 = new ArrayList();
    label404:
    label405:
    for (;;)
    {
      synchronized (this.tH)
      {
        ((List)localObject4).addAll(this.tH);
        if ((localObject4 != null) && (!((List)localObject4).isEmpty()) && (bool))
        {
          acxw localacxw = this.mApp.a().a();
          localacxw.Jn(8112);
          ??? = localacxw.b(acbn.bld, 8111);
          if (??? != null) {
            localacxw.f((RecentUser)???);
          }
          localacxw.Jn(8113);
          Object localObject2 = localacxw.b("sp_uin_for_title", 8113);
          ??? = localObject2;
          if (localObject2 == null) {
            ??? = new RecentUser("sp_uin_for_title", 8113);
          }
          long l1 = -1L - 1L;
          ((RecentUser)???).lastmsgtime = l1;
          ((RecentUser)???).lastmsgdrafttime = -500L;
          ((RecentUser)???).opTime = -500L;
          localacxw.e((RecentUser)???);
          Iterator localIterator = ((List)localObject4).iterator();
          if (!localIterator.hasNext()) {
            break label404;
          }
          RecentRecommendTroopItem localRecentRecommendTroopItem = (RecentRecommendTroopItem)localIterator.next();
          ??? = localacxw.b(localRecentRecommendTroopItem.uin, 8113);
          if (??? != null) {
            break label405;
          }
          ??? = new RecentUser(localRecentRecommendTroopItem.uin, 8113);
          localObject4 = localRecentRecommendTroopItem.name;
          localObject2 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject2 = localRecentRecommendTroopItem.uin;
          }
          ((RecentUser)???).displayName = ((String)localObject2);
          ((RecentUser)???).extraInfo = localRecentRecommendTroopItem;
          l1 -= 1L;
          ((RecentUser)???).lastmsgtime = l1;
          ((RecentUser)???).lastmsgdrafttime = -500L;
          ((RecentUser)???).opTime = -500L;
          localacxw.e((RecentUser)???);
        }
      }
      this.mApp.a().a().Jn(8113);
      return;
    }
  }
  
  public void cJQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "prepareConversationMayKnowRecenUser ，conversationTabDisplayAsVerticalListItem = " + this.bIe);
    }
    if ((!kl("sp_mayknow_entry_list_msg")) || (this.cwn != 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "prepareConversationMayKnowRecenUser hideConversationMayKnow  return ");
      }
    }
    Object localObject2;
    do
    {
      return;
      localObject2 = cw();
    } while ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0));
    acxw localacxw = this.mApp.a().a();
    Jn(8113);
    Object localObject1;
    RecentUser localRecentUser;
    long l1;
    MayKnowRecommend localMayKnowRecommend;
    if (this.bIe)
    {
      localObject1 = localacxw.b(acbn.bld, 8111);
      if (localObject1 != null) {
        localacxw.f((RecentUser)localObject1);
      }
      Jn(8112);
      localRecentUser = localacxw.b("sp_uin_for_title", 8112);
      localObject1 = localRecentUser;
      if (localRecentUser == null) {
        localObject1 = new RecentUser("sp_uin_for_title", 8112);
      }
      l1 = 0L - 1L;
      ((RecentUser)localObject1).lastmsgtime = l1;
      ((RecentUser)localObject1).lastmsgdrafttime = -500L;
      ((RecentUser)localObject1).opTime = -500L;
      localacxw.e((RecentUser)localObject1);
      Iterator localIterator = ((ArrayList)localObject2).iterator();
      if (!localIterator.hasNext()) {
        break label462;
      }
      localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
      localRecentUser = localacxw.b(localMayKnowRecommend.uin, 8112);
      if (localRecentUser != null) {
        break label479;
      }
      localRecentUser = new RecentUser(localMayKnowRecommend.uin, 8112);
    }
    label462:
    label479:
    for (;;)
    {
      localObject2 = localMayKnowRecommend.remark;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = localMayKnowRecommend.mobile_name;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localMayKnowRecommend.nick;
        }
      }
      localRecentUser.displayName = ((String)localObject1);
      localRecentUser.extraInfo = localMayKnowRecommend;
      l1 -= 1L;
      localRecentUser.lastmsgtime = l1;
      localRecentUser.lastmsgdrafttime = -500L;
      localRecentUser.opTime = -500L;
      localacxw.e(localRecentUser);
      break;
      Jn(8112);
      localRecentUser = localacxw.b(acbn.bld, 8111);
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "prepareConversationMayKnowRecenUser mayKnowRecommends.size = " + ((ArrayList)localObject2).size() + ",ru = " + localRecentUser);
      }
      localObject1 = localRecentUser;
      if (localRecentUser == null) {
        localObject1 = new RecentUser(acbn.bld, 8111);
      }
      localacxw.e((RecentUser)localObject1);
      ((LoginWelcomeManager)this.mApp.getManager(146)).duY();
      return;
    }
  }
  
  public void cJR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeConversationMayKnowRecentUser  ，conversationTabDisplayAsVerticalListItem = " + this.bIe);
    }
    acxw localacxw = this.mApp.a().a();
    Jn(8112);
    RecentUser localRecentUser = localacxw.b(acbn.bld, 8111);
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeConversationMayKnowRecentUser ,ru = " + localRecentUser);
    }
    if (localRecentUser != null) {
      localacxw.f(localRecentUser);
    }
    ((LoginWelcomeManager)this.mApp.getManager(146)).duX();
  }
  
  public void cJT()
  {
    if ((this.eb == null) || (this.em == null)) {}
    for (;;)
    {
      return;
      Object localObject4 = null;
      EntityTransaction localEntityTransaction = null;
      Object localObject2 = localEntityTransaction;
      Object localObject1 = localObject4;
      try
      {
        Iterator localIterator = this.eb.entrySet().iterator();
        localObject2 = localEntityTransaction;
        localObject1 = localObject4;
        localEntityTransaction = this.em.getTransaction();
        localObject2 = localEntityTransaction;
        localObject1 = localEntityTransaction;
        localEntityTransaction.begin();
        for (;;)
        {
          localObject2 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          localObject4 = (MayKnowExposure)((Map.Entry)localIterator.next()).getValue();
          localObject2 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          if (((MayKnowExposure)localObject4).exposeCnt > 0)
          {
            localObject2 = localEntityTransaction;
            localObject1 = localEntityTransaction;
            a((Entity)localObject4);
          }
        }
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject2;
          QLog.e("MayknowRecommendManager", 2, "saveExplosures", localException);
        }
        return;
        localObject2 = localException;
        localObject1 = localException;
        localException.commit();
        localObject2 = localException;
        localObject1 = localException;
        if (QLog.isColorLevel())
        {
          localObject2 = localException;
          localObject1 = localException;
          QLog.d("MayknowRecommendManager", 2, "saveExplosures count = " + this.eb.size());
        }
        localObject2 = localException;
        localObject1 = localException;
        localObject4 = ct;
        localObject2 = localException;
        localObject1 = localException;
        try
        {
          if (this.eb != null) {
            this.eb.clear();
          }
          if (localException == null) {
            continue;
          }
          localException.end();
          return;
        }
        finally
        {
          localObject2 = localException;
          localObject1 = localException;
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((EntityTransaction)localObject1).end();
        }
      }
    }
  }
  
  public void cJU()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 1, "turnOffSPMsgTabEntrySwitchState");
    }
    this.mPreferences.edit().putBoolean("sp_mayknow_entry_list_msg", false).commit();
  }
  
  public void cJV()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onConversationTabRecommendTroopHided");
    }
    this.mApp.a().a().Jn(8113);
    Object localObject = this.mPreferences.edit();
    ((SharedPreferences.Editor)localObject).putBoolean("sp_mayknow_entry_list_msg", false);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = (FriendListHandler)this.mApp.getBusinessHandler(1);
    ((FriendListHandler)localObject).notifyUI(92, true, null);
    ((FriendListHandler)localObject).cIQ();
  }
  
  public void cJW()
  {
    this.PS = 0L;
  }
  
  public void cb(int paramInt, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramString != null)
        {
          int i = Integer.valueOf(paramString.optString("reportInterval").trim()).intValue();
          if ((i <= 86400000) && (i > 0)) {
            PR = i;
          }
          i = Integer.valueOf(paramString.optString("showCount").trim()).intValue();
          if ((i > 0) && (i <= 100)) {
            cwk = i;
          }
          i = Integer.valueOf(paramString.optString("totalCount").trim()).intValue();
          if ((i <= 100) && (i > 0)) {
            cwl = i;
          }
          i = Integer.valueOf(paramString.optString("newfriendCount")).intValue();
          if (i > 0) {
            cwm = i;
          }
          this.mPreferences.edit().putLong("sp_report_interval", PR).commit();
          this.mPreferences.edit().putInt("sp_config_showcount", cwk).commit();
          this.mPreferences.edit().putInt("sp_config_expectcount", cwl).commit();
          this.mPreferences.edit().putInt("sp_config_newfriendcount", cwm).commit();
          this.mPreferences.edit().putInt("sp_config_version", paramInt).commit();
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MayknowRecommendManager", 2, "updateConfigs error " + paramString.getMessage());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "timeInterval = " + PR + ",showCount=" + cwk + ",expectCount=" + cwl + ",newfriendCount=" + cwm);
    }
  }
  
  public ArrayList<yrh> cu()
  {
    ArrayList localArrayList = new ArrayList();
    cJN();
    for (;;)
    {
      boolean bool;
      yrh localyrh;
      synchronized (this.cu)
      {
        if (this.ti == null) {
          break;
        }
        bool = Uk();
        Iterator localIterator = this.ti.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localyrh = yrh.a((yrh)localIterator.next());
        if (localyrh.tab_id == 23)
        {
          localyrh.boq = true;
          localArrayList.add(localyrh);
        }
      }
      localyrh.boq = bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "getConnectionsTabInfoList " + localArrayList1.toString());
    }
    return localArrayList1;
  }
  
  public ArrayList<String> cv()
  {
    int i = 0;
    cJN();
    ArrayList localArrayList = new ArrayList(4);
    Object localObject3 = null;
    Object localObject4 = this.cu;
    Object localObject1 = localObject3;
    try
    {
      if (this.ti != null)
      {
        localObject1 = localObject3;
        if (!this.ti.isEmpty()) {
          localObject1 = (yrh)this.ti.get(0);
        }
      }
      if (localObject1 != null)
      {
        localObject1 = q(((yrh)localObject1).tab_id);
        if (localObject1 != null) {
          while ((i < ((ArrayList)localObject1).size()) && (i < 4))
          {
            localArrayList.add(((MayKnowRecommend)((ArrayList)localObject1).get(i)).uin);
            i += 1;
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label160;
      }
    }
    finally {}
    QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonUinListFroAddActivity " + localArrayList.toString());
    label160:
    return localArrayList;
  }
  
  public ArrayList<MayKnowRecommend> cw()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (cs)
    {
      localArrayList.addAll(this.tg);
      return localArrayList;
    }
  }
  
  /* Error */
  public void dG(@NonNull ArrayList<MayKnowRecommend> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 576	java/util/ArrayList:isEmpty	()Z
    //   8: ifeq +30 -> 38
    //   11: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +23 -> 37
    //   17: ldc_w 309
    //   20: iconst_2
    //   21: invokestatic 1760	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   24: ldc_w 1762
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 1765	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokestatic 391	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 487	achg:e	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   43: astore 4
    //   45: aload 4
    //   47: astore_3
    //   48: aload 4
    //   50: invokeinterface 370 1 0
    //   55: sipush 1000
    //   58: if_icmple +15 -> 73
    //   61: aload 4
    //   63: iconst_0
    //   64: sipush 1000
    //   67: invokeinterface 1769 3 0
    //   72: astore_3
    //   73: getstatic 79	achg:cs	Ljava/lang/Object;
    //   76: astore 4
    //   78: aload 4
    //   80: monitorenter
    //   81: aload_0
    //   82: getfield 172	achg:tg	Ljava/util/ArrayList;
    //   85: invokevirtual 1024	java/util/ArrayList:clear	()V
    //   88: aload_0
    //   89: getfield 172	achg:tg	Ljava/util/ArrayList;
    //   92: aload_3
    //   93: invokevirtual 492	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   96: pop
    //   97: aload 4
    //   99: monitorexit
    //   100: aload_0
    //   101: getfield 161	achg:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   104: invokevirtual 496	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   107: astore 4
    //   109: aload 4
    //   111: invokevirtual 501	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   114: aload_0
    //   115: getfield 161	achg:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   118: ldc_w 906
    //   121: invokevirtual 506	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   124: pop
    //   125: aload_3
    //   126: invokeinterface 370 1 0
    //   131: ifle +147 -> 278
    //   134: aload_3
    //   135: invokeinterface 341 1 0
    //   140: astore_3
    //   141: aload_3
    //   142: invokeinterface 346 1 0
    //   147: ifeq +131 -> 278
    //   150: aload_0
    //   151: aload_3
    //   152: invokeinterface 350 1 0
    //   157: checkcast 237	com/tencent/mobileqq/data/MayKnowRecommend
    //   160: invokevirtual 1320	achg:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   163: pop
    //   164: goto -23 -> 141
    //   167: astore_3
    //   168: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +14 -> 185
    //   174: ldc_w 309
    //   177: iconst_2
    //   178: ldc_w 1771
    //   181: aload_3
    //   182: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload 4
    //   187: invokevirtual 519	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   190: iconst_0
    //   191: istore_2
    //   192: aload_0
    //   193: getfield 129	achg:cw	Ljava/lang/Object;
    //   196: astore_3
    //   197: aload_3
    //   198: monitorenter
    //   199: aload_0
    //   200: getfield 116	achg:iP	Ljava/util/HashMap;
    //   203: ifnull +10 -> 213
    //   206: aload_0
    //   207: getfield 116	achg:iP	Ljava/util/HashMap;
    //   210: invokevirtual 1772	java/util/HashMap:clear	()V
    //   213: aload_3
    //   214: monitorexit
    //   215: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -181 -> 37
    //   221: ldc_w 309
    //   224: iconst_2
    //   225: invokestatic 1760	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   228: ldc_w 1774
    //   231: iconst_3
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload_1
    //   238: invokevirtual 488	java/util/ArrayList:size	()I
    //   241: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: aload_0
    //   248: getfield 172	achg:tg	Ljava/util/ArrayList;
    //   251: invokevirtual 488	java/util/ArrayList:size	()I
    //   254: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_2
    //   260: iload_2
    //   261: invokestatic 1415	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   264: aastore
    //   265: invokestatic 1765	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   268: invokestatic 391	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: return
    //   272: astore_1
    //   273: aload 4
    //   275: monitorexit
    //   276: aload_1
    //   277: athrow
    //   278: aload 4
    //   280: invokevirtual 525	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   283: aload 4
    //   285: invokevirtual 519	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   288: iconst_1
    //   289: istore_2
    //   290: goto -98 -> 192
    //   293: astore_1
    //   294: aload 4
    //   296: invokevirtual 519	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   299: aload_1
    //   300: athrow
    //   301: astore_1
    //   302: aload_3
    //   303: monitorexit
    //   304: aload_1
    //   305: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	achg
    //   0	306	1	paramArrayList	ArrayList<MayKnowRecommend>
    //   191	99	2	bool	boolean
    //   47	105	3	localObject1	Object
    //   167	15	3	localException	Exception
    //   43	252	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   109	141	167	java/lang/Exception
    //   141	164	167	java/lang/Exception
    //   278	283	167	java/lang/Exception
    //   81	100	272	finally
    //   273	276	272	finally
    //   109	141	293	finally
    //   141	164	293	finally
    //   168	185	293	finally
    //   278	283	293	finally
    //   199	213	301	finally
    //   213	215	301	finally
    //   302	304	301	finally
  }
  
  public boolean e(int paramInt, Bundle paramBundle)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "getMayKnowRecommendRemote entryType = " + paramInt);
    }
    if (!iv(paramInt))
    {
      QLog.i("MayknowRecommendManager", 1, String.format("getMayKnowRecommendRemote, isTimeToObtainRemote is false, entryType = " + paramInt, new Object[0]));
      if (!this.mPreferences.getBoolean("sp_mayknow_818_first_install", true)) {
        return bool;
      }
      this.mPreferences.edit().putBoolean("sp_mayknow_818_first_install", false).commit();
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "getMayKnowRecommendRemote is818FirstInstall");
      }
    }
    this.r.post(new MayknowRecommendManager.6(this, paramInt, paramBundle));
    bool = true;
    return bool;
  }
  
  public int gx(int paramInt)
  {
    int i = 1;
    ArrayList localArrayList = q(paramInt);
    int j = i;
    if (localArrayList != null)
    {
      j = i;
      if (localArrayList.size() > 0)
      {
        paramInt = ((MayKnowRecommend)localArrayList.get(0)).timestamp;
        int k = localArrayList.size();
        i = 1;
        j = paramInt;
        if (i < k)
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localArrayList.get(i);
          if (localMayKnowRecommend.timestamp >= paramInt) {
            break label91;
          }
          paramInt = localMayKnowRecommend.timestamp;
        }
      }
    }
    label91:
    for (;;)
    {
      i += 1;
      break;
      return j;
    }
  }
  
  public void iV(List<Integer> paramList)
  {
    boolean bool1 = paramList.contains(Integer.valueOf(1));
    boolean bool2 = paramList.contains(Integer.valueOf(2));
    boolean bool3 = paramList.contains(Integer.valueOf(3));
    boolean bool4 = paramList.contains(Integer.valueOf(4));
    boolean bool5 = paramList.contains(Integer.valueOf(5));
    paramList = this.mPreferences.edit();
    paramList.putBoolean("sp_mayknow_entry_list_msg", bool1);
    paramList.putBoolean("sp_mayknow_entry_list_head", bool2);
    paramList.putBoolean("sp_mayknow_entry_list_recommend", bool3);
    paramList.putBoolean("sp_mayknow_entry_list_new", bool4);
    paramList.putBoolean("sp_mayknow_entry_list_add", bool5);
    paramList.commit();
    QLog.i("MayknowRecommendManager", 1, "saveEntryOpenList,MsgEntryOpen=" + bool1 + ",HeadEntryOpen=" + bool2 + ", RecommendEntryOpen=" + bool3 + ", NewEntryOpen=" + bool4 + ", EntryAdd=" + bool5);
  }
  
  public void iW(List<oidb_0xc26.EntryDelay> paramList)
  {
    int n = 0;
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putLong("sp_get_mayknow_timestamp_v3_for_card_header", System.currentTimeMillis());
    localEditor.putLong("sp_get_mayknow_timestamp_v2", System.currentTimeMillis());
    int m;
    int k;
    int j;
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      n = 0;
      m = 0;
      k = 0;
      j = 0;
      i = 0;
      if (paramList.hasNext())
      {
        oidb_0xc26.EntryDelay localEntryDelay = (oidb_0xc26.EntryDelay)paramList.next();
        int i1;
        int i2;
        switch (localEntryDelay.em_entry.get())
        {
        default: 
          i1 = n;
          i2 = m;
          n = i;
          m = j;
          j = i2;
          i = i1;
        }
        for (;;)
        {
          i1 = n;
          i2 = m;
          n = i;
          m = j;
          j = i2;
          i = i1;
          break;
          i1 = localEntryDelay.uint32_delay.get();
          i = n;
          n = j;
          j = m;
          m = n;
          n = i1;
          continue;
          i1 = localEntryDelay.uint32_delay.get();
          j = m;
          m = i1;
          i1 = i;
          i = n;
          n = i1;
          continue;
          k = localEntryDelay.uint32_delay.get();
          i1 = j;
          i2 = i;
          i = n;
          j = m;
          m = i1;
          n = i2;
          continue;
          m = localEntryDelay.uint32_delay.get();
          i1 = j;
          i2 = i;
          i = n;
          j = m;
          m = i1;
          n = i2;
          continue;
          i2 = localEntryDelay.uint32_delay.get();
          n = j;
          i1 = i;
          i = i2;
          j = m;
          m = n;
          n = i1;
        }
      }
    }
    for (;;)
    {
      if (i > 0) {
        localEditor.putLong("pull_interval_conversation_tab", i * 1000);
      }
      if (j > 0) {
        localEditor.putLong("pull_interval_contact_head", j * 1000);
      }
      if (k > 0) {
        localEditor.putLong("pull_interval_recommend_tab", k * 1000);
      }
      if (m > 0) {
        localEditor.putLong("pull_interval_new_friend", m * 1000);
      }
      if (n > 0) {
        localEditor.putLong("pull_interval_add_page", n * 1000);
      }
      localEditor.commit();
      QLog.i("MayknowRecommendManager", 1, "saveReqTimeAndIntervalInfo,msgIntervel = " + i + ",headIntervel = " + j + ",recommendIntervel = " + k + ",newIntervel = " + m + ",addIntervel = " + n);
      return;
      m = 0;
      k = 0;
      j = 0;
      i = 0;
    }
  }
  
  public boolean iu(int paramInt)
  {
    return e(paramInt, null);
  }
  
  public boolean iv(int paramInt)
  {
    long l1;
    long l2;
    if (paramInt == 2)
    {
      l1 = this.mPreferences.getLong("sp_get_mayknow_timestamp_v3_for_card_header", 0L);
      l2 = B(paramInt);
      if (Math.abs(l1 - System.currentTimeMillis()) < l2) {
        break label142;
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("MayknowRecommendManager", 1, String.format(new StringBuilder().append("isTimeToObtainRemote, return=").append(bool).append(", lastTime").append(l1).toString(), new Object[0]) + ", pullInternalTime" + l2 + ",entryType = " + paramInt);
      return bool;
      l1 = this.mPreferences.getLong("sp_get_mayknow_timestamp_v2", 0L);
      break;
    }
  }
  
  public boolean kk(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onMsgTabRecommendBItemRemove uin = " + paramString + ",conversationTabDisplayAsVerticalListItem = " + this.bIe);
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bIe)
    {
      acxw localacxw = this.mApp.a().a();
      paramString = localacxw.b(paramString, 8112);
      bool1 = bool2;
      if (paramString != null)
      {
        localacxw.f(paramString);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean kl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool1 = this.mPreferences.getBoolean(paramString, false);; bool1 = false)
    {
      boolean bool3 = bool1;
      if (this.cwn == 1)
      {
        boolean bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!TextUtils.equals(paramString, "sp_mayknow_ml_s_a_vl"))
          {
            bool2 = bool1;
            if (!TextUtils.equals(paramString, "sp_mayknow_addpage_s_a_vl"))
            {
              bool2 = bool1;
              if (this.mApp != null)
              {
                zbq localzbq = (zbq)this.mApp.getManager(295);
                bool2 = bool1;
                if (localzbq != null)
                {
                  bool2 = bool1;
                  if (localzbq.Ve())
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("MayknowRecommendManager", 2, "getSPSwitchState user closed");
                    }
                    bool2 = false;
                  }
                }
              }
            }
          }
        }
        bool3 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("MayknowRecommendManager", 2, "getSPSwitchState name:" + paramString + "  open:" + bool2);
          bool3 = bool2;
        }
      }
      return bool3;
    }
  }
  
  public int lA()
  {
    return this.mPreferences.getInt("sp_config_version", 0);
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.l);
    cJT();
    synchronized (this.lock)
    {
      this.bgy = true;
      this.r.removeCallbacksAndMessages(null);
      if ((this.mApp.iz(11)) && (this.b != null)) {
        ((PhoneContactManagerImp)this.mApp.getManager(11)).b(this.b);
      }
      this.b = null;
      anwa.b(this.a);
      return;
    }
  }
  
  public void onEnterBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onEnterBackground ");
    }
    if (this.r != null)
    {
      this.r.post(new MayknowRecommendManager.13(this));
      ContactReportUtils.cnC();
    }
  }
  
  public ArrayList<MayKnowRecommend> q(int paramInt)
  {
    ArrayList localArrayList;
    if (paramInt == 23)
    {
      localArrayList = cw();
      Jm(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("getConnectionsPersonLocal ").append(paramInt).append(" ");
        if (localArrayList == null)
        {
          ??? = "null";
          QLog.d("MayknowRecommendManager", 2, (String)???);
        }
      }
      else
      {
        return localArrayList;
      }
    }
    else
    {
      Jk(paramInt);
    }
    for (;;)
    {
      synchronized (this.cw)
      {
        if (this.iP == null) {
          break label156;
        }
        localArrayList = (ArrayList)this.iP.get(Integer.valueOf(paramInt));
        if (localArrayList == null) {
          break label156;
        }
        localArrayList = new ArrayList(localArrayList);
      }
      ??? = localObject1.size() + "";
      break;
      label156:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     achg
 * JD-Core Version:    0.7.0.1
 */