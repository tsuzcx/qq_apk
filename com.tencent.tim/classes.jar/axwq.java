import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class axwq
  extends LinearSmoothScroller
{
  axwq(axwo paramaxwo, Context paramContext)
  {
    super(paramContext);
  }
  
  public float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return null;
  }
  
  public void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    paramView = this.a.a(this.a.c.getLayoutManager(), paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      paramAction.update(i, j, k, this.mDecelerateInterpolator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwq
 * JD-Core Version:    0.7.0.1
 */