import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserGuide;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class yfv
  extends wfm<yfw>
{
  public static final String a = weg.a("StorySvc.get_user_guide");
  
  public String a()
  {
    return a;
  }
  
  public yfw a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetUserGuide localRspGetUserGuide = new qqstory_service.RspGetUserGuide();
    try
    {
      localRspGetUserGuide.mergeFrom(paramArrayOfByte);
      return new yfw(localRspGetUserGuide);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        ykq.c("Q.qqstory.home.GetUserGuideInfoStep", "decodeResponse error=%s", paramArrayOfByte);
      }
    }
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetUserGuide().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfv
 * JD-Core Version:    0.7.0.1
 */