import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

class vkc
  implements BusinessObserver
{
  vkc(vkb paramvkb, WeakReference paramWeakReference) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      paramObject = (String)paramObject;
      ArkAppCenter.a().post(new vkd(this, paramInt, i, paramObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkc
 * JD-Core Version:    0.7.0.1
 */