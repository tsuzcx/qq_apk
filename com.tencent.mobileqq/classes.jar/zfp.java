import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.qphone.base.util.QLog;

public class zfp
  implements Runnable
{
  public zfp(ApolloPanel paramApolloPanel, ApolloActionPackage paramApolloActionPackage) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[checkRedTab] clear new action info");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a != null))
    {
      ApolloDaoManager localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a.getManager(154);
      if (localApolloDaoManager != null) {
        localApolloDaoManager.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPackage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zfp
 * JD-Core Version:    0.7.0.1
 */