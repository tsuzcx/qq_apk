import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;

public class aiou
  implements View.OnTouchListener
{
  float qN = 0.0F;
  
  public aiou(ListenTogetherPlayFragment paramListenTogetherPlayFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.qN = paramView.getAlpha();
      paramView.setAlpha(this.qN * 0.5F);
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setAlpha(this.qN);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiou
 * JD-Core Version:    0.7.0.1
 */