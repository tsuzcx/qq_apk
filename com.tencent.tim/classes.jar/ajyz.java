import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class ajyz
  implements View.OnTouchListener
{
  public ajyz(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (!ShortVideoCommentsView.a(this.this$0)) {}
      this.this$0.bhj();
      ShortVideoCommentsView.b(this.this$0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajyz
 * JD-Core Version:    0.7.0.1
 */