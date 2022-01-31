import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class xwz
  extends RecyclerView.AdapterDataObserver
{
  xwz(xwy paramxwy) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (xwy.a(this.a) != null) {
      xwy.a(this.a).a(xwy.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(xwy.a(this.a).size() + paramInt1, paramInt2);
    if (xwy.a(this.a) != null) {
      xwy.a(this.a).a(xwy.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(xwy.a(this.a).size() + paramInt1, paramInt2);
    if (xwy.a(this.a) != null) {
      xwy.a(this.a).a(xwy.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(xwy.a(this.a).size() + paramInt1, xwy.a(this.a).size() + paramInt2);
    if (xwy.a(this.a) != null) {
      xwy.a(this.a).a(xwy.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(xwy.a(this.a).size() + paramInt1, paramInt2);
    if (xwy.a(this.a) != null) {
      xwy.a(this.a).a(xwy.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xwz
 * JD-Core Version:    0.7.0.1
 */