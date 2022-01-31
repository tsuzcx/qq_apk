import android.graphics.drawable.StateListDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder;

public class uvc
  implements URLDrawable.URLDrawableListener
{
  public uvc(GivingHeartItemBuilder paramGivingHeartItemBuilder, StateListDrawable paramStateListDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvc
 * JD-Core Version:    0.7.0.1
 */