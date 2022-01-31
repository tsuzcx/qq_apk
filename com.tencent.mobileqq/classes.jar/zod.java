import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troop.data.TroopAioKeywordHelper;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;

public class zod
  implements Runnable
{
  public zod(TroopHandler paramTroopHandler, oidb_0x496.AioKeyword paramAioKeyword) {}
  
  public void run()
  {
    ((TroopAioKeywordTipManager)this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b.getManager(224)).a(TroopAioKeywordHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$AioKeyword), TroopAioKeywordHelper.b(this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$AioKeyword));
    TroopAioKeywordHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b, this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$AioKeyword);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zod
 * JD-Core Version:    0.7.0.1
 */