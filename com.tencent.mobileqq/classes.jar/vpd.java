import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class vpd
  implements Runnable
{
  vpd(vpc paramvpc) {}
  
  public void run()
  {
    Object localObject = (List)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.b.get(this.a.b);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.b.remove(this.a.b);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag(2131362148).equals(this.a.jdField_a_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(this.a.jdField_a_of_type_Int);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(this.a.jdField_a_of_type_Int);
      localObject = URLDrawable.getDrawable(new File(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int)), (URLDrawable.URLDrawableOptions)localObject);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpd
 * JD-Core Version:    0.7.0.1
 */