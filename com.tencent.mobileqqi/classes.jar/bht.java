import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public final class bht
  implements Runnable
{
  public void run()
  {
    int i = ImageUtil.a(ImageUtil.c, ImageUtil.d, ImageUtil.e);
    if (QLog.isColorLevel()) {
      QLog.i(ImageUtil.b, 2, "type:" + i);
    }
    if (!TextUtils.isEmpty(ImageUtil.c)) {
      ImageUtil.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(ImageUtil.c);
    }
    Object localObject2;
    switch (i)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = ImageUtil.a((Bitmap)localObject1);
        ((Bitmap)localObject1).recycle();
      }
      break;
    }
    for (Object localObject1 = localObject2;; localObject1 = "")
    {
      if (ImageUtil.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        ImageUtil.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        ImageUtil.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      localObject2 = ImageUtil.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((Message)localObject2).arg1 = 0;
        ((Message)localObject2).obj = localObject1;
      }
      for (;;)
      {
        ImageUtil.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        ImageUtil.jdField_a_of_type_AndroidOsHandler.removeCallbacks(ImageUtil.jdField_a_of_type_JavaLangRunnable);
        return;
        localObject1 = ImageUtil.a(ImageUtil.jdField_a_of_type_AndroidGraphicsBitmap);
        break;
        localObject1 = ImageUtil.b(ImageUtil.jdField_a_of_type_AndroidGraphicsBitmap);
        break;
        localObject1 = ImageUtil.a();
        break;
        ((Message)localObject2).arg1 = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bht
 * JD-Core Version:    0.7.0.1
 */