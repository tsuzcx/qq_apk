import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;

public abstract class imu
  extends imo
{
  protected Path mPath = new Path();
  protected PathMeasure mPathMeasure = new PathMeasure(this.mPath, false);
  
  public abstract void aom();
  
  public void q(float paramFloat1, float paramFloat2)
  {
    super.q(paramFloat1, paramFloat2);
    this.mPath.reset();
    this.mPath.moveTo(paramFloat1, paramFloat2);
    this.mPathMeasure.setPath(this.mPath, false);
    aom();
  }
  
  public void r(float paramFloat1, float paramFloat2)
  {
    this.mPath.quadTo(this.d.x, this.d.y, (this.d.x + paramFloat1) / 2.0F, (this.d.y + paramFloat2) / 2.0F);
    this.mPathMeasure.setPath(this.mPath, false);
    aom();
  }
  
  public void s(float paramFloat1, float paramFloat2)
  {
    this.d.x = paramFloat1;
    this.d.y = paramFloat2;
    this.mPath.lineTo(this.d.x, this.d.y);
    this.mPathMeasure.setPath(this.mPath, false);
    aom();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imu
 * JD-Core Version:    0.7.0.1
 */