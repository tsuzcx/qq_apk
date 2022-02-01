import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class zij
  extends RecyclerView.AdapterDataObserver
{
  zij(zii paramzii) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (zii.a(this.a) != null) {
      zii.a(this.a).a(zii.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(zii.a(this.a).size() + paramInt1, paramInt2);
    if (zii.a(this.a) != null) {
      zii.a(this.a).a(zii.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(zii.a(this.a).size() + paramInt1, paramInt2);
    if (zii.a(this.a) != null) {
      zii.a(this.a).a(zii.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(zii.a(this.a).size() + paramInt1, zii.a(this.a).size() + paramInt2);
    if (zii.a(this.a) != null) {
      zii.a(this.a).a(zii.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(zii.a(this.a).size() + paramInt1, paramInt2);
    if (zii.a(this.a) != null) {
      zii.a(this.a).a(zii.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zij
 * JD-Core Version:    0.7.0.1
 */