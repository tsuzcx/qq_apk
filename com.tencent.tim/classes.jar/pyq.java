import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDateCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDateVideoCollectionList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pyq
  extends ppw
{
  public String avV = "";
  public int blp;
  public int blq;
  public int blr;
  public boolean isFriend;
  public long seq;
  public String uin;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDateVideoCollectionList localRspDateVideoCollectionList = new qqstory_service.RspDateVideoCollectionList();
    try
    {
      localRspDateVideoCollectionList.mergeFrom(paramArrayOfByte);
      return new qad(this.uin, localRspDateVideoCollectionList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory.memories:GetDateCollectionListRequest", mg(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqDateCollectionList localReqDateCollectionList = new qqstory_service.ReqDateCollectionList();
    localReqDateCollectionList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.avV));
    localReqDateCollectionList.collection_count.set(this.blq);
    localReqDateCollectionList.collection_video_count.set(this.blr);
    localReqDateCollectionList.seqno.set(this.seq);
    PBInt32Field localPBInt32Field = localReqDateCollectionList.is_friend;
    if (this.isFriend) {}
    for (int i = 1;; i = 0)
    {
      localPBInt32Field.set(i);
      if (this.blp != -1) {
        localReqDateCollectionList.time_zone.set(this.blp);
      }
      localReqDateCollectionList.union_id.set(ByteStringMicro.copyFromUtf8(this.uin));
      return localReqDateCollectionList.toByteArray();
    }
  }
  
  public String mg()
  {
    if (QQStoryContext.a().eU(this.uin)) {
      return ppf.fQ("StorySvc.get_date_collection_list");
    }
    return ppf.fQ("StorySvc.get_others_video_list");
  }
  
  public String toString()
  {
    return "GetDateCollectionListRequest{startCookie='" + this.avV + '\'' + ", collectionPageSize=" + this.blq + ", collectionVideoCount=" + this.blr + ", seq=" + this.seq + ", timeZoneOffset=" + this.blp + ", uin=" + this.uin + ", isFriend=" + this.isFriend + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyq
 * JD-Core Version:    0.7.0.1
 */