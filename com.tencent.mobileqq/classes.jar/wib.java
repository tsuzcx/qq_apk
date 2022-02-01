import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class wib<M, VH extends wia<M>>
  extends RecyclerView.Adapter<wia<M>>
{
  protected Context a;
  protected View a;
  protected why a;
  protected whz a;
  protected View b;
  
  public wib(Context paramContext)
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
  
  public final wia a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new wia(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Why != null) {
        paramViewGroup.itemView.setOnClickListener(new wic(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Whz != null) {
        paramViewGroup.itemView.setOnLongClickListener(new wid(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new wia(this.b);
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
  
  public void a(why paramwhy)
  {
    this.jdField_a_of_type_Why = paramwhy;
  }
  
  public void a(whz paramwhz)
  {
    this.jdField_a_of_type_Whz = paramwhz;
  }
  
  public final void a(wia paramwia, int paramInt)
  {
    switch (paramwia.getItemViewType())
    {
    default: 
      b(paramwia, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramwia, paramInt, getItemId(paramInt));
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
 * Qualified Name:     wib
 * JD-Core Version:    0.7.0.1
 */