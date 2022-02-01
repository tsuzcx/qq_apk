import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.minigame.manager.EngineInstaller;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"WrongConstant"})
public class ajcv
{
  public static final String[] MINI_APP_LIB_SO = { "native_lame_mp3", "c++_shared", "saturn", "traeimp-rtmp", "txffmpeg", "liteavsdk" };
  private static volatile ajcv jdField_a_of_type_Ajcv;
  private InstalledEngine jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine;
  private boolean lameMp3SoLoaded;
  private int mEngineType = 3;
  
  public ajcv()
  {
    Iterator localIterator = EngineInstaller.getInstalledEngine(this.mEngineType).iterator();
    while (localIterator.hasNext())
    {
      InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
      if (localInstalledEngine.isVerify) {
        this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine = localInstalledEngine;
      }
    }
  }
  
  public static ajcv a()
  {
    if (jdField_a_of_type_Ajcv == null) {}
    try
    {
      if (jdField_a_of_type_Ajcv == null) {
        jdField_a_of_type_Ajcv = new ajcv();
      }
      return jdField_a_of_type_Ajcv;
    }
    finally {}
  }
  
  private String a(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine != null) && (paramInstalledEngine.isVerify)) {
      return paramInstalledEngine.engineDir;
    }
    return null;
  }
  
  public void b(InstalledEngine paramInstalledEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine = paramInstalledEngine;
  }
  
  public boolean isLameMp3SoLoaded()
  {
    return this.lameMp3SoLoaded;
  }
  
  public boolean loadAllMiniSo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine != null) {}
    for (;;)
    {
      try
      {
        bool1 = avwj.a(this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.engineDir + File.separator + "liteavsdk.jar", BaseApplicationImpl.getApplication().getApplicationContext(), getClass().getClassLoader(), "com.tencent.rtmp.ui.TXCloudVideoView", null, false);
        if (bool1)
        {
          QLog.e("MiniAppSoLoader", 1, "load liteavsdk.jar successful!!!");
          bool3 = bool1;
          String[] arrayOfString = MINI_APP_LIB_SO;
          int j = arrayOfString.length;
          int i = 0;
          bool1 = true;
          if (i >= j) {
            continue;
          }
          str = arrayOfString[i];
          if ((!"liteavsdk".equals(str)) || (bool3)) {
            continue;
          }
          QLog.e("MiniAppSoLoader", 1, "load liteavsdk.jar failed?!!, and don't load liteavsdk.so ?!!");
          bool1 = false;
          i += 1;
          continue;
        }
      }
      catch (Exception localException)
      {
        String str;
        QLog.e("MiniAppSoLoader", 1, "load liteavsdk.jar failed, e:" + localException.toString());
        boolean bool1 = false;
        continue;
        QLog.e("MiniAppSoLoader", 1, "load liteavsdk.jar failed ？!! ");
        bool3 = bool1;
        continue;
        if ((bool1) && (loadLibSo(str)))
        {
          bool2 = true;
          bool1 = bool2;
          if (!"native_lame_mp3".equals(str)) {
            continue;
          }
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          this.lameMp3SoLoaded = true;
          bool1 = bool2;
          continue;
        }
        boolean bool2 = false;
        continue;
        if ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.engineDir)))
        {
          QLog.d("MiniAppSoLoader", 1, "loadAllOk, TXLiveBase.setLibraryPath:" + this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.engineDir);
          awcj.callSpecifiedStaticMethod("com.tencent.rtmp.TXLiveBase", "setLibraryPath", false, awcj.getParamsClass(new Class[] { String.class }), new Object[] { this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.engineDir });
        }
        return bool1;
      }
      boolean bool3 = false;
    }
  }
  
  public boolean loadLameMp3So()
  {
    return loadLibSo("native_lame_mp3");
  }
  
  protected boolean loadLibSo(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine == null) || (TextUtils.isEmpty(paramString))) {
      QLog.e("MiniAppSoLoader", 1, "[MiniEng]load so " + paramString + " from " + this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine);
    }
    String str2;
    String str1;
    do
    {
      return false;
      str2 = a(this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine);
      str1 = str2 + File.separator + "lib" + paramString + ".so";
      QLog.i("MiniAppSoLoader", 1, "[MiniEng]load so " + paramString + " from " + str1);
    } while (TextUtils.isEmpty(str2));
    try
    {
      System.load(str1);
      if (this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.loadStatus == 1) {
        this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.loadStatus = 3;
      }
      QLog.i("MiniAppSoLoader", 1, "[MiniEng] load " + str1 + " success.");
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniAppSoLoader", 1, "[MiniEng] load " + str1 + " fail: " + DebugUtil.getPrintableStackTrace(paramString), paramString);
      this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.loadStatus = 2;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcv
 * JD-Core Version:    0.7.0.1
 */