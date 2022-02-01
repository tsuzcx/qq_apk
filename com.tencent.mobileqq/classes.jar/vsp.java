import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayoutItemView;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleTagFlowLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vsp
  implements View.OnClickListener
{
  public vsp(QCircleTagFlowLayout paramQCircleTagFlowLayout, QCircleFlowLayoutItemView paramQCircleFlowLayoutItemView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    QCircleTagFlowLayout.a(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeFlowlayoutQCircleTagFlowLayout, this.jdField_a_of_type_ComTencentBizQqcirclePolylikeFlowlayoutQCircleFlowLayoutItemView, this.jdField_a_of_type_Int);
    if (QCircleTagFlowLayout.a(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeFlowlayoutQCircleTagFlowLayout) != null) {
      QCircleTagFlowLayout.a(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeFlowlayoutQCircleTagFlowLayout).a(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeFlowlayoutQCircleFlowLayoutItemView, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqcirclePolylikeFlowlayoutQCircleTagFlowLayout);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsp
 * JD-Core Version:    0.7.0.1
 */