import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPhotographyGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPhotographyGuide;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class uzd
  extends sys
{
  public static final String a = sxm.a("StorySvc.get_photography_guide");
  
  public String a()
  {
    return a;
  }
  
  public syn a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPhotographyGuide localRspGetPhotographyGuide = new qqstory_service.RspGetPhotographyGuide();
    try
    {
      localRspGetPhotographyGuide.mergeFrom(paramArrayOfByte);
      return new uze(localRspGetPhotographyGuide);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ved.d("Q.qqstory:GetPhotographyGuideRequest", "" + paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzd
 * JD-Core Version:    0.7.0.1
 */