import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ayle
  implements View.OnTouchListener
{
  private final int brm = 10;
  private boolean mIsScroll;
  private int mStartY;
  
  ayle(aykw paramaykw) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        this.mStartY = ((int)f);
        this.mIsScroll = false;
        return false;
      } while (Math.abs(f - this.mStartY) <= 10.0F);
      this.mIsScroll = true;
      return false;
    }
    return this.mIsScroll;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayle
 * JD-Core Version:    0.7.0.1
 */