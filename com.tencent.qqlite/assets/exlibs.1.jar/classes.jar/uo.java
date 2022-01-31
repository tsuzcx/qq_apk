import com.tencent.litetransfersdk.LiteTransferWrapper;

public class uo
  implements Runnable
{
  public uo(LiteTransferWrapper paramLiteTransferWrapper, boolean paramBoolean) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$300(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.destryOperator(LiteTransferWrapper.access$300(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_Boolean);
      LiteTransferWrapper.access$302(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper, 0L);
    }
    LiteTransferWrapper.access$402(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper, null);
    LiteTransferWrapper.access$602(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper, null);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.releaseGlobalFuncCallback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     uo
 * JD-Core Version:    0.7.0.1
 */