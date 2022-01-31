import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;

public class vfl
  implements MessageProgressView.AnimRunnableListener
{
  public vfl(ShortVideoItemBuilder paramShortVideoItemBuilder, ShortVideoItemBuilder.Holder paramHolder) {}
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfl
 * JD-Core Version:    0.7.0.1
 */