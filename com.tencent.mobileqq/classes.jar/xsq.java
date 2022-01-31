import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class xsq
  extends RecyclerView.AdapterDataObserver
{
  xsq(xsp paramxsp) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (xsp.a(this.a) != null) {
      xsp.a(this.a).a(xsp.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(xsp.a(this.a).size() + paramInt1, paramInt2);
    if (xsp.a(this.a) != null) {
      xsp.a(this.a).a(xsp.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(xsp.a(this.a).size() + paramInt1, paramInt2);
    if (xsp.a(this.a) != null) {
      xsp.a(this.a).a(xsp.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(xsp.a(this.a).size() + paramInt1, xsp.a(this.a).size() + paramInt2);
    if (xsp.a(this.a) != null) {
      xsp.a(this.a).a(xsp.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(xsp.a(this.a).size() + paramInt1, paramInt2);
    if (xsp.a(this.a) != null) {
      xsp.a(this.a).a(xsp.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xsq
 * JD-Core Version:    0.7.0.1
 */