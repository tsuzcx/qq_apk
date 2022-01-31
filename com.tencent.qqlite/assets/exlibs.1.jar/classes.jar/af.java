import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.dataline.activities.LiteActivity;
import com.tencent.qphone.base.util.QLog;

public class af
  implements View.OnTouchListener
{
  public af(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LiteActivity.a, 2, "ontouch--fcc----: " + paramMotionEvent.getAction());
    }
    LiteActivity.a(this.a);
    LiteActivity.a(this.a).postDelayed(new ag(this), 200L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     af
 * JD-Core Version:    0.7.0.1
 */