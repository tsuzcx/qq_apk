import com.tencent.litetransfersdk.LiteTransferListenerCallback;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.DataLineHandler;

public class bwn
  implements Runnable
{
  public bwn(LiteTransferListenerCallback paramLiteTransferListenerCallback, long paramLong) {}
  
  public void run()
  {
    Session localSession = LiteTransferListenerCallback.access$100(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferListenerCallback).a(this.jdField_a_of_type_Long);
    LiteTransferListenerCallback.access$000(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferListenerCallback, localSession, null, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bwn
 * JD-Core Version:    0.7.0.1
 */