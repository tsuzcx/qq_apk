import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class xmc
  implements wlz
{
  xmc(xmb paramxmb) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = (xmb.c)((View)paramView.getParent().getParent().getParent()).getTag();
    if (paramView != null) {
      paramView.jdField_do.performLongClick();
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmc
 * JD-Core Version:    0.7.0.1
 */