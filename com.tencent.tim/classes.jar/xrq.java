import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;
import com.tencent.mobileqq.app.QQAppInterface;

public class xrq
  implements xrv<HongBaoPanel>
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private HongBaoPanel jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  private final QQAppInterface app;
  
  public xrq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.app = paramBaseChatPie.app;
  }
  
  public boolean SC()
  {
    return false;
  }
  
  public HongBaoPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  }
  
  public HongBaoPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel = ((HongBaoPanel)View.inflate(paramContext, 2131560682, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel.init(this.app, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  }
  
  public void bo() {}
  
  public void n(int paramInt1, int paramInt2) {}
  
  public int wq()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrq
 * JD-Core Version:    0.7.0.1
 */