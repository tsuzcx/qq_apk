import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.dataline.activities.LiteActivity;
import com.tencent.qphone.base.util.QLog;

public class av
  implements View.OnTouchListener
{
  public av(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LiteActivity.a, 2, "ontouch--fcc----: " + paramMotionEvent.getAction());
    }
    if ((LiteActivity.a(this.a) != null) && (LiteActivity.a(this.a).getVisibility() == 0))
    {
      LiteActivity.a(this.a).setVisibility(8);
      LiteActivity.a(this.a).requestFocus();
    }
    LiteActivity.a(this.a).setImageResource(2130837644);
    LiteActivity.a(this.a);
    LiteActivity.a(this.a).postDelayed(new aw(this), 200L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     av
 * JD-Core Version:    0.7.0.1
 */