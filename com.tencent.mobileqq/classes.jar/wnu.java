import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class wnu<M, VH extends wnt<M>>
  extends RecyclerView.Adapter<wnt<M>>
{
  protected Context a;
  protected View a;
  protected wnr a;
  protected wns a;
  protected View b;
  
  public wnu(Context paramContext)
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
  
  public final wnt a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new wnt(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Wnr != null) {
        paramViewGroup.itemView.setOnClickListener(new wnv(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Wns != null) {
        paramViewGroup.itemView.setOnLongClickListener(new wnw(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new wnt(this.b);
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
  
  public void a(wnr paramwnr)
  {
    this.jdField_a_of_type_Wnr = paramwnr;
  }
  
  public void a(wns paramwns)
  {
    this.jdField_a_of_type_Wns = paramwns;
  }
  
  public final void a(wnt paramwnt, int paramInt)
  {
    switch (paramwnt.getItemViewType())
    {
    default: 
      b(paramwnt, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramwnt, paramInt, getItemId(paramInt));
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
 * Qualified Name:     wnu
 * JD-Core Version:    0.7.0.1
 */