import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserSelfInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserSelfInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class uzl
  extends sys<uzm>
{
  public static final String a = sxm.a("StorySvc.get_user_base_info");
  
  public String a()
  {
    return a;
  }
  
  public uzm a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetUserSelfInfo localRspGetUserSelfInfo = new qqstory_service.RspGetUserSelfInfo();
    try
    {
      localRspGetUserSelfInfo.mergeFrom(paramArrayOfByte);
      return new uzm(localRspGetUserSelfInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        ved.c("Q.qqstory.home.GetUserSelfInfoStep", "decodeResponse error=%s", paramArrayOfByte);
      }
    }
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetUserSelfInfo().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzl
 * JD-Core Version:    0.7.0.1
 */