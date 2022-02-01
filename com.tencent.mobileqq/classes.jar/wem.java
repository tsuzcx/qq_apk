import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class wem
  extends vqr<wgg>
{
  private static final String a = vpl.a("StorySvc.video_music_get");
  
  public String a()
  {
    return a;
  }
  
  public wgg a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetMusicListConfig localRspGetMusicListConfig = new qqstory_service.RspGetMusicListConfig();
    try
    {
      localRspGetMusicListConfig.mergeFrom(paramArrayOfByte);
      return new wgg(localRspGetMusicListConfig);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wem
 * JD-Core Version:    0.7.0.1
 */