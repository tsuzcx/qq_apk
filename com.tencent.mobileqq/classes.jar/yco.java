import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class yco
  extends RecyclerView.ItemDecoration
{
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i == 0)
    {
      paramRect.left = bdaq.a(paramView.getContext(), 3.0F);
      paramRect.right = 0;
      return;
    }
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && (i == paramRecyclerView.getItemCount() - 1)) {}
    for (paramRect.right = bdaq.a(paramView.getContext(), 3.0F);; paramRect.right = 0)
    {
      paramRect.left = (-bdaq.a(paramView.getContext(), 6.0F));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yco
 * JD-Core Version:    0.7.0.1
 */