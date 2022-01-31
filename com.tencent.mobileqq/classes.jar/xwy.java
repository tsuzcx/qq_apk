import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class xwy<T extends RecyclerView.Adapter>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final T jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private final List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xxc jdField_a_of_type_Xxc;
  private final List<View> b = new ArrayList();
  
  public xwy(T paramT)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramT;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.registerAdapterDataObserver(new xwz(this));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt >= -1000) && (paramInt < this.jdField_a_of_type_JavaUtilList.size() - 1000);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt >= -2000) && (paramInt < this.b.size() - 2000);
  }
  
  public xwy a(xxc paramxxc)
  {
    this.jdField_a_of_type_Xxc = paramxxc;
    return this;
  }
  
  public void a(@NonNull View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramView);
  }
  
  public void b(@NonNull View paramView)
  {
    this.b.add(paramView);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount() + this.b.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return paramInt - 1000;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount()) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemViewType(paramInt - this.jdField_a_of_type_JavaUtilList.size());
    }
    return paramInt - 2000 - this.jdField_a_of_type_JavaUtilList.size() - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
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
      return;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount())
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt - this.jdField_a_of_type_JavaUtilList.size());
      return;
    }
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
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (a(paramInt))
    {
      paramInt = Math.abs(paramInt + 1000);
      return new xxa(this, (View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    if (b(paramInt))
    {
      paramInt = Math.abs(paramInt + 2000);
      return new xxb(this, (View)this.b.get(paramInt));
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xwy
 * JD-Core Version:    0.7.0.1
 */