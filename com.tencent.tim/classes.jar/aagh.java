import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class aagh
  implements View.OnTouchListener
{
  private float rm = 1.0F;
  
  aagh(float paramFloat) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.rm = paramView.getAlpha();
      paramView.setAlpha(this.val$alpha);
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        paramView.setAlpha(this.rm);
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = (int)paramMotionEvent.getRawY();
        if (!aagd.isOnView(paramView, i, j)) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagh
 * JD-Core Version:    0.7.0.1
 */