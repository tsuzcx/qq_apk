import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class vnj
  implements URLDrawable.URLDrawableListener
{
  vnj(String paramString1, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    vmp.a("815", "onLoadCanceled - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841740);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    vmp.a("815", "onLoadFialed - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841740);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    vmp.a("815", "onLoadProgressed - " + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    vmp.a("815", "onLoadSuccessed - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "banner")) {
      vbt.b(2, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnj
 * JD-Core Version:    0.7.0.1
 */