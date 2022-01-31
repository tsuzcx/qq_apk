import android.view.MotionEvent;
import java.math.BigDecimal;

public class vjm
{
  public float a;
  private float b;
  private float c;
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
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
        this.c = this.a;
        return false;
        if (paramMotionEvent.getY() >= this.a)
        {
          this.c = this.a;
          return false;
        }
        i = new BigDecimal((this.c - paramMotionEvent.getY()) / 20.0F).setScale(0, 4).intValue();
      } while (i == 0);
      axhp.a().b(i);
      this.c = paramMotionEvent.getY();
      return false;
    }
    veg.a("NewStoryCameraZoom", "onTouchEvent %s", new Object[] { paramMotionEvent });
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
        f1 = vjr.a(f4, f2, f3, f1);
        i = new BigDecimal((f1 - this.b) / 20.0F).setScale(0, 4).intValue();
        if (i != 0)
        {
          veg.a("NewStoryCameraZoom", "set camera zoom increase value %d", new Object[] { Integer.valueOf(i) });
          axhp.a().b(i);
          this.b = f1;
        }
        return true;
        f4 = paramMotionEvent.getX(1);
        f2 = paramMotionEvent.getY(1);
        f3 = paramMotionEvent.getX(2);
      }
    }
    this.b = vjr.a(f4, f2, f3, f1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vjm
 * JD-Core Version:    0.7.0.1
 */