package com.tencent.mobileqq.nearby;

import accg;
import acci;
import acig;
import acpp;
import advp;
import advr;
import aehy;
import ajpp;
import ajra;
import ajrb;
import ajrc;
import ajre;
import ajrk;
import ajro;
import ajvd;
import ajve;
import akkx;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import aolm;
import aomf;
import aqdm;
import aqva;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import mqq.app.AccountManagerImpl;
import mqq.app.IToolProcEventListener;
import mqq.app.ProxyIpManagerImpl;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class NearbyAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public static boolean cpG = true;
  public static boolean cpH = true;
  public List<acci> Dt;
  public List<acci> Du;
  public ajrc a;
  private ajre jdField_a_of_type_Ajre;
  private aomf jdField_a_of_type_Aomf;
  a jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface$a = null;
  NearbyEntityManagerFactory jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
  NearbyMyTabCard jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard;
  public long adf;
  public oidb_0x8dd.SelfInfo b;
  String bRY = null;
  public int bTJ;
  public boolean cpI = true;
  boolean cpJ = false;
  boolean cpK = false;
  int dkg = -2147483648;
  int dkh = 0;
  int dki = 0;
  private Object eh = new Object();
  HashMap<Integer, accg> el;
  public List<acci> fc;
  Map<Integer, Manager> iX = new HashMap(20);
  Object mLock = new Object();
  
  public NearbyAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  /* Error */
  private String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: aload 4
    //   6: ifnull +8 -> 14
    //   9: aload 5
    //   11: ifnonnull +6 -> 17
    //   14: ldc 99
    //   16: areturn
    //   17: aload_1
    //   18: ldc 101
    //   20: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +13 -> 36
    //   26: aload_2
    //   27: invokevirtual 111	java/lang/String:length	()I
    //   30: ifle +6 -> 36
    //   33: ldc 113
    //   35: areturn
    //   36: aload_1
    //   37: ldc 101
    //   39: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +31 -> 73
    //   45: aload 8
    //   47: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +9 -> 59
    //   53: aload 8
    //   55: invokestatic 125	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   58: pop2
    //   59: aload 9
    //   61: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +9 -> 73
    //   67: aload 9
    //   69: invokestatic 125	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: pop2
    //   73: aconst_null
    //   74: areturn
    //   75: astore_1
    //   76: ldc 127
    //   78: areturn
    //   79: astore_1
    //   80: ldc 129
    //   82: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	NearbyAppInterface
    //   0	83	1	paramString1	String
    //   0	83	2	paramString2	String
    //   0	83	3	paramString3	String
    //   0	83	4	paramString4	String
    //   0	83	5	paramString5	String
    //   0	83	6	paramInt1	int
    //   0	83	7	paramInt2	int
    //   0	83	8	paramString6	String
    //   0	83	9	paramString7	String
    //   0	83	10	paramString8	String
    //   0	83	11	paramString9	String
    // Exception table:
    //   from	to	target	type
    //   53	59	75	java/lang/Exception
    //   67	73	79	java/lang/Exception
  }
  
  public static void freePartBitmapCache()
  {
    if (BaseApplicationImpl.sImageCache != null)
    {
      int i = BaseApplicationImpl.sImageCache.size() * 3 / 4;
      BaseApplicationImpl.sImageCache.trimToSize(i);
    }
  }
  
  public void Ri(int paramInt)
  {
    this.dkg = paramInt;
    ajrb.a(getAccount(), "sp_nearby_mytab", 0, "key_nearby_mytab_zan_check", Integer.valueOf(this.dkg));
  }
  
  public ajre a()
  {
    if (this.jdField_a_of_type_Ajre == null) {
      this.jdField_a_of_type_Ajre = new ajre(this);
    }
    return this.jdField_a_of_type_Ajre;
  }
  
  public ajvd a()
  {
    return (ajvd)getManager(214);
  }
  
  public NearbyMyTabCard a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard;
  }
  
  public void a(ajve paramajve)
  {
    ajvd localajvd = (ajvd)getManager(214);
    if (localajvd != null) {
      localajvd.c(paramajve);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (!TextUtils.isEmpty(str)) {
      throw new IllegalArgumentException(str);
    }
    ThreadManager.post(new NearbyAppInterface.3(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9), 2, null, false);
  }
  
  public void a(oidb_0x8dd.SelfInfo paramSelfInfo)
  {
    if (paramSelfInfo == null) {
      return;
    }
    this.b = paramSelfInfo;
    if (paramSelfInfo.uint64_tinyid.get() != 0L) {
      ajrb.c(getAccount(), "self_tinnyid", Long.valueOf(paramSelfInfo.uint64_tinyid.get()));
    }
    if (!TextUtils.isEmpty(paramSelfInfo.bytes_nick.get().toStringUtf8())) {
      ajrb.c(getAccount(), "self_nick", paramSelfInfo.bytes_nick.get().toStringUtf8());
    }
    if (!TextUtils.isEmpty(paramSelfInfo.str_third_line_info.get())) {
      ajrb.c(getAccount(), "self_third_line_info", paramSelfInfo.str_third_line_info.get());
    }
    if (!TextUtils.isEmpty(paramSelfInfo.str_third_line_icon.get())) {
      ajrb.c(getAccount(), "self_third_line_icon", paramSelfInfo.str_third_line_icon.get());
    }
    if (paramSelfInfo.uint32_age.get() != -1) {
      ajrb.c(getAccount(), "self_age", Integer.valueOf(paramSelfInfo.uint32_age.get()));
    }
    int i;
    if (paramSelfInfo.uint32_gender.get() != -1) {
      switch (paramSelfInfo.uint32_gender.get())
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ajrb.c(getAccount(), "self_gender", Integer.valueOf(i));
      a().b(paramSelfInfo);
      return;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.iX.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.iX.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public void addObserver(acci paramacci)
  {
    addObserver(paramacci, false);
  }
  
  public void addObserver(acci paramacci, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.Du.contains(paramacci)) {
        this.Du.add(paramacci);
      }
    }
    while (this.Dt.contains(paramacci)) {
      return;
    }
    this.Dt.add(paramacci);
  }
  
  public NearbyMyTabCard b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard = akkx.a(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard;
  }
  
  public void b(ajve paramajve)
  {
    ajvd localajvd = (ajvd)getManager(214);
    if (localajvd != null) {
      localajvd.d(paramajve);
    }
  }
  
  public void c(NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard != paramNearbyMyTabCard) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard = paramNearbyMyTabCard;
    }
  }
  
  @TargetApi(14)
  public void cKW()
  {
    try
    {
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.app.getSystemService("accessibility");
      boolean bool1 = localAccessibilityManager.isEnabled();
      boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        AppSetting.enableTalkBack = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("NearbyAppInterface", 2, "set talkback enable: " + AppSetting.enableTalkBack);
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void dyD()
  {
    NearbyMyTabCard localNearbyMyTabCard = b();
    if (localNearbyMyTabCard != null)
    {
      localNearbyMyTabCard.visitors.clear();
      akkx.a(this, localNearbyMyTabCard);
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    NearbyEntityManagerFactory localNearbyEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
    if (localNearbyEntityManagerFactory != null) {
      localNearbyEntityManagerFactory.close();
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_Ajrc.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.getAppId();
  }
  
  public accg getBusinessHandler(int paramInt)
  {
    accg localaccg = (accg)this.el.get(Integer.valueOf(paramInt));
    if (localaccg == null) {}
    for (;;)
    {
      synchronized (this.el)
      {
        localaccg = (accg)this.el.get(Integer.valueOf(paramInt));
        if (localaccg == null) {
          break label113;
        }
        return localaccg;
        if (localaccg != null) {
          this.el.put(Integer.valueOf(paramInt), localaccg);
        }
        return localaccg;
      }
      Object localObject2 = new acig(this);
      continue;
      localObject2 = new acpp(this);
      continue;
      localObject2 = new advp(this);
      continue;
      return localObject2;
      label113:
      switch (paramInt)
      {
      }
    }
  }
  
  public List<acci> getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.Dt;
    }
    if (paramInt == 2) {
      return this.Du;
    }
    if (paramInt == 0) {
      return this.fc;
    }
    return this.fc;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getCurrentNickname()
  {
    if (this.b == null) {
      return getAccount();
    }
    return this.b.bytes_nick.get().toStringUtf8();
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    return getEntityManagerFactory(getAccount());
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(getAccount()))) {
      throw new IllegalStateException("Can not create a entity factory, the account is not match." + paramString + "!=" + getAccount());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
    }
    synchronized (this.eh)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory = new NearbyEntityManagerFactory(paramString);
        ThreadManager.getSubThreadHandler().postDelayed(new NearbyAppInterface.1(this), 1000L);
      }
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
    }
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = (Manager)this.iX.get(Integer.valueOf(paramInt));
    Object localObject3;
    if (localObject1 == null)
    {
      Map localMap = this.iX;
      switch (paramInt)
      {
      }
      for (;;)
      {
        try
        {
          if (this.iX.get(Integer.valueOf(paramInt)) == null) {
            break label383;
          }
          localObject4 = (Manager)this.iX.get(Integer.valueOf(paramInt));
          return localObject4;
        }
        finally {}
        localObject1 = new AccountManagerImpl(this);
        continue;
        localObject3 = new WtloginManagerImpl(this);
        continue;
        localObject3 = new TicketManagerImpl(this);
        continue;
        localObject3 = new ProxyIpManagerImpl(this);
        continue;
        localObject3 = new aehy(this);
        continue;
        localObject3 = new aomf();
        continue;
        localObject3 = new ajvd(this);
        continue;
        localObject3 = new DeviceProfileManager.AccountDpcManager(this);
        continue;
        localObject3 = new aqdm(this);
        continue;
        localObject3 = new ajro(this);
        continue;
        localObject3 = new ajra(this);
        continue;
        localObject3 = new advr(this);
        continue;
        localObject3 = new ajpp(this);
        continue;
        localObject3 = new UsingTimeReportManager(this);
        continue;
        localObject3 = new aqva(this);
        continue;
        label383:
        Object localObject4 = localObject3;
        if (localObject3 != null)
        {
          this.iX.put(Integer.valueOf(paramInt), localObject3);
          localObject4 = localObject3;
        }
      }
    }
    return localObject3;
  }
  
  public String getModuleId()
  {
    return "module_nearby";
  }
  
  public aolm getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Aomf == null) {
      this.jdField_a_of_type_Aomf = ((aomf)getManager(211));
    }
    return this.jdField_a_of_type_Aomf.a(this, paramInt);
  }
  
  public void iM(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      ajrk.m("updatePerfState", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.dkh) });
    }
    if (paramInt1 > this.dkh)
    {
      this.dkh = paramInt1;
      if (this.dkh == 1)
      {
        this.adf = System.currentTimeMillis();
        this.dki = paramInt2;
      }
    }
  }
  
  public void onBeforeExitProc() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Ajrc = new ajrc(this);
    this.Dt = new Vector();
    this.Du = new Vector();
    this.fc = new Vector();
    this.el = new HashMap(20);
    ((ajvd)getManager(214)).dzx();
    ThreadManager.post(new NearbyAppInterface.2(this), 8, null, true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mHwEngine != null) {
      this.mHwEngine.closeEngine();
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        boolean bool = this.cpJ;
        if (bool) {
          try
          {
            DeviceProfileManager.a(this, 215).j(this);
            synchronized (this.iX)
            {
              Object localObject2 = this.iX.keySet();
              if ((localObject2 == null) || (((Set)localObject2).size() <= 0)) {
                break;
              }
              localObject2 = ((Set)localObject2).iterator();
              bool = ((Iterator)localObject2).hasNext();
              if (!bool) {
                break;
              }
              try
              {
                Manager localManager = (Manager)this.iX.get(((Iterator)localObject2).next());
                if (localManager == null) {
                  continue;
                }
                localManager.onDestroy();
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              ajrk.m("NearbyAppInterface", new Object[] { "onDestroy", localException2.toString() });
            }
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("NearbyAppInterface", 2, "onDestroy: ", localException1);
            continue;
          }
        }
      }
      this.cpJ = true;
    }
    this.iX.clear();
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    ajrk.m("onReceiveAccountAction", new Object[0]);
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramString)) {
      ((UsingTimeReportManager)getManager(221)).ecu();
    }
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    ajrk.m("onReceiveLegalExitProcAction", new Object[0]);
    return false;
  }
  
  public void removeObserver(acci paramacci)
  {
    this.Dt.remove(paramacci);
    this.Du.remove(paramacci);
    this.fc.remove(paramacci);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (!TextUtils.isEmpty(str)) {
      throw new IllegalArgumentException(str);
    }
    a().a(false, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (!TextUtils.isEmpty(str)) {
      throw new IllegalArgumentException(str);
    }
    a().a(true, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Ajrc.g(paramToServiceMsg);
  }
  
  public void start(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface$a = new a(null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface$a);
    super.start(paramBoolean);
  }
  
  class a
    implements INetInfoHandler
  {
    private a() {}
    
    public void onNetMobile2None()
    {
      if (NearbyAppInterface.i(NearbyAppInterface.this) != null) {
        NearbyAppInterface.j(NearbyAppInterface.this).onNetMobile2None();
      }
    }
    
    public void onNetMobile2Wifi(String paramString)
    {
      if (NearbyAppInterface.g(NearbyAppInterface.this) != null) {
        NearbyAppInterface.h(NearbyAppInterface.this).onNetMobile2Wifi(paramString);
      }
    }
    
    public void onNetNone2Mobile(String paramString)
    {
      if (NearbyAppInterface.a(NearbyAppInterface.this) != null) {
        NearbyAppInterface.b(NearbyAppInterface.this).onNetNone2Mobile(paramString);
      }
    }
    
    public void onNetNone2Wifi(String paramString)
    {
      if (NearbyAppInterface.e(NearbyAppInterface.this) != null) {
        NearbyAppInterface.f(NearbyAppInterface.this).onNetNone2Wifi(paramString);
      }
    }
    
    public void onNetWifi2Mobile(String paramString)
    {
      if (NearbyAppInterface.c(NearbyAppInterface.this) != null) {
        NearbyAppInterface.d(NearbyAppInterface.this).onNetWifi2Mobile(paramString);
      }
    }
    
    public void onNetWifi2None()
    {
      if (NearbyAppInterface.k(NearbyAppInterface.this) != null) {
        NearbyAppInterface.l(NearbyAppInterface.this).onNetWifi2None();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyAppInterface
 * JD-Core Version:    0.7.0.1
 */