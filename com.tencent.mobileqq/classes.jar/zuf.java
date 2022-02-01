import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class zuf
  extends RecyclerView.AdapterDataObserver
{
  zuf(zue paramzue) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (zue.a(this.a) != null) {
      zue.a(this.a).a(zue.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(zue.a(this.a).size() + paramInt1, paramInt2);
    if (zue.a(this.a) != null) {
      zue.a(this.a).a(zue.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(zue.a(this.a).size() + paramInt1, paramInt2);
    if (zue.a(this.a) != null) {
      zue.a(this.a).a(zue.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(zue.a(this.a).size() + paramInt1, zue.a(this.a).size() + paramInt2);
    if (zue.a(this.a) != null) {
      zue.a(this.a).a(zue.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(zue.a(this.a).size() + paramInt1, paramInt2);
    if (zue.a(this.a) != null) {
      zue.a(this.a).a(zue.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zuf
 * JD-Core Version:    0.7.0.1
 */