import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class xdr
  implements ViewTreeObserver.OnPreDrawListener
{
  xdr(xdq paramxdq, View paramView) {}
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnPreDrawListener(this);
    xdq.a(this.jdField_a_of_type_Xdq, this.jdField_a_of_type_AndroidViewView);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xdr
 * JD-Core Version:    0.7.0.1
 */