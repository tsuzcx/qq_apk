import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;

public class bwz
  implements Runnable
{
  public bwz(LiteTransferWrapper paramLiteTransferWrapper, MsgCSBody paramMsgCSBody) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetProxyToJni();
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.PbMsgReciveToJNI(LiteTransferWrapper.access$300(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_ComTencentLitetransfersdkMsgCSBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bwz
 * JD-Core Version:    0.7.0.1
 */