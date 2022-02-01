import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;

public class njb
  extends auwz<RecyclerView.Adapter>
{
  public njb(RecyclerViewWithHeaderFooterFix paramRecyclerViewWithHeaderFooterFix, RecyclerView.Adapter paramAdapter)
  {
    super(paramAdapter);
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    this.b.a(paramViewHolder, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njb
 * JD-Core Version:    0.7.0.1
 */