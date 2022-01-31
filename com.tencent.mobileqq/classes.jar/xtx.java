import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class xtx
  extends AccessibilityNodeProvider
{
  public xtx(xtv paramxtv) {}
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt == -1)
    {
      localObject1 = localObject2;
      if (xtv.a(this.a) != null)
      {
        localObject1 = AccessibilityNodeInfo.obtain(xtv.a(this.a));
        xtv.a(this.a).onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
        ((AccessibilityNodeInfo)localObject1).setText(xtv.a(this.a).getContentDescription());
      }
    }
    return localObject1;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool = xtv.a(this.a).performAccessibilityAction(paramInt2, paramBundle);
    if (paramInt2 == 128) {
      xtv.a(this.a).post(xtv.a(this.a));
    }
    do
    {
      do
      {
        return bool;
      } while (paramInt2 != 64);
      xtv.a(this.a).removeCallbacks(xtv.a(this.a));
    } while (xtv.a(this.a) == null);
    xtv.a(this.a).a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xtx
 * JD-Core Version:    0.7.0.1
 */