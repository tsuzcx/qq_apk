import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqForbidVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspForbidVideo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;

public class wrr
  extends wfm<wrs>
{
  public final String a;
  public String b = "";
  
  public wrr(wrq paramwrq, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = weg.a("StorySvc.forbid_video");
    this.b = paramString;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public wrs a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspForbidVideo localRspForbidVideo = new qqstory_service.RspForbidVideo();
    try
    {
      localRspForbidVideo.mergeFrom(paramArrayOfByte);
      return new wrs(this.jdField_a_of_type_Wrq, localRspForbidVideo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrr
 * JD-Core Version:    0.7.0.1
 */