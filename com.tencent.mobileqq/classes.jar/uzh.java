import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg;
import com.tencent.mobileqq.ark.ArkAppCenterEvent;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.qphone.base.util.QLog;

public final class uzh
  implements ark.ApplicationCallback
{
  public void AppCreate(String paramString, ark.Application paramApplication)
  {
    ArkAppCenterEvent.a(0, paramString, null);
  }
  
  public void AppDestroy(String paramString, ark.Application paramApplication)
  {
    ArkAppCenterEvent.a(1, paramString, null);
  }
  
  public void OutputScriptError(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAppContainer", 1, String.format("%s.script error: %s", new Object[] { str, paramString1 }));
    }
    ArkAppDataReport.c(null, str, paramString1);
  }
  
  public void RegisterModules(ark.ModuleRegister paramModuleRegister, String paramString)
  {
    ArkAppModuleReg.a(paramModuleRegister, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uzh
 * JD-Core Version:    0.7.0.1
 */