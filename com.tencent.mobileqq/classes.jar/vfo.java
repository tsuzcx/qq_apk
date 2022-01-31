import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class vfo
  implements DialogInterface.OnClickListener
{
  public vfo(ShortVideoItemBuilder paramShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Long);
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfo
 * JD-Core Version:    0.7.0.1
 */