import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.LiteTransferListenerCallback;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.Session;

public class bwm
  implements Runnable
{
  public bwm(LiteTransferListenerCallback paramLiteTransferListenerCallback, Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo) {}
  
  public void run()
  {
    LiteTransferListenerCallback.access$000(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferListenerCallback, this.jdField_a_of_type_ComTencentLitetransfersdkSession, this.jdField_a_of_type_ComTencentLitetransfersdkNFCInfo, this.jdField_a_of_type_ComTencentLitetransfersdkFTNInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bwm
 * JD-Core Version:    0.7.0.1
 */