import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.dataline.activities.LiteActivity;

public class bj
  implements View.OnTouchListener
{
  public bj(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a.findViewById(2131231207).setBackgroundResource(2130840096);
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        this.a.findViewById(2131231207).setBackgroundResource(2130840095);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bj
 * JD-Core Version:    0.7.0.1
 */