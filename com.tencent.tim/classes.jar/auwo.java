import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class auwo<M, VH extends auwn<M>>
  extends RecyclerView.Adapter<auwn<M>>
{
  protected auwm.a a;
  protected auwm.b a;
  protected View bK;
  protected Context context;
  protected View footerView;
  
  public auwo(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final auwn a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new auwn(this.bK);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Auwm$a != null) {
        paramViewGroup.itemView.setOnClickListener(new auwp(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Auwm$b != null) {
        paramViewGroup.itemView.setOnLongClickListener(new auwq(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new auwn(this.footerView);
      } else {
        paramViewGroup = b(paramViewGroup, paramInt);
      }
    }
  }
  
  public final void a(auwn paramauwn, int paramInt)
  {
    switch (paramauwn.getItemViewType())
    {
    default: 
      b(paramauwn, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramauwn, paramInt, getItemId(paramInt));
  }
  
  public void addFooterView(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the footer view is null");
      return;
    }
    this.footerView = paramView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwo
 * JD-Core Version:    0.7.0.1
 */