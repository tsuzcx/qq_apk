import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBannerVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBannerVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class vaw
  extends unk<vcu>
{
  public static final String a = ume.a("StorySvc.square_720_banner_vid_list");
  public String b;
  public String c;
  
  public String a()
  {
    return a;
  }
  
  public unf a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBannerVideoList localRspBannerVideoList = new qqstory_service.RspBannerVideoList();
    try
    {
      localRspBannerVideoList.mergeFrom(paramArrayOfByte);
      return new vcu(localRspBannerVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqBannerVideoList localReqBannerVideoList = new qqstory_service.ReqBannerVideoList();
    localReqBannerVideoList.banner_id.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqBannerVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.c));
    return localReqBannerVideoList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vaw
 * JD-Core Version:    0.7.0.1
 */