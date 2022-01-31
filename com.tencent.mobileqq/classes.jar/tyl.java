import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class tyl
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int;
  private final QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  public RecyclerViewCompat a;
  public txj a;
  
  public tyl(tyj paramtyj, View paramView)
  {
    super(paramView);
    paramtyj = (FrameLayout)paramView;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramtyj.getChildAt(0));
    this.jdField_a_of_type_Txj = ((txj)this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getAdapter());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = ((QCircleContentOperationView)paramtyj.getChildAt(1));
    this.jdField_a_of_type_Txj.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView);
  }
  
  public RecyclerViewCompat a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  }
  
  public txj a()
  {
    return this.jdField_a_of_type_Txj;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyl
 * JD-Core Version:    0.7.0.1
 */