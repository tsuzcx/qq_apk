import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;

class yxi
  extends LinearSmoothScroller
{
  yxi(yxh paramyxh, Context paramContext)
  {
    super(paramContext);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxi
 * JD-Core Version:    0.7.0.1
 */