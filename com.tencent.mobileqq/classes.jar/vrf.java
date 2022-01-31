import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class vrf
  extends RecyclerView.AdapterDataObserver
{
  vrf(vre paramvre) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (vre.a(this.a) != null) {
      vre.a(this.a).a(vre.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(vre.a(this.a).size() + paramInt1, paramInt2);
    if (vre.a(this.a) != null) {
      vre.a(this.a).a(vre.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(vre.a(this.a).size() + paramInt1, paramInt2);
    if (vre.a(this.a) != null) {
      vre.a(this.a).a(vre.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(vre.a(this.a).size() + paramInt1, vre.a(this.a).size() + paramInt2);
    if (vre.a(this.a) != null) {
      vre.a(this.a).a(vre.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(vre.a(this.a).size() + paramInt1, paramInt2);
    if (vre.a(this.a) != null) {
      vre.a(this.a).a(vre.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrf
 * JD-Core Version:    0.7.0.1
 */