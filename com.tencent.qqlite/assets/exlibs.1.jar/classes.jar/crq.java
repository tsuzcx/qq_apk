import com.tencent.mobileqq.app.ChatBackgroundManagerImp;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import java.util.ArrayList;

public class crq
  implements Runnable
{
  public crq(ChatBackgroundManagerImp paramChatBackgroundManagerImp, ChatBackgroundInfo paramChatBackgroundInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatBackgroundInfo != null)
    {
      ChatBackgroundManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppChatBackgroundManagerImp).add(this.jdField_a_of_type_ComTencentMobileqqDataChatBackgroundInfo);
      ChatBackgroundManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppChatBackgroundManagerImp, this.jdField_a_of_type_ComTencentMobileqqDataChatBackgroundInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     crq
 * JD-Core Version:    0.7.0.1
 */