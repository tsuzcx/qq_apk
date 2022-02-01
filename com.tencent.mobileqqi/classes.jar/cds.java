import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class cds
  implements URLDrawable.URLDrawableListener
{
  public cds(ChatSettingForTroop paramChatSettingForTroop, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    try
    {
      paramURLDrawable = ImageUtil.a(paramURLDrawable);
      if (paramURLDrawable != null)
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.b.a(paramURLDrawable, paramURLDrawable.getWidth(), paramURLDrawable.getHeight());
        paramURLDrawable.recycle();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
      return;
    }
    catch (NullPointerException paramURLDrawable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.chatopttroop", 2, QLog.getStackTraceString(paramURLDrawable));
      return;
    }
    catch (OutOfMemoryError paramURLDrawable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cds
 * JD-Core Version:    0.7.0.1
 */