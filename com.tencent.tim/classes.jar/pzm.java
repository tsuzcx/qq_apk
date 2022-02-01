import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetFeedVisitor;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFeedVisitor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class pzm
  extends ppw
{
  public static final String CMD = ppf.fQ("StorySvc.feed_visitor_list");
  public String feedId;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetFeedVisitor localRspGetFeedVisitor = new qqstory_service.RspGetFeedVisitor();
    try
    {
      localRspGetFeedVisitor.mergeFrom(paramArrayOfByte);
      return new qat(this.feedId, localRspGetFeedVisitor);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory:GetVideoWatcherListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqGetFeedVisitor localReqGetFeedVisitor = new qqstory_service.ReqGetFeedVisitor();
    localReqGetFeedVisitor.feed_id.set(ByteStringMicro.copyFromUtf8(this.feedId));
    return localReqGetFeedVisitor.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "GetVideoWatcherListRequest{, feedId='" + this.feedId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzm
 * JD-Core Version:    0.7.0.1
 */