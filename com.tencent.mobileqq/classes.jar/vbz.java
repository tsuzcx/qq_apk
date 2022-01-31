import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetFeedVisitor;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFeedVisitor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class vbz
  extends unk
{
  public static final String a = ume.a("StorySvc.feed_visitor_list");
  public String b;
  
  public String a()
  {
    return a;
  }
  
  public unf a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetFeedVisitor localRspGetFeedVisitor = new qqstory_service.RspGetFeedVisitor();
    try
    {
      localRspGetFeedVisitor.mergeFrom(paramArrayOfByte);
      return new vdk(this.b, localRspGetFeedVisitor);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wsv.d("Q.qqstory:GetVideoWatcherListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetFeedVisitor localReqGetFeedVisitor = new qqstory_service.ReqGetFeedVisitor();
    localReqGetFeedVisitor.feed_id.set(ByteStringMicro.copyFromUtf8(this.b));
    return localReqGetFeedVisitor.toByteArray();
  }
  
  public String toString()
  {
    return "GetVideoWatcherListRequest{, feedId='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbz
 * JD-Core Version:    0.7.0.1
 */