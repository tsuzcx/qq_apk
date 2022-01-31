import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.component.extendsadapter.ComponentRvInnerView;

public class wpu
  extends wpa
{
  public wpu(ComponentRvInnerView paramComponentRvInnerView) {}
  
  public wpt a(ViewGroup paramViewGroup, int paramInt)
  {
    if (ComponentRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribeComponentExtendsadapterComponentRvInnerView) != null) {
      return ComponentRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribeComponentExtendsadapterComponentRvInnerView).a(paramViewGroup, paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    if (ComponentRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribeComponentExtendsadapterComponentRvInnerView) != null) {
      return ComponentRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribeComponentExtendsadapterComponentRvInnerView).b();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((!bfmh.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) && (ComponentRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribeComponentExtendsadapterComponentRvInnerView) != null)) {
      ComponentRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribeComponentExtendsadapterComponentRvInnerView).a(paramViewHolder, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wpu
 * JD-Core Version:    0.7.0.1
 */