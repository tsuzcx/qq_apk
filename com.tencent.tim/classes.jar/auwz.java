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

public class auwz<T extends RecyclerView.Adapter>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final T jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private auwz.a jdField_a_of_type_Auwz$a;
  private auwz.b jdField_a_of_type_Auwz$b;
  private final List<View> kd = new ArrayList();
  private final List<View> ke = new ArrayList();
  
  public auwz(T paramT)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramT;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.registerAdapterDataObserver(new auxa(this));
  }
  
  public boolean W(View paramView)
  {
    return this.kd.contains(paramView);
  }
  
  public T a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  }
  
  public auwz a(auwz.a parama)
  {
    this.jdField_a_of_type_Auwz$a = parama;
    return this;
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Auwz$b != null) {
      this.jdField_a_of_type_Auwz$b.a(paramViewHolder, paramInt);
    }
  }
  
  public void co(@NonNull View paramView)
  {
    this.kd.add(paramView);
  }
  
  public void cp(@NonNull View paramView)
  {
    this.kd.remove(paramView);
  }
  
  public void dW(@NonNull View paramView)
  {
    this.ke.add(paramView);
  }
  
  public boolean eY(int paramInt)
  {
    return (paramInt >= -1000) && (paramInt < this.kd.size() - 1000);
  }
  
  public boolean eZ(int paramInt)
  {
    return (paramInt >= -2000) && (paramInt < this.ke.size() - 2000);
  }
  
  public int getItemCount()
  {
    return this.kd.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount() + this.ke.size();
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt < this.kd.size()) {
      return ((View)this.kd.get(paramInt)).hashCode();
    }
    if (paramInt < this.kd.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount()) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemId(paramInt - this.kd.size());
    }
    return ((View)this.ke.get(paramInt - this.kd.size() - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount())).hashCode();
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
  
  public boolean ni(int paramInt)
  {
    return paramInt < this.kd.size();
  }
  
  public boolean nj(int paramInt)
  {
    return paramInt >= getItemCount() - this.ke.size();
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
      a(paramViewHolder, paramInt);
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
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    if (paramInt < this.kd.size()) {
      super.onBindViewHolder(paramViewHolder, paramInt, paramList);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, paramList, getItemId(paramInt));
      return;
      if (paramInt < this.kd.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount()) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt - this.kd.size(), paramList);
      } else {
        super.onBindViewHolder(paramViewHolder, paramInt, paramList);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (eY(paramInt))
    {
      paramInt = Math.abs(paramInt + 1000);
      return new auxb(this, (View)this.kd.get(paramInt));
    }
    if (eZ(paramInt))
    {
      paramInt = Math.abs(paramInt + 2000);
      return new auxc(this, (View)this.ke.get(paramInt));
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter != null) && ((paramViewHolder instanceof auwn))) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onViewAttachedToWindow(paramViewHolder);
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter != null) && ((paramViewHolder instanceof auwn))) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onViewDetachedFromWindow(paramViewHolder);
    }
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter != null) && ((paramViewHolder instanceof auwn))) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onViewRecycled(paramViewHolder);
    }
  }
  
  public int rl()
  {
    return this.kd.size();
  }
  
  public void setOnBindHeaderObserver(auwz.b paramb)
  {
    this.jdField_a_of_type_Auwz$b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void b(RecyclerView.Adapter paramAdapter);
  }
  
  public static abstract interface b
  {
    public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwz
 * JD-Core Version:    0.7.0.1
 */