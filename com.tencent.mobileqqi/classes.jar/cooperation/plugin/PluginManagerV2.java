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
import iah;
import iai;
import iaj;
import iak;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PluginManagerV2
  extends IPluginManager
  implements Handler.Callback, PluginDownloader.OnPluginDownLoadListener, PluginInstaller.OnPluginSetupListener, PluginUpdater.OnPluginInfoUpdateListener
{
  static final String jdField_a_of_type_JavaLangString = "PluginManager";
  public static final int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "index_for_id";
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  private Application jdField_a_of_type_AndroidAppApplication;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private PluginDownloader jdField_a_of_type_CooperationPluginPluginDownloader;
  private PluginInstaller jdField_a_of_type_CooperationPluginPluginInstaller;
  private volatile PluginManagerV2.LaunchState jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
  private PluginManagerV2.NetworkReceiver jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver;
  private PluginUpdater jdField_a_of_type_CooperationPluginPluginUpdater;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public PluginManagerV2(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "init plugin manager");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    b();
    this.jdField_a_of_type_CooperationPluginPluginUpdater = new PluginUpdater(this.jdField_a_of_type_AndroidAppApplication);
    boolean bool;
    if (!this.jdField_a_of_type_CooperationPluginPluginUpdater.a().isEmpty()) {
      bool = true;
    }
    for (;;)
    {
      this.d = bool;
      this.jdField_a_of_type_CooperationPluginPluginUpdater.a(this);
      this.jdField_a_of_type_CooperationPluginPluginDownloader = new PluginDownloader(this.jdField_a_of_type_AndroidAppApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
      try
      {
        this.jdField_a_of_type_CooperationPluginPluginInstaller = new PluginInstaller(this.jdField_a_of_type_AndroidAppApplication, PluginDownloader.a(this.jdField_a_of_type_AndroidAppApplication).getCanonicalPath());
        label142:
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        this.jdField_a_of_type_CooperationPluginBuiltinPluginManager = BuiltinPluginManager.a(this.jdField_a_of_type_AndroidAppApplication);
        this.jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver = new PluginManagerV2.NetworkReceiver(this);
        this.jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver.a();
        PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        localPluginCommunicationHandler.setCommunicationChannel(new QQPluginCommunicationChannel());
        localPluginCommunicationHandler.register(new GetQQAppInterfaceDataRemoteCommand(paramQQAppInterface));
        PluginManageHandler.getInstance().setPluginManager(this);
        return;
        bool = false;
      }
      catch (IOException localIOException)
      {
        break label142;
      }
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
    paramContext.setButton(-2, "取消", new iah(paramOnClickListener));
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
        localObject2 = paramPluginParams.b;
        localObject1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a((String)localObject2);
        if (localObject1 == null) {}
        for (localObject1 = "";; localObject1 = ((PluginInfo)localObject1).mName)
        {
          PluginManagerV2.LaunchState localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          localLaunchState.jdField_a_of_type_Boolean = false;
          localLaunchState.jdField_a_of_type_AndroidAppProgressDialog = a(paramContext, (String)localObject1, new iai(this, paramPluginParams.b, null));
          a((String)localObject2, paramBoolean, new iak(localLaunchState));
          return;
        }
      }
    } while (paramInt != 3);
    Object localObject1 = paramPluginParams.b;
    Object localObject2 = new PluginManagerV2.LaunchState();
    ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
    ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
    ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
    ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_Boolean = true;
    a((String)localObject1, paramBoolean, new iak((PluginManagerV2.LaunchState)localObject2));
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
    a();
    paramOnQueryPluginListener.a(paramString, localPluginInfo1, this);
  }
  
  private boolean a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(66049);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString);
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
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
      PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed info :" + localPluginInfo);
      }
      localObject1 = localObject2;
      if (localPluginInfo != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_CooperationPluginPluginUpdater.a(localPluginInfo))
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
        localObject2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
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
  
  private void b(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
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
      localPluginInfo = this.jdField_a_of_type_CooperationPluginPluginUpdater.a((String)localObject);
      if (localPluginInfo == null)
      {
        a(0, paramContext, paramPluginParams, paramOnPluginReadyListener);
        return;
      }
      bool3 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed :" + bool3);
      }
      if (bool3)
      {
        localObject = this.jdField_a_of_type_CooperationPluginPluginInstaller.a((String)localObject);
        bool1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a((PluginInfo)localObject);
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
        paramPluginParams = new iaj(this, paramOnPluginReadyListener, bool1, paramContext, paramPluginParams, bool3, null);
        a(paramContext, localPluginInfo.mName, localPluginInfo.mLength, paramPluginParams, paramPluginParams, bool1).show();
        return;
      }
      bool2 = true;
      bool1 = true;
    }
  }
  
  private void b(Context paramContext, PluginInfo paramPluginInfo, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "checkUpdate");
    }
    String str = paramPluginParams.b;
    if (paramPluginInfo == null) {
      a(0, paramContext, paramPluginParams, paramOnPluginReadyListener);
    }
    boolean bool;
    do
    {
      return;
      bool = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(str);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed :" + bool);
      }
      if (bool)
      {
        a(2, paramContext, paramPluginParams, paramOnPluginReadyListener);
        return;
      }
      if (!PluginInfoUtil.a(paramPluginInfo, this.jdField_a_of_type_AndroidAppApplication)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
    } while (paramOnPluginReadyListener == null);
    paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
    return;
    paramPluginParams = new iaj(this, paramOnPluginReadyListener, true, paramContext, paramPluginParams, bool, null);
    a(paramContext, paramPluginInfo.mName, paramPluginInfo.mLength, paramPluginParams, paramPluginParams, true).show();
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
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doClose");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.c = true;
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 53
    //   10: iconst_2
    //   11: ldc_w 470
    //   14: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 468	cooperation/plugin/PluginManagerV2:c	Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifeq +6 -> 29
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 347	cooperation/plugin/PluginManagerV2:jdField_b_of_type_Boolean	Z
    //   33: ifne -7 -> 26
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 347	cooperation/plugin/PluginManagerV2:jdField_b_of_type_Boolean	Z
    //   41: aload_0
    //   42: getfield 76	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginUpdater	Lcooperation/plugin/PluginUpdater;
    //   45: aload_0
    //   46: getfield 60	cooperation/plugin/PluginManagerV2:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   49: invokevirtual 472	cooperation/plugin/PluginUpdater:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   52: goto -26 -> 26
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	PluginManagerV2
    //   21	2	1	bool	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	55	finally
    //   17	22	55	finally
    //   29	52	55	finally
  }
  
  public PluginInfo a(String paramString)
  {
    PluginInfo localPluginInfo = new PluginInfo();
    localPluginInfo.mID = paramString;
    localPluginInfo.mName = "test for BOSS!";
    localPluginInfo.mState = 4;
    localPluginInfo.mLength = 123456L;
    return localPluginInfo;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    a();
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
      if (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "mPengdingLaunchState already set");
        }
        if (paramOnPluginReadyListener != null) {
          paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
        }
      }
      while (!a()) {
        return;
      }
      PluginManagerV2.LaunchState localLaunchState = new PluginManagerV2.LaunchState();
      localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
      localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
      localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = localLaunchState;
      return;
    }
    b(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  public void a(Context paramContext, PluginInfo paramPluginInfo, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if ((!this.d) && (!BuiltinPluginManager.b(paramPluginParams.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not ready");
      }
      if (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "mPengdingLaunchState already set");
        }
        if (paramOnPluginReadyListener != null) {
          paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
        }
      }
      while (!a()) {
        return;
      }
      paramPluginInfo = new PluginManagerV2.LaunchState();
      paramPluginInfo.jdField_a_of_type_AndroidContentContext = paramContext;
      paramPluginInfo.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
      paramPluginInfo.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = paramPluginInfo;
      return;
    }
    b(paramContext, paramPluginInfo, paramPluginParams, paramOnPluginReadyListener);
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
      PluginInfo localPluginInfo2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
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
      if (paramString.equals("TencentUnipay.apk"))
      {
        this.jdField_a_of_type_CooperationPluginPluginDownloader.a(localPluginInfo1, this);
        return;
      }
      if ((a(paramString)) || (paramBoolean))
      {
        this.jdField_a_of_type_CooperationPluginPluginInstaller.a(localPluginInfo1, this);
        return;
      }
      this.jdField_a_of_type_CooperationPluginPluginDownloader.a(localPluginInfo1, this);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.d = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "onUpdateFinish. handle pending launch state");
        }
        PluginManagerV2.LaunchState localLaunchState = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
        b(localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
        this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = null;
      }
      return;
      this.jdField_b_of_type_Boolean = false;
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
        break label72;
      }
      ((PluginInfo)localObject).mState = 2;
      ((PluginInfo)localObject).mDownloadProgress = 1.0F;
      this.jdField_a_of_type_CooperationPluginPluginInstaller.a((PluginInfo)localObject, this);
    }
    label72:
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
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    this.jdField_a_of_type_CooperationPluginPluginDownloader.a(paramPluginInfo.mID);
    return this.jdField_a_of_type_CooperationPluginPluginInstaller.b(paramPluginInfo.mID);
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
    this.jdField_a_of_type_CooperationPluginPluginInstaller.b(paramString);
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
    boolean bool2 = false;
    PluginInfo localPluginInfo1 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString);
    PluginInfo localPluginInfo2 = this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString);
    int i;
    boolean bool1;
    if ((localPluginInfo2 != null) && (localPluginInfo1 != null) && (!localPluginInfo2.mMD5.equals(localPluginInfo1.mMD5)))
    {
      i = 1;
      if ((!a(paramString)) || (i == 0)) {
        break label108;
      }
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "needReInstall :" + paramString);
        bool1 = bool2;
      }
    }
    label108:
    do
    {
      return bool1;
      i = 0;
      break;
      bool2 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("plugin_tag", 2, "isPlugininstalled :" + paramString + "," + bool2);
    return bool2;
  }
  
  public boolean isReady()
  {
    return this.d;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65537).sendToTarget();
    this.jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver.b();
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    localPluginCommunicationHandler.setCommunicationChannel(null);
    localPluginCommunicationHandler.unregister("common.get_qq_app_interface_data");
    this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2
 * JD-Core Version:    0.7.0.1
 */