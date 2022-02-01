import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;

public class afwf
  extends RecyclerView.ItemDecoration
{
  private int mBottom;
  private int mLeft;
  private int mRight;
  private int mTop;
  
  public afwf(Fragment paramFragment)
  {
    this.mTop = wja.dp2px(11.0F, paramFragment.getResources());
    this.mBottom = wja.dp2px(11.0F, paramFragment.getResources());
    this.mLeft = wja.dp2px(8.0F, paramFragment.getResources());
    this.mRight = wja.dp2px(8.0F, paramFragment.getResources());
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    int i = paramRecyclerView.getAdapter().getItemCount();
    if (paramRecyclerView.getAdapter().getItemViewType(paramInt) == 6)
    {
      paramRect.set(0, this.mTop, 0, 0);
      return;
    }
    if (paramInt == i - 1)
    {
      paramRect.set(this.mLeft, this.mTop, this.mRight, this.mBottom);
      return;
    }
    paramRect.set(this.mLeft, this.mTop, this.mRight, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwf
 * JD-Core Version:    0.7.0.1
 */