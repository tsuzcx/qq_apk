import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.1;
import com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.2;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.aioapp.data.GrayGroupAppEntity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import mqq.manager.Manager;

public class aoxw
  implements anwa.a, Manager
{
  public List<TroopAIOAppInfo> Hq;
  private final aoxx jdField_a_of_type_Aoxx;
  private final aoxy jdField_a_of_type_Aoxy;
  private final acms c;
  String cnt = "";
  final ConcurrentHashMap<Long, GrayGroupAppEntity> iJ;
  private final QQAppInterface mApp;
  
  public aoxw(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Aoxy = new aoxy(this.mApp);
    this.jdField_a_of_type_Aoxx = new aoxx(this.mApp);
    this.iJ = new ConcurrentHashMap(20);
    this.c = ((acms)this.mApp.getBusinessHandler(20));
    this.Hq = new ArrayList(20);
    anwa.a(this);
  }
  
  public static aoxw a(QQAppInterface paramQQAppInterface)
  {
    return (aoxw)paramQQAppInterface.getManager(196);
  }
  
  private List<TroopAIOAppInfo> a(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    ArrayList localArrayList = new ArrayList(20);
    Object localObject = paramGrayGroupAppEntity.troopAIOAppInfos;
    paramGrayGroupAppEntity = new HashSet(20);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramGrayGroupAppEntity.add(Integer.valueOf(((TroopAIOAppInfo)((Iterator)localObject).next()).appid));
    }
    localObject = this.Hq.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      if (!localTroopAIOAppInfo.isGray) {
        localArrayList.add(localTroopAIOAppInfo);
      } else if (paramGrayGroupAppEntity.contains(Integer.valueOf(localTroopAIOAppInfo.appid))) {
        localArrayList.add(localTroopAIOAppInfo);
      }
    }
    return localArrayList;
  }
  
  private void clearAll()
  {
    this.iJ.clear();
    this.Hq.clear();
    this.cnt = "";
    dXK();
    a().dXN();
    a().dXN();
  }
  
  private List<TroopAIOAppInfo> gx()
  {
    ArrayList localArrayList = new ArrayList(20);
    Iterator localIterator = this.Hq.iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      if (!localTroopAIOAppInfo.isGray) {
        localArrayList.add(localTroopAIOAppInfo);
      }
    }
    return localArrayList;
  }
  
  public long V(long paramLong)
  {
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)this.iJ.get(Long.valueOf(paramLong));
    paramLong = TimeUnit.DAYS.toSeconds(1L);
    if (localGrayGroupAppEntity == null) {
      return paramLong;
    }
    if (localGrayGroupAppEntity.requestIntervalSecond <= 0) {
      return paramLong;
    }
    return localGrayGroupAppEntity.requestIntervalSecond;
  }
  
  public void Ws(int paramInt)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt));
    this.c.B(localArrayList, 0);
  }
  
  public void Wt(int paramInt)
  {
    Object localObject = new ArrayList(this.Hq);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      if (paramInt == localTroopAIOAppInfo.appid) {
        localTroopAIOAppInfo.redPoint = false;
      }
    }
    this.Hq = ((List)localObject);
    localObject = new FullListGroupAppEntity();
    ((FullListGroupAppEntity)localObject).troopAIOAppInfos = this.Hq;
    a().b((FullListGroupAppEntity)localObject);
  }
  
  public aoxx a()
  {
    return this.jdField_a_of_type_Aoxx;
  }
  
  public aoxy a()
  {
    return this.jdField_a_of_type_Aoxy;
  }
  
  public String bJ(long paramLong)
  {
    Object localObject = i(paramLong);
    if (aoyb.isEmpty((Collection)localObject)) {
      return "";
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localTroopAIOAppInfo.hashVal)) {
        return localTroopAIOAppInfo.hashVal;
      }
    }
    return "";
  }
  
  public void dXJ()
  {
    aoyb.j(new AioGroupAppsManager.1(this), 1000L);
  }
  
  public void dXK()
  {
    String str = "_" + this.mApp.getCurrentUin();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).edit();
    localEditor.putString("SP_KEY_FULL_APP_LIST_HASH" + str, this.cnt);
    localEditor.apply();
  }
  
  public void dXL()
  {
    String str = "_" + this.mApp.getCurrentUin();
    this.cnt = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).getString("SP_KEY_FULL_APP_LIST_HASH" + str, "");
  }
  
  public List<TroopAIOAppInfo> i(long paramLong)
  {
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)this.iJ.get(Long.valueOf(paramLong));
    if (localGrayGroupAppEntity == null) {
      return gx();
    }
    return a(localGrayGroupAppEntity);
  }
  
  public void lJ(long paramLong)
  {
    boolean bool = aoya.l(this.mApp, paramLong);
    if (QLog.isColorLevel()) {
      QLog.i("AioGroupAppsManager", 2, "getAppsInObserver: invoked.  needRequest: " + bool);
    }
    if (bool)
    {
      TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).b(String.valueOf(paramLong));
      if (localTroopInfo == null) {}
      for (int i = 0;; i = (int)localTroopInfo.dwGroupClassExt)
      {
        aoya.d(this.mApp, paramLong, i);
        return;
      }
    }
    if (!aoyb.isEmpty(i(paramLong)))
    {
      aoya.v(this.mApp, paramLong);
      return;
    }
    aoyb.an(new AioGroupAppsManager.2(this, paramLong));
  }
  
  public void onChange(boolean paramBoolean)
  {
    clearAll();
  }
  
  public void onDestroy()
  {
    anwa.b(this);
    this.iJ.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoxw
 * JD-Core Version:    0.7.0.1
 */