import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class ykk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ykk(ykf paramykf, ImageView paramImageView) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    yoi.a().a(this.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ykk
 * JD-Core Version:    0.7.0.1
 */