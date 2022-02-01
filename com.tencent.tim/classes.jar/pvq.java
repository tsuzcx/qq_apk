import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqQQStoryGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspQQStoryGuide;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pvq
  extends ppw
{
  public static String CMD = ppf.fQ("StorySvc.new_user_guide");
  public String toUid;
  public String version;
  
  public pvq(String paramString1, String paramString2)
  {
    this.toUid = paramString1;
    this.version = paramString2;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspQQStoryGuide localRspQQStoryGuide = new qqstory_service.RspQQStoryGuide();
    try
    {
      localRspQQStoryGuide.mergeFrom(paramArrayOfByte);
      return new pvq.a(localRspQQStoryGuide);
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
    qqstory_service.ReqQQStoryGuide localReqQQStoryGuide = new qqstory_service.ReqQQStoryGuide();
    try
    {
      localReqQQStoryGuide.to_uid.set(Long.valueOf(this.toUid).longValue());
      localReqQQStoryGuide.version.set(this.version);
      return localReqQQStoryGuide.toByteArray();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localReqQQStoryGuide.to_uid.set(0L);
      }
    }
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "QQStoryGuideRequest{toUid='" + this.toUid + '\'' + "version='" + this.version + '\'' + '}';
  }
  
  public static class a
    extends ppu
  {
    public a(qqstory_service.RspQQStoryGuide paramRspQQStoryGuide)
    {
      super();
    }
    
    public String toString()
    {
      return "QQStoryGuideResponse{}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvq
 * JD-Core Version:    0.7.0.1
 */