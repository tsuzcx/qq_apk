import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.mobileqq.redtouch.RedTouch;

public class alto
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public alto(RedTouch paramRedTouch, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.Q.Dd.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    RedTouch.b(this.Q, this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alto
 * JD-Core Version:    0.7.0.1
 */