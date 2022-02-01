import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;

public final class oar
  implements obb
{
  @NonNull
  private final RecyclerView.Adapter mAdapter;
  
  public oar(@NonNull RecyclerView.Adapter paramAdapter)
  {
    this.mAdapter = paramAdapter;
  }
  
  public void c(int paramInt1, int paramInt2, Object paramObject)
  {
    this.mAdapter.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
  }
  
  public void du(int paramInt1, int paramInt2)
  {
    this.mAdapter.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void dv(int paramInt1, int paramInt2)
  {
    this.mAdapter.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
  
  public void dw(int paramInt1, int paramInt2)
  {
    this.mAdapter.notifyItemMoved(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oar
 * JD-Core Version:    0.7.0.1
 */