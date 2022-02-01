import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import mqq.manager.Manager;

public class aohy
  implements Manager
{
  private final LruCache<String, Long> B;
  private ArrayList<aoif> Bh;
  ArrayList<aohy.b> Bi = new ArrayList(5);
  private final acnd jdField_a_of_type_Acnd = new aoia(this);
  private awms jdField_a_of_type_Awms = new aohz(this);
  private acfd c = new aoib(this);
  private SparseArray<aoil> dx;
  private ConcurrentHashMap<Integer, aoih> iB;
  private ConcurrentHashMap<Integer, aoie> iC;
  private final QQAppInterface mApp;
  SharedPreferences mPref;
  private final HashMap<String, aoii> nP;
  private final Map<String, aohy.a> nv;
  
  public aohy(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.B = new LruCache(100);
    this.nP = new HashMap(50);
    this.dx = new SparseArray();
    this.nv = new HashMap(50);
    this.Bh = new ArrayList(50);
    a(2, new aoik(this.mApp));
    a(4, new aihc(this.mApp));
    dUF();
    this.mApp.addObserver(this.jdField_a_of_type_Acnd);
    this.mApp.addObserver(this.c);
    this.mPref = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0);
  }
  
  private void K(int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramInt1, paramInt2, paramString) == null) {
      a(paramInt1, paramInt2, paramString, aoij.b(paramInt1, paramInt2, paramString));
    }
  }
  
  public static aohy a(QQAppInterface paramQQAppInterface)
  {
    return (aohy)paramQQAppInterface.getManager(339);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, aoii> paramMap, @Nullable Bundle paramBundle)
  {
    int i = 0;
    while (i < this.dx.size())
    {
      aoil localaoil = (aoil)this.dx.valueAt(i);
      if (localaoil != null) {
        localaoil.a(paramContext, paramInt1, paramInt2, paramInt3, paramMap, paramBundle);
      }
      i += 1;
    }
  }
  
  private boolean azI()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.mPref.getLong("banner_inter", 0L);
    aeog localaeog = (aeog)aeif.a().o(553);
    if (localaeog != null) {}
    for (long l1 = localaeog.cOf;; l1 = 10L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 1, new Object[] { "canRequestBanner cur:", Long.valueOf(l2), " last:", Long.valueOf(l3), " interval:", Long.valueOf(60000L * l1) });
      }
      if (l2 - l3 < l1 * 60000L) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void b(apyk paramapyk)
  {
    Iterator localIterator = this.Bh.iterator();
    while (localIterator.hasNext()) {
      ((aoif)localIterator.next()).onUpdate(2, true, paramapyk);
    }
  }
  
  private void dUF()
  {
    this.iB = new ConcurrentHashMap(2);
    this.iB.put(Integer.valueOf(2), new aiia(this.mApp));
    this.iB.put(Integer.valueOf(4), new aiha(this.mApp));
  }
  
  public void QQ(boolean paramBoolean)
  {
    if (this.Bi.size() > 0) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 1, new Object[] { "requestEntryBanner size:", Integer.valueOf(this.Bi.size()) });
      }
    }
    long l;
    do
    {
      do
      {
        do
        {
          return;
          if ((!paramBoolean) || (azI())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TogetherControlManager", 1, "fromAIO in time interval");
        return;
        ArrayList localArrayList = new ArrayList();
        awmr localawmr = new awmr();
        localawmr.eBV = 236;
        localawmr.eBW = 1;
        localArrayList.add(localawmr);
        awmt.a().a(localArrayList, this.jdField_a_of_type_Awms);
      } while (!paramBoolean);
      l = System.currentTimeMillis();
      this.mPref.edit().putLong("banner_inter", l).commit();
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 1, new Object[] { "saveBannerInterval ", Long.valueOf(l) });
  }
  
  public void RS(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
  
  @Nullable
  public HashMap<String, aoii> Z()
  {
    if (this.nP != null) {
      return (HashMap)this.nP.clone();
    }
    return new HashMap();
  }
  
  public aohy.a a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    String str = paramInt1 + "-" + paramInt2 + "-" + paramString + "-" + paramInt3;
    aohy.a locala = (aohy.a)this.nv.get(str);
    paramString = locala;
    if (locala == null)
    {
      paramString = new aohy.a();
      this.nv.put(str, paramString);
    }
    return paramString;
  }
  
  public aohy.b a()
  {
    if (this.Bi.size() > 0) {
      return (aohy.b)this.Bi.remove(0);
    }
    return null;
  }
  
  public aoie a(int paramInt)
  {
    if (this.iC == null)
    {
      this.iC = new ConcurrentHashMap(4);
      return null;
    }
    return (aoie)this.iC.get(Integer.valueOf(paramInt));
  }
  
  public <T extends aoih> T a(int paramInt)
  {
    aoih localaoih2 = (aoih)this.iB.get(Integer.valueOf(paramInt));
    aoih localaoih1 = localaoih2;
    if (localaoih2 == null) {
      localaoih1 = null;
    }
    return localaoih1;
  }
  
  public <T extends aoii> T a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = (aoii)this.nP.get(paramInt1 + "_" + paramInt2 + "_" + paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public apyk a(String paramString)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).getString(paramString, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = ((String)localObject).split("_");
    } while (localObject.length != 2);
    apyk localapyk = new apyk();
    localapyk.troopuin = paramString;
    localapyk.dXV = Integer.valueOf(localObject[0]).intValue();
    localapyk.nUnreadMsgNum = Integer.valueOf(localObject[1]).intValue();
    return localapyk;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    paramString = paramInt1 + "_" + paramInt2 + "_" + paramString;
    this.B.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, aoii paramaoii)
  {
    this.nP.put(paramInt1 + "_" + paramInt2 + "_" + paramString, paramaoii);
  }
  
  public void a(int paramInt, aoil paramaoil)
  {
    this.dx.put(paramInt, paramaoil);
  }
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, @Nullable Bundle paramBundle)
  {
    aoil localaoil = (aoil)this.dx.get(paramInt2);
    if (localaoil == null) {
      throw new IllegalArgumentException("TogetherDelegate not register! serviceType: " + paramInt2);
    }
    if (paramInt2 == 2)
    {
      if (paramInt3 != 0) {
        break label129;
      }
      g("video_tab", "clk_panelvideo", 0, paramString);
    }
    while (a(paramContext, paramInt2, paramString, paramInt3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(paramInt2), " fail because of other together business exist, from=", Integer.valueOf(paramInt3) });
      }
      return;
      label129:
      if (paramInt3 == 2) {
        g("video_tab", "clk_setvideo", 0, paramString);
      }
    }
    K(paramInt2, paramInt1, paramString);
    if (localaoil.a(paramContext, paramString, paramInt1, paramInt3, true, Z(), paramBundle))
    {
      ((aoil)this.dx.get(paramInt2)).a(paramContext, paramString, paramInt1, paramInt3, c(paramInt2), paramBundle);
      a(paramContext, paramInt2, 1, paramInt3, Z(), paramBundle);
      return;
    }
    paramString = localaoil.d();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559151);
    paramContext.setTitle(acfp.m(2131715366) + ((aoil)this.dx.get(paramInt2)).getBusinessName() + acfp.m(2131715368));
    paramContext.setMessage(acfp.m(2131715377) + ((aoil)this.dx.get(paramInt2)).getBusinessName() + acfp.m(2131715386));
    paramContext.setNegativeButton(acfp.m(2131715378), new aoic(this));
    paramContext.show();
  }
  
  public void a(aoie paramaoie)
  {
    if (this.iC == null) {
      this.iC = new ConcurrentHashMap(4);
    }
    do
    {
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.id=", Integer.valueOf(paramaoie.id), "data.isGetFakeData=", Boolean.valueOf(paramaoie.cLF) });
          if (paramaoie.cLF)
          {
            QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.numberOfPeople=", Integer.valueOf(paramaoie.dOC) });
            Iterator localIterator = paramaoie.Bj.iterator();
            while (localIterator.hasNext()) {
              QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.uin=", (String)localIterator.next() });
            }
          }
        }
        if (paramaoie == null) {
          continue;
        }
      }
      catch (Exception paramaoie)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData error", paramaoie.getMessage() });
        }
        return;
      }
      if ((paramaoie.Bj != null) && (paramaoie.Bj.size() >= 4) && (paramaoie.dOC >= 150)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlManager", 2, "putFakePanelData error data");
    return;
    this.iC.put(Integer.valueOf(paramaoie.id), paramaoie);
  }
  
  public void a(aoif paramaoif)
  {
    this.Bh.remove(paramaoif);
    this.Bh.add(paramaoif);
  }
  
  public void a(apyk paramapyk)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.putString(paramapyk.troopuin, paramapyk.dXV + "_" + paramapyk.nUnreadMsgNum);
    localEditor.apply();
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    BaseActivity localBaseActivity;
    if (paramBaseActivity == null)
    {
      paramBaseActivity = BaseActivity.sTopActivity;
      localBaseActivity = paramBaseActivity;
      if (paramBaseActivity != null) {
        break label28;
      }
      QLog.d("TogetherControlManager", 1, "joinTogetherAndEnter return null activity");
    }
    label28:
    boolean bool;
    Object localObject;
    label567:
    label601:
    label764:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localBaseActivity = paramBaseActivity;
                  if (!aqiw.isNetworkAvailable(localBaseActivity))
                  {
                    QQToast.a(localBaseActivity, 1, localBaseActivity.getString(2131696664), 0).show();
                    return;
                  }
                  if (paramInt1 == 1)
                  {
                    ListenTogetherManager.a(this.mApp).a(localBaseActivity, paramInt2, paramString, paramLong);
                    return;
                  }
                  if (paramInt1 != 2) {
                    break label601;
                  }
                  if (paramInt2 != 2) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " sessionType is error" });
                return;
                g("video_tab", "clk_videoark", 0, paramString);
                bool = e(paramInt1, paramInt2, paramString);
                if (QLog.isColorLevel()) {
                  QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " isOpen=" + bool });
                }
                if (!bool)
                {
                  QQToast.a(localBaseActivity, 1, 2131721821, 0).show(localBaseActivity.getTitleBarHeight());
                  return;
                }
                paramBaseActivity = ((TroopManager)this.mApp.getManager(52)).c(paramString);
              } while (paramBaseActivity == null);
              paramBaseActivity = aoij.a(true, paramBaseActivity.isTroopOwner(this.mApp.getCurrentAccountUin()), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, 8);
              localObject = (WatchTogetherSession)a(paramInt1, paramInt2, paramString);
              if ((localObject != null) && (((WatchTogetherSession)localObject).status != 3)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " session=", localObject });
            return;
            if (((WatchTogetherSession)localObject).apd != paramLong)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " session.identifyId=" + ((WatchTogetherSession)localObject).apd + " msg.identify=" + paramLong });
              }
              QQToast.a(localBaseActivity, 1, 2131721821, 0).show(localBaseActivity.getTitleBarHeight());
              return;
            }
            switch (((WatchTogetherSession)localObject).videoType)
            {
            default: 
              if (!a(localBaseActivity, 2, paramString, 8)) {
                break label567;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
          return;
          QQToast.a(localBaseActivity, 0, 2131694552, 0).show();
          return;
          g("video_tab", "clk_videoark_suc", 0, paramString);
          b(localBaseActivity, paramString, 1, 2, 8, paramBaseActivity);
          return;
          g("video_tab", "clk_videoark_suc", 0, paramString);
          aoij.a(this.mApp, ((WatchTogetherSession)localObject).dOE, ((WatchTogetherSession)localObject).ckO, null, paramBaseActivity, 1);
          return;
        } while (paramInt1 != 4);
        if (paramInt2 == 1)
        {
          i = 1;
          if (i == 0) {
            break label726;
          }
          g("sing_tab", "clk_singark", 0, paramString);
        }
        for (;;)
        {
          bool = e(paramInt1, paramInt2, paramString);
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(4), " isOpen=" + bool });
          }
          if (bool) {
            break label764;
          }
          QQToast.a(localBaseActivity, 1, 2131720347, 0).show(localBaseActivity.getTitleBarHeight());
          return;
          i = 0;
          break;
          anot.a(this.mApp, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark", 0, 1, paramString, "", "", "");
        }
        paramBaseActivity = (SingTogetherSession)a(paramInt1, paramInt2, paramString);
        if ((paramBaseActivity != null) && (paramBaseActivity.status != 3)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(4), " session=", paramBaseActivity });
      return;
      if (paramBaseActivity.apd != paramLong)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(4), " session.identifyId=" + paramBaseActivity.apd + " msg.identify=" + paramLong });
        }
        QQToast.a(localBaseActivity, 1, 2131720347, 0).show(localBaseActivity.getTitleBarHeight());
        return;
      }
      i = -1;
      paramBaseActivity = new Bundle();
      localObject = this.mApp.getCurrentAccountUin();
      if (paramInt2 != 1) {
        break;
      }
      paramBaseActivity = ((TroopManager)this.mApp.getManager(52)).c(paramString);
    } while (paramBaseActivity == null);
    label726:
    paramBaseActivity = aoij.a(bool, paramBaseActivity.isTroopOwner((String)localObject), paramBaseActivity.isAdmin(), paramBaseActivity.troopowneruin, paramString, 8);
    int i = 8;
    paramInt1 = paramInt2;
    paramInt2 = i;
    for (;;)
    {
      b(localBaseActivity, paramString, paramInt1, 4, paramInt2, paramBaseActivity);
      return;
      if (paramInt2 == 2)
      {
        paramInt2 = 9;
        paramBaseActivity = aoij.a(bool, 9);
        paramInt1 = 2;
      }
      else
      {
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, apyk paramapyk)
  {
    a(paramapyk);
    b(paramapyk);
    g("video_tab", "exp_whitebar", 0, paramapyk.troopuin);
  }
  
  public boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramInt1 != 1)
    {
      localObject = ListenTogetherManager.a(this.mApp);
      if (paramInt2 < 3) {}
      for (paramInt2 = 1; ((ListenTogetherManager)localObject).D(paramInt2, paramString); paramInt2 = 2)
      {
        QQToast.a(paramContext, 1, acfp.m(2131715383), 0).show();
        return true;
      }
      if (ListenTogetherManager.a(this.mApp).apf())
      {
        QQToast.a(paramContext, 1, acfp.m(2131715376), 0).show();
        return true;
      }
    }
    if ((this.mApp.bF()) || (ilp.checkAVCameraUsed(paramContext)))
    {
      QQToast.a(paramContext, 1, acfp.m(2131715371), 1).show();
      return true;
    }
    if (this.mApp.abz())
    {
      QQToast.a(paramContext, 1, acfp.m(2131715372), 1).show();
      return true;
    }
    if (!this.mApp.YK())
    {
      QQToast.a(paramContext, 1, acfp.m(2131715390), 1).show();
      return true;
    }
    Iterator localIterator = this.nP.keySet().iterator();
    String[] arrayOfString;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        arrayOfString = ((String)localObject).split("_");
        if ((arrayOfString.length > 0) && (paramInt1 != Integer.parseInt(arrayOfString[0])))
        {
          if (this.nP.get(localObject) == null) {
            break label671;
          }
          if ((paramString.equals(arrayOfString[2])) && (3 != ((aoii)this.nP.get(localObject)).status) && (((aoii)this.nP.get(localObject)).status != 0)) {
            switch (Integer.parseInt(arrayOfString[0]))
            {
            default: 
              localObject = acfp.m(2131715381) + ((aoil)this.dx.get(Integer.parseInt(arrayOfString[0]))).getBusinessName() + acfp.m(2131715393);
            }
          }
        }
      }
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      QQToast.a(paramContext, 1, (CharSequence)localObject, 0).show();
      return true;
      localObject = acfp.m(2131715388);
      continue;
      if ((paramString.equals(arrayOfString[2])) && (2 == ((aoii)this.nP.get(localObject)).deR)) {}
      switch (Integer.parseInt(arrayOfString[0]))
      {
      default: 
        localObject = acfp.m(2131715374) + ((aoil)this.dx.get(Integer.parseInt(arrayOfString[0]))).getBusinessName() + acfp.m(2131715391);
        break;
      case 1: 
        localObject = acfp.m(2131715392);
        continue;
        if ((!paramString.equals(arrayOfString[2])) && (aihl.f(Integer.parseInt(arrayOfString[0]), arrayOfString[2], Integer.parseInt(arrayOfString[1])))) {}
        switch (Integer.parseInt(arrayOfString[0]))
        {
        default: 
          localObject = acfp.m(2131715374) + ((aoil)this.dx.get(Integer.parseInt(arrayOfString[0]))).getBusinessName() + acfp.m(2131715391);
          break;
        case 1: 
          localObject = acfp.m(2131715392);
          continue;
          return false;
          label671:
          localObject = "";
        }
        break;
      }
    }
  }
  
  public void ac(String paramString1, int paramInt, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    QLog.d("TogetherControlManager", 1, new Object[] { "reportTianShu time = ", Long.valueOf(l), " actionId:", Integer.valueOf(paramInt), " itemId:", paramString2 });
    awmu localawmu = new awmu();
    localawmu.mActionId = paramInt;
    localawmu.eBB = 1;
    localawmu.cNR = paramString2;
    localawmu.mTraceId = (paramString1 + "_" + l);
    localawmu.eBX = 1;
    localawmu.aBn = l;
    localawmu.mAppId = "tianshu.156";
    localawmu.cNQ = "tianshu.156";
    awmt.a().a(localawmu);
  }
  
  public long b(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = paramInt1 + "_" + paramInt2 + "_" + paramLong;
    localObject = (Long)this.B.get(localObject);
    if (localObject == null) {
      return 0L;
    }
    return ((Long)localObject).longValue();
  }
  
  public void b(Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    int m = 0;
    int k;
    switch (paramInt)
    {
    default: 
      k = m;
    }
    while (k < this.dx.size())
    {
      aoil localaoil = (aoil)this.dx.valueAt(k);
      if (localaoil != null) {
        localaoil.a(paramContext, paramSessionInfo, paramInt);
      }
      k += 1;
      continue;
      if (paramSessionInfo.cZ != 1)
      {
        k = m;
        if (paramSessionInfo.cZ != 0) {
          break;
        }
      }
      else
      {
        int i;
        label108:
        int j;
        if (paramSessionInfo.cZ == 1)
        {
          i = 1;
          j = 0;
        }
        for (;;)
        {
          k = m;
          if (j >= this.dx.size()) {
            break;
          }
          k = this.dx.keyAt(j);
          boolean bool = e(k, i, paramSessionInfo.aTl);
          QLog.d("TogetherControlManager", 1, "TogetherWatch  isOpen=" + bool + " service=" + k);
          if (bool)
          {
            c(k, i, paramSessionInfo.aTl, 1000);
            k = m;
            break;
            i = 2;
            break label108;
          }
          j += 1;
        }
      }
    }
  }
  
  public void b(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, @Nullable Bundle paramBundle)
  {
    aoil localaoil = (aoil)this.dx.get(paramInt2);
    if (localaoil == null) {
      throw new IllegalArgumentException("TogetherDelegate not register! serviceType: " + paramInt2);
    }
    if (paramInt2 == 2)
    {
      if (paramInt3 != 0) {
        break label129;
      }
      g("video_tab", "clk_panelvideo", 0, paramString);
    }
    while (a(paramContext, paramInt2, paramString, paramInt3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(paramInt2), " fail because of other together business exist, from=", Integer.valueOf(paramInt3) });
      }
      return;
      label129:
      if (paramInt3 == 2) {
        g("video_tab", "clk_setvideo", 0, paramString);
      }
    }
    K(paramInt2, paramInt1, paramString);
    if (localaoil.a(paramContext, paramString, paramInt1, paramInt3, false, Z(), paramBundle))
    {
      ((aoil)this.dx.get(paramInt2)).b(paramContext, paramString, paramInt1, paramInt3, c(paramInt2), paramBundle);
      a(paramContext, paramInt2, 3, paramInt3, Z(), paramBundle);
      return;
    }
    paramString = localaoil.d();
    if (paramString != null)
    {
      paramString.show();
      return;
    }
    paramContext = new aqju(paramContext, 2131756467);
    paramContext.setContentView(2131559151);
    paramContext.setTitle(acfp.m(2131715382) + ((aoil)this.dx.get(paramInt2)).getBusinessName() + acfp.m(2131715370));
    paramContext.setMessage(acfp.m(2131715367) + ((aoil)this.dx.get(paramInt2)).getBusinessName() + acfp.m(2131715379));
    paramContext.setNegativeButton(acfp.m(2131715373), new aoid(this));
    paramContext.show();
  }
  
  public void b(aoif paramaoif)
  {
    this.Bh.remove(paramaoif);
  }
  
  public void b(aoii paramaoii, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    aoil localaoil = (aoil)this.dx.get(paramaoii.serviceType);
    if (localaoil != null) {
      localaoil.a(paramaoii, paramInt, paramString, paramLong1, paramLong2, paramObject);
    }
  }
  
  public void b(boolean paramBoolean, aoii paramaoii, int paramInt, String paramString)
  {
    ((aoig)this.mApp.getBusinessHandler(165)).notifyUI(1, paramBoolean, new Object[] { paramaoii, Integer.valueOf(paramInt), paramString });
  }
  
  @Nullable
  public HashMap<String, aoii> c(int paramInt)
  {
    if (this.nP != null)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.nP.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.contains(paramInt + "")) {
          localHashMap.put(str, this.nP.get(str));
        }
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  public void c(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    ((aoig)this.mApp.getBusinessHandler(165)).e(paramInt1, paramInt2, paramString, paramInt3);
  }
  
  public void c(aoii paramaoii, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    ((aoig)this.mApp.getBusinessHandler(165)).notifyUI(0, true, new Object[] { paramaoii, Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramObject });
  }
  
  public void d(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.nv.remove(paramInt1 + "-" + paramInt2 + "-" + paramString + "-" + paramInt3);
  }
  
  public void dUG()
  {
    ((aoig)this.mApp.getBusinessHandler(165)).dUJ();
  }
  
  public void dUH()
  {
    if (this.iC == null)
    {
      this.iC = new ConcurrentHashMap(4);
      return;
    }
    this.iC.clear();
  }
  
  public boolean e(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return false;
          return ((ListenTogetherManager)this.mApp.getManager(331)).D(paramInt2, paramString);
        } while (paramInt2 != 1);
        paramString = ((TroopManager)this.mApp.getManager(52)).a(paramString);
      } while ((paramString == null) || (!paramString.isWatchTogetherOpen()));
      return true;
    }
    return aoij.a(this.mApp, paramString, paramInt2, 16777216);
  }
  
  public void g(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).c(paramString3);
    if (localTroopInfo == null) {
      return;
    }
    int i = 2;
    if (localTroopInfo.isAdmin()) {
      i = 1;
    }
    if (localTroopInfo.isTroopOwner(this.mApp.getCurrentUin())) {
      i = 0;
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00899", "Grp_AIO", "", paramString1, paramString2, 0, paramInt, paramString3, "", i + "", "");
      return;
    }
  }
  
  public void onDestroy()
  {
    int i = 0;
    while (i < this.dx.size())
    {
      aoil localaoil = (aoil)this.dx.valueAt(i);
      if (localaoil != null) {
        localaoil.onDestroy();
      }
      i += 1;
    }
    this.mApp.removeObserver(this.jdField_a_of_type_Acnd);
    this.mApp.removeObserver(this.c);
  }
  
  public int s(int paramInt, String paramString)
  {
    if (paramString.equals(this.mApp.getCurrentAccountUin())) {
      return 0;
    }
    int i = 0;
    label18:
    int j;
    aoil localaoil;
    if (i < this.dx.size())
    {
      j = this.dx.keyAt(i);
      localaoil = (aoil)this.dx.valueAt(i);
      if (localaoil != null) {
        break label64;
      }
    }
    label64:
    while (!e(j, paramInt, paramString))
    {
      i += 1;
      break label18;
      break;
    }
    return localaoil.FB();
  }
  
  public static final class a
  {
    public final Bundle data = new Bundle();
    public Object ff;
  }
  
  public static class b
  {
    public TianShuAccess.AdItem a;
    public String pic;
    public String type;
    public String url;
    
    public static b a(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
    {
      if ((!paramBoolean) || (paramGetAdsRsp == null)) {
        return null;
      }
      if (paramGetAdsRsp.mapAds.has()) {}
      for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp == null; paramGetAdsRsp = null) {
        return null;
      }
      HashMap localHashMap = new HashMap();
      paramGetAdsRsp = paramGetAdsRsp.iterator();
      while (paramGetAdsRsp.hasNext())
      {
        localObject1 = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
        if ((localObject1 != null) && (((TianShuAccess.RspEntry)localObject1).key.has())) {
          localHashMap.put(Integer.valueOf(((TianShuAccess.RspEntry)localObject1).key.get()), localObject1);
        }
      }
      paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(236));
      if ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null) || (paramGetAdsRsp.value.lst.size() == 0) || (paramGetAdsRsp.value.lst.get(0) == null) || (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList == null) || (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList.get() == null)) {
        return null;
      }
      Object localObject1 = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList.get();
      localHashMap = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
        String str = ((TianShuAccess.MapEntry)localObject2).key.get();
        localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          localHashMap.put(str, localObject2);
        }
      }
      localObject1 = new b();
      ((b)localObject1).type = ((String)localHashMap.get("type"));
      ((b)localObject1).pic = ((String)localHashMap.get("pic"));
      ((b)localObject1).url = ((String)localHashMap.get("url"));
      ((b)localObject1).a = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
      if (TextUtils.isEmpty(((b)localObject1).pic)) {
        return null;
      }
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohy
 * JD-Core Version:    0.7.0.1
 */