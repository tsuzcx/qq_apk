import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.olympic.activity.PromotionEntry;

public class akqq
  implements View.OnTouchListener
{
  public akqq(PromotionEntry paramPromotionEntry) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (PromotionEntry.a(this.b) == null) {}
    do
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        PromotionEntry.a(this.b).setAlpha(255);
        return false;
      }
    } while (paramMotionEvent.getAction() != 0);
    PromotionEntry.a(this.b).setAlpha(100);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqq
 * JD-Core Version:    0.7.0.1
 */