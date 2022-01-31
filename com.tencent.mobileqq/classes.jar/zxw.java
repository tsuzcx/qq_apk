import android.os.Handler;
import android.os.RemoteCallbackList;
import com.tencent.biz.qrcode.ipc.QrMainProcManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArResourceDownload;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.mobileqq.ar.aidl.IArFaceCallback;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class zxw
  extends IArConfigManager.Stub
{
  WeakReference a;
  
  public zxw(ArConfigService paramArConfigService)
  {
    QLog.d("ArConfig_ArConfigService", 1, "ArConfigManagerStub constructor");
    this.a = new WeakReference(paramArConfigService);
  }
  
  public ARCommonConfigInfo a()
  {
    if (this.a != null) {}
    for (Object localObject = (ArConfigService)this.a.get();; localObject = null)
    {
      if (localObject == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "getARCommonConfigInfo error arConfigService is null");
        return null;
      }
      if (((ArConfigService)localObject).jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager != null) {}
      for (localObject = ((ArConfigService)localObject).jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager.a();; localObject = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", new Object[] { localObject }));
        }
        return localObject;
      }
    }
  }
  
  public ArConfigInfo a()
  {
    if (this.a != null) {}
    for (Object localObject = (ArConfigService)this.a.get();; localObject = null)
    {
      if (localObject == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "getArConfigInfo error arConfigService is null");
        return null;
      }
      if (((ArConfigService)localObject).jdField_a_of_type_ComTencentMobileqqArArResourceManager != null) {}
      for (localObject = ((ArConfigService)localObject).jdField_a_of_type_ComTencentMobileqqArArResourceManager.a();; localObject = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "getArConfigInfo | mConfigInfo = " + localObject);
        }
        return localObject;
      }
    }
  }
  
  public ArEffectConfig a()
  {
    if (this.a != null) {}
    for (Object localObject = (ArConfigService)this.a.get();; localObject = null)
    {
      if (localObject == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error arConfigService is null");
        return null;
      }
      if (((ArConfigService)localObject).jdField_a_of_type_ComTencentMobileqqArArResourceManager != null) {}
      for (localObject = ((ArConfigService)localObject).jdField_a_of_type_ComTencentMobileqqArArResourceManager.a();; localObject = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "getArEffectConfig|mEffectConfig=" + localObject);
        }
        return localObject;
      }
    }
  }
  
  public void a()
  {
    if (this.a != null) {}
    for (ArConfigService localArConfigService = (ArConfigService)this.a.get();; localArConfigService = null)
    {
      if (localArConfigService == null) {
        QLog.d("ArConfig_ArConfigService", 1, "downloadResource error arConfigService is null");
      }
      while (localArConfigService.jdField_a_of_type_ComTencentMobileqqArArResourceManager == null) {
        return;
      }
      localArConfigService.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(false, false);
      HashMap localHashMap = new HashMap();
      localHashMap.put("click_download", "1");
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(localArConfigService.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ar_client_download_times", true, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadFaceResource error arConfigService is null");
    }
    while (!(ArConfigService.a(localArConfigService) instanceof QQAppInterface)) {
      return;
    }
    FaceScanDownloadManager.a(paramInt, (QQAppInterface)ArConfigService.b(localArConfigService));
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "handleNewConfig error arConfigService is null");
    }
    while (localArConfigService.jdField_a_of_type_ComTencentMobileqqArArResourceManager == null) {
      return;
    }
    localArConfigService.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(paramArConfigInfo);
  }
  
  public void a(IArFaceCallback paramIArFaceCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerFaceCallback error arConfigService is null");
    }
    while ((paramIArFaceCallback == null) || (ArConfigService.b(localArConfigService) == null)) {
      return;
    }
    ArConfigService.b(localArConfigService).register(paramIArFaceCallback);
  }
  
  public void a(IArRemoteCallback paramIArRemoteCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerArCallback error arConfigService is null");
    }
    while ((paramIArRemoteCallback == null) || (ArConfigService.a(localArConfigService) == null)) {
      return;
    }
    ArConfigService.a(localArConfigService).register(paramIArRemoteCallback);
  }
  
  public void a(IArSoCallback paramIArSoCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "registerArSoCallback error arConfigService is null");
    }
    while (paramIArSoCallback == null) {
      return;
    }
    ArConfigService.c(localArConfigService).register(paramIArSoCallback);
  }
  
  public boolean a()
  {
    if (this.a != null) {}
    for (ArConfigService localArConfigService = (ArConfigService)this.a.get();; localArConfigService = null)
    {
      if (localArConfigService == null)
      {
        QLog.d("ArConfig_ArConfigService", 1, "isFaceResConfigReady error arConfigService is null");
        return false;
      }
      if ((ArConfigService.c(localArConfigService) instanceof QQAppInterface))
      {
        boolean bool = FaceScanDownloadManager.a((QQAppInterface)ArConfigService.d(localArConfigService));
        if (!bool) {
          FaceScanDownloadManager.a((QQAppInterface)ArConfigService.e(localArConfigService));
        }
        return bool;
      }
      return false;
    }
  }
  
  public void b()
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "cancelDownload error arConfigService is null");
    }
    while (localArConfigService.jdField_a_of_type_ComTencentMobileqqArArResourceManager == null) {
      return;
    }
    localArConfigService.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a.a();
  }
  
  public void b(int paramInt)
  {
    Object localObject = null;
    if (this.a != null) {
      localObject = (ArConfigService)this.a.get();
    }
    if (localObject == null) {
      QLog.d("ArConfig_ArConfigService", 1, "onToolScannerActivityStateChanged error arConfigService is null");
    }
    do
    {
      return;
      localObject = (QrMainProcManager)ArConfigService.f((ArConfigService)localObject).getManager(242);
    } while (localObject == null);
    ((QrMainProcManager)localObject).a(paramInt);
  }
  
  public void b(IArFaceCallback paramIArFaceCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterFaceCallback error arConfigService is null");
    }
    while ((paramIArFaceCallback == null) || (ArConfigService.b(localArConfigService) == null)) {
      return;
    }
    ArConfigService.b(localArConfigService).unregister(paramIArFaceCallback);
  }
  
  public void b(IArRemoteCallback paramIArRemoteCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback error arConfigService is null");
    }
    while ((paramIArRemoteCallback == null) || (ArConfigService.a(localArConfigService) == null)) {
      return;
    }
    ArConfigService.a(localArConfigService).unregister(paramIArRemoteCallback);
  }
  
  public void b(IArSoCallback paramIArSoCallback)
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "unregisterArSoCallback error arConfigService is null");
    }
    while (paramIArSoCallback == null) {
      return;
    }
    ArConfigService.c(localArConfigService).unregister(paramIArSoCallback);
  }
  
  public boolean b()
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "isArSoReady error arConfigService is null");
      return false;
    }
    if ((ArConfigService.a(localArConfigService)) && (ArConfigService.b(localArConfigService)) && (ArConfigService.c(localArConfigService))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void c()
  {
    ArConfigService localArConfigService = null;
    if (this.a != null) {
      localArConfigService = (ArConfigService)this.a.get();
    }
    if (localArConfigService == null) {
      QLog.d("ArConfig_ArConfigService", 1, "downloadArSo error arConfigService is null");
    }
    do
    {
      return;
      ArConfigService.a(localArConfigService, false);
      ArConfigService.a(localArConfigService);
      ArConfigService.b(localArConfigService);
      ArConfigService.c(localArConfigService);
    } while (ArConfigService.d(localArConfigService));
    int i = (ArConfigService.a(localArConfigService) + ArConfigService.b(localArConfigService) + ArConfigService.c(localArConfigService)) / 3;
    ArConfigService.a(localArConfigService).post(new zxx(this, localArConfigService, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxw
 * JD-Core Version:    0.7.0.1
 */