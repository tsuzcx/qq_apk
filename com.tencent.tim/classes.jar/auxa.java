import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.List;

class auxa
  extends RecyclerView.AdapterDataObserver
{
  auxa(auwz paramauwz) {}
  
  public void onChanged()
  {
    this.b.notifyDataSetChanged();
    if (auwz.a(this.b) != null) {
      auwz.a(this.b).b(auwz.a(this.b));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.b.notifyItemRangeChanged(auwz.a(this.b).size() + paramInt1, paramInt2);
    if (auwz.a(this.b) != null) {
      auwz.a(this.b).b(auwz.a(this.b));
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.b.notifyItemRangeChanged(auwz.a(this.b).size() + paramInt1, paramInt2, paramObject);
    if (auwz.a(this.b) != null) {
      auwz.a(this.b).b(auwz.a(this.b));
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.b.notifyItemRangeInserted(auwz.a(this.b).size() + paramInt1, paramInt2);
    if (auwz.a(this.b) != null) {
      auwz.a(this.b).b(auwz.a(this.b));
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.notifyItemMoved(auwz.a(this.b).size() + paramInt1, auwz.a(this.b).size() + paramInt2);
    if (auwz.a(this.b) != null) {
      auwz.a(this.b).b(auwz.a(this.b));
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.b.notifyItemRangeRemoved(auwz.a(this.b).size() + paramInt1, paramInt2);
    if (auwz.a(this.b) != null) {
      auwz.a(this.b).b(auwz.a(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auxa
 * JD-Core Version:    0.7.0.1
 */