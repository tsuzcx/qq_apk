import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.task.ApolloAioBubblePush;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zbq
  implements Runnable
{
  public zbq(ApolloAioBubblePush paramApolloAioBubblePush, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    Object localObject2 = localApolloManager.a(4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localApolloManager.a(3);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = localApolloManager.a(2);
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localApolloManager.a(7);
      localApolloManager.n = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAioBubblePush", 2, new Object[] { "[onEnterAIO] pushItem:", ApolloAioBubblePush.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush) });
    }
    if ((localObject1 == null) || (((DrawerPushItem)localObject1).show_sum < ((DrawerPushItem)localObject1).show_counts)) {
      ApolloAioBubblePush.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush, (DrawerPushItem)localObject1);
    }
    ApolloAioBubblePush.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zbq
 * JD-Core Version:    0.7.0.1
 */