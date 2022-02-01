import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class pyy
  extends ppw<qaj>
{
  private static final String CMD = ppf.fQ("StorySvc.video_music_get");
  
  public qaj a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetMusicListConfig localRspGetMusicListConfig = new qqstory_service.RspGetMusicListConfig();
    try
    {
      localRspGetMusicListConfig.mergeFrom(paramArrayOfByte);
      return new qaj(localRspGetMusicListConfig);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] encode()
  {
    return new qqstory_service.ReqGetMusicListConfig().toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyy
 * JD-Core Version:    0.7.0.1
 */