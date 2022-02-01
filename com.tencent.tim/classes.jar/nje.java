import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;

public class nje
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public nje(SlideActiveAnimController paramSlideActiveAnimController, Runnable paramRunnable) {}
  
  public void onGlobalLayout()
  {
    this.this$0.aXY();
    if (this.cV != null) {
      this.cV.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nje
 * JD-Core Version:    0.7.0.1
 */