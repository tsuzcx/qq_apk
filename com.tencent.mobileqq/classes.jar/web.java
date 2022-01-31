import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class web
  extends RecyclerView.AdapterDataObserver
{
  web(wea paramwea) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (wea.a(this.a) != null) {
      wea.a(this.a).a(wea.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(wea.a(this.a).size() + paramInt1, paramInt2);
    if (wea.a(this.a) != null) {
      wea.a(this.a).a(wea.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(wea.a(this.a).size() + paramInt1, paramInt2);
    if (wea.a(this.a) != null) {
      wea.a(this.a).a(wea.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(wea.a(this.a).size() + paramInt1, wea.a(this.a).size() + paramInt2);
    if (wea.a(this.a) != null) {
      wea.a(this.a).a(wea.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(wea.a(this.a).size() + paramInt1, paramInt2);
    if (wea.a(this.a) != null) {
      wea.a(this.a).a(wea.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     web
 * JD-Core Version:    0.7.0.1
 */