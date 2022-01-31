import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.QQSettingMe;

public class tld
  implements View.OnTouchListener
{
  public tld(QQSettingMe paramQQSettingMe) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.a.setAlpha(0.5F);
      this.a.a.invalidate();
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.a.a.setAlpha(1.0F);
        this.a.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tld
 * JD-Core Version:    0.7.0.1
 */