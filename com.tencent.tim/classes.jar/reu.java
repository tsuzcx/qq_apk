import android.view.MotionEvent;
import java.math.BigDecimal;

public class reu
{
  private float mJ;
  private float mK;
  public float mL;
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    if ((i == 1) && (paramBoolean)) {
      switch (j)
      {
      }
    }
    while (((i != 2) || (paramBoolean)) && ((i != 3) || (!paramBoolean)))
    {
      do
      {
        return false;
        this.mK = this.mL;
        return false;
        if (paramMotionEvent.getY() >= this.mL)
        {
          this.mK = this.mL;
          return false;
        }
        i = new BigDecimal((this.mK - paramMotionEvent.getY()) / 20.0F).setScale(0, 4).intValue();
      } while (i == 0);
      anij.a().lB(i);
      this.mK = paramMotionEvent.getY();
      return false;
    }
    ram.v("NewStoryCameraZoom", "onTouchEvent %s", new Object[] { paramMotionEvent });
    float f4;
    float f2;
    float f3;
    if (i == 2)
    {
      f4 = paramMotionEvent.getX(0);
      f2 = paramMotionEvent.getY(0);
      f3 = paramMotionEvent.getX(1);
    }
    for (float f1 = paramMotionEvent.getY(1);; f1 = paramMotionEvent.getY(2)) {
      switch (j)
      {
      case 6: 
      case 3: 
      case 4: 
      default: 
        return false;
      case 2: 
        f1 = rex.e(f4, f2, f3, f1);
        i = new BigDecimal((f1 - this.mJ) / 20.0F).setScale(0, 4).intValue();
        if (i != 0)
        {
          ram.v("NewStoryCameraZoom", "set camera zoom increase value %d", new Object[] { Integer.valueOf(i) });
          anij.a().lB(i);
          this.mJ = f1;
        }
        return true;
        f4 = paramMotionEvent.getX(1);
        f2 = paramMotionEvent.getY(1);
        f3 = paramMotionEvent.getX(2);
      }
    }
    this.mJ = rex.e(f4, f2, f3, f1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     reu
 * JD-Core Version:    0.7.0.1
 */