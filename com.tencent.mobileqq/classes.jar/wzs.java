import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;

class wzs
  extends LinearSmoothScroller
{
  wzs(wzr paramwzr, Context paramContext)
  {
    super(paramContext);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzs
 * JD-Core Version:    0.7.0.1
 */