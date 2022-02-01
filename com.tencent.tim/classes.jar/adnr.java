import com.tencent.ark.ark.Application;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallbackTimeOut;
import com.tencent.mobileqq.ark.ArkAppCenter;

final class adnr
  implements ArkAppMgr.IGetAppPathByNameCallbackTimeOut
{
  adnr(String paramString1, String paramString2, adnq.a parama) {}
  
  public void onGetAppPathByNameTimeout(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo != null) && (paramAppPathInfo.path != null))
    {
      paramString = ark.Application.Create(this.val$appName, paramAppPathInfo.path);
      if (paramString != null)
      {
        boolean bool = paramString.CheckShareUrlLegality(this.buI);
        paramString.Release();
        if (bool)
        {
          this.a.GC(true);
          ArkAppCenter.r("ArkApp", String.format("CheckShareUrlLegality, url is in whileList, appName=%s and url=%s", new Object[] { this.val$appName, this.buI }));
        }
      }
      else
      {
        return;
      }
      this.a.GC(false);
      ArkAppCenter.r("ArkApp", String.format("CheckShareUrlLegality, url is not in whileList, appName=%s and url=%s", new Object[] { this.val$appName, this.buI }));
      return;
    }
    this.a.GC(false);
    adqu.a(adnq.getAppInterface(), this.val$appName, "ArkCheckShareUrlLegality", paramInt, 0, 0L, 0L, 0L, "", "");
    ArkAppCenter.r("ArkApp", String.format("CheckShareUrlLegality,getAppInfo is failed and msg=%s", new Object[] { paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnr
 * JD-Core Version:    0.7.0.1
 */