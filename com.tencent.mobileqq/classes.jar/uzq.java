import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqForbidVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspForbidVideo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;

public class uzq
  extends unk<uzr>
{
  public final String a;
  public String b = "";
  
  public uzq(uzp paramuzp, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = ume.a("StorySvc.forbid_video");
    this.b = paramString;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public uzr a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspForbidVideo localRspForbidVideo = new qqstory_service.RspForbidVideo();
    try
    {
      localRspForbidVideo.mergeFrom(paramArrayOfByte);
      return new uzr(this.jdField_a_of_type_Uzp, localRspForbidVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqForbidVideo localReqForbidVideo = new qqstory_service.ReqForbidVideo();
    localReqForbidVideo.vid.set(this.b);
    return localReqForbidVideo.toByteArray();
  }
  
  public String toString()
  {
    return "ReportIgnoreVideoRequest{, vid='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzq
 * JD-Core Version:    0.7.0.1
 */