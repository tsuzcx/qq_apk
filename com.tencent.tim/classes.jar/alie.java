import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class alie
  implements DeviceProfileManager.a, Manager
{
  private QQAppInterface mApp;
  
  public alie(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    String str = DeviceProfileManager.a(paramQQAppInterface).aJ(DeviceProfileManager.DpcNames.SilkCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      aqlv.bj(paramQQAppInterface, str);
      aqlv.ae(paramQQAppInterface, true);
      str = DeviceProfileManager.a(paramQQAppInterface).aJ(DeviceProfileManager.DpcNames.StreamCfg.name(), "null");
      if ("null".equalsIgnoreCase(str)) {
        break label161;
      }
      alil.ax(paramQQAppInterface, str);
      alil.N(paramQQAppInterface, true);
    }
    for (;;)
    {
      paramQQAppInterface = DeviceProfileManager.a(paramQQAppInterface).aJ(DeviceProfileManager.DpcNames.aio_config.name(), "").split("\\|");
      if (paramQQAppInterface.length > 13)
      {
        boolean bool = "1".equals(paramQQAppInterface[12]);
        SyncService.B(BaseApplicationImpl.sApplication, bool);
        if (paramQQAppInterface.length > 14)
        {
          bool = "1".equals(paramQQAppInterface[13]);
          anog.G(BaseApplicationImpl.sApplication, bool);
        }
      }
      DeviceProfileManager.a(this);
      return;
      aqlv.ae(paramQQAppInterface, false);
      break;
      label161:
      alil.N(paramQQAppInterface, false);
    }
  }
  
  public void Og(String paramString)
  {
    QQAppInterface localQQAppInterface = this.mApp;
    aomi.a();
    if (localQQAppInterface != null)
    {
      alil.ay(localQQAppInterface, paramString);
      alil.O(localQQAppInterface, true);
    }
  }
  
  public void Oh(String paramString)
  {
    QQAppInterface localQQAppInterface = this.mApp;
    if (localQQAppInterface != null)
    {
      alig.aw(localQQAppInterface, paramString);
      alig.M(localQQAppInterface, true);
    }
  }
  
  public void Oi(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    aomi.a();
    QQAppInterface localQQAppInterface = this.mApp;
    if (localQQAppInterface != null)
    {
      aliq.az(localQQAppInterface, paramString);
      aliq.P(localQQAppInterface, true);
    }
  }
  
  public void onDestroy()
  {
    aliq.release();
    DeviceProfileManager.b(this);
    aqlv.release();
    alil.release();
  }
  
  public void sr(boolean paramBoolean)
  {
    Object localObject = this.mApp;
    if ((localObject != null) && (paramBoolean))
    {
      aqlv.bj((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).aJ(DeviceProfileManager.DpcNames.SilkCfg.name(), ""));
      aqlv.ae((QQAppInterface)localObject, true);
      alil.ax((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).aJ(DeviceProfileManager.DpcNames.StreamCfg.name(), ""));
      alil.N((QQAppInterface)localObject, true);
      localObject = DeviceProfileManager.a((AppRuntime)localObject).aJ(DeviceProfileManager.DpcNames.aio_config.name(), "").split("\\|");
      if (localObject.length > 13)
      {
        paramBoolean = "1".equals(localObject[12]);
        SyncService.B(BaseApplicationImpl.sApplication, paramBoolean);
        if (localObject.length > 14)
        {
          paramBoolean = "1".equals(localObject[13]);
          anog.G(BaseApplicationImpl.sApplication, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alie
 * JD-Core Version:    0.7.0.1
 */