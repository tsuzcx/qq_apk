import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.biz.subscribe.component.base.ComponentPageView;

public class yea
  extends RecyclerView.ItemDecoration
{
  public yea(ComponentPageView paramComponentPageView, yds paramyds) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    if ((this.a.a != null) && (this.a.a.b(i) != null)) {
      this.a.a.b(i).a(paramRect, paramView, paramRecyclerView, paramState);
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yea
 * JD-Core Version:    0.7.0.1
 */