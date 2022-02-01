import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView;

public class apvb
  implements View.OnTouchListener
{
  public apvb(PinnedHeaderIphoneTreeView paramPinnedHeaderIphoneTreeView) {}
  
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
      this.b.invalidate();
      return true;
      paramView.setPressed(false);
      this.b.invalidate();
      break;
    } while (!paramView.isPressed());
    paramView.setPressed(false);
    this.b.collapseGroup(this.b.dXa);
    this.b.setSelectedGroup(this.b.dXa);
    this.b.IS = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvb
 * JD-Core Version:    0.7.0.1
 */