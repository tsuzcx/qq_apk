import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.gameparty.GamePartyObserver;

public class vxw
  extends GamePartyObserver
{
  public vxw(TroopChatPie paramTroopChatPie) {}
  
  protected void a()
  {
    if (((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      TroopChatPie.b(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar, new Object[0]);
    }
  }
  
  protected void b()
  {
    if (((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar.a();
    }
  }
  
  protected void c()
  {
    if ((((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (TroopChatPie.c(this.a).a() == 14)) {
      TroopChatPie.d(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxw
 * JD-Core Version:    0.7.0.1
 */