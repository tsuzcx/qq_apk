import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class xlk
  implements View.OnTouchListener
{
  public xlk(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    if (i == 0) {
      this.a.b.setText(null);
    }
    do
    {
      return false;
      if (i == 2)
      {
        if (f < this.a.a * -1)
        {
          this.a.a(false, false);
          return true;
        }
        this.a.a(true, false);
        return true;
      }
      if (i == 3)
      {
        this.a.a(false, true);
        return false;
      }
    } while (i != 1);
    if (f < this.a.a * -1)
    {
      this.a.l = false;
      this.a.a(false, true);
    }
    for (;;)
    {
      this.a.b.setText(2131438145);
      return false;
      this.a.l = true;
      this.a.a(true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlk
 * JD-Core Version:    0.7.0.1
 */