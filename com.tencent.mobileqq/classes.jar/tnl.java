import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class tnl
  extends sys<tow>
{
  public String a()
  {
    return sxm.a("StorySvc.video_apply_authkey");
  }
  
  public tow a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspAuthKey localRspAuthKey = new qqstory_service.RspAuthKey();
    try
    {
      localRspAuthKey.mergeFrom(paramArrayOfByte);
      return new tow(localRspAuthKey);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ved.d("Q.qqstory:RefreshVideoFileKeyRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tnl
 * JD-Core Version:    0.7.0.1
 */