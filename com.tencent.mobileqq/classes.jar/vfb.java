import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDeleteVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDeleteVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.List;

public class vfb
  extends urt<vgz>
{
  private static final String b = uqn.a("StorySvc.video_show_delete");
  public String a;
  
  public vfb(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return b;
  }
  
  public vgz a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDeleteVideo localRspDeleteVideo = new qqstory_service.RspDeleteVideo();
    try
    {
      localRspDeleteVideo.mergeFrom(paramArrayOfByte);
      return new vgz(localRspDeleteVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqDeleteVideo localReqDeleteVideo = new qqstory_service.ReqDeleteVideo();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ByteStringMicro.copyFromUtf8(this.a));
    localReqDeleteVideo.vid_list.addAll(localArrayList);
    return localReqDeleteVideo.toByteArray();
  }
  
  public String toString()
  {
    return "DeleteVideoRequest{vid='" + this.a + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfb
 * JD-Core Version:    0.7.0.1
 */