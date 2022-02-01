package com.tencent.mobileqq.theme;

import afgc;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import anlk;
import anlm;
import anpc;
import anwa;
import aofy;
import aogy;
import aogz;
import aohc;
import aqgz;
import aqhq;
import aqiw;
import aqqm;
import aqrh;
import aqri;
import aqsu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import imm;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import wja;

public class ThemeSwitcher
  implements Handler.Callback, aqqm
{
  private static ThemeSwitcher jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
  private static ThemeSwitcher jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher;
  public static final HashSet<String> bA;
  private static AtomicBoolean dU = new AtomicBoolean(false);
  private DownloadListenser jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher$DownloadListenser;
  private long apa;
  private aogy jdField_b_of_type_Aogy = new aogy();
  private a jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher$a;
  private String ckK;
  private AtomicBoolean done = new AtomicBoolean(false);
  private String from;
  private Handler handler = new Handler(Looper.getMainLooper(), this);
  private long startTime;
  private WeakReference<QQAppInterface> weakApp;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("204");
    localHashSet.add("203");
    localHashSet.add("206");
    localHashSet.add("212");
    bA = localHashSet;
  }
  
  private ThemeSwitcher(QQAppInterface paramQQAppInterface, a parama, String paramString1, String paramString2)
  {
    this.weakApp = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher$a = parama;
    this.from = paramString2;
    this.jdField_b_of_type_Aogy.a(paramString1);
    this.ckK = new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date());
  }
  
  private void VN(int paramInt)
  {
    String str = this.jdField_b_of_type_Aogy.getThemeId();
    int i = anlm.en(str);
    if ((paramInt != 0) || (this.weakApp.get() == null) || (!anlm.lG(i))) {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUILog.SimpleUIHandler", 2, "NightModeLogic.postSwitch error, mBPref = " + i + "; themeId = " + str + "; code = " + paramInt);
      }
    }
    boolean bool;
    do
    {
      return;
      anlk localanlk = (anlk)((QQAppInterface)this.weakApp.get()).getBusinessHandler(154);
      bool = anlm.ayn();
      localanlk.lw(localanlk.a(bool, i, false, anwa.aze()));
    } while (!QLog.isColorLevel());
    QLog.d("SimpleUILog.SimpleUIHandler", 2, "NightModeLogic.postSwitch, bSwitch = " + bool + "; bPref = " + i + "; themeId = " + str);
  }
  
  private void X(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher$DownloadListenser = new DownloadListenser(paramBoolean);
    aqsu.a.download(paramQQAppInterface, this.jdField_b_of_type_Aogy.AG());
    aogz.a(paramQQAppInterface, "theme_detail", this.from, 153, -1, 7, this.jdField_b_of_type_Aogy.getThemeId(), "20000000", aogz.ckI, "");
  }
  
  private static boolean a(Context paramContext, aogy paramaogy)
  {
    File localFile = new File(paramaogy.AH());
    paramContext = ThemeUtil.getThemeInfo(paramContext, paramaogy.getThemeId());
    return (paramContext != null) && (paramContext.fileNum > 0) && (localFile.exists()) && (paramContext.fileNum == ThemeUtil.getFileNumInFile(localFile));
  }
  
  private static boolean a(Context paramContext, File paramFile)
  {
    boolean bool = false;
    paramContext = paramContext.getDir("theme_810", 0).getParentFile();
    while ((!bool) && (!paramFile.equals(paramContext)))
    {
      File localFile = new File(paramFile.getParent(), "theme_move_" + Long.toString(System.currentTimeMillis()));
      bool = paramFile.renameTo(localFile);
      QLog.e("ThemeSwitcher", 1, "unzipTheme rename " + paramFile + " success: " + bool + ", dest=" + localFile);
      paramFile = paramFile.getParentFile();
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String arg1, String paramString2, a parama)
  {
    if ((TextUtils.isEmpty(???)) || (!afgc.lO(???)))
    {
      QLog.e("ThemeSwitcher", 1, "error themeId: " + ???);
      if (parama != null) {
        parama.bu(1);
      }
      aqri.a(null, "individual_v2_theme_setup_err", "wrong_id", ???, ???, 0.0F);
      aqrh.is("individual_v2_theme_setup_err", "wrong_id");
      return false;
    }
    if (!dU.compareAndSet(false, true)) {
      QLog.e("ThemeSwitcher", 1, "set " + ??? + " when NOT_FINISH " + jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher);
    }
    jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher = null;
    paramString2 = new ThemeSwitcher(paramQQAppInterface, parama, ???, paramString2);
    synchronized (dU)
    {
      parama = jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
      jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher = paramString2;
      if (parama != null) {
        parama.bV(2, false);
      }
      paramString2.ej(paramQQAppInterface);
      return true;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, a parama)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return a((QQAppInterface)localAppRuntime, paramString1, paramString2, parama);
    }
    QLog.e("ThemeSwitcher", 1, "wrong app: " + localAppRuntime);
    if (parama != null) {
      parama.bu(1);
    }
    aqri.a(null, "individual_v2_theme_setup_err", "wrong_app", String.valueOf(localAppRuntime), paramString1, 0.0F);
    aqrh.is("individual_v2_theme_setup_err", "wrong_app");
    return false;
  }
  
  private boolean azG()
  {
    if (bA.contains(this.from))
    {
      String str1 = SkinEngine.getInstances().getSkinRootPath();
      String str2 = this.jdField_b_of_type_Aogy.AH();
      if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str1)))
      {
        QLog.e("ThemeSwitcher", 1, "needSwitch: normal not changed");
        return false;
      }
      if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1)))
      {
        QLog.e("ThemeSwitcher", 1, "needSwitch: " + this.jdField_b_of_type_Aogy.getThemeId() + " not changed");
        return false;
      }
    }
    return true;
  }
  
  public static boolean azc()
  {
    boolean bool = dU.get();
    QLog.e("ThemeSwitcher", 1, "isSwitching: " + bool + "," + jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher);
    return bool;
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    QLog.e("ThemeSwitcher", 1, "beforeSwitch: " + paramString1 + "=>" + paramString2);
    ThemeUtil.storeLastThemeId(paramString1);
    ChatBackgroundManager localChatBackgroundManager = (ChatBackgroundManager)paramQQAppInterface.getManager(63);
    SharedPreferences localSharedPreferences = ThemeBackground.getSharedPreferences(paramQQAppInterface.getApplication(), paramQQAppInterface.getAccount(), 0);
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(paramString1)))
    {
      if ((!bA.contains(this.from)) && (!"200".equals(this.from)) && ("1103".equals(paramString1)) && ("null".equals(localChatBackgroundManager.lQ(null))) && (localSharedPreferences.contains("theme_bg_record_for_night_mode")))
      {
        String str = localSharedPreferences.getString("theme_bg_record_for_night_mode", "null");
        localChatBackgroundManager.q(paramQQAppInterface.getAccount(), null, str, -1);
        localSharedPreferences.edit().remove("theme_bg_record_for_night_mode").apply();
      }
      if (ThemeUtil.isFixTheme(paramString2)) {
        break label238;
      }
      aohc.a(paramQQAppInterface, paramString2, "20000000");
    }
    for (;;)
    {
      if (!ThemeUtil.isFixTheme(paramString2)) {
        ThemeCleaner.RQ(paramString1);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher$a == null) {
        break;
      }
      return this.jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher$a.a(this.jdField_b_of_type_Aogy);
      label238:
      if ((!ThemeUtil.isFixTheme(paramString1)) && (!"206".equals(this.from))) {
        aohc.a(paramQQAppInterface, paramString1, "20000000");
      }
    }
    return false;
  }
  
  private void bV(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.done.compareAndSet(false, true)) {
      QLog.e("ThemeSwitcher", 1, "onEndSwitch: " + paramInt + "," + paramBoolean + " " + this);
    }
    synchronized (dU)
    {
      if (jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher == this)
      {
        jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher = null;
        dU.set(false);
      }
      boolean bool1 = bool2;
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher$a != null) {
          bool1 = this.jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher$a.bu(paramInt);
        }
      }
      if ((!bool1) && (("211" == this.from) || ("212" == this.from))) {
        VN(paramInt);
      }
      return;
    }
  }
  
  private void dUD()
  {
    ThreadManagerV2.excute(new ThemeSwitcher.1(this), 64, null, true);
  }
  
  private void dUE()
  {
    long l1 = 0L;
    long l2 = this.startTime + 1500L - SystemClock.uptimeMillis();
    if (l2 < 0L) {}
    for (;;)
    {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(1001), l1);
      return;
      l1 = l2;
    }
  }
  
  private void ej(QQAppInterface paramQQAppInterface)
  {
    this.startTime = SystemClock.uptimeMillis();
    String str1 = this.jdField_b_of_type_Aogy.getThemeId();
    String str2 = aofy.aA(paramQQAppInterface.getAccount(), 2);
    QLog.e("ThemeSwitcher", 1, str2 + " startSwitch: " + str1 + ", " + this.from);
    this.handler.sendEmptyMessage(1000);
    if ("1000".equals(str1))
    {
      dUE();
      return;
    }
    if ("999".equals(str1))
    {
      dUD();
      return;
    }
    if ("900".equals(str1))
    {
      this.jdField_b_of_type_Aogy.b();
      dUE();
      return;
    }
    ek(paramQQAppInterface);
  }
  
  private void ek(QQAppInterface paramQQAppInterface)
  {
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).queryItemVersion(3, this.jdField_b_of_type_Aogy.AG(), true, true, 0L, this);
  }
  
  public static void onComplete(String paramString, int paramInt)
  {
    QLog.e("ThemeSwitcher", 1, "onComplete: " + paramString + "," + paramInt);
    String str;
    if ((paramInt == 0) && (paramString.startsWith("theme.android.")))
    {
      str = y(paramString, false);
      if (TextUtils.isEmpty(str))
      {
        aqri.a(null, "individual_v2_theme_setup_err", "unzip_fail", paramString, Build.MODEL, Build.VERSION.RELEASE, "", 0.0F, 0.0F);
        aqrh.is("individual_v2_theme_setup_err", "unzip_fail");
      }
    }
    for (;;)
    {
      if (azc())
      {
        localObject = jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
        if (localObject != null)
        {
          localObject = ((ThemeSwitcher)localObject).jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher$DownloadListenser;
          if (localObject != null) {
            ((DownloadListenser)localObject).W(paramString, str, paramInt);
          }
        }
      }
      while ((paramInt != 0) || (!paramString.startsWith("theme.android.")))
      {
        Object localObject;
        return;
      }
      paramString = ThemeUtil.getIDFromSCID(paramString);
      str = ThemeUtil.getCurrentThemeId();
      QLog.e("ThemeSwitcher", 1, "theme update: " + paramString + " engineId: " + str);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str))) {
        a(paramString, "208", null);
      }
      aogz.a(null, "theme_detail", "208", 153, 1, 35, paramString, "20000000", aogz.ckI, "");
      return;
      str = null;
    }
  }
  
  public static void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ThemeSwitcher)localObject).jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher$DownloadListenser)
    {
      if (localObject != null) {
        ((DownloadListenser)localObject).onProgress(paramString, paramLong1, paramLong2);
      }
      return;
    }
  }
  
  public static boolean pZ(String paramString)
  {
    ThemeSwitcher localThemeSwitcher = jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
    return (localThemeSwitcher != null) && (localThemeSwitcher.jdField_b_of_type_Aogy.getThemeId().equals(paramString));
  }
  
  private static String y(String paramString, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication == null)
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: context == null");
      return null;
    }
    String str1 = ThemeUtil.getIDFromSCID(paramString);
    Object localObject = new aogy().a(str1).a(localBaseApplication, paramString, "");
    if (!((aogy)localObject).azE())
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: zip file missing");
      return null;
    }
    String str2 = ((aogy)localObject).getZipPath();
    String str3 = aqhq.bZ(str2, "MD5");
    if (TextUtils.isEmpty(str3))
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: fail to get md5");
      return null;
    }
    ((aogy)localObject).a(localBaseApplication, paramString, str3);
    String str4 = ((aogy)localObject).AH();
    QLog.e("ThemeSwitcher", 1, "unzipTheme to " + str4);
    File localFile = new File(str4);
    boolean bool;
    if ((!paramBoolean) && (localFile.exists()))
    {
      if (a(localBaseApplication, (aogy)localObject))
      {
        QLog.e("ThemeSwitcher", 1, "unzipTheme unzipDir exists");
        return str3;
      }
      if (!VasQuickUpdateEngine.safeDeleteFile(localFile, "theme_move_"))
      {
        bool = true;
        QLog.e("ThemeSwitcher", 1, "unzipTheme remove oldUnzip needMove: " + bool + " unzip exists: " + localFile.exists());
      }
    }
    for (;;)
    {
      if (bool) {
        if (!a(localBaseApplication, localFile)) {
          break label351;
        }
      }
      int i;
      label351:
      for (localObject = "1";; localObject = "0")
      {
        aqri.a(null, "individual_v2_theme_setup_err", "need_move", paramString, (String)localObject, Build.MODEL, Build.VERSION.RELEASE, 0.0F, 0.0F);
        aqrh.is("individual_v2_theme_setup_err", "need_move");
        i = 0;
        try
        {
          aqhq.W(str2, str4, false);
          if (localFile.exists()) {
            i = ThemeUtil.getFileNumInFile(localFile);
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            QLog.e("ThemeSwitcher", 1, "unzipTheme failed", localIOException);
            i = 0;
          }
        }
        if (i != 0) {
          break label384;
        }
        if (!paramBoolean) {
          break label378;
        }
        QLog.e("ThemeSwitcher", 1, "unzipTheme unzip failed twice");
        return null;
        bool = false;
        break;
      }
      label378:
      return y(paramString, true);
      label384:
      ThemeUtil.ThemeInfo localThemeInfo = ThemeUtil.getThemeInfo(localBaseApplication, str1);
      paramString = localThemeInfo;
      if (localThemeInfo == null)
      {
        QLog.e("ThemeSwitcher", 1, "unzipTheme no ThemeInfo " + str1);
        paramString = new ThemeUtil.ThemeInfo();
        paramString.themeId = str1;
        paramString.version = "20000000";
        paramString.zipVer = 20000000;
        paramString.isVoiceTheme = false;
      }
      paramString.status = "5";
      paramString.fileNum = i;
      long l = new File(str2).length();
      paramString.size = l;
      paramString.downsize = l;
      ThemeUtil.setThemeInfo(localBaseApplication, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitcher", 2, "unzipTheme success: " + paramString);
      }
      return str3;
      bool = paramBoolean;
    }
  }
  
  public void I(int paramInt, String paramString1, String paramString2)
  {
    QLog.e("ThemeSwitcher", 1, "onQueryItemVer: " + paramInt + "," + paramString1 + "," + paramString2);
    QQAppInterface localQQAppInterface = f();
    if (localQQAppInterface == null) {
      return;
    }
    if (paramInt == 2)
    {
      bV(2, false);
      paramString1 = wja.b().append("os.arch: " + System.getProperty("os.arch")).append(" DeviceInfoUtil#getCpuType: " + aqgz.getCpuType()).append(" Build.CPU_ABI: " + Build.CPU_ABI).append(" Build.CPU_ABI2: " + Build.CPU_ABI2).append(" chip:" + imm.getCpuArchitecture());
      if (Build.VERSION.SDK_INT >= 21) {
        paramString1.append(" Build.SUPPORTED_ABIS: " + Arrays.toString(Build.SUPPORTED_ABIS));
      }
      aqri.a(null, "individual_v2_theme_setup_err", "query_timeout", paramString1.toString(), toString(), 0.0F);
      aqrh.is("individual_v2_theme_setup_err", "query_timeout");
      return;
    }
    if (paramInt == 1)
    {
      X(localQQAppInterface, false);
      return;
    }
    this.jdField_b_of_type_Aogy.a(localQQAppInterface.getApp(), paramString1, paramString2);
    if (a(localQQAppInterface.getApp(), this.jdField_b_of_type_Aogy))
    {
      paramString1 = ThemeUtil.getCurrentThemeId();
      if ((!bA.contains(this.from)) && (!this.jdField_b_of_type_Aogy.getThemeId().equals(paramString1)))
      {
        X(localQQAppInterface, true);
        return;
      }
      dUE();
      return;
    }
    QLog.e("ThemeSwitcher", 1, "unZip dir not exist, download again");
    this.jdField_b_of_type_Aogy.c();
    X(localQQAppInterface, false);
  }
  
  QQAppInterface f()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if ((localQQAppInterface == null) || (!localQQAppInterface.isLogin()))
    {
      QLog.e("ThemeSwitcher", 1, "app is destroy: " + localQQAppInterface + " switcher: " + this);
      bV(2, true);
      localQQAppInterface = null;
    }
    while (jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher == this) {
      return localQQAppInterface;
    }
    QLog.e("ThemeSwitcher", 1, "newSwitcher: " + jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher + " old is:" + this);
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    Object localObject = f();
    if (localObject == null) {
      QLog.e("ThemeSwitcher", 1, "app null when handleMessage: " + paramMessage.what);
    }
    do
    {
      return true;
      if (paramMessage.what != 1000) {
        break;
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher$a == null);
    this.jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher$a.beginSwitch();
    return true;
    String str1;
    String str2;
    boolean bool2;
    boolean bool1;
    if (paramMessage.what == 1001)
    {
      paramMessage = ThemeUtil.getCurrentThemeId();
      str1 = this.jdField_b_of_type_Aogy.getThemeId();
      str2 = this.jdField_b_of_type_Aogy.AH();
      ThemeBackground.needUpdateThemeForBg = false;
      if (!b((QQAppInterface)localObject, paramMessage, str1))
      {
        if (!azG()) {
          break label790;
        }
        if (SkinEngine.getInstances().mResources == null)
        {
          bool2 = true;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      label140:
      QLog.e("ThemeSwitcher", 1, "needRetry: " + bool1 + " switchSuccess: " + bool2);
      ThemeUtil.setCurrentThemeIdVersion((AppRuntime)localObject, this.jdField_b_of_type_Aogy.getThemeId(), "20000000");
      if (bool2) {
        bV(0, false);
      }
      for (;;)
      {
        aogz.a(null, "theme_detail", this.from, 155, aqiw.getSystemNetwork(null), 23, str1, "20000000", paramMessage, "");
        QLog.e("ThemeSwitcher", 1, "needRetry: " + bool1 + " sIsSwitching: " + dU.get());
        if (!bool1) {
          break;
        }
        QLog.e("ThemeSwitcher", 1, "engine not ready, start retry: " + this);
        this.apa = (SystemClock.uptimeMillis() + 60000L);
        jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher = this;
        this.handler.sendMessageDelayed(this.handler.obtainMessage(1003), 2000L);
        this.jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher$a = null;
        return true;
        QLog.e("ThemeSwitcher", 1, "setSkinRoot: " + str2);
        bool2 = SkinEngine.getInstances().setSkinRootPath(((QQAppInterface)localObject).getApp(), str2);
        bool1 = false;
        break label140;
        QLog.e("ThemeSwitcher", 1, "engine is doing a switch, retry later");
        localObject = this.handler.obtainMessage(1002, 0, 0);
        this.handler.sendMessageDelayed((Message)localObject, 1000L);
        continue;
        bV(0, true);
        bool1 = false;
      }
      if (paramMessage.what == 1002)
      {
        i = paramMessage.arg1;
        if (i < 10)
        {
          paramMessage = this.jdField_b_of_type_Aogy.AH();
          if (!SkinEngine.getInstances().setSkinRootPath(((QQAppInterface)localObject).getApp(), paramMessage))
          {
            paramMessage = this.handler.obtainMessage(1002, i + 1, 0);
            this.handler.sendMessageDelayed(paramMessage, 1000L);
            return true;
          }
          QLog.e("ThemeSwitcher", 1, "retry switchSuccess: " + this);
        }
        QLog.e("ThemeSwitcher", 1, "retryCount: " + i);
        bV(0, false);
        return true;
      }
      if (paramMessage.what != 1003) {
        break;
      }
      if (jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher != this)
      {
        QLog.e("ThemeSwitcher", 1, "sRetry reset, stop retry: " + this);
        i = 1;
      }
      if (SystemClock.uptimeMillis() > this.apa)
      {
        QLog.e("ThemeSwitcher", 1, "meet deadLine, stop retry " + this);
        aqri.a(null, "individual_v2_theme_setup_err", "engine_timeout", toString(), this.jdField_b_of_type_Aogy.getThemeId(), 0.0F);
        aqrh.is("individual_v2_theme_setup_err", "engine_timeout");
        i = 1;
      }
      if (i != 0)
      {
        jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher = null;
        return true;
      }
      if (SkinEngine.getInstances().mResources == null)
      {
        this.handler.sendMessageDelayed(this.handler.obtainMessage(1003), 2000L);
        return true;
      }
      QLog.e("ThemeSwitcher", 1, "engine ready, retry: " + this);
      jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher = null;
      a((QQAppInterface)localObject, this.jdField_b_of_type_Aogy.getThemeId(), this.from, null);
      return true;
      label790:
      bool2 = true;
      bool1 = false;
    }
  }
  
  public String toString()
  {
    return this.jdField_b_of_type_Aogy.getThemeId() + " start " + this.ckK + " ," + this.from;
  }
  
  class DownloadListenser
    implements Runnable
  {
    private final long apb;
    private volatile long apc;
    private AtomicBoolean done = new AtomicBoolean(false);
    private String reportKey;
    
    public DownloadListenser(boolean paramBoolean)
    {
      long l;
      if (paramBoolean)
      {
        l = 5000L;
        this.apb = l;
        if (!paramBoolean) {
          break label71;
        }
      }
      label71:
      for (this$1 = "update_timeout";; this$1 = "download_timeout")
      {
        this.reportKey = ThemeSwitcher.this;
        this.apc = (SystemClock.uptimeMillis() + this.apb);
        azH();
        return;
        l = 180000L;
        break;
      }
    }
    
    private boolean azH()
    {
      long l = SystemClock.uptimeMillis();
      if (l > this.apc) {
        return true;
      }
      ThreadManager.getSubThreadHandler().postDelayed(this, this.apc + 10L - l);
      return false;
    }
    
    private void p(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
    {
      if (paramInt != 2) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this);
      }
      if (this.done.compareAndSet(false, true))
      {
        ThemeSwitcher.a(ThemeSwitcher.this, null);
        if (!TextUtils.isEmpty(paramString2)) {
          break label84;
        }
        if (TextUtils.isEmpty(ThemeSwitcher.a(ThemeSwitcher.this).AH())) {
          ThemeSwitcher.a(ThemeSwitcher.this, paramInt, false);
        }
      }
      else
      {
        return;
      }
      QLog.e("ThemeSwitcher", 1, "download err, but local exists");
      ThemeSwitcher.a(ThemeSwitcher.this);
      return;
      label84:
      ThemeSwitcher.a(ThemeSwitcher.this).a(paramQQAppInterface.getApp(), paramString1, paramString2);
      ThemeSwitcher.a(ThemeSwitcher.this);
    }
    
    public void W(String paramString1, String paramString2, int paramInt)
    {
      QQAppInterface localQQAppInterface = ThemeSwitcher.this.f();
      if (localQQAppInterface == null) {}
      String str;
      do
      {
        do
        {
          return;
          str = ThemeUtil.getIDFromSCID(paramString1);
        } while (!ThemeSwitcher.a(ThemeSwitcher.this).getThemeId().equals(str));
        this.apc = (SystemClock.uptimeMillis() + this.apb);
        if (paramInt != 0)
        {
          p(localQQAppInterface, null, null, 1);
          return;
        }
      } while (!paramString1.startsWith("theme.android."));
      p(localQQAppInterface, paramString1, paramString2, 0);
      aogz.a(null, "theme_detail", ThemeSwitcher.a(ThemeSwitcher.this), 153, 1, 35, str, "20000000", aogz.ckI, "");
    }
    
    public void onProgress(String paramString, long paramLong1, long paramLong2)
    {
      if (ThemeSwitcher.this.f() == null) {}
      do
      {
        String str;
        do
        {
          return;
          str = ThemeUtil.getIDFromSCID(paramString);
        } while (!ThemeSwitcher.a(ThemeSwitcher.this).getThemeId().equals(str));
        this.apc = (SystemClock.uptimeMillis() + this.apb);
      } while ((!paramString.startsWith("theme.android.")) || (ThemeSwitcher.a(ThemeSwitcher.this) == null));
      ThemeSwitcher.a(ThemeSwitcher.this).onProgress(paramLong1, paramLong2);
    }
    
    public void run()
    {
      QQAppInterface localQQAppInterface;
      if (azH())
      {
        localQQAppInterface = ThemeSwitcher.this.f();
        if (localQQAppInterface != null) {}
      }
      else
      {
        return;
      }
      QLog.e("ThemeSwitcher", 1, "downloadTheme timeout");
      aqri.a(null, "individual_v2_theme_download_fail", this.reportKey, ThemeSwitcher.this.toString(), ThemeSwitcher.a(ThemeSwitcher.this).getThemeId(), ThemeSwitcher.a(ThemeSwitcher.this), "", 0.0F, 0.0F);
      HashMap localHashMap = new HashMap();
      localHashMap.put("reportKey", this.reportKey);
      anpc.a(BaseApplication.getContext()).collectPerformance("", "individual_v2_theme_download_fail", false, 0L, -1L, localHashMap, "", true);
      p(localQQAppInterface, null, null, 2);
    }
  }
  
  public static class a
  {
    public boolean a(aogy paramaogy)
    {
      return false;
    }
    
    public void beginSwitch() {}
    
    public boolean bu(int paramInt)
    {
      return false;
    }
    
    public void onProgress(long paramLong1, long paramLong2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitcher
 * JD-Core Version:    0.7.0.1
 */