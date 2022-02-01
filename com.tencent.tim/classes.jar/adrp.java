import android.content.Context;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;

class adrp
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  adrp(adrm paramadrm, String paramString, Context paramContext) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.path != null)) {
      ArkAppCacheMgr.getAppIcon(this.val$appName, new adrq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrp
 * JD-Core Version:    0.7.0.1
 */