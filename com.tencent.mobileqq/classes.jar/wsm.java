import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserSelfInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserSelfInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class wsm
  extends urt<wsn>
{
  public static final String a = uqn.a("StorySvc.get_user_base_info");
  
  public String a()
  {
    return a;
  }
  
  public wsn a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetUserSelfInfo localRspGetUserSelfInfo = new qqstory_service.RspGetUserSelfInfo();
    try
    {
      localRspGetUserSelfInfo.mergeFrom(paramArrayOfByte);
      return new wsn(localRspGetUserSelfInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        wxe.c("Q.qqstory.home.GetUserSelfInfoStep", "decodeResponse error=%s", paramArrayOfByte);
      }
    }
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetUserSelfInfo().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wsm
 * JD-Core Version:    0.7.0.1
 */