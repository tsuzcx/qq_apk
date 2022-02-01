import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqcircle.fragments.QCircleBaseAggregationFragment;

public class vlj
  implements ViewTreeObserver.OnPreDrawListener
{
  public vlj(QCircleBaseAggregationFragment paramQCircleBaseAggregationFragment, RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public boolean onPreDraw()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() > 0)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBaseAggregationFragment.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, this.b);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlj
 * JD-Core Version:    0.7.0.1
 */