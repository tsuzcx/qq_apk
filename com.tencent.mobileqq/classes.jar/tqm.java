import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import java.util.ArrayList;
import java.util.List;

final class tqm
  implements URLDrawableDownListener
{
  tqm(URLDrawableDownListener paramURLDrawableDownListener, long paramLong, String paramString) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawableDownListener != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      double d = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0F;
      paramView = new ArrayList();
      paramView.add(tzy.a("time_cost", String.valueOf(d)));
      paramView.add(tzy.a("ret_code", "-1"));
      paramView.add(tzy.a("url", this.jdField_a_of_type_JavaLangString));
      tzx.a("image_load_ret", paramView, true);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawableDownListener != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadSuccessed(paramView, paramURLDrawable);
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      double d = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0F;
      paramView = new ArrayList();
      paramView.add(tzy.a("time_cost", String.valueOf(d)));
      paramView.add(tzy.a("ret_code", "0"));
      paramView.add(tzy.a("url", this.jdField_a_of_type_JavaLangString));
      tzx.a("image_load_ret", paramView, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqm
 * JD-Core Version:    0.7.0.1
 */