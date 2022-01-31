import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloManager.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class tmq
  implements Runnable
{
  private WeakReference a;
  public boolean a;
  
  public tmq(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQSettingMe);
  }
  
  public void run()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    QQSettingMe localQQSettingMe;
    do
    {
      return;
      localQQSettingMe = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localQQSettingMe.jdField_a_of_type_AndroidOsHandler == null));
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = ((ApolloManager)localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int i;
    if (localObject3 != null)
    {
      localQQSettingMe.d = ((ApolloBaseInfo)localObject3).apolloStatus;
      localObject2 = ((ApolloBaseInfo)localObject3).getApolloDress();
      if (localObject2 == null) {
        break label340;
      }
      i = ((ApolloDress)localObject2).jdField_a_of_type_Int;
      localObject1 = ((ApolloDress)localObject2).a();
    }
    for (;;)
    {
      localObject2 = localObject1;
      int j = i;
      if (((ApolloBaseInfo)localObject3).apolloLocalTS != ((ApolloBaseInfo)localObject3).apolloServerTS)
      {
        ((VasExtensionHandler)localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a("qqSettingMe");
        j = i;
        localObject2 = localObject1;
      }
      label165:
      if ((j <= 0) || (localObject2 == null) || (localObject2.length <= 0) || (localQQSettingMe.d != 1) || ((j > 0) && (localObject2 != null) && (!ApolloActionHelper.a(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), j, (int[])localObject2, localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))) {
        bool = true;
      }
      for (;;)
      {
        if (ApolloActionHelper.a(localQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11)) {
          break label272;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("QQSettingRedesign", 2, "checkDrawerBasicApolloAction up and down not ready");
        return;
        localQQSettingMe.d = 0;
        j = 0;
        break label165;
        if (!ApolloEngine.a()) {
          bool = true;
        }
      }
      label272:
      localObject1 = new ApolloManager.CheckApolloInfoResult();
      localObject3 = localQQSettingMe.jdField_a_of_type_AndroidOsHandler.obtainMessage(65536);
      ((Message)localObject3).obj = localObject1;
      ((ApolloManager.CheckApolloInfoResult)localObject1).jdField_a_of_type_Int = j;
      ((ApolloManager.CheckApolloInfoResult)localObject1).jdField_a_of_type_Boolean = bool;
      ((ApolloManager.CheckApolloInfoResult)localObject1).jdField_a_of_type_ArrayOfInt = ((int[])localObject2);
      ((ApolloManager.CheckApolloInfoResult)localObject1).b = this.jdField_a_of_type_Boolean;
      localQQSettingMe.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
      return;
      label340:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmq
 * JD-Core Version:    0.7.0.1
 */