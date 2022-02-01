import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class wue
  extends wfm<wvp>
{
  public String a()
  {
    return weg.a("StorySvc.video_apply_authkey");
  }
  
  public wvp a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspAuthKey localRspAuthKey = new qqstory_service.RspAuthKey();
    try
    {
      localRspAuthKey.mergeFrom(paramArrayOfByte);
      return new wvp(localRspAuthKey);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ykq.d("Q.qqstory:RefreshVideoFileKeyRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wue
 * JD-Core Version:    0.7.0.1
 */