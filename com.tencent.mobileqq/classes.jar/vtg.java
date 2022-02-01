import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class vtg<M, VH extends vtf<M>>
  extends RecyclerView.Adapter<vtf<M>>
{
  protected Context a;
  protected View a;
  protected vtd a;
  protected vte a;
  protected View b;
  
  public vtg(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      i = 1;
    }
    int j = i;
    if (this.b != null) {
      j = i + 1;
    }
    return j;
  }
  
  public final vtf a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new vtf(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vtd != null) {
        paramViewGroup.itemView.setOnClickListener(new vth(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Vte != null) {
        paramViewGroup.itemView.setOnLongClickListener(new vti(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new vtf(this.b);
      } else {
        paramViewGroup = b(paramViewGroup, paramInt);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the header view is null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyDataSetChanged();
  }
  
  public void a(vtd paramvtd)
  {
    this.jdField_a_of_type_Vtd = paramvtd;
  }
  
  public void a(vte paramvte)
  {
    this.jdField_a_of_type_Vte = paramvte;
  }
  
  public final void a(vtf paramvtf, int paramInt)
  {
    switch (paramvtf.getItemViewType())
    {
    default: 
      b(paramvtf, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramvtf, paramInt, getItemId(paramInt));
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return 0;
    }
    return 1;
  }
  
  public abstract VH b(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void b(VH paramVH, int paramInt);
  
  public abstract long getItemId(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtg
 * JD-Core Version:    0.7.0.1
 */