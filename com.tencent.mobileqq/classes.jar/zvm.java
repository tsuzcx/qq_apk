import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class zvm
  extends AccessibilityNodeProvider
{
  public zvm(zvk paramzvk) {}
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt == -1)
    {
      localObject1 = localObject2;
      if (zvk.a(this.a) != null)
      {
        localObject1 = AccessibilityNodeInfo.obtain(zvk.a(this.a));
        zvk.a(this.a).onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
        ((AccessibilityNodeInfo)localObject1).setText(zvk.a(this.a).getContentDescription());
      }
    }
    return localObject1;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool = zvk.a(this.a).performAccessibilityAction(paramInt2, paramBundle);
    if (paramInt2 == 128) {
      zvk.a(this.a).post(zvk.a(this.a));
    }
    do
    {
      do
      {
        return bool;
      } while (paramInt2 != 64);
      zvk.a(this.a).removeCallbacks(zvk.a(this.a));
    } while (zvk.a(this.a) == null);
    zvk.a(this.a).a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvm
 * JD-Core Version:    0.7.0.1
 */