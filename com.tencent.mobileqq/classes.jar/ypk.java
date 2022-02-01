import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPhotographyGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPhotographyGuide;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class ypk
  extends wpa
{
  public static final String a = wnu.a("StorySvc.get_photography_guide");
  
  public String a()
  {
    return a;
  }
  
  public wov a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPhotographyGuide localRspGetPhotographyGuide = new qqstory_service.RspGetPhotographyGuide();
    try
    {
      localRspGetPhotographyGuide.mergeFrom(paramArrayOfByte);
      return new ypl(localRspGetPhotographyGuide);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      yuk.d("Q.qqstory:GetPhotographyGuideRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetPhotographyGuide().toByteArray();
  }
  
  public String toString()
  {
    return "GetPhotographyGuideRequest{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypk
 * JD-Core Version:    0.7.0.1
 */