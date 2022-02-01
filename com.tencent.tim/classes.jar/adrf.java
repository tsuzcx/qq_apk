import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.2.2;

public class adrf
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  adrf(adrd paramadrd, String paramString, adrd.a parama) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.path != null))
    {
      ArkAppCacheMgr.getAppIcon(this.val$appName, new adrg(this));
      paramString = ArkAppCacheMgr.getApplicationDesc(this.val$appName);
      ArkAppCenter.a().postToMainThread(new ArkHorizontalListViewAdapter.2.2(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrf
 * JD-Core Version:    0.7.0.1
 */