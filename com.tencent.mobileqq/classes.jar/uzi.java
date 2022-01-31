import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserGuide;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class uzi
  extends sys<uzj>
{
  public static final String a = sxm.a("StorySvc.get_user_guide");
  
  public String a()
  {
    return a;
  }
  
  public uzj a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetUserGuide localRspGetUserGuide = new qqstory_service.RspGetUserGuide();
    try
    {
      localRspGetUserGuide.mergeFrom(paramArrayOfByte);
      return new uzj(localRspGetUserGuide);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        ved.c("Q.qqstory.home.GetUserGuideInfoStep", "decodeResponse error=%s", paramArrayOfByte);
      }
    }
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetUserGuide().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzi
 * JD-Core Version:    0.7.0.1
 */