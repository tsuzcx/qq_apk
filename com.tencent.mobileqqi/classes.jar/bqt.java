import com.tencent.litetransfersdk.FileControl;
import com.tencent.litetransfersdk.LiteTransferOperatorCallback;
import com.tencent.mobileqq.app.DataLineHandler;
import java.util.TimerTask;

public class bqt
  extends TimerTask
{
  public bqt(LiteTransferOperatorCallback paramLiteTransferOperatorCallback, int paramInt, FileControl paramFileControl) {}
  
  public void run()
  {
    LiteTransferOperatorCallback.access$000(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferOperatorCallback).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentLitetransfersdkFileControl.uint64_sessionid, 1005, this.jdField_a_of_type_ComTencentLitetransfersdkFileControl.uint32_operate, this.jdField_a_of_type_ComTencentLitetransfersdkFileControl.uint32_seq, this.jdField_a_of_type_ComTencentLitetransfersdkFileControl.uint32_group_id, this.jdField_a_of_type_ComTencentLitetransfersdkFileControl.uint32_batchID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bqt
 * JD-Core Version:    0.7.0.1
 */