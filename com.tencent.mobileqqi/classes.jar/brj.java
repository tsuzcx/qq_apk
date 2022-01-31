import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.Session;
import java.util.ArrayList;

public class brj
  implements Runnable
{
  public brj(LiteTransferWrapper paramLiteTransferWrapper, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetProxyToJni();
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SendGroupToJNI(LiteTransferWrapper.access$300(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), (Session[])this.jdField_a_of_type_JavaUtilArrayList.toArray(new Session[this.jdField_a_of_type_JavaUtilArrayList.size()]), this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     brj
 * JD-Core Version:    0.7.0.1
 */