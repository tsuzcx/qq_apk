import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;

class yth
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  yth(ytb paramytb, int paramInt) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_Ytb.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_Ytb.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_a_of_type_Ytb.b - this.jdField_a_of_type_Ytb.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2;
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "maxHeight = " + i);
    }
    if (this.jdField_a_of_type_Ytb.jdField_a_of_type_AndroidViewView.getMeasuredHeight() > i)
    {
      localLayoutParams.height = (i - 5);
      this.jdField_a_of_type_Ytb.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    if ((this.jdField_a_of_type_Ytb.jdField_a_of_type_Bbrz != null) && (this.jdField_a_of_type_Ytb.d) && (this.jdField_a_of_type_Ytb.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getOverScroller() != null)) {
      this.jdField_a_of_type_Ytb.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getOverScroller().a(0, 0, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yth
 * JD-Core Version:    0.7.0.1
 */