import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgPayManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgPayManager.PayItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class xbt
  implements Runnable
{
  public xbt(GoldMsgPayManager paramGoldMsgPayManager, GoldMsgPayManager.PayItem paramPayItem) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager$PayItem.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager$PayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbt
 * JD-Core Version:    0.7.0.1
 */