import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class vgu
  extends vgx
{
  public qqstory_service.RspGetPromoteTaskList a;
  
  public vgu(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetPromoteTaskList = new qqstory_service.RspGetPromoteTaskList();
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetPromoteTaskList.mergeFrom(paramArrayOfByte);
      this.b = this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetPromoteTaskList.result.error_desc.get().toStringUtf8();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetPromoteTaskList.result.error_code.get();
      wxe.a("GetPromoteTaskResponse", "GetPromoteTaskResponse(): %s", xrq.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetPromoteTaskList));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wxe.c("GetPromoteTaskResponse", "Error GetPromoteTaskResponse()", paramArrayOfByte);
    }
  }
  
  public String toString()
  {
    return xrq.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetPromoteTaskList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgu
 * JD-Core Version:    0.7.0.1
 */