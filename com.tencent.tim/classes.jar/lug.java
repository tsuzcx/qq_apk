import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class lug
  extends RecyclerView.ItemDecoration
{
  private int bottom;
  boolean isHorizontal = true;
  private int left;
  private int right;
  private int top;
  
  public lug(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.isHorizontal = paramBoolean;
    this.left = paramInt1;
    this.right = paramInt2;
    this.top = paramInt3;
    this.bottom = paramInt4;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (this.isHorizontal)
    {
      paramRect.top = this.top;
      paramRect.bottom = this.bottom;
      if (i == 0) {
        paramRect.left = this.left;
      }
      if (i == paramState.getItemCount() - 1) {
        paramRect.right = this.right;
      }
    }
    do
    {
      return;
      paramRect.left = this.left;
      paramRect.right = this.right;
      if (i == 0) {
        paramRect.top = this.top;
      }
    } while (i != paramState.getItemCount() - 1);
    paramRect.bottom = this.bottom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lug
 * JD-Core Version:    0.7.0.1
 */