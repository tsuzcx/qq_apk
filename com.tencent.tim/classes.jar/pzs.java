import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTranslateToken;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspTranslateToken;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class pzs
  extends ppw
{
  public static final String CMD = ppf.fQ("StorySvc.translate_share_parameters_to_token");
  public String awo;
  public String feedId;
  public int type;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspTranslateToken localRspTranslateToken = new qqstory_service.RspTranslateToken();
    try
    {
      localRspTranslateToken.mergeFrom(paramArrayOfByte);
      return new pzs.a(localRspTranslateToken);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share.trans.req", 2, "decode failed", paramArrayOfByte);
        }
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqTranslateToken localReqTranslateToken = new qqstory_service.ReqTranslateToken();
    localReqTranslateToken.src_buffer.set(ByteStringMicro.copyFromUtf8(this.awo));
    localReqTranslateToken.type.set(this.type);
    if ((this.type == 1) && (this.feedId != null)) {
      localReqTranslateToken.feed_id.set(ByteStringMicro.copyFromUtf8(this.feedId));
    }
    return localReqTranslateToken.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "StoryShareTranslateTokenRequest{feedId='" + this.feedId + '\'' + ", srcBuffer='" + this.awo + '\'' + ", type=" + this.type + '}';
  }
  
  public static class a
    extends ppu
  {
    public long AD;
    public String awp;
    public String coverUrl;
    
    public a(qqstory_service.RspTranslateToken paramRspTranslateToken) {}
    
    public String toString()
    {
      return "StoryShareTranslateTokenResponse{coverUrl='" + this.coverUrl + '\'' + ", dstBuffer='" + this.awp + '\'' + ", shootTimeMillis=" + this.AD + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzs
 * JD-Core Version:    0.7.0.1
 */