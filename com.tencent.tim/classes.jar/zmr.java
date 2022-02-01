import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class zmr
  implements View.OnTouchListener
{
  zmr(zmq paramzmq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    zmq.a(this.a, paramView);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmr
 * JD-Core Version:    0.7.0.1
 */