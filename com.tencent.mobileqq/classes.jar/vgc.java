import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryPlayerTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryPlayerTagInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;

public class vgc
  extends urt<vhq>
{
  public final List<String> a;
  
  public vgc(List<String> paramList)
  {
    this.a = paramList;
  }
  
  public String a()
  {
    return "StorySvc.get_video_tag_778";
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryPlayerTagInfo localRspStoryPlayerTagInfo = new qqstory_service.RspStoryPlayerTagInfo();
    try
    {
      localRspStoryPlayerTagInfo.mergeFrom(paramArrayOfByte);
      return new vhq(localRspStoryPlayerTagInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        wxe.e("Q.qqstory.net:GetStoryPlayerTagInfoRequest", paramArrayOfByte.toString());
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqStoryPlayerTagInfo localReqStoryPlayerTagInfo = new qqstory_service.ReqStoryPlayerTagInfo();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqStoryPlayerTagInfo.vid_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    localReqStoryPlayerTagInfo.client.set(2);
    localReqStoryPlayerTagInfo.version.set(ByteStringMicro.copyFromUtf8("8.3.5"));
    return localReqStoryPlayerTagInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgc
 * JD-Core Version:    0.7.0.1
 */