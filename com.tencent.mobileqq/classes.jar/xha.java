import Wallet.GetGroupRedPackListRsp;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetAvailableListListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import java.lang.ref.SoftReference;
import java.util.HashMap;

class xha
  implements Runnable
{
  xha(xgz paramxgz, GetGroupRedPackListRsp paramGetGroupRedPackListRsp) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Xgz.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager.b != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Xgz.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager.b.get(this.jdField_a_of_type_Xgz.b + "_" + this.jdField_a_of_type_Xgz.jdField_a_of_type_Int) != null) {
        localObject1 = (IRedPacket.OnGetAvailableListListener)((SoftReference)this.jdField_a_of_type_Xgz.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager.b.get(this.jdField_a_of_type_Xgz.b + "_" + this.jdField_a_of_type_Xgz.jdField_a_of_type_Int)).get();
      }
    }
    if (localObject1 == null) {
      return;
    }
    this.jdField_a_of_type_Xgz.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager.a(this.jdField_a_of_type_Xgz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xgz.b, this.jdField_a_of_type_Xgz.jdField_a_of_type_Int, (IRedPacket.OnGetAvailableListListener)localObject1, this.jdField_a_of_type_WalletGetGroupRedPackListRsp, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xha
 * JD-Core Version:    0.7.0.1
 */