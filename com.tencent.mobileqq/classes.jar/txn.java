import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class txn
  extends RecyclerView.ViewHolder
{
  private final QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  public RecyclerViewCompat a;
  public tws a;
  
  public txn(txk paramtxk, View paramView)
  {
    super(paramView);
    paramtxk = (FrameLayout)paramView;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramtxk.getChildAt(0));
    this.jdField_a_of_type_Tws = ((tws)this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getAdapter());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = ((QCircleContentOperationView)paramtxk.getChildAt(1));
    this.jdField_a_of_type_Tws.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView);
  }
  
  public tws a()
  {
    return this.jdField_a_of_type_Tws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txn
 * JD-Core Version:    0.7.0.1
 */