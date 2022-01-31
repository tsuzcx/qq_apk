import com.tencent.mobileqq.apollo.ApolloPushManager;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPush;

public class yva
  implements Runnable
{
  public yva(ApolloMsgPlayController paramApolloMsgPlayController, QQAppInterface paramQQAppInterface, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((ApolloPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(226)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yva
 * JD-Core Version:    0.7.0.1
 */