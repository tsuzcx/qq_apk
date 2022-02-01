import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoost.ConfigBuilder;
import com.qflutter.native_resources.QFlutterSkinEnginePlugin;
import com.qflutter.resource_loader.QFlutterResourceLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.launch.QFlutterLauncher.2;
import com.tencent.mobileqq.flutter.launch.QFlutterLauncher.4;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.view.FlutterMain;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class ahfz
{
  private static ahfz jdField_a_of_type_Ahfz;
  private ahfy jdField_a_of_type_Ahfy = new ahfy();
  private final Looper jdField_a_of_type_AndroidOsLooper = Looper.getMainLooper();
  private boolean cgK;
  private final Set<ahfw> cr = new HashSet();
  private final Handler mMainHandler = new Handler(this.jdField_a_of_type_AndroidOsLooper);
  private int mStatus = 0;
  
  public static ahfz a()
  {
    if (jdField_a_of_type_Ahfz == null) {}
    try
    {
      if (jdField_a_of_type_Ahfz == null) {
        jdField_a_of_type_Ahfz = new ahfz();
      }
      return jdField_a_of_type_Ahfz;
    }
    finally {}
  }
  
  private void a(ahfw paramahfw)
  {
    if (paramahfw == null) {
      return;
    }
    synchronized (this.cr)
    {
      this.cr.add(paramahfw);
      return;
    }
  }
  
  private void dnl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.launcher", 2, "start install");
    }
    this.jdField_a_of_type_Ahfy.dnm();
    if (ahfv.anf())
    {
      this.cgK = true;
      ahfv.dnl();
      return;
    }
    this.cgK = false;
    ahfu.register();
    Bundle localBundle = new Bundle();
    if (2 == BaseApplicationImpl.sProcessId) {
      localBundle.putString("FlutterCallerIpcProcessName", "com.tencent.mobileqq:qzone");
    }
    QIPCClientHelper.getInstance().getClient().callServer("FlutterMainQIPCModule", "ACTION_INSTALL_ENGINE", localBundle, new ahga(this));
  }
  
  private void ensureRunningOnMainThread()
  {
    if (Looper.myLooper() != this.jdField_a_of_type_AndroidOsLooper) {}
  }
  
  private void r(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("QFlutter.launcher", 1, String.format("notifyResult, errCode: %s, isFirstLaunch: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) }));
    if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsLooper)
    {
      s(paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    ThreadManager.getUIHandler().post(new QFlutterLauncher.4(this, paramInt, paramBoolean1, paramBoolean2));
  }
  
  private void s(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mMainHandler.removeCallbacksAndMessages(null);
    if (paramInt == 0) {}
    for (this.mStatus = 2;; this.mStatus = 0)
    {
      ahfx localahfx = new ahfx(paramInt, paramBoolean1, this.cgK, paramBoolean2);
      if (paramBoolean1) {
        this.jdField_a_of_type_Ahfy.bB(paramInt, this.cgK);
      }
      Iterator localIterator = this.cr.iterator();
      while (localIterator.hasNext()) {
        ((ahfw)localIterator.next()).a(localahfx);
      }
    }
  }
  
  public void JW(String paramString)
  {
    this.jdField_a_of_type_Ahfy.dnn();
    String str = paramString + File.separator + "res.apk";
    if (ahbj.isFileExists(str)) {
      try
      {
        AssetManager localAssetManager = BaseApplicationImpl.getContext().getAssets();
        Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localAssetManager, new Object[] { str });
        this.jdField_a_of_type_Ahfy.dno();
        if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsLooper)
        {
          JX(paramString);
          return;
        }
        ThreadManager.getUIHandler().post(new QFlutterLauncher.2(this, paramString));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("QFlutter.launcher", 1, "loadAsset", paramString);
        r(5, true, false);
        return;
      }
    }
    QLog.e("QFlutter.launcher", 1, String.format("assetsPath: %s not exist", new Object[] { str }));
    r(4, true, false);
  }
  
  public void JX(String paramString)
  {
    ensureRunningOnMainThread();
    this.jdField_a_of_type_Ahfy.dnp();
    FlutterMain.setNativeLibDir(paramString);
    ahfq.setNativeLibDir(paramString);
    com.tencent.qflutter.utils.FLog.sLog = new ahfp();
    QFlutterResourceLoader.get().init(BaseApplicationImpl.getContext(), new ahfq(BaseApplicationImpl.getContext()));
    paramString = new ahgb(this);
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
    paramString = new FlutterBoost.ConfigBuilder(BaseApplicationImpl.getApplication(), ahfo.a()).isDebug(false).whenEngineStart(FlutterBoost.ConfigBuilder.IMMEDIATELY).renderMode(FlutterView.RenderMode.texture).pluginsRegister(paramString).build();
    try
    {
      FlutterBoost.instance().init(paramString);
      FlutterBoost.instance().boostPluginRegistry();
      this.jdField_a_of_type_Ahfy.dnq();
      r(0, true, this.jdField_a_of_type_Ahfy.ang());
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("QFlutter.launcher", 1, "loadEngine", paramString);
      r(6, true, false);
    }
  }
  
  public void a(ahfw paramahfw, boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureRunningOnMainThread();
    a(paramahfw);
    if (this.mStatus == 2)
    {
      QLog.d("QFlutter.launcher", 1, "engine is running");
      r(0, false, true);
      return;
    }
    if (this.mStatus == 1)
    {
      QLog.d("QFlutter.launcher", 1, "engine is launching");
      return;
    }
    this.mStatus = 1;
    this.jdField_a_of_type_Ahfy.reset();
    this.jdField_a_of_type_Ahfy.ca(paramBoolean1, paramBoolean2);
    dnl();
  }
  
  public boolean anh()
  {
    return this.mStatus == 1;
  }
  
  public void b(ahfw paramahfw)
  {
    if (paramahfw == null) {
      return;
    }
    synchronized (this.cr)
    {
      this.cr.remove(paramahfw);
      return;
    }
  }
  
  public void c(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.launcher", 2, String.format("onInstallResult, isSuccess: %s, installDir: %s, isLocalEngineExist: %s, isLocalAppExist: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    }
    if ((paramBoolean1) && (ahbj.isFileExists(paramString)))
    {
      this.jdField_a_of_type_Ahfy.cb(paramBoolean2, paramBoolean3);
      JW(paramString);
      return;
    }
    QLog.d("QFlutter.launcher", 1, String.format("onInstallResult, isSuccess: %s, installDir: %s, fileIsExist: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(ahbj.isFileExists(paramString)) }));
    r(3, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfz
 * JD-Core Version:    0.7.0.1
 */