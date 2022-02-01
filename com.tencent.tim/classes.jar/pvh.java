import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeWatched;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pvh
  extends ppw<pvh.a>
{
  static final String CMD = ppf.fQ("StorySvc.msgtab_node_watched");
  public int nodeType;
  public int operation;
  public long recommendId;
  public String unionId;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeWatched localRspMsgTabNodeWatched = new qqstory_service.RspMsgTabNodeWatched();
    try
    {
      localRspMsgTabNodeWatched.mergeFrom(paramArrayOfByte);
      return new pvh.a(localRspMsgTabNodeWatched);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory.msgTab:ReqMsgTabNodeWatched", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqMsgTabNodeWatched localReqMsgTabNodeWatched = new qqstory_service.ReqMsgTabNodeWatched();
    localReqMsgTabNodeWatched.unionID.set(ByteStringMicro.copyFromUtf8(this.unionId));
    localReqMsgTabNodeWatched.node_type.set(this.nodeType);
    localReqMsgTabNodeWatched.operation.set(this.operation);
    localReqMsgTabNodeWatched.recommend_id.set(this.recommendId);
    return localReqMsgTabNodeWatched.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public static class a
    extends ppu
  {
    public a(qqstory_service.RspMsgTabNodeWatched paramRspMsgTabNodeWatched)
    {
      super();
    }
    
    public String toString()
    {
      return "MsgTabNodeWatchedResponse{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvh
 * JD-Core Version:    0.7.0.1
 */