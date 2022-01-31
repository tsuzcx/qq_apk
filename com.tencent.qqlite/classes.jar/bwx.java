import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.utils.FileUtils;

public class bwx
  implements DialogInterface.OnClickListener
{
  public bwx(ShortVideoItemBuilder paramShortVideoItemBuilder, String paramString, ShortVideoItemBuilder.Holder paramHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FileUtils.d(this.jdField_a_of_type_JavaLangString);
    if (ShortVideoItemBuilder.Holder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder) != null) {
      ShortVideoItemBuilder.Holder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder).setImageResource(2130839175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bwx
 * JD-Core Version:    0.7.0.1
 */