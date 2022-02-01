import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.widget.IphoneTreeView;

public class argd
  implements View.OnTouchListener
{
  public argd(IphoneTreeView paramIphoneTreeView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      bool = false;
    }
    do
    {
      return bool;
      paramView.setPressed(true);
      this.a.invalidate();
      return true;
      paramView.setPressed(false);
      this.a.invalidate();
      break;
    } while (!paramView.isPressed());
    paramView.setPressed(false);
    this.a.collapseGroup(this.a.dXa);
    this.a.setSelectedGroup(this.a.dXa);
    this.a.IS = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argd
 * JD-Core Version:    0.7.0.1
 */