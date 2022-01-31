import com.tencent.mobileqq.apollo.ApolloPushManager;
import com.tencent.mobileqq.apollo.ApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.data.ApolloActionPush;
import mqq.util.WeakReference;

public class yra
  implements Runnable
{
  public yra(ApolloPushManager paramApolloPushManager, int paramInt, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    if (ApolloPushManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPushManager) != null)
    {
      ApolloPushManager.OnActionPushListener localOnActionPushListener = (ApolloPushManager.OnActionPushListener)ApolloPushManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPushManager).get();
      if (localOnActionPushListener != null) {
        localOnActionPushListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yra
 * JD-Core Version:    0.7.0.1
 */