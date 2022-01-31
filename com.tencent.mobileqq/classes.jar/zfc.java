import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.view.ApolloMainViewBinder;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class zfc
  extends IResDownloadListener
{
  public zfc(ApolloPanel paramApolloPanel) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "tab download Done");
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "action res done. action=" + paramApolloActionData.actionId);
    }
    this.a.a(paramApolloActionData);
  }
  
  public void a(Boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null)) {}
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        do
        {
          return;
          localMqqHandler = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getHandler(ChatActivity.class);
        } while (localMqqHandler == null);
        localMqqHandler.post(new zfd(this));
        if (!paramBoolean.booleanValue()) {
          break;
        }
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getCurrentAccountUin());
      } while (this.a.c == null);
      this.a.c.clear();
      this.a.d(this.a.b(ApolloPanel.jdField_a_of_type_Int));
      return;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder == null) || (this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.c != 3));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onJsonDone in panel fail refresh panel");
    }
    localMqqHandler.post(new zfe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zfc
 * JD-Core Version:    0.7.0.1
 */