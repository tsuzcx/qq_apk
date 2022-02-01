import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

public class ayvt
{
  private ayvq jdField_a_of_type_Ayvq;
  private ayvt.a jdField_a_of_type_Ayvt$a;
  private int btB;
  private final Bitmap cO;
  private final Bitmap cP;
  private int ckM;
  private int lineHeight;
  private float mLastX;
  private final float of;
  private final Paint paint;
  private final float rW;
  private final float rX;
  private final float rY;
  private float rZ;
  private float sa;
  private float sb;
  private float sc;
  private float sd;
  private float se;
  
  private void a(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.cP, paramFloat, 0.0F, this.paint);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (Math.abs(paramFloat1 - paramFloat3) <= this.rW * 2.0F) && (paramFloat2 > 0.0F) && (paramFloat2 < this.rX);
  }
  
  private void b(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.cO, paramFloat - this.rW, 0.0F, this.paint);
  }
  
  public boolean F(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = a(paramFloat1, paramFloat2, this.rZ - this.rY);
    boolean bool2 = a(paramFloat1, paramFloat2, this.sa + this.rY);
    if (bool1)
    {
      this.ckM = 0;
      return true;
    }
    if (bool2)
    {
      this.ckM = 1;
      return true;
    }
    return false;
  }
  
  public void J(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F) {}
    for (this.se = (this.rW + paramFloat1);; this.se = this.rW)
    {
      if (paramFloat2 >= 0.0F) {
        this.sd = Math.min(this.rW + paramFloat2, this.of - this.rW);
      }
      return;
    }
  }
  
  public float aR()
  {
    return this.rW;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i = this.paint.getColor();
    this.paint.setColor(this.btB);
    paramCanvas.drawRect(this.rZ, 0.0F, this.sa, this.lineHeight, this.paint);
    paramCanvas.drawRect(this.rZ, this.rX - this.lineHeight, this.sa, this.rX, this.paint);
    this.paint.setColor(i);
    b(this.rZ, paramCanvas);
    a(this.sa, paramCanvas);
    paramCanvas.restore();
  }
  
  public float getHeight()
  {
    return this.rX;
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    if (paramMotionEvent.getAction() == 1) {
      this.ckM = -1;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.mLastX = paramMotionEvent.getX();
      return;
    }
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 2)
    {
      f2 = f1 - this.mLastX;
      if (this.ckM != 0) {
        break label186;
      }
      f3 = Math.max(this.sa - this.sc, this.se);
      if (f1 < f3)
      {
        this.rZ = f3;
        return;
      }
      if ((f2 >= 0.0F) || (f2 + this.rZ > this.rW)) {
        break label148;
      }
      this.rZ = f3;
    }
    for (;;)
    {
      this.jdField_a_of_type_Ayvq.invalidate();
      if (this.jdField_a_of_type_Ayvt$a == null) {
        break;
      }
      this.jdField_a_of_type_Ayvt$a.K(this.rZ, this.sa);
      return;
      label148:
      if (this.sa - f1 < this.sb)
      {
        this.rZ = (this.sa - this.sb);
      }
      else
      {
        this.rZ = f1;
        continue;
        label186:
        if (this.ckM == 1)
        {
          f3 = Math.min(this.rZ + this.sc, this.sd);
          if (f1 > f3)
          {
            this.sa = f3;
            return;
          }
          if ((f2 > 0.0F) && (f2 + this.sa >= this.sc)) {
            this.sa = f3;
          } else if (f1 - this.rZ < this.sb) {
            this.sa = (this.rZ + this.sb);
          } else {
            this.sa = f1;
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void K(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayvt
 * JD-Core Version:    0.7.0.1
 */