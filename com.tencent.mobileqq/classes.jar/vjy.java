import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.io.File;

public class vjy
  implements Runnable
{
  public vjy(TroopGiftMsgItemBuilder paramTroopGiftMsgItemBuilder, BubbleImageView paramBubbleImageView, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag(2131362148).equals(this.jdField_a_of_type_JavaLangString))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(this.jdField_a_of_type_Int);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(this.jdField_a_of_type_Int);
      localObject = URLDrawable.getDrawable(new File(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int)), (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vjy
 * JD-Core Version:    0.7.0.1
 */