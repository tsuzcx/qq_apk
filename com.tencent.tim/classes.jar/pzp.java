import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgListHeadNode;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgListHeadNode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class pzp
  extends ppw<qaw>
{
  private static final String CMD = ppf.fQ("StoryLrSvc.msglist_head_node");
  private String awn;
  private int blz;
  private List<Long> mUins;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgListHeadNode localRspMsgListHeadNode = new qqstory_service.RspMsgListHeadNode();
    try
    {
      localRspMsgListHeadNode.mergeFrom(paramArrayOfByte);
      return new qaw(localRspMsgListHeadNode);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RecentTabHaloRequest", 2, "decodeResponse: failed. Message: exception: " + paramArrayOfByte);
        }
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqMsgListHeadNode localReqMsgListHeadNode = new qqstory_service.ReqMsgListHeadNode();
    PBBytesField localPBBytesField = localReqMsgListHeadNode.current_seq;
    if (this.awn != null) {}
    for (String str = this.awn;; str = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localReqMsgListHeadNode.uin_list.set(this.mUins);
      localReqMsgListHeadNode.source.set(this.blz);
      localReqMsgListHeadNode.setHasFlag(true);
      return localReqMsgListHeadNode.toByteArray();
    }
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public int sA()
  {
    return this.blz;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RecentTabHaloRequest{");
    localStringBuilder.append("mCurrentSeq='").append(this.awn).append('\'');
    localStringBuilder.append(", mUins=").append(this.mUins);
    localStringBuilder.append(", mWhen=").append(this.blz);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzp
 * JD-Core Version:    0.7.0.1
 */