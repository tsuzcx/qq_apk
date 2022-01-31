import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;

public class vfy
  extends urt<vho>
{
  private final String a;
  public List<String> a;
  
  public vfy()
  {
    this.jdField_a_of_type_JavaLangString = uqn.a("StoryGroupSvc.datacard_batch_get_video_info");
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchGetVideoInfo localRspBatchGetVideoInfo = new qqstory_service.RspBatchGetVideoInfo();
    try
    {
      localRspBatchGetVideoInfo.mergeFrom(paramArrayOfByte);
      return new vho(localRspBatchGetVideoInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wxe.b("Q.qqstory.shareGroup:GetShareGroupVideoInfoRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqBatchGetVideoInfo localReqBatchGetVideoInfo = new qqstory_service.ReqBatchGetVideoInfo();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqBatchGetVideoInfo.story_id_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    return localReqBatchGetVideoInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfy
 * JD-Core Version:    0.7.0.1
 */