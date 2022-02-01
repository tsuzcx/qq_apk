import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBannerVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBannerVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class pyr
  extends ppw<qae>
{
  public static final String CMD = ppf.fQ("StorySvc.square_720_banner_vid_list");
  public String avV;
  public String bannerId;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBannerVideoList localRspBannerVideoList = new qqstory_service.RspBannerVideoList();
    try
    {
      localRspBannerVideoList.mergeFrom(paramArrayOfByte);
      return new qae(localRspBannerVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqBannerVideoList localReqBannerVideoList = new qqstory_service.ReqBannerVideoList();
    localReqBannerVideoList.banner_id.set(ByteStringMicro.copyFromUtf8(this.bannerId));
    localReqBannerVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.avV));
    return localReqBannerVideoList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyr
 * JD-Core Version:    0.7.0.1
 */