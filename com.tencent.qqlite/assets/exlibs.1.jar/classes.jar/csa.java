import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class csa
  implements Runnable
{
  public csa(DataLineHandler paramDataLineHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.handleMsgBody0x346(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     csa
 * JD-Core Version:    0.7.0.1
 */