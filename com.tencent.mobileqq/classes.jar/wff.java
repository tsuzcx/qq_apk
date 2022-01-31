import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class wff
  extends AccessibilityNodeProvider
{
  public wff(wfd paramwfd) {}
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt == -1)
    {
      localObject1 = localObject2;
      if (wfd.a(this.a) != null)
      {
        localObject1 = AccessibilityNodeInfo.obtain(wfd.a(this.a));
        wfd.a(this.a).onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
        ((AccessibilityNodeInfo)localObject1).setText(wfd.a(this.a).getContentDescription());
      }
    }
    return localObject1;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool = wfd.a(this.a).performAccessibilityAction(paramInt2, paramBundle);
    if (paramInt2 == 128) {
      wfd.a(this.a).post(wfd.a(this.a));
    }
    do
    {
      do
      {
        return bool;
      } while (paramInt2 != 64);
      wfd.a(this.a).removeCallbacks(wfd.a(this.a));
    } while (wfd.a(this.a) == null);
    wfd.a(this.a).a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wff
 * JD-Core Version:    0.7.0.1
 */