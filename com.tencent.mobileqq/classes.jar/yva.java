import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class yva
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  yva(yuw paramyuw, ViewGroup paramViewGroup, View paramView) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    yxp.a("GdtMotiveVideoDialog", "onGlobalLayout: l=" + this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + ",t=" + this.jdField_a_of_type_AndroidViewViewGroup.getTop() + ",r=" + this.jdField_a_of_type_AndroidViewViewGroup.getRight() + ",b=" + this.jdField_a_of_type_AndroidViewViewGroup.getBottom());
    yxp.a("GdtMotiveVideoDialog", "onGlobalLayout: " + this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yva
 * JD-Core Version:    0.7.0.1
 */