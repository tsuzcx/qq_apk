import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.view.MotionEvent;

public class riy
{
  private Matrix C = new Matrix();
  private final int STATE_NONE = 0;
  private boolean aIk;
  private boolean aIl;
  private boolean aIm;
  private riy.a b;
  private final int bsm = 1;
  private final int bsn = 2;
  private final int bso = 3;
  private Matrix mMatrix = new Matrix();
  private float mMaxScale = 2.147484E+009F;
  private float mMinScale;
  private float mStartX;
  private float mStartY;
  private int mState = 0;
  private float nA;
  private float nB;
  private float nC;
  private float nD;
  private float nE;
  private float nF;
  private float nG;
  private float nH;
  
  private void N(MotionEvent paramMotionEvent)
  {
    this.mState = 0;
    reset();
  }
  
  private void P(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX(1);
    paramMotionEvent.getY(1);
    if (this.mState == 1)
    {
      this.mState = 2;
      this.nG = this.b.scaleValue;
      this.nH = this.b.nI;
      this.nE = this.b.translateXValue;
      this.nF = this.b.translateYValue;
      this.nA = riz.spacing(paramMotionEvent);
      this.nB = riz.b(paramMotionEvent);
      paramMotionEvent = riz.a(paramMotionEvent);
      this.nC = paramMotionEvent[0];
      this.nD = paramMotionEvent[1];
    }
  }
  
  private void Q(MotionEvent paramMotionEvent)
  {
    if (this.mState == 2)
    {
      this.aIk = true;
      this.mState = 1;
    }
  }
  
