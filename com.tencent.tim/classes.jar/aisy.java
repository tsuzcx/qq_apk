import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class aisy
  implements View.OnHoverListener
{
  public aisy(LocationPickFragment paramLocationPickFragment) {}
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (AccessibilityManager)this.this$0.getActivity().getSystemService("accessibility");
    if ((paramMotionEvent != null) && (paramMotionEvent.isTouchExplorationEnabled()))
    {
      if (paramView.requestFocus()) {
        ((InputMethodManager)this.this$0.getActivity().getSystemService("input_method")).showSoftInput(paramView, 1);
      }
      if (!LocationPickFragment.a(this.this$0).aQZ())
      {
        LocationPickFragment.a(this.this$0).setDisplayFromType(3);
        LocationPickFragment.a(this.this$0).displayPanel();
      }
      anot.a(null, "CliOper", "", "", "0X800A95E", "0X800A95E", 0, 0, "", "0", "0", "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisy
 * JD-Core Version:    0.7.0.1
 */