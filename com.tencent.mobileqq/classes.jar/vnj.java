import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class vnj
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int;
  private final QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  public RecyclerViewCompat a;
  public vlr a;
  
  public vnj(vnh paramvnh, View paramView)
  {
    super(paramView);
    paramvnh = (FrameLayout)paramView;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramvnh.getChildAt(0));
    this.jdField_a_of_type_Vlr = ((vlr)this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getAdapter());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = ((QCircleContentOperationView)paramvnh.getChildAt(1));
    this.jdField_a_of_type_Vlr.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView);
  }
  
  public RecyclerViewCompat a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  }
  
  public vlr a()
  {
    return this.jdField_a_of_type_Vlr;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnj
 * JD-Core Version:    0.7.0.1
 */