import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;

public class uag
  extends Animation
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  private uag(QCircleExpandableTextView paramQCircleExpandableTextView, int paramInt1, int paramInt2)
  {
    setDuration(paramQCircleExpandableTextView.b);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    int i = (int)((this.b - this.jdField_a_of_type_Int) * paramFloat + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.a.setMaxHeight(i - this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.e);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.getLayoutParams().height = i;
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.requestLayout();
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uag
 * JD-Core Version:    0.7.0.1
 */