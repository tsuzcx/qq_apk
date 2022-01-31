import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;

public class fsm
  implements Runnable
{
  public fsm(BigEmoticonViewBinder paramBigEmoticonViewBinder, ImageView paramImageView) {}
  
  public void run()
  {
    Bitmap localBitmap = EmosmUtils.getCoverBitmap(2, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fsm
 * JD-Core Version:    0.7.0.1
 */