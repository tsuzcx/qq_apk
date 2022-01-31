package cooperation.plugin;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.rc.GetQQAppInterfaceDataRemoteCommand;
import fmu;
import fmv;
import fmw;
import fmx;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class PluginManagerV2
  extends IPluginManager
  implements Handler.Callback, PluginDownloader.OnPluginDownLoadListener, PluginInstaller.OnPluginSetupListener, PluginUpdater.OnPluginInfoUpdateListener
{
  private static PluginInstaller jdField_a_of_type_CooperationPluginPluginInstaller;
  private static PluginUpdater jdField_a_of_type_CooperationPluginPluginUpdater;
  public static final int b = 0;
  public static final int c = 1;
  static final String jdField_c_of_type_JavaLangString = "PluginManager";
  public static final int d = 2;
  private static final String jdField_d_of_type_JavaLangString = "index_for_id";
  public static final int e = 3;
  private Application jdField_a_of_type_AndroidAppApplication;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private PluginDownloader jdField_a_of_type_CooperationPluginPluginDownloader;
  private volatile PluginManagerV2.LaunchState jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
  private PluginManagerV2.NetworkReceiver jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver;
  private PluginPreInstaller jdField_a_of_type_CooperationPluginPluginPreInstaller;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  
  public PluginManagerV2(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "init plugin manager");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    b();
    jdField_a_of_type_CooperationPluginPluginUpdater = new PluginUpdater(this.jdField_a_of_type_AndroidAppApplication);
    this.jdField_a_of_type_CooperationPluginPluginPreInstaller = new PluginPreInstaller(this.jdField_a_of_type_AndroidAppApplication, this);
    jdField_a_of_type_CooperationPluginPluginUpdater.a(this);
    this.jdField_a_of_type_CooperationPluginPluginDownloader = new PluginDownloader(this.jdField_a_of_type_AndroidAppApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    try
    {
      jdField_a_of_type_CooperationPluginPluginInstaller = new PluginInstaller(this.jdField_a_of_type_AndroidAppApplication, PluginDownloader.a(this.jdField_a_of_type_AndroidAppApplication).getCanonicalPath());
      label144:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_a_of_type_CooperationPluginBuiltinPluginManager = BuiltinPluginManager.a(this.jdField_a_of_type_AndroidAppApplication);
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver = new PluginManagerV2.NetworkReceiver(this);
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver.a();
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      localPluginCommunicationHandler.setCommunicationChannel(new QQPluginCommunicationChannel());
      localPluginCommunicationHandler.register(new GetQQAppInterfaceDataRemoteCommand(paramQQAppInterface));
      PluginManageHandler.getInstance().setPluginManagerProvider(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      return;
    }
    catch (IOException localIOException)
    {
      break label144;
    }
  }
  
  private static AlertDialog a(Context paramContext, String paramString, long paramLong, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = "你需要先下载 " + paramString + "（" + ByteUnitTransformUtil.a(paramLong) + "），才能启动";; paramString = paramString + "（" + ByteUnitTransformUtil.a(paramLong) + "）有更新，是否需要下载") {
      return new AlertDialog.Builder(paramContext).setMessage(paramString).setNegativeButton("取消", paramOnClickListener2).setPositiveButton("确认", paramOnClickListener1).create();
    }
  }
  
  private static ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new ProgressDialog(paramContext);
    paramContext.setProgressStyle(1);
    paramContext.setIndeterminate(false);
    paramContext.setTitle(paramString);
    paramContext.setMessage("下载中...");
    paramContext.setCancelable(false);
    paramContext.setButton(-2, "取消", new fmu(paramOnClickListener));
    return paramContext;
  }
  
  private void a(int paramInt, Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    a(paramInt, false, paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  private void a(int paramInt, boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + paramPluginParams.b);
    }
    if ((!this.d) && (!BuiltinPluginManager.b(paramPluginParams.b))) {
      if (paramOnPluginReadyListener != null) {
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 0) {
            break;
          }
        } while (paramOnPluginReadyListener == null);
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (paramOnPluginReadyListener == null);
      paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
      return;
      if (paramInt == 1)
      {
        str = paramPluginParams.b;
        localObject = jdField_a_of_type_CooperationPluginPluginUpdater.a(str);
        if (localObject == null) {}
        for (localObject = "";; localObject = ((PluginInfo)localObject).mName)
        {
          localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          localLaunchState.jdField_a_of_type_Boolean = false;
          localLaunchState.jdField_a_of_type_AndroidAppProgressDialog = a(paramContext, (String)localObject, new fmv(this, paramPluginParams.b, null));
          a(str, paramBoolean, new fmx(this, localLaunchState, paramContext));
          return;
        }
      }
    } while (paramInt != 3);
    String str = paramPluginParams.b;
    Object localObject = jdField_a_of_type_CooperationPluginPluginUpdater.a(str);
    PluginManagerV2.LaunchState localLaunchState = new PluginManagerV2.LaunchState();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((PluginInfo)localObject).mName)
    {
      localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
      localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
      localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
      localLaunchState.jdField_a_of_type_Boolean = false;
      localLaunchState.jdField_a_of_type_AndroidAppProgressDialog = a(paramContext, (String)localObject, new fmv(this, paramPluginParams.b, null));
      a(str, paramBoolean, new fmx(this, localLaunchState, paramContext));
      return;
    }
  }
  
  private void a(String paramString, IPluginManager.OnQueryPluginListener paramOnQueryPluginListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doQueryPlugin: " + paramString + ", " + paramOnQueryPluginListener);
    }
    PluginInfo localPluginInfo2 = b(paramString);
    PluginInfo localPluginInfo1 = localPluginInfo2;
    if (localPluginInfo2 != null) {
      localPluginInfo1 = localPluginInfo2.a();
    }
    b();
    paramOnQueryPluginListener.a(paramString, localPluginInfo1, this);
  }
  
  private PluginInfo b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "fetchPlugin :" + paramString);
    }
    Object localObject2 = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    Object localObject1;
    if (localObject2 == null)
    {
      PluginInfo localPluginInfo = jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed info :" + localPluginInfo);
      }
      localObject1 = localObject2;
      if (localPluginInfo != null)
      {
        localObject1 = localObject2;
        if (jdField_a_of_type_CooperationPluginPluginUpdater.a(localPluginInfo))
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "up to day info");
          }
          localObject1 = localPluginInfo;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
      }
      return localObject2;
      int i = ((PluginInfo)localObject2).mState;
      if ((i != -1) && (i != 4))
      {
        localObject1 = localObject2;
        if (i != -2) {}
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        localObject1 = localObject2;
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "clearOldVersionPlugins");
    }
    File localFile1 = this.jdField_a_of_type_AndroidAppApplication.getDir("plugins", 0);
    File localFile2 = this.jdField_a_of_type_AndroidAppApplication.getDir("NetPlugins", 0);
    try
    {
      FileUtils.a(localFile1.getCanonicalPath());
      FileUtils.a(localFile2.getCanonicalPath());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private boolean b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(66049);
      return true;
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    paramString = this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString);
    if (paramString == null) {
      return false;
    }
    return jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)localIterator.next();
      if ((localPluginInfo != null) && (localPluginInfo.mState == 1) && (localPluginInfo.a == 1)) {
        cancelInstall(localPluginInfo.mID);
      }
    }
  }
  
  private void c(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "checkUpdate");
    }
    if ((!this.d) && (!BuiltinPluginManager.b(paramPluginParams.b))) {
      if (paramOnPluginReadyListener != null) {
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      }
    }
    PluginInfo localPluginInfo;
    boolean bool3;
    boolean bool1;
    do
    {
      return;
      Object localObject = paramPluginParams.b;
      localPluginInfo = jdField_a_of_type_CooperationPluginPluginUpdater.a((String)localObject);
      if (localPluginInfo == null)
      {
        a(0, paramContext, paramPluginParams, paramOnPluginReadyListener);
        return;
      }
      bool3 = jdField_a_of_type_CooperationPluginPluginInstaller.a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed :" + bool3);
      }
      if (bool3)
      {
        localObject = jdField_a_of_type_CooperationPluginPluginInstaller.a((String)localObject);
        bool1 = jdField_a_of_type_CooperationPluginPluginUpdater.a((PluginInfo)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "up to day :" + bool1);
        }
        if (bool1)
        {
          a(2, paramContext, paramPluginParams, paramOnPluginReadyListener);
          return;
        }
      }
      if (!PluginInfoUtil.a(localPluginInfo, this.jdField_a_of_type_AndroidAppApplication)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
    } while (paramOnPluginReadyListener == null);
    paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
    return;
    if ((localPluginInfo.mUpdateType == 0) && (bool3)) {
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "forceUpdate, deamonInstall：" + bool1 + ", " + bool2);
      }
      if (bool2)
      {
        a(3, paramContext, paramPluginParams, paramOnPluginReadyListener);
        return;
        if (localPluginInfo.mInstallType == 1) {
          bool1 = true;
        }
      }
      else
      {
        paramPluginParams = new fmw(this, paramOnPluginReadyListener, bool1, paramContext, paramPluginParams, bool3, null);
        a(paramContext, localPluginInfo.mName, localPluginInfo.mLength, paramPluginParams, paramPluginParams, bool1).show();
        return;
      }
      bool2 = true;
      bool1 = true;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doClose");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.c = true;
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "getPluginList");
        }
        boolean bool = this.c;
        if (bool) {
          return;
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          if (!NetworkUtil.f(this.jdField_a_of_type_AndroidAppApplication)) {
            a(false);
          } else {
            jdField_a_of_type_CooperationPluginPluginUpdater.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
      }
      finally {}
    }
  }
  
  public PluginInfo a(String paramString)
  {
    PluginInfo localPluginInfo = b(paramString);
    paramString = localPluginInfo;
    if (localPluginInfo != null) {
      paramString = localPluginInfo.a();
    }
    b();
    return paramString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    b();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1) && (paramInt2 > 0)) {
      ((PluginInfo)localObject).mDownloadProgress = (paramInt1 / paramInt2);
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallDownloadProgress(paramString, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void a(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if ((!this.d) && (!BuiltinPluginManager.b(paramPluginParams.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not ready");
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "mPengdingLaunchState already set");
          }
          if (paramOnPluginReadyListener != null) {
            paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
          }
          return;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          b();
          PluginManagerV2.LaunchState localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = localLaunchState;
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "set mPendingLaunchState");
          }
          return;
        }
      }
    }
    c(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  public void a(String paramString)
  {
    installPlugin(paramString, null);
  }
  
  public void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "installPlugin." + paramString);
    }
    PluginInfo localPluginInfo1 = null;
    if (paramBoolean)
    {
      localPluginInfo1 = this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString);
      if ((localPluginInfo1 == null) && (paramOnPluginInstallListener == null)) {}
    }
    for (;;)
    {
      try
      {
        paramOnPluginInstallListener.onInstallError(paramString, 1);
        return;
      }
      catch (RemoteException paramString) {}
      PluginInfo localPluginInfo2 = jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
      if (localPluginInfo2 == null) {
        break;
      }
      localPluginInfo1 = localPluginInfo2.a();
      break;
      if (PluginInfoUtil.a(localPluginInfo1, this.jdField_a_of_type_AndroidAppApplication))
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "plugin still running");
        }
        if (paramOnPluginInstallListener == null) {
          continue;
        }
        try
        {
          paramOnPluginInstallListener.onInstallError(paramString, 2);
          return;
        }
        catch (RemoteException paramString)
        {
          return;
        }
      }
      if (paramOnPluginInstallListener != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramOnPluginInstallListener);
      }
      localPluginInfo1.mState = 0;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPluginInfo1);
      if ((b(paramString)) || (paramBoolean))
      {
        jdField_a_of_type_CooperationPluginPluginInstaller.a(localPluginInfo1, this);
        return;
      }
      this.jdField_a_of_type_CooperationPluginPluginDownloader.a(localPluginInfo1, this);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = true;
    if (!paramBoolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "onUpdateFinish. handle pending launch state");
        }
        localLaunchState = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
        c(localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
        this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = null;
      }
      while (!QLog.isColorLevel())
      {
        PluginManagerV2.LaunchState localLaunchState;
        return;
      }
      QLog.d("plugin_tag", 2, "mPendingLaunchState is null");
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onDownloadFinish:" + paramBoolean);
    }
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      if (!paramBoolean) {
        break label71;
      }
      ((PluginInfo)localObject).mState = 2;
      ((PluginInfo)localObject).mDownloadProgress = 1.0F;
      jdField_a_of_type_CooperationPluginPluginInstaller.a((PluginInfo)localObject, this);
    }
    label71:
    do
    {
      return;
      ((PluginInfo)localObject).mState = -2;
      localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    } while (localObject == null);
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 5);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public boolean a()
  {
    if (jdField_a_of_type_CooperationPluginPluginUpdater.a("qqfav.apk") == null) {}
    PluginInfo localPluginInfo;
    do
    {
      do
      {
        return true;
      } while (!jdField_a_of_type_CooperationPluginPluginInstaller.a("qqfav.apk"));
      localPluginInfo = jdField_a_of_type_CooperationPluginPluginInstaller.a("qqfav.apk");
    } while ((!jdField_a_of_type_CooperationPluginPluginUpdater.a(localPluginInfo)) || (!jdField_a_of_type_CooperationPluginPluginInstaller.a(IPluginManager.a())));
    return false;
  }
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    this.jdField_a_of_type_CooperationPluginPluginDownloader.a(paramPluginInfo.mID);
    return jdField_a_of_type_CooperationPluginPluginInstaller.b(paramPluginInfo.mID);
  }
  
  public boolean a(String paramString, IPluginManager.OnQueryPluginListener paramOnQueryPluginListener)
  {
    if (paramOnQueryPluginListener == null) {
      return false;
    }
    paramOnQueryPluginListener = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65536, paramOnQueryPluginListener);
    Bundle localBundle = new Bundle();
    localBundle.putString("index_for_id", paramString);
    paramOnQueryPluginListener.setData(localBundle);
    paramOnQueryPluginListener.sendToTarget();
    return true;
  }
  
  public void b(String paramString)
  {
    ((PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).mState = -2;
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localOnPluginInstallListener != null) {}
    try
    {
      localOnPluginInstallListener.onInstallError(paramString, 4);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if ((localOnPluginInstallListener == null) || (paramBoolean)) {}
    try
    {
      localOnPluginInstallListener.onInstallFinish(paramString);
      label30:
      paramString = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        if (!paramBoolean) {
          break label76;
        }
      }
      label76:
      for (int i = 4;; i = -2)
      {
        for (;;)
        {
          paramString.mState = i;
          return;
          try
          {
            localOnPluginInstallListener.onInstallError(paramString, 7);
          }
          catch (RemoteException localRemoteException1) {}
        }
        break;
      }
    }
    catch (RemoteException localRemoteException2)
    {
      break label30;
    }
  }
  
  public void c(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      ((PluginInfo)localObject).mState = 1;
      ((PluginInfo)localObject).a = NetworkUtil.b(this.jdField_a_of_type_AndroidAppApplication);
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallBegin(paramString);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void cancelInstall(String paramString)
  {
    this.jdField_a_of_type_CooperationPluginPluginDownloader.a(paramString);
    jdField_a_of_type_CooperationPluginPluginInstaller.b(paramString);
  }
  
  public void d(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1))
    {
      ((PluginInfo)localObject).mState = -1;
      ((PluginInfo)localObject).a = 0;
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 3);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void e(String paramString)
  {
    ((PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).mState = -2;
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localOnPluginInstallListener != null) {}
    try
    {
      localOnPluginInstallListener.onInstallError(paramString, 6);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void f(String paramString)
  {
    paramString = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      paramString.mState = 3;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.c) {
      return true;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 65536: 
      a(paramMessage.getData().getString("index_for_id"), (IPluginManager.OnQueryPluginListener)paramMessage.obj);
      return true;
    case 66049: 
      e();
      return true;
    case 66304: 
      c();
      return true;
    }
    d();
    return true;
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    a(paramString, false, paramOnPluginInstallListener);
  }
  
  public boolean isPlugininstalled(String paramString)
  {
    if ((paramString.equals("qqfav.apk")) && (a())) {}
    do
    {
      return false;
      paramString = a(paramString);
    } while ((paramString == null) || (paramString.mState != 4));
    return true;
  }
  
  public boolean isReady()
  {
    return this.d;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65537).sendToTarget();
    this.jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver.b();
    ??? = PluginCommunicationHandler.getInstance();
    ((PluginCommunicationHandler)???).setCommunicationChannel(null);
    ((PluginCommunicationHandler)???).unregister("common.get_qq_app_interface_data");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2
 * JD-Core Version:    0.7.0.1
 */