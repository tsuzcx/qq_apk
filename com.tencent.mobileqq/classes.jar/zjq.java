import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class zjq
  extends AccessibilityNodeProvider
{
  public zjq(zjo paramzjo) {}
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt == -1)
    {
      localObject1 = localObject2;
      if (zjo.a(this.a) != null)
      {
        localObject1 = AccessibilityNodeInfo.obtain(zjo.a(this.a));
        zjo.a(this.a).onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
        ((AccessibilityNodeInfo)localObject1).setText(zjo.a(this.a).getContentDescription());
      }
    }
    return localObject1;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool = zjo.a(this.a).performAccessibilityAction(paramInt2, paramBundle);
    if (paramInt2 == 128) {
      zjo.a(this.a).post(zjo.a(this.a));
    }
    do
    {
      do
      {
        return bool;
      } while (paramInt2 != 64);
      zjo.a(this.a).removeCallbacks(zjo.a(this.a));
    } while (zjo.a(this.a) == null);
    zjo.a(this.a).a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjq
 * JD-Core Version:    0.7.0.1
 */