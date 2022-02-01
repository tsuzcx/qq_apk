import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.1;

@SuppressLint({"NewApi"})
public class rts
  extends View.AccessibilityDelegate
{
  private rts.a a;
  private Runnable dx = new CustomAccessibilityDelegate.1(this);
  private View mView;
  
  public rts(View paramView, rts.a parama)
  {
    this.mView = paramView;
    this.a = parama;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return new rts.b();
  }
  
  public static abstract interface a
  {
    public abstract void bwu();
    
    public abstract void bwv();
  }
  
  public class b
    extends AccessibilityNodeProvider
  {
    public b() {}
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramInt == -1)
      {
        localObject1 = localObject2;
        if (rts.a(rts.this) != null)
        {
          localObject1 = AccessibilityNodeInfo.obtain(rts.a(rts.this));
          rts.a(rts.this).onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
          ((AccessibilityNodeInfo)localObject1).setText(rts.a(rts.this).getContentDescription());
        }
      }
      return localObject1;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      boolean bool = rts.a(rts.this).performAccessibilityAction(paramInt2, paramBundle);
      if (paramInt2 == 128) {
        rts.a(rts.this).post(rts.a(rts.this));
      }
      do
      {
        do
        {
          return bool;
        } while (paramInt2 != 64);
        rts.a(rts.this).removeCallbacks(rts.a(rts.this));
      } while (rts.a(rts.this) == null);
      rts.a(rts.this).bwu();
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rts
 * JD-Core Version:    0.7.0.1
 */