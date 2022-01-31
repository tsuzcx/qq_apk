import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class bbx
  implements View.OnTouchListener
{
  public bbx(QQBrowserActivity paramQQBrowserActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QQBrowserActivity.a(this.a).setVisibility(8);
    QQBrowserActivity.b(this.a).setVisibility(8);
    this.a.b.setVisibility(8);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bbx
 * JD-Core Version:    0.7.0.1
 */