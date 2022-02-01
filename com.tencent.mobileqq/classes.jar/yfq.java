import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPhotographyGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPhotographyGuide;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class yfq
  extends wfm
{
  public static final String a = weg.a("StorySvc.get_photography_guide");
  
  public String a()
  {
    return a;
  }
  
  public wfh a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPhotographyGuide localRspGetPhotographyGuide = new qqstory_service.RspGetPhotographyGuide();
    try
    {
      localRspGetPhotographyGuide.mergeFrom(paramArrayOfByte);
      return new yfr(localRspGetPhotographyGuide);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ykq.d("Q.qqstory:GetPhotographyGuideRequest", "" + paramArrayOfByte);
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
 * Qualified Name:     yfq
 * JD-Core Version:    0.7.0.1
 */