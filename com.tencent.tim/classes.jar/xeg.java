import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.mobileqq.activity.aio.item.IPCSSODataRequest.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

public class xeg
  extends IArkDelegateNetCallback
{
  xeg(xef paramxef, WeakReference paramWeakReference) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      paramObject = (String)paramObject;
      ArkAppCenter.a().post(this.a.aUD, new IPCSSODataRequest.1.1(this, paramInt, i, paramObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xeg
 * JD-Core Version:    0.7.0.1
 */