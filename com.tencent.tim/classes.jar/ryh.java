import android.os.Bundle;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public abstract class ryh
  extends rxq
{
  private boolean aKw = true;
  private BaseWidgetView b;
  private RecyclerView.ViewHolder g;
  
  public ryh(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public BaseWidgetView a()
  {
    return this.b;
  }
  
  protected abstract BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq);
  
  public int getItemCount()
  {
    if (this.aKw) {
      return 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.g == null)
    {
      this.b = a(paramViewGroup, this);
      paramViewGroup = new rxs.a(this, this.b);
      paramViewGroup.setIsRecyclable(false);
      getParentRecyclerView().getRecycledViewPool().setMaxRecycledViews(getGlobalViewType(paramInt), 0);
      this.g = paramViewGroup;
    }
    return this.g;
  }
  
  public void ur(boolean paramBoolean)
  {
    this.aKw = paramBoolean;
    if (getBlockMerger() != null) {
      getBlockMerger().notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryh
 * JD-Core Version:    0.7.0.1
 */