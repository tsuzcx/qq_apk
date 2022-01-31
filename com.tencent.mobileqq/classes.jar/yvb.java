import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class yvb
  implements Runnable
{
  public yvb(ApolloMsgPlayController paramApolloMsgPlayController, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (QQMessageFacade)((AppRuntime)localObject).getManager(19);
      if (localObject != null) {
        ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extStr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvb
 * JD-Core Version:    0.7.0.1
 */