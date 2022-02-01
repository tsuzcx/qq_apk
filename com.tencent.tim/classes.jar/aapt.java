import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class aapt
  implements View.OnTouchListener
{
  public aapt(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    if (i == 0) {
      this.this$0.ff.setText(null);
    }
    do
    {
      return false;
      if (i == 2)
      {
        if (f < this.this$0.cil * -1)
        {
          this.this$0.bl(false, false);
          return true;
        }
        this.this$0.bl(true, false);
        return true;
      }
      if (i == 3)
      {
        this.this$0.bl(false, true);
        return false;
      }
    } while (i != 1);
    if (f < this.this$0.cil * -1)
    {
      this.this$0.bwV = false;
      this.this$0.bl(false, true);
    }
    for (;;)
    {
      this.this$0.ff.setText(2131693779);
      return false;
      this.this$0.bwV = true;
      this.this$0.bl(true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapt
 * JD-Core Version:    0.7.0.1
 */