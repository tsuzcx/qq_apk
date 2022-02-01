import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

public class jde
{
  PointF J;
  boolean XK;
  int axg;
  public float bM = 0.0F;
  float hN;
  float hO;
  float hP;
  float hQ;
  final float hR = 0.5F;
  final float hS = 0.05F;
  Paint mPaint;
  Path mPath;
  
  public jde(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint, PointF paramPointF, boolean paramBoolean)
  {
    if (paramPaint == null) {}
    while (paramPointF == null) {
      return;
    }
    this.axg = paramInt;
    this.hN = paramFloat1;
    this.hO = paramFloat2;
    this.hQ = paramFloat3;
    this.mPaint = paramPaint;
    this.J = paramPointF;
    this.XK = paramBoolean;
    this.mPath = new Path();
  }
  
  public void R(Canvas paramCanvas)
  {
    if (!checkParams()) {
      return;
    }
    float f4 = this.hO * 0.5F;
    float f5 = this.hN * 0.5F;
    float f6 = this.hN;
    int i;
    float f1;
    float f2;
    label114:
    float f8;
    float f9;
    float f10;
    label182:
    float f3;
    if (!this.XK)
    {
      i = this.axg;
      f1 = new float[] { 1.0F, 0.714F, 0.429F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F }[i];
      f2 = this.bM * f1;
      if (this.XK) {
        break label277;
      }
      f1 = f4 - 4.0F;
      this.mPath.rewind();
      i = (int)(f6 * 0.01D);
      float f7 = (float)(0.8D * f1 * f2);
      f8 = (float)(1.0D * f1 * f2);
      f9 = (float)(6.283185307179586D * this.hQ) / f6;
      f10 = this.axg + this.hP;
      f2 = 0.0F;
      if (f2 >= i + f6) {
        break label414;
      }
      if (this.XK) {
        break label286;
      }
      f3 = (float)(f7 * Math.sin(f2 * f9 + f10));
      label218:
      if (this.XK) {
        break label320;
      }
      f3 += f4;
      if (f2 != 0.0F) {
        break label307;
      }
      this.mPath.moveTo(f2, f3);
    }
    for (;;)
    {
      f2 = i + f2;
      break label182;
      f1 = 1.5F * (1.0F - this.axg / 3.0F) - 0.5F;
      break;
      label277:
      f1 = f5 / 6.0F;
      break label114;
      label286:
      f3 = (float)(f8 * Math.sin(f2 * f9 + f10));
      break label218;
      label307:
      this.mPath.lineTo(f2, f3);
      continue;
      label320:
      float f11 = (float)((f3 + f5 - f1) * Math.cos(f2 / f6 * 2.0F * 3.141592653589793D) + f5);
      f3 = (float)((f3 + f5 - f1) * Math.sin(f2 / f6 * 2.0F * 3.141592653589793D) + f4);
      if (f2 == 0.0F) {
        this.mPath.moveTo(f11, f3);
      } else {
        this.mPath.lineTo(f11, f3);
      }
    }
    label414:
    paramCanvas.drawPath(this.mPath, this.mPaint);
  }
  
  public void aun()
  {
    this.hP = 0.0F;
    this.bM = 0.0F;
  }
  
  boolean checkParams()
  {
    if ((this.hN <= 0.0F) || (this.hO <= 0.0F)) {}
    while ((this.hQ <= 0.0F) || (this.mPaint == null) || (this.mPath == null) || (this.J == null)) {
      return false;
    }
    return true;
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public void v(float paramFloat1, float paramFloat2)
  {
    this.hP = paramFloat1;
    float f = this.bM;
    getClass();
    if (f - paramFloat2 > 0.05F * 2.0F)
    {
      getClass();
      paramFloat1 = f - 0.05F * 2.0F;
    }
    for (;;)
    {
      getClass();
      this.bM = Math.min(paramFloat1, 0.5F);
      return;
      getClass();
      paramFloat1 = paramFloat2;
      if (paramFloat2 - f > 0.05F * 2.0F)
      {
        getClass();
        paramFloat1 = f + 0.05F * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jde
 * JD-Core Version:    0.7.0.1
 */