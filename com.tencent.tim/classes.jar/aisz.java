import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class aisz
  implements View.OnTouchListener
{
  public aisz(LocationPickFragment paramLocationPickFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (1 == paramMotionEvent.getAction())
    {
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
 * Qualified Name:     aisz
 * JD-Core Version:    0.7.0.1
 */