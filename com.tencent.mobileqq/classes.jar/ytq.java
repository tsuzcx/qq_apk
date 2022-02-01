import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class ytq
  extends RecyclerView.AdapterDataObserver
{
  ytq(ytp paramytp) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (ytp.a(this.a) != null) {
      ytp.a(this.a).a(ytp.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(ytp.a(this.a).size() + paramInt1, paramInt2);
    if (ytp.a(this.a) != null) {
      ytp.a(this.a).a(ytp.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(ytp.a(this.a).size() + paramInt1, paramInt2);
    if (ytp.a(this.a) != null) {
      ytp.a(this.a).a(ytp.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(ytp.a(this.a).size() + paramInt1, ytp.a(this.a).size() + paramInt2);
    if (ytp.a(this.a) != null) {
      ytp.a(this.a).a(ytp.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(ytp.a(this.a).size() + paramInt1, paramInt2);
    if (ytp.a(this.a) != null) {
      ytp.a(this.a).a(ytp.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytq
 * JD-Core Version:    0.7.0.1
 */