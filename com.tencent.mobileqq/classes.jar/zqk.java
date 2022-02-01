import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class zqk
  extends RecyclerView.AdapterDataObserver
{
  zqk(zqj paramzqj) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (zqj.a(this.a) != null) {
      zqj.a(this.a).a(zqj.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(zqj.a(this.a).size() + paramInt1, paramInt2);
    if (zqj.a(this.a) != null) {
      zqj.a(this.a).a(zqj.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(zqj.a(this.a).size() + paramInt1, paramInt2);
    if (zqj.a(this.a) != null) {
      zqj.a(this.a).a(zqj.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(zqj.a(this.a).size() + paramInt1, zqj.a(this.a).size() + paramInt2);
    if (zqj.a(this.a) != null) {
      zqj.a(this.a).a(zqj.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(zqj.a(this.a).size() + paramInt1, paramInt2);
    if (zqj.a(this.a) != null) {
      zqj.a(this.a).a(zqj.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqk
 * JD-Core Version:    0.7.0.1
 */