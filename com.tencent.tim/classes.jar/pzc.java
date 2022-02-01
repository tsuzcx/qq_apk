import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGroupDateVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGroupDateVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pzc
  extends ppw
{
  private final String CMD = ppf.fQ("StoryGroupSvc.datacard_get_feeds_new");
  public int aaK;
  public String avV = "";
  public int blp;
  public int blv;
  public int dateType;
  public String groupId;
  public long seq;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGroupDateVideoList localRspGroupDateVideoList = new qqstory_service.RspGroupDateVideoList();
    try
    {
      localRspGroupDateVideoList.mergeFrom(paramArrayOfByte);
      return new qal(this.groupId, localRspGroupDateVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory.shareGroup:GetShareGroupDateListRequest", mg(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqGroupDateVideoList localReqGroupDateVideoList = new qqstory_service.ReqGroupDateVideoList();
    localReqGroupDateVideoList.from.set(this.dateType);
    localReqGroupDateVideoList.group_unionid.set(ByteStringMicro.copyFromUtf8(this.groupId));
    localReqGroupDateVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.avV));
    localReqGroupDateVideoList.date_count.set(this.aaK);
    localReqGroupDateVideoList.video_count.set(this.blv);
    localReqGroupDateVideoList.seqno.set(this.seq);
    if (this.blp != -1) {
      localReqGroupDateVideoList.time_zone.set(this.blp);
    }
    return localReqGroupDateVideoList.toByteArray();
  }
  
  public String mg()
  {
    return this.CMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzc
 * JD-Core Version:    0.7.0.1
 */