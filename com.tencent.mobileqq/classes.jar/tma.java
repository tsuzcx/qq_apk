import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDeleteVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDeleteVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.List;

public class tma
  extends sys<tny>
{
  private static final String b = sxm.a("StorySvc.video_show_delete");
  public String a;
  
  public tma(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return b;
  }
  
  public tny a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDeleteVideo localRspDeleteVideo = new qqstory_service.RspDeleteVideo();
    try
    {
      localRspDeleteVideo.mergeFrom(paramArrayOfByte);
      return new tny(localRspDeleteVideo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tma
 * JD-Core Version:    0.7.0.1
 */