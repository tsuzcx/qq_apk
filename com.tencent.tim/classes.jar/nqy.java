import android.graphics.RectF;
import android.support.annotation.NonNull;

public class nqy
{
  private RectF K;
  private RectF N;
  private float kW;
  private float kX;
  
  public nqy(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    this.K = paramRectF1;
    this.N = paramRectF2;
    this.kW = paramFloat1;
    this.kX = paramFloat2;
  }
  
  public float ao()
  {
    return this.kW;
  }
  
  public RectF d()
  {
    return this.K;
  }
  
  public RectF e()
  {
    return this.N;
  }
  
  @NonNull
  public String toString()
  {
    return "cropRect:" + this.K + " ,imageRect:" + this.N + " ,scale:" + this.kW + " ,angle:" + this.kX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nqy
 * JD-Core Version:    0.7.0.1
 */