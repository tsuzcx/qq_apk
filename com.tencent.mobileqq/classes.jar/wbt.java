import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.activity.aio.stickerbubble.ManualDecodeGifImage;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class wbt
  implements Runnable
{
  public wbt(StickerBubbleAnimationView paramStickerBubbleAnimationView, String paramString) {}
  
  public void run()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    if (((File)localObject).exists()) {
      try
      {
        ManualDecodeGifImage localManualDecodeGifImage = new ManualDecodeGifImage((File)localObject, false);
        StickerBubbleAnimationView.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView).put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(localManualDecodeGifImage.a()));
        BitmapDrawable[] arrayOfBitmapDrawable = new BitmapDrawable[localManualDecodeGifImage.b()];
        localObject = StickerBubbleAnimationView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView, localManualDecodeGifImage.a(), 0.7D);
        Resources localResources = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.getResources();
        if (localObject != null) {}
        for (;;)
        {
          arrayOfBitmapDrawable[0] = new BitmapDrawable(localResources, (Bitmap)localObject);
          StickerBubbleAnimationView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView, localManualDecodeGifImage, arrayOfBitmapDrawable, this.jdField_a_of_type_JavaLangString, localManualDecodeGifImage.a());
          StickerBubbleAnimationView.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView).put(this.jdField_a_of_type_JavaLangString, arrayOfBitmapDrawable);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StickerBubbleAnimationView", 2, "decoded first frame of gif: " + this.jdField_a_of_type_JavaLangString);
          return;
          localObject = localManualDecodeGifImage.a();
        }
        QLog.e("StickerBubbleAnimationView", 1, "gifFile " + this.jdField_a_of_type_JavaLangString + " is not exist");
      }
      catch (IOException localIOException)
      {
        QLog.e("StickerBubbleAnimationView", 1, "decode gif fail: " + localIOException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("StickerBubbleAnimationView", 1, "oom when decode gif or scale first frame, " + localOutOfMemoryError);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbt
 * JD-Core Version:    0.7.0.1
 */