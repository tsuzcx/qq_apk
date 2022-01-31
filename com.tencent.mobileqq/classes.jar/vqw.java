import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.activity.aio.item.ZanCombolEffectView;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class vqw
  implements Runnable
{
  public vqw(ZanCombolEffectView paramZanCombolEffectView, Integer[] paramArrayOfInteger) {}
  
  public void run()
  {
    ZanCombolEffectView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView).clear();
    Integer[] arrayOfInteger = this.jdField_a_of_type_ArrayOfJavaLangInteger;
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInteger[i].intValue();
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView.getResources(), k);
        if (localBitmap != null) {
          ZanCombolEffectView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView).add(localBitmap);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
        if (ZanCombolEffectView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView).size() <= 0) {
          break label153;
        }
        ZanCombolEffectView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView, System.currentTimeMillis());
        ZanCombolEffectView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView, ZanCombolEffectView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView));
        ZanCombolEffectView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView, true);
        ZanCombolEffectView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView.postInvalidate();
        if (!ZanCombolEffectView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemZanCombolEffectView)) {
          break label176;
        }
        ThreadManager.postImmediately(new vqx(this), null, true);
        return;
      }
      catch (Throwable localThrowable)
      {
        label70:
        break label70;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqw
 * JD-Core Version:    0.7.0.1
 */