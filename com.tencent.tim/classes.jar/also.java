import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class also
{
  public boolean czd;
  public int dwQ;
  public int mAlpha = 255;
  public Bitmap mBitmap;
  public long mDuration;
  public float mDx;
  public float mDy;
  public float mRotation;
  public float mScale = 1.0F;
  public long mStartPlayTime = System.currentTimeMillis();
  
  public void draw(Canvas paramCanvas, Paint paramPaint, Matrix paramMatrix)
  {
    if (this.mBitmap == null) {
      return;
    }
    int i = (int)(this.mBitmap.getWidth() * this.mScale);
    int j = (int)(this.mBitmap.getHeight() * this.mScale);
    Matrix localMatrix = paramMatrix;
    if (paramMatrix == null) {
      localMatrix = new Matrix();
    }
    paramPaint.setAlpha(this.mAlpha);
    localMatrix.reset();
    localMatrix.setScale(this.mScale, this.mScale);
    localMatrix.postRotate(this.mRotation, i / 2, j / 2);
    localMatrix.postTranslate(this.mDx, this.mDy);
    paramCanvas.drawBitmap(this.mBitmap, localMatrix, paramPaint);
  }
  
  public String toString()
  {
    return " mDx = " + this.mDx + " mDy = " + this.mDy + " mScale = " + this.mScale + " mRotation = " + this.mRotation + " mDuration = " + this.mDuration + " mAlpha = " + this.mAlpha;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     also
 * JD-Core Version:    0.7.0.1
 */