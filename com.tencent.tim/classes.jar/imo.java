import android.graphics.Canvas;
import android.graphics.PointF;
import com.tencent.av.doodle.MySurfaceView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class imo
{
  public String Ov = "unused";
  final String TAG = "DoodleItem_" + getClass().getSimpleName() + "_" + AudioHelper.hG();
  public int apU = 1;
  public PointF d = new PointF();
  public long lV = -1L;
  public int mColor = -65536;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mStrokeWidth = 12;
  
  public imo()
  {
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, getClass().getSimpleName());
    }
  }
  
  public void a(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    float f2 = 0.0F;
    int i = paramMySurfaceView.getWidth();
    int j = paramMySurfaceView.getHeight();
    int k = this.mScreenHeight;
    int m = this.mScreenWidth;
    float f3;
    if (i * k < j * m) {
      f3 = i / m;
    }
    for (float f1 = (j - k * f3) / 2.0F;; f1 = 0.0F)
    {
      if (paramCanvas != null)
      {
        paramCanvas.save();
        paramCanvas.translate(f2, f1);
        paramCanvas.scale(f3, f3);
        b(paramCanvas, paramMySurfaceView, paramBoolean);
      }
      try
      {
        paramCanvas.restore();
        return;
      }
      catch (Exception paramCanvas)
      {
        igd.aL(this.TAG, paramCanvas.getMessage());
      }
      f3 = j / k;
      f2 = (i - m * f3) / 2.0F;
    }
  }
  
  public abstract void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean);
  
  public abstract void ch(long paramLong);
  
  public void q(float paramFloat1, float paramFloat2)
  {
    this.d.x = paramFloat1;
    this.d.y = paramFloat2;
  }
  
  public abstract void r(float paramFloat1, float paramFloat2);
  
  public abstract void s(float paramFloat1, float paramFloat2);
  
  public boolean t(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.abs(paramFloat1 - this.d.x);
    float f2 = Math.abs(paramFloat2 - this.d.y);
    if ((f1 >= 8.0F) || (f2 >= 8.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        r(paramFloat1, paramFloat2);
        this.d.x = paramFloat1;
        this.d.y = paramFloat2;
      }
      return bool;
    }
  }
  
  public String toString()
  {
    return this.TAG + ", mPenType[" + this.apU + "], mPoint[" + this.d.x + "," + this.d.y + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imo
 * JD-Core Version:    0.7.0.1
 */