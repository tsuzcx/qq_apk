import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.script.SpriteActionMessage;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import java.util.concurrent.atomic.AtomicInteger;

public class yqx
  implements Runnable
{
  public yqx(ApolloPanelManager paramApolloPanelManager, ApolloInfo paramApolloInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a.get(), true, ApolloPanelManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager));
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a.get() == 0) && (!ApolloPanelManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager)) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a() != null))
    {
      SpriteActionMessage localSpriteActionMessage = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a()).a();
      if (localSpriteActionMessage != null) {
        localSpriteActionMessage.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.b);
      }
    }
    if ((ApolloPanelManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager)) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager.a.get() > 0)) {
      ApolloPanelManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager, this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqx
 * JD-Core Version:    0.7.0.1
 */