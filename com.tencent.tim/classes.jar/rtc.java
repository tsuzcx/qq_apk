import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class rtc
  extends RecyclerView.AdapterDataObserver
{
  rtc(rtb paramrtb) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
    if (rtb.a(this.a) != null) {
      rtb.a(this.a).b(rtb.a(this.a));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeChanged(rtb.a(this.a).size() + paramInt1, paramInt2);
    if (rtb.a(this.a) != null) {
      rtb.a(this.a).b(rtb.a(this.a));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(rtb.a(this.a).size() + paramInt1, paramInt2);
    if (rtb.a(this.a) != null) {
      rtb.a(this.a).b(rtb.a(this.a));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.notifyItemMoved(rtb.a(this.a).size() + paramInt1, rtb.a(this.a).size() + paramInt2);
    if (rtb.a(this.a) != null) {
      rtb.a(this.a).b(rtb.a(this.a));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(rtb.a(this.a).size() + paramInt1, paramInt2);
    if (rtb.a(this.a) != null) {
      rtb.a(this.a).b(rtb.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rtc
 * JD-Core Version:    0.7.0.1
 */