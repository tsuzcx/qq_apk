import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;

public class ofp
  extends RecyclerView.ItemDecoration
{
  public static final int SPACE = oor.j(5.0F);
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    paramView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getSpanIndex();
    if (paramView.isFullSpan())
    {
      paramRect.left = SPACE;
      paramRect.right = SPACE;
    }
    for (;;)
    {
      paramRect.top = SPACE;
      return;
      if (i % 2 == 0)
      {
        paramRect.left = SPACE;
        paramRect.right = (SPACE / 2);
      }
      else
      {
        paramRect.left = (SPACE / 2);
        paramRect.right = SPACE;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofp
 * JD-Core Version:    0.7.0.1
 */