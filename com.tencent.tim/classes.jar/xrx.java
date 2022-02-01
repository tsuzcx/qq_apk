import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;

public class xrx
  implements xrv<PokeAndEmoPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private PokeAndEmoPanel jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  
  xrx(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public boolean SC()
  {
    return false;
  }
  
  public PokeAndEmoPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  }
  
  public PokeAndEmoPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel = ((PokeAndEmoPanel)View.inflate(paramContext, 2131558677, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  }
  
  public void bo() {}
  
  public void n(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.onShow();
    }
    if ((paramInt1 == 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.onHide();
    }
  }
  
  public int wq()
  {
    return 23;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrx
 * JD-Core Version:    0.7.0.1
 */