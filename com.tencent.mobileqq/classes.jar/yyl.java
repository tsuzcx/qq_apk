import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.script.SpriteActionMessage;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class yyl
  implements Runnable
{
  public yyl(SpriteActionMessage paramSpriteActionMessage, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((SpriteActionMessage.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage) != null) && (SpriteActionMessage.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage).a() != null))
    {
      ApolloPanelManager localApolloPanelManager = ((ApolloManager)SpriteActionMessage.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage).a().getManager(152)).a();
      if (localApolloPanelManager != null)
      {
        localApolloPanelManager.a.set(this.jdField_a_of_type_Int);
        localApolloPanelManager.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yyl
 * JD-Core Version:    0.7.0.1
 */