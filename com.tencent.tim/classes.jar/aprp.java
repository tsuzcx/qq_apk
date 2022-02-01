import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr.2;
import com.tencent.mobileqq.troop.utils.TroopAppMgr.3;
import com.tencent.mobileqq.troop.utils.TroopAppMgr.4;
import com.tencent.mobileqq.troop.utils.TroopAppMgr.5;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa1e.oidb_0xa1e.AppClick;
import tencent.im.oidb.cmd0xa1e.oidb_0xa1e.ReqBody;

public class aprp
  implements Manager
{
  private HashSet<Long> bD = new HashSet();
  protected boolean cSf;
  private String cqJ;
  private String cqK;
  protected String cqL;
  @NonNull
  SparseArray<Integer> dH = new SparseArray(10);
  protected SparseArray<aprm> dI = new SparseArray();
  protected final int dVA = 2;
  protected final int dVz = 1;
  acms e;
  final Object lock = new Object();
  QQAppInterface mApp;
  protected Map<String, JSONObject> nL = new ConcurrentHashMap();
  private HashMap<Long, Integer> or = new HashMap();
  private ThreadLocal<SimpleDateFormat> y = new aprq(this);
  
  public aprp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.e = ((acms)paramQQAppInterface.getBusinessHandler(20));
    ebz();
    paramQQAppInterface = new int[2];
    QQAppInterface tmp121_120 = paramQQAppInterface;
    tmp121_120[0] = 0;
    QQAppInterface tmp125_121 = tmp121_120;
    tmp125_121[1] = 32;
    tmp125_121;
    int j = paramQQAppInterface.length;
    int i = 0;
    while (i < j)
    {
      int k = paramQQAppInterface[i];
      aprm localaprm = new aprm();
      localaprm.cqI = this.mApp.getPreferences().getString("appinfo_date_" + k, "");
      localaprm.timestamp = this.mApp.getPreferences().getInt("KEY_APP_LIST_TIME_STAMP_" + k, 0);
      this.dI.put(k, localaprm);
      i += 1;
    }
    ebD();
    ebA();
    initWhiteList();
    this.cqJ = this.mApp.getPreferences().getString("appid_click_date", null);
    this.cqK = this.mApp.getPreferences().getString("appinfo_all_app_string", acfp.m(2131715545));
  }
  
  private void ebA()
  {
    Object localObject = this.mApp.getPreferences().getString("appid_click_num", null);
    this.dH.clear();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          int j = localJSONObject.optInt("appId");
          int k = localJSONObject.optInt("num");
          this.dH.put(j, Integer.valueOf(k));
          i += 1;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void ebC()
  {
    Calendar localCalendar = Calendar.getInstance();
    this.cqJ = ((SimpleDateFormat)this.y.get()).format(localCalendar.getTime());
    this.mApp.getPreferences().edit().putString("appid_click_date", this.cqJ).commit();
  }
  
  private void ebD()
  {
    if (AppSetting.bs("6.0") < 0) {
      return;
    }
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    synchronized (this.lock)
    {
      Object localObject3 = localEntityManager.query(TroopAIOAppInfo.class);
      Object localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayList();
      }
      localObject1 = ((List)localObject1).listIterator();
      if (((ListIterator)localObject1).hasNext())
      {
        localObject3 = (TroopAIOAppInfo)((ListIterator)localObject1).next();
        aprm localaprm = (aprm)this.dI.get(((TroopAIOAppInfo)localObject3).groupType);
        rom.checkNotNull(localaprm);
        localaprm.a(((TroopAIOAppInfo)localObject3).appid, (TroopAIOAppInfo)localObject3);
      }
    }
    localEntityManager.close();
  }
  
  private void initWhiteList()
  {
    this.bD.add(Long.valueOf(1109863013L));
    this.bD.add(Long.valueOf(1104864066L));
    this.bD.add(Long.valueOf(101786420L));
    this.bD.add(Long.valueOf(101849720L));
    this.bD.add(Long.valueOf(1108961705L));
    this.bD.add(Long.valueOf(1104445552L));
    this.bD.add(Long.valueOf(101846357L));
    this.bD.add(Long.valueOf(1105324038L));
    this.bD.add(Long.valueOf(1103592757L));
    this.bD.add(Long.valueOf(1104536706L));
    this.bD.add(Long.valueOf(1101678813L));
    this.or.put(Long.valueOf(1109863013L), Integer.valueOf(2130851785));
    this.or.put(Long.valueOf(1L), Integer.valueOf(2130851783));
    this.or.put(Long.valueOf(101786420L), Integer.valueOf(2130851786));
    this.or.put(Long.valueOf(101849720L), Integer.valueOf(2130851788));
    this.or.put(Long.valueOf(1108961705L), Integer.valueOf(2130851788));
    this.or.put(Long.valueOf(1104445552L), Integer.valueOf(2130851790));
    this.or.put(Long.valueOf(101846357L), Integer.valueOf(2130851790));
    this.or.put(Long.valueOf(1105324038L), Integer.valueOf(2130851787));
    this.or.put(Long.valueOf(1103592757L), Integer.valueOf(2130851784));
    this.or.put(Long.valueOf(1104536706L), Integer.valueOf(2130851789));
    this.or.put(Long.valueOf(1101678813L), Integer.valueOf(2130851782));
  }
  
  public String BA()
  {
    return this.cqK;
  }
  
  public void G(ArrayList<TroopAIOAppInfo> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    aprm localaprm = (aprm)this.dI.get(paramInt);
    if (localaprm != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (localaprm == null) {
        break;
      }
      synchronized (this.lock)
      {
        Iterator localIterator = paramArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label104;
        }
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
        localaprm.a(localTroopAIOAppInfo.appid, localTroopAIOAppInfo);
      }
    }
    label104:
    ThreadManager.post(new TroopAppMgr.2(this, this.mApp.a().createEntityManager(), paramInt, paramArrayList), 8, null, false);
  }
  
  public void H(ArrayList<TroopAIOAppInfo> paramArrayList, int paramInt)
  {
    ThreadManager.post(new TroopAppMgr.3(this, paramArrayList, this.mApp.a().createEntityManager(), paramInt), 8, null, false);
  }
  
  public void Qx()
  {
    if (this.dH.size() == 0) {
      QLog.d(".troop.troop_app", 2, "clickReport appidNums size == 0");
    }
    do
    {
      return;
      localObject1 = Calendar.getInstance();
    } while (((SimpleDateFormat)this.y.get()).format(((Calendar)localObject1).getTime()).equals(this.cqJ));
    oidb_0xa1e.ReqBody localReqBody = new oidb_0xa1e.ReqBody();
    localReqBody.platform.set(2);
    localReqBody.position.set(1);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.dH;
    int i = 0;
    try
    {
      while (i < this.dH.size())
      {
        int j = this.dH.keyAt(i);
        int k = ((Integer)this.dH.get(j)).intValue();
        oidb_0xa1e.AppClick localAppClick = new oidb_0xa1e.AppClick();
        localAppClick.appid.set(j);
        localAppClick.click_num.set(k);
        localArrayList.add(localAppClick);
        i += 1;
      }
      localReqBody.rpt_app_click.set(localArrayList);
      jnm.a(this.mApp, new aprr(this), localReqBody.toByteArray(), "OidbSvc.0xa1e", 2590, 0);
      return;
    }
    finally {}
  }
  
  public void Se(boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        aprm localaprm = (aprm)this.dI.get(0, null);
        if (localaprm != null) {
          bool = true;
        }
        rom.assertTrue(bool);
        if (localaprm == null) {
          return;
        }
        if (paramBoolean) {
          localaprm.dVy |= 0x2;
        } else {
          localObject.dVy &= 0xFFFFFFFD;
        }
      }
      finally {}
    }
  }
  
  public void TD(String paramString)
  {
    SharedPreferences.Editor localEditor = this.mApp.getPreferences().edit();
    this.cqK = paramString;
    localEditor.putString("appinfo_all_app_string", paramString).commit();
  }
  
  public void WX(int paramInt)
  {
    Object localObject = Calendar.getInstance();
    localObject = ((SimpleDateFormat)this.y.get()).format(((Calendar)localObject).getTime());
    aprm localaprm = (aprm)this.dI.get(paramInt, null);
    if (localaprm != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (localaprm != null) {
        localaprm.cqI = ((String)localObject);
      }
      this.mApp.getPreferences().edit().putString("appinfo_date_" + paramInt, (String)localObject).commit();
      return;
    }
  }
  
  public void WY(int paramInt)
  {
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[2];
    int[] tmp28_26 = arrayOfInt;
    tmp28_26[0] = 0;
    int[] tmp32_28 = tmp28_26;
    tmp32_28[1] = 32;
    tmp32_28;
    if (localEntityManager != null) {}
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        int j = arrayOfInt.length;
        i = 0;
        bool = false;
        if (i < j)
        {
          int k = arrayOfInt[i];
          Object localObject3 = (aprm)this.dI.get(k);
          rom.checkNotNull(localObject3);
          localObject3 = (TroopAIOAppInfo)((aprm)localObject3).iP.get(Integer.valueOf(paramInt));
          if (localObject3 != null)
          {
            localArrayList.add(localObject3);
            ((TroopAIOAppInfo)localObject3).redPoint = false;
            bool = true;
            break label223;
          }
        }
        else
        {
          if (bool) {
            ThreadManager.post(new TroopAppMgr.5(this, localArrayList, localEntityManager), 8, null, false);
          }
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_app", 2, "appid" + paramInt + "clearLocalTroopAppRedPoint," + bool);
          }
          return;
        }
      }
      break label223;
      boolean bool = false;
      continue;
      label223:
      i += 1;
    }
  }
  
  public void aQ(boolean paramBoolean, String paramString)
  {
    try
    {
      this.cSf = paramBoolean;
      this.cqL = paramString;
      return;
    }
    finally {}
  }
  
  public int ae(long paramLong)
  {
    return ((Integer)this.or.get(Long.valueOf(paramLong))).intValue();
  }
  
  public TroopAIOAppInfo b(int paramInt1, int paramInt2)
  {
    Object localObject1 = (aprm)this.dI.get(paramInt2, null);
    if (localObject1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (localObject1 != null) {
        break;
      }
      return null;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        localObject1 = (TroopAIOAppInfo)((aprm)localObject1).iP.get(Integer.valueOf(paramInt1));
        if (localObject1 != null)
        {
          localObject1 = new TroopAIOAppInfo((TroopAIOAppInfo)localObject1);
          return localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public List<TroopAIOAppInfo> b(boolean paramBoolean, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 32)) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (AppSetting.bs("6.0") >= 0) {
        break;
      }
      return Collections.emptyList();
    }
    if (paramBoolean)
    {
      paramBoolean = mi(paramInt);
      this.e.a(1, paramInt, null, paramBoolean);
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.lock)
    {
      Object localObject2 = (aprm)this.dI.get(paramInt);
      rom.checkNotNull(localObject2);
      localObject2 = ((aprm)localObject2).dV().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject2).next();
        if (localTroopAIOAppInfo.isValidTroopApp()) {
          localArrayList.add(localTroopAIOAppInfo);
        }
      }
    }
    return localList;
  }
  
  public boolean b(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    boolean bool2 = false;
    int i = paramTroopAIOAppInfo.appid;
    Object localObject = (aprm)this.dI.get(paramTroopAIOAppInfo.groupType);
    boolean bool1;
    if (localObject != null)
    {
      bool1 = true;
      rom.assertTrue(bool1);
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    do
    {
      return true;
      bool1 = false;
      break;
      localObject = (TroopAIOAppInfo)((aprm)localObject).iP.get(Integer.valueOf(i));
    } while (localObject == null);
    rom.checkNotNull(paramTroopAIOAppInfo.hashVal);
    rom.checkNotNull(((TroopAIOAppInfo)localObject).hashVal);
    if ((TextUtils.equals(paramTroopAIOAppInfo.hashVal, ((TroopAIOAppInfo)localObject).hashVal)) && (((TroopAIOAppInfo)localObject).isValidTroopApp()) && (paramTroopAIOAppInfo.identifyMask == ((TroopAIOAppInfo)localObject).identifyMask))
    {
      bool1 = bool2;
      if (paramTroopAIOAppInfo.redPoint == ((TroopAIOAppInfo)localObject).redPoint) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void bG(boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      try
      {
        aprm localaprm = (aprm)this.dI.get(paramInt, null);
        boolean bool;
        if (localaprm != null)
        {
          bool = true;
          rom.assertTrue(bool);
          if (localaprm != null) {}
        }
        else
        {
          bool = false;
          continue;
        }
        if (paramBoolean) {
          localaprm.dVy |= 0x1;
        } else {
          localObject.dVy &= 0xFFFFFFFE;
        }
      }
      finally {}
    }
  }
  
  public void bO(JSONObject paramJSONObject)
  {
    aprp.a[] arrayOfa = aprp.a.a;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      aprp.a locala = arrayOfa[i];
      JSONObject localJSONObject = locala.s(paramJSONObject.optJSONObject(locala.key));
      if (localJSONObject != null) {
        q(locala.key, localJSONObject);
      }
      i += 1;
    }
  }
  
  public void c(String paramString1, String paramString2, List<TroopAIOAppInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(paramString1, 2, paramString2 + " end");
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          QLog.d(paramString1, 2, ((TroopAIOAppInfo)paramList.next()).toString());
        }
      }
      QLog.d(paramString1, 2, "arg is null");
      QLog.d(paramString1, 2, paramString2 + " end");
    }
  }
  
  public boolean c(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    int i = paramTroopAIOAppInfo.appid;
    aprm localaprm = (aprm)this.dI.get(paramTroopAIOAppInfo.groupType);
    if (localaprm != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (localaprm != null) {
        break;
      }
      return false;
    }
    if ((TroopAIOAppInfo)localaprm.iP.get(Integer.valueOf(i)) != null) {
      return true;
    }
    localaprm.a(paramTroopAIOAppInfo.appid, paramTroopAIOAppInfo);
    return false;
  }
  
  public boolean cP(long paramLong)
  {
    return this.bD.contains(Long.valueOf(paramLong));
  }
  
  protected void ebB()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < this.dH.size())
      {
        int j = this.dH.keyAt(i);
        int k = ((Integer)this.dH.get(j)).intValue();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("appId", j);
          localJSONObject.put("num", k);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(".troop.troop_app", 2, "saveAppIdNums exception");
            }
          }
        }
      }
    }
    if ((localJSONArray.length() != 0) && (this.mApp != null)) {
      this.mApp.getPreferences().edit().putString("appid_click_num", localJSONArray.toString()).commit();
    }
  }
  
  public void ebz()
  {
    aprp.a[] arrayOfa = aprp.a.a;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      aprp.a locala = arrayOfa[i];
      Object localObject = this.mApp.getPreferences().getString("KEY_APP_CONFIG_PREFIX-" + locala.key, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = locala.v((String)localObject);
        this.nL.put(locala.key, localObject);
      }
      i += 1;
    }
  }
  
  public void fd(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    aprm localaprm = (aprm)this.dI.get(0, null);
    if (localaprm != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (localaprm == null) {
        break;
      }
      Iterator localIterator = paramArrayList.iterator();
      Integer localInteger;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localInteger = (Integer)localIterator.next();
      } while (localaprm.iP.containsKey(localInteger));
      QLog.w(".troop.troop_app", 1, "TroopAppMgr:sortTroopAppList error, there is no appid in hashtable");
      return;
    }
    this.e.m(jM(0), paramArrayList);
  }
  
  public void g(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramInt <= 0) {
      return;
    }
    for (;;)
    {
      synchronized (this.dH)
      {
        int i = ((Integer)this.dH.get(paramInt, Integer.valueOf(0))).intValue();
        this.dH.put(paramInt, Integer.valueOf(i + 1));
        ebB();
        ??? = new anov(this.mApp).a("dc00899").b("Grp_AIO").c("add_page").d("Clk_app").a(new String[] { paramString }).a(new String[] { String.valueOf(paramInt) });
        if (paramBoolean)
        {
          paramString = "0";
          ((anov)???).a(new String[] { paramString }).report();
          return;
        }
      }
      paramString = "1";
    }
  }
  
  public boolean g(List<Integer> paramList, int paramInt)
  {
    boolean bool2 = true;
    aprm localaprm = (aprm)this.dI.get(paramInt, null);
    if (paramList != null)
    {
      bool1 = true;
      rom.assertTrue(bool1);
      if (localaprm == null) {
        break label54;
      }
    }
    label54:
    for (boolean bool1 = true;; bool1 = false)
    {
      rom.assertTrue(bool1);
      if ((localaprm != null) && (paramList != null)) {
        break label59;
      }
      return false;
      bool1 = false;
      break;
    }
    label59:
    new ArrayList();
    Object localObject;
    if (paramList.size() != localaprm.iP.size())
    {
      bool1 = bool2;
      localObject = this.lock;
      if (bool1) {
        break label175;
      }
    }
    label175:
    for (;;)
    {
      try
      {
        bool2 = localaprm.av(paramList);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d(".troop.troop_app", 2, "makeAppidsInOrder() app order changed!");
            bool1 = bool2;
          }
        }
        if (bool1)
        {
          localaprm.ac(paramList, paramInt);
          H(localaprm.dV(), paramInt);
        }
        return bool1;
      }
      finally {}
      bool1 = false;
      break;
    }
  }
  
  public int jM(int paramInt)
  {
    aprm localaprm = (aprm)this.dI.get(paramInt);
    if (localaprm != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (localaprm != null) {
        break;
      }
      return 0;
    }
    return localaprm.timestamp;
  }
  
  public void jU(int paramInt1, int paramInt2)
  {
    aprm localaprm = (aprm)this.dI.get(paramInt2);
    boolean bool;
    if (localaprm != null)
    {
      bool = true;
      rom.assertTrue(bool);
      if (localaprm != null) {
        break label35;
      }
    }
    label35:
    do
    {
      return;
      bool = false;
      break;
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localaprm.iP.remove(Integer.valueOf(paramInt1));
      if (localTroopAIOAppInfo != null)
      {
        rom.assertTrue(localaprm.a(localTroopAIOAppInfo));
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_app", 2, new Object[] { "removeTroopAppByAppid appid: ", Integer.valueOf(paramInt1), "/", Integer.valueOf(paramInt2), " removed" });
        }
        ThreadManager.post(new TroopAppMgr.4(this, this.mApp.a().createEntityManager(), localTroopAIOAppInfo), 8, null, false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(".troop.troop_app", 2, new Object[] { "removeTroopAppByAppid appid: ", Integer.valueOf(paramInt1), "/", Integer.valueOf(paramInt2), " remove fail, not contains app" });
  }
  
  public void jV(int paramInt1, int paramInt2)
  {
    aprm localaprm = (aprm)this.dI.get(paramInt2);
    if (localaprm != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (localaprm != null) {
        break;
      }
      return;
    }
    localaprm.timestamp = paramInt1;
    this.mApp.getPreferences().edit().putInt("KEY_APP_LIST_TIME_STAMP_" + paramInt2, paramInt1).commit();
  }
  
  public void jW(int paramInt1, int paramInt2)
  {
    if (b(paramInt1, paramInt2) == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt1));
    this.e.B(localArrayList, 0);
  }
  
  /* Error */
  public boolean mh(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 66	aprp:dI	Landroid/util/SparseArray;
    //   8: iload_1
    //   9: aconst_null
    //   10: invokevirtual 483	android/util/SparseArray:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 105	aprm
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +20 -> 40
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: invokestatic 373	rom:assertTrue	(Z)V
    //   29: aload 4
    //   31: ifnonnull +14 -> 45
    //   34: iload_3
    //   35: istore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -17 -> 25
    //   45: aload 4
    //   47: getfield 486	aprm:dVy	I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_1
    //   53: iand
    //   54: ifeq +8 -> 62
    //   57: iconst_1
    //   58: istore_2
    //   59: goto -23 -> 36
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -5 -> 59
    //   67: astore 4
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 4
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	aprp
    //   0	74	1	paramInt	int
    //   24	40	2	bool1	boolean
    //   1	34	3	bool2	boolean
    //   16	30	4	localaprm	aprm
    //   67	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	18	67	finally
    //   25	29	67	finally
    //   45	51	67	finally
  }
  
  /* Error */
  public boolean mi(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 66	aprp:dI	Landroid/util/SparseArray;
    //   8: iload_1
    //   9: aconst_null
    //   10: invokevirtual 483	android/util/SparseArray:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 105	aprm
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +20 -> 40
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: invokestatic 373	rom:assertTrue	(Z)V
    //   29: aload 4
    //   31: ifnonnull +14 -> 45
    //   34: iload_3
    //   35: istore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -17 -> 25
    //   45: aload 4
    //   47: getfield 486	aprm:dVy	I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_2
    //   53: iand
    //   54: ifeq +8 -> 62
    //   57: iconst_1
    //   58: istore_2
    //   59: goto -23 -> 36
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -5 -> 59
    //   67: astore 4
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 4
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	aprp
    //   0	74	1	paramInt	int
    //   24	40	2	bool1	boolean
    //   1	34	3	bool2	boolean
    //   16	30	4	localaprm	aprm
    //   67	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	18	67	finally
    //   25	29	67	finally
    //   45	51	67	finally
  }
  
  public void o(ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty())) {}
    do
    {
      return;
      if (paramArrayList1.containsAll(paramArrayList2))
      {
        this.e.c(jM(0), paramArrayList1, paramArrayList2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAppMgr.addTroopApp.troop.troop_app", 2, "appids to add are not contained in Appids list!");
  }
  
  public void onDestroy()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 32;
    tmp11_7;
    synchronized (this.lock)
    {
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        bG(false, k);
        aprm localaprm = (aprm)this.dI.get(k);
        rom.checkNotNull(localaprm);
        localaprm.iP.clear();
        localaprm.eby();
        localaprm.timestamp = 0;
        i += 1;
      }
      return;
    }
  }
  
  public void q(String paramString, JSONObject paramJSONObject)
  {
    rom.checkNotNull(paramString);
    rom.checkNotNull(paramJSONObject);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramJSONObject == null) {
      return;
    }
    this.nL.put(str, paramJSONObject);
    this.mApp.getPreferences().edit().putString("KEY_APP_CONFIG_PREFIX-" + str, paramJSONObject.toString()).apply();
  }
  
  public boolean qJ(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(this.cqL)) && (this.cqL.equals(paramString)))
      {
        boolean bool = this.cSf;
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public JSONObject u(String paramString)
  {
    rom.checkNotNull(paramString);
    if (paramString == null) {
      return null;
    }
    return (JSONObject)this.nL.get(paramString);
  }
  
  public boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEntityManager.isOpen())
    {
      if (paramEntity.getStatus() != 1000) {
        break label45;
      }
      paramEntityManager.persistOrReplace(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label45:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return paramEntityManager.update(paramEntity);
  }
  
  public static class a
  {
    public static a[] a = { new a("BulkChatMessageConfig") };
    public String key;
    
    public a(String paramString)
    {
      this.key = paramString;
    }
    
    JSONObject s(JSONObject paramJSONObject)
    {
      return paramJSONObject;
    }
    
    final JSONObject v(String paramString)
    {
      try
      {
        paramString = new JSONObject(paramString);
        return s(paramString);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString = new JSONObject();
        }
      }
    }
  }
  
  public static abstract class b
    extends jnm.d
  {
    public b()
    {
      super();
    }
    
    protected abstract void Sf(boolean paramBoolean);
    
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      QLog.i(".troop.troop_app", 2, "clickReport errorCode = " + paramInt);
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        Sf(bool);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprp
 * JD-Core Version:    0.7.0.1
 */