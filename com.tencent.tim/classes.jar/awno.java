import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class awno
  implements View.OnTouchListener
{
  awno(awnm paramawnm) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awno
 * JD-Core Version:    0.7.0.1
 */