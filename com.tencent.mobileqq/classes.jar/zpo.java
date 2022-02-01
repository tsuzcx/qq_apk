import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import java.util.ArrayList;

public abstract class zpo
  extends zou
{
  private BaseWidgetView a;
  private boolean c = true;
  
  public zpo(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    return 3;
  }
  
  protected abstract BaseWidgetView a(ViewGroup paramViewGroup, zou paramzou);
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
    if (paramArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.c) {
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
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView == null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView = a(paramViewGroup, this);
    }
    return new zoy(this, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpo
 * JD-Core Version:    0.7.0.1
 */