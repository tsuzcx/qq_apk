import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.ark.ArkAppManagerPanel;

public class xrp
  implements xrv<ArkAppManagerPanel>
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArkAppManagerPanel jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  
  public xrp(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public boolean SC()
  {
    return false;
  }
  
  public ArkAppManagerPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  }
  
  public ArkAppManagerPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel = ((ArkAppManagerPanel)View.inflate(paramContext, 2131558744, null));
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo);
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  }
  
  public void bo() {}
  
  public void n(int paramInt1, int paramInt2) {}
  
  public int wq()
  {
    return 30;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrp
 * JD-Core Version:    0.7.0.1
 */