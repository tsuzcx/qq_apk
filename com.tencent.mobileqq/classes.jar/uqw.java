import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class uqw
  implements URLDrawable.URLDrawableListener
{
  uqw(String paramString1, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    uqf.a("815", "onLoadCanceled - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841690);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    uqf.a("815", "onLoadFialed - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841690);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    uqf.a("815", "onLoadProgressed - " + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    uqf.a("815", "onLoadSuccessed - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "banner")) {
      uhc.b(2, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqw
 * JD-Core Version:    0.7.0.1
 */