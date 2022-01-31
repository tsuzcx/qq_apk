import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

public class abc
  implements Runnable
{
  private ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  
  public abc(BaseChatPie paramBaseChatPie, ExtensionInfo paramExtensionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = paramExtensionInfo;
  }
  
  public void run()
  {
    ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(43)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     abc
 * JD-Core Version:    0.7.0.1
 */