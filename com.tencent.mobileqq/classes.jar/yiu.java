import android.os.Bundle;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;

public abstract class yiu
  extends yhy
{
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private BaseWidgetView jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public yiu(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public BaseWidgetView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView;
  }
  
  protected abstract BaseWidgetView a(ViewGroup paramViewGroup, yhy paramyhy);
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (getParentAdapter() != null) {
      getParentAdapter().notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Boolean) {
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
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView = a(paramViewGroup, this);
      paramViewGroup = new yhx(this, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView);
      paramViewGroup.setIsRecyclable(false);
      getParentRecyclerView().getRecycledViewPool().setMaxRecycledViews(getGlobalViewType(paramInt), 0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewGroup;
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yiu
 * JD-Core Version:    0.7.0.1
 */