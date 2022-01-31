import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class ytl
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ytl(ytg paramytg, ImageView paramImageView) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    yyb.a().a(this.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytl
 * JD-Core Version:    0.7.0.1
 */