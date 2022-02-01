package com.tencent.mobileqq.utils;

import acfp;
import aewh;
import anaz;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import anki;
import anpl;
import aqfo;
import aqgd;
import aqgz;
import aqmj;
import aqmr;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVColorStateList;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import imm;
import irc;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jlg;
import jll;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AudioHelper
{
  private static final int[] OP_IN_ANDROID_SDK_API19;
  private static final int[] OP_IN_ANDROID_SDK_BEFORE_API19;
  static long asH;
  private static a[] b;
  private static boolean cTO;
  private static boolean cTP;
  public static boolean cTQ;
  public static boolean cTR;
  public static boolean cTS;
  static boolean cTT;
  static String csR;
  static String csS;
  private static int dZc;
  private static long mUin;
  public static final int[] oW;
  private static boolean soLoaded;
  
  static
  {
    boolean bool = false;
    OP_IN_ANDROID_SDK_BEFORE_API19 = new int[] { 35, 36 };
    OP_IN_ANDROID_SDK_API19 = new int[] { 26, 27 };
    oW = new int[35];
    int i = 0;
    while (i < 35)
    {
      oW[i] = -1000;
      i += 1;
    }
    csR = "actAVFunChatExpression";
    if (Build.VERSION.SDK_INT >= 17) {
      bool = true;
    }
    cTS = bool;
  }
  
  public static void G(AppInterface paramAppInterface)
  {
    ThreadManager.getFileThreadHandler().post(new AudioHelper.2(paramAppInterface));
  }
  
  public static void I(String paramString, Bundle paramBundle)
  {
    b(paramString, paramBundle, false);
  }
  
  public static final void UA(String paramString)
  {
    QLog.w("测试开关", 1, paramString);
  }
  
  public static void UB(String paramString)
  {
    if (isDev())
    {
      QLog.w("AudioHelper", 1, "showDebugToast, text[" + paramString + "]");
      ThreadManager.getUIHandler().post(new AudioHelper.3(paramString));
    }
  }
  
  /* Error */
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 116	com/tencent/mobileqq/utils/AudioHelper:soLoaded	Z
    //   6: ifne +27 -> 33
    //   9: getstatic 118	com/tencent/mobileqq/utils/AudioHelper:dZc	I
    //   12: iconst_3
    //   13: if_icmpge +20 -> 33
    //   16: getstatic 118	com/tencent/mobileqq/utils/AudioHelper:dZc	I
    //   19: iconst_1
    //   20: iadd
    //   21: putstatic 118	com/tencent/mobileqq/utils/AudioHelper:dZc	I
    //   24: aload_0
    //   25: ldc 120
    //   27: invokestatic 126	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   30: putstatic 116	com/tencent/mobileqq/utils/AudioHelper:soLoaded	Z
    //   33: getstatic 116	com/tencent/mobileqq/utils/AudioHelper:soLoaded	Z
    //   36: ifeq +17 -> 53
    //   39: aload_1
    //   40: iload_2
    //   41: fload_3
    //   42: invokestatic 130	com/tencent/mobileqq/utils/AudioHelper:enlargeVolum	([BIF)J
    //   45: lstore 4
    //   47: ldc 2
    //   49: monitorexit
    //   50: lload 4
    //   52: lreturn
    //   53: ldc2_w 131
    //   56: lstore 4
    //   58: goto -11 -> 47
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramContext	Context
    //   0	67	1	paramArrayOfByte	byte[]
    //   0	67	2	paramInt	int
    //   0	67	3	paramFloat	float
    //   45	12	4	l	long
    // Exception table:
    //   from	to	target	type
    //   3	33	61	finally
    //   33	47	61	finally
  }
  
  private static a a(int paramInt, a parama)
  {
    parama = new a(parama.dZd, parama.mode, parama.cTU);
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.AccountDpcManager.DpcAccountNames.qq_audio_play_fix.name(), null);
    if (QLog.isColorLevel()) {
      QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig | dpcConfig = " + (String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (paramInt == 0)
        {
          if (!"-1".equals(localObject[0])) {
            parama.mode = Integer.parseInt(localObject[0]);
          }
          if (!"-1".equals(localObject[1]))
          {
            parama.dZd = Integer.parseInt(localObject[1]);
            return parama;
          }
        }
        else if (paramInt == 1)
        {
          if (!"-1".equals(localObject[2])) {
            parama.mode = Integer.parseInt(localObject[2]);
          }
          if (!"-1".equals(localObject[3]))
          {
            parama.dZd = Integer.parseInt(localObject[3]);
            return parama;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig error.", localException);
        }
      }
    }
    return parama;
  }
  
  public static String a(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = paramResources.getResourceEntryName(paramInt);
      return "[" + paramInt + "][" + paramResources + "]";
    }
    catch (Exception paramResources)
    {
      for (;;)
      {
        paramResources = paramResources.getClass().getName();
      }
    }
  }
  
  public static String a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramAppInterface == null)
    {
      QLog.d("AudioHelper", 1, "BaseInfo, AppInterface is empty");
      return "BaseInfo, AppInterface is empty";
    }
    for (;;)
    {
      try
      {
        if (csS == null)
        {
          if ((paramAppInterface instanceof VideoAppInterface))
          {
            l = imm.getMaxCpuFreq();
            csS = "BaseInfo, APPID[" + AppSetting.getAppId() + "], \nisPublicVersion[" + true + "], \nisGrayVersion[" + false + "], \nisDebugVersion[" + false + "], \nquaMainVersion[" + "2013 3.4.4" + "], \nversionCode[" + aewh.getVersionCode(paramAppInterface.getApp()) + "], \nrevision[" + AppSetting.getRevision() + "], \nisSupporImmersive[" + ImmersiveUtils.isSupporImmersive() + "], \nStatusBarHeight[" + ImmersiveUtils.getStatusBarHeight(paramAppInterface.getApp()) + "], \nhasSmartBar[" + jll.hasSmartBar() + "], \naboutSubVersionLog[" + AppSetting.nU() + "], \ngetQUA[" + s(AppSetting.getQUA()) + "], \nTYPE[" + Build.TYPE + "], \nTAGS[" + Build.TAGS + "], \nMANUFACTURER[" + Build.MANUFACTURER + "], \nPRODUCT[" + Build.PRODUCT + "], \nRELEASE[" + Build.VERSION.RELEASE + "], \nDISPLAY[" + Build.DISPLAY + "], \nCODENAME[" + Build.VERSION.CODENAME + "], \nINCREMENTAL[" + Build.VERSION.INCREMENTAL + "], \nBRAND[" + Build.BRAND + "], \nMODEL[" + Build.MODEL + "], \nCPU_ABI[" + Build.CPU_ABI + "], \nCPU_ABI2[" + Build.CPU_ABI2 + "], \nCPU[" + Build.HARDWARE + "], \nCPUModel[" + imm.gU() + "], \nisExistSDCard[" + aqfo.isExistSDCard() + "], \nsdkVersion[" + Build.VERSION.SDK_INT + "], \ndevicesInfo[" + AppSetting.aHR + "], \nVendorId[" + imm.gW() + "], \nIsMarvell[" + imm.tZ() + "], \nOpenGLVersion[" + imm.lf() + "], \nGLVersion[" + irc.getGLVersion(paramAppInterface.getApp()) + "], \ncupReport[" + imm.getCpuReport() + "], \nFeature[" + imm.gV() + "], \nMaxCpuFreq[" + l + "], \nSystemTotalMemory[" + aqgz.getSystemTotalMemory() + "], \nCpuNum[" + aqgz.getCpuNumber() + "], \nuid[" + paramAppInterface.getApp().getApplicationInfo().uid + "], \nPermission_PackageName[" + paramAppInterface.getApp().getPackageName() + "], \n";
          }
        }
        else
        {
          DisplayMetrics localDisplayMetrics = paramAppInterface.getApp().getResources().getDisplayMetrics();
          paramAppInterface = csS + "UIN[" + paramAppInterface.getAccount() + "], \ndisplayMetrics[" + localDisplayMetrics + "], \ndensity[" + localDisplayMetrics.density + "], \ndensityDpi[" + localDisplayMetrics.densityDpi + "], \nlogLevel[" + QLog.getUIN_REPORTLOG_LEVEL() + "], \nisDevelopLevel[" + QLog.isDevelopLevel() + "], \nisColorLevel[" + QLog.isColorLevel() + "], \nsProcessId[" + BaseApplicationImpl.sProcessId + "], \nprocessName[" + BaseApplicationImpl.processName + "], \nUIThread[" + ThreadManager.getUIHandler().getLooper().getThread().getId() + "], \nCurThread[" + Thread.currentThread().getId() + "], \nisTestEnvironment[" + paramInt + "], \ntid[" + Process.myTid() + "], \nmyPid[" + Process.myPid() + "], \nmyUid[" + Process.myUid() + "]";
          QLog.d("AudioHelper", 1, paramAppInterface);
          return paramAppInterface;
        }
      }
      catch (Exception paramAppInterface)
      {
        QLog.w("AudioHelper", 1, "printBaseInfo, Exception", paramAppInterface);
        return paramAppInterface.getMessage();
      }
      long l = aqgz.getCpuFrequency();
    }
  }
  
  public static void a(int paramInt, a parama)
  {
    String str = "!@$#_" + paramInt + "_";
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit().putInt(str + "m", parama.mode).putInt(str + "s", parama.dZd).putBoolean(str + "so", parama.cTU).commit();
  }
  
  public static void a(Resources paramResources, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "changButtonStyle button is null");
      }
    }
    do
    {
      return;
      if (paramInt1 != 0)
      {
        Drawable localDrawable = paramResources.getDrawable(paramInt1);
        jlg localjlg = jlg.a(paramResources, paramInt1, paramInt2);
        localjlg.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        paramTextView.setCompoundDrawables(null, localjlg, null, null);
      }
    } while (paramInt3 == 0);
    paramTextView.setTextColor(AVColorStateList.a(paramResources, paramInt3));
  }
  
  public static boolean a(BaseApplicationImpl paramBaseApplicationImpl, long paramLong)
  {
    if (!cTQ) {
      cTQ = isDev();
    }
    lX(paramLong);
    if (paramBaseApplicationImpl != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.video.q2v.debug");
      if (paramBaseApplicationImpl.registerReceiver(new aqgd(paramBaseApplicationImpl), localIntentFilter) != null) {
        return true;
      }
    }
    return false;
  }
  
  public static a[] a()
  {
    try
    {
      if (b == null)
      {
        b = new a[5];
        b[0] = b(0);
        b[1] = b(1);
        b[2] = b(2);
        b[3] = b(3);
        b[4] = b(4);
      }
      a[] arrayOfa = b;
      return arrayOfa;
    }
    finally {}
  }
  
  public static boolean aCA()
  {
    if (!anki.axN())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment true");
      }
      return true;
    }
    if (cTP)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "isHuaweiGreenForSegmentLocal " + cTO);
      }
      return cTO;
    }
    cTP = true;
    String str1 = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    String[] arrayOfString = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;BLN-AL40;24|HUAWEI;FRD-AL10;24|HUAWEI;HUAWEI NXT-DL00;24|HUAWEI;NEXT;23|vivo;vivo X5Pro D;21|asus;ASUS_Z00ADB;21|HUAWEI;LON-AL00;26|HUAWEI;COL-AL10;27|HUAWEI;STF_AL00;26".split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        if ((str2 != null) && (str2.equals(str1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment true: " + str1);
          }
          cTO = true;
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static boolean aCg()
  {
    String str = Build.MODEL;
    int i;
    if (((Build.MANUFACTURER.equalsIgnoreCase("Samsung")) || (str.contains("MI 2")) || (str.contains("Nexus 4"))) && (Build.VERSION.SDK_INT >= 11))
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
    }
    label57:
    while ((str.contains("SCH-I699")) && (Build.VERSION.SDK_INT == 10))
    {
      return true;
      i = 0;
      break;
    }
    return false;
  }
  
  private static boolean aCh()
  {
    return (Build.MODEL.contains("HUAWEI Y 200T")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  public static boolean aCi()
  {
    String str2 = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    String str1 = aqmj.bm(BaseApplicationImpl.getContext());
    Object localObject = str1;
    if (aqmr.isEmpty(str1)) {
      localObject = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24";
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioHelper", 2, "isHuaweiGreen greenList: " + (String)localObject + ", feature :" + str2);
    }
    localObject = ((String)localObject).split("\\|");
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        str1 = localObject[i];
        if ((str1 != null) && (str1.equals(str2)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioHelper", 2, "isHuaweiGreen true: " + str2);
          }
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static boolean aCj()
  {
    return (Build.MODEL.contains("Lenovo A278t")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean aCk()
  {
    return (Build.MODEL.contains("ZTE-T U960s")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean aCl()
  {
    return Build.MODEL.contains("5910");
  }
  
  public static boolean aCm()
  {
    return Build.MODEL.contains("Lenovo K900");
  }
  
  private static boolean aCn()
  {
    return Build.MODEL.contains("V926");
  }
  
  private static boolean aCo()
  {
    return Build.MODEL.contains("ZTE N881E");
  }
  
  private static boolean aCp()
  {
    return Build.MODEL.contains("LNV-Lenovo S870e");
  }
  
  private static boolean aCq()
  {
    return Build.MODEL.contains("Coolpad 5891Q");
  }
  
  private static boolean aCr()
  {
    return (Build.MODEL.contains("ME860")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean aCs()
  {
    return Build.MODEL.contains("GT-S7500");
  }
  
  public static boolean aCt()
  {
    return (aCv()) || (aCu());
  }
  
  private static boolean aCu()
  {
    return Build.MODEL.contains("Lenovo A750");
  }
  
  private static boolean aCv()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (str.contains("X907"));
  }
  
  private static boolean aCw()
  {
    return "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean aCx()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((localBluetoothAdapter == null) || (!localBluetoothAdapter.isEnabled())) {}
    while (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(2) != 2) {
      return false;
    }
    return true;
  }
  
  private static boolean aCy()
  {
    if (jY(15) == 1)
    {
      UA(acfp.m(2131702921));
      return true;
    }
    return false;
  }
  
  public static boolean aCz()
  {
    return QLog.isColorLevel();
  }
  
  private static a b(int paramInt)
  {
    a locala;
    if (paramInt == 0) {
      locala = d();
    }
    for (;;)
    {
      String str = "!@$#_" + paramInt + "_";
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext());
      locala.mode = localSharedPreferences.getInt(str + "m", locala.mode);
      locala.dZd = localSharedPreferences.getInt(str + "s", locala.dZd);
      locala.cTU = localSharedPreferences.getBoolean(str + "so", locala.cTU);
      return a(paramInt, locala);
      if (paramInt == 1)
      {
        locala = e();
      }
      else if (paramInt == 2)
      {
        locala = d();
        locala.cTU = false;
      }
      else if (paramInt == 3)
      {
        locala = d();
        locala.cTU = false;
      }
      else
      {
        locala = f();
        locala.cTU = false;
      }
    }
  }
  
  public static String b(View paramView, int paramInt)
  {
    try
    {
      paramView = paramView.getResources().getResourceEntryName(paramInt);
      return "[" + paramInt + "][" + paramView + "]";
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = paramView.getClass().getName();
      }
    }
  }
  
  public static void b(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if ((paramBoolean) || (QLog.isDevelopLevel()))
    {
      String str1 = "BundleValue[" + paramString + "]:\n";
      if (paramBundle != null) {
        paramString = str1;
      }
      try
      {
        localIterator = paramBundle.keySet().iterator();
        paramString = str1;
      }
      catch (Exception localException1)
      {
        Iterator localIterator;
        String str2;
        Object localObject3;
        Object localObject2;
        int i;
        label138:
        label191:
        paramBundle = paramString;
        paramString = localException1;
        if (!QLog.isDevelopLevel()) {
          return;
        }
        new StringBuilder().append(paramBundle).append("Exception").toString();
        QLog.w("AudioHelper", 1, "log", paramString);
        return;
      }
      try
      {
        if (!localIterator.hasNext()) {
          break label309;
        }
        str2 = (String)localIterator.next();
        localObject3 = paramBundle.get(str2);
        if ((localObject3 == null) || (!(localObject3 instanceof long[]))) {
          break label404;
        }
        localObject2 = (long[])localObject3;
        str1 = "" + localObject2.length;
        i = 0;
        if ((i >= localObject2.length) || (i >= 5)) {
          break label410;
        }
        str1 = str1 + "[" + localObject2[i] + "]";
        i += 1;
        break label138;
      }
      catch (Exception localException2)
      {
        paramBundle = paramString;
        paramString = localException2;
        break label356;
        Object localObject1 = null;
        break label191;
        break label191;
      }
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "" + localObject3;
      }
      localObject2 = new StringBuilder().append(paramString).append("    [").append(str2).append("]=[").append((String)localObject2).append("], [");
      if (localObject3 == null) {}
      for (str1 = null;; str1 = localObject3.getClass().getSimpleName())
      {
        str1 = str1 + "]\n";
        paramString = str1;
        break;
      }
      label309:
      for (paramBundle = paramString;; paramBundle = str1 + "bundle为空")
      {
        paramString = paramBundle;
        QLog.w("AudioHelper", 1, paramBundle);
        return;
        paramString = str1;
      }
    }
    label356:
  }
  
  public static <T1, T2> void b(String paramString, Map<T1, T2> paramMap, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramBoolean) || (QLog.isDevelopLevel()))
    {
      paramString = "MapValue[" + paramString + "]:\n";
      if (paramMap != null) {
        localObject1 = paramString;
      }
    }
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      Object localObject2 = paramString;
      localObject1 = paramString;
      if (localIterator.hasNext())
      {
        localObject1 = paramString;
        Object localObject3 = localIterator.next();
        localObject1 = paramString;
        localObject2 = paramMap.get(localObject3);
        localObject1 = paramString;
        String str = "" + localObject2;
        localObject1 = paramString;
        localObject3 = new StringBuilder().append(paramString).append("    [").append(localObject3).append("]=[").append(str).append("], [");
        if (localObject2 == null) {}
        for (localObject2 = null;; localObject2 = localObject2.getClass().getSimpleName())
        {
          localObject1 = paramString;
          paramString = (String)localObject2 + "]\n";
          break;
          localObject1 = paramString;
        }
        localObject1 = paramString;
        localObject2 = paramString + "bundle为空";
      }
      localObject1 = localObject2;
      QLog.w("AudioHelper", 1, (String)localObject2);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isDevelopLevel()) {}
      new StringBuilder().append((String)localObject1).append("Exception").toString();
      QLog.w("AudioHelper", 1, "log", paramString);
    }
  }
  
  public static boolean bL(Context paramContext)
  {
    if (aCx())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "isBluetoothHeadsetOn(), isBluetoothA2dpOn = true");
      }
      return true;
    }
    return bM(paramContext);
  }
  
  public static boolean bM(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    boolean bool1 = paramContext.isBluetoothScoOn();
    boolean bool2 = AudioPlayer.a(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "isBluetoothScoOn(), isSCOOn = " + bool1 + " | isNeedWaitOpenSCO = " + bool2);
    }
    return (bool1) || (bool2);
  }
  
  public static boolean bN(Context paramContext)
  {
    return ((AudioManager)paramContext.getSystemService("audio")).isBluetoothScoOn();
  }
  
  public static a d()
  {
    if (aCg()) {
      return new a(0, 0, true);
    }
    return new a(3, 0, true);
  }
  
  public static void dj(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localHashMap.put("expID", paramString);
      localHashMap.put("action", str);
      UserAction.onUserAction(csR, true, -1L, -1L, localHashMap, true);
      if (jY(2) == 1) {
        QLog.d(csR, 4, String.format("expID[%s], action[%s]", new Object[] { paramString, str }));
      }
      return;
    }
  }
  
  @TargetApi(11)
  public static a e()
  {
    if (aCr()) {
      return new a(0, 0, false);
    }
    if (aCh()) {
      return new a(0, 0, false);
    }
    if (aCj()) {
      return new a(0, 0, false);
    }
    if (aCk()) {
      return new a(0, 0, false);
    }
    if (aCl()) {
      return new a(0, 0, false);
    }
    if (aCn()) {
      return new a(0, 0, false);
    }
    if ((aCm()) || (isVivoX9())) {
      return new a(0, 0, false);
    }
    if (aCo()) {
      return new a(0, 2, false);
    }
    if (aCp()) {
      return new a(0, 2, false);
    }
    if (aCq()) {
      return new a(3, 3, false);
    }
    if (aCs()) {
      return new a(0, 0, false);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new a(0, 3, false);
    }
    return new a(0, 2, false);
  }
  
  @TargetApi(17)
  public static long elapsedRealtimeNanos()
  {
    if (cTS) {
      return SystemClock.elapsedRealtimeNanos();
    }
    return 0L;
  }
  
  @Deprecated
  public static native long enlargeVolum(byte[] paramArrayOfByte, int paramInt, float paramFloat);
  
  public static a f()
  {
    return new a(0, 2, true);
  }
  
  public static void fx(Context paramContext)
  {
    if (!cTQ) {
      cTQ = isDev();
    }
    if (jY(2) == 1)
    {
      QLog.d("AudioHelper", 1, "setBeaconDebug begin");
      anpl.start();
      QLog.d("AudioHelper", 1, "setBeaconDebug end");
    }
  }
  
  public static void g(String paramString, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      b(paramString, paramIntent.getExtras(), false);
      return;
    }
    paramString = "MapValue[" + paramString + "]:\n";
    QLog.w("AudioHelper", 1, paramString + "intent为空");
  }
  
  public static long hF()
  {
    if (aCy()) {
      return System.currentTimeMillis();
    }
    return anaz.gQ() * 1000L;
  }
  
  public static long hG()
  {
    try
    {
      long l = asH;
      asH += 1L;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isDev()
  {
    return false;
  }
  
  public static boolean isForbidByRubbishMeizu(int paramInt)
  {
    return isForbidByRubbishMeizu(paramInt, BaseApplicationImpl.getContext());
  }
  
  public static boolean isForbidByRubbishMeizu(int paramInt, Context paramContext)
  {
    if ((!isRubbishMeizuPhone()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getSystemService("appops");
      if ((paramContext != null) && (paramContext.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = paramContext.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i = OP_IN_ANDROID_SDK_API19[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i = OP_IN_ANDROID_SDK_BEFORE_API19[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(paramContext, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishMeizu(), result = " + paramInt);
          }
          if (paramInt != 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception paramContext) {}
      }
    }
    QLog.e(AudioHelper.class.getSimpleName(), 2, paramContext.toString());
    return false;
  }
  
  private static boolean isRubbishMeizuPhone()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean isVivoX9()
  {
    return Build.MODEL.contains("vivo X9");
  }
  
  public static int jY(int paramInt)
  {
    if (!cTQ) {
      return -1;
    }
    if (oW[paramInt] == -1000)
    {
      if (mUin == 0L)
      {
        QLog.w("AudioHelper", 1, "getDebugValue, uin is empty, [" + paramInt + "]");
        return -1;
      }
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("debugconfig_" + mUin, 4);
      oW[paramInt] = localSharedPreferences.getInt("debugvalue" + paramInt, -1);
      QLog.w("AudioHelper", 1, "getDebugValue, [" + paramInt + "]=[" + oW[paramInt] + "], mUin[" + mUin + "]");
    }
    return oW[paramInt];
  }
  
  public static void lX(long paramLong)
  {
    if (mUin != paramLong)
    {
      mUin = paramLong;
      int i = 0;
      while (i < 35)
      {
        oW[i] = -1000;
        i += 1;
      }
    }
  }
  
  public static String m(AppInterface paramAppInterface)
  {
    return a(paramAppInterface, -1);
  }
  
  public static boolean mr(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioHelper", 2, "SDK_INT: " + Build.VERSION.SDK_INT + " Man: " + Build.MANUFACTURER);
    }
    if ((!aCw()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      Object localObject = BaseApplicationImpl.getContext().getSystemService("appops");
      if ((localObject != null) && (localObject.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = localObject.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i = OP_IN_ANDROID_SDK_API19[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i = OP_IN_ANDROID_SDK_BEFORE_API19[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(localObject, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishXiaomi(), result = " + paramInt);
          }
          if (paramInt != 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception localException) {}
      }
    }
    QLog.e(AudioHelper.class.getSimpleName(), 2, localException.toString());
    return false;
  }
  
  @TargetApi(17)
  public static void rw(String paramString)
  {
    if ((cTS) && (cTT))
    {
      long l = SystemClock.elapsedRealtimeNanos();
      QLog.w("AudioHelper", 1, "printTime[" + paramString + "], time[" + l + "]");
    }
  }
  
  public static String s(Object paramObject)
  {
    if (isDev())
    {
      Object localObject;
      int j;
      String str;
      int i;
      if ((paramObject instanceof String[]))
      {
        localObject = (String[])paramObject;
        j = localObject.length;
        str = "";
        i = 0;
        for (;;)
        {
          paramObject = str;
          if (i >= j) {
            break;
          }
          paramObject = localObject[i];
          paramObject = str + paramObject;
          str = paramObject + "|";
          i += 1;
        }
      }
      if ((paramObject instanceof int[]))
      {
        localObject = (int[])paramObject;
        j = localObject.length;
        str = "";
        i = 0;
        for (;;)
        {
          paramObject = str;
          if (i >= j) {
            break;
          }
          int k = localObject[i];
          paramObject = str + k;
          str = paramObject + "|";
          i += 1;
        }
      }
      paramObject = "" + paramObject;
      return paramObject;
    }
    if (paramObject == null) {
      return "null.";
    }
    if ((paramObject instanceof String))
    {
      if (TextUtils.isEmpty((String)paramObject)) {
        return "*";
      }
      return "**";
    }
    return "***";
  }
  
  public static long stringToLong(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static class a
  {
    public boolean cTU;
    public int dZd;
    public int mode;
    
    public a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.dZd = paramInt1;
      this.mode = paramInt2;
      this.cTU = paramBoolean;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (!(paramObject instanceof a)) {
          break;
        }
        paramObject = (a)paramObject;
      } while ((paramObject.dZd == this.dZd) && (paramObject.mode == this.mode) && (paramObject.cTU == this.cTU));
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper
 * JD-Core Version:    0.7.0.1
 */