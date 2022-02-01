import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class xdt
  extends wpa<xfe>
{
  public String a()
  {
    return wnu.a("StorySvc.video_apply_authkey");
  }
  
  public xfe a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspAuthKey localRspAuthKey = new qqstory_service.RspAuthKey();
    try
    {
      localRspAuthKey.mergeFrom(paramArrayOfByte);
      return new xfe(localRspAuthKey);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      yuk.d("Q.qqstory:RefreshVideoFileKeyRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdt
 * JD-Core Version:    0.7.0.1
 */