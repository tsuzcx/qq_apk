import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class atdq
  implements View.OnTouchListener
{
  atdq(atdp paramatdp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getTag() instanceof View))
    {
      paramView = (View)paramView.getTag();
      if (paramMotionEvent.getAction() != 0) {
        break label32;
      }
      paramView.setPressed(true);
    }
    label32:
    while (1 != paramMotionEvent.getAction()) {
      return false;
    }
    paramView.setPressed(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdq
 * JD-Core Version:    0.7.0.1
 */