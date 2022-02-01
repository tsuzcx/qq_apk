package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import aohf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinEngineLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinEngine.BackupForOOMData;
import com.tencent.theme.SkinEngineHandler;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import mqq.os.MqqHandler;
import swt;

public class InitSkin
  extends OnceIfSuccessStep
{
  public static boolean cII;
  public static volatile boolean cIJ;
  public static int dKl = 3000;
  public static final Object eX = new Object();
  private static final int[] oc = { 2130838125, 2130838387, 2130838386, 2130838385, 2130839506, 2130839619, 2130839618, 2130839650, 2130839652, 2130839658, 2130839639, 2130839802, 2130840195, 2130840732, 2130842220, 2130843369, 2130846716, 2130846715, 2130846711, 2130846710, 2130846706, 2130846705, 2130844989, 2130845001, 2130845002, 2130845003, 2130845004, 2130845005, 2130845006, 2130845007, 2130845008, 2130845009, 2130845012, 2130845011, 2130845013, 2130845014, 2130845015, 2130845017, 2130845016, 2130845026, 2130845027, 2130845028, 2130845029, 2130845030, 2130845031, 2130845032, 2130845033, 2130845034, 2130845035, 2130845036, 2130840655, 2130840654, 2130846603, 2130845225, 2130845227, 2130845002, 2130845116, 2130845225, 2130845227, 2130845001, 2130850414, 2130850839, 2130850824, 2130850823, 2130850846, 2130850845, 2130851351, 2130851242, 2130851238, 2130851023, 2130851105, 2130851404, 2130851123, 2130851119, 2130851127, 2130851133, 2130851131, 2130851111, 2130851058, 2130851068, 2130851069, 2130851081, 2130851351, 2130851314, 2130851315, 2130849915, 2130851331, 2130851336, 2130851334, 2130851342, 2130851338, 2130840663, 2130840667, 2130851155, 2130845064, 2130845063, 2130839642, 2130839643, 2130851245, 2130851241 };
  private static final int[] od = { 2130837650, 2130837662, 2130837663, 2130837673, 2130837674, 2130837678, 2130837679, 2130839619, 2130839618, 2130850839, 2130840669, 2130840667, 2130851758, 2130851105, 2130851111, 2130851119, 2130851123, 2130851127, 2130851129, 2130851130, 2130851131, 2130851133, 2130851767, 2130851917, 2130841134, 2130841129, 2130841133, 2130841128, 2130841126, 2130841127, 2130845043, 2130845041, 2130845042, 2130841140, 2130841138, 2130841139, 2130838812, 2130851770, 2130842709, 2130842710, 2130842711, 2130842712, 2130851395, 2130851023, 2130851079, 2130851081, 2130843326, 2130843325, 2130843332, 2130851242, 2130851238, 2130851246, 2130851103, 2130851342, 2130851338, 2130851331, 2130839802, 2130851354, 2130851356, 2130851313, 2130851312 };
  private static final int[] oe = { 2130837650, 2130837662, 2130837663, 2130837673, 2130837674, 2130837678, 2130837679, 2130838096, 2130838161, 2130838326, 2130838481, 2130838775, 2130838776, 2130838777, 2130838779, 2130838780, 2130838781, 2130838812, 2130838842, 2130838844, 2130839114, 2130839269, 2130839271, 2130839358, 2130839359, 2130839362, 2130839363, 2130839506, 2130839507, 2130839509, 2130839510, 2130839618, 2130839619, 2130839628, 2130839650, 2130839656, 2130839658, 2130839710, 2130839721, 2130839762, 2130839802, 2130840068, 2130840086, 2130839941, 2130840180, 2130840196, 2130837760, 2130840403, 2130840618, 2130840645, 2130849139, 2130849140, 2130841052, 2130841053, 2130849251, 2130842211, 2130842320, 2130843230, 2130843231, 2130843233, 2130843234, 2130844272, 2130844376, 2130845225, 2130845227, 2130846705, 2130846706, 2130846710, 2130846711, 2130846713, 2130846714, 2130846715, 2130846716, 2130846745, 2130848431, 2130848558, 2130848559, 2130848571, 2130848609, 2130848616, 2130848626, 2130848627, 2130848628, 2130848629, 2130848630, 2130848631, 2130848632, 2130848633, 2130848635, 2130848636, 2130848639, 2130848643, 2130848680, 2130848681, 2130848682, 2130848683, 2130848684, 2130848685, 2130848703, 2130848704, 2130849843, 2130837673, 2130848814, 2130848815, 2130848835, 2130848844, 2130848869, 2130848882, 2130849656, 2130848892, 2130848913, 2130848914, 2130848915, 2130848916, 2130848937, 2130848938, 2130848984, 2130849034, 2130849035, 2130849077, 2130849079, 2130849080, 2130849086, 2130849087, 2130849088, 2130849090, 2130849091, 2130849093, 2130849095, 2130849100, 2130849106, 2130849107, 2130849108, 2130849137, 2130849138, 2130849145, 2130849166, 2130849173, 2130849182, 2130849199, 2130849239, 2130849242, 2130849245, 2130849247, 2130849248, 2130849249, 2130849250, 2130849363, 2130849421, 2130849452, 2130849463, 2130849464, 2130849466, 2130849469, 2130849472, 2130846115, 2130849514, 2130849515, 2130849553, 2130849554, 2130849561, 2130849582, 2130849618, 2130849718, 2130849852, 2130849976, 2130849920, 2130849924, 2130849927, 2130849930, 2130849931, 2130850024, 2130850039, 2130850040, 2130850129, 2130850152, 2130850153, 2130850154, 2130850155, 2130850159, 2130850160, 2130850165, 2130850166, 2130850167, 2130850168, 2130850169, 2130850170, 2130850171, 2130850415, 2130850416, 2130850418, 2130850419, 2130850421, 2130850423, 2130850598, 2130850671, 2130850669, 2130850670, 2130850674, 2130851023, 2130851042, 2130851043, 2130851044, 2130851049, 2130851050, 2130851055, 2130851056, 2130851058, 2130851068, 2130851069, 2130851070, 2130851071, 2130851079, 2130851080, 2130851081, 2130851105, 2130851111, 2130851119, 2130851123, 2130851127, 2130851129, 2130851130, 2130851131, 2130851133, 2130851135, 2130851147, 2130851148, 2130851149, 2130851150, 2130851151, 2130851152, 2130851153, 2130851154, 2130851155, 2130851165, 2130851166, 2130851238, 2130851314, 2130851315, 2130851316, 2130851322, 2130851323, 2130849915, 2130849869, 2130849870, 2130849871, 2130849872, 2130849873, 2130851330, 2130851331, 2130851334, 2130851336, 2130851338, 2130851342, 2130851348, 2130851351, 2130851354, 2130851356, 2130851363, 2130851365, 2130851369, 2130851371, 2130851403, 2130851404, 2130851465, 2130851677, 2130851679, 2130851753, 2130851770, 2130851794, 2130851796 };
  public static boolean sInited;
  
  private static final int aG(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getResources();
    TypedValue localTypedValue = new TypedValue();
    paramContext.getValue(2130837504, localTypedValue, true);
    if (localTypedValue.string != null) {
      i = localTypedValue.assetCookie;
    }
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "getDefaultCookieId value.string=" + localTypedValue.string + ", cookieId=" + i);
    }
    return i;
  }
  
  public static final boolean bB(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/web_config");
        localFile2 = new File(localFile2, "/skin/web_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.IS_SUPPORT_THEME = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, od, 1264, 2131165184, null);
        ThreadManager.getSubThreadHandler().postDelayed(new CreateSkinEngineCacheTask("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.getAppId()) || (!"1d5677cf".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, od, 1264, 2131165184, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "web skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, od, 1264, 2131165184, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new swt(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838900);
      SkinEngine.getInstances().addDrawableResource(2130839645);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label507;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "web skin cache time out");
      }
      SkinEngine.init(paramContext, od, 1264, 2131165184, null);
      ThreadManager.getSubThreadHandler().postDelayed(new CreateSkinEngineCacheTask("/skin/web_config", "/skin/web_skin_cache"), 10000L);
    }
  }
  
  @TargetApi(16)
  public static final boolean bC(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/qzone_config");
        localFile2 = new File(localFile2, "/skin/qzone_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.IS_SUPPORT_THEME = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, oe, 1264, 2131165184, null);
        c().postDelayed(new CreateSkinEngineCacheTask("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.getAppId()) || (!"1d5677cf".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, oe, 1264, 2131165184, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "qzone skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, oe, 1264, 2131165184, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new swt(BaseApplicationImpl.getApplication()));
      SkinEngine.getInstances().addDrawableResource(2130838900);
      SkinEngine.getInstances().addDrawableResource(2130839260);
      SkinEngine.getInstances().addDrawableResource(2130839645);
      SkinEngine.getInstances().addDrawableResource(2130839270);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label525;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qzone skin cache time out");
      }
      SkinEngine.init(paramContext, oe, 1264, 2131165184, null);
      c().postDelayed(new CreateSkinEngineCacheTask("/skin/qzone_config", "/skin/qzone_skin_cache"), 10000L);
    }
  }
  
  private static MqqHandler c()
  {
    return new MqqHandler(ThreadManager.getSubThreadLooper());
  }
  
  private void dRO()
  {
    cII = false;
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("dpcConfig", 4).getString("tool_process_profile", "");
    boolean bool;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      Object localObject1 = localObject2;
      if (((String)localObject2).indexOf('{', 0) == 0)
      {
        localObject1 = localObject2;
        if (((String)localObject2).lastIndexOf('}') == ((String)localObject2).length() - 1) {
          localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
        }
      }
      localObject2 = new Integer[2];
      Arrays.fill((Object[])localObject2, Integer.valueOf(0));
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new DeviceProfileManager.e()) >= 2)
      {
        if (localObject2[0].intValue() != 1) {
          break label223;
        }
        bool = true;
        cII = bool;
        if (localObject2[1].intValue() <= 0) {
          break label228;
        }
        i = localObject2[1].intValue();
        label150:
        dKl = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("InitSkin", 2, "ToolAsynInitDPC = " + cII + "  sToolInitTimeout = " + dKl);
    }
    if (cII) {
      ThreadManager.post(new InitSkin.1(this), 8, null, false);
    }
    label223:
    label228:
    do
    {
      return;
      bool = false;
      break;
      i = 0;
      break label150;
      if (QLog.isColorLevel()) {
        QLog.i("InitSkin", 2, "start synInitSkin");
      }
      initSkin(BaseApplicationImpl.sApplication);
      cIJ = true;
    } while (!QLog.isColorLevel());
    QLog.i("InitSkin", 2, "end synInitSkin");
  }
  
  public static void dRP()
  {
    if ((cII) && (!cIJ)) {
      if (QLog.isColorLevel()) {
        QLog.i("InitSkin", 2, "start waitAsynInitSkin");
      }
    }
    synchronized (eX)
    {
      boolean bool = cIJ;
      if (!bool) {}
      try
      {
        eX.wait(dKl);
        if (QLog.isColorLevel()) {
          QLog.i("InitSkin", 2, "end waitAsynInitSkin InitSkin.sToolProcessInitComplete = " + cIJ);
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("InitSkin", 2, localInterruptedException.toString());
          }
        }
      }
    }
  }
  
  public static final boolean initSkin(Context paramContext)
  {
    File localFile;
    for (;;)
    {
      try
      {
        localFile = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localObject1 = new swt(BaseApplicationImpl.getApplication());
        SkinEngine.setSKLog((ISkinEngineLog)localObject1);
      }
      catch (Exception localException1)
      {
        long l1;
        Object localObject1;
        Object localObject2;
        int i;
        String str;
        BaseApplicationImpl.IS_SUPPORT_THEME = false;
        QLog.e("SkinEngine", 1, "Init SkinEngine Error:", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          break label688;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131165184, null);
        ThreadManager.getSubThreadHandler().postDelayed(new CreateSkinEngineCacheTask("/skin/config", str), 10000L);
        continue;
      }
      try
      {
        localObject2 = BaseApplicationImpl.sApplication;
        if (((Application)localObject2).getPackageManager().getApplicationInfo(((Application)localObject2).getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
        {
          SkinEngine.mIconResourceID = Integer.valueOf(2130840732);
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130840732);
          }
        }
        i = aG(paramContext);
        str = "/skin/skin_cache_mobileqq_" + AppSetting.getAppId() + "_" + "1d5677cf" + "_" + i;
        localObject2 = new File(localFile, "/skin/config");
        localFile = new File(localFile, str);
        try
        {
          if (!localFile.exists()) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "cache find, use cache file accered");
          }
          SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131165184, localFile);
        }
        catch (Exception localException3)
        {
          long l2;
          if (!localNameNotFoundException.exists()) {
            break label613;
          }
          localNameNotFoundException.delete();
          if (!localFile.exists()) {
            break label627;
          }
          localFile.delete();
          if (!QLog.isColorLevel()) {
            break label645;
          }
          QLog.d("SkinEngine", 2, "Cache load failed.", localException3);
          SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131165184, null);
          continue;
        }
        SkinEngine.getInstances().setSkinEngineHandler((SkinEngineHandler)localObject1);
        SkinEngine.getInstances().addDrawableResource(2130838900);
        SkinEngine.getInstances().addDrawableResource(2130839260);
        SkinEngine.getInstances().addDrawableResource(2130838901);
        SkinEngine.getInstances().addDrawableResource(2130851302);
        SkinEngine.getInstances().addDrawableResource(2130839645);
        SkinEngine.getInstances().addDrawableResource(2130839270);
        l2 = SystemClock.uptimeMillis();
        localObject1 = new SkinEngine.BackupForOOMData(2130851035, 2130851037, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130851035), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130846953, 2130851037, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130846953), (SkinEngine.BackupForOOMData)localObject1);
        localObject1 = new SkinEngine.BackupForOOMData(2130851025, 2130851037, Bitmap.Config.RGB_565);
        SkinEngine.getInstances().addBackupForOOMData(Integer.valueOf(2130851025), (SkinEngine.BackupForOOMData)localObject1);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        try
        {
          paramContext.getResources().getDrawable(2130837504);
          if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            ThemeUtil.initTheme(null);
          }
          if (!QLog.isColorLevel()) {
            break label688;
          }
          QLog.d("SkinEngine", 2, "init skin engine cost: " + (l2 - l1));
        }
        catch (Exception localException2)
        {
          QLog.e("SkinEngine", 1, "getDrawable(R.drawable.a) error:", localException2);
          SkinEngine.getInstances().unInit();
          throw localException2;
        }
        localNameNotFoundException = localNameNotFoundException;
        localNameNotFoundException.printStackTrace();
      }
    }
    label613:
    label627:
    return true;
  }
  
  protected boolean doStep()
  {
    if (sInited) {}
    String str;
    do
    {
      return true;
      sInited = true;
      String[] arrayOfString = BaseApplicationImpl.processName.split(":");
      str = null;
      if (arrayOfString.length > 1) {
        str = arrayOfString[1];
      }
      SkinEngine.getInstances().setSkinTint(new aohf());
      if ((str == null) || (str.endsWith("map")) || (str.equals("qzone")) || (str.equals("picture")) || (str.equals("pedit")) || (str.equals("plugin")) || (str.equals("demoji")) || (str.equals("peak")) || (str.equals("readinjoy")) || (str.endsWith("nearby")) || (str.equals("tool")) || (str.equals("qqfav")))
      {
        if ("tool".equals(str))
        {
          dRO();
          return true;
        }
        initSkin(BaseApplicationImpl.sApplication);
        return true;
      }
      if (str.equals("qzone"))
      {
        bC(BaseApplicationImpl.sApplication);
        return true;
      }
    } while (!str.equals("web"));
    bB(BaseApplicationImpl.sApplication);
    return true;
  }
  
  static class CreateSkinEngineCacheTask
    extends AsyncTask<Void, Void, Void>
    implements Runnable
  {
    private String ceN;
    private String config;
    
    public CreateSkinEngineCacheTask(String paramString1, String paramString2)
    {
      this.config = paramString1;
      this.ceN = paramString2;
    }
    
    /* Error */
    public Void doInBackground(Void... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: getstatic 38	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
      //   5: astore 4
      //   7: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   10: ifeq +11 -> 21
      //   13: ldc 46
      //   15: iconst_2
      //   16: ldc 48
      //   18: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   21: aload_0
      //   22: getfield 22	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:ceN	Ljava/lang/String;
      //   25: ldc 54
      //   27: invokevirtual 60	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   30: ifeq +138 -> 168
      //   33: new 62	java/io/File
      //   36: dup
      //   37: aload 4
      //   39: invokevirtual 66	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
      //   42: ldc 68
      //   44: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   47: astore 5
      //   49: aload 5
      //   51: ifnull +117 -> 168
      //   54: aload 5
      //   56: invokevirtual 74	java/io/File:isDirectory	()Z
      //   59: ifeq +109 -> 168
      //   62: aload 5
      //   64: invokevirtual 78	java/io/File:list	()[Ljava/lang/String;
      //   67: astore 6
      //   69: aload 6
      //   71: ifnull +97 -> 168
      //   74: aload 6
      //   76: arraylength
      //   77: istore_3
      //   78: iconst_0
      //   79: istore_2
      //   80: iload_2
      //   81: iload_3
      //   82: if_icmpge +86 -> 168
      //   85: aload 6
      //   87: iload_2
      //   88: aaload
      //   89: astore 7
      //   91: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   94: ifeq +29 -> 123
      //   97: ldc 46
      //   99: iconst_2
      //   100: new 80	java/lang/StringBuilder
      //   103: dup
      //   104: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   107: ldc 83
      //   109: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: aload 7
      //   114: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   117: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   120: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   123: aload 7
      //   125: ifnull +346 -> 471
      //   128: aload 7
      //   130: ldc 93
      //   132: invokevirtual 60	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   135: ifeq +336 -> 471
      //   138: new 62	java/io/File
      //   141: dup
      //   142: aload 5
      //   144: aload 7
      //   146: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   149: astore 7
      //   151: aload 7
      //   153: invokevirtual 96	java/io/File:exists	()Z
      //   156: ifeq +315 -> 471
      //   159: aload 7
      //   161: invokevirtual 99	java/io/File:delete	()Z
      //   164: pop
      //   165: goto +306 -> 471
      //   168: new 62	java/io/File
      //   171: dup
      //   172: aload 4
      //   174: invokevirtual 66	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
      //   177: aload_0
      //   178: getfield 20	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:config	Ljava/lang/String;
      //   181: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   184: astore 5
      //   186: new 62	java/io/File
      //   189: dup
      //   190: aload 4
      //   192: invokevirtual 66	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
      //   195: aload_0
      //   196: getfield 22	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:ceN	Ljava/lang/String;
      //   199: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   202: astore 6
      //   204: new 62	java/io/File
      //   207: dup
      //   208: aload 4
      //   210: invokevirtual 66	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
      //   213: new 80	java/lang/StringBuilder
      //   216: dup
      //   217: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   220: aload_0
      //   221: getfield 22	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:ceN	Ljava/lang/String;
      //   224: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   227: ldc 101
      //   229: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   232: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   235: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   238: astore 4
      //   240: aload 5
      //   242: invokevirtual 104	java/io/File:getParentFile	()Ljava/io/File;
      //   245: astore 7
      //   247: aload 7
      //   249: invokevirtual 96	java/io/File:exists	()Z
      //   252: ifne +9 -> 261
      //   255: aload 7
      //   257: invokevirtual 107	java/io/File:mkdirs	()Z
      //   260: pop
      //   261: aload 6
      //   263: invokevirtual 96	java/io/File:exists	()Z
      //   266: ifeq +9 -> 275
      //   269: aload 6
      //   271: invokevirtual 99	java/io/File:delete	()Z
      //   274: pop
      //   275: aload 5
      //   277: invokevirtual 96	java/io/File:exists	()Z
      //   280: ifeq +9 -> 289
      //   283: aload 5
      //   285: invokevirtual 99	java/io/File:delete	()Z
      //   288: pop
      //   289: aload 4
      //   291: invokevirtual 96	java/io/File:exists	()Z
      //   294: ifeq +9 -> 303
      //   297: aload 4
      //   299: invokevirtual 99	java/io/File:delete	()Z
      //   302: pop
      //   303: invokestatic 113	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
      //   306: aload 4
      //   308: invokevirtual 117	com/tencent/theme/SkinEngine:writeCacheFile	(Ljava/io/File;)V
      //   311: aload 4
      //   313: invokevirtual 96	java/io/File:exists	()Z
      //   316: ifeq +11 -> 327
      //   319: aload 4
      //   321: aload 6
      //   323: invokevirtual 121	java/io/File:renameTo	(Ljava/io/File;)Z
      //   326: pop
      //   327: new 123	java/io/ObjectOutputStream
      //   330: dup
      //   331: new 125	java/io/BufferedOutputStream
      //   334: dup
      //   335: new 127	java/io/FileOutputStream
      //   338: dup
      //   339: aload 5
      //   341: invokespecial 129	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   344: invokespecial 132	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   347: invokespecial 133	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   350: astore 4
      //   352: aload 4
      //   354: astore_1
      //   355: aload 4
      //   357: invokestatic 139	com/tencent/common/config/AppSetting:getAppId	()I
      //   360: invokevirtual 143	java/io/ObjectOutputStream:writeInt	(I)V
      //   363: aload 4
      //   365: astore_1
      //   366: aload 4
      //   368: ldc 145
      //   370: invokevirtual 149	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
      //   373: aload 4
      //   375: ifnull +8 -> 383
      //   378: aload 4
      //   380: invokevirtual 152	java/io/ObjectOutputStream:close	()V
      //   383: aconst_null
      //   384: areturn
      //   385: astore 5
      //   387: aconst_null
      //   388: astore 4
      //   390: aload 4
      //   392: astore_1
      //   393: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   396: ifeq +16 -> 412
      //   399: aload 4
      //   401: astore_1
      //   402: ldc 46
      //   404: iconst_2
      //   405: ldc 154
      //   407: aload 5
      //   409: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   412: aload 4
      //   414: ifnull -31 -> 383
      //   417: aload 4
      //   419: invokevirtual 152	java/io/ObjectOutputStream:close	()V
      //   422: aconst_null
      //   423: areturn
      //   424: astore_1
      //   425: aconst_null
      //   426: areturn
      //   427: astore 5
      //   429: aload_1
      //   430: astore 4
      //   432: aload 5
      //   434: astore_1
      //   435: aload 4
      //   437: ifnull +8 -> 445
      //   440: aload 4
      //   442: invokevirtual 152	java/io/ObjectOutputStream:close	()V
      //   445: aload_1
      //   446: athrow
      //   447: astore_1
      //   448: aconst_null
      //   449: areturn
      //   450: astore 4
      //   452: goto -7 -> 445
      //   455: astore 5
      //   457: aload_1
      //   458: astore 4
      //   460: aload 5
      //   462: astore_1
      //   463: goto -28 -> 435
      //   466: astore 5
      //   468: goto -78 -> 390
      //   471: iload_2
      //   472: iconst_1
      //   473: iadd
      //   474: istore_2
      //   475: goto -395 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	478	0	this	CreateSkinEngineCacheTask
      //   0	478	1	paramVarArgs	Void[]
      //   79	396	2	i	int
      //   77	6	3	j	int
      //   5	436	4	localObject1	Object
      //   450	1	4	localIOException1	IOException
      //   458	1	4	arrayOfVoid	Void[]
      //   47	293	5	localFile	File
      //   385	23	5	localIOException2	IOException
      //   427	6	5	localObject2	Object
      //   455	6	5	localObject3	Object
      //   466	1	5	localIOException3	IOException
      //   67	255	6	localObject4	Object
      //   89	167	7	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   2	21	385	java/io/IOException
      //   21	49	385	java/io/IOException
      //   54	69	385	java/io/IOException
      //   74	78	385	java/io/IOException
      //   91	123	385	java/io/IOException
      //   128	165	385	java/io/IOException
      //   168	261	385	java/io/IOException
      //   261	275	385	java/io/IOException
      //   275	289	385	java/io/IOException
      //   289	303	385	java/io/IOException
      //   303	327	385	java/io/IOException
      //   327	352	385	java/io/IOException
      //   417	422	424	java/io/IOException
      //   2	21	427	finally
      //   21	49	427	finally
      //   54	69	427	finally
      //   74	78	427	finally
      //   91	123	427	finally
      //   128	165	427	finally
      //   168	261	427	finally
      //   261	275	427	finally
      //   275	289	427	finally
      //   289	303	427	finally
      //   303	327	427	finally
      //   327	352	427	finally
      //   378	383	447	java/io/IOException
      //   440	445	450	java/io/IOException
      //   355	363	455	finally
      //   366	373	455	finally
      //   393	399	455	finally
      //   402	412	455	finally
      //   355	363	466	java/io/IOException
      //   366	373	466	java/io/IOException
    }
    
    public void run()
    {
      Utils.executeAsyncTaskOnThreadPool(this, new Void[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */