import android.graphics.Point;

public final class aeyr
{
  public final int cPG;
  public float mM;
  public float mO;
  public final Point mPoint;
  public final long mTime;
  
  public aeyr(long paramLong, Point paramPoint, int paramInt)
  {
    this.mTime = paramLong;
    this.mPoint = paramPoint;
    this.cPG = paramInt;
  }
  
  public void P(float paramFloat1, float paramFloat2)
  {
    this.mO = paramFloat1;
    this.mM = paramFloat2;
  }
  
  public float getX()
  {
    return this.mPoint.x - this.mO;
  }
  
  public float getY()
  {
    return this.mPoint.y - this.mM;
  }
  
  public String toString()
  {
    return "TouchPoint{mTime=" + this.mTime + ", mPoint=" + this.mPoint + ", mDistanceOfError=" + this.cPG + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyr
 * JD-Core Version:    0.7.0.1
 */