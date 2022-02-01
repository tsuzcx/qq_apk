import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

final class uyt
  implements URLDrawableDownListener
{
  uyt(URLDrawableDownListener paramURLDrawableDownListener, long paramLong, String paramString) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawableDownListener != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    }
    if (this.jdField_a_of_type_Long > 0L) {
      vts.a("image_load_ret", String.valueOf((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0F), "-1", this.jdField_a_of_type_JavaLangString, 5);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawableDownListener != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadSuccessed(paramView, paramURLDrawable);
    }
    if (this.jdField_a_of_type_Long > 0L) {
      vts.a("image_load_ret", String.valueOf((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0F), "0", this.jdField_a_of_type_JavaLangString, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyt
 * JD-Core Version:    0.7.0.1
 */