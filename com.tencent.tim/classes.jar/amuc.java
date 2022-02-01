import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterEvent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class amuc
  implements amud.a, ark.ApplicationCallback
{
  private ArrayList<WeakReference<amuk>> zC = new ArrayList();
  
  private amuk a(long paramLong)
  {
    ark.Container localContainer = ark.arkGetContainer(paramLong);
    amuk localamuk;
    if (localContainer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkNodeContainer", 2, "getArkNode, arkcontainer is null");
      }
      localamuk = null;
    }
    label150:
    label154:
    for (;;)
    {
      return localamuk;
      if (this.zC.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkNodeContainer", 2, "getArkNode, list is null");
        }
        return null;
      }
      int i = 0;
      if (i < this.zC.size())
      {
        localamuk = (amuk)((WeakReference)this.zC.get(i)).get();
        if ((localamuk == null) || (!(localamuk instanceof amui))) {
          break label150;
        }
      }
      for (amuf localamuf = ((amui)localamuk).a();; localamuf = null)
      {
        if ((localamuf != null) && (localamuf.getContainer() == localContainer)) {
          break label154;
        }
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ArkNodeContainer", 2, "getArkNode, not found");
        }
        return null;
      }
    }
  }
  
  public void AppCreate(ark.Application paramApplication)
  {
    ArkAppCenterEvent.a(0, paramApplication.GetSpecific("appName"), null);
  }
  
  public void AppDestroy(ark.Application paramApplication)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ArkAppCenterEvent.a(1, paramApplication, null);
    adtn.GV(paramApplication);
  }
  
  public boolean CheckUrlLegalityCallback(ark.Application paramApplication, String paramString)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ArkAppUrlChecker localArkAppUrlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(paramApplication);
    boolean bool;
    int i;
    if (localArkAppUrlChecker != null)
    {
      int j = localArkAppUrlChecker.checkUrlIsValidByAppResouceList(paramString);
      if (j == 0)
      {
        bool = true;
        if (bool) {
          break label170;
        }
        if (ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramApplication)) {
          break label165;
        }
        QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.EngineCallback seach appName=", paramApplication, ",url=", jqo.filterKeyForLog(paramString, new String[0]), ", isValid set=true" });
        i = 2;
        bool = true;
        label97:
        adtn.d(paramApplication, paramString, j, i, "");
      }
    }
    for (;;)
    {
      QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.EngineCallback search appName=", paramApplication, ",url=", jqo.filterKeyForLog(paramString, new String[0]), ", isValid=", Boolean.valueOf(bool) });
      return bool;
      bool = false;
      break;
      label165:
      i = 1;
      break label97;
      label170:
      i = 0;
      break label97;
      bool = true;
    }
  }
  
  public void OutputScriptError(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkNodeContainer", 2, String.format("%s.script error: %s", new Object[] { paramString1, paramString2 }));
        }
        adqu.a(null, paramString1, "ScriptError", 0, 0, 0L, 0L, 0L, paramString2, "");
        return;
      }
    }
  }
  
  public void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    adnq.RegisterModules(paramModuleRegister, paramApplication);
    String str = paramApplication.GetSpecific("appName");
    amud localamud = new amud(paramApplication, adnq.ai(str));
    localamud.a(this);
    paramApplication = adnq.getAppInterface();
    if ((!TextUtils.isEmpty(str)) && (paramApplication != null))
    {
      paramApplication = (ArkAppCenter)paramApplication.getManager(121);
      if (paramApplication == null) {}
    }
    for (paramApplication = paramApplication.a();; paramApplication = null)
    {
      if (paramApplication != null) {
        localamud.jB((List)adph.jJ.get(localamud.GetTypeName()));
      }
      paramModuleRegister.RegCallbackWrapper(localamud);
      return;
    }
  }
  
  public void a(amui paramamui)
  {
    if (paramamui == null) {
      return;
    }
    Iterator localIterator = this.zC.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramamui) {
        return;
      }
    }
    this.zC.add(new WeakReference(paramamui));
  }
  
  public void aG(long paramLong, String paramString)
  {
    amuk localamuk = a(paramLong);
    if ((localamuk != null) && ((localamuk instanceof amui))) {
      ((amui)localamuk).PW(paramString);
    }
  }
  
  public void b(amui paramamui)
  {
    if (paramamui == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.zC.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (localWeakReference.get() != paramamui);
    this.zC.remove(localWeakReference);
  }
  
  public void t(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkNodeContainer", 2, "onNotify, KEY：" + paramString1 + " VALUE:" + paramString2);
    }
    amuk localamuk = a(paramLong);
    if ((localamuk != null) && ((localamuk instanceof amui))) {
      ((amui)localamuk).hn(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amuc
 * JD-Core Version:    0.7.0.1
 */