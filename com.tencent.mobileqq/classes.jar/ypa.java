import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class ypa
  implements Runnable
{
  public ypa(SpriteUIHandler paramSpriteUIHandler, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (SpriteUIHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler).a() == null) {
        return;
      }
      XPanelContainer localXPanelContainer = (XPanelContainer)SpriteUIHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler).a().a().findViewById(2131362822);
      if (1 == this.jdField_a_of_type_Int)
      {
        if (localXPanelContainer.a() != 21) {
          return;
        }
        SpriteUIHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler).a().ai();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, localException, new Object[0]);
      return;
    }
    if (2 == this.jdField_a_of_type_Int)
    {
      BaseChatPie localBaseChatPie = SpriteUIHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler).a();
      if (localBaseChatPie != null)
      {
        ApolloPanel localApolloPanel = localBaseChatPie.a;
        if ((localApolloPanel != null) && (localApolloPanel.a() == 7))
        {
          localBaseChatPie.o(0);
          return;
        }
      }
      localException.a(21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypa
 * JD-Core Version:    0.7.0.1
 */