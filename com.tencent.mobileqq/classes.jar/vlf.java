import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class vlf
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int;
  private final QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  public RecyclerViewCompat a;
  public vjn a;
  
  public vlf(vld paramvld, View paramView)
  {
    super(paramView);
    paramvld = (FrameLayout)paramView;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramvld.getChildAt(0));
    this.jdField_a_of_type_Vjn = ((vjn)this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getAdapter());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = ((QCircleContentOperationView)paramvld.getChildAt(1));
    this.jdField_a_of_type_Vjn.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView);
  }
  
  public RecyclerViewCompat a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  }
  
  public vjn a()
  {
    return this.jdField_a_of_type_Vjn;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlf
 * JD-Core Version:    0.7.0.1
 */