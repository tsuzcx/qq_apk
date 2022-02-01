import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import rx.functions.Func1;

final class vni
  implements Func1<String, URLDrawable>
{
  vni(String paramString, Drawable paramDrawable) {}
  
  public URLDrawable a(String paramString)
  {
    if (vnd.a(this.jdField_a_of_type_JavaLangString) == null) {
      throw new RuntimeException("string2URL error");
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vni
 * JD-Core Version:    0.7.0.1
 */