import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.activity.aio.stickerbubble.ManualDecodeGifImage;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.qphone.base.util.QLog;

public class wha
  implements Runnable
{
  public wha(StickerBubbleAnimationView paramStickerBubbleAnimationView, BitmapDrawable[] paramArrayOfBitmapDrawable, ManualDecodeGifImage paramManualDecodeGifImage, String paramString, int paramInt) {}
  
  public void run()
  {
    int j = 0;
    int i = 1;
    if (i < this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleManualDecodeGifImage.a();
      Object localObject = StickerBubbleAnimationView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleManualDecodeGifImage.a(), 0.7D);
      BitmapDrawable[] arrayOfBitmapDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
      if (localObject != null) {}
      for (localObject = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView.getResources(), (Bitmap)localObject);; localObject = null)
      {
        arrayOfBitmapDrawable[i] = localObject;
        QLog.d("StickerBubbleAnimationView", 2, "decode gif: " + i + " / " + this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleManualDecodeGifImage.c() + " / " + this.jdField_a_of_type_JavaLangString);
        if (i != this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleManualDecodeGifImage.c())
        {
          if (QLog.isColorLevel()) {
            QLog.e("StickerBubbleAnimationView", 2, "index is not matched, " + i + " / " + this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length + " / " + this.jdField_a_of_type_JavaLangString);
          }
          j = 1;
        }
        i += 1;
        break;
      }
    }
    if (j == 0) {
      StickerBubbleAnimationHelper.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wha
 * JD-Core Version:    0.7.0.1
 */