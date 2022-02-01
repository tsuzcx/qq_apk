import android.graphics.RectF;

public class axuz
  extends axtw
{
  private int bYc;
  
  public axuz(int paramInt)
  {
    this.bYc = paramInt;
  }
  
  void a(int paramInt, axtx paramaxtx)
  {
    RectF localRectF = paramaxtx.bx;
    localRectF.top += this.bYc * paramInt;
    paramaxtx = paramaxtx.bx;
    paramaxtx.bottom += this.bYc * paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axuz
 * JD-Core Version:    0.7.0.1
 */