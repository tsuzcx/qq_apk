import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class wrp<M, VH extends wro<M>>
  extends RecyclerView.Adapter<wro<M>>
{
  protected Context a;
  protected View a;
  protected wrm a;
  protected wrn a;
  protected View b;
  
  public wrp(Context paramContext)
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
  
  public final wro a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new wro(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Wrm != null) {
        paramViewGroup.itemView.setOnClickListener(new wrq(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Wrn != null) {
        paramViewGroup.itemView.setOnLongClickListener(new wrr(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new wro(this.b);
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
  
  public void a(wrm paramwrm)
  {
    this.jdField_a_of_type_Wrm = paramwrm;
  }
  
  public void a(wrn paramwrn)
  {
    this.jdField_a_of_type_Wrn = paramwrn;
  }
  
  public final void a(wro paramwro, int paramInt)
  {
    switch (paramwro.getItemViewType())
    {
    default: 
      b(paramwro, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramwro, paramInt, getItemId(paramInt));
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
 * Qualified Name:     wrp
 * JD-Core Version:    0.7.0.1
 */