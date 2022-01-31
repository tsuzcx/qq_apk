import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class vfp
  extends urt<vhj>
{
  private static final String a = uqn.a("StorySvc.video_music_get");
  
  public String a()
  {
    return a;
  }
  
  public vhj a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetMusicListConfig localRspGetMusicListConfig = new qqstory_service.RspGetMusicListConfig();
    try
    {
      localRspGetMusicListConfig.mergeFrom(paramArrayOfByte);
      return new vhj(localRspGetMusicListConfig);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetMusicListConfig().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfp
 * JD-Core Version:    0.7.0.1
 */