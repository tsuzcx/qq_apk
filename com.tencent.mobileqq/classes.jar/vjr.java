import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;

public class vjr
  implements Runnable
{
  public vjr(TroopFileItemBuilder paramTroopFileItemBuilder, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder.a.a().b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder.b.post(new vjs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vjr
 * JD-Core Version:    0.7.0.1
 */