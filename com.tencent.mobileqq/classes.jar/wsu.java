import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBlackList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class wsu
  extends wfm<wus>
{
  public static final String a = weg.a("StorySvc.get_user_black_status");
  public String b;
  
  public String a()
  {
    return a;
  }
  
  public wfh a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetBlackList localRspGetBlackList = new qqstory_service.RspGetBlackList();
    try
    {
      localRspGetBlackList.mergeFrom(paramArrayOfByte);
      return new wus(localRspGetBlackList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetBlackList localReqGetBlackList = new qqstory_service.ReqGetBlackList();
    localReqGetBlackList.union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    return localReqGetBlackList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsu
 * JD-Core Version:    0.7.0.1
 */