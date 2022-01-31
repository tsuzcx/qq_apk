import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class yti
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  yti(ytd paramytd, ImageView paramImageView) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    yxy.a().a(this.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yti
 * JD-Core Version:    0.7.0.1
 */