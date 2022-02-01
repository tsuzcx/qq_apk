package com.tencent.qqmail.marcos;

import com.tencent.qqmail.utilities.deviceid.AppInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SafetyApps
{
  private static String TAG = "SafetyApps";
  public static final String app1 = "com.qihoo.cleandroid_cn";
  public static final String app10 = "cn.opda.a.phonoalbumshoushou";
  public static final String app11 = "com.androidlord.optimizationbox";
  public static final String app12 = "com.misoft.fengkuangjiasuqi29";
  public static final String app13 = "com.rootuninstaller.ramboosterpro";
  public static final String app14 = "net.hidroid.himanager";
  public static final String app15 = "net.hidroid.hitask";
  public static final String app16 = "com.mobo.task.killer.cn";
  public static final String app17 = "com.ijinshan.duba";
  public static final String app18 = "com.fractalist.MobileOptimizer";
  public static final String app19 = "com.cleanmaster.mguard_cn";
  public static final String app2 = "com.qihoo360.mobilesafe";
  public static final String app20 = "com.aidian.flowhelper";
  public static final String app21 = "com.ludashi.benchmark";
  public static final String app22 = "imoblife.memorybooster.lite";
  public static final String app23 = "com.spring.sdcard.speedup";
  public static final String app24 = "com.smartprojects.RAMOptimization";
  public static final String app25 = "com.memory.optimization";
  public static final String app26 = "imoblife.toolbox.full";
  public static final String app27 = "com.xyr.systemheigthclear";
  public static final String app28 = "com.frimmon.gManagerLite";
  public static final String app29 = "mobi.thinkchange.android.phoneboost";
  public static final String app3 = "com.qihoo360.mobilesafe.opti";
  public static final String app30 = "com.wgb.shoujijiasulajiqingli";
  public static final String app31 = "com.fractalist.MobileAcceleration";
  public static final String app32 = "com.onion.accelerator";
  public static final String app33 = "com.feistma.sysaccelerate";
  public static final String app34 = "com.onion.fk";
  public static final String app35 = "com.tencent.qqpimsecure";
  public static final String app36 = "com.tencent.wesecure";
  public static final String app37 = "com.tencent.qqpadsecure";
  public static final String app38 = "com.subao.husubao";
  public static final String app39 = "com.speed.boost";
  public static final String app4 = "com.g365.accelerate";
  public static final String app40 = "com.fractalist.SystemOptimizer";
  public static final String app41 = "cn.lgx.cleanshake";
  public static final String app42 = "com.yijianjiasu";
  public static final String app43 = "cn.com.opda.android.clearmaster";
  public static final String app44 = "com.syezon.lab.app_accelerator";
  public static final String app45 = "com.zte.heartyservice";
  public static final String app46 = "com.zdworks.android.toolbox";
  public static final String app47 = "droidmate.memboosterpro";
  public static final String app48 = "com.lyy.asmartuninstaller";
  public static final String app49 = "com.ZhiNengJiaSupgys.ielvs";
  public static final String app5 = "com.anguanjia.safe.optimizer";
  public static final String app50 = "com.rootuninstaller.ramboosterpro";
  public static final String app51 = "com.tencent.token";
  public static final String app52 = "com.smartprojects.RAMOptimization";
  public static final String app53 = "com.anyisheng.doctoran";
  public static final String app54 = "com.hao.shoujimanager";
  public static final String app55 = "com.ijinshan.mguard";
  public static final String app56 = "com.nqmobile.antivirus20";
  public static final String app57 = "com.andy.speedup";
  public static final String app58 = "com.sdincrease.premium.it";
  public static final String app59 = "z.a";
  public static final String app6 = "com.anguanjia.safe";
  public static final String app60 = "faster.mobile.phone.samsung.nokia";
  public static final String app61 = "com.uc.addon.processkiller";
  public static final String app62 = "com.triangle.accelerator6chuiqijiasu";
  public static final String app63 = "com.misoft.accelerator21dayuejin";
  public static final String app64 = "com.coolmob.acceleratorsimp1229";
  public static final String app65 = "com.rootuninstaller.nrambooster1";
  public static final String app66 = "milo.peakbar.tunerpro";
  public static final String app67 = "com.lenovo.safecenter";
  public static final String app68 = "lv.n3o.swapper";
  public static final String app69 = "com.lbe.security";
  public static final String app7 = "com.antutu.ABenchMark";
  public static final String app70 = "com.tdx.roothelper";
  public static final String app8 = "com.fractalist.MobileAcceleration_V5";
  public static final String app9 = "com.dianxinos.optimizer.duplay";
  private static HashMap<String, String> safetyapps = new HashMap();
  
  private static BigInteger generate(BigInteger paramBigInteger, String paramString)
  {
    BigInteger localBigInteger = new BigInteger("1");
    if ((paramString == null) || (paramString.equals(""))) {
      throw new DevRuntimeException("SafetyApps generate code fail for null input");
    }
    return paramBigInteger.or(localBigInteger.shiftLeft(Integer.parseInt(paramString.split("app")[1]) - 1));
  }
  
  public static BigInteger generateInstalledSafetyAppsCode()
  {
    BigInteger localBigInteger = new BigInteger("0");
    if (((safetyapps == null) || (safetyapps.size() == 0)) && (!init())) {
      return localBigInteger;
    }
    Object localObject = DeviceUtil.getInstalledApps();
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      localObject = localBigInteger;
      if (!localIterator.hasNext()) {
        break label123;
      }
      localObject = (AppInfo)localIterator.next();
      if ((localObject == null) || (((AppInfo)localObject).packageName == null) || (((AppInfo)localObject).packageName.equals("")) || (!isSafetyApp((AppInfo)localObject))) {
        break label125;
      }
      localBigInteger = generate(localBigInteger, (String)safetyapps.get(((AppInfo)localObject).packageName));
    }
    label123:
    label125:
    for (;;)
    {
      break;
      localObject = localBigInteger;
      return localObject;
    }
  }
  
  private static boolean init()
  {
    boolean bool2 = true;
    Field[] arrayOfField = SafetyApps.class.getDeclaredFields();
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      try
      {
        if (i < arrayOfField.length)
        {
          arrayOfField[i].setAccessible(true);
          if ((arrayOfField[i].getName() != null) && (arrayOfField[i].getName().startsWith("app"))) {
            safetyapps.put(arrayOfField[i].get(null).toString(), arrayOfField[i].getName());
          }
          i += 1;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, TAG, "SafetyApps init err:" + localException.toString());
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private static boolean isSafetyApp(AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while (!safetyapps.containsKey(paramAppInfo.packageName)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.marcos.SafetyApps
 * JD-Core Version:    0.7.0.1
 */