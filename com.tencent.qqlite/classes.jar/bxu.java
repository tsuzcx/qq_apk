import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.utils.FileUtils;

public class bxu
  implements DialogInterface.OnClickListener
{
  public bxu(ShortVideoItemBuilder paramShortVideoItemBuilder, String paramString, ShortVideoItemBuilder.Holder paramHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FileUtils.d(this.jdField_a_of_type_JavaLangString);
    if (ShortVideoItemBuilder.Holder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder) != null) {
      ShortVideoItemBuilder.Holder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder).setImageResource(2130839177);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bxu
 * JD-Core Version:    0.7.0.1
 */