import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class prq<M, VH extends prp<M>>
  extends RecyclerView.Adapter<prp<M>>
{
  protected pro.a a;
  protected pro.b a;
  protected View bK;
  protected Context context;
  protected View footerView;
  
  public prq(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final prp a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new prp(this.bK);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Pro$a != null) {
        paramViewGroup.itemView.setOnClickListener(new prr(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Pro$b != null) {
        paramViewGroup.itemView.setOnLongClickListener(new prs(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new prp(this.footerView);
      } else {
        paramViewGroup = b(paramViewGroup, paramInt);
      }
    }
  }
  
  public void a(pro.a parama)
  {
    this.jdField_a_of_type_Pro$a = parama;
  }
  
  public void a(pro.b paramb)
  {
    this.jdField_a_of_type_Pro$b = paramb;
  }
  
  public final void a(prp paramprp, int paramInt)
  {
    switch (paramprp.getItemViewType())
    {
    default: 
      b(paramprp, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramprp, paramInt, getItemId(paramInt));
  }
  
  public void addHeaderView(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the header view is null");
      return;
    }
    this.bK = paramView;
    notifyDataSetChanged();
  }
  
  public abstract VH b(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void b(VH paramVH, int paramInt);
  
  public abstract long getItemId(int paramInt);
  
  public int ss()
  {
    int i = 0;
    if (this.bK != null) {
      i = 1;
    }
    int j = i;
    if (this.footerView != null) {
      j = i + 1;
    }
    return j;
  }
  
  public int st()
  {
    if (this.bK == null) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prq
 * JD-Core Version:    0.7.0.1
 */