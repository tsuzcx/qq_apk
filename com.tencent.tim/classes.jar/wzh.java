import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder.2.2;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class wzh
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  wzh(wzb.a parama1, String paramString, wzb.a parama2) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.path != null))
    {
      ArkAppCacheMgr.getAppIcon(this.val$appName, new wzi(this));
      paramString = ArkAppCacheMgr.getApplicationDesc(this.val$appName);
      ArkAppCenter.a().postToMainThread(new ArkAppItemBubbleBuilder.Holder.2.2(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzh
 * JD-Core Version:    0.7.0.1
 */