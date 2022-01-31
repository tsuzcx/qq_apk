import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class vbg
  extends unk<vda>
{
  private static final String a = ume.a("StorySvc.video_music_get");
  
  public String a()
  {
    return a;
  }
  
  public vda a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetMusicListConfig localRspGetMusicListConfig = new qqstory_service.RspGetMusicListConfig();
    try
    {
      localRspGetMusicListConfig.mergeFrom(paramArrayOfByte);
      return new vda(localRspGetMusicListConfig);
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
 * Qualified Name:     vbg
 * JD-Core Version:    0.7.0.1
 */