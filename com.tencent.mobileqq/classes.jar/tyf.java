import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class tyf
  implements URLDrawable.URLDrawableListener
{
  private final int jdField_a_of_type_Int;
  private final URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private final String jdField_a_of_type_JavaLangString;
  private final int b;
  
  public tyf(tye paramtye, @NonNull String paramString, int paramInt1, int paramInt2, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    tye.a(this.jdField_a_of_type_Tye).remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    tye.a(this.jdField_a_of_type_Tye).remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
    urk.d("story.icon.ShareGroupIconManager", "download url failed. %s", new Object[] { this.jdField_a_of_type_JavaLangString });
    paramURLDrawable = (HashSet)tye.a(this.jdField_a_of_type_Tye).remove(this.jdField_a_of_type_JavaLangString);
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.iterator();
      while (paramURLDrawable.hasNext()) {
        ((tyi)paramURLDrawable.next()).a(this.jdField_a_of_type_JavaLangString, paramThrowable);
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    tye.a(this.jdField_a_of_type_Tye).remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
    urk.a("story.icon.ShareGroupIconManager", "download url success. %s", this.jdField_a_of_type_JavaLangString);
    Bitmap localBitmap = tye.a(this.jdField_a_of_type_Tye, paramURLDrawable, this.jdField_a_of_type_Int, this.b);
    if (localBitmap != null)
    {
      paramURLDrawable = (HashSet)tye.a(this.jdField_a_of_type_Tye).remove(this.jdField_a_of_type_JavaLangString);
      if (paramURLDrawable != null)
      {
        paramURLDrawable = paramURLDrawable.iterator();
        while (paramURLDrawable.hasNext()) {
          ((tyi)paramURLDrawable.next()).a(this.jdField_a_of_type_JavaLangString, localBitmap);
        }
      }
    }
    else
    {
      urk.e("story.icon.ShareGroupIconManager", "download url success directly. but OOM occur !");
      onLoadFialed(paramURLDrawable, new Throwable("getBitmapFromDrawable failed"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyf
 * JD-Core Version:    0.7.0.1
 */