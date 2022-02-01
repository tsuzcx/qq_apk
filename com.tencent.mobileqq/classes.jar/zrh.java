import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class zrh
  extends RecyclerView.ItemDecoration
{
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i == 0)
    {
      paramRect.left = DisplayUtil.dip2px(paramView.getContext(), 3.0F);
      paramRect.right = 0;
      return;
    }
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && (i == paramRecyclerView.getItemCount() - 1)) {}
    for (paramRect.right = DisplayUtil.dip2px(paramView.getContext(), 3.0F);; paramRect.right = 0)
    {
      paramRect.left = (-DisplayUtil.dip2px(paramView.getContext(), 6.0F));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zrh
 * JD-Core Version:    0.7.0.1
 */