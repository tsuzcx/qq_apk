import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.qphone.base.util.QLog;

public class ac
  implements View.OnTouchListener
{
  public ac(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LiteActivity.a, 2, "ontouch--fcc----: " + paramMotionEvent.getAction());
    }
    if ((LiteActivity.a(this.a) != null) && (LiteActivity.a(this.a).getVisibility() == 0))
    {
      LiteActivity.a(this.a).setVisibility(8);
      if ((LiteActivity.a(this.a) != null) && (LiteActivity.a(this.a).getVisibility() == 0)) {
        LiteActivity.a(this.a, false);
      }
      LiteActivity.a(this.a).requestFocus();
    }
    LiteActivity.a(this.a).setImageResource(2130837545);
    LiteActivity.a(this.a);
    LiteActivity.a(this.a).postDelayed(new ad(this), 200L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ac
 * JD-Core Version:    0.7.0.1
 */