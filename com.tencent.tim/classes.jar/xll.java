import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class xll
  implements View.OnTouchListener
{
  xll(xlk paramxlk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      xlk.a(this.a).to.setVisibility(0);
      xlk.a(this.a).c.setPressed(true);
      return true;
    case 3: 
      xlk.a(this.a).to.setVisibility(4);
      xlk.a(this.a).c.setPressed(false);
      return true;
    }
    xlk.a(this.a).to.setVisibility(4);
    xlk.a(this.a).c.setPressed(false);
    paramView.performClick();
    xlk.a(this.a, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xll
 * JD-Core Version:    0.7.0.1
 */