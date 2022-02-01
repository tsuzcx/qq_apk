import android.os.Bundle;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

final class adtg
  extends IArkDelegateNet
{
  public void download(String paramString, boolean paramBoolean1, boolean paramBoolean2, HashMap<String, String> paramHashMap, File paramFile, IArkDelegateNetCallback paramIArkDelegateNetCallback)
  {
    QLog.d("ArkApp.ArkMultiProcUtil", 1, new Object[] { "ArkMultiProc.download url=", paramString });
    String str;
    if (paramHashMap != null)
    {
      str = (String)paramHashMap.get("Cookie");
      if (paramHashMap == null) {
        break label161;
      }
      paramHashMap = (String)paramHashMap.get("Referer");
      label53:
      if (paramFile == null) {
        break label168;
      }
    }
    label161:
    label168:
    for (paramFile = paramFile.getAbsolutePath();; paramFile = "")
    {
      if (1 == BaseApplicationImpl.sProcessId) {
        break label175;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", paramString);
      ((Bundle)localObject).putBoolean("supportGzip", paramBoolean1);
      ((Bundle)localObject).putBoolean("supportRedirect", paramBoolean2);
      ((Bundle)localObject).putString("Cookie", str);
      ((Bundle)localObject).putString("Referer", paramHashMap);
      ((Bundle)localObject).putString("file", paramFile);
      adst.a().a("callDownload", (Bundle)localObject, new adtj(this, paramString, paramIArkDelegateNetCallback));
      return;
      str = "";
      break;
      paramHashMap = "";
      break label53;
    }
    label175:
    Object localObject = ((aqva)BaseApplicationImpl.getApplication().getRuntime().getManager(47)).a(1);
    paramFile = new aquz(paramString, new File(paramFile));
    paramFile.cWw = paramBoolean1;
    paramFile.cWy = paramBoolean2;
    if (str != null) {
      paramFile.addHeader("Cookie", str);
    }
    if (paramHashMap != null) {
      paramFile.addHeader("Referer", paramHashMap);
    }
    paramHashMap = new Bundle();
    ((aqvc)localObject).a(paramFile, new adtk(this, paramString, paramIArkDelegateNetCallback), paramHashMap);
  }
  
  public int getNetworkType()
  {
    return aqiw.getNetworkType(BaseApplication.getContext());
  }
  
  public boolean isNetworkAvailable()
  {
    return aqiw.isNetworkAvailable(null);
  }
  
  public void sendAppMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, IArkDelegateNetCallback paramIArkDelegateNetCallback)
  {
    QLog.d("ArkApp.ArkMultiProcUtil", 1, new Object[] { "ArkMultiProc.sendAppMsg cmd=", paramString1, ", msg=", paramString2 });
    if (1 != BaseApplicationImpl.sProcessId)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("cmd", paramString1);
      ((Bundle)localObject).putString("msg", paramString2);
      ((Bundle)localObject).putInt("timeOut", paramInt1);
      ((Bundle)localObject).putInt("notifyType", paramInt2);
      adst.a().a("callSendAppMsg", (Bundle)localObject, new adth(this, paramString1, paramString2, paramIArkDelegateNetCallback, paramInt2));
      return;
    }
    Object localObject = (ArkAppCenter)BaseApplicationImpl.getApplication().getRuntime().getManager(121);
    if (localObject == null)
    {
      QLog.e("ArkApp.ArkMultiProcUtil", 1, "ArkMultiProc.callSendAppMsg  appCenter is null");
      return;
    }
    localObject = ((ArkAppCenter)localObject).a();
    if (localObject == null)
    {
      QLog.e("ArkApp.ArkMultiProcUtil", 1, "ArkMultiProc.callSendAppMsg  sso is null");
      return;
    }
    QLog.d("ArkApp.ArkMultiProcUtil", 1, new Object[] { "ArkMultiProc.callSendAppMsg cmd=", paramString1, ", msg=", paramString2 });
    ((adrc)localObject).a(paramString1, paramString2, paramInt1, paramInt2, new adti(this, paramIArkDelegateNetCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtg
 * JD-Core Version:    0.7.0.1
 */