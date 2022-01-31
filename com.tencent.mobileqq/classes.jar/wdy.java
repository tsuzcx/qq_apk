import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class wdy
  extends RecyclerView.AdapterDataObserver
{
  wdy(wdx paramwdx) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (wdx.a(this.a) != null) {
      wdx.a(this.a).a(wdx.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(wdx.a(this.a).size() + paramInt1, paramInt2);
    if (wdx.a(this.a) != null) {
      wdx.a(this.a).a(wdx.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(wdx.a(this.a).size() + paramInt1, paramInt2);
    if (wdx.a(this.a) != null) {
      wdx.a(this.a).a(wdx.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(wdx.a(this.a).size() + paramInt1, wdx.a(this.a).size() + paramInt2);
    if (wdx.a(this.a) != null) {
      wdx.a(this.a).a(wdx.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(wdx.a(this.a).size() + paramInt1, paramInt2);
    if (wdx.a(this.a) != null) {
      wdx.a(this.a).a(wdx.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wdy
 * JD-Core Version:    0.7.0.1
 */