import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserSelfInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserSelfInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class yps
  extends wpa<ypt>
{
  public static final String a = wnu.a("StorySvc.get_user_base_info");
  
  public String a()
  {
    return a;
  }
  
  public ypt a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetUserSelfInfo localRspGetUserSelfInfo = new qqstory_service.RspGetUserSelfInfo();
    try
    {
      localRspGetUserSelfInfo.mergeFrom(paramArrayOfByte);
      return new ypt(localRspGetUserSelfInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        yuk.c("Q.qqstory.home.GetUserSelfInfoStep", "decodeResponse error=%s", paramArrayOfByte);
      }
    }
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetUserSelfInfo().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yps
 * JD-Core Version:    0.7.0.1
 */