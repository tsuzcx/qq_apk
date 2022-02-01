import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDeleteVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDeleteVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.List;

public class pyn
  extends ppw<qaa>
{
  private static final String CMD = ppf.fQ("StorySvc.video_show_delete");
  public String vid;
  
  public pyn(String paramString)
  {
    this.vid = paramString;
  }
  
  public qaa a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDeleteVideo localRspDeleteVideo = new qqstory_service.RspDeleteVideo();
    try
    {
      localRspDeleteVideo.mergeFrom(paramArrayOfByte);
      return new qaa(localRspDeleteVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqDeleteVideo localReqDeleteVideo = new qqstory_service.ReqDeleteVideo();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ByteStringMicro.copyFromUtf8(this.vid));
    localReqDeleteVideo.vid_list.addAll(localArrayList);
    return localReqDeleteVideo.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "DeleteVideoRequest{vid='" + this.vid + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyn
 * JD-Core Version:    0.7.0.1
 */