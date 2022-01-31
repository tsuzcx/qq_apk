import android.os.Bundle;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;

public abstract class yei
  extends ydp
{
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private BaseWidgetView jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView;
  private boolean d = true;
  
  public yei(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    return 3;
  }
  
  public BaseWidgetView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView;
  }
  
  protected abstract BaseWidgetView a(ViewGroup paramViewGroup, ydp paramydp);
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (a() != null) {
      a().notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    if (this.d) {
      return 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView = a(paramViewGroup, this);
      paramViewGroup = new ydo(this, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView);
      paramViewGroup.setIsRecyclable(false);
      a().getRecycledViewPool().setMaxRecycledViews(d(paramInt), 0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewGroup;
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yei
 * JD-Core Version:    0.7.0.1
 */