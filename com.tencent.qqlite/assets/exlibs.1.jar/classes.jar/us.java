import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.Session;

public class us
  implements Runnable
{
  public us(LiteTransferWrapper paramLiteTransferWrapper, Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetProxyToJni();
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.RecvGroupToJNI(LiteTransferWrapper.access$300(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkSession, this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkNFCInfo, this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkFTNInfo, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     us
 * JD-Core Version:    0.7.0.1
 */