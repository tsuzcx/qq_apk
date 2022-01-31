import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloPushManager;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPush;

public class yhq
  implements Runnable
{
  public yhq(ApolloPushManager paramApolloPushManager, ApolloActionPush paramApolloActionPush, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface;
    SpriteTaskParam localSpriteTaskParam;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam != null))
    {
      localQQAppInterface = ApolloPushManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPushManager);
      localSpriteTaskParam = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush.mContent)) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      ApolloActionHelper.a(localQQAppInterface, localSpriteTaskParam, bool, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.b);
      if ((ApolloPushManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPushManager) != null) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush != null)) {
        ((ApolloDaoManager)ApolloPushManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPushManager).getManager(154)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush.mId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhq
 * JD-Core Version:    0.7.0.1
 */