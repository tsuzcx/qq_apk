import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardSetReq;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public final class esi
  implements Runnable
{
  public esi(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject = new SSummaryCardSetReq(2, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 0L, "3.3.0", 109L, this.jdField_a_of_type_Long, this.b);
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setFuncName("set");
    localUniPacket.setServantName("MCardSvc");
    localUniPacket.put("req", localObject);
    localObject = localUniPacket.encode();
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), (byte)0, null, null, null, null, (byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     esi
 * JD-Core Version:    0.7.0.1
 */