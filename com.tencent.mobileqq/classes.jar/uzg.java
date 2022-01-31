import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPhotographyGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPhotographyGuide;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class uzg
  extends syv
{
  public static final String a = sxp.a("StorySvc.get_photography_guide");
  
  public String a()
  {
    return a;
  }
  
  public syq a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPhotographyGuide localRspGetPhotographyGuide = new qqstory_service.RspGetPhotographyGuide();
    try
    {
      localRspGetPhotographyGuide.mergeFrom(paramArrayOfByte);
      return new uzh(localRspGetPhotographyGuide);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      veg.d("Q.qqstory:GetPhotographyGuideRequest", "" + paramArrayOfByte);
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
 * Qualified Name:     uzg
 * JD-Core Version:    0.7.0.1
 */