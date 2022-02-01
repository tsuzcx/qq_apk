import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqProfileYearNodeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileYearNodeList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class xda
  extends wpa
{
  public String a;
  
  public String a()
  {
    return wnu.a("StorySvc.get_profile_year_node_info");
  }
  
  public wov a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspProfileYearNodeList localRspProfileYearNodeList = new qqstory_service.RspProfileYearNodeList();
    try
    {
      localRspProfileYearNodeList.mergeFrom(paramArrayOfByte);
      return new xdb(localRspProfileYearNodeList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqProfileYearNodeList localReqProfileYearNodeList = new qqstory_service.ReqProfileYearNodeList();
    localReqProfileYearNodeList.union_id.set(ByteStringMicro.copyFromUtf8(this.a));
    return localReqProfileYearNodeList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xda
 * JD-Core Version:    0.7.0.1
 */