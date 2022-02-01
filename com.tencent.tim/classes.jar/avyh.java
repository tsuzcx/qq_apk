import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginManager.1;
import cooperation.qzone.plugin.QZonePluginManager.2;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class avyh
  extends avxl
  implements Handler.Callback, avxu.b, avyc.c, avyf.b, avyf.c, avym.a, Manager
{
  avyh.a jdField_a_of_type_Avyh$a;
  private avyk jdField_a_of_type_Avyk;
  private avym jdField_a_of_type_Avym;
  private avxu jdField_b_of_type_Avxu;
  private avyc jdField_b_of_type_Avyc;
  private avyf jdField_b_of_type_Avyf;
  private boolean closed;
  private boolean dpt;
  private boolean dpu;
  private Handler ed;
  Object fY = new Object();
  private ConcurrentHashMap<String, PluginRecord> jW;
  private ConcurrentHashMap<String, WeakReference<avxr>> jX;
  private WeakReference<avxq> jf;
  Context mContext;
  private boolean mIsReady;
  
  public avyh(QQAppInterface paramQQAppInterface)
  {
    QLog.i("QZonePluginManger", 1, "QZonePluginManager init");
    this.ed = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mContext = paramQQAppInterface.getApp();
    this.jdField_a_of_type_Avym = new avym(paramQQAppInterface, this.mContext, this.ed);
    this.jdField_a_of_type_Avym.a(this);
    this.jW = new ConcurrentHashMap();
    this.jX = new ConcurrentHashMap();
    this.jdField_b_of_type_Avyc = new avyc(this.mContext);
    this.jdField_b_of_type_Avxu = new avxu(this.mContext);
    this.jdField_b_of_type_Avyf = new avyf(this.mContext);
    this.closed = false;
    avyq.a().setAppInterface(paramQQAppInterface);
  }
  
  private void a(int paramInt, Context paramContext, avxl.b paramb, avxl.a parama)
  {
    if (paramb == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              QLog.i("QZonePluginManger", 1, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + paramb.mPluginID);
            } while (isClosed());
            if (this.mIsReady) {
              break;
            }
          } while (parama == null);
          parama.a(false, paramContext, paramb);
          return;
          if (paramInt != 0) {
            break;
          }
        } while (parama == null);
        parama.a(false, paramContext, paramb);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (parama == null);
      localObject1 = this.jdField_b_of_type_Avyf.b(paramb.mPluginID);
      if (localObject1 != null) {
        paramb.mApkFilePath = ((PluginRecord)localObject1).mInstalledPath;
      }
      parama.a(true, paramContext, paramb);
      return;
      if (paramInt == 1)
      {
        localObject1 = paramb.mPluginID;
        localObject2 = this.jdField_a_of_type_Avym.d((String)localObject1);
        if (localObject2 == null) {}
        for (;;)
        {
          localObject2 = new avyh.a();
          ((avyh.a)localObject2).context = paramContext;
          ((avyh.a)localObject2).jdField_b_of_type_Avxl$b = paramb;
          ((avyh.a)localObject2).jdField_b_of_type_Avxl$a = parama;
          try
          {
            a((String)localObject1, new avyh.b((avyh.a)localObject2), 0);
            return;
          }
          catch (RemoteException paramContext)
          {
            QLog.e("QZonePluginManger", 1, paramContext, new Object[0]);
            return;
          }
          localObject2 = ((PluginRecord)localObject2).name;
        }
      }
    } while (paramInt != 3);
    Object localObject1 = paramb.mPluginID;
    Object localObject2 = new avyh.a();
    ((avyh.a)localObject2).context = paramContext;
    ((avyh.a)localObject2).jdField_b_of_type_Avxl$b = paramb;
    ((avyh.a)localObject2).jdField_b_of_type_Avxl$a = parama;
    try
    {
      a((String)localObject1, new avyh.b((avyh.a)localObject2), 0);
      return;
    }
    catch (RemoteException paramContext)
    {
      QLog.e("QZonePluginManger", 1, paramContext, new Object[0]);
    }
  }
  
  public static boolean aLU()
  {
    boolean bool2 = true;
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginDownloadOnlyWifi", 1);
    QLog.d("QZonePluginManger", 1, "canDownloadPlugin, onlyWifi=" + i);
    boolean bool1;
    if (i > 0) {
      bool1 = NetworkState.isWifiConn();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            i = NetworkState.getNetworkType();
            QLog.d("QZonePluginManger", 1, "network type = " + i);
            bool1 = bool2;
          } while (1 == i);
          bool1 = bool2;
        } while (4 == i);
        bool1 = bool2;
      } while (5 == i);
      bool1 = bool2;
    } while (3 == i);
    return false;
  }
  
  private PluginRecord c(String paramString)
  {
    if (isClosed()) {
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner: manager is close. pluginId=" + paramString);
    }
    do
    {
      return null;
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner " + paramString + "");
    } while (TextUtils.isEmpty(paramString));
    PluginRecord localPluginRecord2 = (PluginRecord)this.jW.get(paramString);
    QLog.i("QZonePluginManger", 1, "mProcessingPlugins getInstalledPlugininfo " + localPluginRecord2 + "");
    PluginRecord localPluginRecord1;
    if (localPluginRecord2 == null)
    {
      localPluginRecord1 = this.jdField_b_of_type_Avyf.b(paramString);
      QLog.i("QZonePluginManger", 1, "installer getInstalledPlugininfo " + localPluginRecord1 + "");
      if (localPluginRecord1 == null)
      {
        localPluginRecord1 = this.jdField_a_of_type_Avym.d(paramString);
        QLog.i("QZonePluginManger", 1, "updater getNewPluginRecord " + localPluginRecord1 + "");
      }
    }
    for (;;)
    {
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner final record " + localPluginRecord1 + "");
      return localPluginRecord1;
      boolean bool = this.jdField_a_of_type_Avym.b(localPluginRecord1);
      QLog.i("QZonePluginManger", 1, "updater.checkUpToDate: " + bool + "");
      if (!bool)
      {
        localPluginRecord1 = this.jdField_a_of_type_Avym.d(paramString);
        QLog.i("QZonePluginManger", 1, "updater getNewPluginRecord " + localPluginRecord1 + "");
        continue;
        int i = localPluginRecord2.state;
        if ((i != -1) && (i != 4))
        {
          localPluginRecord1 = localPluginRecord2;
          if (i != -2) {}
        }
        else
        {
          this.jW.remove(paramString);
          localPluginRecord1 = localPluginRecord2;
        }
      }
    }
  }
  
  private void c(Context paramContext, avxl.b paramb, avxl.a parama)
  {
    if (paramb == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("QZonePluginManger", 1, "checkUpdate:" + paramb.mPluginID);
        } while (isClosed());
        if (this.mIsReady) {
          break;
        }
      } while (parama == null);
      parama.a(false, paramContext, paramb);
      return;
      localObject = paramb.mPluginID;
      PluginRecord localPluginRecord = this.jdField_a_of_type_Avym.e((String)localObject);
      if (localPluginRecord == null)
      {
        a(0, paramContext, paramb, parama);
        return;
      }
      boolean bool = isPluginInstalled((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "installed :" + bool);
      }
      localObject = this.jdField_b_of_type_Avyf.b((String)localObject);
      if (bool)
      {
        bool = this.jdField_a_of_type_Avym.b((PluginRecord)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "up to day :" + bool);
        }
        if (bool)
        {
          a(2, paramContext, paramb, parama);
          return;
        }
      }
      if ((!avyo.a(localPluginRecord, paramContext)) || (localPluginRecord == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "plugin still running");
      }
    } while (parama == null);
    paramb.mApkFilePath = ((PluginRecord)localObject).mInstalledPath;
    parama.a(true, paramContext, paramb);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "forceUpdate, deamonInstall：" + true + ", " + true);
    }
    a(3, paramContext, paramb, parama);
  }
  
  private void eCx()
  {
    QLog.i("QZonePluginManger", 1, "getPluginListIfNeed  pluginInfoRequesting:" + this.dpt + " isReady:" + isReady() + " :lastUpdateSuccess:" + this.dpu);
    if (isClosed()) {}
    while ((this.dpt) || (this.dpu)) {
      return;
    }
    this.ed.sendEmptyMessage(0);
  }
  
  private void ezQ()
  {
    QLog.i("QZonePluginManger", 2, "getPluginList  pluginInfoRequesting:" + this.dpt);
    if (isClosed()) {}
    while (this.dpt) {
      return;
    }
    this.dpt = true;
    this.jdField_a_of_type_Avym.ezQ();
  }
  
  private void gV(String paramString, int paramInt)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QZonePluginManager.1(this, paramString, paramInt));
  }
  
  private void gW(String paramString, int paramInt)
  {
    if (isClosed()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("pluginid", paramString);
    anpc.a(this.mContext).collectPerformance(null, "actQzonePluginPatch", true, 0L, 0L, localHashMap, null);
  }
  
  private boolean isClosed()
  {
    return this.closed;
  }
  
  private boolean nG(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  public void WT(boolean paramBoolean)
  {
    QLog.i("QZonePluginManger", 1, "onUpdatefinish success:" + paramBoolean);
    if (isClosed()) {
      return;
    }
    this.dpu = paramBoolean;
    this.mIsReady = true;
    if ((paramBoolean) && (this.jdField_a_of_type_Avyk != null)) {
      this.jdField_a_of_type_Avyk.preload();
    }
    synchronized (this.fY)
    {
      if (this.jdField_a_of_type_Avyh$a != null)
      {
        QLog.i("QZonePluginManger", 1, "onUpdateFinish. handle pending launch state");
        avyh.a locala = this.jdField_a_of_type_Avyh$a;
        c(locala.context, locala.jdField_b_of_type_Avxl$b, locala.jdField_b_of_type_Avxl$a);
        this.jdField_a_of_type_Avyh$a = null;
        this.ed.post(new QZonePluginManager.2(this));
        return;
      }
      QLog.i("QZonePluginManger", 1, "mPendingLaunchState is null");
    }
  }
  
  public PluginRecord a(String paramString)
  {
    if (isClosed()) {
      QLog.i("QZonePluginManger", 1, "queryPlugin: manager is close. pluginId=" + paramString);
    }
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    PluginRecord localPluginRecord2 = c(paramString);
    PluginRecord localPluginRecord1 = localPluginRecord2;
    if (localPluginRecord2 != null) {
      localPluginRecord1 = localPluginRecord2.clone();
    }
    eCx();
    QLog.i("QZonePluginManger", 1, "queryPlugin queryPlugin：" + paramString + ",record:" + localPluginRecord1);
    return localPluginRecord1;
  }
  
  public void a(Context paramContext, avxl.b paramb, avxl.a parama)
  {
    if (isClosed())
    {
      QLog.w("QZonePluginManger", 1, "QZonePluginManagerIsClosed=true");
      return;
    }
    if (!this.mIsReady)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "not ready");
      }
      synchronized (this.fY)
      {
        if (this.jdField_a_of_type_Avyh$a != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZonePluginManger", 2, "mPengdingLaunchState already set");
          }
          if (parama != null) {
            parama.a(false, paramContext, paramb);
          }
          return;
        }
      }
      synchronized (this.fY)
      {
        eCx();
        avyh.a locala = new avyh.a();
        locala.context = paramContext;
        locala.jdField_b_of_type_Avxl$b = paramb;
        locala.jdField_b_of_type_Avxl$a = parama;
        this.jdField_a_of_type_Avyh$a = locala;
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "set mPendingLaunchState");
        }
        return;
      }
    }
    c(paramContext, paramb, parama);
  }
  
  public void a(avxq paramavxq, int paramInt)
    throws RemoteException
  {
    QLog.i("QZonePluginManger", 1, "installPituSo");
    if (avyq.a().getAppInterface() == null) {
      QLog.w("QZonePluginManger", 1, "installPituSo, app is null");
    }
    do
    {
      return;
      this.jf = new WeakReference(paramavxq);
      paramavxq = avpw.Gc();
    } while (TextUtils.isEmpty(paramavxq));
    this.jdField_b_of_type_Avxu.a(paramavxq, this, paramInt);
  }
  
  public void a(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onDownLoadStart record:" + paramPluginRecord);
    if (isClosed()) {
      break label33;
    }
    for (;;)
    {
      label33:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.jW.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        ((PluginRecord)localObject).state = 1;
        localObject = (WeakReference)this.jX.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (avxr)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((avxr)localObject).onInstallBegin(paramPluginRecord.id);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public void a(PluginRecord paramPluginRecord, int paramInt)
  {
    QLog.i("QZonePluginManger", 1, "onDownloadFailed record:" + paramPluginRecord);
    if (isClosed()) {
      break label33;
    }
    label33:
    Object localObject;
    for (;;)
    {
      return;
      if (paramPluginRecord != null)
      {
        paramPluginRecord.state = -2;
        this.jW.remove(paramPluginRecord.id);
        localObject = (WeakReference)this.jX.remove(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (avxr)((WeakReference)localObject).get();
          if (localObject != null) {
            if (-9998 == paramInt)
            {
              ((avxr)localObject).onInstallError(paramPluginRecord.id, 8);
              gW(paramPluginRecord.id, 8);
              return;
            }
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
          return;
        }
      }
    }
    ((avxr)localObject).onInstallError(paramPluginRecord.id, 5);
    gW(paramPluginRecord.id, 5);
  }
  
  public void a(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onInstallFinish record:" + paramPluginRecord);
    if (isClosed()) {}
    while (paramPluginRecord == null) {
      return;
    }
    Object localObject = (WeakReference)this.jX.remove(paramPluginRecord.id);
    try
    {
      this.jW.remove(paramPluginRecord.id);
      if (paramBoolean)
      {
        if (localObject != null)
        {
          localObject = (avxr)((WeakReference)localObject).get();
          if (localObject != null) {
            ((avxr)localObject).onInstallFinish(paramPluginRecord.id);
          }
        }
        gW(paramPluginRecord.id, 0);
        return;
      }
    }
    catch (RemoteException paramPluginRecord)
    {
      QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
      return;
    }
    if (localObject != null)
    {
      localObject = (avxr)((WeakReference)localObject).get();
      if (localObject != null) {
        ((avxr)localObject).onInstallError(paramPluginRecord.id, 7);
      }
    }
    gW(paramPluginRecord.id, 7);
  }
  
  public boolean a(String paramString, avxr paramavxr, int paramInt)
    throws RemoteException
  {
    if (isClosed()) {
      QLog.i("QZonePluginManger", 1, "installPlugin: manager is closed. pluginId=" + paramString);
    }
    do
    {
      return false;
      QLog.i("QZonePluginManger", 1, "installPlugin pluginid=" + paramString + " refer=" + paramInt);
    } while (TextUtils.isEmpty(paramString));
    if (this.jW.containsKey(paramString))
    {
      QLog.d("QZonePluginManger", 1, "installPlugin pluginid:" + paramString + ",正在处理，skip。。。");
      return false;
    }
    this.jX.put(paramString, new WeakReference(paramavxr));
    PluginRecord localPluginRecord1 = this.jdField_a_of_type_Avym.d(paramString);
    if (localPluginRecord1 != null)
    {
      PluginRecord localPluginRecord2 = this.jdField_b_of_type_Avyf.b(paramString);
      if ((localPluginRecord2 != null) && (localPluginRecord2.state == 4) && (this.jdField_a_of_type_Avym.b(localPluginRecord2)))
      {
        QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 已安装");
        if (paramavxr != null) {
          paramavxr.onInstallFinish(paramString);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Avyk == null) {
        this.jdField_a_of_type_Avyk = new avyk(this, this.jdField_a_of_type_Avym);
      }
      return true;
      QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 未安装,开始下载");
      this.jW.put(paramString, localPluginRecord1);
      this.jdField_b_of_type_Avyc.a(localPluginRecord1, this, paramInt);
      gV(localPluginRecord1.id, paramInt);
      continue;
      QLog.e("QZonePluginManger", 1, "installPlugin record==null 没有插件信息，失败");
      this.jW.remove(paramString);
      if (paramavxr != null) {
        paramavxr.onInstallError(paramString, 1);
      }
      gW(paramString, 1);
    }
  }
  
  public void b(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onDownloadCanceled record:" + paramPluginRecord);
    if (isClosed()) {}
    while (paramPluginRecord == null) {
      return;
    }
    paramPluginRecord.state = -1;
    this.jW.remove(paramPluginRecord.id);
    Object localObject = (WeakReference)this.jX.remove(paramPluginRecord.id);
    if (localObject != null) {}
    try
    {
      localObject = (avxr)((WeakReference)localObject).get();
      if (localObject != null) {
        ((avxr)localObject).onInstallError(paramPluginRecord.id, 3);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("QZonePluginManger", 1, localRemoteException, new Object[0]);
      }
    }
    gW(paramPluginRecord.id, 3);
  }
  
  public void b(PluginRecord paramPluginRecord, int paramInt)
  {
    QLog.i("QZonePluginManger", 1, "onDownloadSucceed record:" + paramPluginRecord + " refer=" + paramInt);
    if (isClosed()) {}
    PluginRecord localPluginRecord;
    do
    {
      do
      {
        return;
      } while (paramPluginRecord == null);
      localPluginRecord = (PluginRecord)this.jW.get(paramPluginRecord.id);
    } while (localPluginRecord == null);
    localPluginRecord.state = 2;
    boolean bool;
    if ((nG(paramInt)) && (avyo.a(paramPluginRecord, this.mContext)))
    {
      if (!paramPluginRecord.id.equals(avyo.GF())) {
        break label248;
      }
      if (!awcs.tK(awcs.GL())) {
        break label243;
      }
      bool = true;
    }
    for (;;)
    {
      QLog.i("QZonePluginManger", 1, "onDownloadSucceed record=" + paramPluginRecord + " isPluginRealRunning=" + bool);
      Object localObject;
      if (bool)
      {
        localObject = (WeakReference)this.jX.get(paramPluginRecord.id);
        if (localObject != null)
        {
          localObject = (avxr)((WeakReference)localObject).get();
          if (localObject == null) {}
        }
      }
      try
      {
        ((avxr)localObject).onInstallError(paramPluginRecord.id, 2);
        gW(paramPluginRecord.id, 2);
        this.jdField_b_of_type_Avyf.a(localPluginRecord, this);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          QLog.e("QZonePluginManger", 1, localRemoteException, new Object[0]);
        }
      }
      label243:
      bool = false;
      continue;
      label248:
      bool = true;
    }
  }
  
  public void b(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onUnInstallFinish reslut:" + paramBoolean + "record:" + paramPluginRecord);
    if (isClosed()) {}
  }
  
  public void c(avxu.a parama)
  {
    if (this.jf != null) {}
    try
    {
      parama = (avxq)this.jf.get();
      if (parama != null) {
        parama.eBB();
      }
      return;
    }
    catch (RemoteException parama)
    {
      QLog.e("QZonePluginManger", 1, parama, new Object[0]);
    }
  }
  
  public void c(PluginRecord paramPluginRecord)
  {
    if (isClosed()) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.jW.get(paramPluginRecord.id);
        if (localObject != null) {
          ((PluginRecord)localObject).state = 1;
        }
        localObject = (WeakReference)this.jX.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (avxr)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((avxr)localObject).a(paramPluginRecord.id, paramPluginRecord.progress, paramPluginRecord.size);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public void d(avxu.a parama)
  {
    if (this.jf != null) {}
    try
    {
      parama = (avxq)this.jf.get();
      if (parama != null) {
        parama.onDownloadCancel();
      }
      return;
    }
    catch (RemoteException parama)
    {
      QLog.e("QZonePluginManger", 1, parama, new Object[0]);
    }
  }
  
  public void d(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onInstallBegin record:" + paramPluginRecord);
    if (isClosed()) {
      break label33;
    }
    for (;;)
    {
      label33:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.jW.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        ((PluginRecord)localObject).state = 3;
        localObject = (WeakReference)this.jX.get(paramPluginRecord.id);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (avxr)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((avxr)localObject).onInstallBegin(paramPluginRecord.id);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public void e(avxu.a parama)
  {
    if (this.jf != null) {}
    try
    {
      avxq localavxq = (avxq)this.jf.get();
      if (localavxq != null) {
        localavxq.abV(parama.errorCode);
      }
      return;
    }
    catch (RemoteException parama)
    {
      QLog.e("QZonePluginManger", 1, parama, new Object[0]);
    }
  }
  
  public void e(PluginRecord paramPluginRecord)
  {
    QLog.i("QZonePluginManger", 1, "onUnInstallBegin record:" + paramPluginRecord);
    if (isClosed()) {}
  }
  
  public void eCv()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 1, "triggerQQDownloadPtuFilter");
    }
    QQAppInterface localQQAppInterface = avyq.a().getAppInterface();
    if (localQQAppInterface == null) {
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter, app is null");
    }
    do
    {
      do
      {
        return;
      } while (!ankq.axZ());
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter");
    } while (ankq.by(BaseApplicationImpl.getContext()));
    ankq.f(localQQAppInterface, BaseApplicationImpl.getContext());
  }
  
  public void ezM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    eCx();
  }
  
  public void f(avxu.a parama)
  {
    if (this.jf != null) {}
    try
    {
      parama = (avxq)this.jf.get();
      if (parama != null) {
        parama.onDownloadSuccess();
      }
      return;
    }
    catch (RemoteException parama)
    {
      QLog.e("QZonePluginManger", 1, parama, new Object[0]);
    }
  }
  
  public void g(avxu.a parama)
  {
    if ((this.jf != null) && (parama != null)) {}
    try
    {
      avxq localavxq = (avxq)this.jf.get();
      if (localavxq != null) {
        localavxq.bn(parama.progress);
      }
      return;
    }
    catch (RemoteException parama)
    {
      QLog.e("QZonePluginManger", 1, parama, new Object[0]);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      ezQ();
    }
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    boolean bool = true;
    QLog.i("QZonePluginManger", 1, "isPluginInstalled: " + paramString);
    if (isClosed()) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramString));
      paramString = a(paramString);
    } while (paramString == null);
    QLog.i("QZonePluginManger", 1, " isPluginInstalled record :" + paramString);
    if (paramString.state == 4) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean isReady()
  {
    if (isClosed()) {
      return false;
    }
    return this.mIsReady;
  }
  
  public void onDestroy()
  {
    QLog.i("QZonePluginManger", 1, "onDestroy");
    this.jX.clear();
    this.jW.clear();
    this.jdField_a_of_type_Avym = null;
    this.jdField_b_of_type_Avyf = null;
    if (this.jdField_b_of_type_Avyc != null) {
      this.jdField_b_of_type_Avyc.onDestroy();
    }
    this.jdField_b_of_type_Avxu = null;
    this.jdField_b_of_type_Avyc = null;
    if (this.jdField_a_of_type_Avyk != null) {
      this.jdField_a_of_type_Avyk.onDestroy();
    }
    this.jdField_a_of_type_Avyk = null;
    this.closed = true;
  }
  
  public boolean tB(String paramString)
  {
    QLog.i("QZonePluginManger", 1, "cancelInstall " + paramString + "");
    if (isClosed()) {}
    while (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = this.jdField_a_of_type_Avym.d(paramString);
    this.jdField_b_of_type_Avyc.a(paramString, this);
    return false;
  }
  
  public boolean tr(String paramString)
  {
    QLog.i("QZonePluginManger", 1, "uninstallPlugin " + paramString);
    if (isClosed()) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramString));
      paramString = this.jdField_a_of_type_Avym.d(paramString);
      this.jdField_b_of_type_Avyf.a(paramString, null);
      this.jdField_b_of_type_Avyc.a(paramString, this);
      paramString = avpw.Gc();
    } while (TextUtils.isEmpty(paramString));
    this.jdField_b_of_type_Avxu.aas(paramString);
    return false;
  }
  
  public static class a
  {
    public avxl.a b;
    public avxl.b b;
    public Context context;
  }
  
  class b
    extends avxr.a
  {
    private avyh.a b;
    
    public b(avyh.a parama)
    {
      this.b = parama;
    }
    
    public void a(String paramString, float paramFloat, long paramLong)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "onInstallDownloadProgress." + paramString);
      }
    }
    
    public void onInstallBegin(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "onInstallBegin." + paramString);
      }
    }
    
    public void onInstallError(String paramString, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "onInstallError." + paramString + "," + paramInt);
      }
      avyh.a locala = this.b;
      if ((locala != null) && (locala.jdField_b_of_type_Avxl$a != null))
      {
        paramString = avyh.this.a(paramString);
        if ((paramString != null) && (paramString.mInstalledPath != null)) {
          locala.jdField_b_of_type_Avxl$b.mApkFilePath = paramString.mInstalledPath;
        }
        paramString = locala.jdField_b_of_type_Avxl$a;
        if (paramInt != 2) {
          break label122;
        }
      }
      label122:
      for (boolean bool = true;; bool = false)
      {
        paramString.a(bool, locala.context, locala.jdField_b_of_type_Avxl$b);
        return;
      }
    }
    
    public void onInstallFinish(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
      }
      paramString = this.b;
      if ((paramString != null) && (paramString.jdField_b_of_type_Avxl$a != null))
      {
        PluginRecord localPluginRecord = avyh.a(avyh.this).b(paramString.jdField_b_of_type_Avxl$b.mPluginID);
        if ((localPluginRecord != null) && (localPluginRecord.mInstalledPath != null)) {
          paramString.jdField_b_of_type_Avxl$b.mApkFilePath = localPluginRecord.mInstalledPath;
        }
        paramString.jdField_b_of_type_Avxl$a.a(true, paramString.context, paramString.jdField_b_of_type_Avxl$b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyh
 * JD-Core Version:    0.7.0.1
 */