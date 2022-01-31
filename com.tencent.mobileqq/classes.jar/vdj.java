import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;

public class vdj
  implements MessageProgressView.AnimRunnableListener
{
  public vdj(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, ShortVideoRealItemBuilder.Holder paramHolder) {}
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdj
 * JD-Core Version:    0.7.0.1
 */