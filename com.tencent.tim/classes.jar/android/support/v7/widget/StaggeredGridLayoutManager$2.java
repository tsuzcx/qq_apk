package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;

class StaggeredGridLayoutManager$2
  extends LinearSmoothScroller
{
  StaggeredGridLayoutManager$2(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, Context paramContext)
  {
    super(paramContext);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    paramInt = StaggeredGridLayoutManager.access$400(this.this$0, paramInt);
    if (paramInt == 0) {
      return null;
    }
    if (StaggeredGridLayoutManager.access$500(this.this$0) == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.2
 * JD-Core Version:    0.7.0.1
 */