import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.gameparty.GamePartyObserver;

public class vsl
  extends GamePartyObserver
{
  public vsl(DiscussChatPie paramDiscussChatPie) {}
  
  protected void a()
  {
    if (((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      DiscussChatPie.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar, new Object[0]);
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
    if ((((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (DiscussChatPie.b(this.a).a() == 14)) {
      DiscussChatPie.c(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsl
 * JD-Core Version:    0.7.0.1
 */