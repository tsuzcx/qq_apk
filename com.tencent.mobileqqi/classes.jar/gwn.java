import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import java.util.Map;

class gwn
  implements Runnable
{
  gwn(gwm paramgwm) {}
  
  public void run()
  {
    if (TroopMessageManager.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager).b.containsKey(MsgProxyUtils.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int))) {
      TroopMessageManager.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager).b.remove(MsgProxyUtils.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gwn
 * JD-Core Version:    0.7.0.1
 */