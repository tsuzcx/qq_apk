import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;

public class yzy
  extends blhu
{
  private yzl a;
  
  public yzy(yzl paramyzl)
  {
    this.a = paramyzl;
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    super.clearView(paramRecyclerView, paramViewHolder);
    if ((paramViewHolder instanceof yzu))
    {
      ((yzu)paramViewHolder).a = false;
      if ((paramRecyclerView.getScrollState() == 0) && (!paramRecyclerView.isComputingLayout())) {
        paramRecyclerView.getAdapter().notifyItemChanged(paramViewHolder.getAdapterPosition(), Integer.valueOf(0));
      }
    }
  }
  
  public float getMoveThreshold(RecyclerView.ViewHolder paramViewHolder)
  {
    return 0.25F;
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).getOrientation() == 0)) {}
    for (int i = 15;; i = 0) {
      return makeMovementFlags(i, 0);
    }
  }
  
  public boolean isItemViewSwipeEnabled()
  {
    return false;
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.a != null) {
      this.a.a(paramViewHolder1.getAdapterPosition(), paramViewHolder2.getAdapterPosition());
    }
    return false;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onSelectedChanged(paramViewHolder, paramInt);
    if ((paramInt == 2) && ((paramViewHolder instanceof yzu)))
    {
      paramViewHolder = (yzu)paramViewHolder;
      paramViewHolder.a = true;
      if ((this.a instanceof yzr)) {
        ((yzr)this.a).notifyItemChanged(paramViewHolder.getAdapterPosition(), Integer.valueOf(0));
      }
    }
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzy
 * JD-Core Version:    0.7.0.1
 */