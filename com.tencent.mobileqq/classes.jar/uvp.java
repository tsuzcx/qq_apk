import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

public class uvp
  implements Runnable
{
  int jdField_a_of_type_Int;
  Resources jdField_a_of_type_AndroidContentResResources;
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  int b;
  
  public uvp(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable, int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(Resources paramResources)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  public void run()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
    if (CustomFrameAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable).size() > 0) {}
    Object localObject;
    for (Bitmap localBitmap1 = (Bitmap)CustomFrameAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable).remove(0);; localObject = null)
    {
      if ((localBitmap1 != null) && (!localBitmap1.isRecycled()) && (CustomFrameAnimationDrawable.a())) {
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = localBitmap1;
      }
      if (this.b != 0) {}
      for (;;)
      {
        Bitmap localBitmap2;
        try
        {
          localBitmap1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentResResources, this.b);
          if (localBitmap1 != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localBitmap1);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a = null;
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError1.toString());
          }
          localBitmap2 = null;
          continue;
        }
        if (this.jdField_a_of_type_JavaLangString != null) {
          try
          {
            localBitmap2 = ImageUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError2.toString());
            }
          }
        } else {
          localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvp
 * JD-Core Version:    0.7.0.1
 */