  private void b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    this.aIl = true;
    this.mState = 1;
    float f2 = paramMotionEvent.getX(0);
    float f1 = paramMotionEvent.getY(0);
    this.mStartX = f2;
    this.mStartY = f1;
    this.nE = this.b.translateXValue;
    this.nF = this.b.translateYValue;
    if ((a(this.b, f2, f1)) && (paramBoolean))
    {
      this.mState = 3;
      this.nG = this.b.scaleValue;
      this.nH = this.b.nI;
      f2 = f2 - this.b.centerP.x - this.b.translateXValue;
      f1 = f1 - this.b.centerP.y - this.b.translateYValue;
      this.nA = riz.e(f2, f1);
      this.nB = riz.f(f2, f1);
      this.nC = this.b.centerP.x;
      this.nD = this.b.centerP.y;
    }
  }
  
  private void c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (!this.aIl)
    {
      this.aIl = true;
      b(paramMotionEvent, paramBoolean);
    }
    label394:
    do
    {
      do
      {
        do
        {
          return;
          if ((paramMotionEvent.getPointerCount() == 1) && (this.mState == 1))
          {
            if (this.aIk)
            {
              this.aIk = false;
              this.mStartX = paramMotionEvent.getX(0);
              this.mStartY = paramMotionEvent.getY(0);
              this.nE = this.b.translateXValue;
              this.nF = this.b.translateYValue;
              return;
            }
            f1 = paramMotionEvent.getX(0);
            f2 = this.mStartX;
            f3 = paramMotionEvent.getY(0);
            f4 = this.mStartY;
            this.b.translateXValue = (f1 - f2 + this.nE);
            this.b.translateYValue = (f3 - f4 + this.nF);
            return;
          }
          if ((paramMotionEvent.getPointerCount() != 2) || (this.mState != 2)) {
            break label394;
          }
          float f4 = riz.spacing(paramMotionEvent);
          f1 = riz.b(paramMotionEvent);
          paramMotionEvent = riz.a(paramMotionEvent);
          f2 = paramMotionEvent[0];
          f3 = paramMotionEvent[1];
          paramMotionEvent = this.b;
          float f5 = this.nG;
          paramMotionEvent.scaleValue = (f4 / this.nA * f5);
          paramMotionEvent = this.b;
          f4 = this.nH;
          paramMotionEvent.nI = ((f1 - this.nB + f4) % 360.0F);
          this.b.translateXValue = (this.nE + (f2 - this.nC));
          this.b.translateYValue = (this.nF + (f3 - this.nD));
          if (!this.b.aIn) {
            break;
          }
          if (this.b.scaleValue > this.mMaxScale) {
            this.b.scaleValue = this.mMaxScale;
          }
          if (this.b.scaleValue < this.mMinScale) {
            this.b.scaleValue = this.mMinScale;
          }
        } while (this.b.nI >= 0.0F);
        this.b.nI += 360.0F;
        return;
        this.b.scaleValue = this.nG;
        this.b.nI = this.nH;
        return;
      } while ((paramMotionEvent.getPointerCount() != 1) || (this.mState != 3) || (!paramBoolean));
      float f2 = paramMotionEvent.getX() - this.b.centerP.x - this.b.translateXValue;
      float f3 = paramMotionEvent.getY() - this.b.centerP.y - this.b.translateYValue;
      float f1 = riz.e(f2, f3);
      f2 = riz.f(f2, f3);
      paramMotionEvent = this.b;
      f3 = this.nG;
      paramMotionEvent.scaleValue = (f1 / this.nA * f3);
      paramMotionEvent = this.b;
      f1 = this.nH;
      paramMotionEvent.nI = ((f2 - this.nB + f1) % 360.0F);
      if (!this.b.aIn) {
        break;
      }
      if (this.b.scaleValue > this.mMaxScale) {
        this.b.scaleValue = this.mMaxScale;
      }
      if (this.b.scaleValue < this.mMinScale) {
        this.b.scaleValue = this.mMinScale;
      }
    } while (this.b.nI >= 0.0F);
    this.b.nI += 360.0F;
    return;
    this.b.scaleValue = this.nG;
    this.b.nI = this.nH;
  }
  
  public float a(riy.a parama)
  {
    float f = 1.0F;
    if (parama != null) {
      f = parama.scaleValue * parama.nJ;
    }
    return f;
  }
  
  public Matrix a(riy.a parama)
  {
    this.mMatrix.reset();
    if (parama == null) {
      return this.mMatrix;
    }
    this.mMatrix.postRotate(parama.nI);
    this.mMatrix.postScale(a(parama), a(parama));
    this.mMatrix.postTranslate(parama.centerP.x, parama.centerP.y);
    this.mMatrix.postTranslate(parama.translateXValue, parama.translateYValue);
    return this.mMatrix;
  }
  
  public void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 0: 
      b(paramMotionEvent, paramBoolean);
      return;
    case 5: 
      P(paramMotionEvent);
      return;
    case 2: 
      c(paramMotionEvent, paramBoolean);
      return;
    case 6: 
      Q(paramMotionEvent);
      return;
    }
    N(paramMotionEvent);
  }
  
  public boolean a(riy.a parama, float paramFloat1, float paramFloat2)
  {
    if (parama == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parama).mapPoints(arrayOfFloat);
    float f1 = parama.width;
    float f2 = parama.bsp * 2;
    paramFloat1 = parama.height;
    paramFloat2 = parama.bsp * 2;
    f1 = (f1 + f2) / 2.0F;
    paramFloat1 = (paramFloat1 + paramFloat2) / 2.0F;
    paramFloat2 = riw.tw() / a(parama) / 2.0F;
    int i = 10;
    if (parama.scaleValue > 2.5F) {
      i = 20;
    }
    return (arrayOfFloat[0] >= f1 - paramFloat2 - i) && (arrayOfFloat[0] <= f1 + paramFloat2 + i) && (arrayOfFloat[1] >= paramFloat1 - paramFloat2 - i) && (arrayOfFloat[1] <= i + (paramFloat1 + paramFloat2));
  }
  
  public boolean a(riy.a parama, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (parama == null) {
      return false;
    }
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = paramFloat1;
    arrayOfFloat1[1] = paramFloat2;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = paramFloat3;
    arrayOfFloat2[1] = paramFloat4;
    Matrix localMatrix = c(parama);
    localMatrix.mapPoints(arrayOfFloat1);
    localMatrix.mapPoints(arrayOfFloat2);
    paramFloat3 = parama.width;
    paramFloat4 = parama.height;
    paramFloat2 = paramFloat3;
    if (this.aIm)
    {
      paramFloat1 = paramFloat3;
      if (parama.scaleValue * paramFloat3 < 200.0F) {
        paramFloat1 = 200.0F / parama.scaleValue;
      }
      paramFloat2 = paramFloat1;
      if (parama.scaleValue * paramFloat4 < 200.0F)
      {
        paramFloat2 = 200.0F / parama.scaleValue;
        paramFloat3 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      paramFloat2 = paramFloat3 / 2.0F;
      paramFloat1 /= 2.0F;
      parama = new RectF(-paramFloat2, -paramFloat1, paramFloat2, paramFloat1);
      return riz.a(new PointF(arrayOfFloat1[0], arrayOfFloat1[1]), new PointF(arrayOfFloat2[0], arrayOfFloat2[1]), parama);
      paramFloat1 = paramFloat4;
      paramFloat3 = paramFloat2;
    }
  }
  
  public boolean a(riy.a parama, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (parama == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parama).mapPoints(arrayOfFloat);
    float f2 = parama.width;
    float f1 = parama.height;
    paramFloat2 = f1;
    paramFloat1 = f2;
    if (paramBoolean)
    {
      paramFloat1 = f2 + parama.bsp * 2;
      paramFloat2 = f1 + parama.bsp * 2;
    }
    f2 = paramFloat2;
    float f3 = paramFloat1;
    if (this.aIm)
    {
      f1 = paramFloat1;
      if (parama.scaleValue * paramFloat1 < 200.0F) {
        f1 = 200.0F / parama.scaleValue;
      }
      f2 = paramFloat2;
      f3 = f1;
      if (parama.scaleValue * paramFloat2 < 200.0F)
      {
        f2 = 200.0F / parama.scaleValue;
        f3 = f1;
      }
    }
    paramFloat1 = f3 / 2.0F;
    paramFloat2 = f2 / 2.0F;
    f1 = -paramFloat1;
    f2 = -paramFloat2;
    f3 = riw.tw() / a(parama) / 2.0F;
    if ((arrayOfFloat[0] >= f1) && (arrayOfFloat[0] <= paramFloat1) && (arrayOfFloat[1] >= f2) && (arrayOfFloat[1] <= paramFloat2)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f3 - 10.0F) && (arrayOfFloat[0] <= f1 + f3 + 10.0F) && (arrayOfFloat[1] >= f2 - f3 - 10.0F) && (arrayOfFloat[1] <= f2 + f3 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= paramFloat1 - f3 - 10.0F) && (arrayOfFloat[0] <= paramFloat1 + f3 + 10.0F) && (arrayOfFloat[1] >= f2 - f3 - 10.0F) && (arrayOfFloat[1] <= f2 + f3 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f3 - 10.0F) && (arrayOfFloat[0] <= f1 + f3 + 10.0F) && (arrayOfFloat[1] >= paramFloat2 - f3 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + f3 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= paramFloat1 - f3 - 10.0F) && (arrayOfFloat[0] <= paramFloat1 + f3 + 10.0F) && (arrayOfFloat[1] >= paramFloat2 - f3 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + f3 + 10.0F)) {
      return true;
    }
    return (arrayOfFloat[0] >= f1 - f3) && (arrayOfFloat[0] <= paramFloat1 + f3) && (arrayOfFloat[1] >= f2 - f3) && (arrayOfFloat[1] <= paramFloat2 + f3);
  }
  
  public Matrix b(riy.a parama)
  {
    this.mMatrix.reset();
    if (parama == null) {
      return this.mMatrix;
    }
    this.mMatrix.postRotate(parama.nI);
    this.mMatrix.postTranslate(parama.centerP.x, parama.centerP.y);
    this.mMatrix.postTranslate(parama.translateXValue, parama.translateYValue);
    return this.mMatrix;
  }
  
  public boolean b(riy.a parama, float paramFloat1, float paramFloat2)
  {
    if (parama == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parama).mapPoints(arrayOfFloat);
    float f1 = parama.width;
    float f2 = parama.bsp * 2;
    paramFloat1 = parama.height;
    paramFloat2 = parama.bsp * 2;
    f1 = (f1 + f2) / 2.0F;
    paramFloat2 = (paramFloat1 + paramFloat2) / 2.0F;
    paramFloat1 = riw.tw() / a(parama) / 2.0F;
    int i = 10;
    if (parama.scaleValue > 2.5F) {
      i = 20;
    }
    if ((arrayOfFloat[0] >= f1 - paramFloat1 - i) && (arrayOfFloat[0] <= f1 + paramFloat1 + i) && (arrayOfFloat[1] >= -paramFloat2 - paramFloat1 - i))
    {
      f1 = arrayOfFloat[1];
      paramFloat2 = -paramFloat2;
      if (f1 <= i + (paramFloat2 + paramFloat1)) {
        return true;
      }
    }
    return false;
  }
  
  public Matrix c(riy.a parama)
  {
    this.C.reset();
    if (parama == null) {
      return this.C;
    }
    this.mMatrix = a(parama);
    this.mMatrix.invert(this.C);
    return this.C;
  }
  
  public void d(riy.a parama)
  {
    reset();
    this.b = parama;
  }
  
  public void e(riy.a parama)
  {
    if (parama == null) {
      return;
    }
    parama.scaleValue = 1.0F;
    parama.translateXValue = 0.0F;
    parama.translateYValue = 0.0F;
    parama.nI = 0.0F;
  }
  
  public void reset()
  {
    this.b = null;
    this.mStartX = 0.0F;
    this.mStartY = 0.0F;
    this.nA = 0.0F;
    this.nB = 0.0F;
    this.nC = 0.0F;
    this.nD = 0.0F;
    this.nE = 0.0F;
    this.nF = 0.0F;
    this.nG = 0.0F;
    this.nH = 0.0F;
    this.aIk = false;
    this.aIl = false;
    this.mMatrix.reset();
    this.C.reset();
  }
  
  public void setMaxScale(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.mMaxScale = paramFloat;
    }
  }
  
  public void setMinScale(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.mMinScale = paramFloat;
    }
  }
  
  public void tP(boolean paramBoolean)
  {
    this.aIm = paramBoolean;
  }
  
  public static abstract class a
  {
    public ValueAnimator N;
    public boolean aHC;
    public boolean aIn = true;
    public boolean aIo;
    public boolean aIp;
    public boolean aIq;
    public int bsp;
    public PointF centerP;
    public float height;
    public float nI;
    public float nJ = 1.0F;
    public float scaleValue = 1.0F;
    public float translateXValue;
    public float translateYValue;
    public float width;
    
    public a(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.centerP = new PointF(paramPointF.x, paramPointF.y);
      this.scaleValue = paramFloat1;
      this.nI = paramFloat2;
      this.translateXValue = paramFloat3;
      this.translateYValue = paramFloat4;
      this.width = paramFloat5;
      this.height = paramFloat6;
      this.aIn = paramBoolean;
    }
    
    public a(a parama, float paramFloat)
    {
      this.centerP = new PointF(parama.centerP.x * paramFloat, parama.centerP.y * paramFloat);
      parama.scaleValue *= paramFloat;
      this.nI = parama.nI;
      parama.translateXValue *= paramFloat;
      parama.translateYValue *= paramFloat;
      this.width = parama.width;
      this.height = parama.height;
      this.aIn = parama.aIn;
    }
    
    public void draw(Canvas paramCanvas) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     riy
 * JD-Core Version:    0.7.0.1
 */