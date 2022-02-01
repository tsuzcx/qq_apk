import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class rtb<T extends RecyclerView.Adapter>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final T jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private rtb.a jdField_a_of_type_Rtb$a;
  private final List<View> kd = new ArrayList();
  private final List<View> ke = new ArrayList();
  
  public rtb(T paramT)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramT;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.registerAdapterDataObserver(new rtc(this));
  }
  
  private boolean eY(int paramInt)
  {
    return (paramInt >= -1000) && (paramInt < this.kd.size() - 1000);
  }
  
  private boolean eZ(int paramInt)
  {
    return (paramInt >= -2000) && (paramInt < this.ke.size() - 2000);
  }
  
  public rtb a(rtb.a parama)
  {
    this.jdField_a_of_type_Rtb$a = parama;
    return this;
  }
  
  public void co(@NonNull View paramView)
  {
    this.kd.add(paramView);
  }
  
  public void dW(@NonNull View paramView)
  {
    this.ke.add(paramView);
  }
  
  public int getItemCount()
  {
    return this.kd.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount() + this.ke.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.kd.size()) {
      return paramInt - 1000;
    }
    if (paramInt < this.kd.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount()) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemViewType(paramInt - this.kd.size());
    }
    return paramInt - 2000 - this.kd.size() - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt < this.kd.size())
    {
      if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
        localObject1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((StaggeredGridLayoutManager.LayoutParams)localObject2).setFullSpan(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (paramInt < this.kd.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount())
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt - this.kd.size());
      }
      else
      {
        localObject1 = localObject2;
        if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
          localObject1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
          paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        ((StaggeredGridLayoutManager.LayoutParams)localObject2).setFullSpan(true);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (eY(paramInt))
    {
      paramInt = Math.abs(paramInt + 1000);
      return new rtd(this, (View)this.kd.get(paramInt));
    }
    if (eZ(paramInt))
    {
      paramInt = Math.abs(paramInt + 2000);
      return new rte(this, (View)this.ke.get(paramInt));
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void b(RecyclerView.Adapter paramAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rtb
 * JD-Core Version:    0.7.0.1
 */