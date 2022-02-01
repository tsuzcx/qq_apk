import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class awnq
  implements View.OnTouchListener
{
  awnq(awnm paramawnm) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.aiK();
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.aiK();
      return true;
    }
    return paramView.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnq
 * JD-Core Version:    0.7.0.1
 */