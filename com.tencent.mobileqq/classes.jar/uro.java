import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;

public class uro
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  public uro(ArkAppItemBubbleBuilder.Holder paramHolder1, ArkAppItemBubbleBuilder.Holder paramHolder2) {}
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.a != null))
    {
      ArkAppCenter.a(paramAppPathInfo.a, new urp(this));
      paramString = ArkAppCenter.b(paramAppPathInfo.a);
      ArkAppCenter.a().postToMainThread(new urq(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uro
 * JD-Core Version:    0.7.0.1
 */