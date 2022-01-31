import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;

public class deb
  implements Runnable
{
  public deb(BigEmoticonViewBinder paramBigEmoticonViewBinder, ImageView paramImageView) {}
  
  public void run()
  {
    Bitmap localBitmap = EmosmUtils.getCoverBitmap(2, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder.jdField_a_of_type_AndroidContentContext != null) && (localBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     deb
 * JD-Core Version:    0.7.0.1
 */