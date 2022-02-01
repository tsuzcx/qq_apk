import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;
import java.util.List;

public class njc
  extends RecyclerView.RecycledViewPool
{
  public njc(RecyclerViewWithHeaderFooterFix paramRecyclerViewWithHeaderFooterFix) {}
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    Object localObject = this.b.getAdapter();
    RecyclerView.ViewHolder localViewHolder = super.getRecycledView(paramInt);
    if ((localViewHolder != null) && ((localObject instanceof auwz)))
    {
      localObject = (auwz)localObject;
      if (((auwz)localObject).eZ(paramInt))
      {
        if (!RecyclerViewWithHeaderFooterFix.a(this.b).contains(localViewHolder.itemView))
        {
          putRecycledView(localViewHolder);
          return null;
        }
      }
      else if ((((auwz)localObject).eY(paramInt)) && (!RecyclerViewWithHeaderFooterFix.b(this.b).contains(localViewHolder.itemView)))
      {
        putRecycledView(localViewHolder);
        return null;
      }
    }
    return localViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njc
 * JD-Core Version:    0.7.0.1
 */