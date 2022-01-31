import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class afj
  implements URLDrawable.URLDrawableListener
{
  public afj(ChatSettingForTroop paramChatSettingForTroop, ImageView paramImageView, URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afj
 * JD-Core Version:    0.7.0.1
 */