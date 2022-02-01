import android.content.Context;
import android.view.MotionEvent;

public class akph
{
  private final akph.a a;
  private boolean ctR;
  private boolean ctS;
  private float focusX;
  private float focusY;
  private float xY;
  private float xZ;
  private float ya;
  
  public akph(Context paramContext, akph.a parama)
  {
    this.a = parama;
  }
  
  private boolean asy()
  {
    return (this.ctR) && (this.ctS) && (this.a.b(this));
  }
  
  private float c(MotionEvent paramMotionEvent)
  {
    return (float)Math.toDegrees(Math.atan2(paramMotionEvent.getY(1) - paramMotionEvent.getY(0), paramMotionEvent.getX(1) - paramMotionEvent.getX(0)));
  }
  
  private void dCG()
  {
    if ((this.ctR) || (Math.abs(this.xY - this.xZ) < 5.0F)) {
      return;
    }
    this.ctR = true;
    this.ctS = this.a.a(this);
  }
  
  private void dCH()
  {
    if (!this.ctR) {}
    do
    {
      return;
      this.ctR = false;
    } while (!this.ctS);
    this.a.a(this);
    this.ctS = false;
  }
  
  public float bn()
  {
    return this.xZ - this.ya;
  }
  
  public float getFocusX()
  {
    return this.focusX;
  }
  
  public float getFocusY()
  {
    return this.focusY;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    switch (paramMotionEvent.getActionMasked())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            dCH();
            return true;
          } while (paramMotionEvent.getPointerCount() != 2);
          float f = c(paramMotionEvent);
          this.xZ = f;
          this.ya = f;
          this.xY = f;
          return true;
        } while ((paramMotionEvent.getPointerCount() < 2) || ((this.ctR) && (!this.ctS)));
        this.xZ = c(paramMotionEvent);
        this.focusX = ((paramMotionEvent.getX(1) + paramMotionEvent.getX(0)) * 0.5F);
        this.focusY = ((paramMotionEvent.getY(1) + paramMotionEvent.getY(0)) * 0.5F);
        boolean bool = this.ctR;
        dCG();
        if ((!bool) || (asy())) {
          i = 1;
        }
      } while (i == 0);
      this.ya = this.xZ;
      return true;
    } while (paramMotionEvent.getPointerCount() != 2);
    dCH();
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(akph paramakph);
    
    public abstract boolean a(akph paramakph);
    
    public abstract boolean b(akph paramakph);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akph
 * JD-Core Version:    0.7.0.1
 */