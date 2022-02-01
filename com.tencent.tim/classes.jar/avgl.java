import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.PluginUpdater;
import cooperation.plugin.PluginUpdater.a;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class avgl
  extends avfw
  implements Handler.Callback, avgd.b, avgh.a, PluginUpdater.a
{
  private ArrayList<avgl.c> EL = new ArrayList();
  private avgd jdField_a_of_type_Avgd;
  private avgl.d jdField_a_of_type_Avgl$d;
  private avgn jdField_a_of_type_Avgn;
  private PluginUpdater jdField_a_of_type_CooperationPluginPluginUpdater;
  private avfs jdField_b_of_type_Avfs;
  private avgh jdField_b_of_type_Avgh;
  private volatile boolean dmX;
  private Handler ec;
  private Object fY = new Object();
  private ConcurrentHashMap<String, PluginInfo> jW;
  private ConcurrentHashMap<String, OnPluginInstallListener> jX;
  private QQAppInterface mAppInterface;
  private Application mContext;
  private boolean mIsClose;
  private boolean mIsReady;
  
  public avgl(QQAppInterface paramQQAppInterface)
  {
    QLog.d("plugin_tag", 1, "init plugin manager");
    this.mAppInterface = paramQQAppInterface;
    this.mContext = this.mAppInterface.getApp();
    this.ec = new Handler(ThreadManager.getSubThreadLooper(), this);
    ezO();
    this.jdField_a_of_type_CooperationPluginPluginUpdater = new PluginUpdater(this.mContext, this.ec);
    this.jdField_a_of_type_Avgn = new avgn(this.mContext, this, this.mAppInterface);
    this.jdField_a_of_type_CooperationPluginPluginUpdater.a(this);
    this.jdField_a_of_type_Avgd = new avgd(this.mContext, this.mAppInterface);
    try
    {
      this.jdField_b_of_type_Avgh = new avgh(this.mContext, avgd.m(this.mContext).getCanonicalPath());
      label160:
      this.jW = new ConcurrentHashMap();
      this.jX = new ConcurrentHashMap();
      this.jdField_b_of_type_Avfs = avfs.a(this.mContext);
      this.jdField_a_of_type_Avgl$d = new avgl.d();
      this.jdField_a_of_type_Avgl$d.mark();
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      localPluginCommunicationHandler.setCommunicationChannel(new avgq());
      localPluginCommunicationHandler.register(new avgr(paramQQAppInterface));
      paramQQAppInterface = PluginManageHandler.getInstance();
      if (this.mAppInterface.isLogin()) {
        paramQQAppInterface.setPluginManagerProvider(this.mAppInterface, false);
      }
      QLog.d("plugin_tag", 1, "init plugin manager end");
      return;
    }
    catch (IOException localIOException)
    {
      break label160;
    }
  }
  
  private static AlertDialog a(Context paramContext, String paramString, long paramLong, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = acfp.m(2131709766) + paramString + "（" + avft.cs(paramLong) + acfp.m(2131709763);; paramString = paramString + "（" + avft.cs(paramLong) + acfp.m(2131709765)) {
      return new AlertDialog.Builder(paramContext).setMessage(paramString).setNegativeButton(acfp.m(2131709764), paramOnClickListener2).setPositiveButton(acfp.m(2131709768), paramOnClickListener1).create();
    }
  }
  
  private static ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new ProgressDialog(paramContext);
    paramContext.setProgressStyle(1);
    paramContext.setIndeterminate(false);
    paramContext.setTitle(paramString);
    paramContext.setMessage(acfp.m(2131709767));
    paramContext.setCancelable(false);
    paramContext.setButton(-2, acfp.m(2131709769), new avgm(paramOnClickListener));
    return paramContext;
  }
  
  private void a(int paramInt, Context paramContext, avfw.d paramd, avfw.b paramb)
  {
    a(paramInt, false, paramContext, paramd, paramb);
  }
  
  private void a(int paramInt, boolean paramBoolean, Context paramContext, avfw.d paramd, avfw.b paramb)
  {
    QLog.d("plugin_tag", 1, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + paramd.mPluginID + ", " + this.mIsReady);
    if ((!this.mIsReady) && (!avfs.tm(paramd.mPluginID))) {
      if (paramb != null) {
        paramb.a(false, paramContext, paramd);
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
        } while (paramb == null);
        paramb.a(false, paramContext, paramd);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (paramb == null);
      localObject1 = this.jdField_b_of_type_Avgh.c(paramd.mPluginID);
      if ((localObject1 != null) && (((PluginInfo)localObject1).mInstalledPath != null))
      {
        paramd.mApkFilePath = ((PluginInfo)localObject1).mInstalledPath;
        paramd.a((PluginBaseInfo)localObject1);
      }
      paramb.a(true, paramContext, paramd);
      return;
      if (paramInt == 4)
      {
        localObject1 = paramd.mPluginID;
        localObject2 = new avgl.c();
        ((avgl.c)localObject2).context = paramContext;
        ((avgl.c)localObject2).jdField_d_of_type_Avfw$d = paramd;
        ((avgl.c)localObject2).jdField_d_of_type_Avfw$b = paramb;
        ((avgl.c)localObject2).dmZ = true;
        a((String)localObject1, new avgl.e((avgl.c)localObject2));
        return;
      }
      if (paramInt == 1)
      {
        localObject2 = paramd.mPluginID;
        localObject1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.e((String)localObject2);
        if (localObject1 == null) {}
        for (localObject1 = "";; localObject1 = ((PluginInfo)localObject1).mName)
        {
          avgl.c localc = new avgl.c();
          localc.context = paramContext;
          localc.jdField_d_of_type_Avfw$d = paramd;
          localc.jdField_d_of_type_Avfw$b = paramb;
          localc.dmZ = false;
          localc.a = a(paramContext, (String)localObject1, new avgl.a(paramd.mPluginID, null));
          a((String)localObject2, paramBoolean, new avgl.e(localc));
          return;
        }
      }
    } while (paramInt != 3);
    Object localObject1 = paramd.mPluginID;
    Object localObject2 = new avgl.c();
    ((avgl.c)localObject2).context = paramContext;
    ((avgl.c)localObject2).jdField_d_of_type_Avfw$d = paramd;
    ((avgl.c)localObject2).jdField_d_of_type_Avfw$b = paramb;
    ((avgl.c)localObject2).dmZ = true;
    a((String)localObject1, paramBoolean, new avgl.e((avgl.c)localObject2));
  }
  
  private void a(String paramString, avfw.c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doQueryPlugin: " + paramString + ", " + paramc);
    }
    PluginInfo localPluginInfo2 = d(paramString);
    PluginInfo localPluginInfo1 = localPluginInfo2;
    if (localPluginInfo2 != null) {
      localPluginInfo1 = localPluginInfo2.a();
    }
    aKE();
    paramc.a(paramString, localPluginInfo1, this);
  }
  
  public static boolean aKD()
  {
    boolean bool3 = false;
    if (!DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.DpcNames.disable_dex2oat.name())) {}
    for (boolean bool1 = true; bool1; bool1 = false)
    {
      boolean bool4 = Dex2Oat.aKB();
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (bool4)
        {
          bool2 = bool3;
          if (Build.VERSION.SDK_INT >= 21) {
            bool2 = true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 1, "isPluginSupportDex2Oat = " + bool2 + ", " + bool4);
      }
      return bool2;
    }
    return bool1;
  }
  
  private boolean aKE()
  {
    if (!this.dmX)
    {
      this.ec.sendEmptyMessage(66049);
      return true;
    }
    return false;
  }
  
  private PluginInfo d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "fetchPlugin :" + paramString);
    }
    Object localObject2 = (PluginInfo)this.jW.get(paramString);
    Object localObject1;
    if (localObject2 == null)
    {
      PluginInfo localPluginInfo = this.jdField_b_of_type_Avgh.c(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed info :" + localPluginInfo);
      }
      localObject1 = localObject2;
      if (localPluginInfo != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_CooperationPluginPluginUpdater.c(localPluginInfo))
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
        localObject2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.e(paramString);
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
        this.jW.remove(paramString);
        localObject1 = localObject2;
      }
    }
  }
  
  private void doClose()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doClose");
    }
    this.jW.clear();
    this.mAppInterface = null;
    this.mIsClose = true;
  }
  
  private void e(Context paramContext, avfw.d paramd, avfw.b paramb)
  {
    int j = 2;
    boolean bool2 = false;
    boolean bool3 = true;
    if (paramd == null) {}
    PluginInfo localPluginInfo2;
    boolean bool4;
    boolean bool1;
    label309:
    do
    {
      do
      {
        return;
        QLog.d("plugin_tag", 1, "checkUpdate:" + paramd.mPluginID + ", " + paramd.cKu);
        if ((this.mIsReady) || (avfs.tm(paramd.mPluginID))) {
          break;
        }
      } while (paramb == null);
      paramb.a(false, paramContext, paramd);
      return;
      String str = paramd.mPluginID;
      localPluginInfo2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.e(str);
      if (localPluginInfo2 == null)
      {
        a(0, paramContext, paramd, paramb);
        return;
      }
      bool4 = this.jdField_b_of_type_Avgh.isPluginInstalled(str);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed :" + bool4);
      }
      if (bool4)
      {
        PluginInfo localPluginInfo1 = this.jdField_b_of_type_Avgh.c(str);
        bool1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.c(localPluginInfo1);
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "up to day :" + bool1);
        }
        localObject = localPluginInfo1;
        if (bool1)
        {
          int i = j;
          if (aKD())
          {
            i = j;
            if (Dex2Oat.to(localPluginInfo1.mFingerPrint))
            {
              if (!avgf.a(localPluginInfo2, this.mContext)) {
                break label309;
              }
              QLog.d("plugin_tag", 1, "systemOTA but running " + str);
              i = j;
            }
          }
          for (;;)
          {
            a(i, paramContext, paramd, paramb);
            return;
            i = 4;
            QLog.d("plugin_tag", 1, "systemOTA runDex2Oat");
          }
        }
      }
      else
      {
        localObject = null;
      }
      if ((!avgf.a(localPluginInfo2, this.mContext)) || (localObject == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
    } while (paramb == null);
    paramd.mApkFilePath = ((PluginInfo)localObject).mInstalledPath;
    paramd.a((PluginBaseInfo)localObject);
    paramb.a(true, paramContext, paramd);
    return;
    if ((localPluginInfo2.mUpdateType == 0) && (bool4)) {
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "forceUpdate, deamonInstall：" + bool1 + ", " + bool2);
      }
      if (!bool2) {
        break;
      }
      a(3, paramContext, paramd, paramb);
      return;
      bool1 = bool3;
      if (localPluginInfo2.mInstallType != 1)
      {
        bool2 = true;
        bool1 = bool3;
      }
    }
    if (localObject != null) {}
    for (Object localObject = ((PluginInfo)localObject).mFingerPrint;; localObject = null)
    {
      paramd = new avgl.b(paramb, bool1, paramContext, paramd, bool4, (String)localObject, null);
      a(paramContext, localPluginInfo2.mName, localPluginInfo2.mLength, paramd, paramd, bool1).show();
      return;
    }
  }
  
  private void ezO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "clearOldVersionPlugins");
    }
    File localFile1 = this.mContext.getDir("plugins", 0);
    File localFile2 = this.mContext.getDir("NetPlugins", 0);
    try
    {
      aqhq.cn(localFile1.getCanonicalPath());
      aqhq.cn(localFile2.getCanonicalPath());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private void ezP()
  {
    Iterator localIterator = this.jW.values().iterator();
    while (localIterator.hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)localIterator.next();
      if ((localPluginInfo != null) && (localPluginInfo.mState == 1) && (localPluginInfo.ewW == 1)) {
        cancelInstall(localPluginInfo.mID);
      }
    }
  }
  
  private void ezQ()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "getPluginList");
        }
        boolean bool = this.mIsClose;
        if (bool) {
          return;
        }
        if (!this.dmX)
        {
          this.dmX = true;
          if (!aqiw.isNetworkAvailable(this.mContext)) {
            WA(false);
          } else {
            this.jdField_a_of_type_CooperationPluginPluginUpdater.eP(this.mAppInterface);
          }
        }
      }
      finally {}
    }
  }
  
  private void ezR()
  {
    if (NetworkState.isMobile()) {
      ezP();
    }
    while ((!NetworkState.isWifiConn()) || (!this.mIsReady)) {
      return;
    }
    this.jdField_a_of_type_Avgn.ezT();
  }
  
  private boolean ts(String paramString)
  {
    paramString = this.jdField_b_of_type_Avfs.a(paramString);
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_CooperationPluginPluginUpdater.c(paramString);
  }
  
  public void C(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (PluginInfo)this.jW.get(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1) && (paramInt2 > 0)) {
      ((PluginInfo)localObject).mDownloadProgress = (paramInt1 / paramInt2);
    }
    localObject = (OnPluginInstallListener)this.jX.get(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallDownloadProgress(paramString, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void WA(boolean paramBoolean)
  {
    this.mIsReady = true;
    if (!paramBoolean) {
      this.dmX = false;
    }
    for (;;)
    {
      synchronized (this.fY)
      {
        if (this.EL.isEmpty()) {
          break label121;
        }
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "onUpdateFinish. handle pending");
        }
        Iterator localIterator = this.EL.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        avgl.c localc = (avgl.c)localIterator.next();
        e(localc.context, localc.jdField_d_of_type_Avfw$d, localc.jdField_d_of_type_Avfw$b);
      }
      this.jdField_a_of_type_Avgn.start();
    }
    this.EL.clear();
    for (;;)
    {
      return;
      label121:
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "mPendingLaunchStateList empty");
      }
    }
  }
  
  public void ZN(String paramString)
  {
    Object localObject = (PluginInfo)this.jW.get(paramString);
    this.jW.remove(paramString);
    ((PluginInfo)localObject).mState = -2;
    localObject = (OnPluginInstallListener)this.jX.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 4);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void ZO(String paramString)
  {
    Object localObject = (PluginInfo)this.jW.get(paramString);
    if (localObject != null)
    {
      ((PluginInfo)localObject).mState = 1;
      ((PluginInfo)localObject).ewW = aqiw.getNetworkType(this.mContext);
    }
    localObject = (OnPluginInstallListener)this.jX.get(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallBegin(paramString);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void ZQ(String paramString)
  {
    Object localObject = (PluginInfo)this.jW.get(paramString);
    this.jW.remove(paramString);
    if (localObject != null) {
      ((PluginInfo)localObject).mState = -2;
    }
    localObject = (OnPluginInstallListener)this.jX.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 6);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void ZR(String paramString)
  {
    paramString = (PluginInfo)this.jW.get(paramString);
    if (paramString != null) {
      paramString.mState = 3;
    }
  }
  
  public void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    QLog.d("plugin_tag", 1, "dex2oatPlugin." + paramString);
    PluginInfo localPluginInfo = this.jdField_b_of_type_Avgh.c(paramString);
    if (localPluginInfo == null) {
      return;
    }
    if (avgf.a(localPluginInfo, this.mContext))
    {
      QLog.d("plugin_tag", 1, "dex2oatPlugin plugin still running " + paramString);
      return;
    }
    if (paramOnPluginInstallListener != null) {
      this.jX.put(paramString, paramOnPluginInstallListener);
    }
    localPluginInfo.mState = 5;
    this.jW.put(paramString, localPluginInfo);
    this.jdField_b_of_type_Avgh.c(localPluginInfo, this);
  }
  
  public void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean)
  {
    a(paramString, false, paramBoolean, paramOnPluginInstallListener);
  }
  
  public void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener)
  {
    a(paramString, paramBoolean, false, paramOnPluginInstallListener);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, OnPluginInstallListener paramOnPluginInstallListener)
  {
    QLog.d("plugin_tag", 1, "installPlugin." + paramString);
    PluginInfo localPluginInfo1 = null;
    if (paramBoolean1)
    {
      localPluginInfo1 = this.jdField_b_of_type_Avfs.a(paramString);
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
      PluginInfo localPluginInfo2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.e(paramString);
      if (localPluginInfo2 == null) {
        break;
      }
      localPluginInfo1 = localPluginInfo2.a();
      break;
      if (avgf.a(localPluginInfo1, this.mContext))
      {
        QLog.d("plugin_tag", 1, "plugin still running");
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
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin not run");
      }
      if (paramOnPluginInstallListener != null) {
        this.jX.put(paramString, paramOnPluginInstallListener);
      }
      localPluginInfo1.mState = 5;
      this.jW.put(paramString, localPluginInfo1);
      if ((ts(paramString)) || (paramBoolean1))
      {
        this.jdField_b_of_type_Avgh.a(localPluginInfo1, this);
        return;
      }
      this.jdField_a_of_type_Avgd.a(localPluginInfo1, this, paramBoolean2);
      return;
    }
  }
  
  public PluginInfo b(String paramString)
  {
    PluginInfo localPluginInfo = d(paramString);
    paramString = localPluginInfo;
    if (localPluginInfo != null) {
      paramString = localPluginInfo.a();
    }
    aKE();
    return paramString;
  }
  
  public boolean b(PluginInfo paramPluginInfo)
  {
    this.jdField_a_of_type_Avgd.cancelDownload(paramPluginInfo.mID);
    return this.jdField_b_of_type_Avgh.tr(paramPluginInfo.mID);
  }
  
  public void bd(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onDownloadFinish:" + paramBoolean);
    }
    Object localObject = (PluginInfo)this.jW.get(paramString);
    if (localObject != null)
    {
      if (!paramBoolean) {
        break label72;
      }
      ((PluginInfo)localObject).mState = 2;
      ((PluginInfo)localObject).mDownloadProgress = 1.0F;
      this.jdField_b_of_type_Avgh.a((PluginInfo)localObject, this);
    }
    label72:
    do
    {
      return;
      ((PluginInfo)localObject).mState = -2;
      this.jW.remove(paramString);
      localObject = (OnPluginInstallListener)this.jX.remove(paramString);
    } while (localObject == null);
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 5);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void be(boolean paramBoolean, String paramString)
  {
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.jX.remove(paramString);
    PluginInfo localPluginInfo = (PluginInfo)this.jW.get(paramString);
    this.jW.remove(paramString);
    if (localPluginInfo != null) {
      if (!paramBoolean) {
        break label70;
      }
    }
    for (int i = 4;; i = -2)
    {
      localPluginInfo.mState = i;
      if ((localOnPluginInstallListener != null) && (!paramBoolean)) {
        break;
      }
      label70:
      try
      {
        localOnPluginInstallListener.onInstallFinish(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    }
    try
    {
      localOnPluginInstallListener.onInstallError(paramString, 7);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void c(Context paramContext, avfw.d paramd, avfw.b paramb)
  {
    if ((!this.mIsReady) && (!avfs.tm(paramd.mPluginID)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not ready");
      }
      synchronized (this.fY)
      {
        avgl.c localc;
        if (!this.EL.isEmpty())
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "mPendingLaunchStateList not empty");
          }
          localc = new avgl.c();
          localc.context = paramContext;
          localc.jdField_d_of_type_Avfw$d = paramd;
          localc.jdField_d_of_type_Avfw$b = paramb;
          this.EL.add(localc);
          return;
        }
        synchronized (this.fY)
        {
          aKE();
          localc = new avgl.c();
          localc.context = paramContext;
          localc.jdField_d_of_type_Avfw$d = paramd;
          localc.jdField_d_of_type_Avfw$b = paramb;
          this.EL.add(localc);
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "set mPendingLaunchStateList");
          }
          return;
        }
      }
    }
    e(paramContext, paramd, paramb);
  }
  
  public void cancelInstall(String paramString)
  {
    this.jdField_a_of_type_Avgd.cancelDownload(paramString);
    this.jdField_b_of_type_Avgh.tr(paramString);
  }
  
  public void dc(String paramString)
  {
    Object localObject = (PluginInfo)this.jW.get(paramString);
    this.jW.remove(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1))
    {
      ((PluginInfo)localObject).mState = -1;
      ((PluginInfo)localObject).ewW = 0;
    }
    localObject = (OnPluginInstallListener)this.jX.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 3);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void ezM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    aKE();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.mIsClose) {
      return true;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 65536: 
      a(paramMessage.getData().getString("index_for_id"), (avfw.c)paramMessage.obj);
      return true;
    case 66049: 
      ezQ();
      return true;
    case 66304: 
      ezR();
      return true;
    }
    doClose();
    return true;
  }
  
  public void installPlugin(String paramString)
  {
    installPlugin(paramString, null);
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    a(paramString, false, false, paramOnPluginInstallListener);
  }
  
  public boolean isPlugininstalled(String paramString)
  {
    boolean bool2 = false;
    paramString = b(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.mState == 4)
      {
        bool1 = bool2;
        if (paramString.mInstalledPath != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isReady()
  {
    return this.mIsReady;
  }
  
  public void onDestroy()
  {
    this.ec.obtainMessage(65537).sendToTarget();
    this.jdField_a_of_type_Avgl$d.release();
    ??? = PluginCommunicationHandler.getInstance();
    ((PluginCommunicationHandler)???).setCommunicationChannel(null);
    ((PluginCommunicationHandler)???).unregister("common.get_qq_app_interface_data");
    synchronized (this.fY)
    {
      this.EL.clear();
      return;
    }
  }
  
  public void setListener(RemotePluginManager paramRemotePluginManager)
    throws RemoteException
  {}
  
  public void z(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, " recordPluginStartupTime " + paramString1 + ", key = " + paramString2 + ", span = " + paramLong);
    }
    paramString1 = this.jdField_b_of_type_Avgh.c(paramString1);
    if (paramString1 != null)
    {
      if (!"pluginApkCost".equals(paramString2)) {
        break label81;
      }
      paramString1.costApk = paramLong;
    }
    label81:
    do
    {
      return;
      if ("pluginOatCost".equals(paramString2))
      {
        paramString1.costDex2Oat = paramLong;
        return;
      }
      if ("pluginDownloadCost".equals(paramString2))
      {
        paramString1.costDownload = paramLong;
        return;
      }
    } while (!"pluginLibCost".equals(paramString2));
    paramString1.costLib = paramLong;
  }
  
  class a
    implements DialogInterface.OnClickListener
  {
    private String pluginId;
    
    private a(String paramString)
    {
      this.pluginId = paramString;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return;
      }
      avgl.this.cancelInstall(this.pluginId);
    }
  }
  
  class b
    implements DialogInterface.OnClickListener
  {
    boolean DA;
    avfw.b jdField_c_of_type_Avfw$b;
    avfw.d jdField_c_of_type_Avfw$d;
    boolean dmY;
    Context mContext;
    String mFingerPrint;
    
    private b(avfw.b paramb, boolean paramBoolean1, Context paramContext, avfw.d paramd, boolean paramBoolean2, String paramString)
    {
      this.jdField_c_of_type_Avfw$b = paramb;
      this.dmY = paramBoolean1;
      this.mContext = paramContext;
      this.jdField_c_of_type_Avfw$d = paramd;
      this.DA = paramBoolean2;
      this.mFingerPrint = paramString;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      int i = 0;
      switch (paramInt)
      {
      default: 
        return;
      case -1: 
        avgl.a(avgl.this, 1, this.mContext, this.jdField_c_of_type_Avfw$d, this.jdField_c_of_type_Avfw$b);
        return;
      }
      if (this.dmY) {
        paramInt = i;
      }
      for (;;)
      {
        avgl.a(avgl.this, paramInt, this.mContext, this.jdField_c_of_type_Avfw$d, this.jdField_c_of_type_Avfw$b);
        return;
        paramInt = i;
        if (this.DA)
        {
          if (avgl.aKD())
          {
            boolean bool = Dex2Oat.to(this.mFingerPrint);
            if (bool) {}
            for (i = 4;; i = 2)
            {
              paramInt = i;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("plugin_tag", 2, "dialog needOTA :" + bool);
              paramInt = i;
              break;
            }
          }
          paramInt = 2;
        }
      }
    }
  }
  
  public static class c
  {
    public ProgressDialog a;
    public Context context;
    public avfw.b d;
    public avfw.d d;
    public boolean dmZ = true;
  }
  
  public class d
    implements INetEventHandler
  {
    private boolean cxr;
    private Context mContext = BaseApplicationImpl.getApplication();
    
    public d() {}
    
    public void mark()
    {
      if (this.cxr) {}
      do
      {
        return;
        this.cxr = true;
        try
        {
          AppNetConnInfo.registerNetChangeReceiver(this.mContext, this);
          return;
        }
        catch (Exception localException) {}
      } while (!QLog.isColorLevel());
      QLog.d("plugin_tag", 2, localException, new Object[0]);
    }
    
    public void onNetChangeEvent(boolean paramBoolean)
    {
      avgl.a(avgl.this).sendEmptyMessage(66304);
    }
    
    public void release()
    {
      if (!this.cxr) {}
      do
      {
        return;
        this.cxr = false;
        try
        {
          AppNetConnInfo.unregisterNetEventHandler(this);
          return;
        }
        catch (Exception localException) {}
      } while (!QLog.isColorLevel());
      QLog.d("plugin_tag", 2, localException, new Object[0]);
    }
  }
  
  class e
    extends OnPluginInstallListener.Stub
  {
    private avgl.c jdField_a_of_type_Avgl$c;
    long azw = 0L;
    
    public e(avgl.c paramc)
    {
      this.jdField_a_of_type_Avgl$c = paramc;
    }
    
    public void onInstallBegin(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
      }
      if ((!this.jdField_a_of_type_Avgl$c.dmZ) && (this.jdField_a_of_type_Avgl$c.a != null)) {
        this.jdField_a_of_type_Avgl$c.a.show();
      }
      this.azw = System.currentTimeMillis();
    }
    
    public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
      }
      if ((!this.jdField_a_of_type_Avgl$c.dmZ) && (this.jdField_a_of_type_Avgl$c.a != null))
      {
        this.jdField_a_of_type_Avgl$c.a.setMax(paramInt2);
        this.jdField_a_of_type_Avgl$c.a.setProgress(paramInt1);
      }
    }
    
    public void onInstallError(String paramString, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
      }
      avgl.c localc = this.jdField_a_of_type_Avgl$c;
      if ((localc != null) && (localc.jdField_d_of_type_Avfw$b != null))
      {
        paramString = avgl.this.b(paramString);
        if ((paramString != null) && (paramString.mInstalledPath != null)) {
          localc.jdField_d_of_type_Avfw$d.mApkFilePath = paramString.mInstalledPath;
        }
        paramString = localc.jdField_d_of_type_Avfw$b;
        if (paramInt != 2) {
          break label122;
        }
      }
      label122:
      for (boolean bool = true;; bool = false)
      {
        paramString.a(bool, localc.context, localc.jdField_d_of_type_Avfw$d);
        return;
      }
    }
    
    public void onInstallFinish(String paramString)
    {
      long l = 0L;
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
      }
      paramString = this.jdField_a_of_type_Avgl$c;
      if ((paramString != null) && (!paramString.dmZ) && (paramString.a != null)) {
        paramString.a.dismiss();
      }
      if ((paramString != null) && (paramString.jdField_d_of_type_Avfw$b != null))
      {
        PluginInfo localPluginInfo = avgl.a(avgl.this).c(paramString.jdField_d_of_type_Avfw$d.mPluginID);
        if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
        {
          paramString.jdField_d_of_type_Avfw$d.mApkFilePath = localPluginInfo.mInstalledPath;
          paramString.jdField_d_of_type_Avfw$d.a(localPluginInfo);
        }
        paramString.jdField_d_of_type_Avfw$b.a(true, paramString.context, paramString.jdField_d_of_type_Avfw$d);
      }
      if (this.azw != 0L) {
        l = System.currentTimeMillis() - this.azw;
      }
      avgl.this.z(this.jdField_a_of_type_Avgl$c.jdField_d_of_type_Avfw$d.mPluginID, "pluginDownloadCost", l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgl
 * JD-Core Version:    0.7.0.1
 */