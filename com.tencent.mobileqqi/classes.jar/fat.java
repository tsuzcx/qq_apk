import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class fat
  implements Runnable
{
  public fat(DataLineHandler paramDataLineHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.handleRecvFileReply(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, this.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fat
 * JD-Core Version:    0.7.0.1
 */