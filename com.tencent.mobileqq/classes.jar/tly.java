import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class tly
  implements URLDrawable.URLDrawableListener
{
  tly(String paramString1, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    tlo.a("815", "onLoadCanceled - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841377);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    tlo.a("815", "onLoadFialed - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841377);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    tlo.a("815", "onLoadProgressed - " + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    tlo.a("815", "onLoadSuccessed - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "banner")) {
      tfd.b(2, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tly
 * JD-Core Version:    0.7.0.1
 */