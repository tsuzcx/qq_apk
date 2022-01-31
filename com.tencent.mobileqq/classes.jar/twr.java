import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;

public class twr
  implements ViewTreeObserver.OnPreDrawListener
{
  public twr(QCircleBaseTabFragment paramQCircleBaseTabFragment, RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public boolean onPreDraw()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() > 0)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBaseTabFragment.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, this.b);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twr
 * JD-Core Version:    0.7.0.1
 */