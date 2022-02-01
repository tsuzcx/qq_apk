import android.graphics.RectF;

public class axuf
  extends axtw
{
  private float mHeight;
  private float mWidth;
  
  public axuf(float paramFloat1, float paramFloat2)
  {
    this.mWidth = paramFloat1;
    this.mHeight = paramFloat2;
  }
  
  void a(int paramInt, axtx paramaxtx)
  {
    float f3 = paramaxtx.bx.right;
    float f4 = paramaxtx.bx.left;
    float f1 = paramaxtx.bx.bottom;
    float f2 = paramaxtx.bx.top;
    f3 = Math.abs(f3 - f4 - this.mWidth) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.mHeight) / 2.0F;
    RectF localRectF = paramaxtx.bx;
    localRectF.left += f3;
    paramaxtx = paramaxtx.bx;
    paramaxtx.right = (f3 + paramaxtx.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axuf
 * JD-Core Version:    0.7.0.1
 */